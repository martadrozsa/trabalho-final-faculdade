package view.telaMedico.telaEdicaoExclusaoMedico;

import controller.MedicoController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class TelaEdicaoExclusaoMedico extends javax.swing.JFrame {

    MedicoController controlador;
    DefaultListModel modeloLista;
    String[][] matrizMedicos;
    Map<Integer, String> idsCapturados;
    int indiceLista;
    
    
    
    public TelaEdicaoExclusaoMedico() {
        initComponents();
        controlador = new MedicoController();
        modeloLista = new DefaultListModel();
        idsCapturados = new HashMap<>();
        
        listaPesquisa.setModel(modeloLista);
        listaPesquisa.setVisible(false);
        
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
        
    }

    public void preencherLista() {
        
        modeloLista.clear();
        
        preencherMatriz(true);
        
        List<String> nomes = new ArrayList<>();
        
        int tamanhoMatriz = matrizMedicos.length;
        
        if(tamanhoMatriz != 0) {
            
            for(int i = 0; i < tamanhoMatriz; i++) {
                nomes.add(matrizMedicos[i][1]);
            }
            listaPesquisa.setVisibleRowCount(nomes.size());
            nomes.forEach(nome -> {
                modeloLista.addElement(nome);
            });
        } else {
            modeloLista.clear();
            listaPesquisa.setVisibleRowCount(1);
            modeloLista.addElement("Sem resultado");
        }
        
    }
    
    public void preencherMatriz(boolean flag) {
        if(flag) {
            matrizMedicos = controlador.getMinhaMatrizTexto(txtPesquisa.getText());
        } else {
            matrizMedicos = controlador.getMinhaMatrizTexto();
        }
        for(int i = 0; i < matrizMedicos.length; i++) {
            String capturaId = matrizMedicos[i][0];
            idsCapturados.put(i, capturaId);
        }
    }
    
    public int getIdFromMap() {
        int id;
        if(indiceLista != -1) {
            id = Integer.parseInt(idsCapturados.get(indiceLista));
        } else {
            id = -1;
            System.out.println("Erro na captura do id metodo getIdFromMap");
        }
        return id;
    }
    
    public void preencherCampos() {
        
        int i = indiceLista;
        
        String nome =           matrizMedicos[i][1];
        String telefone =       matrizMedicos[i][2];
        String crm =            matrizMedicos[i][3];
        String especialidade =  matrizMedicos[i][4];
        //tratar os debaixo pra entrar nos comboBox
        String periodo =        matrizMedicos[i][5];
        String consultorio =    matrizMedicos[i][6];
        
        txtNome.setText(nome);
        txtTelefone.setText(telefone);
        txtCRM.setText(crm);
        txtEspecialidade.setText(especialidade);
        
        //tratamento -------------------  não testado        
        preencherCombos(periodo, consultorio);
        btnEditar.setEnabled(true);
        btnApagar.setEnabled(true);
                
    }
    
    public void preencherCampos(String nome, String crm, String especialidade, 
            String periodo, String consultorio, String telefone) {
        
        txtNome.setText(nome);
        txtCRM.setText(crm);
        txtEspecialidade.setText(especialidade);
        txtTelefone.setText(telefone);
        
        preencherCombos(periodo, consultorio);
        btnEditar.setEnabled(true);
        btnApagar.setEnabled(true);
    }
    
    public void preencherCombos(String periodo, String consultorio) {
        
        if(periodo.equals("MATUTINO")) {
            cmbPeriodo.setSelectedIndex(0);
        } else if(periodo.equals("VESPERTINO")) {
            cmbPeriodo.setSelectedIndex(1);
        } else {
            cmbPeriodo.setSelectedIndex(-1);
            System.out.println("Erro na captura do periodo pro CMB");
        }
        
        if(consultorio.equals("CONSULTORIO_1")) {
            cmbConsultorio.setSelectedIndex(0);
        } else if(consultorio.equals("CONSULTORIO_2")) {
            cmbConsultorio.setSelectedIndex(1);
        } else {
            cmbConsultorio.setSelectedIndex(-1);
            System.out.println("Erro na captura do consultorio pro CMB");
        }
    }
    
    public void carregaTabela() {
        //roubei esse metodo do professor, ele preenche a JTable da TelaTabela
        //chamado no btnListarActionPerformed
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaGrafica.getModel();
        modeloTabela.setNumRows(0);
        //id nome telefone crm espec periodo consultorio
        for (int i = 0; i < matrizMedicos.length; i++) {
            modeloTabela.addRow(new Object[]{
                matrizMedicos[i][1],
                matrizMedicos[i][3],
                matrizMedicos[i][4],
                matrizMedicos[i][5],
                matrizMedicos[i][6],
                matrizMedicos[i][2],
                
            });
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaTabela = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGrafica = new javax.swing.JTable();
        pnlPesquisa = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        listaPesquisa = new javax.swing.JList<>();
        pnlCampos = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCRM = new javax.swing.JLabel();
        lblEspecialidade = new javax.swing.JLabel();
        lblConsultorio = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCRM = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEspecialidade = new javax.swing.JTextField();
        lblPeriodo1 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox<>();
        cmbConsultorio = new javax.swing.JComboBox<>();
        pnlEditar = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        telaTabela.setMinimumSize(new java.awt.Dimension(630, 256));

        tabelaGrafica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CRM", "Especialidade", "Período", "Consultório", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaGrafica.setColumnSelectionAllowed(true);
        tabelaGrafica.getTableHeader().setReorderingAllowed(false);
        tabelaGrafica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaGraficaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaGrafica);
        tabelaGrafica.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout telaTabelaLayout = new javax.swing.GroupLayout(telaTabela.getContentPane());
        telaTabela.getContentPane().setLayout(telaTabelaLayout);
        telaTabelaLayout.setHorizontalGroup(
            telaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaTabelaLayout.setVerticalGroup(
            telaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPesquisa.setBackground(new java.awt.Color(153, 153, 153));

        txtPesquisa.setText("Insira o nome e aperte enter...");
        txtPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaMouseClicked(evt);
            }
        });
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Listar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        listaPesquisa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPesquisaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPesquisaLayout = new javax.swing.GroupLayout(pnlPesquisa);
        pnlPesquisa.setLayout(pnlPesquisaLayout);
        pnlPesquisaLayout.setHorizontalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPesquisaLayout.setVerticalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCampos.setBackground(new java.awt.Color(204, 204, 255));

        lblNome.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblNome.setText("Nome:");

        lblCRM.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblCRM.setText("CRM:");

        lblEspecialidade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblEspecialidade.setText("Especialidade:");

        lblConsultorio.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblConsultorio.setText("Consultório:");

        lblTelefone.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblTelefone.setText("Telefone:");

        lblPeriodo1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblPeriodo1.setText("Período:");

        cmbPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino" }));

        cmbConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consultório 1", "Consultório 2" }));

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCRM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCRM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(lblEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCamposLayout.createSequentialGroup()
                                .addComponent(lblPeriodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPeriodo, 0, 156, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCamposLayout.createSequentialGroup()
                                .addComponent(lblConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbConsultorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCRM)
                    .addComponent(txtCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecialidade)
                    .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultorio)
                    .addComponent(lblPeriodo1)
                    .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pnlEditar.setBackground(new java.awt.Color(204, 255, 204));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnApagar.setBackground(new java.awt.Color(255, 0, 0));
        btnApagar.setText("Apagar");

        btnEditar.setBackground(new java.awt.Color(255, 255, 102));
        btnEditar.setText("Editar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout pnlEditarLayout = new javax.swing.GroupLayout(pnlEditar);
        pnlEditar.setLayout(pnlEditarLayout);
        pnlEditarLayout.setHorizontalGroup(
            pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        pnlEditarLayout.setVerticalGroup(
            pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnApagar)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        preencherLista();
        listaPesquisa.setVisible(true);
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        txtPesquisa.setText("");
    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void tabelaGraficaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaGraficaMouseClicked

        if(evt.getClickCount() == 2) {
            
            String nome = "";
            String crm = "";
            String especialidade = "";
            String consultorio = "";
            String periodo = ""; 
            String telefone = "";
            
        
            if (this.tabelaGrafica.getSelectedRow() != -1) {
                
                nome =          tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 0).toString();            
                crm =           tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 1).toString();
                especialidade = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 2).toString();
                periodo =       tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 3).toString();
                consultorio =   tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 4).toString();
                telefone =      tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 5).toString();
                
                indiceLista = tabelaGrafica.getSelectedRow();
            }
            else {
                System.out.println("erro no metodo de captura da tabelagrafica, -1");
            }
            preencherCampos(nome, crm, especialidade, periodo, consultorio, telefone);
            
            telaTabela.dispose();
        }
    }//GEN-LAST:event_tabelaGraficaMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
        preencherMatriz(true); //mudar pra false depois dos testes
        carregaTabela();
        telaTabela.setVisible(true);
        telaTabela.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void listaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPesquisaMouseClicked
        
        indiceLista = listaPesquisa.getSelectedIndex();
        preencherCampos();
        listaPesquisa.setVisible(false);
    }//GEN-LAST:event_listaPesquisaMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
        indiceLista = -1;
        txtCRM.setText("");
        txtEspecialidade.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtPesquisa.setText("Insira o nome e aperte enter...");
        
        cmbConsultorio.setSelectedIndex(-1);
        cmbPeriodo.setSelectedIndex(-1);
        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEdicaoExclusaoMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbConsultorio;
    private javax.swing.JComboBox<String> cmbPeriodo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCRM;
    private javax.swing.JLabel lblConsultorio;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeriodo1;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList<String> listaPesquisa;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlEditar;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JTable tabelaGrafica;
    private javax.swing.JFrame telaTabela;
    private javax.swing.JTextField txtCRM;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
