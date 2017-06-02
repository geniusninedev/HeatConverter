package com.nineinfosys.heatconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.nineinfosys.heatconverter.ConverterActivity.FuelEfficiencyMassActivity;
import com.nineinfosys.heatconverter.ConverterActivity.FuelEfficiencyVolumeActivity;
import com.nineinfosys.heatconverter.ConverterActivity.HeatDensityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.HeatFluxDensityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.HeatTransferCoefficientActivity;
import com.nineinfosys.heatconverter.ConverterActivity.SpecificHeatCapacityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.TemperatureIntervalActivity;
import com.nineinfosys.heatconverter.ConverterActivity.ThermalConductivityActivity;
import com.nineinfosys.heatconverter.ConverterActivity.ThermalExpansionActivity;
import com.nineinfosys.heatconverter.ConverterActivity.ThermalResistanceActivity;


public class SearchActivity extends AppCompatActivity implements TextWatcher {


    // List view
    private ListView lv;

    private String selectedItem;
    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Search By Unit");


        // Listview Data
        String listitem[] = {

                //fueleffiency mass
                "Joule/kilogram -J/kg",
                "Kilojoule/kilogram -kJ/kg",
                "Calorie (IT)/gram -cal/g",
                "Calorie (th)/gram -cal(th)/g",
                "Btu (IT)/pound -Btu/lb",
                "Btu (th)/pound -Btu(th)/lb",
                "Kilogram/joule -kg/T",
                "Kilogram/kilojoule -kg/kJ",
                "Gram/calorie (IT) -g/cal",
                "Gram/calorie (th) -g/cal(th)",
                "Pound/Btu (IT) -lb/Btu",
                "Pound/Btu (th) -lb/Btu(th)",
                "Pound/horsepower/hour -lb/hp/h",
                "Gram/horsepower (metric)/hour -g/hp/h",
                "Gram/kilowatt/hour -g/kW/h",

                //fueleffiency voulme
                "Joule/cubic meter -J/m^3",
                "Joule/liter -J/L",
                "Megajoule/cubic meter -mJ/m^3",
                "Kilojoule/cubic meter -kJ/m^3",
                "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3",
                "Calorie (IT)/cubic centimeter -cal(IT)/cm^3",
                "Therm/cubic foot -therm/ft^3",
                "Therm/gallon (UK) -therm/gal",
                "Btu (IT)/cubic foot -Btu/ft^3",
                "Btu (th)/cubic foot -Btu (th)/ft^3",
                "CHU/cubic foot -CHU/ft^3",
                "Cubic meter/joule -m^3/J",
                "Liter/joule -L/J",
                "Gallon (US)/horsepower -gal(US)/hp",
                "Gallon (UK)/horsepower -gal(UK)/hp",

                //heatdensity
                "Joule/square meter -J/m^2",
                "Calorie (th)/square centimeter -cal(th)/cm^2",
                "Langley -lan",
                "Btu (IT)/square foot -Btu(IT)/ft^2",
                "Btu (th)/square foot -Btu(th)/ft^2",

                //heatfluxdensity
                "Watt/square meter -W/m^2",
                "Kilowatt/square meter -kW/m^2",
                "Watt/square centimeter -W/cm^2",
                "Watt/square inch -W/in^2",
                "Joule/second/square meter -Js/m^2",
                "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2",
                "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2",
                "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2",
                "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2",
                "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2",
                "Calorie (th)/second/square centimeter -cal(th)s/cm^2",
                "Calorie (th)/minute/square centimeter -cal(th)min/cm^2",
                "Calorie (th)/hour/square centimeter -cal(th)h/cm^2",
                "Dyne/hour/centimeter -dynh/cm",
                "Erg/hour/square millimeter -ergh/mm^2",
                "Foot pound/minute/square foot -ftlbmin/ft^2",
                "Horsepower/square foot -hp/ft^2",
                "Horsepower (metric)/square foot -hp/ft^2",
                "Btu (IT)/second/square foot -Btu(IT)s/ft^2",
                "Btu (IT)/minute/square foot -Btu(IT)min/ft^2",
                "Btu (IT)/hour/square foot -Btu(IT)h/ft^2",
                "Btu (th)/second/square inch -Btu(th)s/in^2",
                "Btu (th)/second/square foot -Btu(th)s/ft^2",
                "Btu (th)/minute/square foot -Btu(th)min/ft^2",
                "Btu (th)/hour/square foot -Btu(th)h/ft^2",
                "CHU/hour/square foot -CHUh/ft^2",

                //heat transfer
                "Watt/square meter/K -W/m^2/K",
                "Watt/square meter/%b0C -W/m^2/%b0C",
                "Joule/second/square meter/K -J/s/m^2/K",
                "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C",
                "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C",
                "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C",
                "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F",
                "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F",
                "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F",
                "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F",
                "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C",

                //specific heat capacity
                "Joule/kilogram/K -J/(kg*K)",
                "Joule/kilogram/°C -J/(kg*°C)",
                "Joule/gram/°C -J/(g*°C)",
                "Kilojoule/kilogram/K -kJ/(kg*K)",
                "Kilojoule/kilogram/°C -kJ/(kg*°C)",
                "Calorie (IT)/gram/°C -cal(IT)/(g*°C)",
                "Calorie (IT)/gram/°F -cal(IT)/(g*°F)",
                "Calorie (th)/gram/°C -cal(th)/(g*°C)",
                "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)",
                "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)",
                "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)",
                "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)",
                "Kilogram-force meter/kilogram/K -kgfm/(kg*K)",
                "Pound-force foot/pound/°R -lbfft/(lb*°R)",
                "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)",
                "Btu (th)/pound/°F -Btu(th)/(lb*°F)",
                "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)",
                "Btu (th)/pound/°R -Btu(th)/(lb*°R)",
                "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)",
                "CHU/pound/°C -CHU/(lb*°C)",

                //tempertureinterval
                "Kelvin -K",
                "Degree Celsius -°C",
                "Degree centigrade -°C",
                "Degree Fahrenheit -°F",
                "Degree Rankine -°R",
                "Degree Reaumur -°r",

                //thermalconductivity
                "Watt/meter/K -W/(m*K)",
                "Watt/centimeter/°C -W/(cm*°C)",
                "Kilowatt/meter/K -kW/(m*K)",
                "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)",
                "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)",
                "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)",
                "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)",
                "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)",
                "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)",
                "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)",
                "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)",
                "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)",
                "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)",

                //thermal expansion
                "Length/length/kelvin -1/K",
                "Length/length/degree Celsius -1/°C",
                "Length/length/degree Fahrenheit -1/°F",
                "Length/length/degree Rankine -1/R°",
                "Length/length/degree Reaumur -1/r°",

                //thermal resistance
                "Kelvin/watt -K/W",
                "Degree Fahrenheit hour/Btu (IT) -°Fh/Btu(IT)",
                "Degree Fahrenheit hour/Btu (th) -°Fh/Btu(th)",
                "Degree Fahrenheit second/Btu (IT) -°Fs/Btu(IT)",
                "Degree Fahrenheit second/Btu (th) -°Fs/Btu(th)",



        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, listitem);
        lv.setAdapter(adapter);

