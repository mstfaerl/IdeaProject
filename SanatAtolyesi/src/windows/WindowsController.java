package windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class WindowsController {

    public TextField kadi;
    public TextField ksifre;

    public void giris(ActionEvent event) throws IOException {

            if(kadi.getText().equalsIgnoreCase("asd") && ksifre.getText().equalsIgnoreCase("asd")){
                Parent a = FXMLLoader.load(getClass().getResource("../windows/Secimler.fxml"));
                Scene b = new Scene(a);
                Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                apStage.setScene(b);
                apStage.setTitle("Seçimler");
                apStage.show();
            }
            else if(kadi.getText().equalsIgnoreCase("") || ksifre.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Kullanici adi veya şifre boş geçilemez!");
            }

            else{
                JOptionPane.showMessageDialog(null,"Kullanici adi veya şifre yanlış!");
            }

    }

    public void sanatsecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/SanatAtolyesi.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Sanat Atölyesi");
        apStage.show();

    }

    public void kisisecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/Kisiler.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Kişiler");
        apStage.show();

    }

    public void ahsapsecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/AhsapBoyamaAtolyesi.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Ahşap Boyama Atölyesi");
        apStage.show();

    }

    public void desensecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/DesenliTabloAtolyesi.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Desenli Tablo Atölyesi");
        apStage.show();

    }

    public void ebrusecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/EbruSanatiAtolyesi.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Ebru Sanatı Atölyesi");
        apStage.show();

    }

    public void malzemesecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/Malzemeler.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Malzemeler");
        apStage.show();

    }

    public void yonetimsecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/Yonetim.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Yönetim");
        apStage.show();

    }

    public void egitmensecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/Egitmen.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Egitmen");
        apStage.show();

    }

    public void kursiyersecim(ActionEvent event) throws IOException {

        Parent a = FXMLLoader.load(getClass().getResource("../windows/Kursiyer.fxml"));
        Scene b = new Scene(a);
        Stage apStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        apStage.setScene(b);
        apStage.setTitle("Kursiyer");
        apStage.show();

    }

}
