/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 *
 * @author m07er
 */
public class UygulamaMain {
    
    public static void main(String[] args) {
        
        String path = "D:\\Data\\data4.txt";
        
        try(BufferedWriter bW = new BufferedWriter(new FileWriter(path))){
            bW.write("Malatya Teknokent AŞ");
        }catch(Exception e){
            System.err.println(e);
        }
        
        String str1 = "";
        try(BufferedReader bR = new BufferedReader(new FileReader(path))){
            String str = "";
            while((str = bR.readLine()) != null){
                str1 += str;
            }
           
        }catch(Exception e){
            System.err.println(e);
        }
        
        
        StringTokenizer sT = new StringTokenizer(str1," ");
        String []arr = new String[sT.countTokens()];
        int boyut = 0;
        while(sT.hasMoreTokens()){
            arr[boyut] = sT.nextToken();
            boyut++;
        }
        
        String yeni = "";
        for (int i = arr.length-1 ; i>=1 ; i--) {
            yeni += arr[i].concat(" ");
            if(i == 1){
                yeni += arr[i-1];
            }
        }
        
        System.out.println(yeni);

        try(BufferedWriter bW = new BufferedWriter(new FileWriter(path))){
            bW.write(yeni);
        }catch(Exception e){
            System.err.println(e);
        }

    }
}
