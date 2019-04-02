package DAO;

import java.sql.SQLException;

import javafx.collections.ObservableList;



public interface DAO <T>{
	ObservableList<T> findall() throws SQLException ;
	
	
	
	
	
	
	
	
	
	
	
	
	 
	/*default List<T> find(String t) throws SQLException {  
		
		Connection cnx = Connect.getInstance().getConnection();
 	ObservableList<FicheFrais> UserListF = FXCollections.observableArrayList();
 	
 	t = t
 			.replace("!", "!!")
 			.replace("%", "!%")
 			.replace("_", "!_")
 			.replace("[", "![");
 	
 	String req = "SELECT idVisiteur, mois, nbJustificatifs, montantValide, dateModif, idEtat "
 			+ "FROM fichefrais WHERE  idVisiteur LIKE ? ESCAPE '!' OR mois LIKE ? ESCAPE '!' "
 			+ "OR nbJustificatifs LIKE ? ESCAPE '!' OR montantValide LIKE ? ESCAPE '!' OR dateModif LIKE ? ESCAPE '!'"
 			+ "OR idEtat LIKE ? ESCAPE '!'";
	return null;
 	}*/
}

