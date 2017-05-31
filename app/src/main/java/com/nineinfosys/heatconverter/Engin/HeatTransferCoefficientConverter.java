package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;

public class HeatTransferCoefficientConverter {

	private double wattpersquaremeterperK,wattpersquaremeterperb0C,joulepersecondpersquaremeterperK,calorieITpersecondpersquarecentimeterperb0C,kilocalorieITperhourpersquaremeterperb0C,
	kilocalorieITperhourpersquarefootperb0C,BtuITpersecondpersquarefootperb0F,Btuthpersecondpersquarefootperb0F,BtuITperhourpersquarefootperb0F,Btuthperhourpersquarefootperb0F,
	CHUperhourpersquarefootperb0C;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public HeatTransferCoefficientConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateHeatTransferCoefficientConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{
		case "Watt/square meter/K -W/m^2/K":
			wattpersquaremeterperK=(edtValue)*1;
			wattpersquaremeterperb0C=(edtValue)*1;
			joulepersecondpersquaremeterperK=(edtValue)*1;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.0000238846;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*0.8598452279;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.0798822356;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0000489195;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0000489522;
			BtuITperhourpersquarefootperb0F=(edtValue)*0.1761101837;
			Btuthperhourpersquarefootperb0F=(edtValue)*0.1762280394;
			CHUperhourpersquarefootperb0C=(edtValue)*0.1761101837;
			break;
		case "Watt/square meter/%b0C -W/m^2/%b0C":
			wattpersquaremeterperK=(edtValue)*1;
			wattpersquaremeterperb0C=(edtValue)*1;
			joulepersecondpersquaremeterperK=(edtValue)*1;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.0000238846;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*0.8598452279;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.0798822356;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0000489195;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0000489522;
			BtuITperhourpersquarefootperb0F=(edtValue)*0.1761101837;
			Btuthperhourpersquarefootperb0F=(edtValue)*0.1762280394;
			CHUperhourpersquarefootperb0C=(edtValue)*0.1761101837;
			break;
		case "Joule/second/square meter/K -J/s/m^2/K":
			wattpersquaremeterperK=(edtValue)*1;
			wattpersquaremeterperb0C=(edtValue)*1;
			joulepersecondpersquaremeterperK=(edtValue)*1;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.0000238846;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*0.8598452279;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.0798822356;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0000489195;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0000489522;
			BtuITperhourpersquarefootperb0F=(edtValue)*0.1761101837;
			Btuthperhourpersquarefootperb0F=(edtValue)*0.1762280394;
			CHUperhourpersquarefootperb0C=(edtValue)*0.1761101837;
			break;
		case "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C":
			wattpersquaremeterperK=(edtValue)*41868.000005;
			wattpersquaremeterperb0C=(edtValue)*41868.000005;
			joulepersecondpersquaremeterperK=(edtValue)*41868.000005;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*1;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*36000.000004;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*3344.5094388;
			BtuITpersecondpersquarefootperb0F=(edtValue)*2.0481614365;
			Btuthpersecondpersquarefootperb0F=(edtValue)*2.049532099;
			BtuITperhourpersquarefootperb0F=(edtValue)*7373.3811712;
			Btuthperhourpersquarefootperb0F=(edtValue)*7378.3155564;
			CHUperhourpersquarefootperb0C=(edtValue)*7373.3811712;
			break;
		case "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C":
			wattpersquaremeterperK=(edtValue)*1.163;
			wattpersquaremeterperb0C=(edtValue)*1.163;
			joulepersecondpersquaremeterperK=(edtValue)*1.163;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.0000277778;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*1;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.09290304;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0000568934;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0000569314;
			BtuITperhourpersquarefootperb0F=(edtValue)*0.2048161436;
			Btuthperhourpersquarefootperb0F=(edtValue)*0.2049532099;
			CHUperhourpersquarefootperb0C=(edtValue)*0.2048161436;
			break;
		case "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C":
			wattpersquaremeterperK=(edtValue)*12.518427821;
			wattpersquaremeterperb0C=(edtValue)*12.518427821;
			joulepersecondpersquaremeterperK=(edtValue)*12.518427821;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.0002989975;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*10.763910422;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*1;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0006123952;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.000612805;
			BtuITperhourpersquarefootperb0F=(edtValue)*2.2046226229;
			Btuthperhourpersquarefootperb0F=(edtValue)*2.2060979918;
			CHUperhourpersquarefootperb0C=(edtValue)*2.2046226229;
			break;
		case "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F":
			wattpersquaremeterperK=(edtValue)*20441.748028;
			wattpersquaremeterperb0C=(edtValue)*20441.748028;
			joulepersecondpersquaremeterperK=(edtValue)*20441.748028;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.4882427636;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*17576.739491;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*1632.9325312;
			BtuITpersecondpersquarefootperb0F=(edtValue)*1;
			Btuthpersecondpersquarefootperb0F=(edtValue)*1.0006692161;
			BtuITperhourpersquarefootperb0F=(edtValue)*3600;
			Btuthperhourpersquarefootperb0F=(edtValue)*3602.4091778;
			CHUperhourpersquarefootperb0C=(edtValue)*3600;
			break;
		case "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F":
			wattpersquaremeterperK=(edtValue)*20428.077231;
			wattpersquaremeterperb0C=(edtValue)*20428.077231;
			joulepersecondpersquaremeterperK=(edtValue)*20428.077231;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.4879162422;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*17564.984721;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*1631.8404774;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.9993312315;
			Btuthpersecondpersquarefootperb0F=(edtValue)*1;
			BtuITperhourpersquarefootperb0F=(edtValue)*3597.5924334;
			Btuthperhourpersquarefootperb0F=(edtValue)*3600;
			CHUperhourpersquarefootperb0C=(edtValue)*3597.5924334;
			break;
		case "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F":
			wattpersquaremeterperK=(edtValue)*5.6782633411;
			wattpersquaremeterperb0C=(edtValue)*5.6782633411;
			joulepersecondpersquaremeterperK=(edtValue)*5.6782633411;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.000135623;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*4.8824276364;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.4535923698;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0002777778;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0002779637;
			BtuITperhourpersquarefootperb0F=(edtValue)*1;
			Btuthperhourpersquarefootperb0F=(edtValue)*1.0006692161;
			CHUperhourpersquarefootperb0C=(edtValue)*1;
			break;
		case "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F":
			wattpersquaremeterperK=(edtValue)*5.6744658974;
			wattpersquaremeterperb0C=(edtValue)*5.6744658974;
			joulepersecondpersquaremeterperK=(edtValue)*5.6744658974;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.0001355323;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*4.8791624225;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.4532890215;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.000277592;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0002777778;
			BtuITperhourpersquarefootperb0F=(edtValue)*0.9993312315;
			Btuthperhourpersquarefootperb0F=(edtValue)*1;
			CHUperhourpersquarefootperb0C=(edtValue)*0.9993312315;
			break;
		case "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C":
			wattpersquaremeterperK=(edtValue)*5.6782633411;
			wattpersquaremeterperb0C=(edtValue)*5.6782633411;
			joulepersecondpersquaremeterperK=(edtValue)*5.6782633411;
			calorieITpersecondpersquarecentimeterperb0C=(edtValue)*0.000135623;
			kilocalorieITperhourpersquaremeterperb0C=(edtValue)*4.8824276364;
			kilocalorieITperhourpersquarefootperb0C=(edtValue)*0.4535923698;
			BtuITpersecondpersquarefootperb0F=(edtValue)*0.0002777778;
			Btuthpersecondpersquarefootperb0F=(edtValue)*0.0002779637;
			BtuITperhourpersquarefootperb0F=(edtValue)*1;
			Btuthperhourpersquarefootperb0F=(edtValue)*1.0006692161;
			CHUperhourpersquarefootperb0C=(edtValue)*1;
			break;
		case "Default":
			break;
			
			
		}
		results.setWattpersquaremeterperK(wattpersquaremeterperK);
		results.setWattpersquaremeterperb0C(wattpersquaremeterperb0C);
		results.setJoulepersecondpersquaremeterperK(joulepersecondpersquaremeterperK);
		results.setCalorieITpersecondpersquarecentimeterperb0C(calorieITpersecondpersquarecentimeterperb0C);
		results.setKilocalorieITperhourpersquaremeterperb0C(kilocalorieITperhourpersquaremeterperb0C);
		results.setKilocalorieITperhourpersquarefootperb0C(kilocalorieITperhourpersquarefootperb0C);
		results.setBtuITpersecondpersquarefootperb0F(BtuITpersecondpersquarefootperb0F);
		results.setBtuthpersecondpersquarefootperb0F(Btuthpersecondpersquarefootperb0F);
		results.setBtuITperhourpersquarefootperb0F(BtuITperhourpersquarefootperb0F);
		results.setBtuthperhourpersquarefootperb0F(Btuthperhourpersquarefootperb0F);
		results.setCHUperhourpersquarefootperb0C(CHUperhourpersquarefootperb0C);
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double wattpersquaremeterperK,wattpersquaremeterperb0C,joulepersecondpersquaremeterperK,calorieITpersecondpersquarecentimeterperb0C,kilocalorieITperhourpersquaremeterperb0C,
		kilocalorieITperhourpersquarefootperb0C,BtuITpersecondpersquarefootperb0F,Btuthpersecondpersquarefootperb0F,BtuITperhourpersquarefootperb0F,Btuthperhourpersquarefootperb0F,
		CHUperhourpersquarefootperb0C;

