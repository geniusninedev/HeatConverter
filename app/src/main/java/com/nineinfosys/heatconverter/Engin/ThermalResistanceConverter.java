package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;

public class ThermalResistanceConverter {
	private double kelvinperwatt,degreeFahrenheithourperBtuIT,degreeFahrenheithourperBtuth,degreeFahrenheitsecondperBtuIT,degreeFahrenheitsecondperBtuth;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public ThermalResistanceConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateThermalResistanceConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{
		case "Kelvin/watt -K/W":
			kelvinperwatt=(edtValue)*1;
			degreeFahrenheithourperBtuIT=(edtValue)*0.5275279263;
			degreeFahrenheithourperBtuth=(edtValue)*0.5271751322;
			degreeFahrenheitsecondperBtuIT=(edtValue)*1899.1005347;
			degreeFahrenheitsecondperBtuth=(edtValue)*1897.8304761;
			break;
		case "Degree Fahrenheit hour/Btu (IT) -°Fh/Btu(IT)":
			kelvinperwatt=(edtValue)*1.8956342406;
			degreeFahrenheithourperBtuIT=(edtValue)*1;
			degreeFahrenheithourperBtuth=(edtValue)*0.9993312315;
			degreeFahrenheitsecondperBtuIT=(edtValue)*3600;
			degreeFahrenheitsecondperBtuth=(edtValue)*3597.5924334;
			break;
		case "Degree Fahrenheit hour/Btu (th) -°Fh/Btu(th)":
			kelvinperwatt=(edtValue)*1.8969028295;
			degreeFahrenheithourperBtuIT=(edtValue)*1.0006692161;
			degreeFahrenheithourperBtuth=(edtValue)*1;
			degreeFahrenheitsecondperBtuIT=(edtValue)*3602.4091778;
			degreeFahrenheitsecondperBtuth=(edtValue)*3600;
			break;
		case "Degree Fahrenheit second/Btu (IT) -°Fs/Btu(IT)":
			kelvinperwatt=(edtValue)*0.0005265651;
			degreeFahrenheithourperBtuIT=(edtValue)*0.0002777778;
			degreeFahrenheithourperBtuth=(edtValue)*0.000277592;
			degreeFahrenheitsecondperBtuIT=(edtValue)*1;
			degreeFahrenheitsecondperBtuth=(edtValue)*0.9993312315;
			break;
		case "Degree Fahrenheit second/Btu (th) -°Fs/Btu(th)":
			kelvinperwatt=(edtValue)*0.0005269175;
			degreeFahrenheithourperBtuIT=(edtValue)*0.0002779637;
			degreeFahrenheithourperBtuth=(edtValue)*0.0002777778;
			degreeFahrenheitsecondperBtuIT=(edtValue)*1.0006692161;
			degreeFahrenheitsecondperBtuth=(edtValue)*1;
			break;
		case "Default":
			break;
			
		}
		results.setKelvinperwatt(kelvinperwatt);
		results.setDegreeFahrenheithourperBtuIT(degreeFahrenheithourperBtuIT);
		results.setDegreeFahrenheithourperBtuth(degreeFahrenheithourperBtuth);
		results.setDegreeFahrenheitsecondperBtuIT(degreeFahrenheitsecondperBtuIT);
		results.setDegreeFahrenheitsecondperBtuth(degreeFahrenheitsecondperBtuth);
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double kelvinperwatt,degreeFahrenheithourperBtuIT,degreeFahrenheithourperBtuth,degreeFahrenheitsecondperBtuIT,degreeFahrenheitsecondperBtuth;

		public double getKelvinperwatt() {
			return kelvinperwatt;
		}

		public void setKelvinperwatt(double kelvinperwatt) {
			this.kelvinperwatt = kelvinperwatt;
		}

		public double getDegreeFahrenheithourperBtuIT() {
			return degreeFahrenheithourperBtuIT;
		}

		public void setDegreeFahrenheithourperBtuIT(double degreeFahrenheithourperBtuIT) {
			this.degreeFahrenheithourperBtuIT = degreeFahrenheithourperBtuIT;
		}

		public double getDegreeFahrenheithourperBtuth() {
			return degreeFahrenheithourperBtuth;
		}

		public void setDegreeFahrenheithourperBtuth(double degreeFahrenheithourperBtuth) {
			this.degreeFahrenheithourperBtuth = degreeFahrenheithourperBtuth;
		}

		public double getDegreeFahrenheitsecondperBtuIT() {
			return degreeFahrenheitsecondperBtuIT;
		}

		public void setDegreeFahrenheitsecondperBtuIT(
				double degreeFahrenheitsecondperBtuIT) {
			this.degreeFahrenheitsecondperBtuIT = degreeFahrenheitsecondperBtuIT;
		}

		public double getDegreeFahrenheitsecondperBtuth() {
			return degreeFahrenheitsecondperBtuth;
		}

		public void setDegreeFahrenheitsecondperBtuth(
				double degreeFahrenheitsecondperBtuth) {
			this.degreeFahrenheitsecondperBtuth = degreeFahrenheitsecondperBtuth;
		}
		
	}
}