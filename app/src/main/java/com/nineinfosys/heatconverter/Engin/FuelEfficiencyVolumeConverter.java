package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;

public class FuelEfficiencyVolumeConverter {

	private double joulepercubicmeter,jouleperliter,megajoulepercubicmeter,kilojoulepercubicmeter,kilocalorieITpercubicmeter,calorieITpercubiccentimeter
	,thermpercubicfoot,thermpergallonUK,BtuITpercubicfoot,Btuthpercubicfoot,CHUpercubicfoot,cubicmeterperjoule,
	literperjoule,gallonUSperhorsepower,gallonUKperhorsepower;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public FuelEfficiencyVolumeConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateFuelEfficiencyVolumeConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{

		case "Joule/cubic meter -J/m^3":
			joulepercubicmeter=(edtValue)*1;
			jouleperliter=(edtValue)*0.001;
			megajoulepercubicmeter=(edtValue)*0.000001;
			kilojoulepercubicmeter=(edtValue)*0.001;
			kilocalorieITpercubicmeter=(edtValue)*0.0002388459;
			calorieITpercubiccentimeter=(edtValue)*2.388458966E-7;
			thermpercubicfoot=(edtValue)*2.683919173E-10;
			thermpergallonUK=(edtValue)*4.30886189E-11;
			BtuITpercubicfoot=(edtValue)*0.0000268392;
			Btuthpercubicfoot=(edtValue)*0.0000268572;
			CHUpercubicfoot=(edtValue)*0.0000149107;
			cubicmeterperjoule=(edtValue)*1;
			literperjoule=(edtValue)*1000;
			gallonUSperhorsepower=(edtValue)*709175035.87;
			gallonUKperhorsepower=(edtValue)*699473571.46;
			break;
		case "Joule/liter -J/L":
			joulepercubicmeter=(edtValue)*1000;
			jouleperliter=(edtValue)*1;
			megajoulepercubicmeter=(edtValue)*0.001;
			kilojoulepercubicmeter=(edtValue)*1;
			kilocalorieITpercubicmeter=(edtValue)*0.2388458966;
			calorieITpercubiccentimeter=(edtValue)*0.0002388459;
			thermpercubicfoot=(edtValue)*2.683919173E-7;
			thermpergallonUK=(edtValue)*4.30886189E-8;
			BtuITpercubicfoot=(edtValue)*0.026839192;
			Btuthpercubicfoot=(edtValue)*0.0268571532;
			CHUpercubicfoot=(edtValue)*0.0149106621;
			cubicmeterperjoule=(edtValue)*0.001;
			literperjoule=(edtValue)*1;
			gallonUSperhorsepower=(edtValue)*709175.03587;
			gallonUKperhorsepower=(edtValue)*699473.57146;
			break;
		case "Megajoule/cubic meter -mJ/m^3":
			joulepercubicmeter=(edtValue)*1000000;
			jouleperliter=(edtValue)*1000;
			megajoulepercubicmeter=(edtValue)*1;
			kilojoulepercubicmeter=(edtValue)*1000;
			kilocalorieITpercubicmeter=(edtValue)*238.8458966;
			calorieITpercubiccentimeter=(edtValue)*0.2388458966;
			thermpercubicfoot=(edtValue)*0.0002683919;
			thermpergallonUK=(edtValue)*0.0000430886;
			BtuITpercubicfoot=(edtValue)*26.839191993;
			Btuthpercubicfoot=(edtValue)*26.857153212;
			CHUpercubicfoot=(edtValue)*14.91066207;
			cubicmeterperjoule=(edtValue)*0.000001;
			literperjoule=(edtValue)*0.001;
			gallonUSperhorsepower=(edtValue)*709.17503587;
			gallonUKperhorsepower=(edtValue)*699.47357146;
			break;
		case "Kilojoule/cubic meter -kJ/m^3":
			joulepercubicmeter=(edtValue)*1000;
			jouleperliter=(edtValue)*1;
			megajoulepercubicmeter=(edtValue)*0.001;
			kilojoulepercubicmeter=(edtValue)*1;
			kilocalorieITpercubicmeter=(edtValue)*0.2388458966;
			calorieITpercubiccentimeter=(edtValue)*0.0002388459;
			thermpercubicfoot=(edtValue)*2.683919173E-7;
			thermpergallonUK=(edtValue)*4.30886189E-8;
			BtuITpercubicfoot=(edtValue)*0.026839192;
			Btuthpercubicfoot=(edtValue)*0.0268571532;
			CHUpercubicfoot=(edtValue)*0.0149106621;
			cubicmeterperjoule=(edtValue)*0.001;
			literperjoule=(edtValue)*1;
			gallonUSperhorsepower=(edtValue)*709175.03587;
			gallonUKperhorsepower=(edtValue)*699473.57146;
			break;
		case "Kilocalorie (IT)/cubic meter -kcal(IT)/m^3":
			joulepercubicmeter=(edtValue)*4186.8000005;
			jouleperliter=(edtValue)*4.1868000005;
			megajoulepercubicmeter=(edtValue)*0.0041868;
			kilojoulepercubicmeter=(edtValue)*4.1868000005;
			kilocalorieITpercubicmeter=(edtValue)*1;
			calorieITpercubiccentimeter=(edtValue)*0.001;
			thermpercubicfoot=(edtValue)*0.0000011237;
			thermpergallonUK=(edtValue)*1.804034296E-7;
			BtuITpercubicfoot=(edtValue)*0.1123703291;
			Btuthpercubicfoot=(edtValue)*0.1124455291;
			CHUpercubicfoot=(edtValue)*0.06242796;
			cubicmeterperjoule=(edtValue)*0.0002388459;
			literperjoule=(edtValue)*0.2388458966;
			gallonUSperhorsepower=(edtValue)*169383.54729;
			gallonUKperhorsepower=(edtValue)*167066.39232;
			break;
		case "Calorie (IT)/cubic centimeter -cal(IT)/cm^3":
			joulepercubicmeter=(edtValue)*4186800.0005;
			jouleperliter=(edtValue)*4186.8000005;
			megajoulepercubicmeter=(edtValue)*4.1868000005;
			kilojoulepercubicmeter=(edtValue)*4186.8000005;
			kilocalorieITpercubicmeter=(edtValue)*1000;
			calorieITpercubiccentimeter=(edtValue)*1;
			thermpercubicfoot=(edtValue)*0.0011237033;
			thermpergallonUK=(edtValue)*0.0001804034;
			BtuITpercubicfoot=(edtValue)*112.37032905;
			Btuthpercubicfoot=(edtValue)*112.44552908;
			CHUpercubicfoot=(edtValue)*62.427959962;
			cubicmeterperjoule=(edtValue)*2.388458966E-7;
			literperjoule=(edtValue)*0.0002388459;
			gallonUSperhorsepower=(edtValue)*169.38354729;
			gallonUKperhorsepower=(edtValue)*167.06639232;
			break;
		case "Therm/cubic foot -therm/ft^3":
			joulepercubicmeter=(edtValue)*3725894617.3;
			jouleperliter=(edtValue)*3725894.6173;
			megajoulepercubicmeter=(edtValue)*3725.8946173;
			kilojoulepercubicmeter=(edtValue)*3725894.6173;
			kilocalorieITpercubicmeter=(edtValue)*889914.64051;
			calorieITpercubiccentimeter=(edtValue)*889.91464051;
			thermpercubicfoot=(edtValue)*1;
			thermpergallonUK=(edtValue)*0.1605436532;
			BtuITpercubicfoot=(edtValue)*100000.00098;
			Btuthpercubicfoot=(edtValue)*100066.92259;
			CHUpercubicfoot=(edtValue)*55555.555547;
			cubicmeterperjoule=(edtValue)*2.683919173E-10;
			literperjoule=(edtValue)*2.683919173E-7;
			gallonUSperhorsepower=(edtValue)*0.1903368476;
			gallonUKperhorsepower=(edtValue)*0.1877330529;
			break;
		case "Therm/gallon (UK) -therm/gal":
			joulepercubicmeter=(edtValue)*23207984510.0;
			jouleperliter=(edtValue)*23207984.51;
			megajoulepercubicmeter=(edtValue)*23207.98451;
			kilojoulepercubicmeter=(edtValue)*23207984.51;
			kilocalorieITpercubicmeter=(edtValue)*5543131.8686;
			calorieITpercubiccentimeter=(edtValue)*5543.1318686;
			thermpercubicfoot=(edtValue)*6.2288354594;
			thermpergallonUK=(edtValue)*1;
			BtuITpercubicfoot=(edtValue)*622883.55205;
			Btuthpercubicfoot=(edtValue)*623300.39572;
			CHUpercubicfoot=(edtValue)*346046.41436;
			cubicmeterperjoule=(edtValue)*4.30886189E-11;
			literperjoule=(edtValue)*4.30886189E-8;
			gallonUSperhorsepower=(edtValue)*0.0305573729;
			gallonUKperhorsepower=(edtValue)*0.0301393502;
			break;
		case "Btu (IT)/cubic foot -Btu/ft^3":
			joulepercubicmeter=(edtValue)*37258.945808;
			jouleperliter=(edtValue)*37.258945808;
			megajoulepercubicmeter=(edtValue)*0.0372589458;
			kilojoulepercubicmeter=(edtValue)*37.258945808;
			kilocalorieITpercubicmeter=(edtValue)*8.8991463178;
			calorieITpercubiccentimeter=(edtValue)*0.0088991463;
			thermpercubicfoot=(edtValue)*0.00001;
			thermpergallonUK=(edtValue)*0.0000016054;
			BtuITpercubicfoot=(edtValue)*1;
			Btuthpercubicfoot=(edtValue)*1.0006692161;
			CHUpercubicfoot=(edtValue)*0.55555555;
			cubicmeterperjoule=(edtValue)*0.0000268392;
			literperjoule=(edtValue)*0.026839192;
			gallonUSperhorsepower=(edtValue)*19033.684944;
			gallonUKperhorsepower=(edtValue)*18773.305479;
			break;
		case "Btu (th)/cubic foot -Btu (th)/ft^3":
			joulepercubicmeter=(edtValue)*37234.028198;
			jouleperliter=(edtValue)*37.234028198;
			megajoulepercubicmeter=(edtValue)*0.0372340282;
			kilojoulepercubicmeter=(edtValue)*37.234028198;
			kilocalorieITpercubicmeter=(edtValue)*8.893194849;
			calorieITpercubiccentimeter=(edtValue)*0.0088931948;
			thermpercubicfoot=(edtValue)*0.0000099933;
			thermpergallonUK=(edtValue)*0.0000016044;
			BtuITpercubicfoot=(edtValue)*0.9993312315;
			Btuthpercubicfoot=(edtValue)*1;
			CHUpercubicfoot=(edtValue)*0.555184012;
			cubicmeterperjoule=(edtValue)*0.0000268572;
			literperjoule=(edtValue)*0.0268571532;
			gallonUSperhorsepower=(edtValue)*19046.422592;
			gallonUKperhorsepower=(edtValue)*18785.868876;
			break;
		case "CHU/cubic foot -CHU/ft^3":
			joulepercubicmeter=(edtValue)*67066.103122;
			jouleperliter=(edtValue)*67.066103122;
			megajoulepercubicmeter=(edtValue)*0.0670661031;
			kilojoulepercubicmeter=(edtValue)*67.066103122;
			kilocalorieITpercubicmeter=(edtValue)*16.018463532;
			calorieITpercubiccentimeter=(edtValue)*0.0160184635;
			thermpercubicfoot=(edtValue)*0.000018;
			thermpergallonUK=(edtValue)*0.0000028898;
			BtuITpercubicfoot=(edtValue)*1.8000000179;
			Btuthpercubicfoot=(edtValue)*1.8012046068;
			CHUpercubicfoot=(edtValue)*1;
			cubicmeterperjoule=(edtValue)*0.0000149107;
			literperjoule=(edtValue)*0.0149106621;
			gallonUSperhorsepower=(edtValue)*10574.269308;
			gallonUKperhorsepower=(edtValue)*10429.614051;
			break;
		case "Cubic meter/joule -m^3/J":
			joulepercubicmeter=(edtValue)*1;
			jouleperliter=(edtValue)*0.001;
			megajoulepercubicmeter=(edtValue)*0.000001;
			kilojoulepercubicmeter=(edtValue)*0.001;
			kilocalorieITpercubicmeter=(edtValue)*0.0002388459;
			calorieITpercubiccentimeter=(edtValue)*2.388458966E-7;
			thermpercubicfoot=(edtValue)*2.683919173E-10;
			thermpergallonUK=(edtValue)*4.30886189E-11;
			BtuITpercubicfoot=(edtValue)*0.0000268392;
			Btuthpercubicfoot=(edtValue)*0.0000268572;
			CHUpercubicfoot=(edtValue)*0.0000149107;
			cubicmeterperjoule=(edtValue)*1;
			literperjoule=(edtValue)*1000;
			gallonUSperhorsepower=(edtValue)*709175035.87;
			gallonUKperhorsepower=(edtValue)*699473571.46;
			break;
		case "Liter/joule -L/J":
			joulepercubicmeter=(edtValue)*1000;
			jouleperliter=(edtValue)*1;
			megajoulepercubicmeter=(edtValue)*0.001;
			kilojoulepercubicmeter=(edtValue)*1;
			kilocalorieITpercubicmeter=(edtValue)*0.2388458966;
			calorieITpercubiccentimeter=(edtValue)*0.0002388459;
			thermpercubicfoot=(edtValue)*2.683919173E-7;
			thermpergallonUK=(edtValue)*4.30886189E-8;
			BtuITpercubicfoot=(edtValue)*0.026839192;
			Btuthpercubicfoot=(edtValue)*0.0268571532;
			CHUpercubicfoot=(edtValue)*0.0149106621;
			cubicmeterperjoule=(edtValue)*0.001;
			literperjoule=(edtValue)*1;
			gallonUSperhorsepower=(edtValue)*709175.03587;
			gallonUKperhorsepower=(edtValue)*699473.57146;
			break;
		case "Gallon (US)/horsepower -gal(US)/hp":
			joulepercubicmeter=(edtValue)*709175035.87;
			jouleperliter=(edtValue)*709175.03587;
			megajoulepercubicmeter=(edtValue)*709.17503587;
			kilojoulepercubicmeter=(edtValue)*709175.03587;
			kilocalorieITpercubicmeter=(edtValue)*169383.54729;
			calorieITpercubiccentimeter=(edtValue)*169.38354729;
			thermpercubicfoot=(edtValue)*0.1903368476;
			thermpergallonUK=(edtValue)*0.0305573729;
			BtuITpercubicfoot=(edtValue)*19033.684944;
			Btuthpercubicfoot=(edtValue)*19046.422592;
			CHUpercubicfoot=(edtValue)*10574.269308;
			cubicmeterperjoule=(edtValue)*1.410089116E-9;
			literperjoule=(edtValue)*0.0000014101;
			gallonUSperhorsepower=(edtValue)*1;
			gallonUKperhorsepower=(edtValue)*0.9863200706;
			break;
		case "Gallon (UK)/horsepower -gal(UK)/hp":
			joulepercubicmeter=(edtValue)*699473571.46;
			jouleperliter=(edtValue)*699473.57146;
			megajoulepercubicmeter=(edtValue)*699.47357146;
			kilojoulepercubicmeter=(edtValue)*699473.57146;
			kilocalorieITpercubicmeter=(edtValue)*167066.39232;
			calorieITpercubiccentimeter=(edtValue)*167.06639232;
			thermpercubicfoot=(edtValue)*0.1877330529;
			thermpergallonUK=(edtValue)*0.0301393502;
			BtuITpercubicfoot=(edtValue)*18773.305479;
			Btuthpercubicfoot=(edtValue)*18785.868876;
			CHUpercubicfoot=(edtValue)*10429.614051;
			cubicmeterperjoule=(edtValue)*1.429646581E-9;
			literperjoule=(edtValue)*0.0000014296;
			gallonUSperhorsepower=(edtValue)*1.0138696654;
			gallonUKperhorsepower=(edtValue)*1;
			break;
		case "Default":
			break;
			
			
		}
		results.setJoulepercubicmeter(joulepercubicmeter);
		results.setJouleperliter(jouleperliter);
		results.setMegajoulepercubicmeter(megajoulepercubicmeter);
		results.setKilojoulepercubicmeter(kilojoulepercubicmeter);
		results.setKilocalorieITpercubicmeter(kilocalorieITpercubicmeter);
		results.setCalorieITpercubiccentimeter(calorieITpercubiccentimeter);
		results.setThermpercubicfoot(thermpercubicfoot);
		results.setThermpergallonUK(thermpergallonUK);
		results.setBtuITpercubicfoot(BtuITpercubicfoot);
		results.setBtuthpercubicfoot(Btuthpercubicfoot);
		results.setCHUpercubicfoot(CHUpercubicfoot);
		results.setCubicmeterperjoule(cubicmeterperjoule);
		results.setLiterperjoule(literperjoule);
		results.setGallonUSperhorsepower(gallonUSperhorsepower);
		results.setGallonUKperhorsepower(gallonUKperhorsepower);
		
		
		 
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double joulepercubicmeter,jouleperliter,megajoulepercubicmeter,kilojoulepercubicmeter,kilocalorieITpercubicmeter,calorieITpercubiccentimeter
		,thermpercubicfoot,thermpergallonUK,BtuITpercubicfoot,Btuthpercubicfoot,CHUpercubicfoot,cubicmeterperjoule,
		literperjoule,gallonUSperhorsepower,gallonUKperhorsepower;

