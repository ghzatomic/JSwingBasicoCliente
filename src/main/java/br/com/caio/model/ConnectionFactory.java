package br.com.caio.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	private boolean conectado;
    
	public ConnectionFactory(String jdbcURL, String jdbcUsername, String jdbcPassword) throws Exception {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	public Connection getConexao() throws Exception{
		if (jdbcConnection == null || jdbcConnection.isClosed()){
			connect();
		}
		return this.jdbcConnection;
	}
	
	public void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
            conectado = true;
        }
    }

    public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
            conectado = false;
        }
    }


	public boolean isConectado() {
		return conectado;
	}
	
}
