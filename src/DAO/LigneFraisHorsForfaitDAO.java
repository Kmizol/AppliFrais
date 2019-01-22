package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.VisiteurDAO;

import ClassAppliFrais.Visiteur;
import ClassAppliFrais.LigneFraisHorsForfait;
import javafx.collections.ObservableList;

public class LigneFraisHorsForfaitDAO implements DAO<LigneFraisHorsForfait> {

	public LigneFraisHorsForfait findById(float montantValide) throws SQLException {
		
		String requeteSQL = "SELECT * FROM lignefraishorsforfait WHERE montant = ? ";
		Connection co = Connect.getInstance().getConnection();
		PreparedStatement pst = co.prepareStatement(requeteSQL);
		pst.setFloat(1, montantValide);
		//`id`, `idVisiteur`, `mois`, `libelle`, `date`, `montant`

		LigneFraisHorsForfait v = new LigneFraisHorsForfait(null);
		
			ResultSet carrote = pst.executeQuery();
		while(carrote.next()) {
			v.setId(carrote.getInt("id"));
			v.setMois(carrote.getInt("mois"));
			v.setLibelle(carrote.getString("libelle"));
			v.setDate(carrote.getDate("date"));
			v.setMontant(carrote.getFloat("montant"));
			VisiteurDAO vd = new VisiteurDAO() ;
			Visiteur visiteur= vd.findById(carrote.getString("idVisiteur"));
			v.setIdVisiteur(visiteur);
			
		}
		
		
		
			return v;
	}
	
	@Override
	public ObservableList<LigneFraisHorsForfait> findall() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
