package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;


public class TemperatureIntervalConverter {

	private double kelvin,degreeCelsius,degreecentigrade,degreeFahrenheit,degreeRankine,degreeReaumur;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public TemperatureIntervalConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateTemperatureIntervalConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{
		case "Kelvin -K":
			kelvin=(edtValue)*1;
			degreeCelsius=(edtValue)*1;
			degreecentigrade=(edtValue)*1;
			degreeFahrenheit=(edtValue)*1.8;
			degreeRankine=(edtValue)*1.8;
			degreeReaumur=(edtValue)*0.8;
			break;
		case "Degree Celsius -°C":
			kelvin=(edtValue)*1;
			degreeCelsius=(edtValue)*1;
			degreecentigrade=(edtValue)*1;
			degreeFahrenheit=(edtValue)*1.8;
			degreeRankine=(edtValue)*1.8;
			degreeReaumur=(edtValue)*0.8;
			break;
		case "Degree centigrade -°C":
			kelvin=(edtValue)*1;
			degreeCelsius=(edtValue)*1;
			degreecentigrade=(edtValue)*1;
			degreeFahrenheit=(edtValue)*1.8;
			degreeRankine=(edtValue)*1.8;
			degreeReaumur=(edtValue)*0.8;
			break;
		case "Degree Fahrenheit -°F":
			kelvin=(edtValue)*0.5555555556;
			degreeCelsius=(edtValue)*0.5555555556;
			degreecentigrade=(edtValue)*0.5555555556;
			degreeFahrenheit=(edtValue)*1;
			degreeRankine=(edtValue)*1;
			degreeReaumur=(edtValue)*0.4444444444;
			break;
		case "Degree Rankine -°R":
			kelvin=(edtValue)*0.5555555556;
			degreeCelsius=(edtValue)*0.5555555556;
			degreecentigrade=(edtValue)*0.5555555556;
			degreeFahrenheit=(edtValue)*1;
			degreeRankine=(edtValue)*1;
			degreeReaumur=(edtValue)*0.4444444444;
			break;
		case "Degree Reaumur -°r":
			kelvin=(edtValue)*1.25;
			degreeCelsius=(edtValue)*1.25;
			degreecentigrade=(edtValue)*1.25;
			degreeFahrenheit=(edtValue)*2.25;
			degreeRankine=(edtValue)*2.25;
			degreeReaumur=(edtValue)*1;
			break;
		case "Default":
			break;
			
		}
		results.setKelvin(kelvin);
		results.setDegreeCelsius(degreeCelsius);
		results.setDegreecentigrade(degreecentigrade);
		results.setDegreeFahrenheit(degreeFahrenheit);
		results.setDegreeRankine(degreeRankine);
		results.setDegreeReaumur(degreeReaumur);
		
	
		 
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double kelvin,degreeCelsius,degreecentigrade,degreeFahrenheit,degreeRankine,degreeReaumur;

		public double getKelvin() {
			return kelvin;
		}

		public void setKelvin(double kelvin) {
			this.kelvin = kelvin;
		}

		public double getDegreeCelsius() {
			return degreeCelsius;
		}

		public void setDegreeCelsius(double degreeCelsius) {
			this.degreeCelsius = degreeCelsius;
		}

		public double getDegreecentigrade() {
			return degreecentigrade;
		}

		public void setDegreecentigrade(double degreecentigrade) {
			this.degreecentigrade = degreecentigrade;
		}

		public double getDegreeFahrenheit() {
			return degreeFahrenheit;
		}

		public void setDegreeFahrenheit(double degreeFahrenheit) {
			this.degreeFahrenheit = degreeFahrenheit;
		}

		public double getDegreeRankine() {
			return degreeRankine;
		}

		public void setDegreeRankine(double degreeRankine) {
			this.degreeRankine = degreeRankine;
		}

		public double getDegreeReaumur() {
			return degreeReaumur;
		}

		public void setDegreeReaumur(double degreeReaumur) {
			this.degreeReaumur = degreeReaumur;
		}
		
	}
}