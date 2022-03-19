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
public enum Months {

    Ocak(1,"OCAK"),
    Subat(2,"ŞUBAT"),
    Mart(3,"MART"),
    Nisan(4,"NİSAN"),
    Mayis(5,"MAYIS"),
    Haziran(6,"HAZİRAN"),
    Temmuz(7,"TEMMUZ"),
    Agustos(8,"AGUSTOS"),
    Eylul(9,"EYLÜL"),
    Ekim(10,"EKİM"),
    Kasim(11,"KASIM"),
    Aralik(12,"ARALIK");

    private int month;
    private String monthName;

    private Months(int month,String monthName) {
        this.month = month;
        this.monthName = monthName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

}
