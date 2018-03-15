package view;

import java.sql.*;
import connection.ConnectionFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Produto;
import model.dao.ProdutoDAO;

/**
 *
 * @author rodri_000
 */
public class TelaCadastroUsuario extends javax.swing.JInternalFrame {

    Connection conexao;

    public TelaCadastroUsuario() {
        initComponents();
        conexao = ConnectionFactory.getConnection(); //inicializa a conexão com o BD
        listaTabela(); //lista o conteúdo da tabela
        DefaultTableModel modelo = (DefaultTableModel) jtbTabela.getModel();
        jtbTabela.setRowSorter(new TableRowSorter(modelo));    //ordena os dados da tabela clicando no título
    }

    //método para ao selecionar uma linha na tabela, os dados são preenchidos nos campos do formulário
    //necessário adicionar o evento Mouseclicked na tabela. Vide mais abaixo.
    private void setarDados() {
        int setar = jtbTabela.getSelectedRow();

        txtDesc.setText(jtbTabela.getModel().getValueAt(setar, 1).toString());
        txtQtd.setText(jtbTabela.getModel().getValueAt(setar, 2).toString());
        txtPreco.setText(jtbTabela.getModel().getValueAt(setar, 3).toString());
    }

    public void limparCampos() {
        txtDesc.setText(null);
        txtPreco.setText(null);
        txtQtd.setText(null);
    }

    public void listaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jtbTabela.getModel();

        modelo.setNumRows(0); //para não mostrar duplicados

        ProdutoDAO dao = new ProdutoDAO();

        for (Produto p : dao.listar()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getQtd(),
                p.getPreco()
            });
        }
    }

    //realizar a busca por descrição
    public void buscaDesc(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jtbTabela.getModel();

        modelo.setNumRows(0);

        ProdutoDAO dao = new ProdutoDAO();

        for (Produto p : dao.busca(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getQtd(),
                p.getPreco()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(600, 415));
        setMinimumSize(new java.awt.Dimension(600, 415));
        setPreferredSize(new java.awt.Dimension(600, 415));

        jLabel1.setText("DESCRIÇÃO");

        jLabel2.setText("QUANTIDADE");

        jLabel3.setText("PREÇO");

        jtbTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Quantidade", "Preço"
            }
        ));
        jtbTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTabela);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Atualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreco)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBusca)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 612, 429);
    }// </editor-fold>//GEN-END:initComponents

    //método para cadastrar ( create )
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtDesc.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQtd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!");
        } else {
            Produto p = new Produto(); //para alterar os dados em Produto
            ProdutoDAO dao = new ProdutoDAO(); //para inserir no BD

            p.setDescricao(txtDesc.getText());
            p.setQtd(Integer.parseInt(txtQtd.getText()));  //converter String para Int
            p.setPreco(Double.parseDouble(txtPreco.getText().replace(",", ".")));  //converter String para Double

            dao.inserir(p); //inserir no BD
            listaTabela(); //mostra os dados na tabela
            limparCampos();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //método para alterar ( update)
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int setar = jtbTabela.getSelectedRow();

        if (txtDesc.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQtd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!");
        }
        if (jtbTabela.getSelectedRow() != -1) {  //se a linha estiver selecionada
            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setDescricao(txtDesc.getText());
            p.setQtd(Integer.parseInt(txtQtd.getText()));
            p.setPreco(Double.parseDouble(txtPreco.getText().replace(",", ".")));

            //pegar o ID a partir da linha selecionada
            p.setId((int) jtbTabela.getModel().getValueAt(setar, 0)); //convertido objeto para inteiro (int)

            dao.atualizar(p);
            listaTabela();
            limparCampos();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtbTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTabelaMouseClicked

        setarDados();
    }//GEN-LAST:event_jtbTabelaMouseClicked

    //método para excluir
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int setar = jtbTabela.getSelectedRow();
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do produto?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            //pegar o ID a partir da linha selecionada
            p.setId((int) jtbTabela.getModel().getValueAt(setar, 0)); //convertido objeto para inteiro (int)

            dao.excluir(p); //chama o médoto excluir
            listaTabela(); //atualiza a tabela após a exclusão
            limparCampos(); //limpa os campos dos dados excluídos
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

        buscaDesc(txtBusca.getText());

    }//GEN-LAST:event_btnBuscaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbTabela;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
