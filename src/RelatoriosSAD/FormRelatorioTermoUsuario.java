package RelatoriosSAD;

import Usuario.Usuario;

public class FormRelatorioTermoUsuario {
    private Usuario usuario;

    public FormRelatorioTermoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void gerarRelatorio() {
        try {

            // use Usuario object to load the daata

            String nome = usuario.getNome();
            String CESU = String.valueOf(usuario.getEtiquetaCESU());
            String tomboMicro = ManipulaNumero.manipularNumero((int) usuario.getTombamentoMicro());
            String tomboMonitor = ManipulaNumero.manipularNumero((int) usuario.getTombamentoMonitor());
            String tomboMonitor1 = ManipulaNumero.manipularNumero((int) usuario.getTombamentoMonitor1());
            String serieMicro = usuario.getSerieMicro();
            String serieMonitor = usuario.getSerieMonitor();
            String serieMonitor1 = usuario.getSerieMonitor1();
            String modeloMicro = usuario.getModeloMicro().getModelo();

            System.out.println("Nome: " + nome);
            System.out.println("CESU: " + CESU);
            System.out.println("Tombo Micro: " + tomboMicro);
            System.out.println("Tombo Monitor: " + tomboMonitor);
            System.out.println("Tombo Monitor 1: " + tomboMonitor1);
            System.out.println("Série Micro: " + serieMicro);
            System.out.println("Série Monitor: " + serieMonitor);
            System.out.println("Série Monitor 1: " + serieMonitor1);
            System.out.println("Modelo Micro: " + modeloMicro);


        } catch (Exception e) {

        }

    }


}
