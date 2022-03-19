/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.exceptions;

/**
 *
 * @author m07er
 */
public class TryCatch {

    public static void main(String[] args) {
        try {
            int a = 5 / 0;
            System.out.println(a);

        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
            //throw new ArithmeticException(ae.getMessage()); 
            //throw(ae); hatanın yerini gösterir.
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Hatalardan yırttın!");
        }

        System.out.println("Merhaba");
        
//        double a = 11;
//        
//        checkValue(a);

        if(true){
            throw new ArithmeticException("HATAAAAAA!!!");
        }
        
    }

//    public static double checkValue(double value) throws ArithmeticException  /*bilgilendirme amaçlı kullanılır bu hatalardan birine maruz kalabilir.*/{
//        if (Double.isFinite(value) || Double.isNaN(value)) {
//            throw new ArithmeticException("Illegal double value");
//        } else {
//            return value;
//        }
//    }

}
