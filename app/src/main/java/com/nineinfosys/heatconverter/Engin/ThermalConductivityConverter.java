package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;


public class ThermalConductivityConverter {

	private double wattpermeterperK,wattpercentimeterperC,kilowattpermeterperK,calorieITpersecondpercmperC,caloriethpersecondpercmperC,kilocalorieITperhourpermeterperC,
	kilocaloriethperhourpermeterperC,BtuITinchpersecondpersqfootperF,BtuthinchpersecondpersqfootperF,BtuITfootperhourpersqfootperF,BtuthfootperhourpersqfootperF,
	BtuITinchperhourpersqfootperF,BtuthinchperhourpersqfootperF;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public ThermalConductivityConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateThermalConductivityConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{

		case "Watt/meter/K -W/(m*K)":
			wattpermeterperK=(edtValue)*1;
			wattpercentimeterperC=(edtValue)*0.01;
			kilowattpermeterperK=(edtValue)*0.001;
			calorieITpersecondpercmperC=(edtValue)*0.002388459;
			caloriethpersecondpercmperC=(edtValue)*0.0023900574;
			kilocalorieITperhourpermeterperC=(edtValue)*0.8598452279;
			kilocaloriethperhourpermeterperC=(edtValue)*0.8604206501;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.0019259644;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0019272533;
			BtuITfootperhourpersqfootperF=(edtValue)*0.5777893165;
			BtuthfootperhourpersqfootperF=(edtValue)*0.5781759824;
			BtuITinchperhourpersqfootperF=(edtValue)*6.9334717985;
			BtuthinchperhourpersqfootperF=(edtValue)*6.9381117892;
			break;
		case "Watt/centimeter/°C -W/(cm*°C)":
			wattpermeterperK=(edtValue)*100;
			wattpercentimeterperC=(edtValue)*1;
			kilowattpermeterperK=(edtValue)*0.1;
			calorieITpersecondpercmperC=(edtValue)*0.2388458966;
			caloriethpersecondpercmperC=(edtValue)*0.2390057361;
			kilocalorieITperhourpermeterperC=(edtValue)*85.984522786;
			kilocaloriethperhourpermeterperC=(edtValue)*86.04206501;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.1925964388;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.1927253275;
			BtuITfootperhourpersqfootperF=(edtValue)*57.778931654;
			BtuthfootperhourpersqfootperF=(edtValue)*57.817598243;
			BtuITinchperhourpersqfootperF=(edtValue)*693.34717985;
			BtuthinchperhourpersqfootperF=(edtValue)*693.81117892;
			break;
		case "Kilowatt/meter/K -kW/(m*K)":
			wattpermeterperK=(edtValue)*1000;
			wattpercentimeterperC=(edtValue)*10;
			kilowattpermeterperK=(edtValue)*1;
			calorieITpersecondpercmperC=(edtValue)*2.3884589663;
			caloriethpersecondpercmperC=(edtValue)*2.3900573614;
			kilocalorieITperhourpermeterperC=(edtValue)*859.84522786;
			kilocaloriethperhourpermeterperC=(edtValue)*860.4206501;
			BtuITinchpersecondpersqfootperF=(edtValue)*1.9259643885;
			BtuthinchpersecondpersqfootperF=(edtValue)*1.9272532748;
			BtuITfootperhourpersqfootperF=(edtValue)*577.78931654;
			BtuthfootperhourpersqfootperF=(edtValue)*578.17598243;
			BtuITinchperhourpersqfootperF=(edtValue)*6933.4717985;
			BtuthinchperhourpersqfootperF=(edtValue)*6938.1117892;
			break;
		case "Calorie (IT)/second/cm/°C -cal(IT)/s(cm*°C)":
			wattpermeterperK=(edtValue)*418.68;
			wattpercentimeterperC=(edtValue)*4.1868;
			kilowattpermeterperK=(edtValue)*0.41868;
			calorieITpersecondpercmperC=(edtValue)*1;
			caloriethpersecondpercmperC=(edtValue)*1.0006692161;
			kilocalorieITperhourpermeterperC=(edtValue)*360;
			kilocaloriethperhourpermeterperC=(edtValue)*360.24091778;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.8063627702;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.8069024011;
			BtuITfootperhourpersqfootperF=(edtValue)*241.90883105;
			BtuthfootperhourpersqfootperF=(edtValue)*242.07072033;
			BtuITinchperhourpersqfootperF=(edtValue)*2902.9059726;
			BtuthinchperhourpersqfootperF=(edtValue)*2904.8486439;
			break;
		case "Calorie (th)/second/cm/°C -cal(th)/s(cm*°C)":
			wattpermeterperK=(edtValue)*418.4;
			wattpercentimeterperC=(edtValue)*4.184;
			kilowattpermeterperK=(edtValue)*0.4184;
			calorieITpersecondpercmperC=(edtValue)*0.9993312315;
			caloriethpersecondpercmperC=(edtValue)*1;
			kilocalorieITperhourpermeterperC=(edtValue)*359.75924334;
			kilocaloriethperhourpermeterperC=(edtValue)*360;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.8058235001;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.8063627702;
			BtuITfootperhourpersqfootperF=(edtValue)*241.74705004;
			BtuthfootperhourpersqfootperF=(edtValue)*241.90883105;
			BtuITinchperhourpersqfootperF=(edtValue)*2900.9646005;
			BtuthinchperhourpersqfootperF=(edtValue)*2902.9059726;
			break;
		case "Kilocalorie (IT)/hour/meter/°C -kcal(IT)/h(m*°C)":
			wattpermeterperK=(edtValue)*1.163;
			wattpercentimeterperC=(edtValue)*0.01163;
			kilowattpermeterperK=(edtValue)*0.001163;
			calorieITpersecondpercmperC=(edtValue)*0.0027777778;
			caloriethpersecondpercmperC=(edtValue)*0.0027796367;
			kilocalorieITperhourpermeterperC=(edtValue)*1;
			kilocaloriethperhourpermeterperC=(edtValue)*1.0006692161;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.0022398966;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0022413956;
			BtuITfootperhourpersqfootperF=(edtValue)*0.6719689751;
			BtuthfootperhourpersqfootperF=(edtValue)*0.6724186676;
			BtuITinchperhourpersqfootperF=(edtValue)*8.0636277017;
			BtuthinchperhourpersqfootperF=(edtValue)*8.0690240108;
			break;
		case "Kilocalorie (th)/hour/meter/°C -kcal(th)/h(m*°C)":
			wattpermeterperK=(edtValue)*1.1622222222;
			wattpercentimeterperC=(edtValue)*0.0116222222;
			kilowattpermeterperK=(edtValue)*0.0011622222;
			calorieITpersecondpercmperC=(edtValue)*0.0027759201;
			caloriethpersecondpercmperC=(edtValue)*0.0027777778;
			kilocalorieITperhourpermeterperC=(edtValue)*0.9993312315;
			kilocaloriethperhourpermeterperC=(edtValue)*1;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.0022383986;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0022398966;
			BtuITfootperhourpersqfootperF=(edtValue)*0.6715195834;
			BtuthfootperhourpersqfootperF=(edtValue)*0.6719689751;
			BtuITinchperhourpersqfootperF=(edtValue)*8.0582350014;
			BtuthinchperhourpersqfootperF=(edtValue)*8.0636277017;
			break;
		case "Btu (IT) inch/second/sq. foot/°F -Btu(IT)in/s(sq.ft*°F)":
			wattpermeterperK=(edtValue)*519.22039991;
			wattpercentimeterperC=(edtValue)*5.1922039991;
			kilowattpermeterperK=(edtValue)*0.5192203999;
			calorieITpersecondpercmperC=(edtValue)*1.2401366196;
			caloriethpersecondpercmperC=(edtValue)*1.240966539;
			kilocalorieITperhourpermeterperC=(edtValue)*446.44918307;
			kilocaloriethperhourpermeterperC=(edtValue)*446.74795403;
			BtuITinchpersecondpersqfootperF=(edtValue)*1;
			BtuthinchpersecondpersqfootperF=(edtValue)*1.0006692161;
			BtuITfootperhourpersqfootperF=(edtValue)*300;
			BtuthfootperhourpersqfootperF=(edtValue)*300.20076482;
			BtuITinchperhourpersqfootperF=(edtValue)*3600;
			BtuthinchperhourpersqfootperF=(edtValue)*3602.4091778;
			break;
		case "Btu (th) inch/second/sq. foot/°F -Btu(th)in/s(sq.ft*°F)":
			wattpermeterperK=(edtValue)*518.87316166;
			wattpercentimeterperC=(edtValue)*5.1887316166;
			kilowattpermeterperK=(edtValue)*0.5188731617;
			calorieITpersecondpercmperC=(edtValue)*1.2393072553;
			caloriethpersecondpercmperC=(edtValue)*1.2401366196;
			kilocalorieITperhourpermeterperC=(edtValue)*446.15061192;
			kilocaloriethperhourpermeterperC=(edtValue)*446.44918307;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.9993312315;
			BtuthinchpersecondpersqfootperF=(edtValue)*1;
			BtuITfootperhourpersqfootperF=(edtValue)*299.79936945;
			BtuthfootperhourpersqfootperF=(edtValue)*300;
			BtuITinchperhourpersqfootperF=(edtValue)*3597.5924334;
			BtuthinchperhourpersqfootperF=(edtValue)*3600;
			break;
		case "Btu (IT) foot/hour/sq. foot/°F -Btu(IT)ft/h(sq.ft*°F)":
			wattpermeterperK=(edtValue)*1.7307346664;
			wattpercentimeterperC=(edtValue)*0.0173073467;
			kilowattpermeterperK=(edtValue)*0.0017307347;
			calorieITpersecondpercmperC=(edtValue)*0.0041337887;
			caloriethpersecondpercmperC=(edtValue)*0.0041365551;
			kilocalorieITperhourpermeterperC=(edtValue)*1.4881639436;
			kilocaloriethperhourpermeterperC=(edtValue)*1.4891598468;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.0033333333;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0033355641;
			BtuITfootperhourpersqfootperF=(edtValue)*1;
			BtuthfootperhourpersqfootperF=(edtValue)*1.0006692161;
			BtuITinchperhourpersqfootperF=(edtValue)*12;
			BtuthinchperhourpersqfootperF=(edtValue)*12.008030593;
			break;
		case "Btu (th) foot/hour/sq. foot/°F -Btu(th)ft/h(sq.ft*°F)":
			wattpermeterperK=(edtValue)*1.7295772055;
			wattpercentimeterperC=(edtValue)*0.0172957721;
			kilowattpermeterperK=(edtValue)*0.0017295772;
			calorieITpersecondpercmperC=(edtValue)*0.0041310242;
			caloriethpersecondpercmperC=(edtValue)*0.0041337887;
			kilocalorieITperhourpermeterperC=(edtValue)*1.4871687064;
			kilocaloriethperhourpermeterperC=(edtValue)*1.4881639436;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.0033311041;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0033333333;
			BtuITfootperhourpersqfootperF=(edtValue)*0.9993312315;
			BtuthfootperhourpersqfootperF=(edtValue)*1;
			BtuITinchperhourpersqfootperF=(edtValue)*11.991974778;
			BtuthinchperhourpersqfootperF=(edtValue)*12;
			break;
		case "Btu (IT) inch/hour/sq. foot/°F -Btu(IT)in/h(sq.ft*°F)":
			wattpermeterperK=(edtValue)*0.1442278889;
			wattpercentimeterperC=(edtValue)*0.0014422789;
			kilowattpermeterperK=(edtValue)*0.0001442279;
			calorieITpersecondpercmperC=(edtValue)*0.0003444824;
			caloriethpersecondpercmperC=(edtValue)*0.0003447129;
			kilocalorieITperhourpermeterperC=(edtValue)*0.124013662;
			kilocaloriethperhourpermeterperC=(edtValue)*0.1240966539;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.0002777778;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0002779637;
			BtuITfootperhourpersqfootperF=(edtValue)*0.0833333333;
			BtuthfootperhourpersqfootperF=(edtValue)*0.0833891013;
			BtuITinchperhourpersqfootperF=(edtValue)*1;
			BtuthinchperhourpersqfootperF=(edtValue)*1.0006692161;
			break;
		case "Btu (th) inch/hour/sq. foot/°F -Btu(th)in/h(sq.ft*°F)":
			wattpermeterperK=(edtValue)*0.1441314338;
			wattpercentimeterperC=(edtValue)*0.0014413143;
			kilowattpermeterperK=(edtValue)*0.0001441314;
			calorieITpersecondpercmperC=(edtValue)*0.000344252;
			caloriethpersecondpercmperC=(edtValue)*0.0003444824;
			kilocalorieITperhourpermeterperC=(edtValue)*0.1239307255;
			kilocaloriethperhourpermeterperC=(edtValue)*0.124013662;
			BtuITinchpersecondpersqfootperF=(edtValue)*0.000277592;
			BtuthinchpersecondpersqfootperF=(edtValue)*0.0002777778;
			BtuITfootperhourpersqfootperF=(edtValue)*0.0832776026;
			BtuthfootperhourpersqfootperF=(edtValue)*0.0833333333;
			BtuITinchperhourpersqfootperF=(edtValue)*0.9993312315;
			BtuthinchperhourpersqfootperF=(edtValue)*1;
			break;
		case "Default":
			break;
			
			
		}
		results.setWattpermeterperK(wattpermeterperK);
		results.setWattpercentimeterperC(wattpercentimeterperC);
		results.setKilowattpermeterperK(kilowattpermeterperK);
		results.setCalorieITpersecondpercmperC(calorieITpersecondpercmperC);
		results.setCaloriethpersecondpercmperC(caloriethpersecondpercmperC);
		results.setKilocalorieITperhourpermeterperC(kilocalorieITperhourpermeterperC);
		results.setKilocaloriethperhourpermeterperC(kilocaloriethperhourpermeterperC);
		results.setBtuITinchpersecondpersqfootperF(BtuITinchpersecondpersqfootperF);
		results.setBtuthinchpersecondpersqfootperF(BtuthinchpersecondpersqfootperF);
		results.setBtuITfootperhourpersqfootperF(BtuITfootperhourpersqfootperF);
		results.setBtuthfootperhourpersqfootperF(BtuthfootperhourpersqfootperF);
		results.setBtuITinchperhourpersqfootperF(BtuITinchperhourpersqfootperF);
		results.setBtuthinchperhourpersqfootperF(BtuthinchperhourpersqfootperF);
		
		 
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double wattpermeterperK,wattpercentimeterperC,kilowattpermeterperK,calorieITpersecondpercmperC,caloriethpersecondpercmperC,kilocalorieITperhourpermeterperC,
		kilocaloriethperhourpermeterperC,BtuITinchpersecondpersqfootperF,BtuthinchpersecondpersqfootperF,BtuITfootperhourpersqfootperF,BtuthfootperhourpersqfootperF,
		BtuITinchperhourpersqfootperF,BtuthinchperhourpersqfootperF;

