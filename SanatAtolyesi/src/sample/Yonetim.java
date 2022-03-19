package sample;

public class Yonetim extends Personel{

    private String kademesi;


    public Yonetim() {
    }

    public Yonetim(String kademesi) {
        this.kademesi = kademesi;
    }

    public String getKademesi() {
        return kademesi;
    }

    public void setKademesi(String kademesi) {
        this.kademesi = kademesi;
    }

}