		public double getWattpersquaremeterperK() {
			return wattpersquaremeterperK;
		}

		public void setWattpersquaremeterperK(double wattpersquaremeterperK) {
			this.wattpersquaremeterperK = wattpersquaremeterperK;
		}

		public double getWattpersquaremeterperb0C() {
			return wattpersquaremeterperb0C;
		}

		public void setWattpersquaremeterperb0C(double wattpersquaremeterperb0c) {
			wattpersquaremeterperb0C = wattpersquaremeterperb0c;
		}

		public double getJoulepersecondpersquaremeterperK() {
			return joulepersecondpersquaremeterperK;
		}

		public void setJoulepersecondpersquaremeterperK(
				double joulepersecondpersquaremeterperK) {
			this.joulepersecondpersquaremeterperK = joulepersecondpersquaremeterperK;
		}

		public double getCalorieITpersecondpersquarecentimeterperb0C() {
			return calorieITpersecondpersquarecentimeterperb0C;
		}

		public void setCalorieITpersecondpersquarecentimeterperb0C(
				double calorieITpersecondpersquarecentimeterperb0C) {
			this.calorieITpersecondpersquarecentimeterperb0C = calorieITpersecondpersquarecentimeterperb0C;
		}

		public double getKilocalorieITperhourpersquaremeterperb0C() {
			return kilocalorieITperhourpersquaremeterperb0C;
		}

