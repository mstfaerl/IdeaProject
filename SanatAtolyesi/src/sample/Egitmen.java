package sample;

public class Egitmen extends Personel{

    private String alani;
    private String calismalar;

    public Egitmen() {
    }

    public Egitmen(String alani, String calismalar) {
        this.alani = alani;
        this.calismalar = calismalar;
    }

    public Egitmen(String ad,String soyad,String telno,String adres,int mesai,int maas,String alan,String calisma){
        this.setAdi(ad);
        this.setSoyadi(soyad);
        this.setTelNo(telno);
        this.setAdres(adres);
        this.setMesaisi(mesai);
        this.setMaasi(maas);
        this.alani = alani;
        this.calismalar = calismalar;
    }

    public String getAlani() {
        return alani;
    }

    public void setAlani(String alani) {
        this.alani = alani;
    }

    public String getCalismalar() {
        return calismalar;
    }

    public void setCalismalar(String calismalar) {
        this.calismalar = calismalar;
    }

}
