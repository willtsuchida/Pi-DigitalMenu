package br.digitalmenu.view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import br.digitalmenu.dao.UsuarioDAO;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Usuario;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TelaUsuarios extends Heuristica {

    public TelaUsuarios() throws SQLException {
        initComponents();

        IniciaTabela(tblListaUsuarios);//Formata a tabela e centraliza pela classe heuristicas
        ListaTabela();
        //DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        //tblListaUsuarios.setRowSorter(new TableRowSorter(modelo));
       // ListaTabela();

    }

    public void ListaTabela() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblListaUsuarios.getModel();
        model.setNumRows(0);

        UsuarioDAO usuarios = new UsuarioDAO();
        for (Usuario UsuarioLocal : usuarios.listaTodosOsUsuarios()) {

            model.addRow(new Object[]{
                UsuarioLocal.getIdusuario(),
                UsuarioLocal.getUsuario(),
                UsuarioLocal.getSenha(),
                UsuarioLocal.getTipoacesso(),
                UsuarioLocal.getStatus(),});
        }

    }

    public void Limpar() {

        ((DefaultTableModel) tblListaUsuarios.getModel()).setRowCount(0);

        // Limpando campos Text
        txtUsuario.setText("");
        txtSenha.setText("");
        rdoGrupo1.clearSelection();

        //Deixando o focu no primeiro campo
        txtUsuario.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupo1 = new javax.swing.ButtonGroup();
        pnlGlobal = new javax.swing.JPanel();
        pnlTabelaConsulta = new javax.swing.JScrollPane();
        tblListaUsuarios = new javax.swing.JTable();
        pnlSuperior = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblTipoAcesso = new javax.swing.JLabel();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoPadrao = new javax.swing.JRadioButton();
        btnAdicionar = new javax.swing.JButton();
        pnlInferior = new javax.swing.JPanel();
        btnDesativar = new javax.swing.JButton();
        btnAtivar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");

        tblListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idusuario", "usuario", "senha", "tipoacesso", "status"
            }
        ));
        pnlTabelaConsulta.setViewportView(tblListaUsuarios);

        lblSenha.setText("Senha");

        lblUsuario.setText("Usuário");

        lblTipoAcesso.setText("Tipo de acesso");

        rdoGrupo1.add(rdoAdmin);
        rdoAdmin.setText("Admin");

        rdoGrupo1.add(rdoPadrao);
        rdoPadrao.setText("Atendente");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoAcesso)
                    .addGroup(pnlSuperiorLayout.createSequentialGroup()
                        .addComponent(rdoAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoPadrao)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblTipoAcesso)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoAdmin)
                        .addComponent(btnAdicionar)
                        .addComponent(rdoPadrao)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnDesativar.setText("Desativar");
        btnDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarActionPerformed(evt);
            }
        });

        btnAtivar.setText("Ativar");
        btnAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInferiorLayout = new javax.swing.GroupLayout(pnlInferior);
        pnlInferior.setLayout(pnlInferiorLayout);
        pnlInferiorLayout.setHorizontalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(btnAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesativar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInferiorLayout.setVerticalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInferiorLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesativar)
                    .addComponent(btnAtivar)
                    .addComponent(btnListar))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(485, 384));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed

        try {
            ListaTabela();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Usuario user = new Usuario();

        try {
            String usuario;
            String tipoAcesso = null;
            String senha;

            boolean campo1 = this.verificarSeCampoEstaEmBranco(txtUsuario, "Usuário");
            boolean campo2 = verificarSeCampoEstaEmBranco(txtSenha, "Senha");

            if (campo1 && campo1) {
                if (rdoGrupo1.getSelection() == null) { //se os tipos de acessos estiverem vazios      
                    JOptionPane.showMessageDialog(null, "Escolha o tipo de acesso!");
                    txtSenha.requestFocus();
                } else {
                    if (rdoAdmin.isSelected()) {
                        tipoAcesso = "administrador";
                    }

                    if (rdoPadrao.isSelected()) {
                        tipoAcesso = "atendente";
                    }

                    usuario = txtUsuario.getText();
                    usuario = usuario.toLowerCase();//faz o usuario ficar em letras minusculas

                    senha = txtSenha.getText();

                    user.setUsuario(usuario);
                    user.setSenha(senha);
                    user.setTipoacesso(tipoAcesso);
                    String status = "ativado";//##### COMO PADRÃO, O USUARIO SERÁ CRIADO ATIVADO  ######
                    user.setStatus(status);

                    UsuarioDAO userDAO = new UsuarioDAO();

                    userDAO.insereUsuario(user);
                    JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");

                    Limpar();
                    ListaTabela();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarActionPerformed
        if (tblListaUsuarios.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja confirmar a desativação do usuário " + String.valueOf(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0).toString()) + "?",
                    "Confirmar desativação?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirma == JOptionPane.YES_OPTION) {
                try {
                    UsuarioDAO userDAO = new UsuarioDAO();
                    Usuario user = new Usuario();

                    //fazendo a chamada do metodo para buscar por id
                    userDAO.buscaPorID((Integer.parseInt(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0).toString())), user);
                    user.setStatus("DESATIVADO");//######DESATIVA O USUARIO#####
                    userDAO.atualizaUsuario(user);//chama o metodo de atualizacao
                    JOptionPane.showMessageDialog(null, "Usuário desativado com sucesso!");
                    Limpar();
                    ListaTabela();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir.");
        }

    }//GEN-LAST:event_btnDesativarActionPerformed

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed
        if (tblListaUsuarios.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja confirmar a ativação do usuário " + String.valueOf(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0).toString()) + "?",
                    "Confirmar ativação?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirma == JOptionPane.YES_OPTION) {
                try {
                    UsuarioDAO userDAO = new UsuarioDAO();
                    Usuario user = new Usuario();

                    //fazendo a chamada do metodo para buscar por id
                    userDAO.buscaPorID((Integer.parseInt(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0).toString())), user);
                    user.setStatus("ATIVADO");//######ATIVA O USUARIO#####
                    userDAO.atualizaUsuario(user);//chama o metodo de atualizacao
                    JOptionPane.showMessageDialog(null, "Usuário desativado com sucesso!");
                    Limpar();
                    ListaTabela();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir.");
        }

    }//GEN-LAST:event_btnAtivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnDesativar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipoAcesso;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane pnlTabelaConsulta;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.ButtonGroup rdoGrupo1;
    private javax.swing.JRadioButton rdoPadrao;
    private javax.swing.JTable tblListaUsuarios;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
