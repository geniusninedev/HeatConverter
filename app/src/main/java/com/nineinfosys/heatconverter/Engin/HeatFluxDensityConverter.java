package com.nineinfosys.heatconverter.Engin;

import java.util.ArrayList;

public class HeatFluxDensityConverter {

	private double wattpersquaremeter,kilowattpersquaremeter,wattpersquarecentimeter,wattpersquareinch,joulepersecondpersquaremeter,kilocalorieITperhourpersquaremeter
	,kilocalorieITperhourpersquarefoot,calorieITpersecondpersquarecentimeter,calorieITperminutepersquarecentimeter,calorieITperhourpersquarecentimeter,caloriethpersecondpersquarecentimeter
	,caloriethperminutepersquarecentimeter,caloriethperhourpersquarecentimeter,dyneperhourpercentimeter,ergperhourpersquaremillimeter,footpoundperminutepersquarefoot
	,horsepowerpersquarefoot,horsepowermetricpersquarefoot,BtuITpersecondpersquarefoot,BtuITperminutepersquarefoot,BtuITperhourpersquarefoot,Btuthpersecondpersquareinch
	,Btuthpersecondpersquarefoot,Btuthperminutepersquarefoot,Btuthperhourpersquarefoot,CHUperhourpersquarefoot;
	private double edtValue;
	private String conversionFrom;
	//private String conversionTo;
	public HeatFluxDensityConverter(String conversionFrom, double edtValue){
		// TODO Auto-generated constructor stub
		this.conversionFrom = conversionFrom;
		this.edtValue = edtValue;
	}
	public ArrayList<ConversionResults> calculateHeatFluxDensityConversion()
    {
		ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();
		ConversionResults results= new ConversionResults();
    		 	
		switch(conversionFrom)
		{
		case "Watt/square meter -W/m^2":
			wattpersquaremeter=(edtValue)*1;
			kilowattpersquaremeter=(edtValue)*0.001;
			wattpersquarecentimeter=(edtValue)*0.0001;
			wattpersquareinch=(edtValue)*0.00064516;
			joulepersecondpersquaremeter=(edtValue)*1;
			kilocalorieITperhourpersquaremeter=(edtValue)*0.8598452279;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.0798822356;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0000238846;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0014330754;
			calorieITperhourpersquarecentimeter=(edtValue)*0.0859845228;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0000239006;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0014340344;
			caloriethperhourpersquarecentimeter=(edtValue)*0.086042065;
			dyneperhourpercentimeter=(edtValue)*3600000;
			ergperhourpersquaremillimeter=(edtValue)*36000;
			footpoundperminutepersquarefoot=(edtValue)*4.111305952;
			horsepowerpersquarefoot=(edtValue)*0.000124585;
			horsepowermetricpersquarefoot=(edtValue)*0.000126313;
			BtuITpersecondpersquarefoot=(edtValue)*0.0000880551;
			BtuITperminutepersquarefoot=(edtValue)*0.0052833055;
			BtuITperhourpersquarefoot=(edtValue)*0.3169983306;
			Btuthpersecondpersquareinch=(edtValue)*6.119029147E-7;
			Btuthpersecondpersquarefoot=(edtValue)*0.000088114;
			Btuthperminutepersquarefoot=(edtValue)*0.0052868412;
			Btuthperhourpersquarefoot=(edtValue)*0.317210471;
			CHUperhourpersquarefoot=(edtValue)*0.1761101819;
			break;
		case "Kilowatt/square meter -kW/m^2":
			wattpersquaremeter=(edtValue)*1000;
			kilowattpersquaremeter=(edtValue)*1;
			wattpersquarecentimeter=(edtValue)*0.1;
			wattpersquareinch=(edtValue)*0.6451599995;
			joulepersecondpersquaremeter=(edtValue)*1000;
			kilocalorieITperhourpersquaremeter=(edtValue)*859.8452279;
			kilocalorieITperhourpersquarefoot=(edtValue)*79.88223556;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0238845897;
			calorieITperminutepersquarecentimeter=(edtValue)*1.4330753796;
			calorieITperhourpersquarecentimeter=(edtValue)*85.98452278;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0239005736;
			caloriethperminutepersquarecentimeter=(edtValue)*1.4340344168;
			caloriethperhourpersquarecentimeter=(edtValue)*86.04206501;
			dyneperhourpercentimeter=(edtValue)*3600000000.0;
			ergperhourpersquaremillimeter=(edtValue)*36000000;
			footpoundperminutepersquarefoot=(edtValue)*4111.305952;
			horsepowerpersquarefoot=(edtValue)*0.1245850288;
			horsepowermetricpersquarefoot=(edtValue)*0.1263129815;
			BtuITpersecondpersquarefoot=(edtValue)*0.0880550918;
			BtuITperminutepersquarefoot=(edtValue)*5.283305459;
			BtuITperhourpersquarefoot=(edtValue)*316.99833063;
			Btuthpersecondpersquareinch=(edtValue)*0.0006119029;
			Btuthpersecondpersquarefoot=(edtValue)*0.0881140197;
			Btuthperminutepersquarefoot=(edtValue)*5.2868411834;
			Btuthperhourpersquarefoot=(edtValue)*317.210471;
			CHUperhourpersquarefoot=(edtValue)*176.1101819;
			break;
		case "Watt/square centimeter -W/cm^2":
			wattpersquaremeter=(edtValue)*10000;
			kilowattpersquaremeter=(edtValue)*10;
			wattpersquarecentimeter=(edtValue)*1;
			wattpersquareinch=(edtValue)*6.451599995;
			joulepersecondpersquaremeter=(edtValue)*10000;
			kilocalorieITperhourpersquaremeter=(edtValue)*8598.452279;
			kilocalorieITperhourpersquarefoot=(edtValue)*798.8223556;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.2388458966;
			calorieITperminutepersquarecentimeter=(edtValue)*14.330753796;
			calorieITperhourpersquarecentimeter=(edtValue)*859.8452278;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.2390057361;
			caloriethperminutepersquarecentimeter=(edtValue)*14.340344168;
			caloriethperhourpersquarecentimeter=(edtValue)*860.4206501;
			dyneperhourpercentimeter=(edtValue)*36000000000.0;
			ergperhourpersquaremillimeter=(edtValue)*360000000;
			footpoundperminutepersquarefoot=(edtValue)*41113.05952;
			horsepowerpersquarefoot=(edtValue)*1.245850288;
			horsepowermetricpersquarefoot=(edtValue)*1.263129815;
			BtuITpersecondpersquarefoot=(edtValue)*0.8805509184;
			BtuITperminutepersquarefoot=(edtValue)*52.83305459;
			BtuITperhourpersquarefoot=(edtValue)*3169.9833063;
			Btuthpersecondpersquareinch=(edtValue)*0.0061190291;
			Btuthpersecondpersquarefoot=(edtValue)*0.8811401972;
			Btuthperminutepersquarefoot=(edtValue)*52.868411834;
			Btuthperhourpersquarefoot=(edtValue)*3172.10471;
			CHUperhourpersquarefoot=(edtValue)*1761.101819;
			break;
		case "Watt/square inch -W/in^2":
			wattpersquaremeter=(edtValue)*1550.0031012;
			kilowattpersquaremeter=(edtValue)*1.5500031012;
			wattpersquarecentimeter=(edtValue)*0.1550003101;
			wattpersquareinch=(edtValue)*1;
			joulepersecondpersquaremeter=(edtValue)*1550.0031012;
			kilocalorieITperhourpersquaremeter=(edtValue)*1332.7627698;
			kilocalorieITperhourpersquarefoot=(edtValue)*123.81771285;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.037021188;
			calorieITperminutepersquarecentimeter=(edtValue)*2.2212712826;
			calorieITperhourpersquarecentimeter=(edtValue)*133.27627696;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0370459632;
			caloriethperminutepersquarecentimeter=(edtValue)*2.2227577933;
			caloriethperhourpersquarecentimeter=(edtValue)*133.3654676;
			dyneperhourpercentimeter=(edtValue)*5580011164.3;
			ergperhourpersquaremillimeter=(edtValue)*55800111.643;
			footpoundperminutepersquarefoot=(edtValue)*6372.5369756;
			horsepowerpersquarefoot=(edtValue)*0.193107181;
			horsepowermetricpersquarefoot=(edtValue)*0.195785513;
			BtuITpersecondpersquarefoot=(edtValue)*0.1364856654;
			BtuITperminutepersquarefoot=(edtValue)*8.1891398461;
			BtuITperhourpersquarefoot=(edtValue)*491.34839555;
			Btuthpersecondpersquareinch=(edtValue)*0.0009484514;
			Btuthpersecondpersquarefoot=(edtValue)*0.1365770038;
			Btuthperminutepersquarefoot=(edtValue)*8.1946202298;
			Btuthperhourpersquarefoot=(edtValue)*491.67721379;
			CHUperhourpersquarefoot=(edtValue)*272.9713281;
			break;
		case "Joule/second/square meter -Js/m^2":
			wattpersquaremeter=(edtValue)*1;
			kilowattpersquaremeter=(edtValue)*0.001;
			wattpersquarecentimeter=(edtValue)*0.0001;
			wattpersquareinch=(edtValue)*0.00064516;
			joulepersecondpersquaremeter=(edtValue)*1;
			kilocalorieITperhourpersquaremeter=(edtValue)*0.8598452279;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.0798822356;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0000238846;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0014330754;
			calorieITperhourpersquarecentimeter=(edtValue)*0.0859845228;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0859845228;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0014340344;
			caloriethperhourpersquarecentimeter=(edtValue)*0.086042065;
			dyneperhourpercentimeter=(edtValue)*3600000;
			ergperhourpersquaremillimeter=(edtValue)*36000;
			footpoundperminutepersquarefoot=(edtValue)*4.111305952;
			horsepowerpersquarefoot=(edtValue)*0.000124585;
			horsepowermetricpersquarefoot=(edtValue)*0.000126313;
			BtuITpersecondpersquarefoot=(edtValue)*0.0000880551;
			BtuITperminutepersquarefoot=(edtValue)*0.0052833055;
			BtuITperhourpersquarefoot=(edtValue)*0.3169983306;
			Btuthpersecondpersquareinch=(edtValue)*6.119029147E-7;
			Btuthpersecondpersquarefoot=(edtValue)*0.000088114;
			Btuthperminutepersquarefoot=(edtValue)*0.0052868412;
			Btuthperhourpersquarefoot=(edtValue)*0.317210471;
			CHUperhourpersquarefoot=(edtValue)*0.1761101819;
			break;
		case "Kilocalorie (IT)/hour/square meter -kcal(IT)h/m^2":
			wattpersquaremeter=(edtValue)*1.1629999999;
			kilowattpersquaremeter=(edtValue)*0.001163;
			wattpersquarecentimeter=(edtValue)*0.0001163;
			wattpersquareinch=(edtValue)*0.0007503211;
			joulepersecondpersquaremeter=(edtValue)*1.1629999999;
			kilocalorieITperhourpersquaremeter=(edtValue)*1;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.09290304;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0000277778;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0016666667;
			calorieITperhourpersquarecentimeter=(edtValue)*0.1;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0000277964;
			caloriethperminutepersquarecentimeter=(edtValue)*0.001667782;
			caloriethperhourpersquarecentimeter=(edtValue)*0.1000669216;
			dyneperhourpercentimeter=(edtValue)*4186799.9998;
			ergperhourpersquaremillimeter=(edtValue)*41867.999998;
			footpoundperminutepersquarefoot=(edtValue)*4.7814488219;
			horsepowerpersquarefoot=(edtValue)*0.0001448924;
			horsepowermetricpersquarefoot=(edtValue)*0.000146902;
			BtuITpersecondpersquarefoot=(edtValue)*0.0001024081;
			BtuITperminutepersquarefoot=(edtValue)*0.0061444842;
			BtuITperhourpersquarefoot=(edtValue)*0.3686690585;
			Btuthpersecondpersquareinch=(edtValue)*7.116430898E-7;
			Btuthpersecondpersquarefoot=(edtValue)*0.0001024766;
			Btuthperminutepersquarefoot=(edtValue)*0.0061485963;
			Btuthperhourpersquarefoot=(edtValue)*0.3689157778;
			CHUperhourpersquarefoot=(edtValue)*0.2048161415;
			break;
		case "Kilocalorie (IT)/hour/square foot -kcal(IT)h/ft^2":
			wattpersquaremeter=(edtValue)*12.518427821;
			kilowattpersquaremeter=(edtValue)*0.0125184278;
			wattpersquarecentimeter=(edtValue)*0.0012518428;
			wattpersquareinch=(edtValue)*0.0080763889;
			joulepersecondpersquaremeter=(edtValue)*12.518427821;
			kilocalorieITperhourpersquaremeter=(edtValue)*10.763910422;
			kilocalorieITperhourpersquarefoot=(edtValue)*1;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0002989975;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0179398507;
			calorieITperhourpersquarecentimeter=(edtValue)*1.0763910421;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0002991976;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0179518563;
			caloriethperhourpersquarecentimeter=(edtValue)*1.0771113804;
			dyneperhourpercentimeter=(edtValue)*45066340.154;
			ergperhourpersquaremillimeter=(edtValue)*450663.40154;
			footpoundperminutepersquarefoot=(edtValue)*51.467086808;
			horsepowerpersquarefoot=(edtValue)*0.0015596087;
			horsepowermetricpersquarefoot=(edtValue)*0.0015812399;
			BtuITpersecondpersquarefoot=(edtValue)*0.0011023113;
			BtuITperminutepersquarefoot=(edtValue)*0.066138678;
			BtuITperhourpersquarefoot=(edtValue)*3.9683207212;
			Btuthpersecondpersquareinch=(edtValue)*0.0000076601;
			Btuthpersecondpersquarefoot=(edtValue)*0.001103049;
			Btuthperminutepersquarefoot=(edtValue)*0.0661829398;
			Btuthperhourpersquarefoot=(edtValue)*3.9709763852;
			CHUperhourpersquarefoot=(edtValue)*2.2046226006;
			break;
		case "Calorie (IT)/second/square centimeter -cal(IT)s/cm^2":
			wattpersquaremeter=(edtValue)*41868.000005;
			kilowattpersquaremeter=(edtValue)*41.868000005;
			wattpersquarecentimeter=(edtValue)*4.1868000005;
			wattpersquareinch=(edtValue)*27.011558862;
			joulepersecondpersquaremeter=(edtValue)*41868.000005;
			kilocalorieITperhourpersquaremeter=(edtValue)*36000.000006;
			kilocalorieITperhourpersquarefoot=(edtValue)*3344.5094388;
			calorieITpersecondpersquarecentimeter=(edtValue)*1;
			calorieITperminutepersquarecentimeter=(edtValue)*60;
			calorieITperhourpersquarecentimeter=(edtValue)*3600.0000002;
			caloriethpersecondpersquarecentimeter=(edtValue)*1.0006692162;
			caloriethperminutepersquarecentimeter=(edtValue)*60.040152971;
			caloriethperhourpersquarecentimeter=(edtValue)*3602.4091782;
			dyneperhourpercentimeter=(edtValue)*150724800017.0;
			ergperhourpersquaremillimeter=(edtValue)*1507248000.2;
			footpoundperminutepersquarefoot=(edtValue)*172132.15762;
			horsepowerpersquarefoot=(edtValue)*5.2161259864;
			horsepowermetricpersquarefoot=(edtValue)*5.2884719101;
			BtuITpersecondpersquarefoot=(edtValue)*3.6866905856;
			BtuITperminutepersquarefoot=(edtValue)*221.20143298;
			BtuITperhourpersquarefoot=(edtValue)*13272.086108;
			Btuthpersecondpersquareinch=(edtValue)*0.0256191512;
			Btuthpersecondpersquarefoot=(edtValue)*3.6891577782;
			Btuthperminutepersquarefoot=(edtValue)*221.34946669;
			Btuthperhourpersquarefoot=(edtValue)*13280.968001;
			CHUperhourpersquarefoot=(edtValue)*7373.3810966;
			break;
		case "Calorie (IT)/minute/square centimeter -cal(IT)min/cm^2":
			wattpersquaremeter=(edtValue)*697.80000008;
			kilowattpersquaremeter=(edtValue)*0.6978000001;
			wattpersquarecentimeter=(edtValue)*0.06978;
			wattpersquareinch=(edtValue)*0.4501926477;
			joulepersecondpersquaremeter=(edtValue)*697.80000008;
			kilocalorieITperhourpersquaremeter=(edtValue)*600.0000001;
			kilocalorieITperhourpersquarefoot=(edtValue)*55.74182398;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0166666667;
			calorieITperminutepersquarecentimeter=(edtValue)*1;
			calorieITperhourpersquarecentimeter=(edtValue)*60.000000003;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0166778203;
			caloriethperminutepersquarecentimeter=(edtValue)*1.0006692162;
			caloriethperhourpersquarecentimeter=(edtValue)*60.040152971;
			dyneperhourpercentimeter=(edtValue)*2512080000.3;
			ergperhourpersquaremillimeter=(edtValue)*25120800.003;
			footpoundperminutepersquarefoot=(edtValue)*2868.8692936;
			horsepowerpersquarefoot=(edtValue)*2868.8692936;
			horsepowermetricpersquarefoot=(edtValue)*0.0881411985;
			BtuITpersecondpersquarefoot=(edtValue)*0.0614448431;
			BtuITperminutepersquarefoot=(edtValue)*3.6866905497;
			BtuITperhourpersquarefoot=(edtValue)*221.20143514;
			Btuthpersecondpersquareinch=(edtValue)*0.0004269859;
			Btuthpersecondpersquarefoot=(edtValue)*0.061485963;
			Btuthperminutepersquarefoot=(edtValue)*3.6891577782;
			Btuthperhourpersquarefoot=(edtValue)*221.34946669;
			CHUperhourpersquarefoot=(edtValue)*122.88968494;
			break;
		case "Calorie (IT)/hour/square centimeter -cal(IT)h/cm^2":
			wattpersquaremeter=(edtValue)*11.630000001;
			kilowattpersquaremeter=(edtValue)*0.01163;
			wattpersquarecentimeter=(edtValue)*0.001163;
			wattpersquareinch=(edtValue)*0.0075032108;
			joulepersecondpersquaremeter=(edtValue)*11.630000001;
			kilocalorieITperhourpersquaremeter=(edtValue)*10.000000001;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.9290303996;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0002777778;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0166666667;
			calorieITperhourpersquarecentimeter=(edtValue)*1;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0002779637;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0166778203;
			caloriethperhourpersquarecentimeter=(edtValue)*1.0006692161;
			dyneperhourpercentimeter=(edtValue)*41868000.003;
			ergperhourpersquaremillimeter=(edtValue)*418680.00003;
			footpoundperminutepersquarefoot=(edtValue)*47.814488225;
			horsepowerpersquarefoot=(edtValue)*0.0014489239;
			horsepowermetricpersquarefoot=(edtValue)*0.00146902;
			BtuITpersecondpersquarefoot=(edtValue)*0.0010240807;
			BtuITperminutepersquarefoot=(edtValue)*0.0614448425;
			BtuITperhourpersquarefoot=(edtValue)*3.6866905855;
			Btuthpersecondpersquareinch=(edtValue)*0.0000071164;
			Btuthpersecondpersquarefoot=(edtValue)*0.001024766;
			Btuthperminutepersquarefoot=(edtValue)*0.061485963;
			Btuthperhourpersquarefoot=(edtValue)*3.689157778;
			CHUperhourpersquarefoot=(edtValue)*2.0481614156;
			break;
		case "Calorie (th)/second/square centimeter -cal(th)s/cm^2":
			wattpersquaremeter=(edtValue)*41840;
			kilowattpersquaremeter=(edtValue)*41.84;
			wattpersquarecentimeter=(edtValue)*4.184;
			wattpersquareinch=(edtValue)*26.993494379;
			joulepersecondpersquaremeter=(edtValue)*41840;
			kilocalorieITperhourpersquaremeter=(edtValue)*35975.924335;
			kilocalorieITperhourpersquarefoot=(edtValue)*3342.2727358;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.9993312314;
			calorieITperminutepersquarecentimeter=(edtValue)*59.959873882;
			calorieITperhourpersquarecentimeter=(edtValue)*3597.5924331;
			caloriethpersecondpersquarecentimeter=(edtValue)*1;
			caloriethperminutepersquarecentimeter=(edtValue)*60;
			caloriethperhourpersquarecentimeter=(edtValue)*3600;
			dyneperhourpercentimeter=(edtValue)*150624000000.0;
			ergperhourpersquaremillimeter=(edtValue)*1506240000;
			footpoundperminutepersquarefoot=(edtValue)*172017.04103;
			horsepowerpersquarefoot=(edtValue)*5.212637605;
			horsepowermetricpersquarefoot=(edtValue)*5.284935146;
			BtuITpersecondpersquarefoot=(edtValue)*3.6842250426;
			BtuITperminutepersquarefoot=(edtValue)*221.0535004;
			BtuITperhourpersquarefoot=(edtValue)*13263.210153;
			Btuthpersecondpersquareinch=(edtValue)*0.025602018;
			Btuthpersecondpersquarefoot=(edtValue)*3.6866905852;
			Btuthperminutepersquarefoot=(edtValue)*221.20143511;
			Btuthperhourpersquarefoot=(edtValue)*13272.086107;
			CHUperhourpersquarefoot=(edtValue)*7368.4500107;
			break;
		case "Calorie (th)/minute/square centimeter -cal(th)min/cm^2":
			wattpersquaremeter=(edtValue)*697.33333333;
			kilowattpersquaremeter=(edtValue)*0.6973333333;
			wattpersquarecentimeter=(edtValue)*0.0697333333;
			wattpersquareinch=(edtValue)*0.449891573;
			joulepersecondpersquaremeter=(edtValue)*697.33333333;
			kilocalorieITperhourpersquaremeter=(edtValue)*599.59873892;
			kilocalorieITperhourpersquarefoot=(edtValue)*55.704545597;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0166555205;
			calorieITperminutepersquarecentimeter=(edtValue)*0.9993312314;
			calorieITperhourpersquarecentimeter=(edtValue)*59.959873885;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0166666667;
			caloriethperminutepersquarecentimeter=(edtValue)*1;
			caloriethperhourpersquarecentimeter=(edtValue)*60;
			dyneperhourpercentimeter=(edtValue)*2510400000.0;
			ergperhourpersquaremillimeter=(edtValue)*25104000;
			footpoundperminutepersquarefoot=(edtValue)*2866.9506839;
			horsepowerpersquarefoot=(edtValue)*0.0868772934;
			horsepowermetricpersquarefoot=(edtValue)*0.0880822524;
			BtuITpersecondpersquarefoot=(edtValue)*0.0614037507;
			BtuITperminutepersquarefoot=(edtValue)*3.6842250067;
			BtuITperhourpersquarefoot=(edtValue)*221.05350256;
			Btuthpersecondpersquareinch=(edtValue)*0.0004267003;
			Btuthpersecondpersquarefoot=(edtValue)*0.0614448431;
			Btuthperminutepersquarefoot=(edtValue)*3.6866905852;
			Btuthperhourpersquarefoot=(edtValue)*221.20143511;
			CHUperhourpersquarefoot=(edtValue)*122.80750018;
			break;
		case "Calorie (th)/hour/square centimeter -cal(th)h/cm^2":
			wattpersquaremeter=(edtValue)*11.622222222;
			kilowattpersquaremeter=(edtValue)*0.0116222222;
			wattpersquarecentimeter=(edtValue)*0.0011622222;
			wattpersquareinch=(edtValue)*0.0074981929;
			joulepersecondpersquaremeter=(edtValue)*11.622222222;
			kilocalorieITperhourpersquaremeter=(edtValue)*9.9933123153;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.9284090933;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.000277592;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0166555205;
			calorieITperhourpersquarecentimeter=(edtValue)*0.9993312314;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0002777778;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0166666667;
			caloriethperhourpersquarecentimeter=(edtValue)*1;
			dyneperhourpercentimeter=(edtValue)*41840000;
			ergperhourpersquaremillimeter=(edtValue)*418400;
			footpoundperminutepersquarefoot=(edtValue)*47.782511398;
			horsepowerpersquarefoot=(edtValue)*0.0014479549;
			horsepowermetricpersquarefoot=(edtValue)*0.0014680375;
			BtuITpersecondpersquarefoot=(edtValue)*0.0010233958;
			BtuITperminutepersquarefoot=(edtValue)*0.0614037501;
			BtuITperhourpersquarefoot=(edtValue)*3.6842250426;
			Btuthpersecondpersquareinch=(edtValue)*0.0000071117;
			Btuthpersecondpersquarefoot=(edtValue)*0.0010240807;
			Btuthperminutepersquarefoot=(edtValue)*0.0614448431;
			Btuthperhourpersquarefoot=(edtValue)*3.6866905852;
			CHUperhourpersquarefoot=(edtValue)*2.0467916696;
			break;
		case "Dyne/hour/centimeter -dynh/cm":
			wattpersquaremeter=(edtValue)*2.777777777E-7;
			kilowattpersquaremeter=(edtValue)*2.777777777E-10;
			wattpersquarecentimeter=(edtValue)*2.777777777E-11;
			wattpersquareinch=(edtValue)*1.792111109E-10;
			joulepersecondpersquaremeter=(edtValue)*2.777777777E-7;
			kilocalorieITperhourpersquaremeter=(edtValue)*2.388458966E-7;
			kilocalorieITperhourpersquarefoot=(edtValue)*2.218950987E-8;
			calorieITpersecondpersquarecentimeter=(edtValue)*6.634608238E-12;
			calorieITperminutepersquarecentimeter=(edtValue)*3.980764943E-10;
			calorieITperhourpersquarecentimeter=(edtValue)*2.388458966E-8;
			caloriethpersecondpersquarecentimeter=(edtValue)*6.639048226E-12;
			caloriethperminutepersquarecentimeter=(edtValue)*3.983428935E-10;
			caloriethperhourpersquarecentimeter=(edtValue)*2.390057361E-8;
			dyneperhourpercentimeter=(edtValue)*1;
			ergperhourpersquaremillimeter=(edtValue)*0.01;
			footpoundperminutepersquarefoot=(edtValue)*0.000001142;
			horsepowerpersquarefoot=(edtValue)*3.460695244E-11;
			horsepowermetricpersquarefoot=(edtValue)*3.50869393E-11;
			BtuITpersecondpersquarefoot=(edtValue)*2.445974773E-11;
			BtuITperminutepersquarefoot=(edtValue)*1.467584849E-9;
			BtuITperhourpersquarefoot=(edtValue)*8.805509184E-8;
			Btuthpersecondpersquareinch=(edtValue)*1.699730318E-13;
			Btuthpersecondpersquarefoot=(edtValue)*2.447611658E-11;
			Btuthperminutepersquarefoot=(edtValue)*1.468566995E-9;
			Btuthperhourpersquarefoot=(edtValue)*8.811401972E-8;
			CHUperhourpersquarefoot=(edtValue)*4.891949497E-8;
			break;
		case "Erg/hour/square millimeter -ergh/mm^2":
			wattpersquaremeter=(edtValue)*0.0000277778;
			kilowattpersquaremeter=(edtValue)*2.777777777E-8;
			wattpersquarecentimeter=(edtValue)*2.777777777E-9;
			wattpersquareinch=(edtValue)*1.792111109E-8;
			joulepersecondpersquaremeter=(edtValue)*0.0000277778;
			kilocalorieITperhourpersquaremeter=(edtValue)*0.0000238846;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.000002219;
			calorieITpersecondpersquarecentimeter=(edtValue)*6.634608238E-10;
			calorieITperminutepersquarecentimeter=(edtValue)*3.980764943E-8;
			calorieITperhourpersquarecentimeter=(edtValue)*0.0000023885;
			caloriethpersecondpersquarecentimeter=(edtValue)*6.639048226E-10;
			caloriethperminutepersquarecentimeter=(edtValue)*3.983428935E-8;
			caloriethperhourpersquarecentimeter=(edtValue)*0.0000023901;
			dyneperhourpercentimeter=(edtValue)*100;
			ergperhourpersquaremillimeter=(edtValue)*1;
			footpoundperminutepersquarefoot=(edtValue)*0.0001142029;
			horsepowerpersquarefoot=(edtValue)*3.460695244E-9;
			horsepowermetricpersquarefoot=(edtValue)*3.50869393E-9;
			BtuITpersecondpersquarefoot=(edtValue)*2.445974773E-9;
			BtuITperminutepersquarefoot=(edtValue)*1.467584849E-7;
			BtuITperhourpersquarefoot=(edtValue)*0.0000088055;
			Btuthpersecondpersquareinch=(edtValue)*1.699730318E-11;
			Btuthpersecondpersquarefoot=(edtValue)*2.447611658E-9;
			Btuthperminutepersquarefoot=(edtValue)*1.468566995E-7;
			Btuthperhourpersquarefoot=(edtValue)*0.0000088114;
			CHUperhourpersquarefoot=(edtValue)*0.0000048919;
			break;
		case "Foot pound/minute/square foot -ftlbmin/ft^2":
			wattpersquaremeter=(edtValue)*0.2432317156;
			kilowattpersquaremeter=(edtValue)*0.0002432317;
			wattpersquarecentimeter=(edtValue)*0.0000243232;
			wattpersquareinch=(edtValue)*0.0001569234;
			joulepersecondpersquaremeter=(edtValue)*0.2432317156;
			kilocalorieITperhourpersquaremeter=(edtValue)*0.2091416299;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.0194298932;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0000058095;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0003485694;
			calorieITperhourpersquarecentimeter=(edtValue)*0.020914163;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0000058134;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0003488027;
			caloriethperhourpersquarecentimeter=(edtValue)*0.0209281591;
			dyneperhourpercentimeter=(edtValue)*875634.17611;
			ergperhourpersquaremillimeter=(edtValue)*8756.3417611;
			footpoundperminutepersquarefoot=(edtValue)*1;
			horsepowerpersquarefoot=(edtValue)*0.000030303;
			horsepowermetricpersquarefoot=(edtValue)*0.0000307233;
			BtuITpersecondpersquarefoot=(edtValue)*0.0000214178;
			BtuITperminutepersquarefoot=(edtValue)*0.0012850675;
			BtuITperhourpersquarefoot=(edtValue)*0.0771040478;
			Btuthpersecondpersquareinch=(edtValue)*1.488341957E-7;
			Btuthpersecondpersquarefoot=(edtValue)*0.0000214321;
			Btuthperminutepersquarefoot=(edtValue)*0.0012859275;
			Btuthperhourpersquarefoot=(edtValue)*0.0771556471;
			CHUperhourpersquarefoot=(edtValue)*0.0428355817;
			break;
		case "Horsepower/square foot -hp/ft^2":
			wattpersquaremeter=(edtValue)*8026.6466174;
			kilowattpersquaremeter=(edtValue)*8.0266466174;
			wattpersquarecentimeter=(edtValue)*0.8026646617;
			wattpersquareinch=(edtValue)*5.1784713277;
			joulepersecondpersquaremeter=(edtValue)*8026.6466174;
			kilocalorieITperhourpersquaremeter=(edtValue)*6901.67379;
			kilocalorieITperhourpersquarefoot=(edtValue)*641.18647585;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.1917131608;
			calorieITperminutepersquarecentimeter=(edtValue)*11.502789648;
			calorieITperhourpersquarecentimeter=(edtValue)*690.16737892;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.1918414584;
			caloriethperminutepersquarecentimeter=(edtValue)*11.510487501;
			caloriethperhourpersquarecentimeter=(edtValue)*690.62925007;
			dyneperhourpercentimeter=(edtValue)*28895927823.0;
			ergperhourpersquaremillimeter=(edtValue)*288959278.23;
			footpoundperminutepersquarefoot=(edtValue)*33000.000013;
			horsepowerpersquarefoot=(edtValue)*1;
			horsepowermetricpersquarefoot=(edtValue)*1.0138696657;
			BtuITpersecondpersquarefoot=(edtValue)*0.7067871051;
			BtuITperminutepersquarefoot=(edtValue)*42.407225891;
			BtuITperhourpersquarefoot=(edtValue)*2544.4335783;
			Btuthpersecondpersquareinch=(edtValue)*0.0049115285;
			Btuthpersecondpersquarefoot=(edtValue)*0.7072600984;
			Btuthperminutepersquarefoot=(edtValue)*42.435605901;
			Btuthperhourpersquarefoot=(edtValue)*2546.1363541;
			CHUperhourpersquarefoot=(edtValue)*1413.5741958;
			break;
		case "Horsepower (metric)/square foot -hp/ft^2":
			wattpersquaremeter=(edtValue)*7916.8426564;
			kilowattpersquaremeter=(edtValue)*7.9168426564;
			wattpersquarecentimeter=(edtValue)*0.7916842656;
			wattpersquareinch=(edtValue)*5.1076302043;
			joulepersecondpersquaremeter=(edtValue)*7916.8426564;
			kilocalorieITperhourpersquaremeter=(edtValue)*6807.2593782;
			kilocalorieITperhourpersquarefoot=(edtValue)*632.41508997;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.1890905383;
			calorieITperminutepersquarecentimeter=(edtValue)*11.345432295;
			calorieITperhourpersquarecentimeter=(edtValue)*680.72593774;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.1892170807;
			caloriethperminutepersquarecentimeter=(edtValue)*11.353024842;
			caloriethperhourpersquarecentimeter=(edtValue)*681.18149052;
			dyneperhourpercentimeter=(edtValue)*28500633563.0;
			ergperhourpersquaremillimeter=(edtValue)*285006335.63;
			footpoundperminutepersquarefoot=(edtValue)*32548.562334;
			horsepowerpersquarefoot=(edtValue)*0.9863200704;
			horsepowermetricpersquarefoot=(edtValue)*1;
			BtuITpersecondpersquarefoot=(edtValue)*0.6971183072;
			BtuITperminutepersquarefoot=(edtValue)*41.827098025;
			BtuITperhourpersquarefoot=(edtValue)*2509.6259059;
			Btuthpersecondpersquareinch=(edtValue)*0.0048443391;
			Btuthpersecondpersquarefoot=(edtValue)*0.69758483;
			Btuthperminutepersquarefoot=(edtValue)*41.855089798;
			Btuthperhourpersquarefoot=(edtValue)*2511.3053879;
			CHUperhourpersquarefoot=(edtValue)*1394.2366003;
			break;
		case "Btu (IT)/second/square foot -Btu(IT)s/ft^2":
			wattpersquaremeter=(edtValue)*11356.526682;
			kilowattpersquaremeter=(edtValue)*11.356526682;
			wattpersquarecentimeter=(edtValue)*1.1356526682;
			wattpersquareinch=(edtValue)*7.3267767486;
			joulepersecondpersquaremeter=(edtValue)*11356.526682;
			kilocalorieITperhourpersquaremeter=(edtValue)*9764.8552732;
			kilocalorieITperhourpersquarefoot=(edtValue)*907.18473957;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.2712459798;
			calorieITperminutepersquarecentimeter=(edtValue)*16.274758786;
			calorieITperhourpersquarecentimeter=(edtValue)*976.48552721;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.271427502;
			caloriethperminutepersquarecentimeter=(edtValue)*16.285650118;
			caloriethperhourpersquarecentimeter=(edtValue)*977.13900708;
			dyneperhourpercentimeter=(edtValue)*40883496056.0;
			ergperhourpersquaremillimeter=(edtValue)*408834960.56;
			footpoundperminutepersquarefoot=(edtValue)*46690.155743;
			horsepowerpersquarefoot=(edtValue)*1.4148532038;
			horsepowermetricpersquarefoot=(edtValue)*1.4344767447;
			BtuITpersecondpersquarefoot=(edtValue)*1;
			BtuITperminutepersquarefoot=(edtValue)*59.999999415;
			BtuITperhourpersquarefoot=(edtValue)*3600;
			Btuthpersecondpersquareinch=(edtValue)*0.0069490918;
			Btuthpersecondpersquarefoot=(edtValue)*1.0006692161;
			Btuthperminutepersquarefoot=(edtValue)*60.040152964;
			Btuthperhourpersquarefoot=(edtValue)*3602.4091778;
			CHUperhourpersquarefoot=(edtValue)*1999.9999798;
			break;
		case "Btu (IT)/minute/square foot -Btu(IT)min/ft^2":
			wattpersquaremeter=(edtValue)*189.27544655;
			kilowattpersquaremeter=(edtValue)*0.1892754465;
			wattpersquarecentimeter=(edtValue)*0.0189275447;
			wattpersquareinch=(edtValue)*0.122112947;
			joulepersecondpersquaremeter=(edtValue)*189.27544655;
			kilocalorieITperhourpersquaremeter=(edtValue)*162.74758947;
			kilocalorieITperhourpersquarefoot=(edtValue)*15.119745807;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0045207664;
			calorieITperminutepersquarecentimeter=(edtValue)*0.2712459824;
			calorieITperhourpersquarecentimeter=(edtValue)*16.274758945;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0045237917;
			caloriethperminutepersquarecentimeter=(edtValue)*0.2714275046;
			caloriethperhourpersquarecentimeter=(edtValue)*16.285650277;
			dyneperhourpercentimeter=(edtValue)*681391607.57;
			ergperhourpersquaremillimeter=(edtValue)*6813916.0757;
			footpoundperminutepersquarefoot=(edtValue)*778.16926996;
			horsepowerpersquarefoot=(edtValue)*0.023580887;
			horsepowermetricpersquarefoot=(edtValue)*0.023907946;
			BtuITpersecondpersquarefoot=(edtValue)*0.0166666668;
			BtuITperminutepersquarefoot=(edtValue)*1;
			BtuITperhourpersquarefoot=(edtValue)*60.000000584;
			Btuthpersecondpersquareinch=(edtValue)*0.0001158182;
			Btuthpersecondpersquarefoot=(edtValue)*0.0166778204;
			Btuthperminutepersquarefoot=(edtValue)*1.0006692258;
			Btuthperhourpersquarefoot=(edtValue)*60.040153549;
			CHUperhourpersquarefoot=(edtValue)*33.333333321;
			break;
		case "Btu (IT)/hour/square foot -Btu(IT)h/ft^2":
			wattpersquaremeter=(edtValue)*3.1545907451;
			kilowattpersquaremeter=(edtValue)*0.0031545907;
			wattpersquarecentimeter=(edtValue)*0.0003154591;
			wattpersquareinch=(edtValue)*0.0020352158;
			joulepersecondpersquaremeter=(edtValue)*3.1545907451;
			kilocalorieITperhourpersquaremeter=(edtValue)*2.7124597981;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.251995761;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0000753461;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0045207663;
			calorieITperhourpersquarecentimeter=(edtValue)*0.2712459798;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0000753965;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0045237917;
			caloriethperhourpersquarecentimeter=(edtValue)*0.271427502;
			dyneperhourpercentimeter=(edtValue)*11356526.682;
			ergperhourpersquaremillimeter=(edtValue)*113565.26682;
			footpoundperminutepersquarefoot=(edtValue)*113565.26682;
			horsepowerpersquarefoot=(edtValue)*0.0003930148;
			horsepowermetricpersquarefoot=(edtValue)*0.0003984658;
			BtuITpersecondpersquarefoot=(edtValue)*0.0002777778;
			BtuITperminutepersquarefoot=(edtValue)*0.0166666665;
			BtuITperhourpersquarefoot=(edtValue)*1;
			Btuthpersecondpersquareinch=(edtValue)*0.0000019303;
			Btuthpersecondpersquarefoot=(edtValue)*0.0002779637;
			Btuthperminutepersquarefoot=(edtValue)*0.0166778203;
			Btuthperhourpersquarefoot=(edtValue)*1.0006692161;
			CHUperhourpersquarefoot=(edtValue)*0.5555555499;
			break;
		case "Btu (th)/second/square inch -Btu(th)s/in^2":
			wattpersquaremeter=(edtValue)*1634246.1785;
			kilowattpersquaremeter=(edtValue)*1634.2461785;
			wattpersquarecentimeter=(edtValue)*163.42461785;
			wattpersquareinch=(edtValue)*1054.3502637;
			joulepersecondpersquaremeter=(edtValue)*1634246.1785;
			kilocalorieITperhourpersquaremeter=(edtValue)*1405198.7778;
			kilocalorieITperhourpersquarefoot=(edtValue)*130547.23819;
			calorieITpersecondpersquarecentimeter=(edtValue)*39.033299376;
			calorieITperminutepersquarecentimeter=(edtValue)*2341.9979625;
			calorieITperhourpersquarecentimeter=(edtValue)*140519.87776;
			caloriethpersecondpersquarecentimeter=(edtValue)*39.059421091;
			caloriethperminutepersquarecentimeter=(edtValue)*2343.5652655;
			caloriethperhourpersquarecentimeter=(edtValue)*140613.91593;
			dyneperhourpercentimeter=(edtValue)*5883286242423.0;
			ergperhourpersquaremillimeter=(edtValue)*58832862424.0;
			footpoundperminutepersquarefoot=(edtValue)*6718886.0405;
			horsepowerpersquarefoot=(edtValue)*203.60260721;
			horsepowermetricpersquarefoot=(edtValue)*206.42650731;
			BtuITpersecondpersquarefoot=(edtValue)*143.90369733;
			BtuITperminutepersquarefoot=(edtValue)*8634.221756;
			BtuITperhourpersquarefoot=(edtValue)*518053.3104;
			Btuthpersecondpersquareinch=(edtValue)*1;
			Btuthpersecondpersquarefoot=(edtValue)*144;
			Btuthperminutepersquarefoot=(edtValue)*8640;
			Btuthperhourpersquarefoot=(edtValue)*518400;
			CHUperhourpersquarefoot=(edtValue)*287807.39176;
			break;
		case "Btu (th)/second/square foot -Btu(th)s/ft^2":
			wattpersquaremeter=(edtValue)*11348.931795;
			kilowattpersquaremeter=(edtValue)*11.348931795;
			wattpersquarecentimeter=(edtValue)*1.1348931795;
			wattpersquareinch=(edtValue)*7.3218768311;
			joulepersecondpersquaremeter=(edtValue)*11348.931795;
			kilocalorieITperhourpersquaremeter=(edtValue)*9758.3248455;
			kilocalorieITperhourpersquarefoot=(edtValue)*906.57804299;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.271064579;
			calorieITperminutepersquarecentimeter=(edtValue)*16.26387474;
			calorieITperhourpersquarecentimeter=(edtValue)*975.83248444;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.2712459798;
			caloriethperminutepersquarecentimeter=(edtValue)*16.274758788;
			caloriethperhourpersquarecentimeter=(edtValue)*976.48552728;
			dyneperhourpercentimeter=(edtValue)*40856154461.0;
			ergperhourpersquaremillimeter=(edtValue)*408561544.61;
			footpoundperminutepersquarefoot=(edtValue)*46658.930837;
			horsepowerpersquarefoot=(edtValue)*1.4139069945;
			horsepowermetricpersquarefoot=(edtValue)*1.4335174118;
			BtuITpersecondpersquarefoot=(edtValue)*0.9993312315;
			BtuITperminutepersquarefoot=(edtValue)*59.959873305;
			BtuITperhourpersquarefoot=(edtValue)*3597.5924334;
			Btuthpersecondpersquareinch=(edtValue)*0.0069444444;
			Btuthpersecondpersquarefoot=(edtValue)*1;
			Btuthperminutepersquarefoot=(edtValue)*60;
			Btuthperhourpersquarefoot=(edtValue)*3600;
			CHUperhourpersquarefoot=(edtValue)*1998.6624428;
			break;
		case "Btu (th)/minute/square foot -Btu(th)min/ft^2":
			wattpersquaremeter=(edtValue)*189.14886325;
			kilowattpersquaremeter=(edtValue)*0.1891488632;
			wattpersquarecentimeter=(edtValue)*0.0189148863;
			wattpersquareinch=(edtValue)*0.1220312805;
			joulepersecondpersquaremeter=(edtValue)*189.14886325;
			kilocalorieITperhourpersquaremeter=(edtValue)*162.63874743;
			kilocalorieITperhourpersquarefoot=(edtValue)*15.10963405;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.004517743;
			calorieITperminutepersquarecentimeter=(edtValue)*0.271064579;
			calorieITperhourpersquarecentimeter=(edtValue)*16.263874741;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0045207663;
			caloriethperminutepersquarecentimeter=(edtValue)*0.2712459798;
			caloriethperhourpersquarecentimeter=(edtValue)*16.274758788;
			dyneperhourpercentimeter=(edtValue)*680935907.69;
			ergperhourpersquaremillimeter=(edtValue)*6809359.0769;
			footpoundperminutepersquarefoot=(edtValue)*777.64884728;
			horsepowerpersquarefoot=(edtValue)*0.0235651166;
			horsepowermetricpersquarefoot=(edtValue)*0.0238919569;
			BtuITpersecondpersquarefoot=(edtValue)*0.0166555205;
			BtuITperminutepersquarefoot=(edtValue)*0.9993312218;
			BtuITperhourpersquarefoot=(edtValue)*59.959873889;
			Btuthpersecondpersquareinch=(edtValue)*0.0001157407;
			Btuthpersecondpersquarefoot=(edtValue)*0.0166666667;
			Btuthperminutepersquarefoot=(edtValue)*1;
			Btuthperhourpersquarefoot=(edtValue)*60;
			CHUperhourpersquarefoot=(edtValue)*33.311040713;
			break;
		case "Btu (th)/hour/square foot -Btu(th)h/ft^2":
			wattpersquaremeter=(edtValue)*3.1524810541;
			kilowattpersquaremeter=(edtValue)*0.0031524811;
			wattpersquarecentimeter=(edtValue)*0.0003152481;
			wattpersquareinch=(edtValue)*0.0020338547;
			joulepersecondpersquaremeter=(edtValue)*3.1524810541;
			kilocalorieITperhourpersquaremeter=(edtValue)*2.7106457904;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.2518272342;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.0000752957;
			calorieITperminutepersquarecentimeter=(edtValue)*0.004517743;
			calorieITperhourpersquarecentimeter=(edtValue)*0.271064579;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0000753461;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0045207663;
			caloriethperhourpersquarecentimeter=(edtValue)*0.2712459798;
			dyneperhourpercentimeter=(edtValue)*11348931.795;
			ergperhourpersquaremillimeter=(edtValue)*113489.31795;
			footpoundperminutepersquarefoot=(edtValue)*12.960814121;
			horsepowerpersquarefoot=(edtValue)*0.0003927519;
			horsepowermetricpersquarefoot=(edtValue)*0.0003981993;
			BtuITpersecondpersquarefoot=(edtValue)*0.000277592;
			BtuITperminutepersquarefoot=(edtValue)*0.0166555204;
			BtuITperhourpersquarefoot=(edtValue)*0.9993312315;
			Btuthpersecondpersquareinch=(edtValue)*0.000001929;
			Btuthpersecondpersquarefoot=(edtValue)*0.0002777778;
			Btuthperminutepersquarefoot=(edtValue)*0.0166666667;
			Btuthperhourpersquarefoot=(edtValue)*1;
			CHUperhourpersquarefoot=(edtValue)*0.5551840119;
			break;
		case "CHU/hour/square foot -CHUh/ft^2":
			wattpersquaremeter=(edtValue)*5.6782633986;
			kilowattpersquaremeter=(edtValue)*0.0056782634;
			wattpersquarecentimeter=(edtValue)*0.0005678263;
			wattpersquareinch=(edtValue)*0.0036633884;
			joulepersecondpersquaremeter=(edtValue)*5.6782633986;
			kilocalorieITperhourpersquaremeter=(edtValue)*4.882427686;
			kilocalorieITperhourpersquarefoot=(edtValue)*0.4535923744;
			calorieITpersecondpersquarecentimeter=(edtValue)*0.000135623;
			calorieITperminutepersquarecentimeter=(edtValue)*0.0081373795;
			calorieITperhourpersquarecentimeter=(edtValue)*0.4882427685;
			caloriethpersecondpersquarecentimeter=(edtValue)*0.0001357138;
			caloriethperminutepersquarecentimeter=(edtValue)*0.0081428251;
			caloriethperhourpersquarecentimeter=(edtValue)*0.4885695085;
			dyneperhourpercentimeter=(edtValue)*20441748.235;
			ergperhourpersquaremillimeter=(edtValue)*204417.48235;
			footpoundperminutepersquarefoot=(edtValue)*23.345078108;
			horsepowerpersquarefoot=(edtValue)*0.0007074266;
			horsepowermetricpersquarefoot=(edtValue)*0.0007172384;
			BtuITpersecondpersquarefoot=(edtValue)*0.0005;
			BtuITperminutepersquarefoot=(edtValue)*0.03;
			BtuITperhourpersquarefoot=(edtValue)*1.8000000182;
			Btuthpersecondpersquareinch=(edtValue)*0.0000034745;
			Btuthpersecondpersquarefoot=(edtValue)*0.0005003346;
			Btuthperminutepersquarefoot=(edtValue)*0.0300200768;
			Btuthperhourpersquarefoot=(edtValue)*1.8012046071;
			CHUperhourpersquarefoot=(edtValue)*1;
			break;
		case "Default":
			break;
			
		}
		results.setWattpersquaremeter(wattpersquaremeter);
		results.setKilowattpersquaremeter(kilowattpersquaremeter);
		results.setWattpersquarecentimeter(wattpersquarecentimeter);
		results.setWattpersquareinch(wattpersquareinch);
		results.setJoulepersecondpersquaremeter(joulepersecondpersquaremeter);
		results.setKilocalorieITperhourpersquaremeter(kilocalorieITperhourpersquaremeter);
		results.setKilocalorieITperhourpersquarefoot(kilocalorieITperhourpersquarefoot);
		results.setCalorieITpersecondpersquarecentimeter(calorieITpersecondpersquarecentimeter);
		results.setCalorieITperminutepersquarecentimeter(calorieITperminutepersquarecentimeter);
		results.setCalorieITperhourpersquarecentimeter(calorieITperhourpersquarecentimeter);
		results.setCaloriethpersecondpersquarecentimeter(caloriethpersecondpersquarecentimeter);
		results.setCaloriethperminutepersquarecentimeter(caloriethperminutepersquarecentimeter);
		results.setCaloriethperhourpersquarecentimeter(caloriethperhourpersquarecentimeter);
		results.setDyneperhourpercentimeter(dyneperhourpercentimeter);
		results.setErgperhourpersquaremillimeter(ergperhourpersquaremillimeter);
		results.setFootpoundperminutepersquarefoot(footpoundperminutepersquarefoot);
		results.setHorsepowerpersquarefoot(horsepowerpersquarefoot);
		results.setHorsepowermetricpersquarefoot(horsepowermetricpersquarefoot);
		results.setBtuITpersecondpersquarefoot(BtuITpersecondpersquarefoot);
		results.setBtuITperminutepersquarefoot(BtuITperminutepersquarefoot);
		results.setBtuITperhourpersquarefoot(BtuITperhourpersquarefoot);
		results.setBtuthpersecondpersquareinch(Btuthpersecondpersquareinch);
		results.setBtuthpersecondpersquarefoot(Btuthpersecondpersquarefoot);
		results.setBtuthperminutepersquarefoot(Btuthperminutepersquarefoot);
		results.setBtuthperhourpersquarefoot(Btuthperhourpersquarefoot);
		results.setCHUperhourpersquarefoot(CHUperhourpersquarefoot);
		 converterArray.add(results);
		return converterArray;
}

public 	class ConversionResults{
		private double wattpersquaremeter,kilowattpersquaremeter,wattpersquarecentimeter,wattpersquareinch,joulepersecondpersquaremeter,kilocalorieITperhourpersquaremeter
		,kilocalorieITperhourpersquarefoot,calorieITpersecondpersquarecentimeter,calorieITperminutepersquarecentimeter,calorieITperhourpersquarecentimeter,caloriethpersecondpersquarecentimeter
		,caloriethperminutepersquarecentimeter,caloriethperhourpersquarecentimeter,dyneperhourpercentimeter,ergperhourpersquaremillimeter,footpoundperminutepersquarefoot
		,horsepowerpersquarefoot,horsepowermetricpersquarefoot,BtuITpersecondpersquarefoot,BtuITperminutepersquarefoot,BtuITperhourpersquarefoot,Btuthpersecondpersquareinch
		,Btuthpersecondpersquarefoot,Btuthperminutepersquarefoot,Btuthperhourpersquarefoot,CHUperhourpersquarefoot;

