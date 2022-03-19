/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.calisma;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author m07er
 */
public class Stream {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try (OutputStream output = new FileOutputStream("D:\\Data\\data.txt")) {
            output.write("Hey dude what are you doing!".getBytes());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "Hata");
        }

        // new input stream created
        InputStream is = new FileInputStream("D:\\Data\\data.txt");
        int i;
        char c;
        String s = "";

        try {

            System.out.print("Characters printed : ");

            // reads till the end of the stream
            while ((i = is.read()) != -1) {

                // converts integer to character
                c = (char) i;
                s += (char) i;

                // prints character
                System.out.print(c);
            }
            System.out.println("");
            System.out.println("s : " + s);

        } catch (IOException e) {
            // if any I/O error occurs
            System.out.println(e.getMessage() + "Hata");
        }

    }

}
