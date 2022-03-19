package controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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

public class AhsapBoyamaControl implements Islemler {

    public TextArea ahsapAdres;
    public TextField ahsapKursUcret;
    public ComboBox<String> ahsapVernik;
    public ComboBox<String> ahsapEkMalzeme;
    public ComboBox<String> ahsapEgitmen;
    public ComboBox<String> ahsapSorumlu;
    public ComboBox<String> ahsapKursiyer;
    public TableView<AhsapBoyamaAtolyesi> ahsapBoyamaList;
    public TableColumn<AhsapBoyamaAtolyesi,String> colAdres;
    public TableColumn<AhsapBoyamaAtolyesi,Integer> colUcret;
    public TableColumn<AhsapBoyamaAtolyesi,String> colVernik;
    public TableColumn<AhsapBoyamaAtolyesi,String> colEkler;
    public TableColumn<AhsapBoyamaAtolyesi,String> colEgitmen;
    public TableColumn<AhsapBoyamaAtolyesi,String> colSorumlu;
    public TableColumn<AhsapBoyamaAtolyesi,String> colKursiyer;

    public MalzemelerControl mc = new MalzemelerControl();
    public Malzemeler malzemeler;
    public ArrayList<Malzemeler> malzemelerList = new ArrayList<>();

    public EgitmenControl ec = new EgitmenControl();
    public Egitmen egitmen;
    public ArrayList<Egitmen> egitmenList = new ArrayList<>();

    public KursiyerControl kc = new KursiyerControl();
    public Kursiyer kursiyer;
    public ArrayList<Kursiyer> kursiyerList = new ArrayList<>();

    public YonetimControl yc = new YonetimControl();
    public Yonetim yonetim;
    public ArrayList<Yonetim> yonetimList = new ArrayList<>();


    public ArrayList<AhsapBoyamaAtolyesi> ahsapList = new ArrayList<>();
    ObservableList<AhsapBoyamaAtolyesi> ahsapData = FXCollections.observableArrayList();
    public AhsapBoyamaAtolyesi ahsapBoyamaAtolyesi;


