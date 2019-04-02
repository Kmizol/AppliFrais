package controller;

import java.io.IOException;

import java.sql.SQLException;

import ClassAppliFrais.Document;
import ClassAppliFrais.FicheFrais;
import ClassAppliFrais.Lignefraisforfait;
import DAO.DocumentDAO;
import DAO.FicheFraisDAO;
import DAO.LigneFraisForfaitDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import view.Connexion;

public class FicheFraisVisiteurController {
	
	@FXML
	private Button Rtr;
	@FXML
	private Button Dcx;
	@FXML 
	private Button Valider; 
	@FXML 
	private AnchorPane  mainPane ;
    @FXML
    private TableView <Lignefraisforfait> TBFicheFrais ;
    @FXML
    private TableColumn <Lignefraisforfait,String> IdVisiteur;
    @FXML
    private TableColumn <Lignefraisforfait,String> Mois;
    @FXML
    private TableColumn <Lignefraisforfait,String> IdFraisForfait;
    @FXML
    private TableColumn <Lignefraisforfait,Float> Montant;
    @FXML
    private TableColumn <Lignefraisforfait,Integer> Quantité;
 
    
    @FXML
    private TableView <Document> TBJustificatifs;
    @FXML 
    private TableColumn <Document,String> Justificatifs;
    @FXML
    private TableColumn<Document, Float> MontantJust;
    ObservableList<Document> ListeVide ;
    @FXML
    private TableColumn AfficherJu1;
    
   
    @FXML
    private Label idV ;
    @FXML
    private Label nomV ;
    @FXML
    private Label prenomV ;
    ObservableList<Lignefraisforfait> empData ;
    private FicheFrais fiche ;
    
	public void ValiderFF(ActionEvent evt) throws SQLException, IOException {
					FicheFraisDAO.updateFiche(fiche.getIdVisiteur().getId(),fiche.getMois());

		
	    /*        FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(.class.getClassLoader().getResource("View/afficherFicheFrais.fxml"));
	      AnchorPane visiteurFrame = (AnchorPane) loader.load();*/
	}


	public void setFiche(FicheFrais fiche) {
		this.fiche =fiche ;
		 idV.setText(fiche.getIdVisiteur().getId());
			 nomV.setText(fiche.getIdVisiteur().getNom());
			  prenomV.setText(fiche.getIdVisiteur().getPrenom());
			  try {
	    		     System.out.println(fiche.getIdVisiteur().getId());
					empData = (new LigneFraisForfaitDAO()).findById(fiche.getIdVisiteur().getId());	
					 System.out.println(empData.get(0));
					
					 
	    	}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
				 TBFicheFrais.setItems(empData);
		
	}
	 @FXML
	private void initialize ()  {
		 
	    	
	    	
	    	
	    
	    
			
	    	IdVisiteur.setCellValueFactory(cellData -> cellData.getValue().getIdVisiteur().getIdPro());
	    	Mois.setCellValueFactory(cellData -> cellData.getValue().getMoisPro());
	    	IdFraisForfait.setCellValueFactory(cellData -> cellData.getValue().getIdFraisForfait().getIdPro());
	    	Montant.setCellValueFactory(cellData -> cellData.getValue().getMontantPro().asObject());
	    	Quantité.setCellValueFactory(cellData -> cellData.getValue().getQuantitePro().asObject());	
	    	
	    
	
		  try {
				ListeVide = DocumentDAO.findall();
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				       
			    };
			System.out.println(ListeVide.get(0));
				TBJustificatifs.setItems(ListeVide);
				 
				
				
			 Callback<TableColumn<Document, String>, TableCell<Document, String>> cellFactory
	         = //
	         new Callback<TableColumn<Document, String>, TableCell<Document, String>>() {
				 
	     @Override
	     public TableCell call(final TableColumn<Document, String> param) {
	         final TableCell<Document, String> cell = new TableCell<Document, String>() {

	             final Button btn = new Button("Afficher");

	             @Override
	             public void updateItem(String item, boolean empty) {
	                 super.updateItem(item, empty);
	                 if (empty) {
	                     setGraphic(null);
	                     setText(null);
	                 } else {
	                     btn.setOnAction(event -> {
	                    	 Document Doc = getTableView().getItems().get(getIndex());
	                    System.out.println(Doc);
	                       
	                       FXMLLoader loader = new FXMLLoader();
	         			    loader.setLocation(Connexion.class.getClassLoader().getResource("view/JustificatifPDF.fxml"));
	         			   AnchorPane userFrame;
						try {
							  userFrame = (AnchorPane) loader.load();
							
	                        Scene sc = btn.getScene();
	                        
	                        ControllerJustificatifPDF ConJusPDF = loader.getController(); 
	                        
	                  ConJusPDF.setFiche(Doc);
	                        
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
	 		AfficherJu1.setCellFactory(cellFactory);
	 		
	 		Justificatifs.setCellValueFactory(cellData -> cellData.getValue().getNomJustificatifPro());
			MontantJust.setCellValueFactory(cellData -> cellData.getValue().getMontantJustificatifPro().asObject());
		 
			}
	 
	    
	    
	  
	 
	 
	 @FXML
	public void Retour(ActionEvent actEv)  throws SQLException, IOException {
    	
    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Connexion.class.getClassLoader().getResource("view/TableauDesVisiteur.fxml"));
           Pane Connexion  = (Pane) loader.load();
                Stage stage =  (Stage) Rtr.getScene().getWindow();
            // Set person overview into the center of root layout.
                
                Scene scene = Rtr.getScene();
                scene.setRoot(Connexion);
                stage.setScene(scene);
                
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
   
	@FXML
	public void Deconnexion(ActionEvent actEv)  throws SQLException, IOException {
    	
    	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Connexion.class.getClassLoader().getResource("view/Connexion.fxml"));
           Pane Connexion  = (Pane) loader.load();
                Stage stage =  (Stage) Dcx.getScene().getWindow();
            // Set person overview into the center of root layout.
                
                Scene scene = Dcx.getScene();
                scene.setRoot(Connexion);
                stage.setScene(scene);
                
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }

	
	   
}
               
	       
		
		
	 
	
	

	 
	    

 
