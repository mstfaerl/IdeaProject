/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dersler;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author m07er
 */
public class Ders005 {

    public static void main(String[] args) {

//        Map <String,String> city = new HashMap<String,String>();//diamond özelliği dolayısıyla 2 <> içine yazılmazsada olur ama yazılırsa da daha iyi olur. 
//        city.put("malatya-1","Turkey");
//        city.put("malatya-2","Turkey");
//        city.put("malatya-3","Turkey");
//        city.put("malatya-4","Turkey");
//        city.put("malatya-5","Turkey");
//        city.put("malatya-6","Turkey");
//        
//        city.remove("malatya-5");
//        
//        String arama = city.get("malatya-3");
//        System.out.println("city : " + arama);
//        System.out.println("------------------");
//        
//        for(String ulke : city.values()){
//            System.out.println("ulke : " + ulke);
//        }
//        
//        System.out.println("------------------");
//        
//        for(String key : city.keySet()){
//            System.out.println("key : " + key);
//        }
//        
//        System.out.println("-------------------");       
        Formatter format1 = new Formatter(System.out);
        Formatter format2 = new Formatter(System.out);
        String str = "Battalgazi";
        double d = 45.52;
        short s = 32;

        format1.format("String : %s  Decimal : %d  Float : %f  \n", str, s, d);

        System.out.println("---------------------------");

        System.out.printf("String : %s  Decimal : %d  Float : %f \n", str, s, d);
        
        System.out.println("---------------------------");
        
        System.out.printf("String : %10s  Decimal : %10d  Float : %.1f \n", str, s, d); //%10d 10 karakter boşluk bırakır, %2.2f virgülden önce 2 sonra 2 rakam getirsin

    }
}
