package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.VisiteurDAO;

import ClassAppliFrais.Visiteur;
import ClassAppliFrais.FraisForfait;
import ClassAppliFrais.Lignefraisforfait;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LigneFraisForfaitDAO implements DAO<Lignefraisforfait> {

	public ObservableList<Lignefraisforfait>  findById(String idV) throws SQLException {
		ObservableList<Lignefraisforfait> listeLigneFraisForfait = FXCollections.observableArrayList();
		String requeteSQL = "SELECT * FROM lignefraisforfait WHERE idVisiteur = ? ";
		Connection co = Connect.getInstance().getConnection();
		PreparedStatement pst = co.prepareStatement(requeteSQL);
		pst.setString(1, idV);
		String idVisiteur;
		String mois;
		String idFraisForfait;
		float Montant;
		int quantite;
		
			ResultSet pentoufle = pst.executeQuery();
		while(pentoufle.next()) {
			
			quantite = pentoufle.getInt("quantite");
			mois = pentoufle.getString("mois");
			Montant = pentoufle.getFloat("Montant");
			idVisiteur = pentoufle.getString("idVisiteur");
			VisiteurDAO vd = new VisiteurDAO() ;
			Visiteur v = vd.findById(idVisiteur);
			idFraisForfait = pentoufle.getString("idFraisForfait");
			FraisForfaitDAO ffd = new FraisForfaitDAO();
			FraisForfait ff = ffd.findById(idFraisForfait);
				Lignefraisforfait ligneFraisforfait = new Lignefraisforfait(v,ff);
			ligneFraisforfait.setMois(mois);
			ligneFraisforfait.setIdFraisForfait(ff);
			ligneFraisforfait.setIdVisiteur(v);
			ligneFraisforfait.setQuantite(quantite);
			ligneFraisforfait.setMontant(Montant);
			listeLigneFraisForfait.add(ligneFraisforfait);
				System.out.println(ligneFraisforfait);
			}
		
		
		
			return listeLigneFraisForfait;
	}
	
	@Override
	public ObservableList<Lignefraisforfait> findall() throws SQLException {
		ObservableList<Lignefraisforfait> ListeLigneFraisForfait = FXCollections.observableArrayList();
		String req = "SELECT * FROM lignefraisforfait ";
		Connection cnx = Connect.getInstance().getConnection();
		PreparedStatement pst = cnx.prepareStatement(req);
		
		String idVisiteur;
		String mois;
		String idFraisForfait;
		float Montant;
		int quantite;
		
			ResultSet table = pst.executeQuery();
			while (table.next()) {
		quantite = table.getInt("quantite");
		mois = table.getString("mois");
		Montant = table.getFloat("Montant");
		idVisiteur = table.getString("idVisiteur");
		VisiteurDAO vd = new VisiteurDAO() ;
		Visiteur v = vd.findById(idVisiteur);
		idFraisForfait = table.getString("idFraisForfait");
		FraisForfaitDAO ffd = new FraisForfaitDAO();
		FraisForfait ff = ffd.findById(idFraisForfait);
			Lignefraisforfait ligneFraisforfait = new Lignefraisforfait(v, ff);
		ligneFraisforfait.setMois(mois);
		ligneFraisforfait.setIdFraisForfait(ff);
		ligneFraisforfait.setIdVisiteur(v);
		ligneFraisforfait.setQuantite(quantite);
		ligneFraisforfait.setMontant(Montant);
		ListeLigneFraisForfait.add(ligneFraisforfait);
			System.out.println(ligneFraisforfait);
		}
		
		return ListeLigneFraisForfait;
	
	}

}


