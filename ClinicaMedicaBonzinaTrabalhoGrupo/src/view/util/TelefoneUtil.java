package view.util;

public class TelefoneUtil {
    
    public static String conversor(String entrada) {
        //esse metodo é só pra tirar oque vem da mascara "()-"
        //substring pega o indice inicial e para um antes da contagem
        //exemplo abcd.substring(1,3) --> resultado bc
        //lembre-se: o indice começa no 0, o 3 fica de fora, pega o 1 e o 2 = bc
        //se tiver só um numero igual no termino ele pega daquele até o final
        
        String ddd = entrada.substring(1,3);
        
        String inicio = entrada.substring(4, 8);
        
        String termino = entrada.substring(9);
        
        String saida = ddd + inicio + termino; 
                        
        return saida;
        
    }
    
    public static String formatar(String entrada) {
        
        String ddd = entrada.substring(0, 2);
        
        String inicio = entrada.substring(2, 6);
        
        String termino = entrada.substring(6);
        
        String saida = "(" + ddd + ")" + inicio + "-" + termino;
        
        return saida;
        
    }
        
}
