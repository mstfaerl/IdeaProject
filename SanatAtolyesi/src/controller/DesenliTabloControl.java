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

public class DesenliTabloControl implements Islemler {

    public TextArea desenAdres;
    public TextField desenKursUcret;
    public ComboBox<String> desenTuval;
    public ComboBox<String> desenKagit;
    public ComboBox<String> desenTablo;
    public ComboBox<String> desenEgitmen;
    public ComboBox<String> desenSorumlu;
    public ComboBox<String> desenKursiyer;
    public TableView<DesenliTabloAtolyesi> desenliTabloList;
    public TableColumn<DesenliTabloAtolyesi,String> colAdres;
    public TableColumn<DesenliTabloAtolyesi,String> colUcret;
    public TableColumn<DesenliTabloAtolyesi,String> colTuval;
    public TableColumn<DesenliTabloAtolyesi,String> colKagit;
    public TableColumn<DesenliTabloAtolyesi,String> colTablo;
    public TableColumn<DesenliTabloAtolyesi,String> colEgitmen;
    public TableColumn<DesenliTabloAtolyesi,String> colSorumlu;
    public TableColumn<DesenliTabloAtolyesi,String> colKursiyer;

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

    public ArrayList<DesenliTabloAtolyesi> desenList = new ArrayList<>();
    ObservableList<DesenliTabloAtolyesi> desenData = FXCollections.observableArrayList();
    public DesenliTabloAtolyesi desenliTabloAtolyesi;


    //show fonksiyonları comboboxlara verileri çekmemize yarıyor fxml tarafında combobox mouse click alanında yazılıdır.

