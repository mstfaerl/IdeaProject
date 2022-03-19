package nesneuygulama;



public class NesneUygulama {

    public static void main(String[] args) {
      
       Kontrol kontrol = new Kontrol();
       Kontrol urun = new Kontrol();
       
       
       urun.setAd("asdasd");
       urun.setMarka("sadasd");
       urun.setFiyat(11);
       
       
       kontrol.ekle(urun);
       
       urun = new Kontrol();
       

       urun.setAd("asd");
       urun.setMarka("sadaasdsd");
       urun.setFiyat(123);
       
       
       kontrol.ekle(urun);
       kontrol.listele();
 
       kontrol.guncelleme(0, "sdfdsgs");
       
       kontrol.listele();
       

       
    }
    
}