		public double getJoulepercubicmeter() {
			return joulepercubicmeter;
		}

		public void setJoulepercubicmeter(double joulepercubicmeter) {
			this.joulepercubicmeter = joulepercubicmeter;
		}

		public double getJouleperliter() {
			return jouleperliter;
		}

		public void setJouleperliter(double jouleperliter) {
			this.jouleperliter = jouleperliter;
		}

		public double getMegajoulepercubicmeter() {
			return megajoulepercubicmeter;
		}

		public void setMegajoulepercubicmeter(double megajoulepercubicmeter) {
			this.megajoulepercubicmeter = megajoulepercubicmeter;
		}

		public double getKilojoulepercubicmeter() {
			return kilojoulepercubicmeter;
		}

		public void setKilojoulepercubicmeter(double kilojoulepercubicmeter) {
			this.kilojoulepercubicmeter = kilojoulepercubicmeter;
		}

		public double getKilocalorieITpercubicmeter() {
			return kilocalorieITpercubicmeter;
		}

		public void setKilocalorieITpercubicmeter(double kilocalorieITpercubicmeter) {
			this.kilocalorieITpercubicmeter = kilocalorieITpercubicmeter;
		}

		public double getCalorieITpercubiccentimeter() {
			return calorieITpercubiccentimeter;
		}

