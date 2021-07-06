package controller;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.business.PacienteBusiness;
import model.entity.Paciente;


public class PacienteController {
    
    private final PacienteBusiness pacienteBusiness;
    private final AgendamentoController agendamentoController;
    
    public PacienteController() {
        this.pacienteBusiness = new PacienteBusiness();
        agendamentoController = new AgendamentoController();
    }

    public boolean cadastrar(String nome, Date dataNascimento, String endereco, String telefone) {
        Paciente paciente = new Paciente(dataNascimento, endereco, nome, telefone);
        return pacienteBusiness.insertPacienteIntoBD(paciente);
    }

    public boolean editar(int id, String nome, Date dataNascimento, String endereco, String telefone) {
        Paciente paciente = new Paciente(dataNascimento, endereco, id, nome, telefone);
        return pacienteBusiness.updatePacienteInBD(paciente);
    }

    public boolean apagar(int id) {
        boolean retorno = false;
        int contagem = agendamentoController.contaAgendamentosPaciente(id);
        if(contagem != 0) {
            String titulo = "Consultas encontradas";
            String mensagem = "Este paciente possui " + contagem + 
                    " consultas agendadas, todas serão deletadas! \n" +
                    "Deseja continuar?";
            int confirmacao = JOptionPane.showConfirmDialog(null, mensagem, titulo, 0, 2);
            if(confirmacao == 0) {
                agendamentoController.deleteAllAgendamentosPaciente(id);
                retorno = pacienteBusiness.deletePacienteFromBD(id);
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão cancelada!", "Cancelado", 1);
                retorno = false;
            }
        } else {
            retorno = pacienteBusiness.deletePacienteFromBD(id);
        }
            return retorno;
    }

    public List<Paciente> getMinhaLista() {
        return pacienteBusiness.getMinhaLista();
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        
        List<Paciente> minhaLista = pacienteBusiness.getMinhaLista();
        int tamanho = minhaLista.size();
        
        String[][] matrizPacientes = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            matrizPacientes[i][0] = minhaLista.get(i).getId() + "";
            matrizPacientes[i][1] = minhaLista.get(i).getNome();
            matrizPacientes[i][2] = minhaLista.get(i).getDataNascimento() + "";
            matrizPacientes[i][3] = minhaLista.get(i).getEndereco();
            matrizPacientes[i][4] = minhaLista.get(i).getTelefone() + "";
        }
        return matrizPacientes;
    }
    
    // transformando os dados da base em uma matriz de texto para imprimir na tela
    // método de pesquisa para a TelaPesquisaView e para a TelaBuscarPacienteView
    public String[][] getMinhaMatrizTexto(String inputNomePesquisa) {
        
        List<Paciente> resultList = pacienteBusiness.getMinhaListaByNome(inputNomePesquisa);
        int tamanho = resultList.size();
        
        String[][] resulMatrizPacientes = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            resulMatrizPacientes[i][0] = resultList.get(i).getId() + "";
            resulMatrizPacientes[i][1] = resultList.get(i).getNome();
            resulMatrizPacientes[i][2] = resultList.get(i).getDataNascimento()+ "";
            resulMatrizPacientes[i][3] = resultList.get(i).getEndereco();
            resulMatrizPacientes[i][4] = resultList.get(i).getTelefone()+ "";
        }
        return resulMatrizPacientes;
    }
}
