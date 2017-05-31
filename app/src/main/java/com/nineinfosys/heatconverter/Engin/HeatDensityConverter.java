package com.nineinfosys.heatconverter.Engin;

/**
 * Created by Dev on 11-05-2017.
 */
import java.util.ArrayList;

public class HeatDensityConverter {private double joule,calorie,langley,btuit,btuth;
    private double edtValue;
    private String conversionFrom;
    //private String conversionTo;



    public HeatDensityConverter(String conversionFrom, double edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateHeatDensityConversion()

    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)

        {

            case "Joule/square meter -J/m^2":

                joule=(edtValue)*1;
                calorie=(edtValue)*0.0000239006;
                langley=(edtValue)*0.0000239006;
                btuit=(edtValue)*0.0000880551;
                btuth=(edtValue)*0.000088114;

                break;

            case "Calorie (th)/square centimeter -cal(th)/cm^2":

                joule=(edtValue)*41840;
                calorie=(edtValue)*1;
                langley=(edtValue)*1;
                btuit=(edtValue)*3.6842250426;
                btuth=(edtValue)*3.6866905852;



                break;

            case "Langley -lan":

                joule=(edtValue)*41840;
                calorie=(edtValue)*1;
                langley=(edtValue)*1;
                btuit=(edtValue)*3.6842250426;
                btuth=(edtValue)*3.6866905852;


                break;
            case "Btu (IT)/square foot -Btu(IT)/ft^2":

                joule=(edtValue)*11356.526682;
                calorie=(edtValue)*0.271427502;
                langley=(edtValue)*0.271427502;
                btuit=(edtValue)*1;
                btuth=(edtValue)*1.0006692161;


                break;
            case "Btu (th)/square foot -Btu(th)/ft^2":

                joule=(edtValue)*11348.931795;
                calorie=(edtValue)*0.2712459798;
                langley=(edtValue)*0.2712459798;
                btuit=(edtValue)*0.9993312315;
                btuth=(edtValue)*1;


                break;

        }
        results.setJoule(joule);
        results.setCalorie(calorie);
        results.setLangley(langley);
        results.setBtuit(btuit);
        results.setBtuth(btuth);
        converterArray.add(results);
        return converterArray;



    }
    public class ConversionResults{

        private double joule,calorie,langley,btuit,btuth;

        public double getJoule() {
            return joule;
        }

        public void setJoule(double joule) {
            this.joule = joule;
        }

        public double getCalorie() {
            return calorie;
        }

        public void setCalorie(double calorie) {
            this.calorie = calorie;
        }

        public double getLangley() {
            return langley;
        }

        public void setLangley(double langley) {
            this.langley = langley;
        }

        public double getBtuit() {
            return btuit;
        }

        public void setBtuit(double btuit) {
            this.btuit = btuit;
        }

        public double getBtuth() {
            return btuth;
        }

        public void setBtuth(double btuth) {
            this.btuth = btuth;
        }


    }
}