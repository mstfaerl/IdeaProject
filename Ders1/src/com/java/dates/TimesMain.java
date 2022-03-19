/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

/**
 *
 * @author m07er
 */
public class TimesMain {

    public static void main(String[] args) {

        /*
        long times = System.currentTimeMillis();
        System.out.println("Times : " + times); //Milisaniye cinsinden zamanı getirir.

        Locale locale = new Locale("tr", "TR");
        System.out.println("Ulke dili(Ulke ismi) : " + locale.getDisplayName()); //Dili ve İsmi 

        Date date = new Date();
        System.out.println("Normal tarih : " + date); //Zamani gün ay yıl saat biçiminde getirir.

        SimpleDateFormat formatDate = new SimpleDateFormat();
        String str = formatDate.format(date);
        System.out.println("Boş format tarih : " + str);

        SimpleDateFormat formatDate1 = new SimpleDateFormat("dd/MM/yy");
        String str1 = formatDate1.format(date);
        System.out.println("dd/MM/yy format tarih : " + str1);

        SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yy * hh:mm:ss");
        String str2 = formatDate2.format(date);
        System.out.println("dd/MM/yy * hh:mm:ss format tarih : " + str2);

        SimpleDateFormat formatDate3 = new SimpleDateFormat("dd-MMMM-yyyy * hh:mm:ss");
        String str3 = formatDate3.format(date);
        System.out.println("dd/MMMM/yyyy format tarih : " + str3);

        Date date1 = new Date(97, 6, 13);
        SimpleDateFormat formatDate4 = new SimpleDateFormat("dd/MMMM/yyyy");
        String str4 = formatDate4.format(date1);
        System.out.println(str4);
        
        Date date2 = new Date(119, 6, 13, 1, 30);
        SimpleDateFormat formatDate5 = new SimpleDateFormat("dd/MMMM/yyyy hh:mm");
        String str5 = formatDate5.format(date2);
        System.out.println(str5);
       
        Calendar calendar = Calendar.getInstance();
        System.out.println("Takvim : " + calendar.getTime());
        System.out.println("Takvim : " + calendar.getTime().getTime());
        
        SimpleDateFormat formatDate6 = new SimpleDateFormat("dd/MMMM/yyyy hh:mm");
        String str6 = formatDate6.format(calendar.getTime());
        System.out.println("Takvim format : " + str);
        */
        
        Date date = new Date();
        System.out.println("Date : " + date);
        
        Locale locale = new Locale("tr","TR");
        System.out.println("Locale : " + locale.getDisplayName());
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy * HH:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        String str = simpleDateFormat.format(date);
        System.out.println("SimpleDateFormat : " + str);
        
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar : " + calendar.getTime());
        
        String str1 = simpleDateFormat.format(calendar.getTime());
        System.out.println("Calendar with SimpleDateFormat : " + str1);
        
        String str2 = simpleDateFormat1.format(calendar.getTime().getTime());
        System.out.println("Calendar with SimpleDateFormat : " + str2);
        
        calendar.set(2019, 4, 33);
        String str3 = simpleDateFormat1.format(calendar.getTime());
        System.out.println("Calendar with SimpleDateFormat : " + str3);

    }

}
