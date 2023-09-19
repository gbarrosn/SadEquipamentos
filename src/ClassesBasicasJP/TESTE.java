/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBasicasJP;

import java.math.BigDecimal;
import java.text.DecimalFormat;
//import java.text.NumberFormat;


/**
 *
 * @author joao.paulo
 */
public class TESTE {
    public static void main(String[]  args){
        DecimalFormat df = new DecimalFormat ("###,###,###,###.00");
                df.setParseBigDecimal (true);
       //BigDecimal bd = new BigDecimal ("1234567890.12");
        try {
            BigDecimal b1 = (BigDecimal) df.parse ("123.456.798,5548");
           // String s1 = df.format (b1);
           // System.out.println (s1);
           // System.out.println (bd);
            System.out.println (df.format (b1));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
      
        
        
        
        
        
        
        
        //FUNCIONOU
        /* try{
        String s = "1234567987897789789.89";
        BigDecimal bd = new BigDecimal(s);
        NumberFormat nf = NumberFormat.getNumberInstance();
        String formatado = nf.format(bd);
        //formatado.substring(0, 4);
        String result1 = formatado.substring(0, formatado.length() -3).replace(".", "");
        String result2 = formatado.substring(formatado.length() -3).replace(",", ".");
        String resultFinal = result1 + result2;
        BigDecimal bd2 = new BigDecimal(resultFinal);
        String valorFinal = nf.format(bd2);
        System.out.println(valorFinal);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
    }
    }

