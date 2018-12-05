package br.com.drupalcommerce.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class HelperDAO {
	public static void getConn(Connection conn, Statement st) throws SQLException, ClassNotFoundException {
		conn = DatabaseLocator.getInstance().getConnection();
		st = conn.createStatement();
	}
}
