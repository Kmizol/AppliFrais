package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ComptableDAO {

	

	public static boolean auth(String txtLogin, String txtMdp)throws SQLException {
		Connection cnx = Connect.getInstance().getConnection() ;
		// TODO Auto-generated method stub
		PreparedStatement statement = cnx.prepareStatement("SELECT login,mdp FROM comptable WHERE login = ? AND mdp = ?");
		
		statement.setString(1, txtLogin);
		statement.setString(2, txtMdp);
		ResultSet verif = statement.executeQuery();
		
		while (verif.next()) {
			
			System.out.println("SLT :D"); 
		
		return true;
	}
		return false;
	}
	

	
	}
		
	


