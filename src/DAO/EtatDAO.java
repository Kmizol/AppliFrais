package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassAppliFrais.Etat;
import ClassAppliFrais.Visiteur;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class EtatDAO implements DAO<Etat> {
		
		public Etat findById(String id) throws SQLException {
			
			String requeteSQL = "SELECT * FROM etat WHERE id = ? ";
			Connection co = Connect.getInstance().getConnection();
			PreparedStatement pst = co.prepareStatement(requeteSQL);
			pst.setString(1,id);
			ResultSet patate = pst.executeQuery();
			Etat v = new Etat();
			while(patate.next()) {
				v.setId(patate.getString("id"));
				v.setLibelle(patate.getString("libelle"));
			}
			System.out.println(v.getId());
			return v;
		}

		@Override
		public ObservableList<Etat> findall() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
}
