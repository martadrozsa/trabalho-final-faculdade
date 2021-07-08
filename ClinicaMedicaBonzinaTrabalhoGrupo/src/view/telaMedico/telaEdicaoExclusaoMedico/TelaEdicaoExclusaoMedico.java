package view.telaMedico.telaEdicaoExclusaoMedico;

import controller.AgendamentoController;
import javax.swing.ImageIcon;
import controller.MedicoController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Mensagem;
import view.MensagemAlternativa;
import view.telaMedico.telaCadastroMedico.TelaCadastroMedico;
import view.util.ConsultorioUtil;
import view.util.TelefoneUtil;

public class TelaEdicaoExclusaoMedico extends javax.swing.JFrame {

    MedicoController medicoController;
    AgendamentoController agendamentoController;
    DefaultListModel modeloLista;
    String[][] matrizMedicos;
    Map<Integer, String> idsCapturados;
    int indiceLista =-1;
    

    public TelaEdicaoExclusaoMedico() {
        
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        
        medicoController = new MedicoController();
        agendamentoController = new AgendamentoController();
        modeloLista = new DefaultListModel();
        idsCapturados = new HashMap<>();

        listaPesquisa.setModel(modeloLista);
        listaPesquisa.setVisible(false);

        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);

    }

    public void preencherLista() {

        modeloLista.clear();

        preencherMatriz(true);

        List<String> nomes = new ArrayList<>();

        int tamanhoMatriz = matrizMedicos.length;

        if (tamanhoMatriz != 0) {

            for (int i = 0; i < tamanhoMatriz; i++) {
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

    public void preencherMatriz(boolean tipoConsulta) {
        if (tipoConsulta) {
            matrizMedicos = medicoController.getMinhaMatrizTexto(txtPesquisa.getText());
        } else {
            matrizMedicos = medicoController.getMinhaMatrizTexto();
        }
        for (int i = 0; i < matrizMedicos.length; i++) {
            String capturaId = matrizMedicos[i][0];
            idsCapturados.put(i, capturaId);
        }
    }

    public int getIdFromMap() {
        int id;
        if (indiceLista != -1) {
            id = Integer.parseInt(idsCapturados.get(indiceLista));
        } else {
            id = -1;
            System.out.println("Erro na captura do id metodo getIdFromMap");
        }
        return id;
    }

    public void preencherCampos() {

        int i = indiceLista;
        
        String nome;
        String telefone;
        String crm;
        String especialidade;
        String periodo;
        String consultorio;
        
        try {
            if(matrizMedicos.length != 0) {
                nome =           matrizMedicos[i][1];
                telefone =       matrizMedicos[i][2];
                crm =            matrizMedicos[i][3];
                especialidade =  matrizMedicos[i][4];

                //tratar os debaixo pra entrar nos comboBox
                periodo =        matrizMedicos[i][5];
                consultorio =    matrizMedicos[i][6];
                
                txtNome.setText(nome);
                txtTelefone.setText(telefone);
                txtCRM.setText(crm);
                txtEspecialidade.setText(especialidade);

                //tratamento
                preencherCombos(periodo, consultorio);
                //ativar os botoẽs
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true); 
            
            } else {
                throw new Mensagem("Erro matriz vazia");
            }
            
        } catch (Mensagem erro)  {
            System.out.println(erro);
        }
        
    }

    public void preencherCampos(String nome, String crm, String especialidade,
            String periodo, String consultorio, String telefone) {

        txtNome.setText(nome);
        txtCRM.setText(crm);
        txtEspecialidade.setText(especialidade);
        txtTelefone.setText(telefone);

        preencherCombos(periodo, consultorio);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        
    }

    public void preencherCombos(String periodo, String consultorio) {

        if (periodo.equals("MATUTINO")) {
            cmbPeriodo.setSelectedIndex(0);
        } else if (periodo.equals("VESPERTINO")) {
            cmbPeriodo.setSelectedIndex(1);
        } else {
            cmbPeriodo.setSelectedIndex(-1);
            System.out.println("Erro na captura do periodo pro CMB");
        }

        if (consultorio.equals("CONSULTORIO_1") || consultorio.equals("Consultório 1")) {
            cmbConsultorio.setSelectedIndex(0);
        } else if (consultorio.equals("CONSULTORIO_2") || consultorio.equals("Consultório 2")) {
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
                ConsultorioUtil.converter(matrizMedicos[i][6]),                            //__________________________________________________
                TelefoneUtil.formatar(matrizMedicos[i][2]),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaTabela = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGrafica = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        pnlCampos = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCRM = new javax.swing.JLabel();
        lblEspecialidade = new javax.swing.JLabel();
        lblConsultorio = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCRM = new javax.swing.JTextField();
        txtEspecialidade = new javax.swing.JTextField();
        lblPeriodo1 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox<>();
        cmbConsultorio = new javax.swing.JComboBox<>();
        txtTelefone = new javax.swing.JFormattedTextField();
        pnlEditar = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlPesquisa = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        listaPesquisa = new javax.swing.JList<>();
        btnCadastrar = new javax.swing.JButton();
        painelImagemFundo2 = new view.PainelImagemFundo();
        txtTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaTabelaLayout.setVerticalGroup(
            telaTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Médico");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlCampos.setBackground(new java.awt.Color(255, 255, 255));
        pnlCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblNome.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblNome.setText("Nome");

        lblCRM.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblCRM.setText("CRM");

        lblEspecialidade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblEspecialidade.setText("Especialidade");

        lblConsultorio.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblConsultorio.setText("Consultório");

        lblTelefone.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblTelefone.setText("Telefone");

        lblPeriodo1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblPeriodo1.setText("Período");

        cmbPeriodo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cmbPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino" }));
        cmbPeriodo.setSelectedIndex(-1);

        cmbConsultorio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cmbConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consultório 1", "Consultório 2" }));
        cmbConsultorio.setSelectedIndex(-1);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeriodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCamposLayout.createSequentialGroup()
                                .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(400, 400, 400)
                                .addComponent(lblConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(lblEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(lblCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCRM)
                    .addComponent(txtCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecialidade)
                    .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultorio)
                    .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodo1))
                .addGap(30, 30, 30)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pnlEditar.setBackground(new java.awt.Color(255, 255, 255));

        btnLimpar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditarLayout = new javax.swing.GroupLayout(pnlEditar);
        pnlEditar.setLayout(pnlEditarLayout);
        pnlEditarLayout.setHorizontalGroup(
            pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnCancelar)
                .addGap(92, 92, 92)
                .addComponent(btnExcluir)
                .addGap(79, 79, 79)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnEditar))
        );
        pnlEditarLayout.setVerticalGroup(
            pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlPesquisa.setBackground(new java.awt.Color(255, 255, 255));

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

        btnPesquisar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnPesquisar.setText("Listar todos");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        listaPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaPesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        listaPesquisa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPesquisaMouseClicked(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPesquisaLayout = new javax.swing.GroupLayout(pnlPesquisa);
        pnlPesquisa.setLayout(pnlPesquisaLayout);
        pnlPesquisaLayout.setHorizontalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPesquisaLayout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnPesquisar)
                        .addGap(69, 69, 69)
                        .addComponent(btnCadastrar))
                    .addComponent(listaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        pnlPesquisaLayout.setVerticalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(listaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        painelImagemFundo2.setImg(new ImageIcon("src/view/imagens/fundo/imagem_fundo2.png"));

        txtTitulo.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulo.setText("GERENCIAR MÉDICO");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logoBonzina.png"))); // NOI18N

        javax.swing.GroupLayout painelImagemFundo2Layout = new javax.swing.GroupLayout(painelImagemFundo2);
        painelImagemFundo2.setLayout(painelImagemFundo2Layout);
        painelImagemFundo2Layout.setHorizontalGroup(
            painelImagemFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelImagemFundo2Layout.setVerticalGroup(
            painelImagemFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImagemFundo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelImagemFundo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnlEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelImagemFundo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(pnlEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        if(txtPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(null , "Digite algo ou clique em \"Listar Todos\"", "Campo vazio", 2);
        } else {
            preencherLista();
            listaPesquisa.setVisible(true);
        }        
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        txtPesquisa.setText("");
    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void tabelaGraficaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaGraficaMouseClicked

        if (evt.getClickCount() == 2) {

            String nome = "";
            String crm = "";
            String especialidade = "";
            String consultorio = "";
            String periodo = "";
            String telefone = "";

            if (this.tabelaGrafica.getSelectedRow() != -1) {

                nome = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 0).toString();
                crm = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 1).toString();
                especialidade = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 2).toString();
                periodo = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 3).toString();
                consultorio = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 4).toString();
                telefone = tabelaGrafica.getValueAt(tabelaGrafica.getSelectedRow(), 5).toString();

                indiceLista = tabelaGrafica.getSelectedRow();
            } else {
                System.out.println("erro no metodo de captura da tabelagrafica, -1");
            }
            preencherCampos(nome, crm, especialidade, periodo, consultorio, telefone);

            telaTabela.dispose();
        }
    }//GEN-LAST:event_tabelaGraficaMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        preencherMatriz(false);
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
        btnExcluir.setEnabled(false);
        indiceLista = -1;
        txtCRM.setText("");
        txtEspecialidade.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtPesquisa.setText("Insira o nome e aperte enter...");

        cmbConsultorio.setSelectedIndex(-1);
        cmbPeriodo.setSelectedIndex(-1);
        listaPesquisa.setVisible(false);

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        String titulo = "Confirmar exclusão de médico";
        String confirmaApagar = "Tem certeza que deseja EXCLUIR este Médico";

        int retornoConfirmacao = JOptionPane.showConfirmDialog(null, confirmaApagar, titulo, 0, 2);

        System.out.println(retornoConfirmacao);
        try {
            
            if (retornoConfirmacao == 0) {
                boolean retorno = false;
                int id = getIdFromMap();
                int contagem = agendamentoController.contaAgendamentosMedico(id);
                if (contagem != 0) {
                    String tituloConsultas = "Consultas encontradas";
                    String mensagem = "Este médico possui " + contagem
                            + " consulta(s) agendada(s), todas serão deletadas! \n"
                            + "Deseja continuar?";
                    int confirmacao = JOptionPane.showConfirmDialog(null, mensagem, tituloConsultas, 0, 2);
                    if (confirmacao == 0) {
                        agendamentoController.deleteAllAgendamentosPaciente(id);
                        retorno = medicoController.apagar(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
                        retorno = false;
                    }
                } else {
                    retorno = medicoController.apagar(id);
                }
 
                if (retorno) {
                    JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso", "Apagado!", 1);
                }
            } else {
                throw new Mensagem("Exclusão cancelada!");
            }
            btnLimpar.doClick();
            
        } catch (Mensagem erro) {
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Aviso", 0);
        } 
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            int id;
            String nome = "";
            int crm = 0;
            String especialidade = "";
            String periodo = "";
            String consultorio = "";
            String telefone = "";

            if (getIdFromMap() != -1) {
                id = getIdFromMap();
            } else {
                throw new Mensagem("Erro no método getIdFromMap");
            }

            if (txtNome.getText().length() > 6) {
                nome = txtNome.getText();
            } else {
                throw new Mensagem("O nome inserido é muito pequeno, corrija!");
            }

            if (txtCRM.getText().length() > 3) {
                crm = Integer.parseInt(txtCRM.getText());
            } else {
                throw new Mensagem("O CRM inserido é muito curto, corrija");
            }

            if (txtEspecialidade.getText().length() > 5) {
                especialidade = txtEspecialidade.getText();
            } else {
                throw new Mensagem("A especialidade inserida é muito curta, corrija!");
            }

            if (cmbPeriodo.getSelectedIndex() == 0) {
                periodo = "MATUTINO";
            } else if (cmbPeriodo.getSelectedIndex() == 1) {
                periodo = "VESPERTINO";
            } else {
                throw new Mensagem("Você deve selecionar um Periodo!");
            }

            if (cmbConsultorio.getSelectedIndex() == 0) {
                consultorio = "CONSULTORIO_1";
            } else if (cmbConsultorio.getSelectedIndex() == 1) {
                consultorio = "CONSULTORIO_2";
            } else {
                throw new Mensagem("Você deve selecionar um Consulório");
            }
            
            if(txtTelefone.getText().length() == 13) {
                telefone = TelefoneUtil.converter(txtTelefone.getText());
            } else {
                throw new Mensagem("Telefone inválido");
            }
            
            String titulo = "Confirmar edição de médico";
            String confirmacao = "Você deseja editar as informações "
                    + "do médico selecionado \n Deseja Continmuar?";

            int retornoConfirmacao = JOptionPane.showConfirmDialog(null, confirmacao, titulo, 0, 2);

            System.out.println(retornoConfirmacao);

            if (retornoConfirmacao == 0) {

                if (medicoController.editar(crm, especialidade, periodo, consultorio, id, nome, telefone)) {

                    JOptionPane.showMessageDialog(null, "Médico editado com sucesso", "Editado!", 1);

                } else {
                    throw new Mensagem("Falha na edição!");
                }
                
            } else {
                throw new MensagemAlternativa("Edição cancelada!");
            }
            
            btnLimpar.doClick(); //limpando os campos por simulação de clique
            
        } catch (Mensagem erro) {
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", 0);
        } catch (MensagemAlternativa mensagem) {
            btnLimpar.doClick();
            JOptionPane.showMessageDialog(null, mensagem.getMessage(), "Cancelado", 1);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastroMedico telaCadastro = new TelaCadastroMedico();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        listaPesquisa.setVisible(false);
    }//GEN-LAST:event_txtPesquisaKeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoExclusaoMedico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbConsultorio;
    private javax.swing.JComboBox<String> cmbPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCRM;
    private javax.swing.JLabel lblConsultorio;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeriodo1;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JList<String> listaPesquisa;
    private view.PainelImagemFundo painelImagemFundo2;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlEditar;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JTable tabelaGrafica;
    private javax.swing.JFrame telaTabela;
    private javax.swing.JTextField txtCRM;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