		public double getWattpermeterperK() {
			return wattpermeterperK;
		}

		public void setWattpermeterperK(double wattpermeterperK) {
			this.wattpermeterperK = wattpermeterperK;
		}

		public double getWattpercentimeterperC() {
			return wattpercentimeterperC;
		}

		public void setWattpercentimeterperC(double wattpercentimeterperC) {
			this.wattpercentimeterperC = wattpercentimeterperC;
		}

		public double getKilowattpermeterperK() {
			return kilowattpermeterperK;
		}

		public void setKilowattpermeterperK(double kilowattpermeterperK) {
			this.kilowattpermeterperK = kilowattpermeterperK;
		}

		public double getCalorieITpersecondpercmperC() {
			return calorieITpersecondpercmperC;
		}

		public void setCalorieITpersecondpercmperC(double calorieITpersecondpercmperC) {
			this.calorieITpersecondpercmperC = calorieITpersecondpercmperC;
		}

		public double getCaloriethpersecondpercmperC() {
			return caloriethpersecondpercmperC;
		}

		public void setCaloriethpersecondpercmperC(double caloriethpersecondpercmperC) {
			this.caloriethpersecondpercmperC = caloriethpersecondpercmperC;
		}

		public double getKilocalorieITperhourpermeterperC() {
			return kilocalorieITperhourpermeterperC;
		}

