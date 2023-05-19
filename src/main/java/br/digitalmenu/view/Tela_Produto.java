package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Categoria;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Tela_Produto extends Heuristica {

    String auxNome, auxCat, auxDesc, auxStatus;
    double auxPreco;

    Border border;

    public Tela_Produto() throws SQLException {
        initComponents();
        viewCategoria();
        txtId.setEnabled(false);
        
        jtProduto.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtProduto);//Formata a tabela e centraliza pela classe heuristicas
        listarJTableProdutosAtivados();
        border = txtformatPreco.getBorder();
    }

    public void listarJTableTodosProdutos() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto prod : prodDao.listarProduto()) {
            modelo.addRow(new Object[]{
                prod.getIdProduto(),
                prod.getNome(),
                prod.getCategoria().getNomeCategoria(),
                String.format("%.2f", prod.getPreco()),
                prod.getDescricao(),
                prod.getStatus()
            });
        }
    }

    public void listarJTableProdutosAtivados() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto prod : prodDao.listarProdutosAtivos()) {
            modelo.addRow(new Object[]{
                prod.getIdProduto(),
                prod.getNome(),
                prod.getCategoria().getNomeCategoria(),
                String.format("%.2f", prod.getPreco()),
                prod.getDescricao(),
                prod.getStatus()
            });
        }
    }

    public void listarJtablePorNome(String texto) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorNome(texto)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorFaixaDePreco(double valor1, double valor2) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorFaixaDePreco(valor1, valor2)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorDescricao(String palavra) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorDescricacao(palavra)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorCategoria(String nomeCategoria) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorCategoria(nomeCategoria)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorStatus(status)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void viewCategoria() throws SQLException {
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            cboxCategoria.addItem(categoria.getNomeCategoria());
        }
    }

    public void limparTxtFields() {
        txtId.setText("");
        txtNome.setText("");
        txtarea_Descricao.setText("");
        txtformatPreco.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlobalSuperiro = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        pnlEsquerdo = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        cboxCategoria = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_Descricao = new javax.swing.JTextArea();
        lblCategoria = new javax.swing.JLabel();
        txtformatPreco = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        pnlDireito = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_Pesquisa_Nome = new javax.swing.JButton();
        btn_Pesquisa_Preco = new javax.swing.JButton();
        btn_Pesquisa_Descricao = new javax.swing.JButton();
        btn_Pesquisa_Categoria = new javax.swing.JButton();
        btn_Pesquisa_Status = new javax.swing.JButton();
        btn_ListarTodosAtvios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        pnlGlobalSuperiro.setBackground(new java.awt.Color(255, 255, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        pnlEsquerdo.setBackground(new java.awt.Color(246, 242, 233));
        pnlEsquerdo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar categoria", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnlEsquerdo.setToolTipText("");
        pnlEsquerdo.setPreferredSize(new java.awt.Dimension(670, 181));

        btnSalvar.setBackground(new java.awt.Color(255, 243, 198));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnSalvar.setText("Cadastrar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNome.setText("Nome:");

        cboxCategoria.setBackground(new java.awt.Color(255, 232, 142));
        cboxCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDescricao.setText("Descrição:");

        txtarea_Descricao.setColumns(20);
        txtarea_Descricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtarea_Descricao.setLineWrap(true);
        txtarea_Descricao.setRows(5);
        jScrollPane2.setViewportView(txtarea_Descricao);

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCategoria.setText("Categoria:");

        txtformatPreco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblId.setText("ID:");

        lblPreco.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPreco.setText("Preço:");

        javax.swing.GroupLayout pnlEsquerdoLayout = new javax.swing.GroupLayout(pnlEsquerdo);
        pnlEsquerdo.setLayout(pnlEsquerdoLayout);
        pnlEsquerdoLayout.setHorizontalGroup(
            pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsquerdoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEsquerdoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlEsquerdoLayout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtNome)
                            .addComponent(txtId))
                        .addGap(36, 36, 36)
                        .addComponent(lblPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtformatPreco)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEsquerdoLayout.createSequentialGroup()
                        .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(156, 156, 156))))
        );
        pnlEsquerdoLayout.setVerticalGroup(
            pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsquerdoLayout.createSequentialGroup()
                .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(txtformatPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        pnlDireito.setBackground(new java.awt.Color(246, 242, 233));
        pnlDireito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnlDireito.setPreferredSize(new java.awt.Dimension(670, 181));

        btnDeletar.setBackground(new java.awt.Color(255, 153, 153));
        btnDeletar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDireitoLayout = new javax.swing.GroupLayout(pnlDireito);
        pnlDireito.setLayout(pnlDireitoLayout);
        pnlDireitoLayout.setHorizontalGroup(
            pnlDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDireitoLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(pnlDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(193, 193, 193))
        );
        pnlDireitoLayout.setVerticalGroup(
            pnlDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDireitoLayout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(pnlDireito, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(246, 242, 233));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_Pesquisa_Nome.setBackground(new java.awt.Color(255, 243, 198));
        btn_Pesquisa_Nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Pesquisa_Nome.setText("Nome");
        btn_Pesquisa_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_NomeActionPerformed(evt);
            }
        });

        btn_Pesquisa_Preco.setBackground(new java.awt.Color(255, 243, 198));
        btn_Pesquisa_Preco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Pesquisa_Preco.setText("Faixa de preço");
        btn_Pesquisa_Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_PrecoActionPerformed(evt);
            }
        });

        btn_Pesquisa_Descricao.setBackground(new java.awt.Color(255, 243, 198));
        btn_Pesquisa_Descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Pesquisa_Descricao.setText("Descrição");
        btn_Pesquisa_Descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_DescricaoActionPerformed(evt);
            }
        });

        btn_Pesquisa_Categoria.setBackground(new java.awt.Color(255, 243, 198));
        btn_Pesquisa_Categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Pesquisa_Categoria.setText("Categoria");
        btn_Pesquisa_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_CategoriaActionPerformed(evt);
            }
        });

        btn_Pesquisa_Status.setBackground(new java.awt.Color(255, 243, 198));
        btn_Pesquisa_Status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Pesquisa_Status.setText("Status");
        btn_Pesquisa_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_StatusActionPerformed(evt);
            }
        });

        btn_ListarTodosAtvios.setBackground(new java.awt.Color(255, 243, 198));
        btn_ListarTodosAtvios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ListarTodosAtvios.setText("Listar ativos");
        btn_ListarTodosAtvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListarTodosAtviosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(btn_Pesquisa_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Pesquisa_Preco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Pesquisa_Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Pesquisa_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Pesquisa_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ListarTodosAtvios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(351, 351, 351))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Pesquisa_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pesquisa_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pesquisa_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pesquisa_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pesquisa_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ListarTodosAtvios, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGlobalSuperiroLayout = new javax.swing.GroupLayout(pnlGlobalSuperiro);
        pnlGlobalSuperiro.setLayout(pnlGlobalSuperiroLayout);
        pnlGlobalSuperiroLayout.setHorizontalGroup(
            pnlGlobalSuperiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalSuperiroLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlGlobalSuperiroLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        pnlGlobalSuperiroLayout.setVerticalGroup(
            pnlGlobalSuperiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalSuperiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtProduto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Categoria", "Preço", "Descrição", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProduto.setRowHeight(30);
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtProdutoMouseReleased(evt);
            }
        });
        jtProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtProdutoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jScrollPane1)
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobalSuperiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGlobalSuperiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1416, 808));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutoKeyReleased

        if (jtProduto.getSelectedRow() != -1) {
            txtId.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txtNome.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            cboxCategoria.setSelectedItem(jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txtarea_Descricao.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 4).toString());
            txtformatPreco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
            //            checkboxStatus.setSelected(jtProduto.getValueAt(jtProduto.getSelectedRow(), 5).toString().equalsIgnoreCase("ativado"));
        }
    }//GEN-LAST:event_jtProdutoKeyReleased

    private void jtProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseReleased

        if (jtProduto.getSelectedRow() != -1) {
            txtId.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txtNome.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            cboxCategoria.setSelectedItem(jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txtarea_Descricao.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 4).toString());
            txtformatPreco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
            //            checkboxStatus.setSelected(jtProduto.getValueAt(jtProduto.getSelectedRow(), 5).toString().equalsIgnoreCase("ativado"));
            auxNome = txtNome.getText();
            auxPreco = Double.parseDouble(txtformatPreco.getText());
            auxCat = cboxCategoria.getSelectedItem().toString();
            auxDesc = txtarea_Descricao.getText();
            //            auxStatus = checkboxStatus.isSelected() ? "Ativado" : "Desativado";
        }
    }//GEN-LAST:event_jtProdutoMouseReleased

    private void btn_ListarTodosAtviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListarTodosAtviosActionPerformed
        try {
            listarJTableProdutosAtivados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_ListarTodosAtviosActionPerformed

    private void btn_Pesquisa_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_StatusActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione o status.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJTableTodosProdutos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_StatusActionPerformed

    private void btn_Pesquisa_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_CategoriaActionPerformed
        JPanel painel = new JPanel();
        painel.add(new JLabel("Categoria: "));
        painel.add(cboxCategoria);

        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione a categoria.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String categoria = String.valueOf(cboxCategoria.getSelectedItem());
                listarJtablePorCategoria(categoria);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos da categoria: " + categoria);
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_CategoriaActionPerformed

    private void btn_Pesquisa_DescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_DescricaoActionPerformed
        // TODO add your handling code here:
        String palavra = JOptionPane.showInputDialog("Palavra a pesquisar:");
        try {
            listarJtablePorDescricao(palavra);
            if (jtProduto.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Palavra não encontrada.");
                listarJTableProdutosAtivados();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_Pesquisa_DescricaoActionPerformed

    private void btn_Pesquisa_PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_PrecoActionPerformed
        // TODO add your handling code here:
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De:"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        myPanel.add(new JLabel("Até:"));
        myPanel.add(valorFinal);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Informe a faixa de preço", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double valor1 = Double.parseDouble(valorInicial.getText().replace(',', '.'));
                double valor2 = Double.parseDouble(valorFinal.getText().replace(',', '.'));
                listarJtablePorFaixaDePreco(valor1, valor2);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Faixa de preço não encontrada.");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_PrecoActionPerformed

    private void btn_Pesquisa_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_NomeActionPerformed
        JPanel painel = new JPanel();
        JLabel nomeProduto = new JLabel("Palavra: ");
        JTextField digitarPalavra = new JTextField(25);
        painel.add(nomeProduto);
        painel.add(digitarPalavra);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar produto", JOptionPane.OK_CANCEL_OPTION);
        String palavraPesquisar = digitarPalavra.getText();
        if (result == JOptionPane.OK_OPTION) {
            try {
                listarJtablePorNome(palavraPesquisar);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Palavra não encontrada.");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_NomeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto;
        try {
            produto = produtoDao.listarProdutoPorId(Integer.parseInt(txtId.getText()));
            Panel_Alterar_Produto pteste = new Panel_Alterar_Produto(produto);

            int opcao = JOptionPane.showConfirmDialog(null, pteste, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(pteste.getLbl_Id_Valor().getText()));
                p.setNome(pteste.getTxt_Nome_Novo().getText());
                p.setPreco(Double.parseDouble(pteste.getTxt_Preco_Novo().getText().replace(',', '.')));
                p.getCategoria().setNomeCategoria(pteste.getCbox_Categoria_Novo().getSelectedItem().toString());
                p.setDescricao(pteste.getTxtarea_Descricao_Novo().getText());
                p.setStatus(pteste.getCheckbox_Status_Novo().isSelected() ? "Ativado" : "Desativado");
                ProdutoDao pDao = new ProdutoDao();
                pDao.alterarProduto(p);
                listarJTableProdutosAtivados();
                limparTxtFields();

            } else if (opcao == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "cancelado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        if (jtProduto.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(this,
                "Deletar produto: "
                + "\nID: "
                + txtId.getText()
                + "\nNome: "
                + txtNome.getText(),
                "CONFIRMA DELEÇÃO?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (confirma == JOptionPane.YES_OPTION) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(txtId.getText()));
                ProdutoDao pDao = new ProdutoDao();
                try {
                    pDao.deletaProduto(p);
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
                    listarJTableProdutosAtivados();
                    limparTxtFields();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "operação cancelada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        boolean campo1 = verificarSeCampoEstaEmBranco(txtNome, "Nome");
        boolean campo2 = verificarSeCampoEstaEmBranco(txtformatPreco, "Preço");

        if (campo1 && campo2 == true) {

            Produto p = new Produto();
            p.setNome(txtNome.getText());
            p.setPreco(Double.parseDouble(txtformatPreco.getText().replace(',', '.')));
            p.setDescricao(txtarea_Descricao.getText());
            p.getCategoria().setNomeCategoria(cboxCategoria.getSelectedItem().toString());
            //        p.setStatus(checkboxStatus.isSelected() ? "Ativado" : "Desativado");
            ProdutoDao pDao = new ProdutoDao();
            try {
                pDao.createProduto(p);
                JOptionPane.showMessageDialog(null, "PRODUTO (" + p.getNome() + ") CRIADO COM SUCESSO!");
                listarJTableProdutosAtivados();

                txtformatPreco.setBorder(border);
                txtNome.setBorder(border);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cboxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxCategoriaActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Produto().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btn_ListarTodosAtvios;
    private javax.swing.JButton btn_Pesquisa_Categoria;
    private javax.swing.JButton btn_Pesquisa_Descricao;
    private javax.swing.JButton btn_Pesquisa_Nome;
    private javax.swing.JButton btn_Pesquisa_Preco;
    private javax.swing.JButton btn_Pesquisa_Status;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtProduto;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JPanel pnlDireito;
    private javax.swing.JPanel pnlEsquerdo;
    private javax.swing.JPanel pnlGlobalSuperiro;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtarea_Descricao;
    private javax.swing.JFormattedTextField txtformatPreco;
    // End of variables declaration//GEN-END:variables

}