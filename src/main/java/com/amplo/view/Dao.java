package com.amplo.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Evandro
 */
public class Dao {
	
	private static Connection conn;	
	private static boolean statusAutocommit;

    final static Logger LOGGER = LogManager.getLogger(Dao.class);
	
	public static Connection getConnection(String dbName) throws NamingException, SQLException, ClassNotFoundException {

		if (conn == null || conn.isClosed()) {

			try {
				LOGGER.info("Efetuando conexão...");
				String driver = "org.sqlite.JDBC";
				Class.forName(driver);
				//String dbName = "/mnt/amploviewDATA/amploview.db"; 
				String dbUrl = "jdbc:sqlite:" + dbName;
				LOGGER.info("dbUrl: " + dbUrl + "...");
				Connection conn = DriverManager.getConnection(dbUrl);
				statusAutocommit = conn.getAutoCommit();
				conn.setAutoCommit(true);
				LOGGER.info("Conexão Efetuada!");
			} catch (SQLException e) {
				LOGGER.error("Erro ao pegar uma conexão.");
				e.printStackTrace();
			}
			
		}
		return conn;		
	}

	public void finalize(Connection conn){
		try {
			LOGGER.info("Encerrando conexão...");
			conn.setAutoCommit(statusAutocommit);
			if (conn != null) conn.close();
			LOGGER.info("Conexão Encerrada!");
		} catch (SQLException e) {
			LOGGER.error("Erro ao tentar fechar a conexão.");
			e.printStackTrace();
		}
	}
	
}