		public double getWattpersquaremeter() {
			return wattpersquaremeter;
		}

		public void setWattpersquaremeter(double wattpersquaremeter) {
			this.wattpersquaremeter = wattpersquaremeter;
		}

		public double getKilowattpersquaremeter() {
			return kilowattpersquaremeter;
		}

		public void setKilowattpersquaremeter(double kilowattpersquaremeter) {
			this.kilowattpersquaremeter = kilowattpersquaremeter;
		}

		public double getWattpersquarecentimeter() {
			return wattpersquarecentimeter;
		}

		public void setWattpersquarecentimeter(double wattpersquarecentimeter) {
			this.wattpersquarecentimeter = wattpersquarecentimeter;
		}

		public double getWattpersquareinch() {
			return wattpersquareinch;
		}

		public void setWattpersquareinch(double wattpersquareinch) {
			this.wattpersquareinch = wattpersquareinch;
		}

		public double getJoulepersecondpersquaremeter() {
			return joulepersecondpersquaremeter;
		}

		public void setJoulepersecondpersquaremeter(double joulepersecondpersquaremeter) {
			this.joulepersecondpersquaremeter = joulepersecondpersquaremeter;
		}

		public double getKilocalorieITperhourpersquaremeter() {
			return kilocalorieITperhourpersquaremeter;
		}

