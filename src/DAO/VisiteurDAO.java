package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassAppliFrais.Visiteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisiteurDAO {

	
	public static ObservableList<Visiteur> findall() throws SQLException {
		ObservableList<Visiteur> VisiteurList = FXCollections.observableArrayList();
		String req = "SELECT * FROM visiteur";
		Connection cnx = Connect.getInstance().getConnection();
		PreparedStatement pst = cnx.prepareStatement(req);
		
		String id; 
		String nom;
		String prenom;
		String login;
		String mdp;
		String adresse;
		String cp;
		String ville;
		Date dateEmbauche;
		
		
		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
			id = table.getString("id");
			nom = table.getString("nom");
			prenom = table.getString("prenom");
			login = table.getString("login");
			mdp = table.getString("mdp");
			adresse = table.getString("adresse");
			cp = table.getString("cp");
			ville = table.getString("ville");
			dateEmbauche = table.getDate("dateEmbauche");
			
			
			Visiteur listeVisiteur = new Visiteur();

			listeVisiteur.setId(id);
			listeVisiteur.setNom(nom);
			listeVisiteur.setPrenom(prenom);
			listeVisiteur.setLogin(login);
			listeVisiteur.setMdp(mdp);
			listeVisiteur.setAdresse(adresse);
			listeVisiteur.setCp(cp);
			listeVisiteur.setVille(ville);
			listeVisiteur.setDateEmbauche(dateEmbauche);
			VisiteurList.add(listeVisiteur);
			System.out.println(listeVisiteur);
		}
		
		
		return VisiteurList;
	}
	
	
	
	
	
	
	
	
	
	public Visiteur findById(String id) throws SQLException {
		
		String requeteSQL = "SELECT * FROM visiteur WHERE id = ? ";
		Connection co = Connect.getInstance().getConnection();
		PreparedStatement pst = co.prepareStatement(requeteSQL);
		pst.setString(1, id);
		Visiteur v = new Visiteur();
		ResultSet jeu =pst.executeQuery();
		//  `id`, `nom`, `prenom`, `login`, `mdp`, `adresse`, `cp`, `ville`, `dateEmbauche`
		while(jeu.next()) {
		v.setId(jeu.getString("id"));
		v.setNom(jeu.getString("nom"));
		v.setPrenom(jeu.getString("prenom"));
		v.setLogin(jeu.getString("login"));
		v.setMdp(jeu.getString("mdp"));
		v.setAdresse(jeu.getString("adresse"));
		v.setCp(jeu.getString("cp"));
		v.setVille(jeu.getString("ville"));
		v.setDateEmbauche(jeu.getDate("dateEmbauche"));
		
		}
		return v;
	}

	

}
