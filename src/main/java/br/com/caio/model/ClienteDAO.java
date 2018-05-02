package br.com.caio.model;

import br.com.caio.dto.ClienteDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;


    /**
     *
     CREATE TABLE `cliente` (
     `id` int NOT NULL AUTO_INCREMENT,
     `nome` varchar(255) NOT NULL,
     PRIMARY KEY (`id`),
     UNIQUE KEY `cliente_id_UNIQUE` (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1

     */

    public ClienteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public static void main(String[] args) throws Exception {
        ClienteDAO cliente = new ClienteDAO("jdbc:mysql://localhost:3306/teste_cliente","root","123");
        cliente.connect();
        cliente.update(new ClienteDTO(11L,"CAIO"));
        cliente.disconnect();
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insert(ClienteDTO cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome) VALUES (?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<ClienteDTO> listAll() throws SQLException {
        List<ClienteDTO> listRet = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String nome = resultSet.getString("nome");

            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(id);
            clienteDTO.setNome(nome);
            //TODO implementar o resto
            listRet.add(clienteDTO);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listRet;
    }

    public boolean deleteBook(ClienteDTO clienteDTO) throws SQLException {
        String sql = "DELETE FROM cliente where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, clienteDTO.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean update(ClienteDTO clienteDTO) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, clienteDTO.getNome());
        statement.setLong(2, clienteDTO.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public ClienteDTO getCliente(Long id) throws SQLException {
        ClienteDTO clienteDTO = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            clienteDTO = new ClienteDTO(id, nome);
        }

        resultSet.close();
        statement.close();

        return clienteDTO;
    }
}