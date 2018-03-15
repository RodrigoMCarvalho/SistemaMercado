package model.dao;

import java.sql.*;
import connection.ConnectionFactory;
import javax.swing.JOptionPane;
import view.TelaPrincipal;

public class UsuarioDAO {

    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean check = false;

    public boolean logar(String login, String senha) { //recebe dois parâmetros
        String sql = "SELECT * FROM usuario WHERE login=? AND senha =?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
                TelaPrincipal main = new TelaPrincipal();
                main.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou/e senha inválidos!");
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);;
        }

        return check;
    }

}
