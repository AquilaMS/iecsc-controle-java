package com.iecsc.iecsccontrole.Utils;

import javafx.util.converter.CurrencyStringConverter;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class ConvertData {

    public String convertToCurrencyFormat(String textInput){
        try{
            String textNumber = NumberFormat.getCurrencyInstance().format(new BigDecimal(textInput));
            return textNumber;
        }catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}
