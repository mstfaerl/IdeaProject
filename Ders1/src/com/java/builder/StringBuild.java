/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.builder;

/**
 *
 * @author m07er
 */
public class StringBuild {

    public static void main(String[] args) {
        
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("1.").append("Java ").append("Java SE ").append("Java EE ");
        sBuilder.append("\r\n2.").append("HTML5 ").append("Css3 ").append("JS ").append("JQuery ");
        sBuilder.append("\r\n3.").append("Malatya ").append("Yeşilyurt ").append("Battalgazi ");
        String str = sBuilder.toString();
        System.out.println("Append : " + str);
        
//        int cap = sBuilder.capacity();
//        System.out.println("Kapasite : " + cap);
//        char c = sBuilder.charAt(56);
//        System.out.println("56. Index : " + c);
        
        //Kısaca bu şekilde de üretilebilir.
        String str1 = new StringBuilder("1.").append("asd ").append("sdf").toString();
        System.out.println("str1 : " + str1);
    }

}
