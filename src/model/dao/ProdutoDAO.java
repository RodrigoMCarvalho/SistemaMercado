package model.dao;

import java.sql.*;
import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

public class ProdutoDAO {

    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;  //guarda o resultado de uma consulta no BD

    //método para cadastrar
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

    //método para listar os produtos na tabela
    public List<Produto> listar() {
        List<Produto> listProdutos = new ArrayList<>();  //criar uma lista de produtos
        String sql = "SELECT * FROM produto";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtd(rs.getInt("qtd"));
                p.setPreco(rs.getDouble("preco"));

                listProdutos.add(p);  //adicionar os valores na lista
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs); //finaliza a conexão
        }

        return listProdutos;  //retorna a lista de produtos
    }

    //método para alterar os dados dos produtos
    public void atualizar(Produto p) {
        String sql = "UPDATE produto SET descricao=?,qtd=?,preco=? WHERE id=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConncetion(conexao, stmt);
        }
    }

    public List<Produto> busca(String desc) {
        List<Produto> listBusca = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE descricao LIKE ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, desc + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtd(rs.getInt("qtd"));
                p.setPreco(rs.getDouble("preco"));

                listBusca.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listBusca;
    }

    //método para excluir produtos com o ID selecionado
    public void excluir(Produto p) {
        String sql = "DELETE FROM produto WHERE id=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConncetion(conexao, stmt); //fecha conexão
        }
    }

}
