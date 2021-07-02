package view.telaPaciente.telaEdicaoExclusaoPaciente;

import com.toedter.calendar.JDateChooser;
import view.util.DateUtil;
import controller.PacienteController;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Mensagem;
import view.util.TelefoneUtil;

public class TelaEdicaoExclusaoPaciente extends javax.swing.JFrame {

    PacienteController pacienteController;
    DefaultListModel modeloLista;
    String[][] matrizPacientes;
    Map<Integer, String> idsCapturados;
    int indiceLista = -1;
    
    public TelaEdicaoExclusaoPaciente() {
        
        initComponents();
        this.setLocationRelativeTo(null);
                
        pacienteController = new PacienteController();
        modeloLista = new DefaultListModel();
        idsCapturados = new HashMap<>();
        
        listaPesquisa.setVisible(false);
        listaPesquisa.setModel(modeloLista);
        
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
        
    }

    public void preencherLista() {
        //limpa a lista caso ja tenha sido preenchida
        //chama o metodo pesquisar que busca os dados com o controlador
        //usei um arraylist pra botar os nomes da matriz na lista de resultado
        //se a lista vier vazia ela exibe "Sem resultado"
    
        modeloLista.clear();
        
        preencherMatriz();
        
        ArrayList<String> nomes = new ArrayList<>();
        
        int tamanhoMatriz = matrizPacientes.length;
        
        if (tamanhoMatriz != 0) {
            
            for (int i = 0; i < tamanhoMatriz; i++) {
                nomes.add(matrizPacientes[i][1]);
            }
            listaPesquisa.setVisibleRowCount(nomes.size());
            nomes.forEach(nome -> {
                modeloLista.addElement(nome);
            }); 
            // isso é um forEach escrito com lambda
            // para cada nome presente no arraylist nomes
            // ele da um addElement na listaModelo passando o nome
            
        } else {
            //esse metodo não ta se comportando bem aqui...
            //deveria apagar a listaModelo e mostrar só 1 campo "sem resultado"
            //apesar de mostrar o sem resultado, se você clicar nele ainda
            //preenche os campos!! acontecendo aqui, deixei pra teste ai
            modeloLista.clear();
            listaPesquisa.setVisibleRowCount(1);
            modeloLista.addElement("Sem resultado");
        }
        
    }
    
    public void preencherMatriz(){
        //chama o metodo do controlador e bota os resultados do banco na matriz
        //percorre a matriz e bota os ids dentro do map com o metodo put
        //put equivale ao add das listas, veja idsCapturados.put(i, captura)
        //map<chave, valor>, chave é o inteiro i, valor é o String capturaId
        //no caso, capturaId é o id que vem em formato String do controlador
        
        matrizPacientes = pacienteController.getMinhaMatrizTexto(txtPesquisa.getText());
                
        for(int i = 0; i< matrizPacientes.length; i++) {
            String capturaId = matrizPacientes[i][0];
            idsCapturados.put(i, capturaId); 
        }
    }
    
    public int getIdFromMap() {
        //esse metodo usa o indiceLista pra tirar o id do Map, como o id está
        //salvo como String no Map, ele converte e devolve o id como resposta
        //se o usuario não houver selecionado nenhum cliente, ele dá um alerta
        //informando sobre o erro
        
        int id;
        if(indiceLista != -1){
            id = Integer.parseInt(idsCapturados.get(indiceLista));
        }
        else {
            id = -1;
            JOptionPane.showMessageDialog(null,
                    "Você deve selecionar um paciente", "Erro de captura do Id", 0);
        }
        return id;
    }
    
