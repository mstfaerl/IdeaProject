package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import sample.Malzemeler;

import java.io.File;
import java.util.ArrayList;


public class MalzemelerControl implements Islemler {

    public TextField vernikTipi;
    public TextField ekMalzeme;
    public TextField tekneEbati;
    public TextField fircaCesidi;
    public TextField tarakCesidi;
    public TextField tuvalBoyutu;
    public TextField kagitBoyutu;
    public TextField tabloCesidi;
    public TableView<Malzemeler> malzemelerList;
    public TableColumn<Malzemeler,String> colVernik;
    public TableColumn<Malzemeler,String> colEkler;
    public TableColumn<Malzemeler,String> colTekne;
    public TableColumn<Malzemeler,String> colFirca;
    public TableColumn<Malzemeler,String> colTarak;
    public TableColumn<Malzemeler,String> colTuval;
    public TableColumn<Malzemeler,String> colKagit;
    public TableColumn<Malzemeler,String> colTablo;

    ObservableList<Malzemeler> data = FXCollections.observableArrayList();
    public Malzemeler malzeme;
    public ArrayList <Malzemeler> mlzm = new ArrayList();


    @Override
    public void olustur(){

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("malzemeler");
            doc.appendChild(rootElement);

            for(Malzemeler m : mlzm){

                Element staff = doc.createElement("malzeme");
                rootElement.appendChild(staff);

                int id = mlzm.indexOf(m);
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(id));
                staff.setAttributeNode(attr);

                Element verniktipi = doc.createElement("verniktipi");
                verniktipi.appendChild(doc.createTextNode(m.getVernikTip()));
                staff.appendChild(verniktipi);

                Element ekmalzeme = doc.createElement("ekmalzeme");
                ekmalzeme.appendChild(doc.createTextNode(m.getEkMalzemeler()));
                staff.appendChild(ekmalzeme);

                Element tekneebati = doc.createElement("tekneebati");
                tekneebati.appendChild(doc.createTextNode(m.getTekneEbati()));
                staff.appendChild(tekneebati);

                Element fircacesidi = doc.createElement("fircacesidi");
                fircacesidi.appendChild(doc.createTextNode(m.getFircaCesidi()));
                staff.appendChild(fircacesidi);

                Element tarakcesidi = doc.createElement("tarakcesidi");
                tarakcesidi.appendChild(doc.createTextNode(m.getTarakCesidi()));
                staff.appendChild(tarakcesidi);

                Element tuvalboyutu = doc.createElement("tuvalboyutu");
                tuvalboyutu.appendChild(doc.createTextNode(m.getTuvalBoyut()));
                staff.appendChild(tuvalboyutu);

                Element kagitboyutu = doc.createElement("kagitboyutu");
                kagitboyutu.appendChild(doc.createTextNode(m.getKagitBoyut()));
                staff.appendChild(kagitboyutu);

                Element tablocesidi = doc.createElement("tablocesidi");
                tablocesidi.appendChild(doc.createTextNode(m.getTabloCesit()));
                staff.appendChild(tablocesidi);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\MalzemelerFiles.xml"));

            transformer.transform(source, result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void ekle(){

        mlzm = read();

        malzeme = new Malzemeler(vernikTipi.getText(), ekMalzeme.getText(), tuvalBoyutu.getText(), kagitBoyutu.getText(), tabloCesidi.getText(), tekneEbati.getText(), fircaCesidi.getText(), tarakCesidi.getText());
        mlzm.add(malzeme);

        olustur();



    }

    @Override
    public void duzenle() {

        int i =  malzemelerList.getSelectionModel().getSelectedIndex();
        this.mlzm = new ArrayList<>();
        mlzm = read();
        malzeme = new Malzemeler();
        malzeme.setVernikTip(vernikTipi.getText());
        malzeme.setEkMalzemeler(ekMalzeme.getText());
        malzeme.setTekneEbati(tekneEbati.getText());
        malzeme.setFircaCesidi(fircaCesidi.getText());
        malzeme.setTarakCesidi(tarakCesidi.getText());
        malzeme.setTuvalBoyut(tuvalBoyutu.getText());
        malzeme.setKagitBoyut(kagitBoyutu.getText());
        malzeme.setTabloCesit(tabloCesidi.getText());
        mlzm.set(i,malzeme);
        olustur();

    }

    @Override
    public void show(){
        vernikTipi.setText(malzemelerList.getSelectionModel().getSelectedItem().getVernikTip());
        ekMalzeme.setText(malzemelerList.getSelectionModel().getSelectedItem().getEkMalzemeler());
        tekneEbati.setText(malzemelerList.getSelectionModel().getSelectedItem().getTekneEbati());
        fircaCesidi.setText(malzemelerList.getSelectionModel().getSelectedItem().getFircaCesidi());
        tarakCesidi.setText(malzemelerList.getSelectionModel().getSelectedItem().getTarakCesidi());
        tuvalBoyutu.setText(malzemelerList.getSelectionModel().getSelectedItem().getTuvalBoyut());
        kagitBoyutu.setText(malzemelerList.getSelectionModel().getSelectedItem().getKagitBoyut());
        tabloCesidi.setText(malzemelerList.getSelectionModel().getSelectedItem().getTabloCesit());
    }

    @Override
    public void listele() {

        mlzm = new ArrayList<>();
        mlzm = read();
        data = FXCollections.observableArrayList(mlzm);
        colVernik.setCellValueFactory(new PropertyValueFactory<>("VernikTip"));
        colEkler.setCellValueFactory(new PropertyValueFactory<>("EkMalzemeler"));
        colTekne.setCellValueFactory(new PropertyValueFactory<>("TekneEbati"));
        colFirca.setCellValueFactory(new PropertyValueFactory<>("FircaCesidi"));
        colTarak.setCellValueFactory(new PropertyValueFactory<>("TarakCesidi"));
        colTuval.setCellValueFactory(new PropertyValueFactory<>("TuvalBoyut"));
        colKagit.setCellValueFactory(new PropertyValueFactory<>("KagitBoyut"));
        colTablo.setCellValueFactory(new PropertyValueFactory<>("TabloCesit"));
        malzemelerList.setItems(data);


    }

    @Override
    public void sil(){
        int i =  malzemelerList.getSelectionModel().getSelectedIndex();
        this.mlzm = new ArrayList<>();
        mlzm = read();
        mlzm.remove(i);
        olustur();
    }

    @Override
    public ArrayList<Malzemeler> read() {

        ArrayList<Malzemeler> list = new ArrayList<>();

            try {

                File fXmlFile = new File("C:\\Users\\m07er\\IdeaProjects\\SanatAtolyesi\\src\\datafiles\\MalzemelerFiles.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("malzeme");

                for (int i = 0; i < nList.getLength(); i++) {

                    Node nNode =  nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        String vtipi = eElement.getElementsByTagName("verniktipi").item(0).getTextContent();
                        String ekm = eElement.getElementsByTagName("ekmalzeme").item(0).getTextContent();
                        String tebat = eElement.getElementsByTagName("tekneebati").item(0).getTextContent();
                        String fc = eElement.getElementsByTagName("fircacesidi").item(0).getTextContent();
                        String tc = eElement.getElementsByTagName("tarakcesidi").item(0).getTextContent();
                        String tb = eElement.getElementsByTagName("tuvalboyutu").item(0).getTextContent();
                        String kb = eElement.getElementsByTagName("kagitboyutu").item(0).getTextContent();
                        String tac = eElement.getElementsByTagName("tablocesidi").item(0).getTextContent();

                        Malzemeler tmp = new Malzemeler(vtipi,ekm,tb,kb,tac,tebat,fc,tc);
                        list.add(tmp);

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return list;

    }

}
