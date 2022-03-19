/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.tokenizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author m07er
 */
public class Uygulama {

    public static void main(String[] args) {

        Map<Integer, Integer> mapList = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç sayı olsun istersiniz : ");
        int sayi = scan.nextInt();

        for (int i = 0; i < sayi; i++) {
            mapList.put(i, (int) (Math.random()* 30 + 1));
        }

        Set mapSetList = mapList.entrySet();
        Iterator itr = mapSetList.iterator();

        System.out.println("Liste Elemanları");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        int toplam = 0;
        for (Integer item : mapList.values()) {
            toplam += item;
        }

        System.out.println("Liste Elemanlarının Toplamı : " + toplam);

    }
}