		public void setKilocalorieITperhourpermeterperC(
				double kilocalorieITperhourpermeterperC) {
			this.kilocalorieITperhourpermeterperC = kilocalorieITperhourpermeterperC;
		}

		public double getKilocaloriethperhourpermeterperC() {
			return kilocaloriethperhourpermeterperC;
		}

		public void setKilocaloriethperhourpermeterperC(
				double kilocaloriethperhourpermeterperC) {
			this.kilocaloriethperhourpermeterperC = kilocaloriethperhourpermeterperC;
		}

		public double getBtuITinchpersecondpersqfootperF() {
			return BtuITinchpersecondpersqfootperF;
		}

		public void setBtuITinchpersecondpersqfootperF(
				double btuITinchpersecondpersqfootperF) {
			BtuITinchpersecondpersqfootperF = btuITinchpersecondpersqfootperF;
		}

		public double getBtuthinchpersecondpersqfootperF() {
			return BtuthinchpersecondpersqfootperF;
		}

		public void setBtuthinchpersecondpersqfootperF(
				double btuthinchpersecondpersqfootperF) {
			BtuthinchpersecondpersqfootperF = btuthinchpersecondpersqfootperF;
		}

		public double getBtuITfootperhourpersqfootperF() {
			return BtuITfootperhourpersqfootperF;
		}

		public void setBtuITfootperhourpersqfootperF(
				double btuITfootperhourpersqfootperF) {
			BtuITfootperhourpersqfootperF = btuITfootperhourpersqfootperF;
		}

		public double getBtuthfootperhourpersqfootperF() {
			return BtuthfootperhourpersqfootperF;
		}

		public void setBtuthfootperhourpersqfootperF(
				double btuthfootperhourpersqfootperF) {
			BtuthfootperhourpersqfootperF = btuthfootperhourpersqfootperF;
		}

		public double getBtuITinchperhourpersqfootperF() {
			return BtuITinchperhourpersqfootperF;
		}

		public void setBtuITinchperhourpersqfootperF(
				double btuITinchperhourpersqfootperF) {
			BtuITinchperhourpersqfootperF = btuITinchperhourpersqfootperF;
		}

		public double getBtuthinchperhourpersqfootperF() {
			return BtuthinchperhourpersqfootperF;
		}

		public void setBtuthinchperhourpersqfootperF(double BtuthinchperhourpersqfootperF) {
			this.BtuthinchperhourpersqfootperF = BtuthinchperhourpersqfootperF;
		}
		
	}
}