        /*Collections.sort(lv, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });*/

        inputSearch.addTextChangedListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                //Do some more stuff here and launch new activity
                selectedItem = (String) adapterView.getItemAtPosition(position);
                //  Toast.makeText(SearchActivity.this,"Position"+selectedItem,Toast.LENGTH_LONG).show();
                switch (selectedItem) {


                    //fueleffiency mass
                    case "Joule/kilogram -J/kg" : fueleffiency(); break;
                    case "Kilojoule/kilogram -kJ/kg" : fueleffiency(); break;
                    case "Calorie (IT)/gram -cal/g" : fueleffiency(); break;
                    case "Calorie (th)/gram -cal(th)/g" : fueleffiency(); break;
                    case "Btu (IT)/pound -Btu/lb" : fueleffiency(); break;
                    case "Btu (th)/pound -Btu(th)/lb" : fueleffiency(); break;
                    case "Kilogram/joule -kg/T" : fueleffiency(); break;
                    case "Kilogram/kilojoule -kg/kJ" : fueleffiency(); break;
                    case "Gram/calorie (IT) -g/cal" : fueleffiency(); break;
                    case "Gram/calorie (th) -g/cal(th)" : fueleffiency(); break;
                    case "Pound/Btu (IT) -lb/Btu" : fueleffiency(); break;
                    case "Pound/Btu (th) -lb/Btu(th)" : fueleffiency(); break;
                    case "Pound/horsepower/hour -lb/hp/h" : fueleffiency(); break;
                    case "Gram/horsepower (metric)/hour -g/hp/h" : fueleffiency(); break;
                    case "Gram/kilowatt/hour -g/kW/h" : fueleffiency(); break;

                    //fuel effiency volume
                    case "Joule/cubic meter -J/m^3" : fueleffiencyvolume(); break;
                    case "Joule/liter -J/L" : fueleffiencyvolume(); break;
                    case "Megajoule/cubic meter -mJ/m^3" : fueleffiencyvolume(); break;
                    case "Kilojoule/cubic meter -kJ/m^3" : fueleffiencyvolume(); break;
                    case "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3" : fueleffiencyvolume(); break;
                    case "Calorie (IT)/cubic centimeter -cal(IT)/cm^3" : fueleffiencyvolume(); break;
                    case "Therm/cubic foot -therm/ft^3" : fueleffiencyvolume(); break;
                    case "Therm/gallon (UK) -therm/gal" : fueleffiencyvolume(); break;
                    case "Btu (IT)/cubic foot -Btu/ft^3" : fueleffiencyvolume(); break;
                    case "Btu (th)/cubic foot -Btu (th)/ft^3" : fueleffiencyvolume(); break;
                    case "CHU/cubic foot -CHU/ft^3" : fueleffiencyvolume(); break;
                    case "Cubic meter/joule -m^3/J" : fueleffiencyvolume(); break;
                    case "Liter/joule -L/J" : fueleffiencyvolume(); break;
                    case "Gallon (US)/horsepower -gal(US)/hp" : fueleffiencyvolume(); break;
                    case "Gallon (UK)/horsepower -gal(UK)/hp" : fueleffiencyvolume(); break;

                    //heat density
                    case "Joule/square meter -J/m^2" : heatdensity(); break;
                    case "Calorie (th)/square centimeter -cal(th)/cm^2" : heatdensity(); break;
                    case "Langley -lan" : heatdensity(); break;
                    case "Btu (IT)/square foot -Btu(IT)/ft^2" : heatdensity(); break;
                    case "Btu (th)/square foot -Btu(th)/ft^2" : heatdensity(); break;

                    //haetflux density
                    case "Watt/square meter -W/m^2" : heatfluxdensity(); break;
                    case "Kilowatt/square meter -kW/m^2" : heatfluxdensity(); break;
                    case "Watt/square centimeter -W/cm^2" : heatfluxdensity(); break;
                    case "Watt/square inch -W/in^2" : heatfluxdensity(); break;
                    case "Joule/second/square meter -Js/m^2" : heatfluxdensity(); break;
                    case "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2" : heatfluxdensity(); break;
                    case "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2" : heatfluxdensity(); break;
                    case "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2" : heatfluxdensity(); break;
                    case "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2" : heatfluxdensity(); break;
                    case "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2" : heatfluxdensity(); break;
                    case "Calorie (th)/second/square centimeter -cal(th)s/cm^2" : heatfluxdensity(); break;
                    case "Calorie (th)/minute/square centimeter -cal(th)min/cm^2" : heatfluxdensity(); break;
                    case "Calorie (th)/hour/square centimeter -cal(th)h/cm^2" : heatfluxdensity(); break;
                    case "Dyne/hour/centimeter -dynh/cm" : heatfluxdensity(); break;
                    case "Erg/hour/square millimeter -ergh/mm^2" : heatfluxdensity(); break;
                    case "Foot pound/minute/square foot -ftlbmin/ft^2" : heatfluxdensity(); break;
                    case "Horsepower/square foot -hp/ft^2" : heatfluxdensity(); break;
                    case "Horsepower (metric)/square foot -hp/ft^2" : heatfluxdensity(); break;
                    case "Btu (IT)/second/square foot -Btu(IT)s/ft^2" : heatfluxdensity(); break;
                    case "Btu (IT)/minute/square foot -Btu(IT)min/ft^2" : heatfluxdensity(); break;
                    case "Btu (IT)/hour/square foot -Btu(IT)h/ft^2" : heatfluxdensity(); break;
                    case "Btu (th)/second/square inch -Btu(th)s/in^2" : heatfluxdensity(); break;
                    case "Btu (th)/second/square foot -Btu(th)s/ft^2" : heatfluxdensity(); break;
                    case "Btu (th)/minute/square foot -Btu(th)min/ft^2" : heatfluxdensity(); break;
                    case "Btu (th)/hour/square foot -Btu(th)h/ft^2" : heatfluxdensity(); break;
                    case "CHU/hour/square foot -CHUh/ft^2" : heatfluxdensity(); break;

                    //heat transfer
                    case "Watt/square meter/K -W/m^2/K" : heattransfer(); break;
                    case "Watt/square meter/%b0C -W/m^2/%b0C" : heattransfer(); break;
                    case "Joule/second/square meter/K -J/s/m^2/K" : heattransfer(); break;
                    case "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C" : heattransfer(); break;
                    case "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C" : heattransfer(); break;
                    case "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C" : heattransfer(); break;
                    case "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F" : heattransfer(); break;
                    case "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F" : heattransfer(); break;
                    case "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F" : heattransfer(); break;
                    case "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F" : heattransfer(); break;
                    case "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C" : heattransfer(); break;

                    //specific heat
                    case "Joule/kilogram/K -J/(kg*K)" : specificheat(); break;
                    case "Joule/kilogram/°C -J/(kg*°C)" : specificheat(); break;
                    case "Joule/gram/°C -J/(g*°C)" : specificheat(); break;
                    case "Kilojoule/kilogram/K -kJ/(kg*K)" : specificheat(); break;
                    case "Kilojoule/kilogram/°C -kJ/(kg*°C)" : specificheat(); break;
                    case "Calorie (IT)/gram/°C -cal(IT)/(g*°C)" : specificheat(); break;
                    case "Calorie (IT)/gram/°F -cal(IT)/(g*°F)" : specificheat(); break;
                    case "Calorie (th)/gram/°C -cal(th)/(g*°C)" : specificheat(); break;
                    case "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)" : specificheat(); break;
                    case "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)" : specificheat(); break;
                    case "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)" : specificheat(); break;
                    case "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)" : specificheat(); break;
                    case "Kilogram-force meter/kilogram/K -kgfm/(kg*K)" : specificheat(); break;
                    case "Pound-force foot/pound/°R -lbfft/(lb*°R)" : specificheat(); break;
                    case "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)" : specificheat(); break;
                    case "Btu (th)/pound/°F -Btu(th)/(lb*°F)" : specificheat(); break;
                    case "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)" : specificheat(); break;
                    case "Btu (th)/pound/°R -Btu(th)/(lb*°R)" : specificheat(); break;
                    case "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)" : specificheat(); break;
                    case "CHU/pound/°C -CHU/(lb*°C)" : specificheat(); break;

                    //temperture interbval
                    case "Kelvin -K" : tempertureinterval(); break;
                    case "Degree Celsius -°C" : tempertureinterval(); break;
                    case "Degree centigrade -°C" : tempertureinterval(); break;
                    case "Degree Fahrenheit -°F" : tempertureinterval(); break;
                    case "Degree Rankine -°R" : tempertureinterval(); break;
                    case "Degree Reaumur -°r" : tempertureinterval(); break;

                    //thermal conducutivyt
                    case "Watt/meter/K -W/(m*K)" : thermalconducitivity(); break;
                    case "Watt/centimeter/°C -W/(cm*°C)" : thermalconducitivity(); break;
                    case "Kilowatt/meter/K -kW/(m*K)" : thermalconducitivity(); break;
                    case "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)" : thermalconducitivity(); break;
                    case "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)" : thermalconducitivity(); break;
                    case "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)" : thermalconducitivity(); break;
                    case "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)" : thermalconducitivity(); break;
                    case "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)" : thermalconducitivity(); break;
                    case "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)" : thermalconducitivity(); break;

                    //thermal expansion
                    case "Length/length/kelvin -1/K" : thermalexpansion(); break;
                    case "Length/length/degree Celsius -1/°C" : thermalexpansion(); break;
                    case "Length/length/degree Fahrenheit -1/°F" : thermalexpansion(); break;
                    case "Length/length/degree Rankine -1/R°" : thermalexpansion(); break;
                    case "Length/length/degree Reaumur -1/r°" : thermalexpansion(); break;

                    //thermal resistance
                    case "Kelvin/watt -K/W" : thermalresistance(); break;
                    case "Degree Fahrenheit hour/Btu (IT) -°Fh/Btu(IT)" : thermalresistance(); break;
                    case "Degree Fahrenheit hour/Btu (th) -°Fh/Btu(th)" : thermalresistance(); break;
                    case "Degree Fahrenheit second/Btu (IT) -°Fs/Btu(IT)" : thermalresistance(); break;
                    case "Degree Fahrenheit second/Btu (th) -°Fs/Btu(th)" : thermalresistance(); break;

                }
            }
        });
        }

    private void thermalresistance() {
        Intent i7=new Intent(SearchActivity.this, ThermalResistanceActivity.class);
        startActivity(i7);
    }

    private void thermalexpansion() {
        Intent i7=new Intent(SearchActivity.this, ThermalExpansionActivity.class);
        startActivity(i7);
    }

    private void thermalconducitivity() {
        Intent i7=new Intent(SearchActivity.this, ThermalConductivityActivity.class);
        startActivity(i7);
    }


    private void tempertureinterval() {
        Intent i7=new Intent(SearchActivity.this, TemperatureIntervalActivity.class);
        startActivity(i7);
    }

    private void specificheat() {
        Intent i7=new Intent(SearchActivity.this, SpecificHeatCapacityActivity.class);
        startActivity(i7);
    }

    private void heattransfer() {
        Intent i7=new Intent(SearchActivity.this, HeatTransferCoefficientActivity.class);
        startActivity(i7);
    }

    private void heatfluxdensity() {
        Intent i7=new Intent(SearchActivity.this, HeatFluxDensityActivity.class);
        startActivity(i7);
    }

    private void heatdensity() {
        Intent i7=new Intent(SearchActivity.this, HeatDensityActivity.class);
        startActivity(i7);
    }

    private void fueleffiencyvolume() {
        Intent i7=new Intent(SearchActivity.this, FuelEfficiencyVolumeActivity.class);
        startActivity(i7);
    }

    private void fueleffiency() {
        Intent i7=new Intent(SearchActivity.this, FuelEfficiencyMassActivity.class);
        startActivity(i7);
    }



    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        SearchActivity.this.adapter.getFilter().filter(s);

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



