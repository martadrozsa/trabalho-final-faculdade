package controller;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import model.business.PacienteBusiness;
import model.entity.Paciente;

public class PacienteController {
    private final PacienteBusiness pacienteBusiness;

    public PacienteController() {
        this.pacienteBusiness = new PacienteBusiness();
    }

    public boolean cadastrar(String nome, Date dataNascimento, String endereco, String telefone) {
        Paciente paciente = new Paciente(dataNascimento, endereco, nome, telefone);
        return pacienteBusiness.insertPacienteIntoBD(paciente);
    }

    public boolean editar(String nome, Date dataNascimento, String endereco, int id, String telefone) {
        Paciente paciente = new Paciente(dataNascimento, endereco, id, nome, telefone);
        return pacienteBusiness.updatePacienteInBD(paciente);
    }

    public boolean apagar(int id) {
        return pacienteBusiness.deletePacienteFromBD(id);
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
    //    List<Paciente> resultList = pacienteBusiness.getMinhaListaByNome(inputNomePesquisa);
        List<Paciente> resultList = tabelaTeste();

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
    
    
    public List<Paciente> tabelaTeste() {
        LocalDate datal = LocalDate.of(2021, 06, 28);
        java.sql.Date data = java.sql.Date.valueOf(datal);
        Paciente paciente1 = new Paciente(data, "rua 0", 10, "tico doido", "4433331122");
        Paciente paciente2 = new Paciente(data, "rua 1", 20, "maria corona", "44123456789");
        Paciente paciente3 = new Paciente(data, "rua 2", 30, "marco loco", "44899991111");
        Paciente paciente4 = new Paciente(data, "rua 3", 40, "antonio lindo", "44899992221");
        Paciente paciente5 = new Paciente(data, "rua 4", 50, "amanda gabriela", "4488818888");
        Paciente paciente6 = new Paciente(data, "rua 5", 60, "anna julia", "4499111222");
        Paciente paciente7 = new Paciente(data, "rua 6", 70, "kelly souza", "4422111333");
        List<Paciente> lista = new ArrayList<>();
        lista.add(paciente1);
        lista.add(paciente2);
        lista.add(paciente3);
        lista.add(paciente4);
        lista.add(paciente5);
        lista.add(paciente6);
        lista.add(paciente7);
        return lista;
    }   
}
