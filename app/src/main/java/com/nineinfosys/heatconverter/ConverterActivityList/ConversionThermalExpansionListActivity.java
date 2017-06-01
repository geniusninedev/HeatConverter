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
import com.nineinfosys.heatconverter.Engin.ThermalExpansionConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemList;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionThermalExpansionListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;
    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    private String strlengthperlengthperkelvin=null,strlengthperlengthperdegreeCelsius=null,strlengthperlengthperdegreeFahrenheit=null,strlengthperlengthperdegreeRankine=null,
            strlengthperlengthperdegreeReaumur=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#237b27")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#FF144E17"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionThermalExpansionListActivity.this, getString(R.string.ads_app_id));
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
            case "Length/length/kelvin -1/K":
                textconversionFrom.setText("Length/length/kelvin ");                 textViewConversionShortform.setText("1/K");
                break;
            case "Length/length/degree Celsius -1/°C":
                textconversionFrom.setText("Length/length/degree Celsius ");                 textViewConversionShortform.setText("1/°C");
                break;
            case "Length/length/degree Fahrenheit -1/°F":
                textconversionFrom.setText("Length/length/degree Fahrenheit ");                 textViewConversionShortform.setText("1/°F");
                break;
            case "Length/length/degree Rankine -1/R°":
                textconversionFrom.setText("Length/length/degree Rankine ");                 textViewConversionShortform.setText("1/R°");
                break;
            case "Length/length/degree Reaumur -1/r°":
                textconversionFrom.setText("Length/length/degree Reaumur ");                 textViewConversionShortform.setText("1/r°");
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

        ThermalExpansionConverter c = new  ThermalExpansionConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<ThermalExpansionConverter.ConversionResults> results = c.calculateThermalExpansionConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ThermalExpansionConverter.ConversionResults item = results.get(i);

            strlengthperlengthperkelvin=String.valueOf(formatter.format(item.getLengthperlengthperkelvin()));
            strlengthperlengthperdegreeCelsius=String.valueOf(formatter.format(item.getLengthperlengthperdegreeCelsius()));
            strlengthperlengthperdegreeFahrenheit=String.valueOf(formatter.format(item.getLengthperlengthperdegreeFahrenheit()));
            strlengthperlengthperdegreeRankine=String.valueOf(formatter.format(item.getLengthperlengthperdegreeRankine()));
            strlengthperlengthperdegreeReaumur=String.valueOf(formatter.format(item.getLengthperlengthperdegreeReaumur()));


            list.add(new ItemList("1/K","Length/length/kelvin ",strlengthperlengthperkelvin,"1/K"));
            list.add(new ItemList("1/°C","Length/length/degree Celsius ",strlengthperlengthperdegreeCelsius,"1/°C"));
            list.add(new ItemList("1/°F","Length/length/degree Fahrenheit ",strlengthperlengthperdegreeFahrenheit,"1/°F"));
            list.add(new ItemList("1/R°","Length/length/degree Rankine ",strlengthperlengthperdegreeRankine,"1/R°"));
            list.add(new ItemList("1/r°","Length/length/degree Reaumur ",strlengthperlengthperdegreeReaumur,"1/r°"));

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

