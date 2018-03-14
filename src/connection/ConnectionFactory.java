package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbmercado";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //estabelecer conexão com o BD
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro:" + ex);
        }
    }

    //método para fechar a conexão (Connection)
    public static void closeConnection(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
            }
        }
    }

    //método para fechar a conexão(PreparedStatement)(Sobrecarga)
    public static void closeConncetion(Connection conexao, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
            closeConnection(conexao);
        }
    }

    //método para fechar a conexão(ResultSet)(Sobrecarga)
    public static void closeConnection(Connection conexao, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
            }
            closeConncetion(conexao, stmt);
        }
    }

}
