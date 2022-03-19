/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author m07er
 */
public class FilesMain {

    public static void main(String[] args) {

        String path = "D:\\Data";
        //String path = "D:\\Data\\data.txt";
        File file = new File(path);
        System.out.println("Dosyanın yolu : " + file.getParent());
        System.out.println("Dosya uzantısı yolu : " + file.getAbsolutePath());
        System.out.println("Dosya çalışıyor mu : " + file.canExecute());
        System.out.println("Dosya okunabilir mi : " + file.canRead());
        System.out.println("Dosya yazılabilir mi : " + file.canWrite());
        System.out.println("Dosya var mı : " + file.exists());
        System.out.println("Dosya adı : " + file.getName());
        System.out.println("Dosya  class : " + file.getClass());
        System.out.println("Dosya görünürlüğü : " + file.isHidden());
        System.out.println("Dosya length : " + file.length());
        Locale lokal = new Locale("tr", "TR");
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", lokal);
        Date date = new Date(file.lastModified());
        String str = sdf.format(date);
        System.out.println("Değişiklik tarihi : " + str);

        for (String itr : file.list()) {
            System.out.println("Eger klasorün içinde dosya varsa isimlerini yazdırır : " + itr);
        }
      
        
        
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            System.out.println("Dosya içerik : " + reader.readLine());
//        } catch (FileNotFoundException fnfe) {
//            System.out.println(fnfe);
//        } catch (IOException io) {
//            System.out.println(io);
//        }
    }

}