		public void setKilocalorieITperhourpersquaremeter(
				double kilocalorieITperhourpersquaremeter) {
			this.kilocalorieITperhourpersquaremeter = kilocalorieITperhourpersquaremeter;
		}

		public double getKilocalorieITperhourpersquarefoot() {
			return kilocalorieITperhourpersquarefoot;
		}

		public void setKilocalorieITperhourpersquarefoot(
				double kilocalorieITperhourpersquarefoot) {
			this.kilocalorieITperhourpersquarefoot = kilocalorieITperhourpersquarefoot;
		}

		public double getCalorieITpersecondpersquarecentimeter() {
			return calorieITpersecondpersquarecentimeter;
		}

		public void setCalorieITpersecondpersquarecentimeter(
				double calorieITpersecondpersquarecentimeter) {
			this.calorieITpersecondpersquarecentimeter = calorieITpersecondpersquarecentimeter;
		}

		public double getCalorieITperminutepersquarecentimeter() {
			return calorieITperminutepersquarecentimeter;
		}

		public void setCalorieITperminutepersquarecentimeter(
				double calorieITperminutepersquarecentimeter) {
			this.calorieITperminutepersquarecentimeter = calorieITperminutepersquarecentimeter;
		}

		public double getCalorieITperhourpersquarecentimeter() {
			return calorieITperhourpersquarecentimeter;
		}

