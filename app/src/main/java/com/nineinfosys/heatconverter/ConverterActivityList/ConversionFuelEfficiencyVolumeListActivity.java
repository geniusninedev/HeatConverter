package com.nineinfosys.heatconverter.ConverterActivityList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.heatconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.heatconverter.Engin.FuelEfficiencyVolumeConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemList;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionFuelEfficiencyVolumeListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;
    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;
   private String strjoulepercubicmeter=null,strjouleperliter=null,strmegajoulepercubicmeter=null,strkilojoulepercubicmeter=null,strkilocalorieITpercubicmeter=null,strcalorieITpercubiccentimeter =null,
            strthermpercubicfoot=null,strthermpergallonUK=null,strBtuITpercubicfoot=null,strBtuthpercubicfoot=null,strCHUpercubicfoot=null,strcubicmeterperjoule=null,
            strliterperjoule=null,strgallonUSperhorsepower=null,strgallonUKperhorsepower=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionFuelEfficiencyVolumeListActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverterList);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        edittextConversionListvalue=(EditText)findViewById(R.id.edittextConversionListvalue) ;
        textconversionFrom=(TextView) findViewById(R.id.textViewConversionFrom) ;
        textViewConversionShortform=(TextView) findViewById(R.id.textViewConversionShortform) ;

        //get the value from temperture activity
        stringSpinnerFrom = getIntent().getExtras().getString("stringSpinnerFrom");
        doubleEdittextvalue= getIntent().getExtras().getDouble("doubleEdittextvalue");
        edittextConversionListvalue.setText(String.valueOf(doubleEdittextvalue));

        NamesAndShortform(stringSpinnerFrom);

        //   Toast.makeText(this,"string1 "+stringSpinnerFrom,Toast.LENGTH_LONG).show();
        rowListItem = getAllunitValue(stringSpinnerFrom,doubleEdittextvalue);

        //Initializing Views
        rView = (RecyclerView) findViewById(R.id.recyclerViewConverterList);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(this, 1));


        //Initializing our superheroes list
        rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem);
        rView.setAdapter(rcAdapter);

        edittextConversionListvalue.addTextChangedListener(this);



    }

    private void NamesAndShortform(String stringSpinnerFrom) {
        switch (stringSpinnerFrom) {
            case "Joule/cubic meter -J/m^3":
                textconversionFrom.setText("Joule/cubic meter ");                 textViewConversionShortform.setText("J/m^3");
                break;
            case "Joule/liter -J/L":
                textconversionFrom.setText("Joule/liter ");                 textViewConversionShortform.setText("J/L");
                break;
            case "Megajoule/cubic meter -mJ/m^3":
                textconversionFrom.setText("Megajoule/cubic meter ");                 textViewConversionShortform.setText("mJ/m^3");
                break;
            case "Kilojoule/cubic meter -kJ/m^3":
                textconversionFrom.setText("Kilojoule/cubic meter ");                 textViewConversionShortform.setText("kJ/m^3");
                break;
            case "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3":
                textconversionFrom.setText("Kilocalorie (IT)/cubic meter ");                 textViewConversionShortform.setText("kcal(IT)/m^3");
                break;
            case "Calorie (IT)/cubic centimeter -cal(IT)/cm^3":
                textconversionFrom.setText("Calorie (IT)/cubic centimeter ");                 textViewConversionShortform.setText("cal(IT)/cm^3");
                break;
            case "Therm/cubic foot -therm/ft^3":
                textconversionFrom.setText("Therm/cubic foot ");                 textViewConversionShortform.setText("therm/ft^3");
                break;
            case "Therm/gallon (UK) -therm/gal":
                textconversionFrom.setText("Therm/gallon (UK) ");                 textViewConversionShortform.setText("therm/gal");
                break;
            case "Btu (IT)/cubic foot -Btu/ft^3":
                textconversionFrom.setText("Btu (IT)/cubic foot ");                 textViewConversionShortform.setText("Btu/ft^3");
                break;
            case "Btu (th)/cubic foot -Btu (th)/ft^3":
                textconversionFrom.setText("Btu (th)/cubic foot ");                 textViewConversionShortform.setText("Btu (th)/ft^3");
                break;
            case "CHU/cubic foot -CHU/ft^3":
                textconversionFrom.setText("CHU/cubic foot ");                 textViewConversionShortform.setText("CHU/ft^3");
                break;
            case "Cubic meter/joule -m^3/J":
                textconversionFrom.setText("Cubic meter/joule ");                 textViewConversionShortform.setText("m^3/J");
                break;
            case "Liter/joule -L/J":
                textconversionFrom.setText("Liter/joule ");                 textViewConversionShortform.setText("L/J");
                break;
            case "Gallon (US)/horsepower -gal(US)/hp":
                textconversionFrom.setText("Gallon (US)/horsepower ");                 textViewConversionShortform.setText("gal(US)/hp");
                break;
            case "Gallon (UK)/horsepower -gal(UK)/hp":
                textconversionFrom.setText("Gallon (UK)/horsepower ");                 textViewConversionShortform.setText("gal(UK)/hp");
                break;
        }
    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String  FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        String DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"2");
        Settings settings=new Settings(FormattedString,DecimalplaceString);
        formatter= settings.setting();
    }

    private List<ItemList> getAllunitValue(String strSpinnerFrom,double doubleEdittextvalue1) {

        FuelEfficiencyVolumeConverter c = new  FuelEfficiencyVolumeConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<FuelEfficiencyVolumeConverter.ConversionResults> results = c.calculateFuelEfficiencyVolumeConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            FuelEfficiencyVolumeConverter.ConversionResults item = results.get(i);



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


            list.add(new ItemList("J/m^3","Joule/cubic meter ",strjoulepercubicmeter,"J/m^3"));
            list.add(new ItemList("J/L","Joule/liter ",strjouleperliter,"J/L"));
            list.add(new ItemList("mJ/m^3","Megajoule/cubic meter ",strmegajoulepercubicmeter,"mJ/m^3"));
            list.add(new ItemList("kJ/m^3","Kilojoule/cubic meter ",strkilojoulepercubicmeter,"kJ/m^3"));
            list.add(new ItemList("kcal(IT)/m^3","Kilocalorie (IT)/cubic meter ",strkilocalorieITpercubicmeter,"kcal(IT)/m^3"));
            list.add(new ItemList("cal(IT)/cm^3","Calorie (IT)/cubic centimeter ",strcalorieITpercubiccentimeter,"cal(IT)/cm^3"));
            list.add(new ItemList("therm/ft^3","Therm/cubic foot ",strthermpercubicfoot,"therm/ft^3"));
            list.add(new ItemList("therm/gal","Therm/gallon (UK) ",strthermpergallonUK,"therm/gal"));
            list.add(new ItemList("Btu/ft^3","Btu (IT)/cubic foot ",strBtuITpercubicfoot,"Btu/ft^3"));
            list.add(new ItemList("Btu (th)/ft^3","Btu (th)/cubic foot ",strBtuthpercubicfoot,"Btu (th)/ft^3"));
            list.add(new ItemList("CHU/ft^3","CHU/cubic foot ",strCHUpercubicfoot,"CHU/ft^3"));
            list.add(new ItemList("m^3/J","Cubic meter/joule ",strcubicmeterperjoule,"m^3/J"));
            list.add(new ItemList("L/J","Liter/joule ",strliterperjoule,"L/J"));
            list.add(new ItemList("gal(US)/hp","Gallon (US)/horsepower ",strgallonUSperhorsepower,"gal(US)/hp"));
            list.add(new ItemList("gal(UK)/hp","Gallon (UK)/horsepower ",strgallonUKperhorsepower,"gal(UK)/hp"));
            



        }
        return list;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        rowListItem.clear();
        try {

           double value = Double.parseDouble(edittextConversionListvalue.getText().toString().trim());

            rowListItem1 = getAllunitValue(stringSpinnerFrom,value);


            rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem1);
            rView.setAdapter(rcAdapter);

        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
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