		public void setCalorieITpercubiccentimeter(double calorieITpercubiccentimeter) {
			this.calorieITpercubiccentimeter = calorieITpercubiccentimeter;
		}

		public double getThermpercubicfoot() {
			return thermpercubicfoot;
		}

		public void setThermpercubicfoot(double thermpercubicfoot) {
			this.thermpercubicfoot = thermpercubicfoot;
		}

		public double getThermpergallonUK() {
			return thermpergallonUK;
		}

		public void setThermpergallonUK(double thermpergallonUK) {
			this.thermpergallonUK = thermpergallonUK;
		}

		public double getBtuITpercubicfoot() {
			return BtuITpercubicfoot;
		}

		public void setBtuITpercubicfoot(double btuITpercubicfoot) {
			BtuITpercubicfoot = btuITpercubicfoot;
		}

		public double getBtuthpercubicfoot() {
			return Btuthpercubicfoot;
		}

		public void setBtuthpercubicfoot(double btuthpercubicfoot) {
			Btuthpercubicfoot = btuthpercubicfoot;
		}

		public double getCHUpercubicfoot() {
			return CHUpercubicfoot;
		}

		public void setCHUpercubicfoot(double cHUpercubicfoot) {
			CHUpercubicfoot = cHUpercubicfoot;
		}

		public double getCubicmeterperjoule() {
			return cubicmeterperjoule;
		}

		public void setCubicmeterperjoule(double cubicmeterperjoule) {
			this.cubicmeterperjoule = cubicmeterperjoule;
		}

		public double getLiterperjoule() {
			return literperjoule;
		}

		public void setLiterperjoule(double literperjoule) {
			this.literperjoule = literperjoule;
		}

		public double getGallonUSperhorsepower() {
			return gallonUSperhorsepower;
		}

		public void setGallonUSperhorsepower(double gallonUSperhorsepower) {
			this.gallonUSperhorsepower = gallonUSperhorsepower;
		}

		public double getGallonUKperhorsepower() {
			return gallonUKperhorsepower;
		}

		public void setGallonUKperhorsepower(double gallonUKperhorsepower) {
			this.gallonUKperhorsepower = gallonUKperhorsepower;
		}
		
	}
}