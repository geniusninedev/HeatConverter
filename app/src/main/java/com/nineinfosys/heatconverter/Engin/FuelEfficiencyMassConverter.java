package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;


public class FuelEfficiencyMassConverter {

	private double jouleperkilogram,kilojouleperkilogram,calorieITpergram,caloriethpergram,BtuITperpound,Btuthperpound
	,kilogramperjoule,kilogramperkilojoule,grampercalorieIT,grampercalorieth,poundperBtuIT,poundperBtuth,
	poundperhorsepowerperhour,gramperhorsepowermetricperhour,gramperkilowattperhour;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public FuelEfficiencyMassConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateFuelEfficiencyMassConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{

		case "Joule/kilogram -J/kg":
			jouleperkilogram=(edtValue)*1;
			kilojouleperkilogram=(edtValue)*0.001;
			calorieITpergram=(edtValue)*0.0002388459;
			caloriethpergram=(edtValue)*0.0002390057;
			BtuITperpound=(edtValue)*0.0004299226;
			Btuthperpound=(edtValue)*0.0004302103;
			kilogramperjoule=(edtValue)*1;
			kilogramperkilojoule=(edtValue)*1000;
			grampercalorieIT=(edtValue)*4186.8;
			grampercalorieth=(edtValue)*4184;
			poundperBtuIT=(edtValue)*2326;
			poundperBtuth=(edtValue)*2324.4444444;
			poundperhorsepowerperhour=(edtValue)*5918352.5016;
			gramperhorsepowermetricperhour=(edtValue)*2647795500.0;
			gramperkilowattperhour=(edtValue)*3600000000.0;
			break;
		case "Kilojoule/kilogram -kJ/kg":
			jouleperkilogram=(edtValue)*1000;
			kilojouleperkilogram=(edtValue)*1;
			calorieITpergram=(edtValue)*0.2388458966;
			caloriethpergram=(edtValue)*0.2390057361;
			BtuITperpound=(edtValue)*0.4299226139;
			Btuthperpound=(edtValue)*0.430210325;
			kilogramperjoule=(edtValue)*001;
			kilogramperkilojoule=(edtValue)*1;
			grampercalorieIT=(edtValue)*4.1868;
			grampercalorieth=(edtValue)*4.184;
			poundperBtuIT=(edtValue)*2.326;
			poundperBtuth=(edtValue)*2.3244444444;
			poundperhorsepowerperhour=(edtValue)*5918.3525016;
			gramperhorsepowermetricperhour=(edtValue)*2647795.5;
			gramperkilowattperhour=(edtValue)*3600000;
			break;
		case "Calorie (IT)/gram -cal/g":
			jouleperkilogram=(edtValue)*4186.8;
			kilojouleperkilogram=(edtValue)*4.1868;
			calorieITpergram=(edtValue)*1;
			caloriethpergram=(edtValue)*1.0006692161;
			BtuITperpound=(edtValue)*1.8;
			Btuthperpound=(edtValue)*1.8012045889;
			kilogramperjoule=(edtValue)*0.0002388459;
			kilogramperkilojoule=(edtValue)*0.2388458966;
			grampercalorieIT=(edtValue)*1;
			grampercalorieth=(edtValue)*0.9993312315;
			poundperBtuIT=(edtValue)*0.5555555556;
			poundperBtuth=(edtValue)*0.5551840175;
			poundperhorsepowerperhour=(edtValue)*1413.5742098;
			gramperhorsepowermetricperhour=(edtValue)*632415.09028;
			gramperkilowattperhour=(edtValue)*859845.22786;
			break;
		case "Calorie (th)/gram -cal(th)/g":
			jouleperkilogram=(edtValue)*4184;
			kilojouleperkilogram=(edtValue)*4.184;
			calorieITpergram=(edtValue)*0.9993312315;
			caloriethpergram=(edtValue)*1;
			BtuITperpound=(edtValue)*1.7987962167;
			Btuthperpound=(edtValue)*1.8;
			kilogramperjoule=(edtValue)*0.0002390057;
			kilogramperkilojoule=(edtValue)*0.2390057361;
			grampercalorieIT=(edtValue)*1.0006692161;
			grampercalorieth=(edtValue)*1;
			poundperBtuIT=(edtValue)*0.5559273423;
			poundperBtuth=(edtValue)*0.5555555556;
			poundperhorsepowerperhour=(edtValue)*1414.5201964;
			gramperhorsepowermetricperhour=(edtValue)*632838.31262;
			gramperkilowattperhour=(edtValue)*860420.65009;
			break;
		case "Btu (IT)/pound -Btu/lb":
			jouleperkilogram=(edtValue)*2326;
			kilojouleperkilogram=(edtValue)*2.326;
			calorieITpergram=(edtValue)*0.5555555556;
			caloriethpergram=(edtValue)*0.5559273423;
			BtuITperpound=(edtValue)*1;
			Btuthperpound=(edtValue)*1.0006692161;
			kilogramperjoule=(edtValue)*0.0004299226;
			kilogramperkilojoule=(edtValue)*0.4299226139;
			grampercalorieIT=(edtValue)*1.8;
			grampercalorieth=(edtValue)*1.7987962167;
			poundperBtuIT=(edtValue)*1;
			poundperBtuth=(edtValue)*0.9993312315;
			poundperhorsepowerperhour=(edtValue)*2544.4335776;
			gramperhorsepowermetricperhour=(edtValue)*1138347.1625;
			gramperkilowattperhour=(edtValue)*1547721.4101;
			break;
		case "Btu (th)/pound -Btu(th)/lb":
			jouleperkilogram=(edtValue)*2324.4444444;
			kilojouleperkilogram=(edtValue)*2.3244444444;
			calorieITpergram=(edtValue)*0.5551840175;
			caloriethpergram=(edtValue)*0.5555555556;
			BtuITperpound=(edtValue)*0.9993312315;
			Btuthperpound=(edtValue)*1;
			kilogramperjoule=(edtValue)*0.0004302103;
			kilogramperkilojoule=(edtValue)*0.430210325;
			grampercalorieIT=(edtValue)*1.8012045889;
			grampercalorieth=(edtValue)*1.8;
			poundperBtuIT=(edtValue)*1.0006692161;
			poundperBtuth=(edtValue)*1;
			poundperhorsepowerperhour=(edtValue)*2546.1363535;
			gramperhorsepowermetricperhour=(edtValue)*1139108.9627;
			gramperkilowattperhour=(edtValue)*1548757.1702;
			break;
		case "Kilogram/joule -kg/T":
			jouleperkilogram=(edtValue)*1;
			kilojouleperkilogram=(edtValue)*0.001;
			calorieITpergram=(edtValue)*0.0002388459;
			caloriethpergram=(edtValue)*0.0002390057;
			BtuITperpound=(edtValue)*0.0004299226;
			Btuthperpound=(edtValue)*0.0004302103;
			kilogramperjoule=(edtValue)*1;
			kilogramperkilojoule=(edtValue)*1000;
			grampercalorieIT=(edtValue)*4186.8;
			grampercalorieth=(edtValue)*4184;
			poundperBtuIT=(edtValue)*2326;
			poundperBtuth=(edtValue)*2324.4444444;
			poundperhorsepowerperhour=(edtValue)*5918352.5016;
			gramperhorsepowermetricperhour=(edtValue)*2647795500.0;
			gramperkilowattperhour=(edtValue)*3600000000.0;
			break;
		case "Kilogram/kilojoule -kg/kJ":
			jouleperkilogram=(edtValue)*1000;
			kilojouleperkilogram=(edtValue)*1;
			calorieITpergram=(edtValue)*0.2388458966;
			caloriethpergram=(edtValue)*0.2390057361;
			BtuITperpound=(edtValue)*0.4299226139;
			Btuthperpound=(edtValue)*0.430210325;
			kilogramperjoule=(edtValue)*0.001;
			kilogramperkilojoule=(edtValue)*1;
			grampercalorieIT=(edtValue)*4.1868;
			grampercalorieth=(edtValue)*4.184;
			poundperBtuIT=(edtValue)*2.326;
			poundperBtuth=(edtValue)*2.3244444444;
			poundperhorsepowerperhour=(edtValue)*5918.3525016;
			gramperhorsepowermetricperhour=(edtValue)*2647795.5;
			gramperkilowattperhour=(edtValue)*3600000;
			break;
		case "Gram/calorie (IT) -g/cal":
			jouleperkilogram=(edtValue)*4186.8;
			kilojouleperkilogram=(edtValue)*4.1868;
			calorieITpergram=(edtValue)*1;
			caloriethpergram=(edtValue)*1.0006692161;
			BtuITperpound=(edtValue)*1.8;
			Btuthperpound=(edtValue)*1.8012045889;
			kilogramperjoule=(edtValue)*0.0002388459;
			kilogramperkilojoule=(edtValue)*0.2388458966;
			grampercalorieIT=(edtValue)*1;
			grampercalorieth=(edtValue)*0.9993312315;
			poundperBtuIT=(edtValue)*0.5555555556;
			poundperBtuth=(edtValue)*0.5551840175;
			poundperhorsepowerperhour=(edtValue)*1413.5742098;
			gramperhorsepowermetricperhour=(edtValue)*632415.09028;
			gramperkilowattperhour=(edtValue)*859845.22786;
			break;
		case "Gram/calorie (th) -g/cal(th)":
			jouleperkilogram=(edtValue)*4184;
			kilojouleperkilogram=(edtValue)*4.184;
			calorieITpergram=(edtValue)*0.9993312315;
			caloriethpergram=(edtValue)*1;
			BtuITperpound=(edtValue)*1.7987962167;
			Btuthperpound=(edtValue)*1.8;
			kilogramperjoule=(edtValue)*0.0002390057;
			kilogramperkilojoule=(edtValue)*0.2390057361;
			grampercalorieIT=(edtValue)*1.0006692161;
			grampercalorieth=(edtValue)*1;
			poundperBtuIT=(edtValue)*0.5559273423;
			poundperBtuth=(edtValue)*0.5555555556;
			poundperhorsepowerperhour=(edtValue)*1414.5201964;
			gramperhorsepowermetricperhour=(edtValue)*632838.31262;
			gramperkilowattperhour=(edtValue)*860420.65009;
			break;
		case "Pound/Btu (IT) -lb/Btu":
			jouleperkilogram=(edtValue)*2326;
			kilojouleperkilogram=(edtValue)*2.326;
			calorieITpergram=(edtValue)*0.5555555556;
			caloriethpergram=(edtValue)*0.5559273423;
			BtuITperpound=(edtValue)*1;
			Btuthperpound=(edtValue)*1.0006692161;
			kilogramperjoule=(edtValue)*0.0004299226;
			kilogramperkilojoule=(edtValue)*0.4299226139;
			grampercalorieIT=(edtValue)*1.8;
			grampercalorieth=(edtValue)*1.7987962167;
			poundperBtuIT=(edtValue)*1;
			poundperBtuth=(edtValue)*0.9993312315;
			poundperhorsepowerperhour=(edtValue)*2544.4335776;
			gramperhorsepowermetricperhour=(edtValue)*1138347.1625;
			gramperkilowattperhour=(edtValue)*1547721.4101;
			break;
		case "Pound/Btu (th) -lb/Btu(th)":
			jouleperkilogram=(edtValue)*2324.4444444;
			kilojouleperkilogram=(edtValue)*2.3244444444;
			calorieITpergram=(edtValue)*0.5551840175;
			caloriethpergram=(edtValue)*0.5555555556;
			BtuITperpound=(edtValue)*0.9993312315;
			Btuthperpound=(edtValue)*1;
			kilogramperjoule=(edtValue)*0.0004302103;
			kilogramperkilojoule=(edtValue)*0.430210325;
			grampercalorieIT=(edtValue)*1.8012045889;
			grampercalorieth=(edtValue)*1.8;
			poundperBtuIT=(edtValue)*1.0006692161;
			poundperBtuth=(edtValue)*1;
			poundperhorsepowerperhour=(edtValue)*2546.1363535;
			gramperhorsepowermetricperhour=(edtValue)*1139108.9627;
			gramperkilowattperhour=(edtValue)*1548757.1702;
			break;
		case "Pound/horsepower/hour -lb/hp/h":
			jouleperkilogram=(edtValue)*5918352.5016;
			kilojouleperkilogram=(edtValue)*5918.3525016;
			calorieITpergram=(edtValue)*1413.5742098;
			caloriethpergram=(edtValue)*1414.5201964;
			BtuITperpound=(edtValue)*2544.4335776;
			Btuthperpound=(edtValue)*2546.1363535;
			kilogramperjoule=(edtValue)*1.68965941E-7;
			kilogramperkilojoule=(edtValue)*0.0001689659;
			grampercalorieIT=(edtValue)*0.0007074266;
			grampercalorieth=(edtValue)*0.0007069535;
			poundperBtuIT=(edtValue)*0.0003930148;
			poundperBtuth=(edtValue)*0.0003927519;
			poundperhorsepowerperhour=(edtValue)*1;
			gramperhorsepowermetricperhour=(edtValue)*447.38725841;
			gramperkilowattperhour=(edtValue)*608.27738784;
			break;
		case "Gram/horsepower (metric)/hour -g/hp/h":
			jouleperkilogram=(edtValue)*2647795500.0;
			kilojouleperkilogram=(edtValue)*2647795.5;
			calorieITpergram=(edtValue)*632415.09028;
			caloriethpergram=(edtValue)*632838.31262;
			BtuITperpound=(edtValue)*1138347.1625;
			Btuthperpound=(edtValue)*1139108.9627;
			kilogramperjoule=(edtValue)*3.776726714E-10;
			kilogramperkilojoule=(edtValue)*3.776726714E-7;
			grampercalorieIT=(edtValue)*0.0000015812;
			grampercalorieth=(edtValue)*0.0000015802;
			poundperBtuIT=(edtValue)*8.784666338E-7;
			poundperBtuth=(edtValue)*8.77879143E-7;
			poundperhorsepowerperhour=(edtValue)*0.0022352;
			gramperhorsepowermetricperhour=(edtValue)*1;
			gramperkilowattperhour=(edtValue)*1.3596216173;
			break;
		case "Gram/kilowatt/hour -g/kW/h":
			jouleperkilogram=(edtValue)*3600000000.0;
			kilojouleperkilogram=(edtValue)*3600000;
			calorieITpergram=(edtValue)*859845.22786;
			caloriethpergram=(edtValue)*860420.65009;
			BtuITperpound=(edtValue)*1547721.4101;
			Btuthperpound=(edtValue)*1548757.1702;
			kilogramperjoule=(edtValue)*2.777777777E-10;
			kilogramperkilojoule=(edtValue)*2.777777777E-7;
			grampercalorieIT=(edtValue)*0.000001163;
			grampercalorieth=(edtValue)*0.0000011622;
			poundperBtuIT=(edtValue)*6.461111111E-7;
			poundperBtuth=(edtValue)*6.456790123E-7;
			poundperhorsepowerperhour=(edtValue)*0.0016439868;
			gramperhorsepowermetricperhour=(edtValue)*0.73549875;
			gramperkilowattperhour=(edtValue)*1;
			break;
		case "Default":
			break;
			
			
		}
		results.setJouleperkilogram(jouleperkilogram);
		results.setKilojouleperkilogram(kilojouleperkilogram);
		results.setCalorieITpergram(calorieITpergram);
		results.setCaloriethpergram(caloriethpergram);
		results.setBtuITperpound(BtuITperpound);
		results.setBtuthperpound(Btuthperpound);
		results.setKilogramperjoule(kilogramperjoule);
		results.setKilogramperkilojoule(kilogramperkilojoule);
		results.setGrampercalorieIT(grampercalorieIT);
		results.setGrampercalorieth(grampercalorieth);
		results.setPoundperBtuIT(poundperBtuIT);
		results.setPoundperBtuth(poundperBtuth);
		results.setPoundperhorsepowerperhour(poundperhorsepowerperhour);
		results.setGramperhorsepowermetricperhour(gramperhorsepowermetricperhour);
		results.setGramperkilowattperhour(gramperkilowattperhour);
		
		 
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double jouleperkilogram,kilojouleperkilogram,calorieITpergram,caloriethpergram,BtuITperpound,Btuthperpound
		,kilogramperjoule,kilogramperkilojoule,grampercalorieIT,grampercalorieth,poundperBtuIT,poundperBtuth,
		poundperhorsepowerperhour,gramperhorsepowermetricperhour,gramperkilowattperhour;

