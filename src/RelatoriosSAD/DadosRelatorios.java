/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RelatoriosSAD;

import Geral.ConectarSQL;
import Micro.Configuracao.Configuracao;
import Micro.MarcaMicro.MarcaMicro;
import Micro.ModeloMicro.ModeloMicro;
import Micro.OS.OS;
import Micro.PlataformaMicro.PlataformaMicro;
import Micro.ProprietarioMicro.ProprietarioMicro;
import Monitor.MarcaMonitor.MarcaMonitor;
import Monitor.ModeloMonitor.ModeloMonitor;
import Monitor.ProprietarioMonitor.ProprietarioMonitor;
import SADpe.Cargo.Cargo;
import SADpe.Gerencia.Gerencia;
import SADpe.Pavimento.Pavimento;
import Usuario.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosRelatorios extends ConectarSQL implements InterfaceRelatorios{

    
    //RELATORIO APENAS PAVIMENTO
        @Override
    public int contagemUsuariosPavimento(Usuario UsuarioPavimentoRelatorio) throws Exception {
        
         int totalPavimento=0;  
        
        try {
            Statement conex = conectar();
            String sql = "SELECT count(*) AS Quantidade FROM Usuario ";
            sql += " WHERE id_pavimento="+UsuarioPavimentoRelatorio.getPavimentoUsuario().getIdPavimento();
         
            ResultSet rs = conex.executeQuery(sql);
            
            while (rs.next()) {
                  totalPavimento = (rs.getInt("Quantidade"));                
            }
            
            
        }catch (SQLException e){
            throw new Exception("Erro ao executar Contagem total de Máquinas deste Pavimento" + e.getMessage());
        }
        desconectar();
        
        return totalPavimento;
    }
    
    
    @Override
    public int contagemTotal() throws Exception {
           
         int total=0;  
        
        try {
            Statement conex = conectar();
            String sql = "SELECT count(*) AS Quantidade FROM Usuario ";
            sql += " WHERE id_pavimento=id_pavimento";
         
            ResultSet rs = conex.executeQuery(sql);
            
            while (rs.next()) {
                  total = (rs.getInt("Quantidade"));                
            }
            
            
        }catch (SQLException e){
            throw new Exception("Erro ao executar Contagem total de Máquinas deste Pavimento" + e.getMessage());
        }
        desconectar();
        
        return total;
    }
    
    
     //RELATORIO APENAS PAVIMENTO
    @Override
    public ArrayList<Usuario> listarUsuarioPavimentoRelatorio(Usuario userPavimentoRelatorio) throws Exception {
        
          ArrayList<Usuario> listaUserPavimentoRelatorio = new ArrayList<Usuario>(); 

            try {     

                Statement conex = conectar();
                //instrução SQL Consulta usuário usando filtro SE HOUVER
                String sql = "select * from Usuario,Gerencia,Cargo,Pavimento,Configuracao,Marca_Micro,Modelo_Micro,Plataforma,";
                sql += "Proprietario_Micro,Sistema,Modelo_Monitor,Marca_Monitor,Proprietario_Monitor";
                sql += " where usuario.id_gerencia=gerencia.id_gerencia and usuario.id_cargo=cargo.id_cargo and usuario.id_pavimento=pavimento.id_pavimento";
                sql += " and usuario.id_configuracao=configuracao.id_configuracao and usuario.id_marca_micro=marca_micro.id_marca_micro";
                sql += " and usuario.id_modelo_micro=modelo_micro.id_modelo_micro and usuario.id_plataforma=plataforma.id_plataforma and usuario.id_proprietario_micro=proprietario_micro.id_proprietario_micro";
                sql += " and usuario.id_so=sistema.id_so and usuario.id_modelo_monitor=modelo_monitor.id_modelo_monitor and usuario.id_marca_monitor=marca_monitor.id_marca_monitor";
                sql += " and usuario.id_proprietario_monitor=proprietario_monitor.id_proprietario_monitor";                
                
                sql += " and usuario.id_pavimento=" + userPavimentoRelatorio.getPavimentoUsuario().getIdPavimento()+ " ";
                
                
                /*
                if ((userPavimentoRelatorio.getNome().trim().equals(""))== false){
                    sql += " and nome LIKE '%" + userPavimentoRelatorio.getNome().trim() + "%'";
                } 
                
                if (userPavimentoRelatorio.getEtiquetaCMTECH() > 0) {
                    sql += " and cmtech LIKE '%"+ userPavimentoRelatorio.getEtiquetaCMTECH()+ "%'";
                }
                */
                
               sql += "  order by nome";
                    //executando a instrução sql
                ResultSet rs = conex.executeQuery(sql);
                    //Enquanto houver resultado eles são guardados no ArrayList  
               while (rs.next()) {                
                    Usuario user = new Usuario();
                    user.setId_usuario(rs.getInt("id_usuario"));
                    user.setNomepc(rs.getString("host_nome"));
                    user.setNome(rs.getString("nome"));
                    user.setTombamentoMicro(rs.getInt("tombo_micro"));
                    user.setSerieMicro(rs.getString("serie_micro"));
                    user.setTombamentoMonitor(rs.getInt("tombo_monitor"));
                    user.setSerieMonitor(rs.getString("serie_monitor"));
                    user.setEtiquetaCESU(rs.getInt("cmtech"));
                    user.setGarantia(rs.getString("garantia"));
                    user.setNotebook(rs.getString("notebook"));
                        user.setNovoTomboMicro(rs.getString("novo_tombo_micro"));
                        user.setNovoTomboMonitor(rs.getString("novo_tombo_monitor"));
                        user.setTermo_responsabilidade(rs.getBoolean("possui_termo"));
                    //Chaves estrangeiras:
                        //Gerencia:
                        Gerencia gerencia = new Gerencia();
                        gerencia.setIdGerencia(rs.getInt("id_gerencia"));
                        gerencia.setGerencia(rs.getString("gerencia"));
                            user.setGerencia(gerencia);
                        //Cargo:
                        Cargo cargo = new Cargo();
                        cargo.setIdCargo(rs.getInt("id_cargo"));
                        cargo.setCargo(rs.getString("cargo"));
                            user.setCargo(cargo);   
                        //Pavimento:
                        Pavimento pavimento = new Pavimento();
                        pavimento.setIdPavimento(rs.getInt("id_pavimento"));
                        pavimento.setPavimento(rs.getString("pavimento"));
                            user.setPavimentoUsuario(pavimento);
                        //Configuracao:
                        Configuracao configuracao = new Configuracao();
                        configuracao.setIdConfiguracao(rs.getInt("id_configuracao"));
                        configuracao.setConfiguracao(rs.getString("configuracao")); 
                            user.setConfigMicro(configuracao);
                        //Marca Micro:
                        MarcaMicro marcamicro = new MarcaMicro();
                        marcamicro.setIdMarca(rs.getInt("id_marca_micro"));
                        marcamicro.setMarca(rs.getString("marca_micro"));
                            user.setMarcaMicro(marcamicro);
                        //Modelo Micro:
                        ModeloMicro modeloMicro = new ModeloMicro();
                        modeloMicro.setIdModelo(rs.getInt("id_modelo_micro"));
                        modeloMicro.setModelo(rs.getString("modelo_micro"));
                            user.setModeloMicro(modeloMicro);
                        //Plataforma:
                        PlataformaMicro plataforma = new PlataformaMicro();
                        plataforma.setIdPlataforma(rs.getInt("id_plataforma"));
                        plataforma.setPlataforma(rs.getString("plataforma"));
                            user.setPlataformaMicro(plataforma);
                        //Proprietário Micro:
                        ProprietarioMicro proprietarioMicro = new ProprietarioMicro();
                        proprietarioMicro.setIdProprietario(rs.getInt("id_proprietario_micro"));
                        proprietarioMicro.setProprietario(rs.getString("proprietario_micro")); 
                            user.setProprietarioMicro(proprietarioMicro);
                        //SO:
                        OS os = new OS();
                        os.setIdOS(rs.getInt("id_so"));
                        os.setOs(rs.getString("so"));
                            user.setOsMicro(os);
                        //Modelo Monitor:
                        ModeloMonitor modeloMonitor = new ModeloMonitor();
                        modeloMonitor.setIdModelo(rs.getInt("id_modelo_monitor"));
                        modeloMonitor.setModelo(rs.getString("modelo_monitor"));
                            user.setModeloMonitor(modeloMonitor);
                        //Marca Monitor:
                        MarcaMonitor marcaMonitor = new MarcaMonitor();
                        marcaMonitor.setIdMarca(rs.getInt("id_marca_monitor"));
                        marcaMonitor.setMarca(rs.getString("marca_monitor"));
                            user.setMarcaMonitor(marcaMonitor);
                        //Proprietario Monitor:
                        ProprietarioMonitor proprietarioMonitor = new ProprietarioMonitor();
                        proprietarioMonitor.setIdProprietario(rs.getInt("id_proprietario_monitor"));
                        proprietarioMonitor.setProprietario(rs.getString("proprietario_monitor"));
                            user.setProprietarioMonitor(proprietarioMonitor);
                  
                            listaUserPavimentoRelatorio.add(user);
                }
            } catch (SQLException e) {
                    //caso haja algum erro neste método será levantada esta execeção
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                //fechando a conexão com o banco de dados
            desconectar();
                //retornando uma coleção de users
            return listaUserPavimentoRelatorio;
    }
      
    
    //RELATORIO PERSONALIZADO
    @Override
    public ArrayList<Usuario> listarUsuarioRelatorioPersonalizado(Usuario userRelatorioPersonalizado,Relatorios checkRelatorio) throws Exception {
        
         ArrayList<Usuario> listaUserPavimentoRelatorio = new ArrayList<Usuario>(); 

            try {     

                Statement conex = conectar();
                //instrução SQL Consulta usuário usando filtro SE HOUVER
                String sql = "select * from Usuario,Gerencia,Cargo,Pavimento,Configuracao,Marca_Micro,Modelo_Micro,Plataforma,";
                sql += "Proprietario_Micro,Sistema,Modelo_Monitor,Marca_Monitor,Proprietario_Monitor";
                sql += " where usuario.id_gerencia=gerencia.id_gerencia and usuario.id_cargo=cargo.id_cargo and usuario.id_pavimento=pavimento.id_pavimento";
                sql += " and usuario.id_configuracao=configuracao.id_configuracao and usuario.id_marca_micro=marca_micro.id_marca_micro";
                sql += " and usuario.id_modelo_micro=modelo_micro.id_modelo_micro and usuario.id_plataforma=plataforma.id_plataforma and usuario.id_proprietario_micro=proprietario_micro.id_proprietario_micro";
                sql += " and usuario.id_so=sistema.id_so and usuario.id_modelo_monitor=modelo_monitor.id_modelo_monitor and usuario.id_marca_monitor=marca_monitor.id_marca_monitor";
                sql += " and usuario.id_proprietario_monitor=proprietario_monitor.id_proprietario_monitor";                
                
                //sql += " and usuario.id_pavimento=" + userPavimentoRelatorio.getPavimentoUsuario().getIdPavimento()+ " ";
                
                
                
                if ((checkRelatorio.getRelatorioCheckPavimento()==1 )){
                    sql += " and usuario.id_pavimento=" + userRelatorioPersonalizado.getPavimentoUsuario().getIdPavimento()+ " ";
                } 
                
                if (checkRelatorio.getRelatorioCheckGerencia()==1) {
                    sql += " and usuario.id_gerencia=" + userRelatorioPersonalizado.getGerencia().getIdGerencia()+ " ";
                }
                
                if (checkRelatorio.getRelatorioCheckModeloMicro()==1) {
                    sql += " and usuario.id_gerencia=" + userRelatorioPersonalizado.getModeloMicro().getIdModelo()+ " ";
                }
                
                
               sql += "  order by pavimento.id_pavimento,gerencia.id_gerencia,nome";
                    //executando a instrução sql
                ResultSet rs = conex.executeQuery(sql);
                    //Enquanto houver resultado eles são guardados no ArrayList  
               while (rs.next()) {                
                    Usuario user = new Usuario();
                    user.setId_usuario(rs.getInt("id_usuario"));
                    user.setNomepc(rs.getString("host_nome"));
                    user.setNome(rs.getString("nome"));
                    user.setTombamentoMicro(rs.getInt("tombo_micro"));
                    user.setSerieMicro(rs.getString("serie_micro"));
                    user.setTombamentoMonitor(rs.getInt("tombo_monitor"));
                    user.setSerieMonitor(rs.getString("serie_monitor"));
                    user.setEtiquetaCESU(rs.getInt("cmtech"));
                    user.setGarantia(rs.getString("garantia"));
                    user.setNotebook(rs.getString("notebook"));
                    
                        user.setNovoTomboMicro(rs.getString("novo_tombo_micro"));
                        user.setNovoTomboMonitor(rs.getString("novo_tombo_monitor"));
                        user.setTermo_responsabilidade(rs.getBoolean("possui_termo"));
                        
                    //Chaves estrangeiras:
                        //Gerencia:
                        Gerencia gerencia = new Gerencia();
                        gerencia.setIdGerencia(rs.getInt("id_gerencia"));
                        gerencia.setGerencia(rs.getString("gerencia"));
                            user.setGerencia(gerencia);
                        //Cargo:
                        Cargo cargo = new Cargo();
                        cargo.setIdCargo(rs.getInt("id_cargo"));
                        cargo.setCargo(rs.getString("cargo"));
                            user.setCargo(cargo);   
                        //Pavimento:
                        Pavimento pavimento = new Pavimento();
                        pavimento.setIdPavimento(rs.getInt("id_pavimento"));
                        pavimento.setPavimento(rs.getString("pavimento"));
                            user.setPavimentoUsuario(pavimento);
                        //Configuracao:
                        Configuracao configuracao = new Configuracao();
                        configuracao.setIdConfiguracao(rs.getInt("id_configuracao"));
                        configuracao.setConfiguracao(rs.getString("configuracao")); 
                            user.setConfigMicro(configuracao);
                        //Marca Micro:
                        MarcaMicro marcamicro = new MarcaMicro();
                        marcamicro.setIdMarca(rs.getInt("id_marca_micro"));
                        marcamicro.setMarca(rs.getString("marca_micro"));
                            user.setMarcaMicro(marcamicro);
                        //Modelo Micro:
                        ModeloMicro modeloMicro = new ModeloMicro();
                        modeloMicro.setIdModelo(rs.getInt("id_modelo_micro"));
                        modeloMicro.setModelo(rs.getString("modelo_micro"));
                            user.setModeloMicro(modeloMicro);
                        //Plataforma:
                        PlataformaMicro plataforma = new PlataformaMicro();
                        plataforma.setIdPlataforma(rs.getInt("id_plataforma"));
                        plataforma.setPlataforma(rs.getString("plataforma"));
                            user.setPlataformaMicro(plataforma);
                        //Proprietário Micro:
                        ProprietarioMicro proprietarioMicro = new ProprietarioMicro();
                        proprietarioMicro.setIdProprietario(rs.getInt("id_proprietario_micro"));
                        proprietarioMicro.setProprietario(rs.getString("proprietario_micro")); 
                            user.setProprietarioMicro(proprietarioMicro);
                        //SO:
                        OS os = new OS();
                        os.setIdOS(rs.getInt("id_so"));
                        os.setOs(rs.getString("so"));
                            user.setOsMicro(os);
                        //Modelo Monitor:
                        ModeloMonitor modeloMonitor = new ModeloMonitor();
                        modeloMonitor.setIdModelo(rs.getInt("id_modelo_monitor"));
                        modeloMonitor.setModelo(rs.getString("modelo_monitor"));
                            user.setModeloMonitor(modeloMonitor);
                        //Marca Monitor:
                        MarcaMonitor marcaMonitor = new MarcaMonitor();
                        marcaMonitor.setIdMarca(rs.getInt("id_marca_monitor"));
                        marcaMonitor.setMarca(rs.getString("marca_monitor"));
                            user.setMarcaMonitor(marcaMonitor);
                        //Proprietario Monitor:
                        ProprietarioMonitor proprietarioMonitor = new ProprietarioMonitor();
                        proprietarioMonitor.setIdProprietario(rs.getInt("id_proprietario_monitor"));
                        proprietarioMonitor.setProprietario(rs.getString("proprietario_monitor"));
                            user.setProprietarioMonitor(proprietarioMonitor);
                  
                            listaUserPavimentoRelatorio.add(user);
                }
            } catch (SQLException e) {
                    //caso haja algum erro neste método será levantada esta execeção
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                //fechando a conexão com o banco de dados
            desconectar();
                //retornando uma coleção de users
            return listaUserPavimentoRelatorio;
    }

    @Override
    public int contagemUsuariosPersonalizado(Usuario UsuarioRelatorioPersonalizado,Relatorios checkRelatorio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public ArrayList<Pavimento> listarPavimento(Pavimento filtroPavimento) throws Exception {
        
        ArrayList<Pavimento> listaPavimento = new ArrayList<Pavimento>(); 

            try {     

                Statement conex = conectar();
               
                String sql = "select * from Pavimento";
                sql += " where pavimento=pavimento ";
                           
                sql += " and id_pavimento =" + filtroPavimento.getIdPavimento()+";";
                 
                    
                ResultSet rs = conex.executeQuery(sql);
                      
                while (rs.next()) {                
                    Pavimento pavimento = new Pavimento();
                    pavimento.setIdPavimento(rs.getInt("id_pavimento"));
                    pavimento.setPavimento(rs.getString("pavimento"));
                            
                    listaPavimento.add(pavimento);
                  
                }
            } catch (SQLException e) {
                    
                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }
                
            desconectar();
                
            return listaPavimento;
    }

    public ArrayList<Usuario> listarUsuario(Usuario filtroUsuario) throws Exception {

        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

            try {

                Statement conex = conectar();

                String sql = "SELECT * " +
                        "FROM Usuario " +
                        "INNER JOIN Gerencia ON Usuario.id_gerencia = Gerencia.id_gerencia " +
                        "INNER JOIN Cargo ON Usuario.id_cargo = Cargo.id_cargo " +
                        "INNER JOIN Pavimento ON Usuario.id_pavimento = Pavimento.id_pavimento " +
                        "INNER JOIN Configuracao ON Usuario.id_configuracao = Configuracao.id_configuracao " +
                        "INNER JOIN Marca_Micro ON Usuario.id_marca_micro = Marca_Micro.id_marca_micro " +
                        "INNER JOIN Modelo_Micro ON Usuario.id_modelo_micro = Modelo_Micro.id_modelo_micro " +
                        "INNER JOIN Plataforma ON Usuario.id_plataforma = Plataforma.id_plataforma " +
                        "INNER JOIN Proprietario_Micro ON Usuario.id_proprietario_micro = Proprietario_Micro.id_proprietario_micro " +
                        "INNER JOIN Sistema ON Usuario.id_so = Sistema.id_so " +
                        "INNER JOIN Modelo_Monitor ON Usuario.id_modelo_monitor = Modelo_Monitor.id_modelo_monitor " +
                        "INNER JOIN Marca_Monitor ON Usuario.id_marca_monitor = Marca_Monitor.id_marca_monitor " +
                        "INNER JOIN Proprietario_Monitor ON Usuario.id_proprietario_monitor = Proprietario_Monitor.id_proprietario_monitor " +
                        "INNER JOIN Versao_Office ON Usuario.id_versao_office = Versao_Office.id_versao_office " +
                        "LEFT JOIN Modelo_Monitor AS Modelo_Monitor2 ON Usuario.id_modelo_monitor2 = Modelo_Monitor2.id_modelo_monitor " +
                        "LEFT JOIN Marca_Monitor AS Marca_Monitor2 ON Usuario.id_marca_monitor2 = Marca_Monitor2.id_marca_monitor " +
                        "LEFT JOIN Proprietario_Monitor AS Proprietario_Monitor2 ON Usuario.id_proprietario_monitor2 = Proprietario_Monitor2.id_proprietario_monitor";

                        sql += " where id_usuario="+filtroUsuario.getId_usuario()+";";


                ResultSet rs = conex.executeQuery(sql);

                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setTombamentoMicro(rs.getInt("tombo_micro"));
                    usuario.setSerieMicro(rs.getString("serie_micro"));
                    usuario.setTombamentoMonitor(rs.getInt("tombo_monitor"));
                    usuario.setSerieMonitor(rs.getString("serie_monitor"));
                    usuario.setEtiquetaCESU(rs.getInt("cmtech"));
                    usuario.setGarantia(rs.getString("garantia"));
                    usuario.setNotebook(rs.getString("notebook"));
                    usuario.setNovoTomboMicro(rs.getString("novo_tombo_micro"));
                    usuario.setNovoTomboMonitor(rs.getString("novo_tombo_monitor"));

                    ModeloMicro modeloMicro = new ModeloMicro();
                    modeloMicro.setIdModelo(rs.getInt("id_modelo_micro"));
                    modeloMicro.setModelo(rs.getString("modelo_micro"));
                    usuario.setModeloMicro(modeloMicro);

                    ModeloMonitor modeloMonitor = new ModeloMonitor();
                    modeloMonitor.setIdModelo(rs.getInt("id_modelo_monitor"));
                    modeloMonitor.setModelo(rs.getString("modelo_monitor"));
                    usuario.setModeloMonitor(modeloMonitor);

                    ModeloMonitor modeloMonitor1 = new ModeloMonitor();
                    modeloMonitor1.setIdModelo(rs.getInt("id_modelo_monitor2"));
                    modeloMonitor1.setModelo(rs.getString("modelo_monitor2"));
                    usuario.setModeloMonitor1(modeloMonitor1);

                    usuario.setSerieMonitor(rs.getString("serie_monitor"));
                    usuario.setSerieMonitor1(rs.getString("serie_monitor2"));


                    listaUsuario.add(usuario);

                }
            } catch (SQLException e) {

                throw new Exception("Erro ao executar Consulta/Listagem: " + e.getMessage());
            }

            desconectar();

            return listaUsuario;
    }
}
