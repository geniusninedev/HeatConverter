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
import com.nineinfosys.heatconverter.ConverterActivityList.ConversionHeatTransferCoefficientListActivity;
import com.nineinfosys.heatconverter.Engin.HeatTransferCoefficientConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HeatTransferCoefficientActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


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
    private int basicunit = 4;
    private int allunit = 11;
    DecimalFormat formatter = null;


    HeatTransferCoefficientConverter.ConversionResults item;
    private  String strwattpersquaremeterperK=null,strwattpersquaremeterperb0C=null,strjoulepersecondpersquaremeterperK=null,strcalorieITpersecondpersquarecentimeterperb0C=null,
            strkilocalorieITperhourpersquaremeterperb0C=null, strkilocalorieITperhourpersquarefootperb0C=null,strBtuITpersecondpersquarefootperb0F=null,strBtuthpersecondpersquarefootperb0F=null,
            strBtuITperhourpersquarefootperb0F=null,strBtuthperhourpersquarefootperb0F=null, strCHUperhourpersquarefootperb0C=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e64a19")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Heat Transfer Coefficient");

        formatsetting();

        MobileAds.initialize(HeatTransferCoefficientActivity.this, getString(R.string.ads_app_id));
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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkorange)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkorange)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkorange)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkorange)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkorange)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkorange)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#ac0800"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Watt/square meter/K -W/m^2/K");
        listtempFirstfrom.add("Watt/square meter/%b0C -W/m^2/%b0C");
        listtempFirstfrom.add("Joule/second/square meter/K -J/s/m^2/K");
        listtempFirstfrom.add("Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C");

        //for first time running spinner
        listFirsttempTo.add("Watt/square meter/K -W/m^2/K");
        listFirsttempTo.add("Watt/square meter/%b0C -W/m^2/%b0C");
        listFirsttempTo.add("Joule/second/square meter/K -J/s/m^2/K");
        listFirsttempTo.add("Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(HeatTransferCoefficientActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(HeatTransferCoefficientActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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
                        listtempfrom.add("Watt/square meter/K -W/m^2/K");
                        listtempfrom.add("Watt/square meter/%b0C -W/m^2/%b0C");
                        listtempfrom.add("Joule/second/square meter/K -J/s/m^2/K");
                        listtempfrom.add("Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C");


                        //2 spinner
                        listtempTo.add("Watt/square meter/K -W/m^2/K");
                        listtempTo.add("Watt/square meter/%b0C -W/m^2/%b0C");
                        listtempTo.add("Joule/second/square meter/K -J/s/m^2/K");
                        listtempTo.add("Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Watt/square meter/K -W/m^2/K");
                        listtempfrom.add("Watt/square meter/%b0C -W/m^2/%b0C");
                        listtempfrom.add("Joule/second/square meter/K -J/s/m^2/K");
                        listtempfrom.add("Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C");
                        listtempfrom.add("Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C");
                        listtempfrom.add("Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C");
                        listtempfrom.add("Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F");
                        listtempfrom.add("Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F");
                        listtempfrom.add("Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F");
                        listtempfrom.add("Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F");
                        listtempfrom.add("CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C");


                        //second spinner
                        listtempTo.add("Watt/square meter/K -W/m^2/K");
                        listtempTo.add("Watt/square meter/%b0C -W/m^2/%b0C");
                        listtempTo.add("Joule/second/square meter/K -J/s/m^2/K");
                        listtempTo.add("Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C");
                        listtempTo.add("Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C");
                        listtempTo.add("Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C");
                        listtempTo.add("Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F");
                        listtempTo.add("Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F");
                        listtempTo.add("Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F");
                        listtempTo.add("Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F");
                        listtempTo.add("CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(HeatTransferCoefficientActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(HeatTransferCoefficientActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionHeatTransferCoefficientListActivity.class);
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


  /* @Override
   protected void onResume() {
       Intent intent = new Intent(TempertureActivity.this, TempertureActivity.class);
       TempertureActivity.this.startActivity(intent);
       finish();
       super.onResume();
   }*/
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

            HeatTransferCoefficientConverter c = new HeatTransferCoefficientConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<HeatTransferCoefficientConverter.ConversionResults> results = c.calculateHeatTransferCoefficientConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strwattpersquaremeterperK=String.valueOf(formatter.format(item.getWattpersquaremeterperK()));
                strwattpersquaremeterperb0C=String.valueOf(formatter.format(item.getWattpersquaremeterperb0C()));
                strjoulepersecondpersquaremeterperK=String.valueOf(formatter.format(item.getJoulepersecondpersquaremeterperK()));
                strcalorieITpersecondpersquarecentimeterperb0C=String.valueOf(formatter.format(item.getCalorieITpersecondpersquarecentimeterperb0C()));
                strkilocalorieITperhourpersquaremeterperb0C=String.valueOf(formatter.format(item.getKilocalorieITperhourpersquaremeterperb0C()));
                strkilocalorieITperhourpersquarefootperb0C=String.valueOf(formatter.format(item.getKilocalorieITperhourpersquarefootperb0C()));
                strBtuITpersecondpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuITpersecondpersquarefootperb0F()));
                strBtuthpersecondpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuthpersecondpersquarefootperb0F()));
                strBtuITperhourpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuITperhourpersquarefootperb0F()));
                strBtuthperhourpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuthperhourpersquarefootperb0F()));
                strCHUperhourpersquarefootperb0C=String.valueOf(formatter.format(item.getCHUperhourpersquarefootperb0C()));


                switch (strSpinnerFromvalue1) {
                    case "Watt/square meter/K -W/m^2/K":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Watt/square meter/%b0C -W/m^2/%b0C":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/second/square meter/K -J/s/m^2/K":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C":
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
            case "Watt/square meter/K -W/m^2/K":
                editTextValueTo.setText(strwattpersquaremeterperK);
                break;
            case "Watt/square meter/%b0C -W/m^2/%b0C":
                editTextValueTo.setText(strwattpersquaremeterperb0C);
                break;
            case "Joule/second/square meter/K -J/s/m^2/K":
                editTextValueTo.setText(strjoulepersecondpersquaremeterperK);
                break;
            case "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C":
                editTextValueTo.setText(strcalorieITpersecondpersquarecentimeterperb0C);
                break;
            case "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C":
                editTextValueTo.setText(strkilocalorieITperhourpersquaremeterperb0C);
                break;
            case "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C":
                editTextValueTo.setText(strkilocalorieITperhourpersquarefootperb0C);
                break;
            case "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F":
                editTextValueTo.setText(strBtuITpersecondpersquarefootperb0F);
                break;
            case "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F":
                editTextValueTo.setText(strBtuthpersecondpersquarefootperb0F);
                break;
            case "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F":
                editTextValueTo.setText(strBtuITperhourpersquarefootperb0F);
                break;
            case "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F":
                editTextValueTo.setText(strBtuthperhourpersquarefootperb0F);
                break;
            case "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C":
                editTextValueTo.setText(strCHUperhourpersquarefootperb0C);
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