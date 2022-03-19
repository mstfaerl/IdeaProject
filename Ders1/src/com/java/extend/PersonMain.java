/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.extend;

import com.java.extend2.Ik;
import com.java.extend2.Musteri;
import com.java.extend2.SatisUzmani;

/**
 *
 * @author m07er
 */
public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person();
        person.setPersonIsim("asd");
        System.out.println(person.getPersonIsim());

        Ik person1 = new Ik();
        person1.setPersonIsim("sdf");
        System.out.println(person1.getPersonIsim());
        person1.setPersonSoyisim("dfg");
        person1.FullName();

        Musteri musteri = new Musteri();
        musteri.setPersonIsim("Mustafa");
        musteri.setPersonSoyisim("Erol");
        musteri.setPersonTc("123123");
        musteri.setPersonAdres("Malatya");
        musteri.setPersonCinsiyet(false);
        musteri.setMusteriId("K23L12");
        musteri.setMusteriPuan("3456");

        System.out.println("Musteri id : " + musteri.getMusteriId() + "\nMusteri tc : " + musteri.getPersonTc() + "\nMusteri isim : " + musteri.getPersonIsim() + "\nMusteri soyisim : " + musteri.getPersonSoyisim() +  "\nMusteri puan : " + musteri.getMusteriPuan() + "\nCinsiyet : " + musteri.Cinsiyet());
        musteri.FullName();
        
        
        SatisUzmani satisUzmani = new SatisUzmani();
        satisUzmani.FullName();
        if(satisUzmani instanceof Person){
            System.out.println("Doğrudur Gardaşım");
        }else{
            System.out.println("Kaybol gözüm görmesin");
        }
        
    }
}

