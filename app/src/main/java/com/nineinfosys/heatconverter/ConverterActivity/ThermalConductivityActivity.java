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
import com.nineinfosys.heatconverter.ConverterActivityList.ConversionThermalConductivityListActivity;
import com.nineinfosys.heatconverter.Engin.ThermalConductivityConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ThermalConductivityActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listtempFirstfrom, listFirsttempTo, listtempfrom, listtempTo;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 5;
    private int allunit = 13;
    private static final int REQUEST_CODE = 100;
    DecimalFormat formatter = null;


    ThermalConductivityConverter.ConversionResults item;
     private String strwattpermeterperK=null,strwattpercentimeterperC=null,strkilowattpermeterperK=null,strcalorieITpersecondpercmperC=null,strcaloriethpersecondpercmperC=null,
            strkilocalorieITperhourpermeterperC=null, strkilocaloriethperhourpermeterperC=null,strBtuITinchpersecondpersqfootperF=null,strBtuthinchpersecondpersqfootperF=null,
            strBtuITfootperhourpersqfootperF=null,strBtuthfootperhourpersqfootperF=null,strBtuITinchperhourpersqfootperF=null,strBtuthinchperhourpersqfootperF=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
      /*  android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db290d")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Thermal Conductivity ");

        formatsetting();


        MobileAds.initialize(ThermalConductivityActivity.this, getString(R.string.ads_app_id));
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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a10000"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Watt/meter/K -W/(m*K)");
        listtempFirstfrom.add("Watt/centimeter/°C -W/(cm*°C)");
        listtempFirstfrom.add("Kilowatt/meter/K -kW/(m*K)");
        listtempFirstfrom.add("Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)");
        listtempFirstfrom.add("Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)");

        //for first time running spinner
        listFirsttempTo.add("Watt/meter/K -W/(m*K)");
        listFirsttempTo.add("Watt/centimeter/°C -W/(cm*°C)");
        listFirsttempTo.add("Kilowatt/meter/K -kW/(m*K)");
        listFirsttempTo.add("Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)");
        listFirsttempTo.add("Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ThermalConductivityActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ThermalConductivityActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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
                        listtempfrom.add("Watt/meter/K -W/(m*K)");
                        listtempfrom.add("Watt/centimeter/°C -W/(cm*°C)");
                        listtempfrom.add("Kilowatt/meter/K -kW/(m*K)");
                        listtempfrom.add("Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)");
                        listtempfrom.add("Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)");


                        //2 spinner
                        listtempTo.add("Watt/meter/K -W/(m*K)");
                        listtempTo.add("Watt/centimeter/°C -W/(cm*°C)");
                        listtempTo.add("Kilowatt/meter/K -kW/(m*K)");
                        listtempTo.add("Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)");
                        listtempTo.add("Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Watt/meter/K -W/(m*K)");
                        listtempfrom.add("Watt/centimeter/°C -W/(cm*°C)");
                        listtempfrom.add("Kilowatt/meter/K -kW/(m*K)");
                        listtempfrom.add("Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)");
                        listtempfrom.add("Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)");
                        listtempfrom.add("Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)");
                        listtempfrom.add("Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)");
                        listtempfrom.add("Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)");
                        listtempfrom.add("Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)");
                        listtempfrom.add("Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)");
                        listtempfrom.add("Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)");
                        listtempfrom.add("Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)");
                        listtempfrom.add("Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)");


                        //second spinner
                        listtempTo.add("Watt/meter/K -W/(m*K)");
                        listtempTo.add("Watt/centimeter/°C -W/(cm*°C)");
                        listtempTo.add("Kilowatt/meter/K -kW/(m*K)");
                        listtempTo.add("Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)");
                        listtempTo.add("Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)");
                        listtempTo.add("Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)");
                        listtempTo.add("Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)");
                        listtempTo.add("Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)");
                        listtempTo.add("Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)");
                        listtempTo.add("Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)");
                        listtempTo.add("Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)");
                        listtempTo.add("Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)");
                        listtempTo.add("Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ThermalConductivityActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ThermalConductivityActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionThermalConductivityListActivity.class);
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

            ThermalConductivityConverter c = new ThermalConductivityConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<ThermalConductivityConverter.ConversionResults> results = c.calculateThermalConductivityConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strwattpermeterperK=String.valueOf(formatter.format(item.getWattpermeterperK()));
                strwattpercentimeterperC=String.valueOf(formatter.format(item.getWattpercentimeterperC()));
                strkilowattpermeterperK=String.valueOf(formatter.format(item.getKilowattpermeterperK()));
                strcalorieITpersecondpercmperC=String.valueOf(formatter.format(item.getCalorieITpersecondpercmperC()));
                strcaloriethpersecondpercmperC=String.valueOf(formatter.format(item.getCaloriethpersecondpercmperC()));
                strkilocalorieITperhourpermeterperC=String.valueOf(formatter.format(item.getKilocalorieITperhourpermeterperC()));
                strkilocaloriethperhourpermeterperC=String.valueOf(formatter.format(item.getKilocaloriethperhourpermeterperC()));
                strBtuITinchpersecondpersqfootperF=String.valueOf(formatter.format(item.getBtuITinchpersecondpersqfootperF()));
                strBtuthinchpersecondpersqfootperF=String.valueOf(formatter.format(item.getBtuthinchpersecondpersqfootperF()));
                strBtuITfootperhourpersqfootperF=String.valueOf(formatter.format(item.getBtuITfootperhourpersqfootperF()));
                strBtuthfootperhourpersqfootperF=String.valueOf(formatter.format(item.getBtuthfootperhourpersqfootperF()));
                strBtuITinchperhourpersqfootperF=String.valueOf(formatter.format(item.getBtuITinchperhourpersqfootperF()));
                strBtuthinchperhourpersqfootperF=String.valueOf(formatter.format(item.getBtuthinchperhourpersqfootperF()));
                

                switch (strSpinnerFromvalue1) {
                    case "Watt/meter/K -W/(m*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Watt/centimeter/°C -W/(cm*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilowatt/meter/K -kW/(m*K)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)":
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
            case "Watt/meter/K -W/(m*K)":
                 editTextValueTo.setText(strwattpermeterperK);
                break;
            case "Watt/centimeter/°C -W/(cm*°C)":
                 editTextValueTo.setText(strwattpercentimeterperC);
                break;
            case "Kilowatt/meter/K -kW/(m*K)":
                 editTextValueTo.setText(strkilowattpermeterperK);
                break;
            case "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)":
                 editTextValueTo.setText(strcalorieITpersecondpercmperC);
                break;
            case "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)":
                 editTextValueTo.setText(strcaloriethpersecondpercmperC);
                break;
            case "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)":
                 editTextValueTo.setText(strkilocalorieITperhourpermeterperC);
                break;
            case "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)":
                 editTextValueTo.setText(strkilocaloriethperhourpermeterperC);
                break;
            case "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)":
                 editTextValueTo.setText(strBtuITinchpersecondpersqfootperF);
                break;
            case "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)":
                 editTextValueTo.setText(strBtuthinchpersecondpersqfootperF);
                break;
            case "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)":
                 editTextValueTo.setText(strBtuITfootperhourpersqfootperF);
                break;
            case "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)":
                 editTextValueTo.setText(strBtuthfootperhourpersqfootperF);
                break;
            case "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)":
                 editTextValueTo.setText(strBtuITinchperhourpersqfootperF);
                break;
            case "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)":
                 editTextValueTo.setText(strBtuthinchperhourpersqfootperF);
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