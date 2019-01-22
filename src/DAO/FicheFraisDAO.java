package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import ClassAppliFrais.LigneFraisHorsForfait;
import ClassAppliFrais.Etat;
import ClassAppliFrais.FicheFrais;
import ClassAppliFrais.Visiteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
	
public class FicheFraisDAO {
	
public static ObservableList<FicheFrais> findByMois(String mois2) throws SQLException {
		ObservableList<FicheFrais> FicheFraisList = FXCollections.observableArrayList();
		String requeteSQL = "SELECT * FROM fichefrais WHERE mois = ? ";
		Connection co = Connect.getInstance().getConnection();
		PreparedStatement pst = co.prepareStatement(requeteSQL);
		pst.setString(1, mois2);
		
		String mois;
		int nbJustificatifs;
		Date dateModif;
		String idEtat;
		String idVisiteur;
		float montantValide;
		
			ResultSet table = pst.executeQuery();
			while (table.next()) {
			
		mois = table.getString("mois");
		nbJustificatifs = table.getInt("nbJustificatifs");
		dateModif = table.getDate("dateModif");
		idEtat = table.getString("idEtat");
		idVisiteur = table.getString("idVisiteur");
		montantValide = table.getFloat("montantValide");
		VisiteurDAO vd = new VisiteurDAO() ;
		Visiteur v = vd.findById(idVisiteur);
		EtatDAO ed = new EtatDAO();
		Etat e = ed.findById(idEtat);
		LigneFraisHorsForfaitDAO ld = new LigneFraisHorsForfaitDAO();
		LigneFraisHorsForfait l = ld.findById(montantValide);
			FicheFrais listeFicheFrais = new FicheFrais(v, l, e);
			
		listeFicheFrais.setMois(mois);
		listeFicheFrais.setNbJustificatifs(nbJustificatifs);
		listeFicheFrais.setDateModif(dateModif);
		listeFicheFrais.setIdVisiteur(v);
		listeFicheFrais.setIdEtat(e);
		listeFicheFrais.setMontantValide(l);
			FicheFraisList.add(listeFicheFrais);
			System.out.println(listeFicheFrais);
		}
		
		return FicheFraisList;
	}




	public static ObservableList<FicheFrais> findall() throws SQLException {
		ObservableList<FicheFrais> FicheFraisList = FXCollections.observableArrayList();
		String req = "SELECT * FROM fichefrais";
		Connection cnx = Connect.getInstance().getConnection();
		PreparedStatement pst = cnx.prepareStatement(req);
		
		
		String mois;
		int nbJustificatifs;
		Date dateModif;
		String idEtat;
		String idVisiteur;
		float montantValide;
		
			ResultSet table = pst.executeQuery();
			while (table.next()) {
			
		mois = table.getString("mois");
		nbJustificatifs = table.getInt("nbJustificatifs");
		dateModif = table.getDate("dateModif");
		idEtat = table.getString("idEtat");
		idVisiteur = table.getString("idVisiteur");
		montantValide = table.getFloat("montantValide");
		VisiteurDAO vd = new VisiteurDAO() ;
		Visiteur v = vd.findById(idVisiteur);
		EtatDAO ed = new EtatDAO();
		Etat e = ed.findById(idEtat);
		LigneFraisHorsForfaitDAO ld = new LigneFraisHorsForfaitDAO();
		LigneFraisHorsForfait l = ld.findById(montantValide);
			FicheFrais listeFicheFrais = new FicheFrais(v, l, e);
			
		listeFicheFrais.setMois(mois);
		listeFicheFrais.setNbJustificatifs(nbJustificatifs);
		listeFicheFrais.setDateModif(dateModif);
		listeFicheFrais.setIdVisiteur(v);
		listeFicheFrais.setIdEtat(e);
		listeFicheFrais.setMontantValide(l);
			FicheFraisList.add(listeFicheFrais);
			System.out.println(listeFicheFrais);
		}
		
		return FicheFraisList;
	}
public static boolean updateFiche(String idVisiteur, String mois) throws SQLException{ 
		
		String reqUpdate = "UPDATE `fichefrais` SET `dateModif`=?,`idEtat`= ? WHERE idVisiteur = ? AND mois=?";
		Connection cxUpdate =  Connect.getInstance().getConnection() ;
		PreparedStatement pstUpdate = cxUpdate.prepareStatement(reqUpdate);
		String dateModif = String.valueOf( LocalDate.now());
		pstUpdate.setString(1,dateModif);
		pstUpdate.setString(2, "VA");
		pstUpdate.setString(3, idVisiteur);
		pstUpdate.setString(4, mois);
		boolean i = pstUpdate.execute();
		
		
		
	return i;
	
	
	
	
		}



}