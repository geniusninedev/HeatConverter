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
import com.nineinfosys.heatconverter.Engin.FuelEfficiencyMassConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemList;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionFuelEfficiencyMassListActivity extends AppCompatActivity implements TextWatcher {

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

    private String strjouleperkilogram=null,strkilojouleperkilogram=null,strcalorieITpergram=null,strcaloriethpergram=null,strBtuITperpound=null,strBtuthperpound =null,strkilogramperjoule=null,
            strkilogramperkilojoule=null,strgrampercalorieIT=null,strgrampercalorieth=null,strpoundperBtuIT=null,strpoundperBtuth=null, strpoundperhorsepowerperhour=null,
            strgramperhorsepowermetricperhour=null,strgramperkilowattperhour=null;

    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#707070"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionFuelEfficiencyMassListActivity.this, getString(R.string.ads_app_id));
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
            case "Joule/kilogram -J/kg":
                textconversionFrom.setText("Joule/kilogram ");                 textViewConversionShortform.setText("J/kg");
                break;
            case "Kilojoule/kilogram -kJ/kg":
                textconversionFrom.setText("Kilojoule/kilogram ");                 textViewConversionShortform.setText("kJ/kg");
                break;
            case "Calorie (IT)/gram -cal/g":
                textconversionFrom.setText("Calorie (IT)/gram ");                 textViewConversionShortform.setText("cal/g");
                break;
            case "Calorie (th)/gram -cal(th)/g":
                textconversionFrom.setText("Calorie (th)/gram ");                 textViewConversionShortform.setText("cal(th)/g");
                break;
            case "Btu (IT)/pound -Btu/lb":
                textconversionFrom.setText("Btu (IT)/pound ");                 textViewConversionShortform.setText("Btu/lb");
                break;
            case "Btu (th)/pound -Btu(th)/lb":
                textconversionFrom.setText("Btu (th)/pound ");                 textViewConversionShortform.setText("Btu(th)/lb");
                break;
            case "Kilogram/joule -kg/T":
                textconversionFrom.setText("Kilogram/joule ");                 textViewConversionShortform.setText("kg/T");
                break;
            case "Kilogram/kilojoule -kg/kJ":
                textconversionFrom.setText("Kilogram/kilojoule ");                 textViewConversionShortform.setText("kg/kJ");
                break;
            case "Gram/calorie (IT) -g/cal":
                textconversionFrom.setText("Gram/calorie (IT) ");                 textViewConversionShortform.setText("g/cal");
                break;
            case "Gram/calorie (th) -g/cal(th)":
                textconversionFrom.setText("Gram/calorie (th) ");                 textViewConversionShortform.setText("g/cal(th)");
                break;
            case "Pound/Btu (IT) -lb/Btu":
                textconversionFrom.setText("Pound/Btu (IT) ");                 textViewConversionShortform.setText("lb/Btu");
                break;
            case "Pound/Btu (th) -lb/Btu(th)":
                textconversionFrom.setText("Pound/Btu (th) ");                 textViewConversionShortform.setText("lb/Btu(th)");
                break;
            case "Pound/horsepower/hour -lb/hp/h":
                textconversionFrom.setText("Pound/horsepower/hour ");                 textViewConversionShortform.setText("lb/hp/h");
                break;
            case "Gram/horsepower (metric)/hour -g/hp/h":
                textconversionFrom.setText("Gram/horsepower (metric)/hour ");                 textViewConversionShortform.setText("g/hp/h");
                break;
            case "Gram/kilowatt/hour -g/kW/h":
                textconversionFrom.setText("Gram/kilowatt/hour ");                 textViewConversionShortform.setText("g/kW/h");
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

        FuelEfficiencyMassConverter c = new  FuelEfficiencyMassConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<FuelEfficiencyMassConverter.ConversionResults> results = c.calculateFuelEfficiencyMassConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            FuelEfficiencyMassConverter.ConversionResults item = results.get(i);



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

            list.add(new ItemList("J/kg","Joule/kilogram ",strjouleperkilogram,"J/kg"));
            list.add(new ItemList("kJ/kg","Kilojoule/kilogram ",strkilojouleperkilogram,"kJ/kg"));
            list.add(new ItemList("cal/g","Calorie (IT)/gram ",strcalorieITpergram,"cal/g"));
            list.add(new ItemList("cal(th)/g","Calorie (th)/gram ",strcaloriethpergram,"cal(th)/g"));
            list.add(new ItemList("Btu/lb","Btu (IT)/pound ",strBtuITperpound,"Btu/lb"));
            list.add(new ItemList("Btu(th)/lb","Btu (th)/pound ",strBtuthperpound,"Btu(th)/lb"));
            list.add(new ItemList("kg/T","Kilogram/joule ",strkilogramperjoule,"kg/T"));
            list.add(new ItemList("kg/kJ","Kilogram/kilojoule ",strkilogramperkilojoule,"kg/kJ"));
            list.add(new ItemList("g/cal","Gram/calorie (IT) ",strgrampercalorieIT,"g/cal"));
            list.add(new ItemList("g/cal(th)","Gram/calorie (th) ",strgrampercalorieth,"g/cal(th)"));
            list.add(new ItemList("lb/Btu","Pound/Btu (IT) ",strpoundperBtuIT,"lb/Btu"));
            list.add(new ItemList("lb/Btu(th)","Pound/Btu (th) ",strpoundperBtuth,"lb/Btu(th)"));
            list.add(new ItemList("lb/hp/h","Pound/horsepower/hour ",strpoundperhorsepowerperhour,"lb/hp/h"));
            list.add(new ItemList("g/hp/h","Gram/horsepower (metric)/hour ",strgramperhorsepowermetricperhour,"g/hp/h"));
            list.add(new ItemList("g/kW/h","Gram/kilowatt/hour ",strgramperkilowattperhour,"g/kW/h"));



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


