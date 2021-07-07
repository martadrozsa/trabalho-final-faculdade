package view.telaPrincipal;

import controller.AgendamentoController;
import controller.PacienteController;
import javax.swing.ImageIcon;
import view.telaAgendamento.TelaAgendamento;
import view.telaConsultaAgendamento.TelaConsulta;
import view.telaMedico.telaEdicaoExclusaoMedico.TelaEdicaoExclusaoMedico;
import view.telaPaciente.telaEdicaoExclusaoPaciente.TelaEdicaoExclusaoPaciente;
import view.telaSobre.TelaSobre;

public class TelaPrincipal extends javax.swing.JFrame {
    
    public TelaPrincipal() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PacienteController pacienteControl = new PacienteController();
        lblContagemPacientes.setText(Integer.toString(pacienteControl.getCountPacientes()));
        AgendamentoController agendaControl = new AgendamentoController();
        lblContagemConsultas.setText(Integer.toString(agendaControl.getCountWeekSchedules()));
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        painelImagemFundo = new view.PainelImagemFundo();
        txtLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAgendaConsulta = new javax.swing.JButton();
        btnConsultaAgenda = new javax.swing.JButton();
        btnSobre = new javax.swing.JButton();
        btnCadastraPaciente = new javax.swing.JButton();
        btnCadastraMedico = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        pnlPacientesCount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblContagemPacientes = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlPacientesCount1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblContagemConsultas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Consultas");
        setResizable(false);

        painelImagemFundo.setImg(new ImageIcon("src/view/imagens/fundo/imagem_fundo.jpg"));

        txtLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logoBonzina.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(231, 248, 246));

        btnAgendaConsulta.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgendaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/agendar.png"))); // NOI18N
        btnAgendaConsulta.setText("AGENDAR");
        btnAgendaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaConsultaActionPerformed(evt);
            }
        });

        btnConsultaAgenda.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnConsultaAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/consultar.png"))); // NOI18N
        btnConsultaAgenda.setText("CONSULTAR");
        btnConsultaAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaAgendaActionPerformed(evt);
            }
        });

        btnSobre.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/about.png"))); // NOI18N
        btnSobre.setText("SOBRE");
        btnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreActionPerformed(evt);
            }
        });

        btnCadastraPaciente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnCadastraPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/pacient.png"))); // NOI18N
        btnCadastraPaciente.setText("PACIENTE");
        btnCadastraPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraPacienteActionPerformed(evt);
            }
        });

        btnCadastraMedico.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnCadastraMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/doctor.png"))); // NOI18N
        btnCadastraMedico.setText("MÉDICO");
        btnCadastraMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraMedicoActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/exit.png"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgendaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsultaAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
            .addComponent(btnCadastraPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCadastraMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSobre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAgendaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastraPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastraMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnlPacientesCount.setBorder(new javax.swing.border.MatteBorder(null));
        pnlPacientesCount.setPreferredSize(new java.awt.Dimension(294, 302));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pacientes Cadastrados");

        lblContagemPacientes.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblContagemPacientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContagemPacientes.setText("--");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/pacients.png"))); // NOI18N

        javax.swing.GroupLayout pnlPacientesCountLayout = new javax.swing.GroupLayout(pnlPacientesCount);
        pnlPacientesCount.setLayout(pnlPacientesCountLayout);
        pnlPacientesCountLayout.setHorizontalGroup(
            pnlPacientesCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPacientesCountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPacientesCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContagemPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlPacientesCountLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlPacientesCountLayout.setVerticalGroup(
            pnlPacientesCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPacientesCountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(lblContagemPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPacientesCount1.setBorder(new javax.swing.border.MatteBorder(null));
        pnlPacientesCount1.setPreferredSize(new java.awt.Dimension(294, 302));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Consultas Cadastradas");

        lblContagemConsultas.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblContagemConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContagemConsultas.setText("--");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/consultas.png"))); // NOI18N

        javax.swing.GroupLayout pnlPacientesCount1Layout = new javax.swing.GroupLayout(pnlPacientesCount1);
        pnlPacientesCount1.setLayout(pnlPacientesCount1Layout);
        pnlPacientesCount1Layout.setHorizontalGroup(
            pnlPacientesCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPacientesCount1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPacientesCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContagemConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlPacientesCount1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlPacientesCount1Layout.setVerticalGroup(
            pnlPacientesCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPacientesCount1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(lblContagemConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelImagemFundoLayout = new javax.swing.GroupLayout(painelImagemFundo);
        painelImagemFundo.setLayout(painelImagemFundoLayout);
        painelImagemFundoLayout.setHorizontalGroup(
            painelImagemFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImagemFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagemFundoLayout.createSequentialGroup()
                        .addComponent(txtLogo)
                        .addContainerGap(774, Short.MAX_VALUE))
                    .addGroup(painelImagemFundoLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(pnlPacientesCount, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPacientesCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );
        painelImagemFundoLayout.setVerticalGroup(
            painelImagemFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(painelImagemFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPacientesCount, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPacientesCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(317, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelImagemFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaConsultaActionPerformed
        TelaAgendamento novoAgendamento = new TelaAgendamento();
        novoAgendamento.mostraTelaModoAgendamento();
    }//GEN-LAST:event_btnAgendaConsultaActionPerformed

    private void btnConsultaAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaAgendaActionPerformed
        TelaConsulta consultarAgendamento = new TelaConsulta();
        consultarAgendamento.mostrarTela();
    }//GEN-LAST:event_btnConsultaAgendaActionPerformed

    private void btnCadastraPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraPacienteActionPerformed
        TelaEdicaoExclusaoPaciente telaPaciente = new TelaEdicaoExclusaoPaciente();
    }//GEN-LAST:event_btnCadastraPacienteActionPerformed

    private void btnCadastraMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraMedicoActionPerformed
        TelaEdicaoExclusaoMedico telaMedico = new TelaEdicaoExclusaoMedico();
    }//GEN-LAST:event_btnCadastraMedicoActionPerformed

    private void btnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreActionPerformed
        TelaSobre telaSobre = new TelaSobre();
    }//GEN-LAST:event_btnSobreActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendaConsulta;
    private javax.swing.JButton btnCadastraMedico;
    private javax.swing.JButton btnCadastraPaciente;
    private javax.swing.JButton btnConsultaAgenda;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSobre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblContagemConsultas;
    private javax.swing.JLabel lblContagemPacientes;
    private view.PainelImagemFundo painelImagemFundo;
    private javax.swing.JPanel pnlPacientesCount;
    private javax.swing.JPanel pnlPacientesCount1;
    private javax.swing.JLabel txtLogo;
    // End of variables declaration//GEN-END:variables
}
