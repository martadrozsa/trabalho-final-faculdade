package view.telaConsultaAgendamento;

import javax.swing.ImageIcon;
import controller.AgendamentoController;
import static controller.AgendamentoController.DadosMatrizAgendamento.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import view.telaAgendamento.TelaAgendamento;
import view.util.DateUtil;
import view.util.SwingUtil;
import static view.util.SwingUtil.centralizaCells;


public class TelaConsulta extends javax.swing.JFrame {
    private final AgendamentoController agendamentoController;
    private final TelaAgendamento agendamentoView;

    private Date dataAgendamento;
    private String[][] linhasMatriz;
    
    public TelaConsulta() {
        initComponents();
        agendamentoController = new AgendamentoController();
        agendamentoView = new TelaAgendamento();
        SwingUtil.centralizaHeaderTabela(tabelaAgendamentosConsulta);
        centralizaCells(tabelaAgendamentosConsulta, SwingConstants.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTituloMedico1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inputPesquisaAgenda = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        calendarDataAgendamento = new com.toedter.calendar.JDateChooser();
        btnSair = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgendamentosConsulta = new javax.swing.JTable();
        painelImagemFundo1 = new view.PainelImagemFundo();
        txtTituloMedico2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        txtTituloMedico1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtTituloMedico1.setText("Agendamento");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnPesquisar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        calendarDataAgendamento.setDateFormatString("dd/MM/yyyy");
        calendarDataAgendamento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarDataAgendamentoPropertyChange(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnVisualizar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("AGENDA"));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        tabelaAgendamentosConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Data de Nascimento", "Horário", "Data da Consulta", "Médico", "Consultório"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        tabelaAgendamentosConsulta.getTableHeader().setReorderingAllowed(false);
        tabelaAgendamentosConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendamentosConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgendamentosConsulta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1214, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelImagemFundo1.setImg(new ImageIcon("src/view/imagens/fundo/imagem_fundo2.png"));

        txtTituloMedico2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtTituloMedico2.setForeground(new java.awt.Color(102, 102, 102));
        txtTituloMedico2.setText("AGENDA MÉDICA");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logoBonzina.png"))); // NOI18N

        javax.swing.GroupLayout painelImagemFundo1Layout = new javax.swing.GroupLayout(painelImagemFundo1);
        painelImagemFundo1.setLayout(painelImagemFundo1Layout);
        painelImagemFundo1Layout.setHorizontalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTituloMedico2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        painelImagemFundo1Layout.setVerticalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImagemFundo1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTituloMedico2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImagemFundo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(inputPesquisaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar)
                        .addGap(8, 8, 8))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addGap(98, 98, 98)
                        .addComponent(btnVisualizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(calendarDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnLimpar)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPesquisaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(calendarDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void mostrarTela() {
        limpaTabela();
        inputPesquisaAgenda.setText("");
        calendarDataAgendamento.setDate(null);
        setVisible(true);
        
    }
       
    public void preencheTabela(String[][] matrizAgendamentosWrappers) {
        
       DefaultTableModel modelo = (DefaultTableModel) this.tabelaAgendamentosConsulta.getModel();
       modelo.setNumRows(0);

       for (int i = 0; i < matrizAgendamentosWrappers.length; i++) {
           modelo.addRow(new Object[]{
           matrizAgendamentosWrappers[i][NOME_PACIENTE.ordinal()],
           DateUtil.formatar(matrizAgendamentosWrappers[i][DATA_NASCIMENTO.ordinal()]),
           matrizAgendamentosWrappers[i][HORARIO.ordinal()],
           DateUtil.formatar(matrizAgendamentosWrappers[i][DATA_AGENDAMENTO.ordinal()]),
           matrizAgendamentosWrappers[i][NOME_MEDICO.ordinal()],
           matrizAgendamentosWrappers[i][CONSULTORIO.ordinal()]
           });
       }
    }
    
    public void atualizaTabelaAgendaDaData() {
        dataAgendamento = calendarDataAgendamento.getDate(); 
        String inputPesquisa = this.inputPesquisaAgenda.getText();
     
        String[][] linhasMatriz = agendamentoController.
                getAgendamentosByDateConsulta(inputPesquisa, dataAgendamento);
        if (linhasMatriz.length > 0) {
            preencheTabela(linhasMatriz);
            this.linhasMatriz = linhasMatriz;
        } 
        else {
            limpaTabela();
        }
    }
    
    private void limpaTabela() {
        // inicializa a matriz  com strings vazias.
        String[][] matrizVazia = new String[10][10];
        
        // fazer "for" que passa por todas as linhas e seta uma String vazia na  coluna.
        for (int i = 0; i < matrizVazia.length; i++) {
           matrizVazia[i][NOME_PACIENTE.ordinal()] = "";
           matrizVazia[i][DATA_NASCIMENTO.ordinal()] = "";
           matrizVazia[i][HORARIO.ordinal()] = "";
           matrizVazia[i][DATA_AGENDAMENTO.ordinal()] = "";
           matrizVazia[i][NOME_MEDICO.ordinal()] = "";
           matrizVazia[i][CONSULTORIO.ordinal()] = "";
           matrizVazia[i][ID_AGENDAMENTO.ordinal()] = "";
        }
        preencheTabela(matrizVazia);
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        atualizaTabelaAgendaDaData();       
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
    private void calendarDataAgendamentoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarDataAgendamentoPropertyChange
        if (calendarDataAgendamento.getDate() == null) {
            return;
        }
        atualizaTabelaAgendaDaData();
    }//GEN-LAST:event_calendarDataAgendamentoPropertyChange

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed
    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
       
        if (this.tabelaAgendamentosConsulta.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente");
            return;
        }
        
        int rowIdx = this.tabelaAgendamentosConsulta.getSelectedRow();
        
        String nome = linhasMatriz[rowIdx][NOME_PACIENTE.ordinal()];
        String dataNascimento = linhasMatriz[rowIdx][DATA_NASCIMENTO.ordinal()];
        String horario = linhasMatriz[rowIdx][HORARIO.ordinal()];
        String dataAgendamento = linhasMatriz[rowIdx][DATA_AGENDAMENTO.ordinal()];
        String medico = linhasMatriz[rowIdx][NOME_MEDICO.ordinal()];
        String consultorio = linhasMatriz[rowIdx][CONSULTORIO.ordinal()];
        String idAgendamento = linhasMatriz[rowIdx][ID_AGENDAMENTO.ordinal()]; 
        String idPaciente = linhasMatriz[rowIdx][ID_PACIENTE.ordinal()];
        String idMedico = linhasMatriz[rowIdx][ID_MEDICO.ordinal()];
        
        int idAgendamentoConsulta = Integer.parseInt(idAgendamento);
        int idPacienteConsulta = Integer.parseInt(idPaciente);
        int idMedicoConsulta = Integer.parseInt(idMedico);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // Time horarioAgendamento = Time.valueOf(horario);

        try {
            Date dataConsulta = formatter.parse(dataAgendamento);
            agendamentoView.recebeDadosPaciente(nome, dataNascimento, horario, dataConsulta, idMedicoConsulta, medico, consultorio, idAgendamentoConsulta, idPacienteConsulta, this);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        agendamentoView.mostraTelaModoReagendamento();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        calendarDataAgendamento.setDate(null);
        atualizaTabelaAgendaDaData();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tabelaAgendamentosConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendamentosConsultaMouseClicked
        if(evt.getClickCount() == 2) {
            btnVisualizar.doClick();
        }
    }//GEN-LAST:event_tabelaAgendamentosConsultaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizar;
    private com.toedter.calendar.JDateChooser calendarDataAgendamento;
    private javax.swing.JTextField inputPesquisaAgenda;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private view.PainelImagemFundo painelImagemFundo1;
    private javax.swing.JTable tabelaAgendamentosConsulta;
    private javax.swing.JLabel txtTituloMedico1;
    private javax.swing.JLabel txtTituloMedico2;
    // End of variables declaration//GEN-END:variables
}
