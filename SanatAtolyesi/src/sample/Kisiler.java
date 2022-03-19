package sample;

public class Kisiler {

    private String adi;
    private String soyadi;
    private String telNo;
    private String adres;



    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Kisiler{" +
                "adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", telNo='" + telNo + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