    public void preencherCampos() {
        //esse indice vem la do metodo lstResultadoMouseClicked
        //quando voce clica na lista ele pega o indice pela posição
        //esse metodo é chamado pelo lstResultadoMouseClicked ele preencheCampos :)
        //o metodo Util.conversorData pega o texto que vem do banco e transforma
        //em Date, ele vem yyyy-MM-dd e vira Date, **olhe a classe Util
        
        int j = indiceLista; // apenas para legibilidade
        
        String nome;
        String stringData;
        String endereco;
        String telefone;
        
        try {
            if(matrizPacientes.length != 0) {
                nome =         matrizPacientes[j][1];
                stringData =   matrizPacientes[j][2];
                endereco =     matrizPacientes[j][3];
                telefone =     matrizPacientes[j][4];
                
                txtNome.setText(nome);
                txtEndereco.setText(endereco);
                txtTelefone.setText(telefone);
                dtChooser.setDate(DateUtil.converter(stringData));

                btnEditar.setEnabled(true);
                btnApagar.setEnabled(true);
                
            } else {
                throw new Mensagem("Erro matriz vazia");
            }
            
        } catch (Mensagem erro) {
            System.out.println(erro);
        }

    }
    
    public void preencherCampos(String nome, String stringData, String endereco, String telefone) {
        //esse metodo é chamado quando  TelaTabela está sendo usada pra seleção
        //ele faz a mesma coisa que o de cima, só que pega os dados "mastigados" 
        //pelo metodo tabelaGraficaMouseClicked que está la embaixo
        
        txtNome.setText(nome);
        txtEndereco.setText(endereco);
        txtTelefone.setText(telefone);
        dtChooser.setDate(DateUtil.converter(stringData));
        
        btnEditar.setEnabled(true);
        btnApagar.setEnabled(true);
        
    }
    
