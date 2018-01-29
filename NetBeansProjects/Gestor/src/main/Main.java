    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Login;
import model.SQLLogin;

/**
 *
 * @author emanuel
 */
public class Main extends Application {
    
     @Override
    public void start(Stage stage) throws Exception {
         SQLLogin login = new SQLLogin();
         
         login.create(new Login(1,"Emanuel","123","inspetoria"));
         //login.delete();
         System.out.println(login.all());
        
        //Parent root = FXMLLoader.load(getClass().getResource("/view/PresoFXML.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private static ArrayList<onChangeScreen> listeners = new ArrayList();
    
    public static interface onChangeScreen{
        void onScreenChange(String newScreen, Object userData);
    }
    
    public static  void addOnChangeScreenListener(onChangeScreen newListener){
        listeners.add(newListener);
    }
    
    public static void notifyAllListeners(String newScreen, Object userData){
        for (onChangeScreen listener : listeners) {
            listener.onScreenChange(newScreen, userData);
        }
    }
}
