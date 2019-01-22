package view;

import java.sql.SQLException;


import ClassAppliFrais.LigneFraisHorsForfait;
import ClassAppliFrais.Lignefraisforfait;
import ClassAppliFrais.Document;
import ClassAppliFrais.Etat;
import ClassAppliFrais.FicheFrais;
import ClassAppliFrais.Visiteur;
import DAO.ComptableDAO;
import DAO.DocumentDAO;
import DAO.FicheFraisDAO;
import DAO.LigneFraisForfaitDAO;
import DAO.VisiteurDAO;
import javafx.collections.ObservableList;

public class test {

	public static void main(String[] args) throws SQLException {
		
	/*LigneFraisForfaitDAO b = new LigneFraisForfaitDAO();
	ObservableList<Lignefraisforfait> OUI = b.findall();*/
	
		DocumentDAO y = new DocumentDAO();
	ObservableList<Document> listeDoc= (new DocumentDAO()).findall();
	System.out.println(listeDoc.get(0));
		
		//VisiteurDAO v = new VisiteurDAO();
	//<Visiteur> idVisiteur = v.findById("a131");
		
	
	
	}
	

}

