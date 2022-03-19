package sample;

public class AhsapBoyamaAtolyesi extends SanatAtolyesi{

    private Malzemeler ahsapMalzemeler;

    public AhsapBoyamaAtolyesi() {
    }

    public AhsapBoyamaAtolyesi(Malzemeler ahsapMalzemeler) {
        this.ahsapMalzemeler = ahsapMalzemeler;
    }

    public AhsapBoyamaAtolyesi(String adres,int ucret,String vertip,String ekmal,String egitmen,String sorumlu,String kursiyer) {
        this.setAdresi(adres);
        this.setKursUcreti(ucret);
        this.getAhsapMalzemeler().setVernikTip(vertip);
        this.getAhsapMalzemeler().setEkMalzemeler(ekmal);
        this.getEgitmeni().setAdi(egitmen);
        this.getYonetimi().setAdi(sorumlu);
        this.getKursiyeri().setAdi(kursiyer);
    }

    public Malzemeler getAhsapMalzemeler() {
        if(this.ahsapMalzemeler == null){
            this.ahsapMalzemeler = new Malzemeler();
        }
        return ahsapMalzemeler;
    }

    public void setAhsapMalzemeler(Malzemeler ahsapMalzemeler) {
        this.ahsapMalzemeler = ahsapMalzemeler;
    }

    @Override
    public String toString() {
        return ahsapMalzemeler.getVernikTip() + " " + ahsapMalzemeler.getEkMalzemeler();
    }
}
