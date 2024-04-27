package com.app.spotify.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtil {
	Logger logger = Logger.getLogger(DBUtil.class.getName());
	

	public Connection getConnection() throws SQLException {
		Connection connection;
		
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root",
				"Kavithas$9$9");
		logger.log(Level.INFO,"connection established");
		logger.log(Level.INFO,"connection {0}",connection);
		return connection;
	}
}