    //show fonksiyonları comboboxlara verileri çekmemize yarıyor fxml tarafında combobox mouse click alanında yazılıdır.
    public void showVernik(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> vernik = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            vernik.add(malzemelerList.get(i).getVernikTip());
            ahsapVernik.setItems(vernik);
        }
    }

    public void showEkler(){

        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> ekmalz = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            ekmalz.add(malzemelerList.get(i).getEkMalzemeler());
            ahsapEkMalzeme.setItems(ekmalz);
        }
    }

    public void showEgitmen(){
        egitmenList = new ArrayList<>();
        egitmenList = ec.read();
        ObservableList<String> ead = FXCollections.observableArrayList();
        for(int i = 0 ; i < egitmenList.size() ; i++){
            ead.add(egitmenList.get(i).getAdi());
            ahsapEgitmen.setItems(ead);
        }
    }

    public void showSorumlu(){

        yonetimList = new ArrayList<>();
        yonetimList = yc.read();
        ObservableList<String> sorumlu = FXCollections.observableArrayList();
        for(int i = 0 ; i < yonetimList.size() ; i++){
            sorumlu.add(yonetimList.get(i).getAdi());
            ahsapSorumlu.setItems(sorumlu);
        }
    }

    public void showKursiyer(){
        kursiyerList = new ArrayList<>();
        kursiyerList = kc.read();
        ObservableList<String> kad = FXCollections.observableArrayList();
        for(int i = 0 ; i < kursiyerList.size() ; i++){
            kad.add(kursiyerList.get(i).getAdi());
            ahsapKursiyer.setItems(kad);
        }
    }




    @Override
    public void ekle() {

        ahsapList = read();
        String adres = ahsapAdres.getText();
        int ucret = Integer.parseInt(ahsapKursUcret.getText());
        String vertip = ahsapVernik.getValue();
        String ekma = ahsapEkMalzeme.getValue();
        String egit = ahsapEgitmen.getValue();
        String sorum = ahsapSorumlu.getValue();
        String kursi = ahsapKursiyer.getValue();

        ahsapBoyamaAtolyesi = new AhsapBoyamaAtolyesi();
        ahsapBoyamaAtolyesi.setAdresi(adres);
        ahsapBoyamaAtolyesi.setKursUcreti(ucret);
        ahsapBoyamaAtolyesi.getAhsapMalzemeler().setVernikTip(vertip);
        ahsapBoyamaAtolyesi.getAhsapMalzemeler().setEkMalzemeler(ekma);
        ahsapBoyamaAtolyesi.getEgitmeni().setAdi(egit);
        ahsapBoyamaAtolyesi.getYonetimi().setAdi(sorum);
        ahsapBoyamaAtolyesi.getKursiyeri().setAdi(kursi);
        ahsapList.add(ahsapBoyamaAtolyesi);
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

            for(AhsapBoyamaAtolyesi a : ahsapList){

                Element staff = doc.createElement("ahsapatolyesi");
                rootElement.appendChild(staff);

                int id = ahsapList.indexOf(a);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element ahsapadres = doc.createElement("adres");
                ahsapadres.appendChild(doc.createTextNode(a.getAdresi()));
                staff.appendChild(ahsapadres);

                Element kursucret = doc.createElement("kursucret");
                kursucret.appendChild(doc.createTextNode(String.valueOf(a.getKursUcreti())));
                staff.appendChild(kursucret);

                Element verniktip = doc.createElement("verniktip");
                verniktip.appendChild(doc.createTextNode(a.getAhsapMalzemeler().getVernikTip()));
                staff.appendChild(verniktip);

                Element ekmalzeme = doc.createElement("ekmalzeme");
                ekmalzeme.appendChild(doc.createTextNode(a.getAhsapMalzemeler().getEkMalzemeler()));
                staff.appendChild(ekmalzeme);

                Element ahsapegitmen = doc.createElement("egitmen");
                ahsapegitmen.appendChild(doc.createTextNode(a.getEgitmeni().getAdi()));
                staff.appendChild(ahsapegitmen);

                Element ahsapsorumlu = doc.createElement("sorumlu");
                ahsapsorumlu.appendChild(doc.createTextNode(a.getYonetimi().getAdi()));
                staff.appendChild(ahsapsorumlu);

                Element ahsapkursiyer = doc.createElement("kursiyer");
                ahsapkursiyer.appendChild(doc.createTextNode(a.getKursiyeri().getAdi()));
                staff.appendChild(ahsapkursiyer);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\AhsapBoyamaFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<AhsapBoyamaAtolyesi> read() {

        ArrayList<AhsapBoyamaAtolyesi> list = new ArrayList<>();

        try {

            File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\AhsapBoyamaFiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("ahsapatolyesi");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode =  nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String adres = eElement.getElementsByTagName("adres").item(0).getTextContent();
                    int ucret = Integer.parseInt(eElement.getElementsByTagName("kursucret").item(0).getTextContent());
                    String vtip = eElement.getElementsByTagName("verniktip").item(0).getTextContent();
                    String ekm = eElement.getElementsByTagName("ekmalzeme").item(0).getTextContent();
                    String egit = eElement.getElementsByTagName("egitmen").item(0).getTextContent();
                    String sorum = eElement.getElementsByTagName("sorumlu").item(0).getTextContent();
                    String kursi = eElement.getElementsByTagName("kursiyer").item(0).getTextContent();

                    AhsapBoyamaAtolyesi tmp = new AhsapBoyamaAtolyesi();
                    tmp.setAdresi(adres);
                    tmp.setKursUcreti(ucret);
                    tmp.getAhsapMalzemeler().setVernikTip(vtip);
                    tmp.getAhsapMalzemeler().setEkMalzemeler(ekm);
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
    public void duzenle() {

        int i =  ahsapBoyamaList.getSelectionModel().getSelectedIndex();
        this.ahsapList = new ArrayList<>();
        ahsapList = read();
        ahsapBoyamaAtolyesi = new AhsapBoyamaAtolyesi();
        ahsapBoyamaAtolyesi.setAdresi(ahsapAdres.getText());
        ahsapBoyamaAtolyesi.setKursUcreti(Integer.parseInt(ahsapKursUcret.getText()));
        ahsapBoyamaAtolyesi.getAhsapMalzemeler().setVernikTip(ahsapVernik.getValue());
        ahsapBoyamaAtolyesi.getAhsapMalzemeler().setEkMalzemeler(ahsapEkMalzeme.getValue());
        ahsapBoyamaAtolyesi.getEgitmeni().setAdi(ahsapEgitmen.getValue());
        ahsapBoyamaAtolyesi.getYonetimi().setAdi(ahsapSorumlu.getValue());
        ahsapBoyamaAtolyesi.getKursiyeri().setAdi(ahsapKursiyer.getValue());
        ahsapList.set(i,ahsapBoyamaAtolyesi);
        olustur();

    }

    @Override
    public void listele() {

        ahsapList = new ArrayList<>();
        ahsapList = read();
        ahsapData = FXCollections.observableArrayList(ahsapList);
        colAdres.setCellValueFactory(new PropertyValueFactory<>("adresi"));
        colUcret.setCellValueFactory(new PropertyValueFactory<>("kursUcreti"));
        colVernik.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAhsapMalzemeler().getVernikTip()));
        colEkler.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAhsapMalzemeler().getEkMalzemeler()));
        colEgitmen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEgitmeni().getAdi()));
        colSorumlu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getYonetimi().getAdi()));
        colKursiyer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKursiyeri().getAdi()));
        ahsapBoyamaList.setItems(ahsapData);

    }

    @Override
    public void sil() {

        int i =  ahsapBoyamaList.getSelectionModel().getSelectedIndex();
        this.ahsapList = new ArrayList<>();
        ahsapList = read();
        ahsapList.remove(i);
        olustur();
    }


    @Override
    public void show() {

        ahsapAdres.setText(ahsapBoyamaList.getSelectionModel().getSelectedItem().getAdresi());
        ahsapKursUcret.setText(String.valueOf(ahsapBoyamaList.getSelectionModel().getSelectedItem().getKursUcreti()));
        ahsapVernik.setValue(ahsapBoyamaList.getSelectionModel().getSelectedItem().getAhsapMalzemeler().getVernikTip());
        ahsapEkMalzeme.setValue(ahsapBoyamaList.getSelectionModel().getSelectedItem().getAhsapMalzemeler().getEkMalzemeler());
        ahsapEgitmen.setValue(ahsapBoyamaList.getSelectionModel().getSelectedItem().getEgitmeni().getAdi());
        ahsapSorumlu.setValue(ahsapBoyamaList.getSelectionModel().getSelectedItem().getYonetimi().getAdi());
        ahsapKursiyer.setValue(ahsapBoyamaList.getSelectionModel().getSelectedItem().getKursiyeri().getAdi());

    }
}
