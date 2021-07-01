package view.telaPaciente.telaGerenciaPaciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Util {
    
    public static Date conversorData(String entrada) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        
        try {    
            data = sdf.parse(entrada);
            
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Erro na conversão de Data", 0);     
        }
        
        return data;
    }
    
    public static String conversorTelefone(String entrada) {
        
        String ddd = entrada.substring(1,3);
        
        String inicio = "";
        String termino = "";
        String saida;
        
        switch (entrada.length()) {
            case 13:
                inicio = entrada.substring(4, 8);
                termino = entrada.substring(10);
                break;
            case 14:
                inicio = entrada.substring(4, 9);
                termino = entrada.substring(11);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro na inserção do telefone", "erro telefone", 0);
                break;
        }    
        
        saida = ddd + inicio + termino;
        
        return saida;
        
    }
    
    
}
