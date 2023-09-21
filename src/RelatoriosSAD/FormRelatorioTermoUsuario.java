package RelatoriosSAD;

import Usuario.Usuario;

public class FormRelatorioTermoUsuario {
    private Usuario usuario;

    public FormRelatorioTermoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void gerarRelatorio() {
        try {
/*
            // use Usuario object to load the daata

            String nome = usuario.getNome();
            String CESU = String.valueOf(usuario.getEtiquetaCESU());
            String tomboMicro = String.valueOf(usuario.getTombamentoMicro());

*/
            String tomboMicro = manipularNumero(usuario.getTombamentoMicro());
        } catch (Exception e) {

        }

    // use the tombamento of the user to return a tombo starting with 120101.

    }


}



public static String manipularNumero(long numero) {
    // Transforma o número em uma string
    String numeroStr = String.valueOf(numero);

    // Conta quantos dígitos possui
    int qtdDigitos = numeroStr.length();

    // Adiciona '120101.' no início da string
    numeroStr = "120101." + numeroStr;

    // Separa a string em três partes
    String parte1 = numeroStr.substring(0, 7);  // '120101.'
    String parte2 = numeroStr.substring(7, 7 + qtdDigitos);  // Dígitos no meio
    String parte3 = numeroStr.substring(7 + qtdDigitos);  // Últimos 4 dígitos

    // Completa os dígitos no meio com zeros à esquerda
    while (parte2.length() < 6) {
        parte2 = "0" + parte2;
    }

    // Retorna a string completa
    return parte1 + parte2 + parte3;
}

public static void main(String[] args) {
    int numero = 1234567890;
    String resultado = manipularNumero(numero);
    System.out.println(resultado);
}
}