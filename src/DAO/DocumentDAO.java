package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassAppliFrais.Document;

import ClassAppliFrais.Visiteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DocumentDAO {


	
	public static ObservableList<Document> findall() throws SQLException {
		ObservableList<Document> DocumentList = FXCollections.observableArrayList();
		String req = "SELECT * FROM document";
		Connection cnx = Connect.getInstance().getConnection();
		PreparedStatement pst = cnx.prepareStatement(req);
		
		int idJustificatif; 
		String idVisiteur;
		String path;
		
		
		
		
		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
			idJustificatif = table.getInt("idJustificatif");
			idVisiteur= table.getString("idVisiteur");
			path = table.getString("path");
		
			
			
			VisiteurDAO vd = new VisiteurDAO() ;
			Visiteur v = vd.findById(idVisiteur);
			
			
		
			
			Document listeDoc = new Document(v);

			listeDoc.setIdJustificatif(idJustificatif);
			listeDoc.setPath(path);
			listeDoc.setIdVisiteur(v);
			
	
			
			DocumentList.add(listeDoc);
			System.out.println(listeDoc);
		}
		
		
		return DocumentList;
}
	
public ObservableList<Document> findPath() throws SQLException {
	ObservableList<Document> DocumentList = FXCollections.observableArrayList();
		String requeteSQL = " ";
		Connection cnx = Connect.getInstance().getConnection();
		PreparedStatement pst = cnx.prepareStatement(requeteSQL);
		
		int idJustificatif; 
		String idVisiteur;
		String path;
	
		
		
		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
			idJustificatif = table.getInt("idJustificatif");
			idVisiteur= table.getString("idVisiteur");
			path = table.getString("path");
			
			
			VisiteurDAO vd = new VisiteurDAO() ;
			Visiteur v = vd.findById(idVisiteur);
			
			
		
			
			Document listeDoc = new Document(v);

			listeDoc.setIdJustificatif(idJustificatif);
			listeDoc.setPath(path);
			listeDoc.setIdVisiteur(v);
		
			
			DocumentList.add(listeDoc);
			System.out.println(listeDoc);
		}
		
		
		return DocumentList;
}
}