		public void setCalorieITperhourpersquarecentimeter(
				double calorieITperhourpersquarecentimeter) {
			this.calorieITperhourpersquarecentimeter = calorieITperhourpersquarecentimeter;
		}

		public double getCaloriethpersecondpersquarecentimeter() {
			return caloriethpersecondpersquarecentimeter;
		}

		public void setCaloriethpersecondpersquarecentimeter(
				double caloriethpersecondpersquarecentimeter) {
			this.caloriethpersecondpersquarecentimeter = caloriethpersecondpersquarecentimeter;
		}

		public double getCaloriethperminutepersquarecentimeter() {
			return caloriethperminutepersquarecentimeter;
		}

		public void setCaloriethperminutepersquarecentimeter(
				double caloriethperminutepersquarecentimeter) {
			this.caloriethperminutepersquarecentimeter = caloriethperminutepersquarecentimeter;
		}

		public double getCaloriethperhourpersquarecentimeter() {
			return caloriethperhourpersquarecentimeter;
		}

		public void setCaloriethperhourpersquarecentimeter(
				double caloriethperhourpersquarecentimeter) {
			this.caloriethperhourpersquarecentimeter = caloriethperhourpersquarecentimeter;
		}

		public double getDyneperhourpercentimeter() {
			return dyneperhourpercentimeter;
		}

