/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.enums;

/**
 *
 * @author m07er
 */
public class EnumMain {

    public static void main(String[] args) {

        Months months = Months.Temmuz;

        System.out.println("Ay : " + months.getMonth());
        System.out.println("--------------------");
        Days days = Days.Pazartesi;
        System.out.println("Day : " + days);
        
        System.out.println("--------------------");
        
        for (Days day : days.values()) {
            System.out.println(day);
        }
        
        System.out.println("---------------------");
        
        Months months1 = Months.Haziran;
//        months1.setMonth(9);
//        months1.setMonthName("Bilmem");
        System.out.println(months1.getMonth() + " " + months1.getMonthName());
        
    }
}

