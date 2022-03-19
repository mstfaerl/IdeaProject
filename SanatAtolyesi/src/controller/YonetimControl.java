package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.*;
import sample.Egitmen;
import sample.Yonetim;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class YonetimControl implements Islemler {

    public TextField yonetimAd;
    public TextField yonetimSoyad;
    public TextField yonetimTelNo;
    public TextArea yonetimAdres;
    public TextField yonetimMesai;
    public TextField yonetimMaas;
    public TextField yonetimKademe;
    public TableView<Yonetim> yonetimList;
    public TableColumn<Yonetim,String> colAd;
    public TableColumn<Yonetim,String> colSoyad;
    public TableColumn<Yonetim,String> colTelNo;
    public TableColumn<Yonetim,String> colAdres;
    public TableColumn<Yonetim,String> colMesai;
    public TableColumn<Yonetim,String> colMaas;
    public TableColumn<Yonetim,String> colKademe;


    ObservableList<Yonetim> data = FXCollections.observableArrayList();
    public Yonetim yonetim = new Yonetim();
    public ArrayList <Yonetim> yntm = new ArrayList<>();




    @Override
    public void ekle() {

        yntm = read();
        String ad = yonetimAd.getText();
        String soyad = yonetimSoyad.getText();
        String telno = yonetimTelNo.getText();
        String adres = yonetimAdres.getText();
        int mesai = (Integer.parseInt(yonetimMesai.getText()));
        int maas = (Integer.parseInt(yonetimMaas.getText()));
        String kademe = yonetimKademe.getText();
        yonetim = new Yonetim();
        yonetim.setAdi(ad);
        yonetim.setSoyadi(soyad);
        yonetim.setTelNo(telno);
        yonetim.setAdres(adres);
        yonetim.setMesaisi(mesai);
        yonetim.setMaasi(maas);
        yonetim.setKademesi(kademe);
        yntm.add(yonetim);
        olustur();

    }

    @Override
    public void olustur() {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("yonetimler");
            doc.appendChild(rootElement);

            for(Yonetim y : yntm){

                Element staff = doc.createElement("yonetim");
                rootElement.appendChild(staff);

                int id = yntm.indexOf(y);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element yonetimad = doc.createElement("yonetimad");
                yonetimad.appendChild(doc.createTextNode(y.getAdi()));
                staff.appendChild(yonetimad);

                Element yonetimsoyad= doc.createElement("yonetimsoyad");
                yonetimsoyad.appendChild(doc.createTextNode(y.getSoyadi()));
                staff.appendChild(yonetimsoyad);

                Element yonetimtelno = doc.createElement("yonetimtelno");
                yonetimtelno.appendChild(doc.createTextNode(y.getTelNo()));
                staff.appendChild(yonetimtelno);

                Element yonetimadres = doc.createElement("yonetimadres");
                yonetimadres.appendChild(doc.createTextNode(y.getAdres()));
                staff.appendChild(yonetimadres);

                Element yonetimmesai = doc.createElement("yonetimmesai");
                yonetimmesai.appendChild(doc.createTextNode(String.valueOf(y.getMesaisi())));
                staff.appendChild(yonetimmesai);

                Element yonetimmaas= doc.createElement("yonetimmaas");
                yonetimmaas.appendChild(doc.createTextNode(String.valueOf(y.getMaasi())));
                staff.appendChild(yonetimmaas);

                Element yonetimkademe = doc.createElement("yonetimkademe");
                yonetimkademe.appendChild(doc.createTextNode(y.getKademesi()));
                staff.appendChild(yonetimkademe);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\YonetimFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void duzenle() {

        int i =  yonetimList.getSelectionModel().getSelectedIndex();
        this.yntm = new ArrayList<>();
        yntm = read();
        yonetim = new Yonetim();
        yonetim.setAdi(yonetimAd.getText());
        yonetim.setSoyadi(yonetimSoyad.getText());
        yonetim.setTelNo(yonetimTelNo.getText());
        yonetim.setAdres(yonetimAdres.getText());
        yonetim.setMesaisi(Integer.parseInt(yonetimMesai.getText()));
        yonetim.setMaasi(Integer.parseInt(yonetimMaas.getText()));
        yonetim.setKademesi(yonetimKademe.getText());
        yntm.set(i,yonetim);
        olustur();

    }

    @Override
    public void listele() {

        yntm = new ArrayList<>();
        yntm = read();
        data = FXCollections.observableArrayList(yntm);
        colAd.setCellValueFactory(new PropertyValueFactory<>("Adi"));
        colSoyad.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("TelNo"));
        colAdres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        colMesai.setCellValueFactory(new PropertyValueFactory<>("Mesaisi"));
        colMaas.setCellValueFactory(new PropertyValueFactory<>("Maasi"));
        colKademe.setCellValueFactory(new PropertyValueFactory<>("Kademesi"));
        yonetimList.setItems(data);

    }

    @Override
    public void sil() {

        int i =  yonetimList.getSelectionModel().getSelectedIndex();
        this.yntm = new ArrayList<>();
        yntm = read();
        yntm.remove(i);
        olustur();

    }

    @Override
    public ArrayList<Yonetim> read() {
        ArrayList<Yonetim> list = new ArrayList<>();

        try {

            File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\YonetimFiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("yonetim");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode =  nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String yadi = eElement.getElementsByTagName("yonetimad").item(0).getTextContent();
                    String ysoyadi = eElement.getElementsByTagName("yonetimsoyad").item(0).getTextContent();
                    String ytelno = eElement.getElementsByTagName("yonetimtelno").item(0).getTextContent();
                    String yadres = eElement.getElementsByTagName("yonetimadres").item(0).getTextContent();
                    int ymesai = Integer.parseInt(eElement.getElementsByTagName("yonetimmesai").item(0).getTextContent());
                    int ymaas = Integer.parseInt(eElement.getElementsByTagName("yonetimmaas").item(0).getTextContent());
                    String ykademe = eElement.getElementsByTagName("yonetimkademe").item(0).getTextContent();

                    //Egitmen tmp = new Egitmen(eadi,esoyadi,etelno,eadres,emesaisi,emaasi,ealani,ecalismalar);
                    Yonetim tmp = new Yonetim();
                    tmp.setAdi(yadi);
                    tmp.setSoyadi(ysoyadi);
                    tmp.setTelNo(ytelno);
                    tmp.setAdres(yadres);
                    tmp.setMesaisi(ymesai);
                    tmp.setMaasi(ymaas);
                    tmp.setKademesi(ykademe);

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

        yonetimAd.setText(yonetimList.getSelectionModel().getSelectedItem().getAdi());
        yonetimSoyad.setText(yonetimList.getSelectionModel().getSelectedItem().getSoyadi());
        yonetimTelNo.setText(yonetimList.getSelectionModel().getSelectedItem().getTelNo());
        yonetimAdres.setText(yonetimList.getSelectionModel().getSelectedItem().getAdres());
        yonetimMesai.setText(String.valueOf(yonetimList.getSelectionModel().getSelectedItem().getMesaisi()));
        yonetimMaas.setText(String.valueOf(yonetimList.getSelectionModel().getSelectedItem().getMaasi()));
        yonetimKademe.setText(yonetimList.getSelectionModel().getSelectedItem().getKademesi());

    }
}