		public void setDyneperhourpercentimeter(double dyneperhourpercentimeter) {
			this.dyneperhourpercentimeter = dyneperhourpercentimeter;
		}

		public double getErgperhourpersquaremillimeter() {
			return ergperhourpersquaremillimeter;
		}

		public void setErgperhourpersquaremillimeter(
				double ergperhourpersquaremillimeter) {
			this.ergperhourpersquaremillimeter = ergperhourpersquaremillimeter;
		}

		public double getFootpoundperminutepersquarefoot() {
			return footpoundperminutepersquarefoot;
		}

		public void setFootpoundperminutepersquarefoot(
				double footpoundperminutepersquarefoot) {
			this.footpoundperminutepersquarefoot = footpoundperminutepersquarefoot;
		}

		public double getHorsepowerpersquarefoot() {
			return horsepowerpersquarefoot;
		}

		public void setHorsepowerpersquarefoot(double horsepowerpersquarefoot) {
			this.horsepowerpersquarefoot = horsepowerpersquarefoot;
		}

		public double getHorsepowermetricpersquarefoot() {
			return horsepowermetricpersquarefoot;
		}

		public void setHorsepowermetricpersquarefoot(
				double horsepowermetricpersquarefoot) {
			this.horsepowermetricpersquarefoot = horsepowermetricpersquarefoot;
		}

