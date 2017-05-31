package com.nineinfosys.heatconverter.Engin;
import java.util.ArrayList;

/**
 * Created by Dev on 11-05-2017.
 */

public class SpecificHeatCapacityConverter {
    private double jkgk,jkgc,jgc,kkk,kkc,citc,citf,cth,kitc,kthc,kitk,kthk,kf,pf,btuitf,btuthf,btuitr,btuthr,btuitc,chu;

    private double edtValue;
    private String conversionFrom;




    public SpecificHeatCapacityConverter(String conversionFrom, double edtValue) {

        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }



    public ArrayList<ConversionResults> calculateheatcapacityConversion()

    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)

        {
            case "Joule/kilogram/K -J/(kg*K)":


                jkgk=(edtValue)*1;
                jkgc=(edtValue)*1;
                jgc=(edtValue)*0.001;
                kkk=(edtValue)*0.001;
                kkc=(edtValue)*0.001;
                citc=(edtValue)*0.0002388459;
                citf=(edtValue)*0.0002388459;
                cth=(edtValue)*0.0002390057;
                kitc=(edtValue)*0.0002388459;
                kthc=(edtValue)*0.0002390057;
                kitk=(edtValue)*0.0002388459;
                kthk=(edtValue)*0.0002390057;
                kf=(edtValue)*0.1019716213;
                pf=(edtValue)*0.1858625352;
                btuitf=(edtValue)*0.0002388459;
                btuthf=(edtValue)*0.0002390057;
                btuitr=(edtValue)*0.0002388459;
                btuthr=(edtValue)*0.0002390057;
                btuitc=(edtValue)*0.0004299226;
                chu=(edtValue)*0.0002388459;


                break;
            case "Joule/kilogram/°C -J/(kg*°C)":

                jkgk=(edtValue)*1;
                jkgc=(edtValue)*1;
                jgc=(edtValue)*0.001;
                kkk=(edtValue)*0.001;
                kkc=(edtValue)*0.001;
                citc=(edtValue)*0.0002388459;
                citf=(edtValue)*0.0002388459;
                cth=(edtValue)*0.0002390057;
                kitc=(edtValue)*0.0002388459;
                kthc=(edtValue)*0.0002390057;
                kitk=(edtValue)*0.0002388459;
                kthk=(edtValue)*0.0002390057;
                kf=(edtValue)*0.1019716213;
                pf=(edtValue)*0.1858625352;
                btuitf=(edtValue)*0.0002388459;
                btuthf=(edtValue)*0.0002390057;
                btuitr=(edtValue)*0.0002388459;
                btuthr=(edtValue)*0.0002390057;
                btuitc=(edtValue)*0.0004299226;
                chu=(edtValue)*0.0002388459;


                break;
            case "Joule/gram/°C -J/(g*°C)":

                jkgk=(edtValue)*1000;
                jkgc=(edtValue)*1000;
                jgc=(edtValue)*1;
                kkk=(edtValue)*1;
                kkc=(edtValue)*1;
                citc=(edtValue)*0.2388458966;
                citf=(edtValue)*0.2388458966;
                cth=(edtValue)*0.2390057361;
                kitc=(edtValue)*0.2388458966;
                kthc=(edtValue)*0.2390057361;
                kitk=(edtValue)*0.2388458966;
                kthk=(edtValue)*0.2390057361;
                kf=(edtValue)*101.9716213;
                pf=(edtValue)*185.86253517;
                btuitf=(edtValue)*0.2388458966;
                btuthf=(edtValue)*0.2390057361;
                btuitr=(edtValue)*0.2388458966;
                btuthr=(edtValue)*0.2390057361;
                btuitc=(edtValue)*0.4299226139;
                chu=(edtValue)*0.2388458966;


                break;
            case "Kilojoule/kilogram/K -kJ/(kg*K)":
                jkgk=(edtValue)*1000;
                jkgc=(edtValue)*1000;
                jgc=(edtValue)*1;
                kkk=(edtValue)*1;
                kkc=(edtValue)*1;
                citc=(edtValue)*0.2388458966;
                citf=(edtValue)*0.2388458966;
                cth=(edtValue)*0.2390057361;
                kitc=(edtValue)*0.2388458966;
                kthc=(edtValue)*0.2390057361;
                kitk=(edtValue)*0.2388458966;
                kthk=(edtValue)*0.2390057361;
                kf=(edtValue)*101.9716213;
                pf=(edtValue)*185.86253517;
                btuitf=(edtValue)*0.2388458966;
                btuthf=(edtValue)*0.2390057361;
                btuitr=(edtValue)*0.2388458966;
                btuthr=(edtValue)*0.2390057361;
                btuitc=(edtValue)*0.4299226139;
                chu=(edtValue)*0.2388458966;



                break;
            case "Kilojoule/kilogram/°C -kJ/(kg*°C)":

                jkgk=(edtValue)*1000;
                jkgc=(edtValue)*1000;
                jgc=(edtValue)*1;
                kkk=(edtValue)*1;
                kkc=(edtValue)*1;
                citc=(edtValue)*0.2388458966;
                citf=(edtValue)*0.2388458966;
                cth=(edtValue)*0.2390057361;
                kitc=(edtValue)*0.2388458966;
                kthc=(edtValue)*0.2390057361;
                kitk=(edtValue)*0.2388458966;
                kthk=(edtValue)*0.2390057361;
                kf=(edtValue)*101.9716213;
                pf=(edtValue)*185.86253517;
                btuitf=(edtValue)*0.2388458966;
                btuthf=(edtValue)*0.2390057361;
                btuitr=(edtValue)*0.2388458966;
                btuthr=(edtValue)*0.2390057361;
                btuitc=(edtValue)*0.4299226139;
                chu=(edtValue)*0.2388458966;


                break;
            case "Calorie (IT)/gram/°C -cal(IT)/(g*°C)":

                jkgk=(edtValue)*4186.8;
                jkgc=(edtValue)*4186.8;
                jgc=(edtValue)*4.1868;
                kkk=(edtValue)*4.1868;
                kkc=(edtValue)*4.1868;
                citc=(edtValue)*1;
                citf=(edtValue)*1;
                cth=(edtValue)*1.0006692161;
                kitc=(edtValue)*1;
                kthc=(edtValue)*1.0006692161;
                kitk=(edtValue)*1;
                kthk=(edtValue)*1.0006692161;
                kf=(edtValue)*426.93478405;
                pf=(edtValue)*778.16926227;
                btuitf=(edtValue)*1;
                btuthf=(edtValue)*1.0006692161;
                btuitr=(edtValue)*1;
                btuthr=(edtValue)*1.0006692161;
                btuitc=(edtValue)*1.7999999999;
                chu=(edtValue)*0.9999999999;


                break;
            case "Calorie (IT)/gram/°F -cal(IT)/(g*°F)":

                jkgk=(edtValue)*4186.8;
                jkgc=(edtValue)*4186.8;
                jgc=(edtValue)*4.1868;
                kkk=(edtValue)*4.1868;
                kkc=(edtValue)*4.1868;
                citc=(edtValue)*1;
                citf=(edtValue)*1;
                cth=(edtValue)*1.0006692161;
                kitc=(edtValue)*1;
                kthc=(edtValue)*1.0006692161;
                kitk=(edtValue)*1;
                kthk=(edtValue)*1.0006692161;
                kf=(edtValue)*426.93478405;
                pf=(edtValue)*778.16926227;
                btuitf=(edtValue)*1;
                btuthf=(edtValue)*1.0006692161;
                btuitr=(edtValue)*1;
                btuthr=(edtValue)*1.0006692161;
                btuitc=(edtValue)*1.7999999999;
                chu=(edtValue)*0.9999999999;


                break;
            case "Calorie (th)/gram/°C -cal(th)/(g*°C)":

                jkgk=(edtValue)*4184;
                jkgc=(edtValue)*4184;
                jgc=(edtValue)*4.184;
                kkk=(edtValue)*4.184;
                kkc=(edtValue)*4.184;
                citc=(edtValue)*0.9993312315;
                citf=(edtValue)*0.9993312315;
                cth=(edtValue)*1;
                kitc=(edtValue)*0.9993312315;
                kthc=(edtValue)*1;
                kitk=(edtValue)*0.9993312315;
                kthk=(edtValue)*1;
                kf=(edtValue)*426.64926351;
                pf=(edtValue)*777.64884717;
                btuitf=(edtValue)*0.9993312315;
                btuthf=(edtValue)*1;
                btuitr=(edtValue)*0.9993312315;
                btuthr=(edtValue)*1;
                btuitc=(edtValue)*1.7987962166;
                chu=(edtValue)*0.9993312314;

                break;
            case "Kilocalorie (IT)/kilogram/°C -kcal(IT)/(kg*°C)":

                jkgk=(edtValue)*4186.8;
                jkgc=(edtValue)*4186.8;
                jgc=(edtValue)*4.1868;
                kkk=(edtValue)*4.1868;
                kkc=(edtValue)*4.1868;
                citc=(edtValue)*1;
                citf=(edtValue)*1;
                cth=(edtValue)*1.0006692161;
                kitc=(edtValue)*1;
                kthc=(edtValue)*1.0006692161;
                kitk=(edtValue)*1;
                kthk=(edtValue)*1.0006692161;
                kf=(edtValue)*426.93478405;
                pf=(edtValue)*778.16926227;
                btuitf=(edtValue)*1;
                btuthf=(edtValue)*1.0006692161;
                btuitr=(edtValue)*1;
                btuthr=(edtValue)*1.0006692161;
                btuitc=(edtValue)*1.7999999999;
                chu=(edtValue)*0.9999999999;



                break;
            case "Kilocalorie (th)/kilogram/°C -kcal(th)/(kg*°C)":

                jkgk=(edtValue)*4184;
                jkgc=(edtValue)*4184;
                jgc=(edtValue)*4.184;
                kkk=(edtValue)*4.184;
                kkc=(edtValue)*4.184;
                citc=(edtValue)*0.9993312315;
                citf=(edtValue)*0.9993312315;
                cth=(edtValue)*1;
                kitc=(edtValue)*0.9993312315;
                kthc=(edtValue)*1;
                kitk=(edtValue)*0.9993312315;
                kthk=(edtValue)*1;
                kf=(edtValue)*426.64926351;
                pf=(edtValue)*777.64884717;
                btuitf=(edtValue)*0.9993312315;
                btuthf=(edtValue)*1;
                btuitr=(edtValue)*0.9993312315;
                btuthr=(edtValue)*1;
                btuitc=(edtValue)*1.7987962166;
                chu=(edtValue)*0.9993312314;


                break;
            case "Kilocalorie (IT)/kilogram/K -kcal(IT)/(kg*K)":

                jkgk=(edtValue)*4186.8;
                jkgc=(edtValue)*4186.8;
                jgc=(edtValue)*4.1868;
                kkk=(edtValue)*4.1868;
                kkc=(edtValue)*4.1868;
                citc=(edtValue)*1;
                citf=(edtValue)*1;
                cth=(edtValue)*1.0006692161;
                kitc=(edtValue)*1;
                kthc=(edtValue)*1.0006692161;
                kitk=(edtValue)*1;
                kthk=(edtValue)*1.0006692161;
                kf=(edtValue)*426.93478405;
                pf=(edtValue)*778.16926227;
                btuitf=(edtValue)*1;
                btuthf=(edtValue)*1.0006692161;
                btuitr=(edtValue)*1;
                btuthr=(edtValue)*1.0006692161;
                btuitc=(edtValue)*1.7999999999;
                chu=(edtValue)*0.9999999999;



                break;
            case "Kilocalorie (th)/kilogram/K -kcal(th)/(kg*K)":

                jkgk=(edtValue)*4184;
                jkgc=(edtValue)*4184;
                jgc=(edtValue)*4.184;
                kkk=(edtValue)*4.184;
                kkc=(edtValue)*4.184;
                citc=(edtValue)*0.9993312315;
                citf=(edtValue)*0.9993312315;
                cth=(edtValue)*1;
                kitc=(edtValue)*0.9993312315;
                kthc=(edtValue)*1;
                kitk=(edtValue)*0.9993312315;
                kthk=(edtValue)*1;
                kf=(edtValue)*426.64926351;
                pf=(edtValue)*777.64884717;
                btuitf=(edtValue)*0.9993312315;
                btuthf=(edtValue)*1;
                btuitr=(edtValue)*0.9993312315;
                btuthr=(edtValue)*1;
                btuitc=(edtValue)*1.7987962166;
                chu=(edtValue)*0.9993312314;

                break;

            case "Kilogram-force meter/kilogram/K -kgfm/(kg*K)":

                jkgk=(edtValue)*9.80665;
                jkgc=(edtValue)*9.80665;
                jgc=(edtValue)*0.00980665;
                kkk=(edtValue)*0.00980665;
                kkc=(edtValue)*0.00980665;
                citc=(edtValue)*0.0023422781;
                citf=(edtValue)*0.0023422781;
                cth=(edtValue)*0.0023438456;
                kitc=(edtValue)*0.0023422781;
                kthc=(edtValue)*0.0023438456;
                kitk=(edtValue)*0.0023422781;
                kthk=(edtValue)*0.0023438456;
                kf=(edtValue)*1;
                pf=(edtValue)*1.8226888306;
                btuitf=(edtValue)*0.0023422781;
                btuthf=(edtValue)*0.0023438456;
                btuitr=(edtValue)*0.0023422781;
                btuthr=(edtValue)*0.0023438456;
                btuitc=(edtValue)*0.0042161006;
                chu=(edtValue)*0.0023422781;

                break;
            case "Pound-force foot/pound/°R -lbfft/(lb*°R)":

                jkgk=(edtValue)*5.380320456;
                jkgc=(edtValue)*5.380320456;
                jgc=(edtValue)*0.0053803205;
                kkk=(edtValue)*0.0053803205;
                kkc=(edtValue)*0.0053803205;
                citc=(edtValue)*0.0012850675;
                citf=(edtValue)*0.0012850675;
                cth=(edtValue)*0.0012859275;
                kitc=(edtValue)*0.0012850675;
                kthc=(edtValue)*0.0012859275;
                kitk=(edtValue)*0.0012850675;
                kthk=(edtValue)*0.0012859275;
                kf=(edtValue)*0.54864;
                pf=(edtValue)*1;
                btuitf=(edtValue)*0.0012850675;
                btuthf=(edtValue)*0.0012859275;
                btuitr=(edtValue)*0.0012850675;
                btuthr=(edtValue)*0.0012859275;
                btuitc=(edtValue)*0.0023131214;
                chu=(edtValue)*0.0012850675;

                break;

            case "Btu (IT)/pound/°F -Btu(IT)/(lb*°F)":

                jkgk=(edtValue)*4186.8;
                jkgc=(edtValue)*4186.8;
                jgc=(edtValue)*4.1868;
                kkk=(edtValue)*4.1868;
                kkc=(edtValue)*4.1868;
                citc=(edtValue)*1;
                citf=(edtValue)*1;
                cth=(edtValue)*1.0006692161;
                kitc=(edtValue)*1;
                kthc=(edtValue)*1.0006692161;
                kitk=(edtValue)*1;
                kthk=(edtValue)*1.0006692161;
                kf=(edtValue)*426.93478405;
                pf=(edtValue)*778.16926227;
                btuitf=(edtValue)*1;
                btuthf=(edtValue)*1.0006692161;
                btuitr=(edtValue)*1;
                btuthr=(edtValue)*1.0006692161;
                btuitc=(edtValue)*1.7999999999;
                chu=(edtValue)*0.9999999999;

                break;
            case "Btu (th)/pound/°F -Btu(th)/(lb*°F)":

                jkgk=(edtValue)*4184;
                jkgc=(edtValue)*4184;
                jgc=(edtValue)*4.184;
                kkk=(edtValue)*4.184;
                kkc=(edtValue)*4.184;
                citc=(edtValue)*0.9993312315;
                citf=(edtValue)*0.9993312315;
                cth=(edtValue)*1;
                kitc=(edtValue)*0.9993312315;
                kthc=(edtValue)*1;
                kitk=(edtValue)*0.9993312315;
                kthk=(edtValue)*1;
                kf=(edtValue)*426.64926351;
                pf=(edtValue)*777.64884717;
                btuitf=(edtValue)*0.9993312315;
                btuthf=(edtValue)*1;
                btuitr=(edtValue)*0.9993312315;
                btuthr=(edtValue)*1;
                btuitc=(edtValue)*1.7987962166;
                chu=(edtValue)*0.9993312314;

                break;
            case "Btu (IT)/pound/°R -Btu(IT)/(lb*°R)":

                jkgk=(edtValue)*4186.8;
                jkgc=(edtValue)*4186.8;
                jgc=(edtValue)*4.1868;
                kkk=(edtValue)*4.1868;
                kkc=(edtValue)*4.1868;
                citc=(edtValue)*1;
                citf=(edtValue)*1;
                cth=(edtValue)*1.0006692161;
                kitc=(edtValue)*1;
                kthc=(edtValue)*1.0006692161;
                kitk=(edtValue)*1;
                kthk=(edtValue)*1.0006692161;
                kf=(edtValue)*426.93478405;
                pf=(edtValue)*778.16926227;
                btuitf=(edtValue)*1;
                btuthf=(edtValue)*1.0006692161;
                btuitr=(edtValue)*1;
                btuthr=(edtValue)*1.0006692161;
                btuitc=(edtValue)*1.7999999999;
                chu=(edtValue)*0.9999999999;

                break;
            case "Btu (th)/pound/°R -Btu(th)/(lb*°R)":

                jkgk=(edtValue)*4184;
                jkgc=(edtValue)*4184;
                jgc=(edtValue)*4.184;
                kkk=(edtValue)*4.184;
                kkc=(edtValue)*4.184;
                citc=(edtValue)*0.9993312315;
                citf=(edtValue)*0.9993312315;
                cth=(edtValue)*1;
                kitc=(edtValue)*0.9993312315;
                kthc=(edtValue)*1;
                kitk=(edtValue)*0.9993312315;
                kthk=(edtValue)*1;
                kf=(edtValue)*426.64926351;
                pf=(edtValue)*777.64884717;
                btuitf=(edtValue)*0.9993312315;
                btuthf=(edtValue)*1;
                btuitr=(edtValue)*0.9993312315;
                btuthr=(edtValue)*1;
                btuitc=(edtValue)*1.7987962166;
                chu=(edtValue)*0.9993312314;

                break;
            case "Btu (IT)/pound/°C -Btu(IT)/(lb*°C)":

                jkgk=(edtValue)*2326.0000002;
                jkgc=(edtValue)*2326.0000002;
                jgc=(edtValue)*2.3260000002;
                kkk=(edtValue)*2.3260000002;
                kkc=(edtValue)*2.3260000002;
                citc=(edtValue)*0.5555555556;
                citf=(edtValue)*0.5555555556;
                cth=(edtValue)*0.5559273423;
                kitc=(edtValue)*0.5555555556;
                kthc=(edtValue)*0.5559273423;
                kitk=(edtValue)*0.5555555556;
                kthk=(edtValue)*0.5559273423;
                kf=(edtValue)*237.18599116;
                pf=(edtValue)*432.31625684;
                btuitf=(edtValue)*0.5555555556;
                btuthf=(edtValue)*0.5559273423;
                btuitr=(edtValue)*0.5555555556;
                btuthr=(edtValue)*0.5559273423;
                btuitc=(edtValue)*1;
                chu=(edtValue)*0.5555555555;

                break;
            case "CHU/pound/°C -CHU/(lb*°C)":

                jkgk=(edtValue)*4186.8000005;
                jkgc=(edtValue)*4186.8000005;
                jgc=(edtValue)*4.1868000005;
                kkk=(edtValue)*4.1868000005;
                kkc=(edtValue)*4.1868000005;
                citc=(edtValue)*1.0000000001;
                citf=(edtValue)*1.0000000001;
                cth=(edtValue)*1.0006692162;
                kitc=(edtValue)*1.0000000001;
                kthc=(edtValue)*1.0006692162;
                kitk=(edtValue)*1.0000000001;
                kthk=(edtValue)*1.0006692162;
                kf=(edtValue)*426.9347841;
                pf=(edtValue)*778.16926236;
                btuitf=(edtValue)*1.0000000001;
                btuthf=(edtValue)*1.0006692162;
                btuitr=(edtValue)*1.0000000001;
                btuthr=(edtValue)*1.0006692162;
                btuitc=(edtValue)*1.8000000001;
                chu=(edtValue)*1;

                break;


        }

        results.setJkgk(jkgk);
        results.setJkgc(jkgc);
        results.setJgc(jgc);
        results.setKkk(kkk);
        results.setKkc(kkc);
        results.setCitc(citc);
        results.setCitf(citf);
        results.setCth(cth);
        results.setKitc(kitc);
        results.setKthc(kthc);
        results.setKitk(kitk);
        results.setKthk(kthk);
        results.setKf(kf);
        results.setPf(pf);
        results.setBtuitf(btuitf);
        results.setBtuthf(btuthf);
        results.setBtuitr(btuitr);
        results.setBtuthr(btuthr);
        results.setBtuitc(btuitc);
        results.setChu(chu);



        converterArray.add(results);

        return converterArray;


    }
    public class ConversionResults{

        public double getJkgk() {
            return jkgk;
        }

        public void setJkgk(double jkgk) {
            this.jkgk = jkgk;
        }

        public double getJkgc() {
            return jkgc;
        }

        public void setJkgc(double jkgc) {
            this.jkgc = jkgc;
        }

        public double getJgc() {
            return jgc;
        }

        public void setJgc(double jgc) {
            this.jgc = jgc;
        }

        public double getKkk() {
            return kkk;
        }

        public void setKkk(double kkk) {
            this.kkk = kkk;
        }

        public double getKkc() {
            return kkc;
        }

        public void setKkc(double kkc) {
            this.kkc = kkc;
        }

        public double getCitc() {
            return citc;
        }

        public void setCitc(double citc) {
            this.citc = citc;
        }

        public double getCitf() {
            return citf;
        }

        public void setCitf(double citf) {
            this.citf = citf;
        }

        public double getCth() {
            return cth;
        }

        public void setCth(double cth) {
            this.cth = cth;
        }

        public double getKitc() {
            return kitc;
        }

        public void setKitc(double kitc) {
            this.kitc = kitc;
        }

        public double getKthc() {
            return kthc;
        }

        public void setKthc(double kthc) {
            this.kthc = kthc;
        }

        public double getKitk() {
            return kitk;
        }

        public void setKitk(double kitk) {
            this.kitk = kitk;
        }

        public double getKthk() {
            return kthk;
        }

        public void setKthk(double kthk) {
            this.kthk = kthk;
        }

        public double getKf() {
            return kf;
        }

        public void setKf(double kf) {
            this.kf = kf;
        }

        public double getPf() {
            return pf;
        }

        public void setPf(double pf) {
            this.pf = pf;
        }

        public double getBtuitf() {
            return btuitf;
        }

        public void setBtuitf(double btuitf) {
            this.btuitf = btuitf;
        }

        public double getBtuthf() {
            return btuthf;
        }

        public void setBtuthf(double btuthf) {
            this.btuthf = btuthf;
        }

        public double getBtuitr() {
            return btuitr;
        }

        public void setBtuitr(double btuitr) {
            this.btuitr = btuitr;
        }

        public double getBtuthr() {
            return btuthr;
        }

        public void setBtuthr(double btuthr) {
            this.btuthr = btuthr;
        }

        public double getBtuitc() {
            return btuitc;
        }

        public void setBtuitc(double btuitc) {
            this.btuitc = btuitc;
        }

        public double getChu() {
            return chu;
        }

        public void setChu(double chu) {
            this.chu = chu;
        }

        private double jkgk,jkgc,jgc,kkk,kkc,citc,citf,cth,kitc,kthc,kitk,kthk,kf,pf,btuitf,btuthf,btuitr,btuthr,btuitc,chu;



    }
}