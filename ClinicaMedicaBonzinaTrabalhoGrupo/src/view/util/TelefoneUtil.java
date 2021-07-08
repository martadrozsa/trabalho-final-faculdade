package view.util;

public class TelefoneUtil {

    public static String converter(String entrada) {
        //esse metodo é só pra tirar oque vem da mascara "()-"
        //substring pega o indice inicial e para um antes da contagem
        //exemplo abcd.substring(1,3) --> resultado bc
        //lembre-se: o indice começa no 0, o 3 fica de fora, pega o 1 e o 2 = bc
        //se tiver só um numero igual no termino ele pega daquele até o final
        String ddd = "";
        String inicio = "";
        String termino = "";

        try {
            ddd = entrada.substring(1, 3);

            inicio = entrada.substring(4, 8);

            termino = entrada.substring(9);

        } catch (Exception e) {
            System.out.println("erro do converter na classe util " + e.getMessage());
        }

        String saida = ddd + inicio + termino;

        return saida;

    }

    public static String formatar(String entrada) {
        //esse metodo faz o oposto do anterior, ele insere os sinais no numero
        //serve pra uma apresentação mais elegante do resultado na tabela
        String ddd = "";
        String inicio = "";
        String termino = "";

        try {
            ddd = entrada.substring(0, 2);

            inicio = entrada.substring(2, 6);

            termino = entrada.substring(6);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String saida = "(" + ddd + ")" + inicio + "-" + termino;

        return saida;

    }

}
