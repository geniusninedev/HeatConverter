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
import com.nineinfosys.heatconverter.Engin.HeatFluxDensityConverter;
import com.nineinfosys.heatconverter.R;
import com.nineinfosys.heatconverter.Supporter.ItemList;
import com.nineinfosys.heatconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionHeatFluxDensityListActivity extends AppCompatActivity implements TextWatcher {

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

  private   String strwattpersquaremeter=null,strkilowattpersquaremeter=null,strwattpersquarecentimeter=null,strwattpersquareinch=null,strjoulepersecondpersquaremeter=null,
            strkilocalorieITperhourpersquaremeter =null,strkilocalorieITperhourpersquarefoot=null,strcalorieITpersecondpersquarecentimeter=null,strcalorieITperminutepersquarecentimeter=null,
            strcalorieITperhourpersquarecentimeter=null,strcaloriethpersecondpersquarecentimeter =null,strcaloriethperminutepersquarecentimeter=null,strcaloriethperhourpersquarecentimeter=null,
            strdyneperhourpercentimeter=null,strergperhourpersquaremillimeter=null,strfootpoundperminutepersquarefoot =null,strhorsepowerpersquarefoot=null,strhorsepowermetricpersquarefoot=null,
            strBtuITpersecondpersquarefoot=null,strBtuITperminutepersquarefoot=null,strBtuITperhourpersquarefoot=null,strBtuthpersecondpersquareinch=null,strBtuthpersecondpersquarefoot=null,
            strBtuthperminutepersquarefoot=null,strBtuthperhourpersquarefoot=null,strCHUperhourpersquarefoot=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e5b526")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#af8600"));
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
            case "Watt/square meter -W/m^2":
                textconversionFrom.setText("Watt/square meter ");                 textViewConversionShortform.setText("W/m^2");
                break;
            case "Kilowatt/square meter -kW/m^2":
                textconversionFrom.setText("Kilowatt/square meter ");                 textViewConversionShortform.setText("kW/m^2");
                break;
            case "Watt/square centimeter -W/cm^2":
                textconversionFrom.setText("Watt/square centimeter ");                 textViewConversionShortform.setText("W/cm^2");
                break;
            case "Watt/square inch -W/in^2":
                textconversionFrom.setText("Watt/square inch ");                 textViewConversionShortform.setText("W/in^2");
                break;
            case "Joule/second/square meter -Js/m^2":
                textconversionFrom.setText("Joule/second/square meter ");                 textViewConversionShortform.setText("Js/m^2");
                break;
            case "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2":
                textconversionFrom.setText("Kilocalorie (IT)/hour/square meter ");                 textViewConversionShortform.setText("kcal(IT)h/m^2");
                break;
            case  "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2":
                textconversionFrom.setText("Kilocalorie (IT)/hour/square foot ");                 textViewConversionShortform.setText("kcal(IT)h/ft^2");
                break;
            case "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2":
                textconversionFrom.setText("Calorie (IT)/second/square centimeter ");                 textViewConversionShortform.setText("cal(IT)s/cm^2");
                break;
            case "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2":
                textconversionFrom.setText("Calorie (IT)/minute/square centimeter ");                 textViewConversionShortform.setText("cal(IT)min/cm^2");
                break;
            case "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2":
                textconversionFrom.setText("Calorie (IT)/hour/square centimeter ");                 textViewConversionShortform.setText("cal(IT)h/cm^2");
                break;
            case "Calorie (th)/second/square centimeter -cal(th)s/cm^2":
                textconversionFrom.setText("Calorie (th)/second/square centimeter ");                 textViewConversionShortform.setText("cal(th)s/cm^2");
                break;
            case "Calorie (th)/minute/square centimeter -cal(th)min/cm^2":
                textconversionFrom.setText("Calorie (th)/minute/square centimeter ");                 textViewConversionShortform.setText("cal(th)min/cm^2");
                break;
            case "Calorie (th)/hour/square centimeter -cal(th)h/cm^2":
                textconversionFrom.setText("Calorie (th)/hour/square centimeter ");                 textViewConversionShortform.setText("cal(th)h/cm^2");
                break;
            case "Dyne/hour/centimeter -dynh/cm":
                textconversionFrom.setText("Dyne/hour/centimeter ");                 textViewConversionShortform.setText("dynh/cm");
                break;
            case "Erg/hour/square millimeter -ergh/mm^2":
                textconversionFrom.setText("Erg/hour/square millimeter ");                 textViewConversionShortform.setText("ergh/mm^2");
                break;
            case "Foot pound/minute/square foot -ftlbmin/ft^2":
                textconversionFrom.setText("Foot pound/minute/square foot ");                 textViewConversionShortform.setText("ftlbmin/ft^2");
                break;
            case "Horsepower/square foot -hp/ft^2":
                textconversionFrom.setText("Horsepower/square foot ");                 textViewConversionShortform.setText("hp/ft^2");
                break;
            case "Horsepower (metric)/square foot -hp/ft^2":
                textconversionFrom.setText("Horsepower (metric)/square foot ");                 textViewConversionShortform.setText("hp/ft^2");
                break;
            case "Btu (IT)/second/square foot -Btu(IT)s/ft^2":
                textconversionFrom.setText("Btu (IT)/second/square foot ");                 textViewConversionShortform.setText("Btu(IT)s/ft^2");
                break;
            case "Btu (IT)/minute/square foot -Btu(IT)min/ft^2":
                textconversionFrom.setText("Btu (IT)/minute/square foot ");                 textViewConversionShortform.setText("Btu(IT)min/ft^2");
                break;
            case "Btu (IT)/hour/square foot -Btu(IT)h/ft^2":
                textconversionFrom.setText("Btu (IT)/hour/square foot ");                 textViewConversionShortform.setText("Btu(IT)h/ft^2");
                break;
            case "Btu (th)/second/square inch -Btu(th)s/in^2":
                textconversionFrom.setText("Btu (th)/second/square inch ");                 textViewConversionShortform.setText("Btu(th)s/in^2");
                break;
            case "Btu (th)/second/square foot -Btu(th)s/ft^2":
                textconversionFrom.setText("Btu (th)/second/square foot ");                 textViewConversionShortform.setText("Btu(th)s/ft^2");
                break;
            case "Btu (th)/minute/square foot -Btu(th)min/ft^2":
                textconversionFrom.setText("Btu (th)/minute/square foot ");                 textViewConversionShortform.setText("Btu(th)min/ft^2");
                break;
            case "Btu (th)/hour/square foot -Btu(th)h/ft^2":
                textconversionFrom.setText("Btu (th)/hour/square foot ");                 textViewConversionShortform.setText("Btu(th)h/ft^2");
                break;
            case "CHU/hour/square foot -CHUh/ft^2":
                textconversionFrom.setText("CHU/hour/square foot ");                 textViewConversionShortform.setText("CHUh/ft^2");
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

        HeatFluxDensityConverter c = new HeatFluxDensityConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<HeatFluxDensityConverter.ConversionResults> results = c.calculateHeatFluxDensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            HeatFluxDensityConverter.ConversionResults item = results.get(i);


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



            list.add(new ItemList("W/m^2","Watt/square meter ",strwattpersquaremeter,"W/m^2"));
            list.add(new ItemList("kW/m^2","Kilowatt/square meter ",strkilowattpersquaremeter,"kW/m^2"));
            list.add(new ItemList("W/cm^2","Watt/square centimeter ",strwattpersquarecentimeter,"W/cm^2"));
            list.add(new ItemList("W/in^2","Watt/square inch ",strwattpersquareinch,"W/in^2"));
            list.add(new ItemList("Js/m^2","Joule/second/square meter ",strjoulepersecondpersquaremeter,"Js/m^2"));
            list.add(new ItemList("kcal(IT)h/m^2","Kilocalorie (IT)/hour/square meter ",strkilocalorieITperhourpersquaremeter,"kcal(IT)h/m^2"));
            list.add(new ItemList("kcal(IT)h/ft^2","Kilocalorie (IT)/hour/square foot ",strkilocalorieITperhourpersquarefoot,"kcal(IT)h/ft^2"));
            list.add(new ItemList("cal(IT)s/cm^2","Calorie (IT)/second/square centimeter ",strcalorieITpersecondpersquarecentimeter,"cal(IT)s/cm^2"));
            list.add(new ItemList("cal(IT)min/cm^2","Calorie (IT)/minute/square centimeter ",strcalorieITperminutepersquarecentimeter,"cal(IT)min/cm^2"));
            list.add(new ItemList("cal(IT)h/cm^2","Calorie (IT)/hour/square centimeter ",strcalorieITperhourpersquarecentimeter,"cal(IT)h/cm^2"));
            list.add(new ItemList("cal(th)s/cm^2","Calorie (th)/second/square centimeter ",strcaloriethpersecondpersquarecentimeter,"cal(th)s/cm^2"));
            list.add(new ItemList("cal(th)min/cm^2","Calorie (th)/minute/square centimeter ",strcaloriethperminutepersquarecentimeter,"cal(th)min/cm^2"));
            list.add(new ItemList("cal(th)h/cm^2","Calorie (th)/hour/square centimeter ",strcaloriethperhourpersquarecentimeter,"cal(th)h/cm^2"));
            list.add(new ItemList("dynh/cm","Dyne/hour/centimeter ",strdyneperhourpercentimeter,"dynh/cm"));
            list.add(new ItemList("ergh/mm^2","Erg/hour/square millimeter ",strergperhourpersquaremillimeter,"ergh/mm^2"));
            list.add(new ItemList("ftlbmin/ft^2","Foot pound/minute/square foot ",strfootpoundperminutepersquarefoot,"ftlbmin/ft^2"));
            list.add(new ItemList("hp/ft^2","Horsepower/square foot ",strhorsepowerpersquarefoot,"hp/ft^2"));
            list.add(new ItemList("hp/ft^2","Horsepower (metric)/square foot ",strhorsepowermetricpersquarefoot,"hp/ft^2"));
            list.add(new ItemList("Btu(IT)s/ft^2","Btu (IT)/second/square foot ",strBtuITpersecondpersquarefoot,"Btu(IT)s/ft^2"));
            list.add(new ItemList("Btu(IT)min/ft^2","Btu (IT)/minute/square foot ",strBtuITperminutepersquarefoot,"Btu(IT)min/ft^2"));
            list.add(new ItemList("Btu(IT)h/ft^2","Btu (IT)/hour/square foot ",strBtuITperhourpersquarefoot,"Btu(IT)h/ft^2"));
            list.add(new ItemList("Btu(th)s/in^2","Btu (th)/second/square inch ",strBtuthpersecondpersquareinch,"Btu(th)s/in^2"));
            list.add(new ItemList("Btu(th)s/ft^2","Btu (th)/second/square foot ",strBtuthpersecondpersquarefoot,"Btu(th)s/ft^2"));
            list.add(new ItemList("Btu(th)min/ft^2","Btu (th)/minute/square foot ",strBtuthperminutepersquarefoot,"Btu(th)min/ft^2"));
            list.add(new ItemList("Btu(th)h/ft^2","Btu (th)/hour/square foot ",strBtuthperhourpersquarefoot,"Btu(th)h/ft^2"));
            list.add(new ItemList("CHUh/ft^2","CHU/hour/square foot ",strCHUperhourpersquarefoot,"CHUh/ft^2"));



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