    public void showTuval(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> tuval = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            tuval.add(malzemelerList.get(i).getTuvalBoyut());
            desenTuval.setItems(tuval);
        }
    }

    public void showKagit(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> kagit = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            kagit.add(malzemelerList.get(i).getKagitBoyut());
            desenKagit.setItems(kagit);
        }
    }

    public void showTablo(){
        malzemelerList = new ArrayList<>();
        malzemelerList = mc.read();
        ObservableList<String> tablo = FXCollections.observableArrayList();
        for(int i = 0 ; i < malzemelerList.size() ; i++){
            tablo.add((malzemelerList.get(i).getTabloCesit()));
            desenTablo.setItems(tablo);
        }
    }

    public void showEgitmen(){
        egitmenList = new ArrayList<>();
        egitmenList = ec.read();
        ObservableList<String> eg = FXCollections.observableArrayList();
        for(int i = 0 ; i < egitmenList.size() ; i++){
            eg.add(egitmenList.get(i).getAdi());
            desenEgitmen.setItems(eg);
        }
    }

    public void showSorumlu(){
        yonetimList = new ArrayList<>();
        yonetimList = yc.read();
        ObservableList<String> yon = FXCollections.observableArrayList();
        for(int i = 0 ; i < yonetimList.size() ; i++){
            yon.add(yonetimList.get(i).getAdi());
            desenSorumlu.setItems(yon);
        }
    }

    public void showKursiyer(){
        kursiyerList = new ArrayList<>();
        kursiyerList = kc.read();
        ObservableList<String> kur = FXCollections.observableArrayList();
        for(int i = 0 ; i < kursiyerList.size() ; i++){
            kur.add(kursiyerList.get(i).getAdi());
            desenKursiyer.setItems(kur);
        }
    }

    @Override
    public void ekle() {

        desenList = read();
        String adres = desenAdres.getText();
        int ucret = Integer.parseInt(desenKursUcret.getText());
        String tuv = desenTuval.getValue();
        String kag = desenKagit.getValue();
        String tab = desenTablo.getValue();
        String egit = desenEgitmen.getValue();
        String sorum = desenSorumlu.getValue();
        String kur = desenKursiyer.getValue();

        desenliTabloAtolyesi = new DesenliTabloAtolyesi();

        desenliTabloAtolyesi.setAdresi(adres);
        desenliTabloAtolyesi.setKursUcreti(ucret);
        desenliTabloAtolyesi.getTabloMalzemeler().setTuvalBoyut(tuv);
        desenliTabloAtolyesi.getTabloMalzemeler().setKagitBoyut(kag);
        desenliTabloAtolyesi.getTabloMalzemeler().setTabloCesit(tab);
        desenliTabloAtolyesi.getEgitmeni().setAdi(egit);
        desenliTabloAtolyesi.getYonetimi().setAdi(sorum);
        desenliTabloAtolyesi.getKursiyeri().setAdi(kur);
        desenList.add(desenliTabloAtolyesi);
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

            for(DesenliTabloAtolyesi d : desenList){

                Element staff = doc.createElement("desenatolyesi");
                rootElement.appendChild(staff);

                int id = desenList.indexOf(d);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element desenadres = doc.createElement("adres");
                desenadres.appendChild(doc.createTextNode(d.getAdresi()));
                staff.appendChild(desenadres);

                Element kursucret = doc.createElement("kursucret");
                kursucret.appendChild(doc.createTextNode(String.valueOf(d.getKursUcreti())));
                staff.appendChild(kursucret);

                Element tuvalboyut = doc.createElement("tuvalboyutu");
                tuvalboyut.appendChild(doc.createTextNode(d.getTabloMalzemeler().getTuvalBoyut()));
                staff.appendChild(tuvalboyut);

                Element kagitboyut = doc.createElement("kagitboyut");
                kagitboyut.appendChild(doc.createTextNode(d.getTabloMalzemeler().getKagitBoyut()));
                staff.appendChild(kagitboyut);

                Element tablocesidi = doc.createElement("tablocesidi");
                tablocesidi.appendChild(doc.createTextNode(d.getTabloMalzemeler().getTabloCesit()));
                staff.appendChild(tablocesidi);

                Element desenegitmen = doc.createElement("egitmen");
                desenegitmen.appendChild(doc.createTextNode(d.getEgitmeni().getAdi()));
                staff.appendChild(desenegitmen);

                Element desensorumlu = doc.createElement("sorumlu");
                desensorumlu.appendChild(doc.createTextNode(d.getYonetimi().getAdi()));
                staff.appendChild(desensorumlu);

                Element desenkursiyer = doc.createElement("kursiyer");
                desenkursiyer.appendChild(doc.createTextNode(d.getKursiyeri().getAdi()));
                staff.appendChild(desenkursiyer);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\DesenliTabloFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void duzenle() {

        int i =  desenliTabloList.getSelectionModel().getSelectedIndex();
        this.desenList = new ArrayList<>();
        desenList = read();
        desenliTabloAtolyesi = new DesenliTabloAtolyesi();
        desenliTabloAtolyesi.setAdresi(desenAdres.getText());
        desenliTabloAtolyesi.setKursUcreti(Integer.parseInt(desenKursUcret.getText()));
        desenliTabloAtolyesi.getTabloMalzemeler().setTuvalBoyut(desenTuval.getValue());
        desenliTabloAtolyesi.getTabloMalzemeler().setKagitBoyut(desenKagit.getValue());
        desenliTabloAtolyesi.getTabloMalzemeler().setTabloCesit(desenTablo.getValue());
        desenliTabloAtolyesi.getEgitmeni().setAdi(desenEgitmen.getValue());
        desenliTabloAtolyesi.getYonetimi().setAdi(desenSorumlu.getValue());
        desenliTabloAtolyesi.getKursiyeri().setAdi(desenKursiyer.getValue());
        desenList.set(i,desenliTabloAtolyesi);
        olustur();

    }

    @Override
    public void listele() {

        desenList = new ArrayList<>();
        desenList = read();
        desenData = FXCollections.observableArrayList(desenList);
        colAdres.setCellValueFactory(new PropertyValueFactory<>("adresi"));
        colUcret.setCellValueFactory(new PropertyValueFactory<>("kursUcreti"));
        colTuval.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTabloMalzemeler().getTuvalBoyut()));
        colKagit.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTabloMalzemeler().getKagitBoyut()));
        colTablo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTabloMalzemeler().getTabloCesit()));
        colEgitmen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEgitmeni().getAdi()));
        colSorumlu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getYonetimi().getAdi()));
        colKursiyer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKursiyeri().getAdi()));
        desenliTabloList.setItems(desenData);

    }

    @Override
    public void sil() {

        int i =  desenliTabloList.getSelectionModel().getSelectedIndex();
        this.desenList = new ArrayList<>();
        desenList = read();
        desenList.remove(i);
        olustur();

    }


    @Override
    public ArrayList<DesenliTabloAtolyesi> read() {

        ArrayList<DesenliTabloAtolyesi> list = new ArrayList<>();

        try {

            File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\DesenliTabloFiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("desenatolyesi");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode =  nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String adres = eElement.getElementsByTagName("adres").item(0).getTextContent();
                    int ucret = Integer.parseInt(eElement.getElementsByTagName("kursucret").item(0).getTextContent());
                    String tboy = eElement.getElementsByTagName("tuvalboyutu").item(0).getTextContent();
                    String kboy = eElement.getElementsByTagName("kagitboyut").item(0).getTextContent();
                    String tces = eElement.getElementsByTagName("tablocesidi").item(0).getTextContent();
                    String egit = eElement.getElementsByTagName("egitmen").item(0).getTextContent();
                    String sorum = eElement.getElementsByTagName("sorumlu").item(0).getTextContent();
                    String kursi = eElement.getElementsByTagName("kursiyer").item(0).getTextContent();

                    DesenliTabloAtolyesi tmp = new DesenliTabloAtolyesi();
                    tmp.setAdresi(adres);
                    tmp.setKursUcreti(ucret);
                    tmp.getTabloMalzemeler().setTuvalBoyut(tboy);
                    tmp.getTabloMalzemeler().setKagitBoyut(kboy);
                    tmp.getTabloMalzemeler().setTabloCesit(tces);
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

        desenAdres.setText(desenliTabloList.getSelectionModel().getSelectedItem().getAdresi());
        desenKursUcret.setText(String.valueOf(desenliTabloList.getSelectionModel().getSelectedItem().getKursUcreti()));
        desenTuval.setValue(desenliTabloList.getSelectionModel().getSelectedItem().getTabloMalzemeler().getTuvalBoyut());
        desenKagit.setValue(desenliTabloList.getSelectionModel().getSelectedItem().getTabloMalzemeler().getKagitBoyut());
        desenTablo.setValue(desenliTabloList.getSelectionModel().getSelectedItem().getTabloMalzemeler().getTabloCesit());
        desenEgitmen.setValue(desenliTabloList.getSelectionModel().getSelectedItem().getEgitmeni().getAdi());
        desenSorumlu.setValue(desenliTabloList.getSelectionModel().getSelectedItem().getYonetimi().getAdi());
        desenKursiyer.setValue(desenliTabloList.getSelectionModel().getSelectedItem().getKursiyeri().getAdi());

    }
}
