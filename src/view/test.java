package view;

import java.sql.SQLException;


import ClassAppliFrais.Lignefraisforfait;

import DAO.LigneFraisForfaitDAO;

import javafx.collections.ObservableList;

public class test {

	public static void main(String[] args) throws SQLException {
		
	/*LigneFraisForfaitDAO b = new LigneFraisForfaitDAO();
	ObservableList<Lignefraisforfait> OUI = b.findall();*/
	
		
	LigneFraisForfaitDAO l = new LigneFraisForfaitDAO();
	ObservableList<Lignefraisforfait> liste  = l.findById("a131");
	System.out.println(liste.get(0).getQuantite());
		
		//VisiteurDAO v = new VisiteurDAO();
	//<Visiteur> idVisiteur = v.findById("a131");
		
	
	
	}
	

}

