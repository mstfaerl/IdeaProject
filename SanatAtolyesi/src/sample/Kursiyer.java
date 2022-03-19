package sample;

public class Kursiyer extends Kisiler{

    private String dersi;
    private int suresi;
    private String becerisi;
    private String kursiyerNo;
    SanatAtolyesi sanatAtolyesi;

    public Kursiyer() {
    }

    public Kursiyer(String dersi, int suresi, String becerisi, String kursiyerNo) {
        this.dersi = dersi;
        this.suresi = suresi;
        this.becerisi = becerisi;
        this.kursiyerNo = kursiyerNo;
    }

    public Kursiyer(String ad,String soyad, String telno,String adres, String dersi, int suresi, String becerisi, String kursiyerNo){
        this.setAdi(ad);
        this.setSoyadi(soyad);
        this.setAdres(adres);
        this.setTelNo(telno);
        this.dersi = dersi;
        this.suresi = suresi;
        this.becerisi = becerisi;
        this.kursiyerNo = kursiyerNo;
    }

    public String getDersi() {
        return dersi;
    }

    public void setDersi(String dersi) {
        this.dersi = dersi;
    }

    public int getSuresi() {
        return suresi;
    }

    public void setSuresi(int suresi) {
        this.suresi = suresi;
    }

    public String getBecerisi() {
        return becerisi;
    }

    public void setBecerisi(String becerisi) {
        this.becerisi = becerisi;
    }

    public String getKursiyerNo() {
        return kursiyerNo;
    }

    public void setKursiyerNo(String kursiyerNo) {
        this.kursiyerNo = kursiyerNo;
    }



    public int hesap(int ucret){
        return sanatAtolyesi.getKursUcreti();
    }

    public int hesap(int ucret,SanatAtolyesi sanatAtolyesi){
        int hesapla;
        hesapla = sanatAtolyesi.getKursUcreti()*ucret;
        return hesapla;
    }


}