		public void setKilocalorieITperhourpersquaremeterperb0C(
				double kilocalorieITperhourpersquaremeterperb0C) {
			this.kilocalorieITperhourpersquaremeterperb0C = kilocalorieITperhourpersquaremeterperb0C;
		}

		public double getKilocalorieITperhourpersquarefootperb0C() {
			return kilocalorieITperhourpersquarefootperb0C;
		}

		public void setKilocalorieITperhourpersquarefootperb0C(
				double kilocalorieITperhourpersquarefootperb0C) {
			this.kilocalorieITperhourpersquarefootperb0C = kilocalorieITperhourpersquarefootperb0C;
		}

		public double getBtuITpersecondpersquarefootperb0F() {
			return BtuITpersecondpersquarefootperb0F;
		}

		public void setBtuITpersecondpersquarefootperb0F(
				double btuITpersecondpersquarefootperb0F) {
			BtuITpersecondpersquarefootperb0F = btuITpersecondpersquarefootperb0F;
		}

		public double getBtuthpersecondpersquarefootperb0F() {
			return Btuthpersecondpersquarefootperb0F;
		}

		public void setBtuthpersecondpersquarefootperb0F(
				double btuthpersecondpersquarefootperb0f) {
			Btuthpersecondpersquarefootperb0F = btuthpersecondpersquarefootperb0f;
		}

		public double getBtuITperhourpersquarefootperb0F() {
			return BtuITperhourpersquarefootperb0F;
		}

		public void setBtuITperhourpersquarefootperb0F(
				double btuITperhourpersquarefootperb0F) {
			BtuITperhourpersquarefootperb0F = btuITperhourpersquarefootperb0F;
		}

		public double getBtuthperhourpersquarefootperb0F() {
			return Btuthperhourpersquarefootperb0F;
		}

		public void setBtuthperhourpersquarefootperb0F(
				double btuthperhourpersquarefootperb0f) {
			Btuthperhourpersquarefootperb0F = btuthperhourpersquarefootperb0f;
		}

		public double getCHUperhourpersquarefootperb0C() {
			return CHUperhourpersquarefootperb0C;
		}

		public void setCHUperhourpersquarefootperb0C(
				double cHUperhourpersquarefootperb0C) {
			CHUperhourpersquarefootperb0C = cHUperhourpersquarefootperb0C;
		}
		
	}
}