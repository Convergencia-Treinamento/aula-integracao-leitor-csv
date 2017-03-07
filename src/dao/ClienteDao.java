package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDao {

    Cliente c = new Cliente();

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String PASSWORD = "";
    private static final String USER = "postgres";
    private static final String URL = "jdbc:postgresql:excel";

    public void inserir(Cliente c) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {

            Class.forName(DRIVER);
            PreparedStatement pstmt = con.prepareStatement("insert into pessoa(id, nome, cpfcnpj) values (?, ?, ?) ");
            pstmt.setInt(1, c.getId());
            pstmt.setString(2, c.getNome());
            pstmt.setString(3, c.getCpfcnpj());
            pstmt.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
