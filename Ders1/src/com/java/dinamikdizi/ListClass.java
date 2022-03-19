/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dinamikdizi;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;
import java.util.List;

/**
 *
 * @author m07er
 */
public class ListClass {

    public static void main(String[] args) {

        List<Integer> aList = new ArrayList<>();

        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);
        aList.add(5);
        
        //Iterator kullanımı
//        Iterator<Integer> itr = aList.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
        

        System.out.println("0.indis : " + aList.get(0));
        System.out.println("------------------");

        for (Integer list : aList) {
            System.out.println("aList : " + list);
        }

        System.out.println("-------------------------");

        System.out.println("aList size : " + aList.size());

        System.out.println("-------------------------");

        aList.remove(4);

        for (Integer list : aList) {
            System.out.println("Güncel aList : " + list);
        }

        System.out.println("------------------------");

        List<Integer> bList = new ArrayList<>();

        bList.addAll(aList);

        for (Integer list : bList) {
            System.out.println("bList : " + list);
        }

        System.out.println("------------------------");

        aList.clear();

        if (aList.size() == 0) {
            System.out.println("Liste silindi.");
        } else {
            for (Integer list : aList) {
                System.out.println("Güncel aList : " + list);
            }
        }

        System.out.println("------------------------");
        aList.add(2);
        aList.add(5);
        aList.add(4);
        aList.add(3);
        aList.add(1);

        System.out.println("0-2 aralığı : " + aList.subList(0, 3));

        System.out.println("------------------------");

        Collections.sort(aList);

        for (Integer list : aList) {
            System.out.println("Sort sıralanmış Liste : " + list);
        }

        System.out.println("------------------------");
        Collections.reverse(aList);

        for (Integer list : aList) {
            System.out.println("Reverse : " + list);
        }

        Collections.sort(aList);
        System.out.println("BinarySearch : " + Collections.binarySearch(aList, 5));

        Collections.shuffle(aList);

        for (Integer list : aList) {
            System.out.println("Shuffle : " + list);
        }
        
        System.out.println("------------------------");
        //Araya yerleştirme gibi fonksiyonlar bekliyorsak LinkedList kullanmalıyız.
        //Sürekli arama yapılıyorsa List kullanılır.
        List<Integer> cList = new ArrayList<>();
        cList.add(11);
        cList.add(22);

        List<Integer> dList = new ArrayList<>();
        dList.add(33);
        dList.add(44);

        dList.addAll(cList);

        for (Integer item : cList) {
            System.out.println("cList : " + item);
        }

        System.out.println("---------------------");

        for (Integer item : dList) {
            System.out.println("dList : " + item);
        }

    }

}
