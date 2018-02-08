/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import utils.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author emanuel
 */
public class PresoFXMLController implements Initializable {

    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtRg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void txtFormatTel(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0987654321");
        tff.setTf(txtTel);
        tff.formatter();
    }

    @FXML
    private void txtFormatRg(KeyEvent event) {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##.###.###-#");
        tff.setCaracteresValidos("0987654321");
        tff.setTf(txtRg);
        tff.formatter();
    }

}
