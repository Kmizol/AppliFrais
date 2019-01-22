package controller;



import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import ClassAppliFrais.Etat;
import ClassAppliFrais.FicheFrais;
import ClassAppliFrais.Visiteur;
import DAO.FicheFraisDAO;
import DAO.VisiteurDAO;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import view.Connexion;


public class ControllerTableauDesVisiteur {

	@FXML
	private TextField txtMois;
	
	@FXML	
	private Button dcx;
	
	@FXML
	private Button BtRecherche;
	
	@FXML
	private Button All;
	
	@FXML
	private TableView<FicheFrais> tbVisiteur;
	
	@FXML
	private TableColumn<FicheFrais,String> TBId;
	
	@FXML 
	private TableColumn<FicheFrais,String> TBNom;
	
	@FXML
	private TableColumn<FicheFrais,String> TBPrenom;
	
	@FXML
	private TableColumn<FicheFrais,String> TBAdresse;
	
	@FXML
	private TableColumn<FicheFrais,String> TBVille;
	
	@FXML 
	private TableColumn<FicheFrais,String> TBCp;
	
	@FXML 
	private TableColumn<FicheFrais,String> TBDateEmbauche;
	
	@FXML
	private TableColumn<FicheFrais,String> TBIdEtat;
	
	@FXML
	private TableColumn AccesFF;
	
	@FXML 
	private Pane  mainPane ;
    ObservableList<FicheFrais> empData ;
    
 
    @FXML
    private void RechercheParMois(ActionEvent evt) {
    	
    String mois = txtMois.getText();
    
	try {
		empData = (new FicheFraisDAO()).findByMois(mois);
		 tbVisiteur.setItems(empData);	
		} 
	
	catch (SQLException e) 	{
		// TODO Auto-generated catch block
		e.printStackTrace();
							}	
   } 

	
  /* @FXML
    private void searchUsers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all User information
             empData = FicheFraisDAO.findall();
            //Populate Employees on TableView
            tbVisiteur.setItems(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }*/
 /*   @FXML
    private void searchUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all User information
            ObservableList<FicheFrais> empData = FicheFraisDAO.findall();
            //Populate Employees on TableView
            tbVisiteur.setItems(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }*/
    
    @FXML
    private void initialize ()  {
    	
    	try {
			empData = (new FicheFraisDAO()).findall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		 tbVisiteur.setItems(empData);
		 
		 Callback<TableColumn<FicheFrais, String>, TableCell<FicheFrais, String>> cellFactory
         = //
         new Callback<TableColumn<FicheFrais, String>, TableCell<FicheFrais, String>>() {
			 
     @Override
     public TableCell call(final TableColumn<FicheFrais, String> AccesFF) {
         final TableCell<FicheFrais, String> cell = new TableCell<FicheFrais, String>() {

             final Button btn = new Button("Afficher");

             @Override
             public void updateItem(String item, boolean empty) {
                 super.updateItem(item, empty);
                 if (empty) {
                     setGraphic(null);
                     setText(null);
                 } else {
                     btn.setOnAction(event -> {
                    	 FicheFrais fiche = getTableView().getItems().get(getIndex());
                    System.out.println(fiche);
                       
                       FXMLLoader loader = new FXMLLoader();
         			    loader.setLocation(Connexion.class.getClassLoader().getResource("view/FicheFraisVisiteur.fxml"));
         			   AnchorPane userFrame;
					try {
						  userFrame = (AnchorPane) loader.load();
						
                        Scene sc = btn.getScene();
                        
                        FicheFraisVisiteurController FicheFController = loader.getController(); 
                        
                  FicheFController.setFiche(fiche);
                        
                        sc.setRoot(userFrame);
                     
                     
                       
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         			    // Set person overview into the center of root layout.
         			 
                     });
                     setGraphic(btn);
                     setText(null);
                 }
             }
         };
         return cell;
     }
 };		 

	tbVisiteur.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
       
    });
	AccesFF.setCellFactory(cellFactory);
	
TBIdEtat.setCellValueFactory(cellData -> cellData.getValue().getIdEtat().getLibellePro());
TBId.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getIdPro());
TBNom.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getNomPro());
TBPrenom.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getPrenomPro());
TBAdresse.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getAdressePro());
TBVille.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getVillePro());
TBCp.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getCpPro());
TBDateEmbauche.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getDateEmbauchePro().asString());

    }
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void Deconnexion(ActionEvent actEv)  throws SQLException, IOException {
    	
    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Connexion.class.getClassLoader().getResource("view/Connexion.fxml"));
           Pane Connexion  = (Pane) loader.load();
                Stage stage =  (Stage) dcx.getScene().getWindow();
            // Set person overview into the center of root layout.
                
                Scene scene = dcx.getScene();
                scene.setRoot(Connexion);
                stage.setScene(scene);
                
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
   
    }