    public void carregaTabela() {
        //roubei esse metodo do professor, ele preenche a JTable da TelaTabela
        //chamado no btnListarActionPerformed
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaGrafica.getModel();
        modeloTabela.setNumRows(0);

        for (int i = 0; i < matrizPacientes.length; i++) {
            modeloTabela.addRow(new Object[]{
                matrizPacientes[i][1],
                matrizPacientes[i][2],
                matrizPacientes[i][3],
                TelefoneUtil.formatar(matrizPacientes[i][4])
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaTabela = new javax.swing.JFrame();
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
        btnPesquisar = new javax.swing.JButton();
        listaPesquisa = new javax.swing.JList<>();
        btnApagar = new javax.swing.JButton();

        telaTabela.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        telaTabela.setMinimumSize(new java.awt.Dimension(569, 377));
        telaTabela.setResizable(false);

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
        tabelaGrafica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaGraficaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaGrafica);

        javax.swing.GroupLayout telaTabelaLayout = new javax.swing.GroupLayout(telaTabela.getContentPane());
        telaTabela.getContentPane().setLayout(telaTabelaLayout);
        telaTabelaLayout.setHorizontalGroup(
            telaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaTabelaLayout.setVerticalGroup(
            telaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaTabelaLayout.createSequentialGroup()
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
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Exibir Tabela");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        listaPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaPesquisa.setVisibleRowCount(5);
        listaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPesquisaMouseClicked(evt);
            }
        });

        btnApagar.setText("Excluir");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnApagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome)
                                    .addComponent(txtEndereco)
                                    .addComponent(dtChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnApagar))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(528, Short.MAX_VALUE))
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
        
        preencherLista();
        listaPesquisa.setVisible(true);
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void listaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPesquisaMouseClicked
        //serve pra pegar o nome na lista usando a posição (indice)
        //chama o metodo preencher que usa o indice pra definir quem foi clicado
        //esconde a lista
        
        indiceLista = listaPesquisa.getSelectedIndex();
        preencherCampos();
        listaPesquisa.setVisible(false);
    }//GEN-LAST:event_listaPesquisaMouseClicked

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        //serve pra esconder a lista se digitar (excessão a tecla enter)
        //botei esse metodo pensando na tecla esc mas ele pega toda digitação
        
        listaPesquisa.setVisible(false);
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        //metodo alternativo para exibir tela com a tabela de resultados
        //TelaTabela é um JFrame adicional que está em [OutrosComponentes]
        //exibe a telaTabela, o setLocation...(null) bota essa tela bem no meio
        
        preencherMatriz();
        carregaTabela();
        telaTabela.setVisible(true);
        telaTabela.setLocationRelativeTo(null);  
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
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
                indiceLista = tabelaGrafica.getSelectedRow();
            }
            else {
                System.out.println("erro");
            }
            telefone = TelefoneUtil.conversor(telefone);
            preencherCampos(nome, data, endereco, telefone);
            telaTabela.dispose();
        }       
        
    }//GEN-LAST:event_tabelaGraficaMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //bloqueia os botões e, limpa os campos e a variavel que guarda o id
        btnEditar.setEnabled(false);
        btnApagar.setEnabled(false);
        indiceLista = -1;
        txtPesquisa.setText("Insira o nome e aperte enter...");
        txtNome.setText("");
        dtChooser.cleanup();
        System.out.println(dtChooser.getDate());
      //  dtChooser = new JDateChooser();
        dtChooser.add(new JDateChooser());
        txtEndereco.setText("");
        txtTelefone.setText("");   
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        //pega o id do map ainda em formato de String, transforma em int e manda
        //pro controlador apagar o paciente selecionado. usando o indice da lista;
        //o indice da lista é o valor que o map usou como chave para armazenar os ids
        //ainda vou adicionar uma confirmação antes de apagar***************
        
        String titulo = "Confirmar exclusão de médico";
        String confirmacao = "Você está prestes a apagar as informações do paciente selecionado";

        int retornoConfirmacao = JOptionPane.showConfirmDialog(null, confirmacao, titulo, 0, 2);

        System.out.println(retornoConfirmacao);
        try {

            if (retornoConfirmacao == 0) {

                if (pacienteController.apagar(getIdFromMap())) {
                    JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso", "Apagado!", 1);
                } else {
                    throw new Mensagem("Falha no metodo do controlador");
                }
            } else {
                throw new Mensagem("Exclusão cancelada!");

            }
            btnLimpar.doClick();
        
        } catch (Mensagem erro) {
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", 0);
        }

        System.out.println(getIdFromMap()); //teste pra ver se o id vem certo, FUNCIONANDO        
        //controlador.apagar(getIdFromMap()); ----------liberar o metodo 
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    //esse metodo pega as informações da tela e altera o paciente que foi selecionado
    //é praticamente igual ao do professor, então é sem stress
        try {
            int id;
            String nome;
            Date data;
            String endereco;
            String telefone;

            if(getIdFromMap() != -1) {
                id = getIdFromMap();
            } else {
                throw new Mensagem("Erro no metodo getIdFromMap");
            }
            
            if(txtNome.getText().length() > 6) {
                nome = txtNome.getText();
            } else {
                throw new Mensagem("O nome inserido é muito pequeno, altere!");
            }
            
            if(dtChooser.getDate() != null) {
                data = dtChooser.getDate();
            } else {
                throw new Mensagem("Ocorreu um erro com a data!");
            }
            
            if(txtEndereco.getText().length() > 5) {
                endereco = txtEndereco.getText();
            } else {
                throw new Mensagem("O endereço inserido é muito pequeno, corrija!");
            }
            
            if(txtTelefone.getText().length() == 13){
                telefone = TelefoneUtil.conversor(txtTelefone.getText());
            } else {
                throw new Mensagem("O telefone não foi inserido corretamentem, corrija!");
            }
            
            String titulo = "Confirmar edição de paciente";
            String confirmacao = "Você está prestes a editar as informações "
                    + "do paciente selecionado \n Deja Continmuar?";

            int retornoConfirmacao = JOptionPane.showConfirmDialog(null, confirmacao, titulo, 0, 2);

            System.out.println(retornoConfirmacao);
            
            if(retornoConfirmacao == 0){

                if(pacienteController.editar(id, nome, data, endereco, telefone)) {
                    
                    JOptionPane.showMessageDialog(null, "Paciente editado com sucesso", "Editado!", 1);
                    
                } else {
                    throw new Mensagem("Falha no metodo do controlador");
                }
                
            } else {
                throw new Mensagem("Edição cancelada!");
            }
            
            btnLimpar.doClick();//limpando os campos por simulacão de clique
            
        } catch(Mensagem erro){
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", 0);
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        txtPesquisa.setText("");
    }//GEN-LAST:event_txtPesquisaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private com.toedter.calendar.JDateChooser dtChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList<String> listaPesquisa;
    private javax.swing.JTable tabelaGrafica;
    private javax.swing.JFrame telaTabela;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
