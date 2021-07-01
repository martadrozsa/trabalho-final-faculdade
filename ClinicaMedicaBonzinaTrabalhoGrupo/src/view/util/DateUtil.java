package view.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DateUtil {
    
    public static Date conversorData(String entrada) {
        //metodo pra pegar o data que vem como texto do banco e transformar em data
        //isso serve pra preencher o JDataChooser, aquele calendario de escolher a data
        //SimpleDateFormat cria uma data, na hora de instanciar definimos o padrao de 
        //entrada "yyyy-MM-dd", instanciamos uma data (new Date(), e depois atribuimos
        //o resultado do SimpleDateFormat a ela, retornamos a data como resultado do
        //metodo, repare, o metodo recebe uma String como parametro(argumento)
        //retorna uma Data no final
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        
        try {    
            data = sdf.parse(entrada);
            
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Erro na conversão de Data", 0);     
        }
        
        return data;
    }
    
    public static String conversorTelefone(String entrada) {
        //esse metodo é só pra tirar oque vem da mascara "()-"
        //substring pega o indice inicial e para um antes da contagem
        //exemplo abcd.substring(1,3) --> resultado bc
        //lembre-se: o indice começa no 0, o 3 fica de fora, pega o 1 e o 2 = bc
        //se tiver só um numero igual no termino ele pega daquele até o final
        
        String ddd = entrada.substring(1,3);
        
        String inicio = entrada.substring(4, 8);
        
        String termino = entrada.substring(10);
        
        String saida= ddd + inicio + termino;
        
        return saida;
        
    }
    
    
}
