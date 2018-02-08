/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import animations.FadeInLeftTransition;
import animations.FadeInLeftTransition1;
import animations.FadeInRightTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Login;
import model.SQLLogin;

/**
 * FXML Controller class
 *
 * @author emanuel
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Text lblWelcome;
    @FXML
    private Text lblUserLogin;
    @FXML
    private Text lblUsername;
    @FXML
    private Text lblPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Text lblRudyCom;
    @FXML
    private Label lblClose;

    Stage stage;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            new FadeInRightTransition(lblUserLogin).play();
            new FadeInLeftTransition(lblWelcome).play();
            new FadeInLeftTransition1(lblPassword).play();
            new FadeInLeftTransition1(lblUsername).play();
            new FadeInLeftTransition1(txtUsername).play();
            new FadeInLeftTransition1(txtPassword).play();
            new FadeInRightTransition(btnLogin).play();
            lblClose.setOnMouseClicked((MouseEvent event) -> {
                Platform.exit();
                System.exit(0);
            });
            btnLogin.setDefaultButton(true);
            txtUsername.setText("");
            txtPassword.setText("");
        });
        // TODO
    }

    @FXML
    private void aksiLogin(ActionEvent event) throws IOException {
        SQLLogin login = new SQLLogin();
        Login l = login.isLogin(txtUsername.getText(), "");

        if (txtUsername.getText().equals(l.getUser()) && txtPassword.getText().equals(l.getPass())) {
            stage = (Stage) lblClose.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/view/FormMenu.fxml"));
            Parent root = Loader.load();
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.initStyle(StageStyle.UNDECORATED);
            st.setResizable(false);
            st.setMaximized(true);
            st.setTitle("SisCrag");
            st.setScene(scene);
            MenuController menu = Loader.getController();
            switch(l.getPerfil()){
                case "inspetoria":
                    menu.listMenu.getItems().addAll("  Escala", "  Folgas", "  Trocas", "  Inversões", "  Férias", "  Sobre");
                    break;
                case "sicop":
                    menu.listMenu.getItems().addAll("  Comunicado", "  Informativo", "  Relatorios", "  Presos", "  RD", "  Sobre");
            }
            st.show();
            stage.close();

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText("Login no sistema");
            alert.setContentText("Usuario ou senha errado!");

            alert.showAndWait();
        }
    }

}
