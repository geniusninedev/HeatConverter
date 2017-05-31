package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;

public class ThermalExpansionConverter {
	private double lengthperlengthperkelvin,lengthperlengthperdegreeCelsius,lengthperlengthperdegreeFahrenheit,lengthperlengthperdegreeRankine,lengthperlengthperdegreeReaumur;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public ThermalExpansionConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateThermalExpansionConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{
		case "Length/length/kelvin -1/K":
			lengthperlengthperkelvin=(edtValue)*1;
			lengthperlengthperdegreeCelsius=(edtValue)*1;
			lengthperlengthperdegreeFahrenheit=(edtValue)*0.5555555556;
			lengthperlengthperdegreeRankine=(edtValue)*0.5555555556;
			lengthperlengthperdegreeReaumur=(edtValue)*1.25;
			break;
		case "Length/length/degree Celsius -1/°C":
			lengthperlengthperkelvin=(edtValue)*1;
			lengthperlengthperdegreeCelsius=(edtValue)*1;
			lengthperlengthperdegreeFahrenheit=(edtValue)*0.5555555556;
			lengthperlengthperdegreeRankine=(edtValue)*0.5555555556;
			lengthperlengthperdegreeReaumur=(edtValue)*1.25;
			break;
		case "Length/length/degree Fahrenheit -1/°F":
			lengthperlengthperkelvin=(edtValue)*1.8;
			lengthperlengthperdegreeCelsius=(edtValue)*1.8;
			lengthperlengthperdegreeFahrenheit=(edtValue)*1;
			lengthperlengthperdegreeRankine=(edtValue)*1;
			lengthperlengthperdegreeReaumur=(edtValue)*25;
			break;
		case "Length/length/degree Rankine -1/R°":
			lengthperlengthperkelvin=(edtValue)*1.8;
			lengthperlengthperdegreeCelsius=(edtValue)*1.8;
			lengthperlengthperdegreeFahrenheit=(edtValue)*1;
			lengthperlengthperdegreeRankine=(edtValue)*1;
			lengthperlengthperdegreeReaumur=(edtValue)*2.25;
			break;
		case "Length/length/degree Reaumur -1/r°":
			lengthperlengthperkelvin=(edtValue)*0.8;
			lengthperlengthperdegreeCelsius=(edtValue)*0.8;
			lengthperlengthperdegreeFahrenheit=(edtValue)*0.4444444444;
			lengthperlengthperdegreeRankine=(edtValue)*0.4444444444;
			lengthperlengthperdegreeReaumur=(edtValue)*1;
			break;
		case "Default":
			break;
			
		}
		results.setLengthperlengthperkelvin(lengthperlengthperkelvin);
		results.setLengthperlengthperdegreeCelsius(lengthperlengthperdegreeCelsius);
		results.setLengthperlengthperdegreeFahrenheit(lengthperlengthperdegreeFahrenheit);
		results.setLengthperlengthperdegreeRankine(lengthperlengthperdegreeRankine);
		results.setLengthperlengthperdegreeReaumur(lengthperlengthperdegreeReaumur);
		
	
		 
		 converterArray.add(results);
		return converterArray;
}

public class ConversionResults{
		private double lengthperlengthperkelvin,lengthperlengthperdegreeCelsius,lengthperlengthperdegreeFahrenheit,lengthperlengthperdegreeRankine,lengthperlengthperdegreeReaumur;

		public double getLengthperlengthperkelvin() {
			return lengthperlengthperkelvin;
		}

		public void setLengthperlengthperkelvin(double lengthperlengthperkelvin) {
			this.lengthperlengthperkelvin = lengthperlengthperkelvin;
		}

		public double getLengthperlengthperdegreeCelsius() {
			return lengthperlengthperdegreeCelsius;
		}

		public void setLengthperlengthperdegreeCelsius(
				double lengthperlengthperdegreeCelsius) {
			this.lengthperlengthperdegreeCelsius = lengthperlengthperdegreeCelsius;
		}

		public double getLengthperlengthperdegreeFahrenheit() {
			return lengthperlengthperdegreeFahrenheit;
		}

		public void setLengthperlengthperdegreeFahrenheit(
				double lengthperlengthperdegreeFahrenheit) {
			this.lengthperlengthperdegreeFahrenheit = lengthperlengthperdegreeFahrenheit;
		}

		public double getLengthperlengthperdegreeRankine() {
			return lengthperlengthperdegreeRankine;
		}

		public void setLengthperlengthperdegreeRankine(
				double lengthperlengthperdegreeRankine) {
			this.lengthperlengthperdegreeRankine = lengthperlengthperdegreeRankine;
		}

		public double getLengthperlengthperdegreeReaumur() {
			return lengthperlengthperdegreeReaumur;
		}

		public void setLengthperlengthperdegreeReaumur(
				double lengthperlengthperdegreeReaumur) {
			this.lengthperlengthperdegreeReaumur = lengthperlengthperdegreeReaumur;
		}
		
	}
}