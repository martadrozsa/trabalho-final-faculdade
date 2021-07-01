package view.telaPesquisa;

import controller.PacienteController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class TelaPesquisa extends javax.swing.JFrame {

    PacienteController controlador;
    DefaultListModel modeloLista;
    String[][] matrizPacientes;
    String id;
    
    int indiceLista;
    
    public TelaPesquisa() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        controlador = new PacienteController();
        modeloLista = new DefaultListModel();
        lstResultado.setModel(modeloLista);
        lstResultado.setVisible(false);
    }

    public void listarResultado() {
        //limpa a lista caso ja tenha sido preenchida
        //preeche a matriz com os dados do banco
        //usei um arraylist pra botar os nomes da matriz na lista de resultado
        //se a lista vier vazia ela exibe "Sem resultado"
    
        modeloLista.clear();
        matrizPacientes = controlador.getMinhaMatrizTexto(txtPesquisa.getText());

        ArrayList<String> nomes = new ArrayList<>();
        
        int tamanhoMatriz = 0;//matrizPacientes.length;
        
        if (tamanhoMatriz != 0) {
            
            for (int i = 0; i < tamanhoMatriz; i++) {
                nomes.add(matrizPacientes[i][1]);
            }
            
            nomes.forEach(nome -> {
            //    modeloLista.setSize(tamanhoMatriz);
                modeloLista.addElement(nome);
            }); 
            // isso é um forEach escrito com lambda
            // para cada nome presente no arraylist nomes
            // ele da um addElement na listaModelo passando o nome
            
        } else {
            modeloLista.clear();
            lstResultado.setVisibleRowCount(1);
            modeloLista.addElement("Sem resultado");
        }
        
    }
    
    public void preencherCampos() {
        //esse indice vem la do metodo lstResultadoMouseClicked
        //quando voce clica na lista ele pega o indice pela posição
        //esse metodo é chamado pelo lstResultadoMouseClicked ele preencheCampos :)
        //o metodo Util.conversorData pega o texto que vem do banco e transforma
        //em Date, ele vem yyyy-MM-dd e vira Date, **olhe a classe Util
        
        int j = indiceLista; // apenas para legibilidade
        
        String nome =         matrizPacientes[j][1];
        String stringData =   matrizPacientes[j][2];
        String endereco =     matrizPacientes[j][3];
        String telefone =     matrizPacientes[j][4];
       
        txtNome.setText(nome);
        txtEndereco.setText(endereco);
        txtTelefone.setText(telefone);
        dtChooser.setDate(Util.conversorData(stringData));

    }
    
    public void preencherCampos(String nome, String stringData, String endereco, String telefone) {
        //esse metodo é chamado quando  TelaTabela está sendo usada pra seleção
        //ele faz a mesma coisa que o de cima, só que pega os dados "mastigados" 
        //pelo metodo tabelaGraficaMouseClicked que está la embaixo
        
        txtNome.setText(nome);
        txtEndereco.setText(endereco);
        txtTelefone.setText(telefone);
        dtChooser.setDate(Util.conversorData(stringData));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaTabela = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGrafica = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtPesquisa = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        dtChooser = new com.toedter.calendar.JDateChooser();
        btnLimpar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        lstResultado = new javax.swing.JList<>();

        TelaTabela.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        TelaTabela.setMaximumSize(new java.awt.Dimension(569, 377));
        TelaTabela.setMinimumSize(new java.awt.Dimension(569, 377));
        TelaTabela.setResizable(false);

        tabelaGrafica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Data de Nascimento", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaGrafica.setColumnSelectionAllowed(true);
        tabelaGrafica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaGraficaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaGrafica);

        javax.swing.GroupLayout TelaTabelaLayout = new javax.swing.GroupLayout(TelaTabela.getContentPane());
        TelaTabela.getContentPane().setLayout(TelaTabelaLayout);
        TelaTabelaLayout.setHorizontalGroup(
            TelaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        TelaTabelaLayout.setVerticalGroup(
            TelaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 211, 185));

        lblNome.setBackground(java.awt.Color.lightGray);
        lblNome.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(1, 1, 1));
        lblNome.setText("Nome");
        lblNome.setOpaque(true);
        lblNome.setPreferredSize(new java.awt.Dimension(36, 16));

        lblData.setBackground(java.awt.Color.lightGray);
        lblData.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(1, 1, 1));
        lblData.setText("Data de Nascimento");
        lblData.setOpaque(true);
        lblData.setPreferredSize(new java.awt.Dimension(36, 16));

        lblEndereco.setBackground(java.awt.Color.lightGray);
        lblEndereco.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(1, 1, 1));
        lblEndereco.setText("Endereço");
        lblEndereco.setOpaque(true);
        lblEndereco.setPreferredSize(new java.awt.Dimension(36, 16));

        lblTelefone.setBackground(java.awt.Color.lightGray);
        lblTelefone.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(1, 1, 1));
        lblTelefone.setText("Telefone");
        lblTelefone.setOpaque(true);
        lblTelefone.setPreferredSize(new java.awt.Dimension(36, 16));

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");

        btnCadastrar.setText("Cadastrar");

        btnListar.setText("Exibir Tabela");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        lstResultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstResultado.setVisibleRowCount(5);
        lstResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstResultadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLimpar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCadastrar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome)
                                    .addComponent(txtEndereco)
                                    .addComponent(dtChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lstResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lstResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(dtChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        //serve pra capturar a tecla enter, preenche a lista usando o a matriz
        //o metodo listarResultado fica encarregado de capturar oque foi pesquisado
        //deixa a lista visivel que mostra os nomes 
        
        listarResultado();
        lstResultado.setVisible(true);
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void lstResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstResultadoMouseClicked
        //serve pra pegar o nome na lista usando a posição (indice)
        //chama o metodo preencher que usa o indice pra definir quem foi clicado
        //esconde a lista
        
        indiceLista = lstResultado.getSelectedIndex();
        preencherCampos();
        lstResultado.setVisible(false);
    }//GEN-LAST:event_lstResultadoMouseClicked

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        //serve pra esconder a lista se digitar (excessão a tecla enter)
        //botei esse metodo pensando na tecla esc mas ele pega toda digitação
        
        lstResultado.setVisible(false);
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        //metodo alternativo para exibir tela com a tabela de resultados
        //TelaTabela é um JFrame adicional que está em Outros Componentes
        //exibe a telaTabela, o setLocation...(null) bota essa tela bem no meio
        
        matrizPacientes = controlador.getMinhaMatrizTexto(txtPesquisa.getText());
        carregaTabela(matrizPacientes);
        TelaTabela.setVisible(true);
        TelaTabela.setLocationRelativeTo(null);  
    }//GEN-LAST:event_btnListarActionPerformed
    
    public void carregaTabela(String[][] matrizPacientes) {
        //roubei esse metodo do professor, ele preenche a JTable da TelaTabela
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaGrafica.getModel();
        modelo.setNumRows(0);

        String matrizAqui[][] = matrizPacientes;
        for (int i = 0; i < matrizAqui.length; i++) {
            modelo.addRow(new Object[]{
                matrizAqui[i][1],
                matrizAqui[i][2],
                matrizAqui[i][3],
                matrizAqui[i][4]
            });
        }
    }
    
    private void tabelaGraficaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaGraficaMouseClicked
        //captura o clique na tabela da TelaTabela
        //esse evt.getClickC... pega apenas o clique duplo, sem ele um clique
        //iria disparar o metodo completo sem chance para erro de mouse na seleção
        //ele pega o conteudo da tabela mesmo e chama uma sobrecarga do metodo 
        //preencherCampos, passando o conteudo da tabela como argumentos
        //o TelaTabela.dispose() esconde a telaTabela quando o item é selecinado
        
        if(evt.getClickCount() == 2) {
            String nome = "";
            String data = "";
            String endereco = "";
            String telefone = "";
        
            if (this.tabelaGrafica.getSelectedRow() != -1) {
                nome =     tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 0).toString();            
                data =     tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 1).toString();
                endereco = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 2).toString();
                telefone = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 3).toString();
            }
            else {
                System.out.println("erro");
            }
            preencherCampos(nome, data, endereco, telefone);
            TelaTabela.dispose();
        }       
        
    }//GEN-LAST:event_tabelaGraficaMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //limpa os campos e a variavel que guarda o id;
        
        txtPesquisa.setText("");
        txtNome.setText("");
        dtChooser.cleanup();
        txtEndereco.setText("");
        txtTelefone.setText("");               
    }//GEN-LAST:event_btnLimparActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame TelaTabela;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private com.toedter.calendar.JDateChooser dtChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList<String> lstResultado;
    private javax.swing.JTable tabelaGrafica;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
