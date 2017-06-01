package com.nineinfosys.heatconverter.ConverterActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.heatconverter.ConverterActivityList.ConversionSpecificHeatCapacityListActivity;
import com.nineinfosys.heatconverter.Engin.SpecificHeatCapacityConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SpecificHeatCapacityActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private static final int REQUEST_CODE = 100;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listtempFirstfrom, listFirsttempTo, listtempfrom, listtempTo;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 5;
    private int allunit = 20;
    DecimalFormat formatter = null;


    SpecificHeatCapacityConverter.ConversionResults item;
   private String  strjoulekilogramK=null,strjoulekilogramC=null,strjoulegramC=null,strkilojoulekilogramK=null,strkilojoulekilogramC=null,strcalorieITgramC=null,strcalorieITgramF=null,
            strcaloriethgramC=null,strkilocalorieITkilogramC=null,strkilocaloriethkilogramC=null,strkilocalorieITkilogramK=null,strkilocaloriethkilogramK=null,
            strkilogramforcemeterkilogramK=null,strpoundforcefootpoundR=null,strBtuITpoundF=null,strBtuthpoundF=null,strBtuITpoundR=null,strBtuthpoundR=null,
            strBtuITpoundC=null,strCHUpoundC=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2eaf46")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Specific Heat Capacity");

        formatsetting();
        MobileAds.initialize(SpecificHeatCapacityActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverter);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initalization of tools and variables
        spinnerConvertFrom = (Spinner) findViewById(R.id.spinnerConvertFrom);
        spinnerConvertTo = (Spinner) findViewById(R.id.spinnerConvertTo);
        textViewBasicUnit = (TextView) findViewById(R.id.textViewBasicUnit);
        textViewAllUnit = (TextView) findViewById(R.id.textViewAllUnit);
        textViewConvert=(TextView) findViewById(R.id.buttonUnitConverter);
        editTextValue = (EditText) findViewById(R.id.edittextFrom);
        editTextValueTo = (EditText) findViewById(R.id.edittextTo);
        buttonCopy = (FloatingActionButton) findViewById(R.id.button_copy);
        buttonList = (FloatingActionButton) findViewById(R.id.button_list_fullreport);
        buttonShare = (FloatingActionButton) findViewById(R.id.button_list_share);
        buttonMail = (FloatingActionButton) findViewById(R.id.button_list_mail);
        switchChangeType = (SwitchCompat) findViewById(R.id.switchButton);

        //changing color dynamically
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007e17"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Joule/kilogram/K -J/(kg*K)");
        listtempFirstfrom.add("Joule/kilogram/°C -J/(kg*°C)");
        listtempFirstfrom.add("Joule/gram/°C -J/(g*°C)");
        listtempFirstfrom.add("Kilojoule/kilogram/K -kJ/(kg*K)");
        listtempFirstfrom.add("Kilojoule/kilogram/°C -kJ/(kg*°C)");

        //for first time running spinner
        listFirsttempTo.add("Joule/kilogram/K -J/(kg*K)");
        listFirsttempTo.add("Joule/kilogram/°C -J/(kg*°C)");
        listFirsttempTo.add("Joule/gram/°C -J/(g*°C)");
        listFirsttempTo.add("Kilojoule/kilogram/K -kJ/(kg*K)");
        listFirsttempTo.add("Kilojoule/kilogram/°C -kJ/(kg*°C)");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(SpecificHeatCapacityActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(SpecificHeatCapacityActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


        // Drop down layout style - list view with radio button
        Adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        AdapterTempTo.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        // attaching data adapter to spinner
        spinnerConvertFrom.setAdapter(Adapter);
        spinnerConvertTo.setAdapter(AdapterTempTo);

        //switch converttype
        switchChangeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                listtempfrom = new ArrayList<String>();
                listtempTo = new ArrayList<String>();
                String stringSwitchSate = String.valueOf(isChecked);
                String strBasic = "Basic";
                String strAdvance = "All";
                switch (stringSwitchSate) {

                    case "false":
                        Snackbar.make(buttonView, "You switched to " + strBasic + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Joule/kilogram/K -J/(kg*K)");
                        listtempfrom.add("Joule/kilogram/°C -J/(kg*°C)");
                        listtempfrom.add("Joule/gram/°C -J/(g*°C)");
                        listtempfrom.add("Kilojoule/kilogram/K -kJ/(kg*K)");
                        listtempfrom.add("Kilojoule/kilogram/°C -kJ/(kg*°C)");


                        //2 spinner
                        listtempTo.add("Joule/kilogram/K -J/(kg*K)");
                        listtempTo.add("Joule/kilogram/°C -J/(kg*°C)");
                        listtempTo.add("Joule/gram/°C -J/(g*°C)");
                        listtempTo.add("Kilojoule/kilogram/K -kJ/(kg*K)");
                        listtempTo.add("Kilojoule/kilogram/°C -kJ/(kg*°C)");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Joule/kilogram/K -J/(kg*K)");
                        listtempfrom.add("Joule/kilogram/°C -J/(kg*°C)");
                        listtempfrom.add("Joule/gram/°C -J/(g*°C)");
                        listtempfrom.add("Kilojoule/kilogram/K -kJ/(kg*K)");
                        listtempfrom.add("Kilojoule/kilogram/°C -kJ/(kg*°C)");
                        listtempfrom.add("Calorie (IT)/gram/°C -cal(IT)/(g*°C)");
                        listtempfrom.add("Calorie (IT)/gram/°F -cal(IT)/(g*°F)");
                        listtempfrom.add("Calorie (th)/gram/°C -cal(th)/(g*°C)");
                        listtempfrom.add("Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)");
                        listtempfrom.add("Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)");
                        listtempfrom.add("Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)");
                        listtempfrom.add("Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)");
                        listtempfrom.add("Kilogram-force meter/kilogram/K -kgfm/(kg*K)");
                        listtempfrom.add("Pound-force foot/pound/°R -lbfft/(lb*°R)");
                        listtempfrom.add("Btu (IT)/pound/°F -Btu(IT)/(lb*°F)");
                        listtempfrom.add("Btu (th)/pound/°F -Btu(th)/(lb*°F)");
                        listtempfrom.add("Btu (IT)/pound/°R -Btu(IT)/(lb*°R)");
                        listtempfrom.add("Btu (th)/pound/°R -Btu(th)/(lb*°R)");
                        listtempfrom.add("Btu (IT)/pound/°C -Btu(IT)/(lb*°C)");
                        listtempfrom.add("CHU/pound/°C -CHU/(lb*°C)");


                        //second spinner
                        listtempTo.add("Joule/kilogram/K -J/(kg*K)");
                        listtempTo.add("Joule/kilogram/°C -J/(kg*°C)");
                        listtempTo.add("Joule/gram/°C -J/(g*°C)");
                        listtempTo.add("Kilojoule/kilogram/K -kJ/(kg*K)");
                        listtempTo.add("Kilojoule/kilogram/°C -kJ/(kg*°C)");
                        listtempTo.add("Calorie (IT)/gram/°C -cal(IT)/(g*°C)");
                        listtempTo.add("Calorie (IT)/gram/°F -cal(IT)/(g*°F)");
                        listtempTo.add("Calorie (th)/gram/°C -cal(th)/(g*°C)");
                        listtempTo.add("Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)");
                        listtempTo.add("Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)");
                        listtempTo.add("Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)");
                        listtempTo.add("Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)");
                        listtempTo.add("Kilogram-force meter/kilogram/K -kgfm/(kg*K)");
                        listtempTo.add("Pound-force foot/pound/°R -lbfft/(lb*°R)");
                        listtempTo.add("Btu (IT)/pound/°F -Btu(IT)/(lb*°F)");
                        listtempTo.add("Btu (th)/pound/°F -Btu(th)/(lb*°F)");
                        listtempTo.add("Btu (IT)/pound/°R -Btu(IT)/(lb*°R)");
                        listtempTo.add("Btu (th)/pound/°R -Btu(th)/(lb*°R)");
                        listtempTo.add("Btu (IT)/pound/°C -Btu(IT)/(lb*°C)");
                        listtempTo.add("CHU/pound/°C -CHU/(lb*°C)");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(SpecificHeatCapacityActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(SpecificHeatCapacityActivity.this, android.R.layout.simple_spinner_item, listtempTo);


                // Drop down layout style - list view with radio button
                Adapter2.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                AdapterTempTo2.setDropDownViewResource(android.R.layout.simple_list_item_checked);

                // attaching data adapter to spinner
                spinnerConvertFrom.setAdapter(Adapter2);
                spinnerConvertTo.setAdapter(AdapterTempTo2);

            }
        });

        editTextValue.addTextChangedListener(this);
        buttonList.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonMail.setOnClickListener(this);
        buttonCopy.setOnClickListener(this);
        textViewConvert.setOnClickListener(this);


        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerConvertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences = this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF, "Thousands separator");
        String DecimalplaceString = sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF, "2");
        Settings settings = new Settings(FormattedString, DecimalplaceString);
        formatter = settings.setting();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUnitConverter:
                //switch spinner value
                int spinner1Index = spinnerConvertFrom.getSelectedItemPosition();
                spinnerConvertFrom.setSelection(spinnerConvertTo.getSelectedItemPosition());
                spinnerConvertTo.setSelection(spinner1Index );
                break;

            case R.id.button_list_fullreport:
                doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                Intent i = new Intent(this, ConversionSpecificHeatCapacityListActivity.class);
                i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
                i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
                startActivity(i);
                break;

            case R.id.button_copy:
                String text = editTextValueTo.getText().toString().trim();
                android.content.ClipboardManager clipboardMgr = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", text);
                clipboardMgr.setPrimaryClip(clip);
                Snackbar.make(v, "Conversion Value Copied", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                break;

            case R.id.button_list_share:
                String textTo = editTextValueTo.getText().toString().trim();
                String textFrom = editTextValueTo.getText().toString().trim();

                String shareMessage = textFrom + " " + stringSpinnerFrom + ": " + textTo + " " + stringSpinnerTo;

                try {
                    Intent share = new Intent();
                    share.setAction("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", shareMessage);
                    startActivity(Intent.createChooser(share, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
             break;

            case R.id.button_list_mail:
                String textmailTo = editTextValueTo.getText().toString().trim();
                String textmailFrom = editTextValueTo.getText().toString().trim();
                String message = textmailTo + " " + stringSpinnerFrom + " :  " + textmailFrom + "  " + stringSpinnerTo;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                email.putExtra(Intent.EXTRA_SUBJECT, "Conversion Details");
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Select Email Client"));
                break;

        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {

            doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
            stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
            stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();
            calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);

        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }


    }

    public void calcualteValue(String strSpinnerFromvalue1, String strSpinnerTovalue2, double doubleEdittextvalue1) {



        try {

            SpecificHeatCapacityConverter c = new SpecificHeatCapacityConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<SpecificHeatCapacityConverter.ConversionResults> results = c.calculateheatcapacityConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strjoulekilogramK=String.valueOf(formatter.format(item.getJkgk()));
                strjoulekilogramC=String.valueOf(formatter.format(item.getJkgc()));
                strjoulegramC=String.valueOf(formatter.format(item.getJgc()));
                strkilojoulekilogramK=String.valueOf(formatter.format(item.getKkk()));
                strkilojoulekilogramC=String.valueOf(formatter.format(item.getKkc()));
                strcalorieITgramC=String.valueOf(formatter.format(item.getCitc()));
                strcalorieITgramF=String.valueOf(formatter.format(item.getCitf()));
                strcaloriethgramC=String.valueOf(formatter.format(item.getCth()));
                strkilocalorieITkilogramC=String.valueOf(formatter.format(item.getKitc()));
                strkilocaloriethkilogramC=String.valueOf(formatter.format(item.getKthc()));
                strkilocalorieITkilogramK=String.valueOf(formatter.format(item.getKitk()));
                strkilocaloriethkilogramK=String.valueOf(formatter.format(item.getKthk()));
                strkilogramforcemeterkilogramK=String.valueOf(formatter.format(item.getKf()));
                strpoundforcefootpoundR=String.valueOf(formatter.format(item.getPf()));
                strBtuITpoundF=String.valueOf(formatter.format(item.getBtuitf()));
                strBtuthpoundF=String.valueOf(formatter.format(item.getBtuthf()));
                strBtuITpoundR=String.valueOf(formatter.format(item.getBtuitr()));
                strBtuthpoundR=String.valueOf(formatter.format(item.getBtuthr()));
                strBtuITpoundC=String.valueOf(formatter.format(item.getBtuitc()));
                strCHUpoundC=String.valueOf(formatter.format(item.getChu()));


                switch (strSpinnerFromvalue1) {
                    case "Joule/kilogram/K -J/(kg*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/kilogram/°C -J/(kg*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/gram/°C -J/(g*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilojoule/kilogram/K -kJ/(kg*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilojoule/kilogram/°C -kJ/(kg*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/gram/°C -cal(IT)/(g*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/gram/°F -cal(IT)/(g*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (th)/gram/°C -cal(th)/(g*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram-force meter/kilogram/K -kgfm/(kg*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound-force foot/pound/°R -lbfft/(lb*°R)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/pound/°F -Btu(th)/(lb*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/pound/°R -Btu(th)/(lb*°R)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "CHU/pound/°C -CHU/(lb*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                }
            }


        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    private void conversion(String strSpinnerTovalue2) {

        switch (strSpinnerTovalue2) {
            case "Joule/kilogram/K -J/(kg*K)":
                editTextValueTo.setText(strjoulekilogramK);
                break;
            case "Joule/kilogram/°C -J/(kg*°C)":
                editTextValueTo.setText(strjoulekilogramC);
                break;
            case "Joule/gram/°C -J/(g*°C)":
                editTextValueTo.setText(strjoulegramC);
                break;
            case "Kilojoule/kilogram/K -kJ/(kg*K)":
                editTextValueTo.setText(strkilojoulekilogramK);
                break;
            case "Kilojoule/kilogram/°C -kJ/(kg*°C)":
                editTextValueTo.setText(strkilojoulekilogramC);
                break;
            case "Calorie (IT)/gram/°C -cal(IT)/(g*°C)":
                editTextValueTo.setText(strcalorieITgramC);
                break;
            case "Calorie (IT)/gram/°F -cal(IT)/(g*°F)":
                editTextValueTo.setText(strcalorieITgramF);
                break;
            case "Calorie (th)/gram/°C -cal(th)/(g*°C)":
                editTextValueTo.setText(strcaloriethgramC);
                break;
            case "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)":
                editTextValueTo.setText(strkilocalorieITkilogramC);
                break;
            case "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)":
                editTextValueTo.setText(strkilocaloriethkilogramC);
                break;
            case "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)":
                editTextValueTo.setText(strkilocalorieITkilogramK);
                break;
            case "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)":
                editTextValueTo.setText(strkilocaloriethkilogramK);
                break;
            case "Kilogram-force meter/kilogram/K -kgfm/(kg*K)":
                editTextValueTo.setText(strkilogramforcemeterkilogramK);
                break;
            case "Pound-force foot/pound/°R -lbfft/(lb*°R)":
                editTextValueTo.setText(strpoundforcefootpoundR);
                break;
            case "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)":
                editTextValueTo.setText(strBtuITpoundF);
                break;
            case "Btu (th)/pound/°F -Btu(th)/(lb*°F)":
                editTextValueTo.setText(strBtuthpoundF);
                break;
            case "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)":
                editTextValueTo.setText(strBtuITpoundR);
                break;
            case "Btu (th)/pound/°R -Btu(th)/(lb*°R)":
                editTextValueTo.setText(strBtuthpoundR);
                break;
            case "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)":
                editTextValueTo.setText(strBtuITpoundC);
                break;
            case "CHU/pound/°C -CHU/(lb*°C)":
                editTextValueTo.setText(strCHUpoundC);
                break;
        }


    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}