		public double getJouleperkilogram() {
			return jouleperkilogram;
		}

		public void setJouleperkilogram(double jouleperkilogram) {
			this.jouleperkilogram = jouleperkilogram;
		}

		public double getKilojouleperkilogram() {
			return kilojouleperkilogram;
		}

		public void setKilojouleperkilogram(double kilojouleperkilogram) {
			this.kilojouleperkilogram = kilojouleperkilogram;
		}

		public double getCalorieITpergram() {
			return calorieITpergram;
		}

		public void setCalorieITpergram(double calorieITpergram) {
			this.calorieITpergram = calorieITpergram;
		}

		public double getCaloriethpergram() {
			return caloriethpergram;
		}

		public void setCaloriethpergram(double caloriethpergram) {
			this.caloriethpergram = caloriethpergram;
		}

		public double getBtuITperpound() {
			return BtuITperpound;
		}

		public void setBtuITperpound(double btuITperpound) {
			BtuITperpound = btuITperpound;
		}

		public double getBtuthperpound() {
			return Btuthperpound;
		}

		public void setBtuthperpound(double btuthperpound) {
			Btuthperpound = btuthperpound;
		}

		public double getKilogramperjoule() {
			return kilogramperjoule;
		}

		public void setKilogramperjoule(double kilogramperjoule) {
			this.kilogramperjoule = kilogramperjoule;
		}

