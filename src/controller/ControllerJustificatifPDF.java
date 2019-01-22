package controller;

import ClassAppliFrais.Document;
import ClassAppliFrais.FicheFrais;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerJustificatifPDF {
	@FXML
	private Document Doc;
	@FXML
	private Label NomJus;
	@FXML
	private Label PathJus;
	
	  
	public void setFiche(Document Doc) {
		this.Doc=Doc ;
		NomJus.setText(Doc.getNomJustificatif());
			 PathJus.setText(Doc.getPath());
			
		

}
}