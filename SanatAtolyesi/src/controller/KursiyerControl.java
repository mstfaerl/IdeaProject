package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.*;
import sample.Kursiyer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class KursiyerControl implements Islemler{

    public TextField kursiyerAd;
    public TextField kursiyerSoyad;
    public TextField kursiyerTelNo;
    public TextArea kursiyerAdres;
    public TextField kursiyerDers;
    public TextField kursiyerSure;
    public TextField kursiyerBeceri;
    public TextField kursiyerNo;
    public TableView<Kursiyer> kursiyerList;
    public TableColumn<Kursiyer,String> colAdi;
    public TableColumn<Kursiyer,String> colSoyadi;
    public TableColumn<Kursiyer,String> colTelefon;
    public TableColumn<Kursiyer,String> colAdres;
    public TableColumn<Kursiyer,String> colDers;
    public TableColumn<Kursiyer,String> colSure;
    public TableColumn<Kursiyer,String> colBeceri;
    public TableColumn<Kursiyer,String> colNo;



    public Kursiyer kursiyer;
    public ArrayList <Kursiyer> krsyr = new ArrayList();
    ObservableList<Kursiyer> data = FXCollections.observableArrayList();

    @Override
    public void ekle() {

        krsyr = read();
        String ad = kursiyerAd.getText();
        String soyad = kursiyerSoyad.getText();
        String telno = kursiyerTelNo.getText();
        String adres = kursiyerAdres.getText();
        String ders = kursiyerDers.getText();
        int sure = Integer.parseInt(kursiyerSure.getText());
        String beceri = kursiyerBeceri.getText();
        String no = kursiyerNo.getText();
        kursiyer = new Kursiyer(ad,soyad,telno,adres,ders,sure,beceri,no);
        krsyr.add(kursiyer);
        olustur();

    }

    @Override
    public void olustur() {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("kursiyerler");
            doc.appendChild(rootElement);

            for(Kursiyer k : krsyr){

                Element staff = doc.createElement("kursiyer");
                rootElement.appendChild(staff);

                int id = krsyr.indexOf(k);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element kursiyerad = doc.createElement("kursiyerad");
                kursiyerad.appendChild(doc.createTextNode(k.getAdi()));
                staff.appendChild(kursiyerad);

                Element kursiyersoyad = doc.createElement("kursiyersoyad");
                kursiyersoyad.appendChild(doc.createTextNode(k.getSoyadi()));
                staff.appendChild(kursiyersoyad);

                Element kursiyertelno = doc.createElement("kursiyertelno");
                kursiyertelno.appendChild(doc.createTextNode(k.getTelNo()));
                staff.appendChild(kursiyertelno);

                Element kursiyeradres = doc.createElement("kursiyeradres");
                kursiyeradres.appendChild(doc.createTextNode(k.getAdres()));
                staff.appendChild(kursiyeradres);

                Element kursiyerdersi = doc.createElement("kursiyerdersi");
                kursiyerdersi.appendChild(doc.createTextNode(k.getDersi()));
                staff.appendChild(kursiyerdersi);

                Element kursiyersuresi= doc.createElement("kursiyersuresi");
                kursiyersuresi.appendChild(doc.createTextNode(String.valueOf(k.getSuresi())));
                staff.appendChild(kursiyersuresi);

                Element kursiyerbecerisi = doc.createElement("kursiyerbecerisi");
                kursiyerbecerisi.appendChild(doc.createTextNode(k.getBecerisi()));
                staff.appendChild(kursiyerbecerisi);

                Element kursiyerno = doc.createElement("kursiyerno");
                kursiyerno.appendChild(doc.createTextNode(k.getKursiyerNo()));
                staff.appendChild(kursiyerno);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\KursiyerFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void show() {

        kursiyerAd.setText(kursiyerList.getSelectionModel().getSelectedItem().getAdi());
        kursiyerSoyad.setText(kursiyerList.getSelectionModel().getSelectedItem().getSoyadi());
        kursiyerTelNo.setText(kursiyerList.getSelectionModel().getSelectedItem().getTelNo());
        kursiyerAdres.setText(kursiyerList.getSelectionModel().getSelectedItem().getAdres());
        kursiyerDers.setText(kursiyerList.getSelectionModel().getSelectedItem().getDersi());
        kursiyerSure.setText(String.valueOf(kursiyerList.getSelectionModel().getSelectedItem().getSuresi()));
        kursiyerBeceri.setText(kursiyerList.getSelectionModel().getSelectedItem().getBecerisi());
        kursiyerNo.setText(kursiyerList.getSelectionModel().getSelectedItem().getKursiyerNo());

    }

    @Override
    public void duzenle() {

        int i =  kursiyerList.getSelectionModel().getSelectedIndex();
        this.krsyr = new ArrayList<>();
        krsyr = read();
        kursiyer = new Kursiyer();
        kursiyer.setAdi(kursiyerAd.getText());
        kursiyer.setSoyadi(kursiyerSoyad.getText());
        kursiyer.setTelNo(kursiyerTelNo.getText());
        kursiyer.setAdres(kursiyerAdres.getText());
        kursiyer.setDersi(kursiyerDers.getText());
        kursiyer.setSuresi(Integer.parseInt(kursiyerSure.getText()));
        kursiyer.setBecerisi(kursiyerBeceri.getText());
        kursiyer.setKursiyerNo(kursiyerNo.getText());
        krsyr.set(i,kursiyer);
        olustur();

    }

    @Override
    public void listele() {
        krsyr = new ArrayList<>();
        krsyr = read();
        data = FXCollections.observableArrayList(krsyr);
        colAdi.setCellValueFactory(new PropertyValueFactory<>("Adi"));
        colSoyadi.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
        colTelefon.setCellValueFactory(new PropertyValueFactory<>("TelNo"));
        colAdres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        colDers.setCellValueFactory(new PropertyValueFactory<>("Dersi"));
        colSure.setCellValueFactory(new PropertyValueFactory<>("Suresi"));
        colBeceri.setCellValueFactory(new PropertyValueFactory<>("Becerisi"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("KursiyerNo"));
        kursiyerList.setItems(data);
    }

    @Override
    public void sil() {

        int i =  kursiyerList.getSelectionModel().getSelectedIndex();
        this.krsyr = new ArrayList<>();
        krsyr = read();
        krsyr.remove(i);
        olustur();

    }

    @Override
    public ArrayList<Kursiyer> read() {

        ArrayList<Kursiyer> list = new ArrayList<>();

        try {

            File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\KursiyerFiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("kursiyer");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode =  nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String kadi = eElement.getElementsByTagName("kursiyerad").item(0).getTextContent();
                    String ksoyadi = eElement.getElementsByTagName("kursiyersoyad").item(0).getTextContent();
                    String ktelno = eElement.getElementsByTagName("kursiyertelno").item(0).getTextContent();
                    String kadres = eElement.getElementsByTagName("kursiyeradres").item(0).getTextContent();
                    String kdersi = eElement.getElementsByTagName("kursiyerdersi").item(0).getTextContent();
                    int ksure = Integer.parseInt(eElement.getElementsByTagName("kursiyersuresi").item(0).getTextContent());
                    String kbecerisi = eElement.getElementsByTagName("kursiyerbecerisi").item(0).getTextContent();
                    String kno = eElement.getElementsByTagName("kursiyerno").item(0).getTextContent();

                    Kursiyer tmp = new Kursiyer(kadi,ksoyadi,ktelno,kadres,kdersi,ksure,kbecerisi,kno);

                    list.add(tmp);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
