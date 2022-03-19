package sample;

public class Malzemeler {

    private String vernikTip;
    private String ekMalzemeler;
    private String tuvalBoyut;
    private String kagitBoyut;
    private String tabloCesit;
    private String tekneEbati;
    private String fircaCesidi;
    private String tarakCesidi;

    public Malzemeler() {
    }

    public Malzemeler(String vernikTip, String ekMalzemeler, String tuvalBoyut, String kagitBoyut, String tabloCesit, String tekneEbati, String fircaCesidi, String tarakCesidi) {
        this.vernikTip = vernikTip;
        this.ekMalzemeler = ekMalzemeler;
        this.tuvalBoyut = tuvalBoyut;
        this.kagitBoyut = kagitBoyut;
        this.tabloCesit = tabloCesit;
        this.tekneEbati = tekneEbati;
        this.fircaCesidi = fircaCesidi;
        this.tarakCesidi = tarakCesidi;
    }

    public String getVernikTip() {
        return vernikTip;
    }

    public void setVernikTip(String vernikTip) {
        this.vernikTip = vernikTip;
    }

    public String getEkMalzemeler() {
        return ekMalzemeler;
    }

    public void setEkMalzemeler(String ekMalzemeler) {
        this.ekMalzemeler = ekMalzemeler;
    }

    public String getTuvalBoyut() {
        return tuvalBoyut;
    }

    public void setTuvalBoyut(String tuvalBoyut) {
        this.tuvalBoyut = tuvalBoyut;
    }

    public String getKagitBoyut() {
        return kagitBoyut;
    }

    public void setKagitBoyut(String kagitBoyut) {
        this.kagitBoyut = kagitBoyut;
    }

    public String getTabloCesit() {
        return tabloCesit;
    }

    public void setTabloCesit(String tabloCesit) {
        this.tabloCesit = tabloCesit;
    }

    public String getTekneEbati() {
        return tekneEbati;
    }

    public void setTekneEbati(String tekneEbati) {
        this.tekneEbati = tekneEbati;
    }

    public String getFircaCesidi() {
        return fircaCesidi;
    }

    public void setFircaCesidi(String fircaCesidi) {
        this.fircaCesidi = fircaCesidi;
    }

    public String getTarakCesidi() {
        return tarakCesidi;
    }

    public void setTarakCesidi(String tarakCesidi) {
        this.tarakCesidi = tarakCesidi;
    }
}
