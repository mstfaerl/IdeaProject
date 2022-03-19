package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import sample.Egitmen;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class EgitmenControl implements Islemler {

    public TextField egitmenAd;
    public TextField egitmenSoyad;
    public TextField egitmenTelNo;
    public TextArea egitmenAdres;
    public TextField egitmenMesai;
    public TextField egitmenMaas;
    public TextField egitmenAlan;
    public TextField egitmenCalismalar;
    public TableView<Egitmen> egitmenList;
    public TableColumn<Egitmen,String> colAdi;
    public TableColumn<Egitmen,String> colSoyadi;
    public TableColumn<Egitmen,String> colTelefonNo;
    public TableColumn<Egitmen,String> colAdres;
    public TableColumn<Egitmen,String> colMesai;
    public TableColumn<Egitmen,String> colMaas;
    public TableColumn<Egitmen,String> colAlani;
    public TableColumn<Egitmen,String> colCalismalar;

    ObservableList<Egitmen> data = FXCollections.observableArrayList();
    public Egitmen egitmen;
    public ArrayList <Egitmen> egtmn = new ArrayList<>();


    @Override
    public void ekle() {

        egtmn = read();
        String ad = egitmenAd.getText();
        String soyad = egitmenSoyad.getText();
        String telno = egitmenTelNo.getText();
        String adres = egitmenAdres.getText();
        int mesai = (Integer.parseInt(egitmenMesai.getText()));
        int maas = (Integer.parseInt(egitmenMaas.getText()));
        String alan = egitmenAlan.getText();
        String calisma = egitmenCalismalar.getText();
        egitmen = new Egitmen();
        egitmen.setAdi(ad);
        egitmen.setSoyadi(soyad);
        egitmen.setTelNo(telno);
        egitmen.setAdres(adres);
        egitmen.setMesaisi(mesai);
        egitmen.setMaasi(maas);
        egitmen.setAlani(alan);
        egitmen.setCalismalar(calisma);
        //egitmen = new Egitmen(ad,soyad,telno,adres,mesai,maas,alan,calisma);
        egtmn.add(egitmen);
        olustur();

    }

    @Override
    public void olustur() {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("egitmenler");
            doc.appendChild(rootElement);

            for(Egitmen e : egtmn){

                Element staff = doc.createElement("egitmen");
                rootElement.appendChild(staff);

                int id = egtmn.indexOf(e);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element egitmenad = doc.createElement("egitmenad");
                egitmenad.appendChild(doc.createTextNode(e.getAdi()));
                staff.appendChild(egitmenad);

                Element egitmensoyad= doc.createElement("egitmensoyad");
                egitmensoyad.appendChild(doc.createTextNode(e.getSoyadi()));
                staff.appendChild(egitmensoyad);

                Element egitmentelno = doc.createElement("egitmentelno");
                egitmentelno.appendChild(doc.createTextNode(e.getTelNo()));
                staff.appendChild(egitmentelno);

                Element egitmenadres = doc.createElement("egitmenadres");
                egitmenadres.appendChild(doc.createTextNode(e.getAdres()));
                staff.appendChild(egitmenadres);

                Element egitmenmesai = doc.createElement("egitmenmesai");
                egitmenmesai.appendChild(doc.createTextNode(String.valueOf(e.getMesaisi())));
                staff.appendChild(egitmenmesai);

                Element egitmenmaasi= doc.createElement("egitmenmaasi");
                egitmenmaasi.appendChild(doc.createTextNode(String.valueOf(e.getMaasi())));
                staff.appendChild(egitmenmaasi);

                Element egitmenalani = doc.createElement("egitmenalani");
                egitmenalani.appendChild(doc.createTextNode(e.getAlani()));
                staff.appendChild(egitmenalani);

                Element egitmencalismalar = doc.createElement("egitmencalisma");
                egitmencalismalar.appendChild(doc.createTextNode(e.getCalismalar()));
                staff.appendChild(egitmencalismalar);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\EgitmenFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void duzenle() {

        int i =  egitmenList.getSelectionModel().getSelectedIndex();
        this.egtmn = new ArrayList<>();
        egtmn = read();
        egitmen = new Egitmen();
        egitmen.setAdi(egitmenAd.getText());
        egitmen.setSoyadi(egitmenSoyad.getText());
        egitmen.setTelNo(egitmenTelNo.getText());
        egitmen.setAdres(egitmenAdres.getText());
        egitmen.setMesaisi(Integer.parseInt(egitmenMesai.getText()));
        egitmen.setMaasi(Integer.parseInt(egitmenMaas.getText()));
        egitmen.setAlani(egitmenAlan.getText());
        egitmen.setCalismalar(egitmenCalismalar.getText());
        egtmn.set(i,egitmen);
        olustur();



    }

    @Override
    public void show() {

        egitmenAd.setText(egitmenList.getSelectionModel().getSelectedItem().getAdi());
        egitmenSoyad.setText(egitmenList.getSelectionModel().getSelectedItem().getSoyadi());
        egitmenTelNo.setText(egitmenList.getSelectionModel().getSelectedItem().getTelNo());
        egitmenAdres.setText(egitmenList.getSelectionModel().getSelectedItem().getAdres());
        egitmenCalismalar.setText(egitmenList.getSelectionModel().getSelectedItem().getCalismalar());
        egitmenAlan.setText(egitmenList.getSelectionModel().getSelectedItem().getAlani());
        egitmenMaas.setText(String.valueOf(egitmenList.getSelectionModel().getSelectedItem().getMaasi()));
        egitmenMesai.setText(String.valueOf(egitmenList.getSelectionModel().getSelectedItem().getMesaisi()));

    }

    @Override
    public void listele() {

        egtmn = new ArrayList<>();
        egtmn = read();
        data = FXCollections.observableArrayList(egtmn);
        colAdi.setCellValueFactory(new PropertyValueFactory<>("Adi"));
        colSoyadi.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
        colTelefonNo.setCellValueFactory(new PropertyValueFactory<>("TelNo"));
        colAdres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        colAlani.setCellValueFactory(new PropertyValueFactory<>("Alani"));
        colCalismalar.setCellValueFactory(new PropertyValueFactory<>("Calismalar"));
        colMaas.setCellValueFactory(new PropertyValueFactory<>("Maasi"));
        colMesai.setCellValueFactory(new PropertyValueFactory<>("Mesaisi"));
        egitmenList.setItems(data);

    }

    @Override
    public void sil() {

        int i =  egitmenList.getSelectionModel().getSelectedIndex();
        this.egtmn = new ArrayList<>();
        egtmn = read();
        egtmn.remove(i);
        olustur();

    }



    @Override
    public ArrayList<Egitmen> read() {

        ArrayList<Egitmen> list = new ArrayList<>();

        try {

            File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\EgitmenFiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("egitmen");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode =  nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String eadi = eElement.getElementsByTagName("egitmenad").item(0).getTextContent();
                    String esoyadi = eElement.getElementsByTagName("egitmensoyad").item(0).getTextContent();
                    String etelno = eElement.getElementsByTagName("egitmentelno").item(0).getTextContent();
                    String eadres = eElement.getElementsByTagName("egitmenadres").item(0).getTextContent();
                    int emesaisi = Integer.parseInt(eElement.getElementsByTagName("egitmenmesai").item(0).getTextContent());
                    int emaasi = Integer.parseInt(eElement.getElementsByTagName("egitmenmaasi").item(0).getTextContent());
                    String ealani = eElement.getElementsByTagName("egitmenalani").item(0).getTextContent();
                    String ecalismalar = eElement.getElementsByTagName("egitmencalisma").item(0).getTextContent();

                    //Egitmen tmp = new Egitmen(eadi,esoyadi,etelno,eadres,emesaisi,emaasi,ealani,ecalismalar);
                    Egitmen tmp = new Egitmen();
                    tmp.setAdi(eadi);
                    tmp.setSoyadi(esoyadi);
                    tmp.setTelNo(etelno);
                    tmp.setAdres(eadres);
                    tmp.setMesaisi(emesaisi);
                    tmp.setMaasi(emaasi);
                    tmp.setAlani(ealani);
                    tmp.setCalismalar(ecalismalar);

                    list.add(tmp);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
