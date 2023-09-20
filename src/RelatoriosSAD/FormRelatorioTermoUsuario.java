package RelatoriosSAD;
import Usuario.Usuario;


public class FormRelatorioTermoUsuario (Usuario usuario){
    Usuario usuario = new Usuario();

    public void gerarRelatorio(){
        String nome = usuario.getNome();
        String cesu = String.valueOf(usuario.getEtiquetaCESU());
        String serieMicro = usuario.getSerieMicro();
        String modeloMicro = usuario.getModeloMicro().getModelo();
        String serieMonitor = usuario.getSerieMonitor();
        String modeloMonitor = usuario.getModeloMonitor().getModelo();
        String serieMonitor1 = usuario.getSerieMonitor1();
        String modeloMonitor1 = usuario.getModeloMonitor1().getModelo();
        String Gerencia = usuario.getGerencia().getSiglaGerencia();
        String tomboMicro = String.valueOf(usuario.getTombamentoMicro());


    }
}
