package controller;

import java.io.IOException;

import java.sql.SQLException;

import DAO.ComptableDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import view.Connexion;


public class ConnexionController {
	
	@FXML
	TextField txtLogin ;
	@FXML
	TextField txtMdp ;
	@FXML
	Button btConnexion ;
	@FXML 
	Pane PaneConnexion;
	@FXML
	TextField info;
	
	
	
	
	@FXML
	private void actionConnexion(ActionEvent evt) throws SQLException, IOException {
	
	
			
			
		if( ComptableDAO.auth(txtLogin.getText(),txtMdp.getText())) {
	
				FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Connexion.class.getClassLoader().getResource("view/TableauDesVisiteur.fxml"));
	            AnchorPane PageVisiteur = (AnchorPane) loader.load();
	                 Stage stage =  (Stage)txtMdp.getScene().getWindow();
	             // Set person overview into the center of root layout.
	                 Scene scene = txtMdp.getScene();
	                 scene.setRoot(PageVisiteur);
	                 stage.setScene(scene);
		
		}
		
		info.setText("Login ou mdp incorrect!");
		
	} 
	
	

	
	@FXML
    private void initialize ()  {
		
		
		txtLogin.setText("");
	}
	

}
 