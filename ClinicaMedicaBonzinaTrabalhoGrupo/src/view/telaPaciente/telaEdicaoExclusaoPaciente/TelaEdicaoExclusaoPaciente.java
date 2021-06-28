package view.telaPaciente.telaEdicaoExclusaoPaciente;
import DAO.PacienteDAO;
import controller.PacienteController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.Mensagem;

public class TelaEdicaoExclusaoPaciente extends javax.swing.JFrame {
    PacienteDAO CONEXAO = new PacienteDAO(); //------------------------
    private PacienteController controlador;  //---------------------------
    DefaultListModel MODELO; //------------------------------------------
    int Enter = 0; //----------------------------------------------------

    public TelaEdicaoExclusaoPaciente() {
        initComponents();
        
        CONEXAO.connectToDatabase();
        MostraPesquisa();
        lista.setVisible(false);
        MODELO = new DefaultListModel();
        lista.setModel(MODELO);
        this.controlador = new PacienteController(); 
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisa_nome = new javax.swing.JTextField();
        lista = new javax.swing.JList<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputData = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputFone = new javax.swing.JTextField();
        inputNome = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pesquisa_nome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pesquisa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisa_nomeActionPerformed(evt);
            }
        });
        pesquisa_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisa_nomeKeyReleased(evt);
            }
        });

        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jLabel1.setText("Nome");

        jLabel2.setText("Endereço");

        jLabel3.setText("Data de Nascimento");

        jLabel4.setText("Telefone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputNome)
                    .addComponent(inputEndereco)
                    .addComponent(inputFone)
                    .addComponent(inputData, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnCancelar)
                        .addGap(48, 48, 48)
                        .addComponent(btnEditar)
                        .addGap(37, 37, 37)
                        .addComponent(btnExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pesquisa_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnEditar)
                            .addComponent(btnExcluir))))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisa_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisa_nomeActionPerformed
       // TODO add your handling code here:
       lista.setVisible(false);
       Enter = 1;
    }//GEN-LAST:event_pesquisa_nomeActionPerformed

    private void pesquisa_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisa_nomeKeyReleased
        // TODO add your handling code here:
        if (Enter == 0){
            ListaPesquisa();
        }else{
            Enter = 0;
        }
    }//GEN-LAST:event_pesquisa_nomeKeyReleased

    private void listaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMousePressed
        // TODO add your handling code here:
        MostraPesquisa();
        lista.setVisible(false);
    }//GEN-LAST:event_listaMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        try {
            // recebendo e validando dados da interface gr�fica.
            String nome = "";
            Date data_nascimento = null;
            String endereco = "";
            String telefone = "";

            if (this.inputNome.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.inputNome.getText();
            }

            if (this.inputData.getDate() == null) {
                throw new Mensagem("Data nascimento nao deve ser nulo.");
            } else {
                data_nascimento = this.inputData.getDate();
            }

            if (this.inputEndereco.getText().length() < 2) {
                throw new Mensagem("Endereço deve conter ao menos 2 caracteres.");
            } else {
                endereco = this.inputEndereco.getText();
            }

            if (this.inputFone.getText().length() <= 0) {
                throw new Mensagem("Telefone deve ser numero e maior que zero.");
            } else {
                telefone = this.inputFone.getText();
            }
            
            
            
            
//             if (this.jTableAlunos.getSelectedRow() == -1) {
//                throw new Mensagens("Primeiro Selecione um Aluno para Alterar");
//            } else {
//                id = Integer.parseInt(this.jTableAlunos.getValueAt(this.jTableAlunos.getSelectedRow(), 0).toString());
//            }

            // envia os dados para o Controlador processar
            System.out.println("" + data_nascimento);
            if (this.controlador.editar(nome, data_nascimento, endereco, telefone)) {

                // limpa os campos
                this.inputNome.setText("");
                this.inputData.setDate(null);
                this.inputEndereco.setText("");
                this.inputFone.setText("");
                JOptionPane.showMessageDialog(rootPane, "Paciente Alterado com Sucesso!");

            }
            
            
            
            
            
            
        }catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        // TODO add your handling code here:
//        try {
//            // validando dados da interface gr�fica.
//            int id = 0;
//            if (this.jTableAlunos.getSelectedRow() == -1) {
//                throw new Mensagens("Primeiro Selecione um Aluno para APAGAR");
//            } else {
//                id = Integer.parseInt(this.jTableAlunos.getValueAt(this.jTableAlunos.getSelectedRow(), 0).toString());
//            }
//
//            // retorna 0 -> primeiro bot�o | 1 -> segundo bot�o | 2 -> terceiro bot�o
//            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este Aluno ?");
//
//            if (resposta_usuario == 0) {// clicou em SIM
//
//                // envia os dados para o Controlador processar
//                if (this.controlador.Apagar(id)) {
//
//                    // limpa os campos
//                    this.inputNome.setText("");
//                    this.inputData.setDate(null);
//                    this.inputEndereco.setText("");
//                    this.inputFone.setText("");
//                    JOptionPane.showMessageDialog(rootPane, "Paciente Apagado com Sucesso!");
//
//                }
//
//            }
//
//            System.out.println(this.controlador.getMinhaLista().toString());
//
//        } catch (Mensagens erro) {
//            JOptionPane.showMessageDialog(null, erro.getMessage());
//        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEdicaoExclusaoPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private com.toedter.calendar.JDateChooser inputData;
    private javax.swing.JTextField inputEndereco;
    private javax.swing.JTextField inputFone;
    private javax.swing.JTextField inputNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField pesquisa_nome;
    // End of variables declaration//GEN-END:variables
    
    public void ListaPesquisa(){
        try{
            CONEXAO.executaSQL("SELECT * FROM paciente where nome like '" + pesquisa_nome.getText() + "%' ORDER BY nome");
            MODELO.removeAllElements();
            int v = 0;
            while (CONEXAO.resultset.next() & v < 4){
                MODELO.addElement(CONEXAO.resultset.getString("nome"));
                v++;
            }
            if (v >= 1){
                lista.setVisible(true);
            } else{
                lista.setVisible(false);
            }
            
            ResultadoPesquisa();
        
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar dados" + erro);
        }
    
    
    }
    
    
    
    
    
    public void MostraPesquisa(){
        int Linha = lista.getSelectedIndex();
        if (Linha >= 0){
            CONEXAO.executaSQL("SELECT * FROM paciente where nome like '" + "" + pesquisa_nome.getText() + "%' ORDER BY nome LIMIT " + Linha + " , 1");
            ResultadoPesquisa();

        }
    }
    
    public void ResultadoPesquisa(){
        try{
            CONEXAO.resultset.first();
            inputNome.setText(CONEXAO.resultset.getString("nome"));
            inputData.setDate(CONEXAO.resultset.getDate("data_nascimento"));
            inputEndereco.setText(CONEXAO.resultset.getString("endereco"));
            inputFone.setText(CONEXAO.resultset.getString("telefone"));
            
        }catch (SQLException erro){
        }
       }
    

}
