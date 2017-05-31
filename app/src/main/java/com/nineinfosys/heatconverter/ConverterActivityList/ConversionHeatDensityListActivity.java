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


import com.nineinfosys.heatconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.heatconverter.Engin.HeatDensityConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemList;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionHeatDensityListActivity extends AppCompatActivity implements TextWatcher {

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
    private String strjoulesquaremeter=null,strcaloriethsquarecentimeter=null,strlangley=null,strBtuITsquarefoot=null,strBtuthsquarefoot=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e58f0c")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#FFB1700C"));
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
            case "Joule/square meter -J/m^2":
                textconversionFrom.setText("Joule/square meter ");                 textViewConversionShortform.setText("J/m^2");
                break;
            case "Calorie (th)/square centimeter -cal(th)/cm^2":
                textconversionFrom.setText("Calorie (th)/square centimeter ");                 textViewConversionShortform.setText("cal(th)/cm^2");
                break;
            case "Langley -lan":
                textconversionFrom.setText("Langley ");                 textViewConversionShortform.setText("lan");
                break;
            case "Btu (IT)/square foot -Btu(IT)/ft^2":
                textconversionFrom.setText("Btu (IT)/square foot ");                 textViewConversionShortform.setText("Btu(IT)/ft^2");
                break;
            case "Btu (th)/square foot -Btu(th)/ft^2":
                textconversionFrom.setText("Btu (th)/square foot ");                 textViewConversionShortform.setText("Btu(th)/ft^2");
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

        HeatDensityConverter c = new  HeatDensityConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<HeatDensityConverter.ConversionResults> results = c.calculateHeatDensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            HeatDensityConverter.ConversionResults item = results.get(i);

            strjoulesquaremeter=String.valueOf(formatter.format(item.getJoule()));
            strcaloriethsquarecentimeter=String.valueOf(formatter.format(item.getCalorie()));
            strlangley=String.valueOf(formatter.format(item.getLangley()));
            strBtuITsquarefoot=String.valueOf(formatter.format(item.getBtuit()));
            strBtuthsquarefoot=String.valueOf(formatter.format(item.getBtuth()));


            list.add(new ItemList("J/m^2","Joule/square meter ",strjoulesquaremeter,"J/m^2"));
            list.add(new ItemList("cal(th)/cm^2","Calorie (th)/square centimeter ",strcaloriethsquarecentimeter,"cal(th)/cm^2"));
            list.add(new ItemList("lan","Langley ",strlangley,"lan"));
            list.add(new ItemList("Btu(IT)/ft^2","Btu (IT)/square foot ",strBtuITsquarefoot,"Btu(IT)/ft^2"));
            list.add(new ItemList("Btu(th)/ft^2","Btu (th)/square foot ",strBtuthsquarefoot,"Btu(th)/ft^2"));



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
