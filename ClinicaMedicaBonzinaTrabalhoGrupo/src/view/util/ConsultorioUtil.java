package view.util;

public class ConsultorioUtil {
    
    public static String converter(String entrada) {
        
    String saida = "";
        
    if(entrada.equals("CONSULTORIO_2")) {
        saida = "Consultório 2";
    } else {
        saida = "Consultório 1";
    }
        
    return saida;    
    }
    
}
