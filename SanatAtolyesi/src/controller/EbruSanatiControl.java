package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.*;
import sample.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class EbruSanatiControl implements Islemler {

    public TextArea ebruAdres;
    public TextField ebruKursUcret;
    public ComboBox<String> ebruTekne;
    public ComboBox<String> ebruFirca;
    public ComboBox<String> ebruTarak;
    public ComboBox<String> ebruEgitmen;
    public ComboBox<String> ebruSorumlu;
    public ComboBox<String> ebruKursiyer;
    public TableView<EbruSanatiAtolyesi> ebruSanatiList;
    public TableColumn<EbruSanatiAtolyesi,String> colAdres;
    public TableColumn<EbruSanatiAtolyesi,String> colUcret;
    public TableColumn<EbruSanatiAtolyesi,String> colTekne;
    public TableColumn<EbruSanatiAtolyesi,String> colFirca;
    public TableColumn<EbruSanatiAtolyesi,String> colTarak;
    public TableColumn<EbruSanatiAtolyesi,String> colEgitmen;
    public TableColumn<EbruSanatiAtolyesi,String> colSorumlu;
    public TableColumn<EbruSanatiAtolyesi,String> colKursiyer;

    public MalzemelerControl mc = new MalzemelerControl();
    public Malzemeler malzemeler;
    ObservableList<Malzemeler> malzemeData = FXCollections.observableArrayList();
    public ArrayList<Malzemeler> malzemelerList = new ArrayList<>();

    public EgitmenControl ec = new EgitmenControl();
    public Egitmen egitmen;
    ObservableList<Egitmen> egitmenData = FXCollections.observableArrayList();
    public ArrayList<Egitmen> egitmenList = new ArrayList<>();

    public KursiyerControl kc = new KursiyerControl();
    public Kursiyer kursiyer;
    ObservableList<Kursiyer> kursiyerData = FXCollections.observableArrayList();
    public ArrayList<Kursiyer> kursiyerList = new ArrayList<>();

    public YonetimControl yc = new YonetimControl();
    public Yonetim yonetim;
    ObservableList<Yonetim> yonetimData = FXCollections.observableArrayList();
    public ArrayList<Yonetim> yonetimList = new ArrayList<>();

    public ArrayList<EbruSanatiAtolyesi> ebruList = new ArrayList<>();
    ObservableList<EbruSanatiAtolyesi> ebruData = FXCollections.observableArrayList();
    public EbruSanatiAtolyesi ebruSanatiAtolyesi;

    //show fonksiyonları comboboxlara verileri çekmemize yarıyor fxml tarafında combobox mouse click alanında yazılıdır.

    public void showTekne(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> tekne = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            tekne.add(malzemelerList.get(i).getTekneEbati());
            ebruTekne.setItems(tekne);
        }
    }

    public void showFirca(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> firca = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            firca.add(malzemelerList.get(i).getFircaCesidi());
            ebruFirca.setItems(firca);
        }
    }

    public void showTarak(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> tarak = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            tarak.add(malzemelerList.get(i).getTarakCesidi());
            ebruTarak.setItems(tarak);
        }
    }

    public void showEgitmen(){
        egitmenList = new ArrayList<>();
        egitmenList = ec.read();
        ObservableList<String> egit = FXCollections.observableArrayList();
        for(int i = 0 ; i < egitmenList.size() ; i++){
            egit.add(egitmenList.get(i).getAdi());
            ebruEgitmen.setItems(egit);
        }
    }

    public void showSorumlu(){
        yonetimList = new ArrayList<>();
        yonetimList = yc.read();
        ObservableList<String> sorum = FXCollections.observableArrayList();
        for(int i = 0 ; i < yonetimList.size() ; i++){
            sorum.add(yonetimList.get(i).getAdi());
            ebruSorumlu.setItems(sorum);
        }
    }

    public void showKursiyer(){
        kursiyerList = new ArrayList<>();
        kursiyerList = kc.read();
        ObservableList<String> kurs = FXCollections.observableArrayList();
        for(int i = 0 ; i < kursiyerList.size() ; i++){
            kurs.add(kursiyerList.get(i).getAdi());
            ebruKursiyer.setItems(kurs);
        }
    }



    @Override
    public void ekle() {

        ebruList = read();
        String adres = ebruAdres.getText();
        int ucret = Integer.parseInt(ebruKursUcret.getText());
        String tekn = ebruTekne.getValue();
        String fir = ebruFirca.getValue();
        String tara = ebruTarak.getValue();
        String egit = ebruEgitmen.getValue();
        String sorum = ebruSorumlu.getValue();
        String kursi = ebruKursiyer.getValue();

        ebruSanatiAtolyesi = new EbruSanatiAtolyesi();
        ebruSanatiAtolyesi.setAdresi(adres);
        ebruSanatiAtolyesi.setKursUcreti(ucret);
        ebruSanatiAtolyesi.getEbruMalzemeler().setTekneEbati(tekn);
        ebruSanatiAtolyesi.getEbruMalzemeler().setFircaCesidi(fir);
        ebruSanatiAtolyesi.getEbruMalzemeler().setTarakCesidi(tara);
        ebruSanatiAtolyesi.getEgitmeni().setAdi(egit);
        ebruSanatiAtolyesi.getYonetimi().setAdi(sorum);
        ebruSanatiAtolyesi.getKursiyeri().setAdi(kursi);
        ebruList.add(ebruSanatiAtolyesi);
        olustur();

    }

    @Override
    public void olustur() {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("sanatatolyesi");
            doc.appendChild(rootElement);

            for(EbruSanatiAtolyesi e : ebruList){

                Element staff = doc.createElement("ebruatolyesi");
                rootElement.appendChild(staff);

                int id = ebruList.indexOf(e);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element ebruadres = doc.createElement("adres");
                ebruadres.appendChild(doc.createTextNode(e.getAdresi()));
                staff.appendChild(ebruadres);

                Element kursucret = doc.createElement("kursucret");
                kursucret.appendChild(doc.createTextNode(String.valueOf(e.getKursUcreti())));
                staff.appendChild(kursucret);

                Element tekneebati = doc.createElement("tekneebati");
                tekneebati.appendChild(doc.createTextNode(e.getEbruMalzemeler().getTekneEbati()));
                staff.appendChild(tekneebati);

                Element fircacesidi = doc.createElement("fircacesidi");
                fircacesidi.appendChild(doc.createTextNode(e.getEbruMalzemeler().getFircaCesidi()));
                staff.appendChild(fircacesidi);

                Element tarakcesidi = doc.createElement("tarakcesidi");
                tarakcesidi.appendChild(doc.createTextNode(e.getEbruMalzemeler().getTarakCesidi()));
                staff.appendChild(tarakcesidi);

                Element ebruegitmen = doc.createElement("egitmen");
                ebruegitmen.appendChild(doc.createTextNode(e.getEgitmeni().getAdi()));
                staff.appendChild(ebruegitmen);

                Element ebrusorumlu = doc.createElement("sorumlu");
                ebrusorumlu.appendChild(doc.createTextNode(e.getYonetimi().getAdi()));
                staff.appendChild(ebrusorumlu);

                Element ebrukursiyer = doc.createElement("kursiyer");
                ebrukursiyer.appendChild(doc.createTextNode(e.getKursiyeri().getAdi()));
                staff.appendChild(ebrukursiyer);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\EbruSanatiFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void duzenle() {

        int i =  ebruSanatiList.getSelectionModel().getSelectedIndex();
        this.ebruList = new ArrayList<>();
        ebruList = read();
        ebruSanatiAtolyesi = new EbruSanatiAtolyesi();
        ebruSanatiAtolyesi.setAdresi(ebruAdres.getText());
        ebruSanatiAtolyesi.setKursUcreti(Integer.parseInt(ebruKursUcret.getText()));
        ebruSanatiAtolyesi.getEbruMalzemeler().setTekneEbati(ebruTekne.getValue());
        ebruSanatiAtolyesi.getEbruMalzemeler().setFircaCesidi(ebruFirca.getValue());
        ebruSanatiAtolyesi.getEbruMalzemeler().setTarakCesidi(ebruTarak.getValue());
        ebruSanatiAtolyesi.getEgitmeni().setAdi(ebruEgitmen.getValue());
        ebruSanatiAtolyesi.getYonetimi().setAdi(ebruSorumlu.getValue());
        ebruSanatiAtolyesi.getKursiyeri().setAdi(ebruKursiyer.getValue());
        ebruList.set(i,ebruSanatiAtolyesi);
        olustur();

    }

    @Override
    public void listele() {

        ebruList = new ArrayList<>();
        ebruList = read();
        ebruData = FXCollections.observableArrayList(ebruList);
        colAdres.setCellValueFactory(new PropertyValueFactory<>("adresi"));
        colUcret.setCellValueFactory(new PropertyValueFactory<>("kursUcreti"));
        colTekne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEbruMalzemeler().getTekneEbati()));
        colFirca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEbruMalzemeler().getFircaCesidi()));
        colTarak.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEbruMalzemeler().getTarakCesidi()));
        colEgitmen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEgitmeni().getAdi()));
        colSorumlu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getYonetimi().getAdi()));
        colKursiyer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKursiyeri().getAdi()));
        ebruSanatiList.setItems(ebruData);

    }

    @Override
    public void sil() {

        int i =  ebruSanatiList.getSelectionModel().getSelectedIndex();
        this.ebruList = new ArrayList<>();
        ebruList = read();
        ebruList.remove(i);
        olustur();

    }

    @Override
    public ArrayList<EbruSanatiAtolyesi> read() {

        ArrayList<EbruSanatiAtolyesi> list = new ArrayList<>();

        try {

            File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\EbruSanatiFiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("ebruatolyesi");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode =  nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String adres = eElement.getElementsByTagName("adres").item(0).getTextContent();
                    int ucret = Integer.parseInt(eElement.getElementsByTagName("kursucret").item(0).getTextContent());
                    String tebat = eElement.getElementsByTagName("tekneebati").item(0).getTextContent();
                    String fces = eElement.getElementsByTagName("fircacesidi").item(0).getTextContent();
                    String tces = eElement.getElementsByTagName("tarakcesidi").item(0).getTextContent();
                    String egit = eElement.getElementsByTagName("egitmen").item(0).getTextContent();
                    String sorum = eElement.getElementsByTagName("sorumlu").item(0).getTextContent();
                    String kursi = eElement.getElementsByTagName("kursiyer").item(0).getTextContent();

                    EbruSanatiAtolyesi tmp = new EbruSanatiAtolyesi();
                    tmp.setAdresi(adres);
                    tmp.setKursUcreti(ucret);
                    tmp.getEbruMalzemeler().setTekneEbati(tebat);
                    tmp.getEbruMalzemeler().setFircaCesidi(fces);
                    tmp.getEbruMalzemeler().setTarakCesidi(tces);
                    tmp.getEgitmeni().setAdi(egit);
                    tmp.getYonetimi().setAdi(sorum);
                    tmp.getKursiyeri().setAdi(kursi);
                    list.add(tmp);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void show() {

        ebruAdres.setText(ebruSanatiList.getSelectionModel().getSelectedItem().getAdresi());
        ebruKursUcret.setText(String.valueOf(ebruSanatiList.getSelectionModel().getSelectedItem().getKursUcreti()));
        ebruTekne.setValue(ebruSanatiList.getSelectionModel().getSelectedItem().getEbruMalzemeler().getTekneEbati());
        ebruFirca.setValue(ebruSanatiList.getSelectionModel().getSelectedItem().getEbruMalzemeler().getFircaCesidi());
        ebruTarak.setValue(ebruSanatiList.getSelectionModel().getSelectedItem().getEbruMalzemeler().getTarakCesidi());
        ebruEgitmen.setValue(ebruSanatiList.getSelectionModel().getSelectedItem().getEgitmeni().getAdi());
        ebruSorumlu.setValue(ebruSanatiList.getSelectionModel().getSelectedItem().getYonetimi().getAdi());
        ebruKursiyer.setValue(ebruSanatiList.getSelectionModel().getSelectedItem().getKursiyeri().getAdi());

    }
}
