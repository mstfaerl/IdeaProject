/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author m07er
 */
public class FileWriterMain {

    public static void main(String[] args) throws IOException {
        
        String path = "D:\\Data\\data1.txt";

        BufferedWriter bW = null;
        try {
            FileWriter fW = new FileWriter(path);
            bW = new BufferedWriter(fW);
            bW.write("Malatya Teknokent Java");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            bW.close();
        }

    }

}
