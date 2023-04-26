package com.iecsc.iecsccontrole.Utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class CurrencyConverter {

    public String convertStringToCurrency(String value){
        value = value.replaceAll("\\D", "");
        Double centsValue = Double.parseDouble(value)/100;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
        System.out.println(nf.format(centsValue).trim());
        return nf.format(centsValue).trim();
    }
}
