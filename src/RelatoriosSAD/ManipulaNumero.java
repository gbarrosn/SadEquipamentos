package RelatoriosSAD;

public class ManipulaNumero {

    public static String manipularNumero(int numero, int gerencia) {

        String codigo_orgao = "120101.";

        if (gerencia == 9 || gerencia == 7){
            codigo_orgao = "120101.";
        } else if (gerencia == 15 || gerencia == 12){
            codigo_orgao = "140101.";
        } else if (gerencia == 11) {
            codigo_orgao = "150101.";
        }


        String numeroStr = String.valueOf(numero);

        // Conta quantos dígitos possui
        int qtdDigitos = numeroStr.length();

        int qtdZero = 10 - qtdDigitos;
        for (int i = 0; i < qtdZero; i++) {
            numeroStr = "0" + numeroStr;
        }
        // Adiciona '120101.' no início da string
        numeroStr = codigo_orgao + numeroStr;

        // Separa a string em três partes
        String parte1 = numeroStr.substring(0, 7);  // 'codigo do orgao + .'
        String parte2 = numeroStr.substring(7, 13);  // Dígitos no meio
        String parte3 = numeroStr.substring(13);  // Últimos 4 dígitos

        // Completa os dígitos no meio com zeros à esquerda
        while (parte2.length() < 6) {
            parte2 = "0" + parte2;
        }

        // Retorna a string completa
        return parte1 + parte2 + "." + parte3;
    }


    public static void main(String[] args) {

    }
}
