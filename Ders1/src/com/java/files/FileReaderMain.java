/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author m07er
 */
public class FileReaderMain {
    
    public static void main(String[] args) throws IOException {
        
        String path = "D:\\Data\\data1.txt";
        FileReader fR = new FileReader(path);
        BufferedReader bR = new BufferedReader(fR);
        try{
            String satir = "";
            while((satir = bR.readLine()) != null){
                System.out.println(satir);
            }         
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            bR.close();
        }
        
        //try with resources
        try(BufferedReader bR2 = new BufferedReader(new FileReader("D:\\Data\\data2.txt"))){
            String satir1 = "";
            while((satir1 = bR2.readLine()) != null){
                System.out.println(satir1);
            }       
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
