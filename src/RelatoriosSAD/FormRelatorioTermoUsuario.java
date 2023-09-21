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
            String tomboMicro = String.valueOf((usuario.getTombamentoMicro()));
        } catch (Exception e) {

        }

    // use the tombamento of the user to return a tombo starting with 120101.

    }


}
