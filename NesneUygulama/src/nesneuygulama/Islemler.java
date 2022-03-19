package nesneuygulama;



public interface Islemler <T> {
    
    void ekle (T o);

    void guncelleme (int index , String ad);
    
    void silme (T o);
     
     
}
