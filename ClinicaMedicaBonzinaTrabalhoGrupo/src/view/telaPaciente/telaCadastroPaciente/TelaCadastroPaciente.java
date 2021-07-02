package view.telaPaciente.telaCadastroPaciente;
import controller.PacienteController;
import java.util.Date;
import javax.swing.JOptionPane;
import view.Mensagem;
import view.util.DateUtil;


public class TelaCadastroPaciente extends javax.swing.JFrame {
    
    private PacienteController controlador; 

    public TelaCadastroPaciente() {
        initComponents();
        this.controlador = new PacienteController(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        inputNome = new javax.swing.JTextField();
        inputEndereco = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        inputDTNascimento = new com.toedter.calendar.JDateChooser();
        inputFone = new javax.swing.JFormattedTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.setText("Nome");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(100, 130, 80, 28);

        jTextField3.setText("Endereço");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(100, 230, 100, 28);

        jTextField4.setText("Data de nascimento");
        getContentPane().add(jTextField4);
        jTextField4.setBounds(100, 180, 160, 28);

        jTextField5.setText("Telefone");
        getContentPane().add(jTextField5);
        jTextField5.setBounds(100, 280, 90, 28);
        getContentPane().add(inputNome);
        inputNome.setBounds(310, 130, 150, 28);
        getContentPane().add(inputEndereco);
        inputEndereco.setBounds(310, 230, 150, 28);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(110, 420, 140, 30);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(310, 420, 150, 30);
        getContentPane().add(inputDTNascimento);
        inputDTNascimento.setBounds(310, 180, 150, 28);

        try {
            inputFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(inputFone);
        inputFone.setBounds(310, 280, 170, 28);

        jTextField2.setText("Cadastro de Pacientes");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 50, 160, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            String nome = "";
            Date data_nascimento = null;
            String endereco = "";
            String telefone = "";
            
            if (this.inputNome.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.inputNome.getText();
            }

            if (this.inputDTNascimento.getDate() == null) {
                throw new Mensagem("Data Nascimento deve ser numero e maior que zero.");
            } else {
                data_nascimento = inputDTNascimento.getDate();
            }

            if (this.inputEndereco.getText().length() < 2) {
                throw new Mensagem("Endereco deve conter ao menos 2 caracteres.");
            } else {
                endereco = this.inputEndereco.getText();
            }

            if (this.inputFone.getText().length() <= 0) {
                throw new Mensagem("Telefone deve ser numero e maior que zero.");
            } else {
//                telefone = DateUtil.conversorTelefone(this.inputFone.getText());
            }

            // envia os dados para o Controlador cadastrar
            if (this.controlador.cadastrar(nome, data_nascimento, endereco, telefone)) {
                JOptionPane.showMessageDialog(rootPane, "Paciente Cadastrado com Sucesso!");

                // limpa campos da interface
                this.inputNome.setText("");
                this.inputDTNascimento.setDate(null);
                this.inputEndereco.setText("");
                this.inputFone.setText("");

            }

            System.out.println(this.controlador.getMinhaLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um numero.");
        } 
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private com.toedter.calendar.JDateChooser inputDTNascimento;
    private javax.swing.JTextField inputEndereco;
    private javax.swing.JFormattedTextField inputFone;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