		public double getBtuITpersecondpersquarefoot() {
			return BtuITpersecondpersquarefoot;
		}

		public void setBtuITpersecondpersquarefoot(double btuITpersecondpersquarefoot) {
			BtuITpersecondpersquarefoot = btuITpersecondpersquarefoot;
		}

		public double getBtuITperminutepersquarefoot() {
			return BtuITperminutepersquarefoot;
		}

		public void setBtuITperminutepersquarefoot(double btuITperminutepersquarefoot) {
			BtuITperminutepersquarefoot = btuITperminutepersquarefoot;
		}

		public double getBtuITperhourpersquarefoot() {
			return BtuITperhourpersquarefoot;
		}

		public void setBtuITperhourpersquarefoot(double btuITperhourpersquarefoot) {
			BtuITperhourpersquarefoot = btuITperhourpersquarefoot;
		}

		public double getBtuthpersecondpersquareinch() {
			return Btuthpersecondpersquareinch;
		}

		public void setBtuthpersecondpersquareinch(double btuthpersecondpersquareinch) {
			Btuthpersecondpersquareinch = btuthpersecondpersquareinch;
		}

		public double getBtuthpersecondpersquarefoot() {
			return Btuthpersecondpersquarefoot;
		}

		public void setBtuthpersecondpersquarefoot(double btuthpersecondpersquarefoot) {
			Btuthpersecondpersquarefoot = btuthpersecondpersquarefoot;
		}

		public double getBtuthperminutepersquarefoot() {
			return Btuthperminutepersquarefoot;
		}

		public void setBtuthperminutepersquarefoot(double btuthperminutepersquarefoot) {
			Btuthperminutepersquarefoot = btuthperminutepersquarefoot;
		}

		public double getBtuthperhourpersquarefoot() {
			return Btuthperhourpersquarefoot;
		}

		public void setBtuthperhourpersquarefoot(double btuthperhourpersquarefoot) {
			Btuthperhourpersquarefoot = btuthperhourpersquarefoot;
		}

		public double getCHUperhourpersquarefoot() {
			return CHUperhourpersquarefoot;
		}

		public void setCHUperhourpersquarefoot(double cHUperhourpersquarefoot) {
			CHUperhourpersquarefoot = cHUperhourpersquarefoot;
		}
		
	}
}