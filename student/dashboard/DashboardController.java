/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.dashboard;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class DashboardController implements Initializable {

    @FXML
    private ImageView btnClose;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private JFXButton btnTrackApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
        
    }

    @FXML
    private void handleRegisterButton(MouseEvent event) {
        
        try {
                     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/student/register/RegisterUI.fxml"));  
                     System.out.println("Hello dashboard controller1");
                     Parent root1 = (Parent)fxmlLoader.load();
                     System.out.println("Hello dashboard controller34");

                     Stage stage = new Stage();
                     System.out.println("Hello dashboard controller41");

                     //stage.initStyle(StageStyle.TRANSPARENT);
                     stage.setScene(new Scene(root1));
                    System.out.println("Hello dashboard controller66");
 
                     stage.show();
                     System.out.println("Hello dashboard controller2222");
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                     System.out.println("Hello dashboard 128");


                     
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
    }
    
}
