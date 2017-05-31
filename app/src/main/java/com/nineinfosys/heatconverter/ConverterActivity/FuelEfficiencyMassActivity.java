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


import com.nineinfosys.heatconverter.ConverterActivityList.ConversionFuelEfficiencyMassListActivity;
import com.nineinfosys.heatconverter.Engin.FuelEfficiencyMassConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FuelEfficiencyMassActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


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
    private int basicunit = 6;
    private int allunit = 15;
    DecimalFormat formatter = null;


    FuelEfficiencyMassConverter.ConversionResults item;
    private String strjouleperkilogram=null,strkilojouleperkilogram=null,strcalorieITpergram=null,strcaloriethpergram=null,strBtuITperpound=null,strBtuthperpound =null,strkilogramperjoule=null,
            strkilogramperkilojoule=null,strgrampercalorieIT=null,strgrampercalorieth=null,strpoundperBtuIT=null,strpoundperBtuth=null, strpoundperhorsepowerperhour=null,
            strgramperhorsepowermetricperhour=null,strgramperkilowattperhour=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Fuel Efficiency Mass ");

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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#707070"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Joule/kilogram -J/kg");
        listtempFirstfrom.add("Kilojoule/kilogram -kJ/kg");
        listtempFirstfrom.add("Calorie (IT)/gram -cal/g");
        listtempFirstfrom.add("Calorie (th)/gram -cal(th)/g");
        listtempFirstfrom.add("Btu (IT)/pound -Btu/lb");
        listtempFirstfrom.add("Btu (th)/pound -Btu(th)/lb");

        //for first time running spinner
        listFirsttempTo.add("Joule/kilogram -J/kg");
        listFirsttempTo.add("Kilojoule/kilogram -kJ/kg");
        listFirsttempTo.add("Calorie (IT)/gram -cal/g");
        listFirsttempTo.add("Calorie (th)/gram -cal(th)/g");
        listFirsttempTo.add("Btu (IT)/pound -Btu/lb");
        listFirsttempTo.add("Btu (th)/pound -Btu(th)/lb");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(FuelEfficiencyMassActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(FuelEfficiencyMassActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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
                        listtempfrom.add("Joule/kilogram -J/kg");
                        listtempfrom.add("Kilojoule/kilogram -kJ/kg");
                        listtempfrom.add("Calorie (IT)/gram -cal/g");
                        listtempfrom.add("Calorie (th)/gram -cal(th)/g");
                        listtempfrom.add("Btu (IT)/pound -Btu/lb");
                        listtempfrom.add("Btu (th)/pound -Btu(th)/lb");


                        //2 spinner
                        listtempTo.add("Joule/kilogram -J/kg");
                        listtempTo.add("Kilojoule/kilogram -kJ/kg");
                        listtempTo.add("Calorie (IT)/gram -cal/g");
                        listtempTo.add("Calorie (th)/gram -cal(th)/g");
                        listtempTo.add("Btu (IT)/pound -Btu/lb");
                        listtempTo.add("Btu (th)/pound -Btu(th)/lb");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Joule/kilogram -J/kg");
                        listtempfrom.add("Kilojoule/kilogram -kJ/kg");
                        listtempfrom.add("Calorie (IT)/gram -cal/g");
                        listtempfrom.add("Calorie (th)/gram -cal(th)/g");
                        listtempfrom.add("Btu (IT)/pound -Btu/lb");
                        listtempfrom.add("Btu (th)/pound -Btu(th)/lb");
                        listtempfrom.add("Kilogram/joule -kg/T");
                        listtempfrom.add("Kilogram/kilojoule -kg/kJ");
                        listtempfrom.add("Gram/calorie (IT) -g/cal");
                        listtempfrom.add("Gram/calorie (th) -g/cal(th)");
                        listtempfrom.add("Pound/Btu (IT) -lb/Btu");
                        listtempfrom.add("Pound/Btu (th) -lb/Btu(th)");
                        listtempfrom.add("Pound/horsepower/hour -lb/hp/h");
                        listtempfrom.add("Gram/horsepower (metric)/hour -g/hp/h");
                        listtempfrom.add("Gram/kilowatt/hour -g/kW/h");


                        //second spinner
                        listtempTo.add("Joule/kilogram -J/kg");
                        listtempTo.add("Kilojoule/kilogram -kJ/kg");
                        listtempTo.add("Calorie (IT)/gram -cal/g");
                        listtempTo.add("Calorie (th)/gram -cal(th)/g");
                        listtempTo.add("Btu (IT)/pound -Btu/lb");
                        listtempTo.add("Btu (th)/pound -Btu(th)/lb");
                        listtempTo.add("Kilogram/joule -kg/T");
                        listtempTo.add("Kilogram/kilojoule -kg/kJ");
                        listtempTo.add("Gram/calorie (IT) -g/cal");
                        listtempTo.add("Gram/calorie (th) -g/cal(th)");
                        listtempTo.add("Pound/Btu (IT) -lb/Btu");
                        listtempTo.add("Pound/Btu (th) -lb/Btu(th)");
                        listtempTo.add("Pound/horsepower/hour -lb/hp/h");
                        listtempTo.add("Gram/horsepower (metric)/hour -g/hp/h");
                        listtempTo.add("Gram/kilowatt/hour -g/kW/h");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(FuelEfficiencyMassActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(FuelEfficiencyMassActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionFuelEfficiencyMassListActivity.class);
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

            FuelEfficiencyMassConverter c = new FuelEfficiencyMassConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<FuelEfficiencyMassConverter.ConversionResults> results = c.calculateFuelEfficiencyMassConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strjouleperkilogram=String.valueOf(formatter.format(item.getJouleperkilogram()));
                strkilojouleperkilogram=String.valueOf(formatter.format(item.getKilojouleperkilogram()));
                strcalorieITpergram=String.valueOf(formatter.format(item.getCalorieITpergram()));
                strcaloriethpergram=String.valueOf(formatter.format(item.getCaloriethpergram()));
                strBtuITperpound=String.valueOf(formatter.format(item.getBtuITperpound()));
                strBtuthperpound=String.valueOf(formatter.format(item.getBtuthperpound()));
                strkilogramperjoule=String.valueOf(formatter.format(item.getKilogramperjoule()));
                strkilogramperkilojoule=String.valueOf(formatter.format(item.getKilogramperkilojoule()));
                strgrampercalorieIT=String.valueOf(formatter.format(item.getGrampercalorieIT()));
                strgrampercalorieth=String.valueOf(formatter.format(item.getGrampercalorieth()));
                strpoundperBtuIT=String.valueOf(formatter.format(item.getPoundperBtuIT()));
                strpoundperBtuth=String.valueOf(formatter.format(item.getPoundperBtuth()));
                strpoundperhorsepowerperhour=String.valueOf(formatter.format(item.getPoundperhorsepowerperhour()));
                strgramperhorsepowermetricperhour=String.valueOf(formatter.format(item.getGramperhorsepowermetricperhour()));
                strgramperkilowattperhour=String.valueOf(formatter.format(item.getGramperkilowattperhour()));


                switch (strSpinnerFromvalue1) {
                    case "Joule/kilogram -J/kg":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilojoule/kilogram -kJ/kg":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (IT)/gram -cal/g":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Calorie (th)/gram -cal(th)/g":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (IT)/pound -Btu/lb":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Btu (th)/pound -Btu(th)/lb":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram/joule -kg/T":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram/kilojoule -kg/kJ":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram/calorie (IT) -g/cal":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram/calorie (th) -g/cal(th)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound/Btu (IT) -lb/Btu":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound/Btu (th) -lb/Btu(th)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound/horsepower/hour -lb/hp/h":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram/horsepower (metric)/hour -g/hp/h":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram/kilowatt/hour -g/kW/h":
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
            case "Joule/kilogram -J/kg":
                editTextValueTo.setText(strjouleperkilogram);
                break;
            case "Kilojoule/kilogram -kJ/kg":
                editTextValueTo.setText(strkilojouleperkilogram
                );
                break;
            case "Calorie (IT)/gram -cal/g":
                editTextValueTo.setText(strcalorieITpergram);
                break;
            case "Calorie (th)/gram -cal(th)/g":
                editTextValueTo.setText(strcaloriethpergram);
                break;
            case "Btu (IT)/pound -Btu/lb":
                editTextValueTo.setText(strBtuITperpound);
                break;
            case "Btu (th)/pound -Btu(th)/lb":
                editTextValueTo.setText(strBtuthperpound);
                break;
            case "Kilogram/joule -kg/T":
                editTextValueTo.setText(strkilogramperjoule);
                break;
            case "Kilogram/kilojoule -kg/kJ":
                editTextValueTo.setText(strkilogramperkilojoule);
                break;
            case "Gram/calorie (IT) -g/cal":
                editTextValueTo.setText(strgrampercalorieIT);
                break;
            case "Gram/calorie (th) -g/cal(th)":
                editTextValueTo.setText(strgrampercalorieth);
                break;
            case "Pound/Btu (IT) -lb/Btu":
                editTextValueTo.setText(strpoundperBtuIT);
                break;
            case "Pound/Btu (th) -lb/Btu(th)":
                editTextValueTo.setText(strpoundperBtuth);
                break;
            case "Pound/horsepower/hour -lb/hp/h":
                editTextValueTo.setText(strpoundperhorsepowerperhour);
                break;
            case "Gram/horsepower (metric)/hour -g/hp/h":
                editTextValueTo.setText(strgramperhorsepowermetricperhour);
                break;
            case "Gram/kilowatt/hour -g/kW/h":
                editTextValueTo.setText(strgramperkilowattperhour);
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