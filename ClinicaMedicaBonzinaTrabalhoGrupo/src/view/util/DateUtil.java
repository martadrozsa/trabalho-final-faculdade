package view.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DateUtil {
    
    public static Date converter(String entrada) {
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
    
    public static String formatar(String entrada) {
        
        String saida = "";
        
        try {
            String dia = entrada.substring(8);
            
            String mes = entrada.substring(5, 7);
            
            String ano = entrada.substring(0, 4);
            
            saida = dia + "/" + mes + "/" + ano;
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return saida;
    }
}
