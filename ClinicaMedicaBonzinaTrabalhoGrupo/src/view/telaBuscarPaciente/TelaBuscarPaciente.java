
package view.telaBuscarPaciente;

import controller.PacienteController;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import view.telaAgendamento.TelaAgendamento;
import view.telaPaciente.telaCadastroPaciente.TelaCadastroPaciente;
import view.util.DateUtil;
import view.util.SwingUtil;
import static view.util.SwingUtil.centralizaCells;


public class TelaBuscarPaciente extends javax.swing.JFrame {
   
    private PacienteController pacienteController;
    private TelaAgendamento agendamentoView;
    private TelaCadastroPaciente cadastrarPaciente;
            
    public TelaBuscarPaciente() {
        initComponents();
        this.pacienteController = new PacienteController();
        SwingUtil.centralizaHeaderTabela(tabelaPacientes);
        centralizaCells(tabelaPacientes, SwingConstants.CENTER);
    }
    
    public TelaBuscarPaciente(TelaAgendamento agendamentoView) {
        this.agendamentoView = agendamentoView;
        limpaTabela();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPacientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        inputBuscarPaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Paciente");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnFechar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSelecionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setMultiClickThreshhold(30L);
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        tabelaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Data de Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPacientes.getTableHeader().setReorderingAllowed(false);
        tabelaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPacientes);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel1.setText("Nome");

        btnBuscarPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/lupa.png"))); // NOI18N
        btnBuscarPaciente.setOpaque(false);
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addGap(98, 98, 98)
                        .addComponent(btnSelecionar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(inputBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
   public void preencheTabela(String[][] linhasMatriz) {

       DefaultTableModel modelo = (DefaultTableModel) this.tabelaPacientes.getModel();
       modelo.setNumRows(0);

       for (int i = 0; i < linhasMatriz.length; i++) {
           modelo.addRow(new Object[]{
           linhasMatriz[i][0],
           linhasMatriz[i][1],
           DateUtil.formatar(linhasMatriz[i][2]),
           linhasMatriz[i][3],
           linhasMatriz[i][4]
           });
       }
   }
  
    public boolean validaInput(String input) {
        if (input.equals("")){
                JOptionPane.showMessageDialog(rootPane, "Informe um texto válido");
                 return false;
            }
            return true;
    }
    
    public void mostrar(TelaAgendamento agendamentoView) {
        this.agendamentoView = agendamentoView;
        limpaTabela();
        setVisible(true);
    }
    
    private void limpaTabela() {
        // inicializa a matriz  com strings vazias.
        String[][] matrizVazia = new String[4][5];
        
        // fazer "for" que passa por todas as linhas e seta uma String vazia na  coluna.
        for (int i = 0; i< matrizVazia.length; i++) {
           matrizVazia[i][0] = "";
           matrizVazia[i][1] = "";
           matrizVazia[i][2] = "";
           matrizVazia[i][3] = "";
           matrizVazia[i][4] = "";
        }
        preencheTabela(matrizVazia);
    }
    
    private void verificaSePacienteExiste () {

        int resposta_usuario = JOptionPane.showConfirmDialog(
                null, "O paciente não foi encontrado. Você deseja cadastrar?");
        if (resposta_usuario == 0) {
            cadastrarPaciente = new TelaCadastroPaciente();    
        }
    }
    

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        
        String input = this.inputBuscarPaciente.getText();

        boolean valido = validaInput(input);
        if (valido != true) {
            return;
        }

        String[][] linhasMatriz = pacienteController.getMinhaMatrizTexto(input);
        if (linhasMatriz.length > 0) {
            preencheTabela(linhasMatriz);
        } else {
            verificaSePacienteExiste();
            limpaTabela();  
        }
        this.inputBuscarPaciente.setText("");
        
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    
    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (this.tabelaPacientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um paciente");
        } else {
            String id = this.tabelaPacientes.getValueAt(this.tabelaPacientes.getSelectedRow(), 0).toString();
            String nome = this.tabelaPacientes.getValueAt(this.tabelaPacientes.getSelectedRow(),1).toString();
            String dataNascimento = this.tabelaPacientes.getValueAt(this.tabelaPacientes.getSelectedRow(), 2).toString();

            int idInt = Integer.parseInt(id);
            agendamentoView.recebeDadosPaciente(idInt, nome, dataNascimento);
            setVisible(false);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tabelaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPacientesMouseClicked
        if(evt.getClickCount() == 2) {
            btnSelecionar.doClick();
        }
    }//GEN-LAST:event_tabelaPacientesMouseClicked

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
            java.util.logging.Logger.getLogger(TelaBuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBuscarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JTextField inputBuscarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPacientes;
    // End of variables declaration//GEN-END:variables
}
