/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.files;

import com.java.entity.Kullanici;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author m07er
 */
public class KullaniciFiles implements Process<Kullanici> {

    String path = "D:\\Data\\Kullanıcı.txt";
    private ArrayList<Kullanici> kList;


    @Override
    public void addFile(Kullanici o) {
        kList.add(o);
        try (BufferedWriter reader = new BufferedWriter(new FileWriter(path))) {
            for (Kullanici kullanici : kList) {
                reader.write(kullanici.getKullaniciID() + " " + kullanici.getKullaniciAdi() + " " + kullanici.getKullaniciSifre() + "\n");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Kullanici o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Kullanici o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
