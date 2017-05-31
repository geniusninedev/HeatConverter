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


import com.nineinfosys.heatconverter.ConverterActivityList.ConversionHeatFluxDensityListActivity;
import com.nineinfosys.heatconverter.Engin.HeatFluxDensityConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HeatFluxDensityActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


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
    private int allunit = 26;
    DecimalFormat formatter = null;


    HeatFluxDensityConverter.ConversionResults item;
     private String strwattpersquaremeter=null,strkilowattpersquaremeter=null,strwattpersquarecentimeter=null,strwattpersquareinch=null,strjoulepersecondpersquaremeter=null,
            strkilocalorieITperhourpersquaremeter =null,strkilocalorieITperhourpersquarefoot=null,strcalorieITpersecondpersquarecentimeter=null,strcalorieITperminutepersquarecentimeter=null,
            strcalorieITperhourpersquarecentimeter=null,strcaloriethpersecondpersquarecentimeter =null,strcaloriethperminutepersquarecentimeter=null,strcaloriethperhourpersquarecentimeter=null,
            strdyneperhourpercentimeter=null,strergperhourpersquaremillimeter=null,strfootpoundperminutepersquarefoot =null,strhorsepowerpersquarefoot=null,strhorsepowermetricpersquarefoot=null,
            strBtuITpersecondpersquarefoot=null,strBtuITperminutepersquarefoot=null,strBtuITperhourpersquarefoot=null,strBtuthpersecondpersquareinch=null,strBtuthpersecondpersquarefoot=null,
            strBtuthperminutepersquarefoot=null,strBtuthperhourpersquarefoot=null,strCHUperhourpersquarefoot=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
      /*  android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e5b526")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Heat Flux Density ");

        formatsetting();




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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkYellow)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkYellow)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkYellow)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkYellow)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkYellow)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDarkYellow)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#af8600"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Watt/square meter -W/m^2");
        listtempFirstfrom.add("Kilowatt/square meter -kW/m^2");
        listtempFirstfrom.add("Watt/square centimeter -W/cm^2");
        listtempFirstfrom.add("Watt/square inch -W/in^2");
        listtempFirstfrom.add("Joule/second/square meter -Js/m^2");

        //for first time running spinner
        listFirsttempTo.add("Watt/square meter -W/m^2");
        listFirsttempTo.add("Kilowatt/square meter -kW/m^2");
        listFirsttempTo.add("Watt/square centimeter -W/cm^2");
        listFirsttempTo.add("Watt/square inch -W/in^2");
        listFirsttempTo.add("Joule/second/square meter -Js/m^2");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(HeatFluxDensityActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(HeatFluxDensityActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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
                        listtempfrom.add("Watt/square meter -W/m^2");
                        listtempfrom.add("Kilowatt/square meter -kW/m^2");
                        listtempfrom.add("Watt/square centimeter -W/cm^2");
                        listtempfrom.add("Watt/square inch -W/in^2");
                        listtempfrom.add("Joule/second/square meter -Js/m^2");


                        //2 spinner
                        listtempTo.add("Watt/square meter -W/m^2");
                        listtempTo.add("Kilowatt/square meter -kW/m^2");
                        listtempTo.add("Watt/square centimeter -W/cm^2");
                        listtempTo.add("Watt/square inch -W/in^2");
                        listtempTo.add("Joule/second/square meter -Js/m^2");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Watt/square meter -W/m^2");
                        listtempfrom.add("Kilowatt/square meter -kW/m^2");
                        listtempfrom.add("Watt/square centimeter -W/cm^2");
                        listtempfrom.add("Watt/square inch -W/in^2");
                        listtempfrom.add("Joule/second/square meter -Js/m^2");
                        listtempfrom.add("Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2");
                        listtempfrom.add("Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2");
                        listtempfrom.add("Calorie (IT)/second/square centimeter -cal(IT)s/cm^2");
                        listtempfrom.add("Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2");
                        listtempfrom.add("Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2");
                        listtempfrom.add("Calorie (th)/second/square centimeter -cal(th)s/cm^2");
                        listtempfrom.add("Calorie (th)/minute/square centimeter -cal(th)min/cm^2");
                        listtempfrom.add("Calorie (th)/hour/square centimeter -cal(th)h/cm^2");
                        listtempfrom.add("Dyne/hour/centimeter -dynh/cm");
                        listtempfrom.add("Erg/hour/square millimeter -ergh/mm^2");
                        listtempfrom.add("Foot pound/minute/square foot -ftlbmin/ft^2");
                        listtempfrom.add("Horsepower/square foot -hp/ft^2");
                        listtempfrom.add("Horsepower (metric)/square foot -hp/ft^2");
                        listtempfrom.add("Btu (IT)/second/square foot -Btu(IT)s/ft^2");
                        listtempfrom.add("Btu (IT)/minute/square foot -Btu(IT)min/ft^2");
                        listtempfrom.add("Btu (IT)/hour/square foot -Btu(IT)h/ft^2");
                        listtempfrom.add("Btu (th)/second/square inch -Btu(th)s/in^2");
                        listtempfrom.add("Btu (th)/second/square foot -Btu(th)s/ft^2");
                        listtempfrom.add("Btu (th)/minute/square foot -Btu(th)min/ft^2");
                        listtempfrom.add("Btu (th)/hour/square foot -Btu(th)h/ft^2");
                        listtempfrom.add("CHU/hour/square foot -CHUh/ft^2");


                        //second spinner
                        listtempTo.add("Watt/square meter -W/m^2");
                        listtempTo.add("Kilowatt/square meter -kW/m^2");
                        listtempTo.add("Watt/square centimeter -W/cm^2");
                        listtempTo.add("Watt/square inch -W/in^2");
                        listtempTo.add("Joule/second/square meter -Js/m^2");
                        listtempTo.add("Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2");
                        listtempTo.add("Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2");
                        listtempTo.add("Calorie (IT)/second/square centimeter -cal(IT)s/cm^2");
                        listtempTo.add("Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2");
                        listtempTo.add("Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2");
                        listtempTo.add("Calorie (th)/second/square centimeter -cal(th)s/cm^2");
                        listtempTo.add("Calorie (th)/minute/square centimeter -cal(th)min/cm^2");
                        listtempTo.add("Calorie (th)/hour/square centimeter -cal(th)h/cm^2");
                        listtempTo.add("Dyne/hour/centimeter -dynh/cm");
                        listtempTo.add("Erg/hour/square millimeter -ergh/mm^2");
                        listtempTo.add("Foot pound/minute/square foot -ftlbmin/ft^2");
                        listtempTo.add("Horsepower/square foot -hp/ft^2");
                        listtempTo.add("Horsepower (metric)/square foot -hp/ft^2");
                        listtempTo.add("Btu (IT)/second/square foot -Btu(IT)s/ft^2");
                        listtempTo.add("Btu (IT)/minute/square foot -Btu(IT)min/ft^2");
                        listtempTo.add("Btu (IT)/hour/square foot -Btu(IT)h/ft^2");
                        listtempTo.add("Btu (th)/second/square inch -Btu(th)s/in^2");
                        listtempTo.add("Btu (th)/second/square foot -Btu(th)s/ft^2");
                        listtempTo.add("Btu (th)/minute/square foot -Btu(th)min/ft^2");
                        listtempTo.add("Btu (th)/hour/square foot -Btu(th)h/ft^2");
                        listtempTo.add("CHU/hour/square foot -CHUh/ft^2");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(HeatFluxDensityActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(HeatFluxDensityActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionHeatFluxDensityListActivity.class);
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

            HeatFluxDensityConverter c = new HeatFluxDensityConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<HeatFluxDensityConverter.ConversionResults> results = c.calculateHeatFluxDensityConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strwattpersquaremeter=String.valueOf(formatter.format(item.getWattpersquaremeter()));
                strkilowattpersquaremeter=String.valueOf(formatter.format(item.getKilowattpersquaremeter()));
                strwattpersquarecentimeter=String.valueOf(formatter.format(item.getWattpersquarecentimeter()));
                strwattpersquareinch=String.valueOf(formatter.format(item.getWattpersquareinch()));
                strjoulepersecondpersquaremeter=String.valueOf(formatter.format(item.getJoulepersecondpersquaremeter()));
                strkilocalorieITperhourpersquaremeter=String.valueOf(formatter.format(item.getKilocalorieITperhourpersquaremeter()));
                strkilocalorieITperhourpersquarefoot=String.valueOf(formatter.format(item.getKilocalorieITperhourpersquarefoot()));
                strcalorieITpersecondpersquarecentimeter=String.valueOf(formatter.format(item.getCalorieITpersecondpersquarecentimeter()));
                strcalorieITperminutepersquarecentimeter=String.valueOf(formatter.format(item.getCalorieITperminutepersquarecentimeter()));
                strcalorieITperhourpersquarecentimeter=String.valueOf(formatter.format(item.getCalorieITperhourpersquarecentimeter()));
                strcaloriethpersecondpersquarecentimeter=String.valueOf(formatter.format(item.getCaloriethpersecondpersquarecentimeter()));
                strcaloriethperminutepersquarecentimeter=String.valueOf(formatter.format(item.getCaloriethperminutepersquarecentimeter()));
                strcaloriethperhourpersquarecentimeter=String.valueOf(formatter.format(item.getCaloriethperhourpersquarecentimeter()));
                strdyneperhourpercentimeter=String.valueOf(formatter.format(item.getDyneperhourpercentimeter()));
                strergperhourpersquaremillimeter=String.valueOf(formatter.format(item.getErgperhourpersquaremillimeter()));
                strfootpoundperminutepersquarefoot=String.valueOf(formatter.format(item.getFootpoundperminutepersquarefoot()));
                strhorsepowerpersquarefoot=String.valueOf(formatter.format(item.getHorsepowerpersquarefoot()));
                strhorsepowermetricpersquarefoot=String.valueOf(formatter.format(item.getHorsepowermetricpersquarefoot()));
                strBtuITpersecondpersquarefoot=String.valueOf(formatter.format(item.getBtuITpersecondpersquarefoot()));
                strBtuITperminutepersquarefoot=String.valueOf(formatter.format(item.getBtuITperminutepersquarefoot()));
                strBtuITperhourpersquarefoot=String.valueOf(formatter.format(item.getBtuITperhourpersquarefoot()));
                strBtuthpersecondpersquareinch=String.valueOf(formatter.format(item.getBtuthpersecondpersquareinch()));
                strBtuthpersecondpersquarefoot=String.valueOf(formatter.format(item.getBtuthpersecondpersquarefoot()));
                strBtuthperminutepersquarefoot=String.valueOf(formatter.format(item.getBtuthperminutepersquarefoot()));
                strBtuthperhourpersquarefoot=String.valueOf(formatter.format(item.getBtuthperhourpersquarefoot()));
                strCHUperhourpersquarefoot=String.valueOf(formatter.format(item.getCHUperhourpersquarefoot()));


                switch (strSpinnerFromvalue1) {
                    case "Watt/square meter -W/m^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilowatt/square meter -kW/m^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Watt/square centimeter -W/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Watt/square inch -W/in^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/second/square meter -Js/m^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case  "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (th)/second/square centimeter -cal(th)s/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (th)/minute/square centimeter -cal(th)min/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (th)/hour/square centimeter -cal(th)h/cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Dyne/hour/centimeter -dynh/cm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Erg/hour/square millimeter -ergh/mm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Foot pound/minute/square foot -ftlbmin/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Horsepower/square foot -hp/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Horsepower (metric)/square foot -hp/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/second/square foot -Btu(IT)s/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/minute/square foot -Btu(IT)min/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/hour/square foot -Btu(IT)h/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/second/square inch -Btu(th)s/in^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/second/square foot -Btu(th)s/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/minute/square foot -Btu(th)min/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/hour/square foot -Btu(th)h/ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "CHU/hour/square foot -CHUh/ft^2":
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
            case "Watt/square meter -W/m^2":
                editTextValueTo.setText(strwattpersquaremeter);
                break;
            case "Kilowatt/square meter -kW/m^2":
                editTextValueTo.setText(strkilowattpersquaremeter);
                break;
            case "Watt/square centimeter -W/cm^2":
                editTextValueTo.setText(strwattpersquarecentimeter);
                break;
            case "Watt/square inch -W/in^2":
                editTextValueTo.setText(strwattpersquareinch);
                break;
            case "Joule/second/square meter -Js/m^2":
                editTextValueTo.setText(strjoulepersecondpersquaremeter);
                break;
            case "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2":
                editTextValueTo.setText(strkilocalorieITperhourpersquaremeter);
                break;
            case  "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2":
                editTextValueTo.setText(strkilocalorieITperhourpersquarefoot);
                break;
            case "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2":
                editTextValueTo.setText(strcalorieITpersecondpersquarecentimeter);
                break;
            case "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2":
                editTextValueTo.setText(strcalorieITperminutepersquarecentimeter);
                break;
            case "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2":
                editTextValueTo.setText(strcalorieITperhourpersquarecentimeter);
                break;
            case "Calorie (th)/second/square centimeter -cal(th)s/cm^2":
                editTextValueTo.setText(strcaloriethpersecondpersquarecentimeter);
                break;
            case "Calorie (th)/minute/square centimeter -cal(th)min/cm^2":
                editTextValueTo.setText(strcaloriethperminutepersquarecentimeter);
                break;
            case "Calorie (th)/hour/square centimeter -cal(th)h/cm^2":
                editTextValueTo.setText(strcaloriethperhourpersquarecentimeter);
                break;
            case "Dyne/hour/centimeter -dynh/cm":
                editTextValueTo.setText(strdyneperhourpercentimeter);
                break;
            case "Erg/hour/square millimeter -ergh/mm^2":
                editTextValueTo.setText(strergperhourpersquaremillimeter);
                break;
            case "Foot pound/minute/square foot -ftlbmin/ft^2":
                editTextValueTo.setText(strfootpoundperminutepersquarefoot);
                break;
            case "Horsepower/square foot -hp/ft^2":
                editTextValueTo.setText(strhorsepowerpersquarefoot);
                break;
            case "Horsepower (metric)/square foot -hp/ft^2":
                editTextValueTo.setText(strhorsepowermetricpersquarefoot);
                break;
            case "Btu (IT)/second/square foot -Btu(IT)s/ft^2":
                editTextValueTo.setText(strBtuITpersecondpersquarefoot);
                break;
            case "Btu (IT)/minute/square foot -Btu(IT)min/ft^2":
                editTextValueTo.setText(strBtuITperminutepersquarefoot);
                break;
            case "Btu (IT)/hour/square foot -Btu(IT)h/ft^2":
                editTextValueTo.setText(strBtuITperhourpersquarefoot);
                break;
            case "Btu (th)/second/square inch -Btu(th)s/in^2":
                editTextValueTo.setText(strBtuthpersecondpersquareinch);
                break;
            case "Btu (th)/second/square foot -Btu(th)s/ft^2":
                editTextValueTo.setText(strBtuthpersecondpersquarefoot);
                break;
            case "Btu (th)/minute/square foot -Btu(th)min/ft^2":
                editTextValueTo.setText(strBtuthperminutepersquarefoot);
                break;
            case "Btu (th)/hour/square foot -Btu(th)h/ft^2":
                editTextValueTo.setText(strBtuthperhourpersquarefoot);
                break;
            case "CHU/hour/square foot -CHUh/ft^2":
                editTextValueTo.setText(strCHUperhourpersquarefoot);
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