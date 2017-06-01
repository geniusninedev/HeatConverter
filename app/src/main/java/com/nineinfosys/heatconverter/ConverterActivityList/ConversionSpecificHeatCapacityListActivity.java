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
import com.nineinfosys.heatconverter.Engin.SpecificHeatCapacityConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemList;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionSpecificHeatCapacityListActivity extends AppCompatActivity implements TextWatcher {

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

  private  String  strjoulekilogramK=null,strjoulekilogramC=null,strjoulegramC=null,strkilojoulekilogramK=null,strkilojoulekilogramC=null,strcalorieITgramC=null,strcalorieITgramF=null,
            strcaloriethgramC=null,strkilocalorieITkilogramC=null,strkilocaloriethkilogramC=null,strkilocalorieITkilogramK=null,strkilocaloriethkilogramK=null,
            strkilogramforcemeterkilogramK=null,strpoundforcefootpoundR=null,strBtuITpoundF=null,strBtuthpoundF=null,strBtuITpoundR=null,strBtuthpoundR=null,
            strBtuITpoundC=null,strCHUpoundC=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        MobileAds.initialize(ConversionSpecificHeatCapacityListActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverterList);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2eaf46")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007e17"));
        }

        //format of decimal pint
        formatsetting();


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
            case "Joule/kilogram/K -J/(kg*K)":
                textconversionFrom.setText("Joule/kilogram/K ");                 textViewConversionShortform.setText("J/(kg*K)");
                break;
            case "Joule/kilogram/°C -J/(kg*°C)":
                textconversionFrom.setText("Joule/kilogram/°C ");                 textViewConversionShortform.setText("J/(kg*°C)");
                break;
            case "Joule/gram/°C -J/(g*°C)":
                textconversionFrom.setText("Joule/gram/°C ");                 textViewConversionShortform.setText("J/(g*°C)");
                break;
            case "Kilojoule/kilogram/K -kJ/(kg*K)":
                textconversionFrom.setText("Kilojoule/kilogram/K ");                 textViewConversionShortform.setText("kJ/(kg*K)");
                break;
            case "Kilojoule/kilogram/°C -kJ/(kg*°C)":
                textconversionFrom.setText("Kilojoule/kilogram/°C ");                 textViewConversionShortform.setText("kJ/(kg*°C)");
                break;
            case "Calorie (IT)/gram/°C -cal(IT)/(g*°C)":
                textconversionFrom.setText("Calorie (IT)/gram/°C ");                 textViewConversionShortform.setText("cal(IT)/(g*°C)");
                break;
            case "Calorie (IT)/gram/°F -cal(IT)/(g*°F)":
                textconversionFrom.setText("Calorie (IT)/gram/°F ");                 textViewConversionShortform.setText("cal(IT)/(g*°F)");
                break;
            case "Calorie (th)/gram/°C -cal(th)/(g*°C)":
                textconversionFrom.setText("Calorie (th)/gram/°C ");                 textViewConversionShortform.setText("cal(th)/(g*°C)");
                break;
            case "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)":
                textconversionFrom.setText("Kilocalorie (IT)/kilogram/°C ");                 textViewConversionShortform.setText("kcal(IT)/(kg*°C)");
                break;
            case "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)":
                textconversionFrom.setText("Kilocalorie (th)/kilogram/°C ");                 textViewConversionShortform.setText("kcal(th)/(kg*°C)");
                break;
            case "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)":
                textconversionFrom.setText("Kilocalorie (IT)/kilogram/K ");                 textViewConversionShortform.setText("kcal(IT)/(kg*K)");
                break;
            case "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)":
                textconversionFrom.setText("Kilocalorie (th)/kilogram/K ");                 textViewConversionShortform.setText("kcal(th)/(kg*K)");
                break;
            case "Kilogram-force meter/kilogram/K -kgfm/(kg*K)":
                textconversionFrom.setText("Kilogram-force meter/kilogram/K ");                 textViewConversionShortform.setText("kgfm/(kg*K)");
                break;
            case "Pound-force foot/pound/°R -lbfft/(lb*°R)":
                textconversionFrom.setText("Pound-force foot/pound/°R ");                 textViewConversionShortform.setText("lbfft/(lb*°R)");
                break;
            case "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)":
                textconversionFrom.setText("Btu (IT)/pound/°F ");                 textViewConversionShortform.setText("Btu(IT)/(lb*°F)");
                break;
            case "Btu (th)/pound/°F -Btu(th)/(lb*°F)":
                textconversionFrom.setText("Btu (th)/pound/°F ");                 textViewConversionShortform.setText("Btu(th)/(lb*°F)");
                break;
            case "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)":
                textconversionFrom.setText("Btu (IT)/pound/°R ");                 textViewConversionShortform.setText("Btu(IT)/(lb*°R)");
                break;
            case "Btu (th)/pound/°R -Btu(th)/(lb*°R)":
                textconversionFrom.setText("Btu (th)/pound/°R ");                 textViewConversionShortform.setText("Btu(th)/(lb*°R)");
                break;
            case "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)":
                textconversionFrom.setText("Btu (IT)/pound/°C ");                 textViewConversionShortform.setText("Btu(IT)/(lb*°C)");
                break;
            case "CHU/pound/°C -CHU/(lb*°C)":
                textconversionFrom.setText("CHU/pound/°C ");                 textViewConversionShortform.setText("CHU/(lb*°C");
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

        SpecificHeatCapacityConverter c = new  SpecificHeatCapacityConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<SpecificHeatCapacityConverter.ConversionResults> results = c.calculateheatcapacityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            SpecificHeatCapacityConverter.ConversionResults item = results.get(i);


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



            list.add(new ItemList("J/(kg*K)","Joule/kilogram/K ",strjoulekilogramK,"J/(kg*K)"));
            list.add(new ItemList("J/(kg*°C)","Joule/kilogram/°C ",strjoulekilogramC,"J/(kg*°C)"));
            list.add(new ItemList("J/(g*°C)","Joule/gram/°C ",strjoulegramC,"J/(g*°C)"));
            list.add(new ItemList("kJ/(kg*K)","Kilojoule/kilogram/K ",strkilojoulekilogramK,"kJ/(kg*K)"));
            list.add(new ItemList("kJ/(kg*°C)","Kilojoule/kilogram/°C ",strkilojoulekilogramC,"kJ/(kg*°C)"));
            list.add(new ItemList("cal(IT)/(g*°C)","Calorie (IT)/gram/°C ",strcalorieITgramC,"cal(IT)/(g*°C)"));
            list.add(new ItemList("cal(IT)/(g*°F)","Calorie (IT)/gram/°F ",strcalorieITgramF,"cal(IT)/(g*°F)"));
            list.add(new ItemList("cal(th)/(g*°C)","Calorie (th)/gram/°C ",strcaloriethgramC,"cal(th)/(g*°C)"));
            list.add(new ItemList("kcal(IT)/(kg*°C)","Kilocalorie (IT)/kilogram/°C ",strkilocalorieITkilogramC,"kcal(IT)/(kg*°C)"));
            list.add(new ItemList("kcal(th)/(kg*°C)","Kilocalorie (th)/kilogram/°C ",strkilocaloriethkilogramC,"kcal(th)/(kg*°C)"));
            list.add(new ItemList("kcal(IT)/(kg*K)","Kilocalorie (IT)/kilogram/K ",strkilocalorieITkilogramK,"kcal(IT)/(kg*K)"));
            list.add(new ItemList("kcal(th)/(kg*K)","Kilocalorie (th)/kilogram/K ",strkilocaloriethkilogramK,"kcal(th)/(kg*K)"));
            list.add(new ItemList("kgfm/(kg*K)","Kilogram-force meter/kilogram/K ",strkilogramforcemeterkilogramK,"kgfm/(kg*K)"));
            list.add(new ItemList("lbfft/(lb*°R)","Pound-force foot/pound/°R ",strpoundforcefootpoundR,"lbfft/(lb*°R)"));
            list.add(new ItemList("Btu(IT)/(lb*°F)","Btu (IT)/pound/°F ",strBtuITpoundF,"Btu(IT)/(lb*°F)"));
            list.add(new ItemList("Btu(th)/(lb*°F)","Btu (th)/pound/°F ",strBtuthpoundF,"Btu(th)/(lb*°F)"));
            list.add(new ItemList("Btu(IT)/(lb*°R)","Btu (IT)/pound/°R ",strBtuITpoundR,"Btu(IT)/(lb*°R)"));
            list.add(new ItemList("Btu(th)/(lb*°R)","Btu (th)/pound/°R ",strBtuthpoundR,"Btu(th)/(lb*°R)"));
            list.add(new ItemList("Btu(IT)/(lb*°C)","Btu (IT)/pound/°C ",strBtuITpoundC,"Btu(IT)/(lb*°C)"));
            list.add(new ItemList("CHU/(lb*°C)","CHU/pound/°C ",strCHUpoundC,"CHU/(lb*°C)"));
            



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

