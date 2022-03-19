package sample;

import javafx.beans.property.StringProperty;

public class SanatAtolyesi{

    private String adresi;
    private int kursUcreti;
    private Egitmen egitmeni;
    private Yonetim yonetimi;
    private Kursiyer kursiyeri;

    public String getAdresi() {
        return adresi;
    }

    public void setAdresi(String adresi) {
        this.adresi = adresi;
    }


    public int getKursUcreti() {
        return kursUcreti;
    }

    public void setKursUcreti(int kursUcreti) {
        this.kursUcreti = kursUcreti;
    }

    public Egitmen getEgitmeni() {
        if (this.egitmeni == null){
            this.egitmeni = new Egitmen();
        }
        return egitmeni;
    }

    public void setEgitmeni(Egitmen egitmeni) {
        this.egitmeni = egitmeni;
    }

    public Yonetim getYonetimi() {
        if(this.yonetimi == null){
            this.yonetimi = new Yonetim();
        }
        return yonetimi;
    }

    public void setYonetimi(Yonetim yonetimi) {
        this.yonetimi = yonetimi;
    }

    public Kursiyer getKursiyeri() {
        if(this.kursiyeri == null){
            this.kursiyeri = new Kursiyer();
        }
        return kursiyeri;
    }

    public void setKursiyeri(Kursiyer kursiyeri) {
        this.kursiyeri = kursiyeri;
    }

}
