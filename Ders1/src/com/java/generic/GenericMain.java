/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m07er
 */
public class GenericMain {

    public static void main(String[] args) throws ArithmeticException, NullPointerException {

        Generic<String> generic = new Generic("Mustafa");
        System.out.println("A : " + generic.getA());
        generic.dataTypes();
        Generic<Integer> generic1 = new Generic(18);
        System.out.println("A : " + generic1.getA());
        generic1.dataTypes();

        MultiGeneric<Integer, String> generic2 = new MultiGeneric(18, "Mustafa");
        System.out.println("Tx : " + generic2.getTx() + "\nTy : " + generic2.getTy());
        generic2.dataTypes();

        GenericList<String> list = new GenericList();
        list.getList().add("Mustafa");
        list.getList().add("Erol");
        System.out.println(list.getList().get(0) + " " + list.getList().get(1));

        GenericMethod generic3 = new GenericMethod();

        Integer[] dizi = new Integer[2];
        String[] dizi1 = new String[2];

        dizi[0] = 0;
        dizi[1] = 1;
        dizi1[0] = "A";
        dizi1[1] = "B";

        generic3.genericMethod(dizi);
        generic3.genericMethod(dizi1);

        GenericConstructor gC = new GenericConstructor("asd");
        GenericConstructor gC1 = new GenericConstructor(12);

        System.out.println(gC.getObject());
        gC.methodName();
        System.out.println(gC1.getObject());
        gC1.methodName();

        System.out.println("------------------------------------");

        try {
            GenericSinif genericSinif = new GenericSinif("Mustafa", "Erol", 22);
            GenericSinif genericSinif1 = new GenericSinif("Mustafa1", "Erol1", 221);
            List<String> genericList1 = new ArrayList<>();
            List<Integer> genericList2 = new ArrayList<>();

            genericList1.add(genericSinif.getAd());
            genericList1.add(genericSinif.getSoyad());
            genericList2.add(genericSinif.getYas());

            genericList1.add(genericSinif1.getAd());
            genericList1.add(genericSinif1.getSoyad());
            genericList2.add(genericSinif1.getYas());

            for (String str : genericList1) {
                System.out.println(str);
            }

            for (Integer in : genericList2) {
                System.out.println(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------");

        try {
            GenericsSinif genericsSinif1 = new GenericsSinif("Mustafa", "Erol", 22, 1996);
            GenericsSinif genericsSinif2 = new GenericsSinif("Mustafa1", "Erol1", 23, 1995);
            List<GenericsSinif> genericsList = new ArrayList<>();
            genericsList.add(genericsSinif1);
            genericsList.add(genericsSinif2);

            for (GenericsSinif genericsSinif : genericsList) {
                System.out.println("Adı : " + genericsSinif.getName() + "\nSoyadı : " + genericsSinif.getSurname() + "\nYaşı : " + genericsSinif.getAge() + "\nDoğum Tarihi : " + genericsSinif.getBirthDay() + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("------------------------------------");

        Generics<Integer> generics1 = new Generics("Mustafa", "Erol", 44);
        Generics<Double> generics2 = new Generics("Mustafa1", "Erol1", 44.54);

        List<Generics<Integer>> genericsList1 = new ArrayList<>();
        List<Generics<Double>> genericsList2 = new ArrayList<>();


        genericsList1.add(generics1);
        genericsList2.add(generics2);

        for (Generics generic4 : genericsList1) {
            System.out.println("Adı : " + generic4.getName() + "\nSoyadı : " + generic4.getSurname() + "\nFiyat : " + generic4.getFiyat() + "\n");
        }
        
        for (Generics generic4 : genericsList2) {
            System.out.println("Adı : " + generic4.getName() + "\nSoyadı : " + generic4.getSurname() + "\nFiyat : " + generic4.getFiyat() + "\n");
        }

    }

}
