/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.tokenizer;

import java.util.StringTokenizer;


/**
 *
 * @author m07er
 */
public class StringTokenizerMain {
    public static void main(String[] args) {
        
        
        String str = "malatya adsd *malatya ,dfgofg malatya *dkfgjdfg ?malatya +sdfsdf";
        StringTokenizer sTok = new StringTokenizer(str);
        StringTokenizer sTok1 = new StringTokenizer(str, "*,?+ ");
        StringTokenizer sTok2 = new StringTokenizer(str, "*,?+ ", true);
        
        while(sTok.hasMoreTokens()){
            String str1 = sTok.nextToken();
            System.out.println("Str1 : " + str1);
        }
        
        while(sTok1.hasMoreTokens()){
            String str2 = sTok1.nextToken();
            System.out.println("Str2 : " + str2);
        }
        
        while(sTok2.hasMoreTokens()){
            String str3 = sTok2.nextToken();
            System.out.println("Str3 : " + str3);
        }
        
        String sM = "Merhabalar nasılsınız biz Malatyadayız.";
        StringTokenizer sTok3 = new StringTokenizer(sM);
        String a,b,c,d;
        a = sTok3.nextToken();
        b = sTok3.nextToken();
        c = sTok3.nextToken();
        d = sTok3.nextToken();
        System.out.println(a + " " + b + " " + c + " " + d);
        
        String str5 = "14.56|Melekbaba|44";
        StringTokenizer sTok4 = new StringTokenizer(str5, "|");
        double dou = Double.parseDouble(sTok4.nextToken());
        String str6 = sTok4.nextToken();
        int inte = Integer.parseInt(sTok4.nextToken());
        
        System.out.println("Double : " + dou + " String : " + str6 + " Intege r : " + inte);
        System.out.println("Toplam : " + (dou + inte));      

    }
}
