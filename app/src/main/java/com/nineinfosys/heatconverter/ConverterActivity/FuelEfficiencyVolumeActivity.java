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


import com.nineinfosys.heatconverter.ConverterActivityList.ConversionFuelEfficiencyVolumeListActivity;
import com.nineinfosys.heatconverter.Engin.FuelEfficiencyVolumeConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FuelEfficiencyVolumeActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


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
    private int allunit = 15;
    DecimalFormat formatter = null;


    FuelEfficiencyVolumeConverter.ConversionResults item;
     private String strjoulepercubicmeter=null,strjouleperliter=null,strmegajoulepercubicmeter=null,strkilojoulepercubicmeter=null,strkilocalorieITpercubicmeter=null,strcalorieITpercubiccentimeter =null,
            strthermpercubicfoot=null,strthermpergallonUK=null,strBtuITpercubicfoot=null,strBtuthpercubicfoot=null,strCHUpercubicfoot=null,strcubicmeterperjoule=null,
            strliterperjoule=null,strgallonUSperhorsepower=null,strgallonUKperhorsepower=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
      /*  android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Fuel Efficiency Volume ");

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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Joule/cubic meter -J/m^3");
        listtempFirstfrom.add("Joule/liter -J/L");
        listtempFirstfrom.add("Megajoule/cubic meter -mJ/m^3");
        listtempFirstfrom.add("Kilojoule/cubic meter -kJ/m^3");
        listtempFirstfrom.add("Kilocalorie (IT)/cubic meter -kcal(IT)/m^3");

        //for first time running spinner
        listFirsttempTo.add("Joule/cubic meter -J/m^3");
        listFirsttempTo.add("Joule/liter -J/L");
        listFirsttempTo.add("Megajoule/cubic meter -mJ/m^3");
        listFirsttempTo.add("Kilojoule/cubic meter -kJ/m^3");
        listFirsttempTo.add("Kilocalorie (IT)/cubic meter -kcal(IT)/m^3");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(FuelEfficiencyVolumeActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(FuelEfficiencyVolumeActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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
                        listtempfrom.add("Joule/cubic meter -J/m^3");
                        listtempfrom.add("Joule/liter -J/L");
                        listtempfrom.add("Megajoule/cubic meter -mJ/m^3");
                        listtempfrom.add("Kilojoule/cubic meter -kJ/m^3");
                        listtempfrom.add("Kilocalorie (IT)/cubic meter -kcal(IT)/m^3");


                        //2 spinner
                        listtempTo.add("Joule/cubic meter -J/m^3");
                        listtempTo.add("Joule/liter -J/L");
                        listtempTo.add("Megajoule/cubic meter -mJ/m^3");
                        listtempTo.add("Kilojoule/cubic meter -kJ/m^3");
                        listtempTo.add("Kilocalorie (IT)/cubic meter -kcal(IT)/m^3");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Joule/cubic meter -J/m^3");
                        listtempfrom.add("Joule/liter -J/L");
                        listtempfrom.add("Megajoule/cubic meter -mJ/m^3");
                        listtempfrom.add("Kilojoule/cubic meter -kJ/m^3");
                        listtempfrom.add("Kilocalorie (IT)/cubic meter -kcal(IT)/m^3");
                        listtempfrom.add("Calorie (IT)/cubic centimeter -cal(IT)/cm^3");
                        listtempfrom.add("Therm/cubic foot -therm/ft^3");
                        listtempfrom.add("Therm/gallon (UK) -therm/gal");
                        listtempfrom.add("Btu (IT)/cubic foot -Btu/ft^3");
                        listtempfrom.add("Btu (th)/cubic foot -Btu (th)/ft^3");
                        listtempfrom.add("CHU/cubic foot -CHU/ft^3");
                        listtempfrom.add("Cubic meter/joule -m^3/J");
                        listtempfrom.add("Liter/joule -L/J");
                        listtempfrom.add("Gallon (US)/horsepower -gal(US)/hp");
                        listtempfrom.add("Gallon (UK)/horsepower -gal(UK)/hp");


                        //second spinner
                        listtempTo.add("Joule/cubic meter -J/m^3");
                        listtempTo.add("Joule/liter -J/L");
                        listtempTo.add("Megajoule/cubic meter -mJ/m^3");
                        listtempTo.add("Kilojoule/cubic meter -kJ/m^3");
                        listtempTo.add("Kilocalorie (IT)/cubic meter -kcal(IT)/m^3");
                        listtempTo.add("Calorie (IT)/cubic centimeter -cal(IT)/cm^3");
                        listtempTo.add("Therm/cubic foot -therm/ft^3");
                        listtempTo.add("Therm/gallon (UK) -therm/gal");
                        listtempTo.add("Btu (IT)/cubic foot -Btu/ft^3");
                        listtempTo.add("Btu (th)/cubic foot -Btu (th)/ft^3");
                        listtempTo.add("CHU/cubic foot -CHU/ft^3");
                        listtempTo.add("Cubic meter/joule -m^3/J");
                        listtempTo.add("Liter/joule -L/J");
                        listtempTo.add("Gallon (US)/horsepower -gal(US)/hp");
                        listtempTo.add("Gallon (UK)/horsepower -gal(UK)/hp");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(FuelEfficiencyVolumeActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(FuelEfficiencyVolumeActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionFuelEfficiencyVolumeListActivity.class);
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

            FuelEfficiencyVolumeConverter c = new FuelEfficiencyVolumeConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<FuelEfficiencyVolumeConverter.ConversionResults> results = c.calculateFuelEfficiencyVolumeConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strjoulepercubicmeter=String.valueOf(formatter.format(item.getJoulepercubicmeter()));
                strjouleperliter=String.valueOf(formatter.format(item.getJouleperliter()));
                strmegajoulepercubicmeter=String.valueOf(formatter.format(item.getMegajoulepercubicmeter()));
                strkilojoulepercubicmeter=String.valueOf(formatter.format(item.getKilojoulepercubicmeter()));
                strkilocalorieITpercubicmeter=String.valueOf(formatter.format(item.getKilocalorieITpercubicmeter()));
                strcalorieITpercubiccentimeter=String.valueOf(formatter.format(item.getCalorieITpercubiccentimeter()));
                strthermpercubicfoot=String.valueOf(formatter.format(item.getThermpercubicfoot()));
                strthermpergallonUK=String.valueOf(formatter.format(item.getThermpergallonUK()));
                strBtuITpercubicfoot=String.valueOf(formatter.format(item.getBtuITpercubicfoot()));
                strBtuthpercubicfoot=String.valueOf(formatter.format(item.getBtuthpercubicfoot()));
                strCHUpercubicfoot=String.valueOf(formatter.format(item.getCHUpercubicfoot()));
                strcubicmeterperjoule=String.valueOf(formatter.format(item.getCubicmeterperjoule()));
                strliterperjoule=String.valueOf(formatter.format(item.getLiterperjoule()));
                strgallonUSperhorsepower=String.valueOf(formatter.format(item.getGallonUSperhorsepower()));
                strgallonUKperhorsepower=String.valueOf(formatter.format(item.getGallonUKperhorsepower()));


                switch (strSpinnerFromvalue1) {
                    case "Joule/cubic meter -J/m^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/liter -J/L":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megajoule/cubic meter -mJ/m^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilojoule/cubic meter -kJ/m^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/cubic centimeter -cal(IT)/cm^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Therm/cubic foot -therm/ft^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Therm/gallon (UK) -therm/gal":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/cubic foot -Btu/ft^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/cubic foot -Btu (th)/ft^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "CHU/cubic foot -CHU/ft^3":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Cubic meter/joule -m^3/J":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Liter/joule -L/J":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gallon (US)/horsepower -gal(US)/hp":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gallon (UK)/horsepower -gal(UK)/hp":
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
            case "Joule/cubic meter -J/m^3":
                editTextValueTo.setText(strjoulepercubicmeter);
                break;
            case "Joule/liter -J/L":
                editTextValueTo.setText(strjouleperliter);
                break;
            case "Megajoule/cubic meter -mJ/m^3":
                editTextValueTo.setText(strmegajoulepercubicmeter);
                break;
            case "Kilojoule/cubic meter -kJ/m^3":
                editTextValueTo.setText(strkilojoulepercubicmeter);
                break;
            case "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3":
                editTextValueTo.setText(strkilocalorieITpercubicmeter);
                break;
            case "Calorie (IT)/cubic centimeter -cal(IT)/cm^3":
                editTextValueTo.setText(strcalorieITpercubiccentimeter);
                break;
            case "Therm/cubic foot -therm/ft^3":
                editTextValueTo.setText(strthermpercubicfoot);
                break;
            case "Therm/gallon (UK) -therm/gal":
                editTextValueTo.setText(strthermpergallonUK);
                break;
            case "Btu (IT)/cubic foot -Btu/ft^3":
                editTextValueTo.setText(strBtuITpercubicfoot);
                break;
            case "Btu (th)/cubic foot -Btu (th)/ft^3":
                editTextValueTo.setText(strBtuthpercubicfoot);
                break;
            case "CHU/cubic foot -CHU/ft^3":
                editTextValueTo.setText(strCHUpercubicfoot);
                break;
            case "Cubic meter/joule -m^3/J":
                editTextValueTo.setText(strcubicmeterperjoule);
                break;
            case "Liter/joule -L/J":
                editTextValueTo.setText(strliterperjoule);
                break;
            case "Gallon (US)/horsepower -gal(US)/hp":
                editTextValueTo.setText(strgallonUSperhorsepower);
                break;
            case "Gallon (UK)/horsepower -gal(UK)/hp":
                editTextValueTo.setText(strgallonUKperhorsepower);
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