		public double getKilogramperkilojoule() {
			return kilogramperkilojoule;
		}

		public void setKilogramperkilojoule(double kilogramperkilojoule) {
			this.kilogramperkilojoule = kilogramperkilojoule;
		}

		public double getGrampercalorieIT() {
			return grampercalorieIT;
		}

		public void setGrampercalorieIT(double grampercalorieIT) {
			this.grampercalorieIT = grampercalorieIT;
		}

		public double getGrampercalorieth() {
			return grampercalorieth;
		}

		public void setGrampercalorieth(double grampercalorieth) {
			this.grampercalorieth = grampercalorieth;
		}

		public double getPoundperBtuIT() {
			return poundperBtuIT;
		}

		public void setPoundperBtuIT(double poundperBtuIT) {
			this.poundperBtuIT = poundperBtuIT;
		}

		public double getPoundperBtuth() {
			return poundperBtuth;
		}

		public void setPoundperBtuth(double poundperBtuth) {
			this.poundperBtuth = poundperBtuth;
		}

		public double getPoundperhorsepowerperhour() {
			return poundperhorsepowerperhour;
		}

		public void setPoundperhorsepowerperhour(double poundperhorsepowerperhour) {
			this.poundperhorsepowerperhour = poundperhorsepowerperhour;
		}

		public double getGramperhorsepowermetricperhour() {
			return gramperhorsepowermetricperhour;
		}

		public void setGramperhorsepowermetricperhour(
				double gramperhorsepowermetricperhour) {
			this.gramperhorsepowermetricperhour = gramperhorsepowermetricperhour;
		}

		public double getGramperkilowattperhour() {
			return gramperkilowattperhour;
		}

		public void setGramperkilowattperhour(double gramperkilowattperhour) {
			this.gramperkilowattperhour = gramperkilowattperhour;
		}
		
		
	}
}