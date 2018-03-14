package model.dao;

import java.sql.*;
import connection.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

public class ProdutoDAO {

    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    public void inserir(Produto p) {
        String sql = "INSERT INTO produto (descricao,qtd,preco) VALUES (?,?,?) ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConncetion(conexao, stmt); //fechando as conexões
        }

    }

}
