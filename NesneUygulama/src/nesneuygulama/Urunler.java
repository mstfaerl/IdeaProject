package nesneuygulama;

import java.util.ArrayList;

public abstract class  Urunler {

    private String ad;
    private String marka;
    private int fiyat;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    
    public abstract void listele();

}

class Kontrol extends Urunler implements Islemler<Urunler>{
   
    ArrayList<Urunler> urunList = new ArrayList();
   
    //interface fonksiyon
    @Override
    public void ekle(Urunler urun) {
        this.urunList.add(urun);
    }

    @Override
    public void silme(Urunler urun) {
        urunList.remove(urun);
    }

    
    @Override
    public void guncelleme(int index, String ad) {
        urunList.get(index).setAd(ad);    
    }
    
    //abstract fonksiyon
    @Override
    public void listele() {
        for(int i = 0 ; i < urunList.size() ; i++){
            System.out.println(urunList.get(i).getAd()+" "+urunList.get(i).getMarka()+" "+urunList.get(i).getFiyat());
        }
    }
    
}
