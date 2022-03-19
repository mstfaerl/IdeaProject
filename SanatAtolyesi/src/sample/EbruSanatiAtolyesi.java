package sample;

public class EbruSanatiAtolyesi extends SanatAtolyesi {

    private Malzemeler ebruMalzemeler;

    public EbruSanatiAtolyesi() {
    }

    public EbruSanatiAtolyesi(Malzemeler ebruMalzemeler) {
        this.ebruMalzemeler = ebruMalzemeler;
    }

    public Malzemeler getEbruMalzemeler() {
        if(this.ebruMalzemeler == null){
            this.ebruMalzemeler = new Malzemeler();
        }
        return ebruMalzemeler;
    }

    public void setEbruMalzemeler(Malzemeler ebruMalzemeler) {
        this.ebruMalzemeler = ebruMalzemeler;
    }

    @Override
    public String toString() {
        return ebruMalzemeler.getTekneEbati() + " " + ebruMalzemeler.getFircaCesidi() + " " + ebruMalzemeler.getTarakCesidi();
    }
}
