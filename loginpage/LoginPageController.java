/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class LoginPageController implements Initializable {
    
    @SuppressWarnings("unsused")
    private LoginPage loginpage;

    @FXML
    private Pane paneStudent;
    @FXML
    private JFXTextField txtPaymentReceipt;
    @FXML
    private JFXPasswordField txtPin;
    @FXML
    private JFXButton btnStudentLogin;
    @FXML
    private JFXButton btnAdminLoginSwitch;
    @FXML
    private ImageView btnClose;
    @FXML
    private Pane paneAdmin;
    @FXML
    private JFXTextField txtAdminUsername;
    @FXML
    private JFXPasswordField txtAdminPassword;
    @FXML
    private JFXButton btnAdminLogin;
    @FXML
    private JFXButton btnStudentLoginSwitch;
    @FXML
    private ImageView btnBack;
    @FXML
    private Label lblPinIncorrect;

    /**
     * Initializes the controller class.
     */
    

    @FXML
    private void handleLoginSwitchAction(ActionEvent event) {
        if (event.getSource().equals(btnStudentLoginSwitch)) {

            paneStudent.toFront();
        }

        if (event.getSource().equals(btnAdminLoginSwitch)) {
            paneAdmin.toFront();
        }

    }

    @FXML
    private void handleMovementToggle(MouseEvent event) {

        if (event.getSource() == btnClose) {
            System.exit(0);
        }

        if (event.getSource() == btnBack) {
            paneStudent.toFront();

        }
    }
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    @FXML 
    private void handleStudentLogin(MouseEvent event) {
        
        
        String receipt = txtPaymentReceipt.getText();
        String pin = txtPin.getText();
        
        if (receipt.equals("") && pin.equals(""))
        {
            System.out.println("Hello");
            JOptionPane.showMessageDialog(null, "Incorrect receipt or pin!");
            txtPaymentReceipt.requestFocus();

        }
        
        else {
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/schoolsystem", "root", "");
                preparedStatement = connection.prepareStatement("select * from stlogin where payment=? and pin=?");
                
                preparedStatement.setString(1, receipt);
                preparedStatement.setString(2, pin);
                
                resultSet = preparedStatement.executeQuery();
                
                
                if (resultSet.next())
                {
                    //JOptionPane.showMessageDialog(null, "Login Successful!");
                    try {
                     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/student/dashboard/Dashboard.fxml"));  
                     System.out.println("Hello loginpage controller1");
                     Parent root1 = (Parent)fxmlLoader.load();
                     Stage stage = new Stage();
                     stage.initStyle(StageStyle.TRANSPARENT);
                     stage.setScene(new Scene(root1));
                     stage.show();
                     System.out.println("Hello loginpage controller2222");
                    ((Node)(event.getSource())).getScene().getWindow().hide();

                     
                    }
                    catch(Exception e){
                    }
                    e.printStackTrace();
                }
                
                else 
                {
                     JOptionPane.showMessageDialog(null, "Login Failed!");
                        txtPaymentReceipt.setText("");
                        txtPaymentReceipt.requestFocus();

                        txtPin.setText("");
                }
            }
            
            
            
            
            
            catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO       
    }
    
    
    
   


   

}
