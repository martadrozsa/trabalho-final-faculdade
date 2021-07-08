package view.telaPaciente.telaEdicaoExclusaoPaciente;

import controller.AgendamentoController;
import javax.swing.ImageIcon;
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
import view.MensagemAlternativa;
import view.telaPaciente.telaCadastroPaciente.TelaCadastroPaciente;
import view.util.TelefoneUtil;

public class TelaEdicaoExclusaoPaciente extends javax.swing.JFrame {

    PacienteController pacienteController;
    AgendamentoController agendamentoController;
    DefaultListModel modeloLista;
    String[][] matrizPacientes;
    Map<Integer, String> idsCapturados;
    int indiceLista = -1;
    
    public TelaEdicaoExclusaoPaciente() {
        
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
                
        pacienteController = new PacienteController();
        agendamentoController = new AgendamentoController();
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
        
        preencherMatriz(true);
        
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
            //foreach é um for que percorre tudo mas não conta as posições
            
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
    
    public void preencherMatriz(boolean tipoConsulta){
        //chama o metodo do controlador e bota os resultados do banco na matriz
        //percorre a matriz e bota os ids dentro do map com o metodo put
        //put equivale ao add das listas, veja idsCapturados.put(i, captura)
        //map<chave, valor>, chave é o inteiro i, valor é o String capturaId
        //no caso, capturaId é o id que vem em formato String do controlador
        if(tipoConsulta) {
            matrizPacientes = pacienteController.getMinhaMatrizTexto(txtPesquisa.getText());
        } else {
            matrizPacientes = pacienteController.getMinhaMatrizTexto();
        }
        
                
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
        } //depois que eu deixei os botoes desativados esse trecho virou
          //um detalhe que demonstra de como o codigo veio sendo refatorado
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
                throw new Mensagem("Erro na busca dos pacientes!");
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
        txtPesquisa = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        listaPesquisa = new javax.swing.JList<>();
        btnApagar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        dtChooser = new com.toedter.calendar.JDateChooser();
        txtNome = new javax.swing.JTextField();
        painelImagemFundo2 = new view.PainelImagemFundo();
        txtTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Paciente");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtPesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
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

        btnLimpar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnPesquisar.setText("Listar todos");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        listaPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaPesquisa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaPesquisa.setVisibleRowCount(5);
        listaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPesquisaMouseClicked(evt);
            }
        });

        btnApagar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnApagar.setText("Excluir");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTelefone.setBackground(new java.awt.Color(255, 255, 255));
        lblTelefone.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(1, 1, 1));
        lblTelefone.setText("Telefone");
        lblTelefone.setOpaque(true);
        lblTelefone.setPreferredSize(new java.awt.Dimension(36, 16));

        lblEndereco.setBackground(new java.awt.Color(255, 255, 255));
        lblEndereco.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(1, 1, 1));
        lblEndereco.setText("Endereço");
        lblEndereco.setOpaque(true);
        lblEndereco.setPreferredSize(new java.awt.Dimension(36, 16));

        lblData.setBackground(new java.awt.Color(255, 255, 255));
        lblData.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(1, 1, 1));
        lblData.setText("Data de Nascimento");
        lblData.setOpaque(true);
        lblData.setPreferredSize(new java.awt.Dimension(36, 16));

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(1, 1, 1));
        lblNome.setText("Nome");
        lblNome.setOpaque(true);
        lblNome.setPreferredSize(new java.awt.Dimension(36, 16));

        dtChooser.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        painelImagemFundo2.setImg(new ImageIcon("src/view/imagens/fundo/imagem_fundo2.png"));

        txtTitulo.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setText("GERENCIAR PACIENTE");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logoBonzina.png"))); // NOI18N

        javax.swing.GroupLayout painelImagemFundo2Layout = new javax.swing.GroupLayout(painelImagemFundo2);
        painelImagemFundo2.setLayout(painelImagemFundo2Layout);
        painelImagemFundo2Layout.setHorizontalGroup(
            painelImagemFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelImagemFundo2Layout.setVerticalGroup(
            painelImagemFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImagemFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTitulo)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(97, 97, 97)
                        .addComponent(btnApagar)
                        .addGap(82, 82, 82)
                        .addComponent(btnLimpar)
                        .addGap(65, 65, 65)
                        .addComponent(btnEditar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(btnPesquisar)
                            .addGap(39, 39, 39)
                            .addComponent(btnCadastrar))))
                .addGap(48, 48, 48))
            .addComponent(painelImagemFundo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelImagemFundo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        //serve pra capturar a tecla enter, preenche a lista usando o a matriz
        //o metodo listarResultado fica encarregado de capturar oque foi pesquisado
        //deixa a lista visivel que mostra os nomes 
        if(txtPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(null , "Digite algo ou clique em Listar Todos", "Campo vazio", 2);
        } else {
           preencherLista();
           listaPesquisa.setVisible(true); 
        }
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
        //se a pesquisa estiver vazia ou não for selecionada, ele busca todos
        //os resultados do banco
        //TelaTabela é um JFrame adicional que está em [OutrosComponentes]
        //exibe a telaTabela, o setLocation...(null) bota essa tela bem no meio
        
        if(txtPesquisa.getText().equals("") || 
                txtPesquisa.getText().equals("Insira o nome e aperte enter...")) {
            preencherMatriz(false);
        } else {
            preencherMatriz(true);
        }
        
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
            telefone = TelefoneUtil.converter(telefone);
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
        dtChooser.setDate(null);
        txtEndereco.setText("");
        txtTelefone.setText("");  
        listaPesquisa.setVisible(false);
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        //verifica se o usuario tem certeza ao apagar, pega o id do map e manda
        //para o controlador apagar o paciente selecionado. 

        String titulo = "Confirmar exclusão de paciente";
        String confirmaApagar = "Tem certeza que deseja EXCLUIR este Paciente?";

        int retornoConfirmacao = JOptionPane.showConfirmDialog(null, confirmaApagar, titulo, 0, 2);

        System.out.println(getIdFromMap()); //teste de captura

        System.out.println(retornoConfirmacao + " captura confirmação");
        try {

            if (retornoConfirmacao == 0) {
                boolean retorno = false;
                int id = getIdFromMap();
                int contagem = agendamentoController.contaAgendamentosPaciente(id);
                if (contagem != 0) {
                    String tituloConsultas = "Consultas encontradas";
                    String mensagem = "Este paciente possui " + contagem
                            + " consultas agendadas, todas serão deletadas! \n"
                            + "Deseja continuar?";
                    int confirmacao = JOptionPane.showConfirmDialog(null, mensagem, tituloConsultas, 0, 2);
                    if (confirmacao == 0) {
                        agendamentoController.deleteAllAgendamentosPaciente(id);
                        retorno = pacienteController.apagar(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Exclusão cancelada!", "Cancelado", 1);
                        retorno = false;
                    }
                } else {
                    retorno = pacienteController.apagar(id);
                }

                if (retorno) {
                    JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso", "Apagado!", 1);
                }
            } else {
                throw new Mensagem("Exclusão cancelada!");

            }
            btnLimpar.doClick();

        } catch (Mensagem erro) {
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Aviso", 0);
        }

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
                throw new Mensagem("Por favor, insira um endereço válido!");
            }
            
            if(txtTelefone.getText().length() == 13){
                telefone = TelefoneUtil.converter(txtTelefone.getText());
            } else {
                throw new Mensagem("Por favor, insira um telefone válido!");
            }
            
            String titulo = "Confirmar edição de paciente";
            String confirmacao = "Você deseja editar as informações "
                    + "do paciente selecionado \n Deseja Continuar?";

            int retornoConfirmacao = JOptionPane.showConfirmDialog(null, confirmacao, titulo, 0, 2);

            System.out.println(retornoConfirmacao);
            
            if(retornoConfirmacao == 0){

                if(pacienteController.editar(id, nome, data, endereco, telefone)) {
                    
                    JOptionPane.showMessageDialog(null, "Paciente editado com sucesso", "Editado!", 1);
                    
                } else {
                    throw new Mensagem("Falha no método do controlador");
                }
                
            } else {
                throw new MensagemAlternativa("Edição cancelada!");
            }
            
            btnLimpar.doClick();//limpando os campos por simulacão de clique
            
        } catch(Mensagem erro){
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", 0);
        } catch(MensagemAlternativa mensagem) {
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, mensagem.getMessage(), "Cancelado", 1);
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        txtPesquisa.setText("");
    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastroPaciente telaCadastro = new TelaCadastroPaciente();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private com.toedter.calendar.JDateChooser dtChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList<String> listaPesquisa;
    private view.PainelImagemFundo painelImagemFundo2;
    private javax.swing.JTable tabelaGrafica;
    private javax.swing.JFrame telaTabela;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
