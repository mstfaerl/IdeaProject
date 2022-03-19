/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author m07er
 */
public class MapMain {

    public static void main(String[] args) {

//        Map<Integer, String> mapList = new HashMap<>();
//
//        mapList.put(01, "Adana");
//        mapList.put(02, "Adıyaman");
//        mapList.put(03, "Afyon");
//        mapList.put(04, "Ağrı");
//        mapList.put(05, "Amasya");
//        mapList.put(06, "Ankara");
//        mapList.put(07, "Antalya");
//
//        System.out.println("Foreach with keySet()");
//
//        for (Integer item : mapList.keySet()) {
//            System.out.println(item);
//        }
//
//        System.out.println("------------");
//
//        System.out.println("Foreach with values()");
//        for (String item : mapList.values()) {
//            System.out.println(item);
//        }
//
//        System.out.println("------------");
//
//        System.out.println("Iterator with entrySet()");
//        Set setMap = mapList.entrySet();
//        Iterator itr = setMap.iterator();
//
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
//
//        System.out.println("------------");
//
//        System.out.println("Iterator with keySet()");
//        Set setMap2 = mapList.keySet();
//        Iterator itr2 = setMap2.iterator();
//        while (itr2.hasNext()) {
//            System.out.println(itr2.next());
//        }
//
//        System.out.println("------------");
//
//        System.out.println("Size : " + mapList.size());
//
//        Integer a = 5;
//        System.out.println("Get : " + mapList.get(5));
//
//        System.out.println("------------");
//
//        String str = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit enim nihil illo et architecto a incidunt, ea rerum fugiat? Mollitia iste necessitatibus sequi esse, adipisci voluptates. Modi earum iusto exercitationem.Perspiciatis, molestias aut? Atque, dolorem exercitationem? Eveniet accusantium quis et totam vitae iure perferendis nemo molestiae. Provident a iusto eligendi, libero illo, molestiae, sunt repellendus architecto nam reiciendis commodi expedita?";
//
//        String[] arr = str.split(" ");
//
//        Map<Integer, Character> strList = new HashMap<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            strList.put(i, arr[i].charAt(0));
//            Integer cevrim = (int) arr[i].charAt(0);
//        }
//
//        Set setMap3 = strList.entrySet();
//        Iterator itr3 = setMap3.iterator();
//
//        while (itr3.hasNext()) {
//            System.out.println(itr3.next());
//        }
//
//        System.out.println("-----------------------");
//
//        String str1 = "Malatya Teknokent Java";
//
//        String[] arr1 = str1.split(" ");
//
//        Map<Character, String> strList1 = new HashMap<>();
//
//        String str5;
//
//        for (int i = 0; i < arr1.length; i++) {
//            char ilkHal = arr1[i].charAt(0);
//            int cevrim1 = (int) arr[i].charAt(0) + 3;
//            str5 = Character.toString((char) cevrim1);
//            strList1.put(ilkHal, str5);
//            System.out.println("İlk hali : " + ilkHal);
//            System.out.println("Integer Çevrim : " + cevrim1);
//            System.out.println("String Çevrim : " + str5);
//        }
//
//        Set setListMap = strList1.entrySet();
//        Iterator itr5 = setListMap.iterator();
//
//        while (itr5.hasNext()) {
//            System.out.println(itr5.next());
//        }
//        
//        System.out.println("Bundan sonrası farklı değişkenler aynı olabilir dikkat et");
        
        System.out.print("Lütfen herhangi bir cümle giriniz : ");
        String str = scan().nextLine();
        
        String[] arr = str.split("");

        Map<Integer, Character> strList = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            strList.put(i, arr[i].charAt(0));
        }

        Set setMap = strList.entrySet();
        Iterator itr = setMap.iterator();
        
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }

    public static Scanner scan(){
        Scanner scan = new Scanner(System.in);
        return scan;
    }
}
