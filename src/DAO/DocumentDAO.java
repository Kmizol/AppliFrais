package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassAppliFrais.Document;
import ClassAppliFrais.FraisForfait;
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
		String idFraisForfait;
		String NomJustificatif;
		float MontantJustificatif;
		
		
		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
			idJustificatif = table.getInt("idJustificatif");
			idVisiteur= table.getString("idVisiteur");
			path = table.getString("path");
			idFraisForfait= table.getString("idFraisForfait");
			NomJustificatif = table.getString("NomJustificatif");
			MontantJustificatif = table.getFloat("MontantJustificatif");
			
			VisiteurDAO vd = new VisiteurDAO() ;
			Visiteur v = vd.findById(idVisiteur);
			FraisForfaitDAO ffd = new FraisForfaitDAO();
			FraisForfait ff = ffd.findById(idFraisForfait);
			
			
		
			
			Document listeDoc = new Document(ff, v);

			listeDoc.setIdJustificatif(idJustificatif);
			listeDoc.setPath(path);
			listeDoc.setIdVisiteur(v);
			listeDoc.setIdFraisForfait(ff);
			listeDoc.setNomJustificatif(NomJustificatif);
			listeDoc.setMontantJustificatif(MontantJustificatif);
			
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
		String idFraisForfait;
		String NomJustificatif;
		float MontantJustificatif;
		
		
		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
			idJustificatif = table.getInt("idJustificatif");
			idVisiteur= table.getString("idVisiteur");
			path = table.getString("path");
			idFraisForfait= table.getString("idFraisForfait");
			NomJustificatif = table.getString("NomJustificatife");
			MontantJustificatif = table.getFloat("MontantJustificatif");
			
			VisiteurDAO vd = new VisiteurDAO() ;
			Visiteur v = vd.findById(idVisiteur);
			FraisForfaitDAO ffd = new FraisForfaitDAO();
			FraisForfait ff = ffd.findById(idFraisForfait);
			
			
		
			
			Document listeDoc = new Document(ff, v);

			listeDoc.setIdJustificatif(idJustificatif);
			listeDoc.setPath(path);
			listeDoc.setIdVisiteur(v);
			listeDoc.setIdFraisForfait(ff);
			listeDoc.setNomJustificatif(NomJustificatif);
			listeDoc.setMontantJustificatif(MontantJustificatif);
			
			DocumentList.add(listeDoc);
			System.out.println(listeDoc);
		}
		
		
		return DocumentList;
}
}