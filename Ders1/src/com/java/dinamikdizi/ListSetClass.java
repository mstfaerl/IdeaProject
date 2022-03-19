/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.dinamikdizi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author m07er
 */
public class ListSetClass {

    public static void main(String[] args) {

        //Eğer elemanlar art arda ise sıralı getirir.Değilse HashSet karışık sıralar.
        Set<Integer> hashSetList = new HashSet<>();

        hashSetList.add(123);
        hashSetList.add(120);
        hashSetList.add(122);
        hashSetList.add(121);
        hashSetList.add(119);
        
        //Iterator kullanımı 
        Iterator<Integer> id = hashSetList.iterator(); 
        while(id.hasNext()){
            System.out.println("Iterator : " + id.next());
        }
        
        System.out.println("---------------------------");
        
        for (Integer item : hashSetList) {
            System.out.println("HashSetList : " + item);
        }
           
        System.out.println("---------------------------");
        
        //Eklediğimiz sırada gelsin istiyorsak LinkedHashSet kullanırız.        
        Set<Integer> linkedSetList = new LinkedHashSet<>();

        linkedSetList.add(123);
        linkedSetList.add(120);
        linkedSetList.add(122);
        linkedSetList.add(121);
        linkedSetList.add(119);

        for (Integer item : linkedSetList) {
            System.out.println("LinkedHashSet : " + item);
        }
        
        System.out.println("---------------------------");
        
        //Eğer sıralı eklenmesini istiyorsak TreeSet kullanmalıyız.
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(123);
        treeSet.add(120);
        treeSet.add(122);
        treeSet.add(121);
        treeSet.add(119);

        for (Integer item : treeSet) {
            System.out.println("TreeSet : " + item);
        }

        System.out.println("---------------------------");
        
        //Araya koyma gibi işlemler yapacaksaksak LinkedList kullanmalıyız.
        LinkedList<Integer> aLinkedList = new LinkedList<>();
        
        aLinkedList.add(33);
        aLinkedList.add(55);
        aLinkedList.add(44);
        aLinkedList.add(11);
        aLinkedList.add(22);
        
        for (Integer item : aLinkedList) {
            System.out.println("LinkedList : " + item);
        }
        
        System.out.println("---------------------------");
        
        //Boyutu dolduğunda 2 katına çıkaran vector listesini kullanabilir.
        Vector vectorList = new Vector();
        
        vectorList.add("Mustafa");
        vectorList.add(1);
        
        Iterator itr = vectorList.iterator();
        
        while(itr.hasNext()){
            System.out.println("Iterator : " + itr.next());
        }
        
    }
}
