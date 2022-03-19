package sample;

public class DesenliTabloAtolyesi extends SanatAtolyesi {

    private Malzemeler tabloMalzemeler;

    public DesenliTabloAtolyesi() {

    }

    public DesenliTabloAtolyesi(Malzemeler tabloMalzemeler) {
        this.tabloMalzemeler = tabloMalzemeler;
    }

    public Malzemeler getTabloMalzemeler() {
        if(this.tabloMalzemeler == null){
            this.tabloMalzemeler = new Malzemeler();
        }
        return tabloMalzemeler;
    }

    public void setTabloMalzemeler(Malzemeler tabloMalzemeler) {
        this.tabloMalzemeler = tabloMalzemeler;
    }

    @Override
    public String toString() {
        return tabloMalzemeler.getTuvalBoyut() + " " + tabloMalzemeler.getKagitBoyut()  + " " + tabloMalzemeler.getTabloCesit();
    }
}
