/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

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
import Versao_Office.VersaoOffice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Posseidon
 */
public class DadosUsuario extends ConectarSQL implements InterfaceUsuario {

    @Override
    public void cadastrarUsuario(Usuario user) throws Exception {

        try {

            Connection conectarSQL = conectarPrepared();
            String sql = " INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,";
            sql += "host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,";
            sql += "id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,";
            sql += "id_marca_monitor, id_proprietario_monitor,garantia,cmtech,notebook,id_versao_office,data_alteracao,usuario_alteracao,";
            sql += "novo_tombo_micro,novo_tombo_monitor,possui_termo, etq_sad, id_modelo_monitor2, id_marca_monitor2, ";
            sql += "id_proprietario_monitor2, tombo_monitor2, serie_monitor2, cpf)";
            sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement conex = conectarSQL.prepareStatement(sql);
            conex.setString(1, user.getNome());
            conex.setInt(2, user.getGerencia().getIdGerencia());
            conex.setInt(3, user.getCargo().getIdCargo());
            conex.setInt(4, user.getPavimentoUsuario().getIdPavimento());
            conex.setString(5, user.getNomepc());
            conex.setLong(6, user.getTombamentoMicro());
            conex.setString(7, user.getSerieMicro());
            conex.setInt(8, user.getConfigMicro().getIdConfiguracao());
            conex.setInt(9, user.getMarcaMicro().getIdMarca());
            conex.setInt(10, user.getModeloMicro().getIdModelo());
            conex.setInt(11, user.getPlataformaMicro().getIdPlataforma());
            conex.setInt(12, user.getProprietarioMicro().getIdProprietario());
            conex.setInt(13, user.getOsMicro().getIdOS());
            conex.setLong(14, user.getTombamentoMonitor());
            conex.setString(15, user.getSerieMonitor());
            conex.setInt(16, user.getModeloMonitor().getIdModelo());
            conex.setInt(17, user.getMarcaMonitor().getIdMarca());
            conex.setInt(18, user.getProprietarioMonitor().getIdProprietario());
            conex.setString(19, user.getGarantia());
            conex.setLong(20, user.getEtiquetaCESU());
            conex.setString(21, user.getNotebook());
            conex.setInt(22, user.getVersao_office().getId_versao_office());
            conex.setString(23, user.getDataAlteracao());
            conex.setString(24, user.getUsuarioAlteracao());
            conex.setString(25, "1");
            conex.setString(26, "1");
            conex.setBoolean(27, user.getTermo_responsabilidade());
            conex.setString(28, user.getEtiquetaSAD());
            conex.setInt(29, user.getModeloMonitor1().getIdModelo());
            conex.setInt(30, user.getMarcaMonitor1().getIdMarca());
            conex.setInt(31, user.getProprietarioMonitor1().getIdProprietario());
            conex.setLong(32, user.getTombamentoMonitor1());
            conex.setString(33, user.getSerieMonitor1());
            conex.setString(34, user.getCpf());

            conex.executeUpdate();

            /*
            Statement conex = conectar();

            //instrução sql para cadastro do usuário
            //String sql ="DECLARE @TRANSACTION VARCHAR(200) = '"+user.getTransactID()+"' BEGIN TRANSACTION "+user.getTransactID()+" SAVE TRANSACTION "+user.getTransactID();
            String sql = " INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,";
            sql += "host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,";
            sql += "id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,";
            sql += "id_marca_monitor, id_proprietario_monitor,garantia,cmtech,notebook,id_versao_office,data_alteracao,usuario_alteracao)";
            sql += "VALUES ('" + user.getNome() + "'," + user.getGerencia().getIdGerencia() + ","
                    + user.getCargo().getIdCargo() + "," + user.getPavimentoUsuario().getIdPavimento()
                    + ",'" + user.getNomepc() + "'," + user.getTombamentoMicro() + ",'"
                    + user.getSerieMicro() + "'," + user.getConfigMicro().getIdConfiguracao() + ","
                    + user.getMarcaMicro().getIdMarca() + "," + user.getModeloMicro().getIdModelo() + ","
                    + user.getPlataformaMicro().getIdPlataforma() + "," + user.getProprietarioMicro().getIdProprietario() + ","
                    + user.getOsMicro().getIdOS() + "," + user.getTombamentoMonitor() + ",'"
                    + user.getSerieMonitor() + "'," + user.getModeloMonitor().getIdModelo() + ","
                    + user.getMarcaMonitor().getIdMarca() + "," + user.getProprietarioMonitor().getIdProprietario() + ",'"
                    + user.getGarantia() + "'," + user.getEtiquetaCMTECH() + ",'" + user.getNotebook() + "',"
                    + user.getVersao_office().getId_versao_office() + ",'" + user.getDataAlteracao() + "','" + user.getUsuarioAlteracao() + "')";

            conex.execute(sql);
            */

        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao cadastrar Usuário - " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void alterarUsuario(Usuario alterarUser, Usuario selecionadoUser) throws Exception {
        try {

            Statement conex = conectar();
            String sql = "UPDATE Usuario SET ";
            sql += "nome='" + alterarUser.getNome() + "',id_gerencia=" + alterarUser.getGerencia().getIdGerencia() + ",";
            sql += "id_cargo=" + alterarUser.getCargo().getIdCargo() + ", id_pavimento=" + alterarUser.getPavimentoUsuario().getIdPavimento() + ",";
            sql += "host_nome='" + alterarUser.getNomepc() + "',tombo_micro=" + alterarUser.getTombamentoMicro() + ",";
            sql += "serie_micro='" + alterarUser.getSerieMicro() + "', id_configuracao=" + alterarUser.getConfigMicro().getIdConfiguracao() + ",";
            sql += "id_marca_micro=" + alterarUser.getMarcaMicro().getIdMarca() + ",id_modelo_micro=" + alterarUser.getModeloMicro().getIdModelo() + ",";
            sql += "id_plataforma=" + alterarUser.getPlataformaMicro().getIdPlataforma() + ",id_proprietario_micro=" + alterarUser.getProprietarioMicro().getIdProprietario() + ",";
            sql += "id_so=" + alterarUser.getOsMicro().getIdOS() + ",tombo_monitor=" + alterarUser.getTombamentoMonitor() + ",";
            sql += "serie_monitor='" + alterarUser.getSerieMonitor() + "',id_modelo_monitor=" + alterarUser.getModeloMonitor().getIdModelo() + ",";
            sql += "id_marca_monitor=" + alterarUser.getMarcaMonitor().getIdMarca() + ",id_proprietario_monitor=" + alterarUser.getProprietarioMonitor().getIdProprietario() + ",";
            sql += "garantia='" + alterarUser.getGarantia() + "',cmtech=" + alterarUser.getEtiquetaCESU() + ",notebook='" + alterarUser.getNotebook() + "'";
            sql += ",etq_sad = '" + alterarUser.getEtiquetaSAD() + "' ";
            sql += ",id_versao_office=" + alterarUser.getVersao_office().getId_versao_office();
            sql += ",data_alteracao='" + alterarUser.getDataAlteracao() + "'";
            sql += ",usuario_alteracao='" + alterarUser.getUsuarioAlteracao() + "'";
            sql +=",novo_tombo_micro='"+ "1" + "'";
            sql +=",possui_termo='"+ alterarUser.getTermo_responsabilidade().toString() + "',";
            sql += "id_modelo_monitor2='"+alterarUser.getModeloMonitor1().getIdModelo()+"'";
            sql += ",id_marca_monitor2='"+alterarUser.getMarcaMonitor1().getIdMarca()+"',";
            sql += "id_proprietario_monitor2='"+alterarUser.getProprietarioMonitor1().getIdProprietario()+"',";
            sql += "tombo_monitor2='"+alterarUser.getTombamentoMonitor1()+"',";
            sql += "serie_monitor2='"+alterarUser.getSerieMonitor1()+"'";
            sql += "cpf='"+alterarUser.getCpf()+"'";


            sql += " WHERE id_usuario=" + selecionadoUser.getId_usuario() + ";";

            conex.execute(sql);

        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao alterar Usuário.");
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerUsuario(Usuario removerUser) throws Exception {
        try {
            Statement conex = conectar();
            String sql = "DELETE Usuario WHERE id_usuario= " + removerUser.getId_usuario();
            //executando a instrução sql
            conex.execute(sql);
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao deletar o Usuário - Certifique-se de que o Usuário não está vinculado à alguma Observação.\n" + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public ArrayList<Usuario> listarUsuario(Usuario filtroUser) throws Exception {

        ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

        try {

            Statement conex = conectar();
            //instrução SQL Consulta usuário usando filtro SE HOUVER
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


            if (filtroUser.getAtivo()){
                sql += " where ativo = 1";
            }
            else {
                sql += " where ativo = 0";
            }

            //Tombamento Micro
            if (filtroUser.getTombamentoMicro() > 0 && filtroUser.getPesq().equals("livre")) {
                sql += " and tombo_micro LIKE '%" + filtroUser.getTombamentoMicro() + "%'";
            }
            if (filtroUser.getTombamentoMicro() > 0 && filtroUser.getPesq().equals("exata")) {
                sql += " and tombo_micro=" + filtroUser.getTombamentoMicro();
            }

            //Nome
            if (!(filtroUser.getNome().trim().equals("")) && filtroUser.getPesq().equals("livre")) {
                sql += " and nome LIKE '%" + filtroUser.getNome() + "%'";
            }
            if (!(filtroUser.getNome().trim().equals("")) && filtroUser.getPesq().equals("exata")) {
                sql += " and nome = '" + filtroUser.getNome() + "'";
            }

            //CMTECH
            if (filtroUser.getEtiquetaCESU() > 0 && filtroUser.getPesq().equals("livre")) {
                sql += " and cmtech LIKE '%" + filtroUser.getEtiquetaCESU() + "%'";
            }
            if (filtroUser.getEtiquetaCESU() > 0 && filtroUser.getPesq().equals("exata")) {
                sql += " and cmtech =" + filtroUser.getEtiquetaCESU();
            }

            //PAVIMENTO
            if (!filtroUser.getPavimentoUsuario().getPavimento().trim().equals("")) {
                sql += " and usuario.id_pavimento=" + filtroUser.getPavimentoUsuario().getIdPavimento();
            }

            //HOST NAME
            if (!filtroUser.getNomepc().trim().equals("") && filtroUser.getPesq().equals("livre")) {
                sql += " and usuario.host_nome LIKE '%" + filtroUser.getNomepc().trim() + "%'";
            }
            if (!filtroUser.getNomepc().trim().equals("") && filtroUser.getPesq().equals("exata")) {
                sql += " and usuario.host_nome = '" + filtroUser.getNomepc().trim() + "'";
            }

            //NOTEBOOK
            if (filtroUser.getNotebook().trim().equals("sim")) {
                sql += " and usuario.notebook = 'sim'";
            } else if (filtroUser.getNotebook().trim().equals("não")) {
                sql += " and usuario.notebook = 'não'";
            }

            //CONFIG MICRO
            if (!filtroUser.getConfigMicro().getConfiguracao().trim().equals("")) {
                sql += " and usuario.id_configuracao=" + filtroUser.getConfigMicro().getIdConfiguracao();
            }

            //MODELO MICRO
            if (!filtroUser.getModeloMicro().getModelo().trim().equals("")) {
                sql += " and usuario.id_modelo_micro=" + filtroUser.getModeloMicro().getIdModelo();
            }

            //SERIE MICRO
            if (!filtroUser.getSerieMicro().trim().equals("") && filtroUser.getPesq().equals("livre")) {
                sql += " and usuario.serie_micro LIKE '%" + filtroUser.getSerieMicro().trim() + "%'";
            }
            if (!filtroUser.getSerieMicro().trim().equals("") && filtroUser.getPesq().equals("exata")) {
                sql += " and usuario.serie_micro = '" + filtroUser.getSerieMicro().trim() + "'";
            }

            //SERIE MONITOR
            if (!filtroUser.getSerieMonitor().trim().equals("") && filtroUser.getPesq().equals("livre")) {
                sql += " and usuario.serie_monitor LIKE '%" + filtroUser.getSerieMonitor().trim() + "%'";
            }
            if (!filtroUser.getSerieMonitor().trim().equals("") && filtroUser.getPesq().equals("exata")) {
                sql += " and usuario.serie_monitor = '" + filtroUser.getSerieMonitor().trim() + "'";
            }

            //TOMBO MONITOR
            if (filtroUser.getTombamentoMonitor() > 0 && filtroUser.getPesq().equals("livre")) {
                sql += " and tombo_monitor LIKE '%" + filtroUser.getTombamentoMonitor() + "%'";
            }
            if (filtroUser.getTombamentoMonitor() > 0 && filtroUser.getPesq().equals("exata")) {
                sql += " and tombo_monitor =" + filtroUser.getTombamentoMonitor();
            }

            //MODELO MONITOR
            if (!filtroUser.getModeloMonitor().getModelo().trim().equals("")) {
                sql += " and usuario.id_modelo_monitor=" + filtroUser.getModeloMonitor().getIdModelo();
            }

            //PLATAFORMA
            if (!filtroUser.getPlataformaMicro().getPlataforma().trim().equals("")) {
                sql += " and usuario.id_plataforma=" + filtroUser.getPlataformaMicro().getIdPlataforma();
            }


            //GERENCIA
            if (!filtroUser.getGerencia().getSiglaGerencia().trim().equals("")) {
                sql += " and usuario.id_gerencia=" + filtroUser.getGerencia().getIdGerencia();
            }

            //VERSAO OFFICE
            if (!filtroUser.getVersao_office().getDescricao().trim().equals("")) {
                sql += " and usuario.id_versao_office=" + filtroUser.getVersao_office().getId_versao_office();
            }

            //PROP MICRO
            if (!filtroUser.getProprietarioMicro().getProprietario().trim().equals("")) {
                sql += " and usuario.id_proprietario_micro=" + filtroUser.getProprietarioMicro().getIdProprietario();
            }

            //CARGO
            if (!filtroUser.getCargo().getCargo().trim().equals("")) {
                sql += " and usuario.id_cargo=" + filtroUser.getCargo().getIdCargo();
            }

            //SISTEMA OPERACIONAL
            if (!filtroUser.getOsMicro().getOs().trim().equals("")) {
                sql += " and usuario.id_so=" + filtroUser.getOsMicro().getIdOS();
            }


            //POSSUI TERMO?
            if (filtroUser.getTermo_responsabilidade()!=null){
                if (!filtroUser.getTermo_responsabilidade()) {
                    sql += " and usuario.possui_termo = '" + filtroUser.getTermo_responsabilidade().toString() + "'";
                }
                else if (filtroUser.getTermo_responsabilidade()) {
                    sql += " and usuario.possui_termo = '" + filtroUser.getTermo_responsabilidade().toString() + "'";
                }
            }

            //SERIE MONITOR 2
            if (!filtroUser.getSerieMonitor1().trim().equals("") && filtroUser.getPesq().equals("livre")) {
                sql += " and usuario.serie_monitor2 LIKE '%" + filtroUser.getSerieMonitor1().trim() + "%'";
            }
            if (!filtroUser.getSerieMonitor1().trim().equals("") && filtroUser.getPesq().equals("exata")) {
                sql += " and usuario.serie_monitor2 = '" + filtroUser.getSerieMonitor1().trim() + "'";
            }

            //TOMBO MONITOR 2
            if (filtroUser.getTombamentoMonitor1() > 0 && filtroUser.getPesq().equals("livre")) {
                sql += " and tombo_monitor2 LIKE '%" + filtroUser.getTombamentoMonitor1() + "%'";
            }
            if (filtroUser.getTombamentoMonitor1() > 0 && filtroUser.getPesq().equals("exata")) {
                sql += " and tombo_monitor2 =" + filtroUser.getTombamentoMonitor1();
            }

            //MODELO MONITOR 2
            if (!filtroUser.getModeloMonitor1().getModelo().trim().equals("")) {
                sql += " and usuario.id_modelo_monitor2=" + filtroUser.getModeloMonitor1().getIdModelo();
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
                //monitor 2
                user.setSerieMonitor1(rs.getString("serie_monitor2"));
                user.setTombamentoMonitor1(rs.getInt("tombo_monitor2"));

                user.setEtiquetaCESU(rs.getInt("cmtech"));
                user.setEtiquetaSAD(rs.getString("etq_sad"));
                user.setGarantia(rs.getString("garantia"));
                user.setNotebook(rs.getString("notebook"));



                user.setTermo_responsabilidade(rs.getBoolean("possui_termo"));

                user.setDataAlteracao(rs.getString("data_alteracao"));
                user.setUsuarioAlteracao(rs.getString("usuario_alteracao"));
                //Chaves estrangeiras:

                //Versao Office
                VersaoOffice versaoOffice = new VersaoOffice();
                versaoOffice.setId_versao_office(rs.getInt("id_versao_office"));
                versaoOffice.setDescricao(rs.getString("descricao_office"));
                user.setVersao_office(versaoOffice);
                //Gerencia:
                Gerencia gerencia = new Gerencia();
                gerencia.setIdGerencia(rs.getInt("id_gerencia"));
                gerencia.setGerencia(rs.getString("gerencia"));
                gerencia.setSiglaGerencia(rs.getString("sigla"));
                //Pavimento pavimentoGer = new Pavimento();
                // pavimentoGer.setIdPavimento(rs.getInt("id_pavimento"));
                //pavimentoGer.setPavimento(rs.getString("pavimento"));
                // user.setPavimentoUsuario(pavimentoGer);
                // gerencia.setPavimento(pavimentoGer);
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

                //Modelo Monitor2:
                ModeloMonitor modeloMonitor1 = new ModeloMonitor();
                modeloMonitor1.setIdModelo(rs.getInt("id_modelo_monitor2"));
                modeloMonitor1.setModelo(rs.getString("modelo_monitor"));
                user.setModeloMonitor1(modeloMonitor1);
                //Marca Monitor2:
                MarcaMonitor marcaMonitor1 = new MarcaMonitor();
                marcaMonitor1.setIdMarca(rs.getInt("id_marca_monitor2"));
                marcaMonitor1.setMarca(rs.getString("marca_monitor"));
                user.setMarcaMonitor1(marcaMonitor1);
                //Proprietario Monitor2:
                ProprietarioMonitor proprietarioMonitor1 = new ProprietarioMonitor();
                proprietarioMonitor1.setIdProprietario(rs.getInt("id_proprietario_monitor2"));
                proprietarioMonitor1.setProprietario(rs.getString("proprietario_monitor"));
                user.setProprietarioMonitor1(proprietarioMonitor1);

                //ativo ou não

                user.setAtivo(rs.getBoolean("ativo"));
                if (user.getAtivo() == filtroUser.getAtivo() || filtroUser.getAtivo() == null) {
                    listaUser.add(user);
                }
                else {
                    //não adiciona
                }

                //listaUser.add(user);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar Consulta - " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
        //retornando uma coleção de users
        return listaUser;
    }

    @Override
    public ArrayList<Usuario> listarUsuarioTodosCampos(String filtroUserString) throws Exception {

        ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

        try {

            Statement conex = conectar();
            //instrução SQL Consulta usuário usando filtro SE HOUVER
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
                    "INNER JOIN Modelo_Monitor AS Modelo_Monitor2 ON Usuario.id_modelo_monitor2 = Modelo_Monitor2.id_modelo_monitor " +
                    "INNER JOIN Marca_Monitor AS Marca_Monitor2 ON Usuario.id_marca_monitor2 = Marca_Monitor2.id_marca_monitor " +
                    "INNER JOIN Proprietario_Monitor AS Proprietario_Monitor2 ON Usuario.id_proprietario_monitor2 = Proprietario_Monitor2.id_proprietario_monitor";

            sql += " and (usuario.nome LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.host_nome LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.tombo_micro LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.serie_micro LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.tombo_monitor LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.serie_monitor LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.tombo_monitor2 LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.serie_monitor2 LIKE  '%" +filtroUserString.trim() + "%'";
            sql += " or usuario.garantia LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.cmtech LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.etq_sad LIKE '%" + filtroUserString.trim() + "%'";
            //sql += " or usuario.notebook LIKE '%"+filtroUserString.trim()+"%'";

            sql += " or gerencia.sigla LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or gerencia.gerencia LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or cargo.cargo LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or pavimento.pavimento LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or configuracao.configuracao LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or marca_micro.marca_micro LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or modelo_micro.modelo_micro LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or plataforma.plataforma LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or proprietario_micro.proprietario_micro LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or sistema.so LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or modelo_monitor.modelo_monitor LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or marca_monitor.marca_monitor LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or proprietario_monitor.proprietario_monitor LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or versao_office.descricao_office LIKE '%" + filtroUserString.trim() + "%'";

            sql += " or usuario.data_alteracao LIKE '%" + filtroUserString.trim() + "%'";
            sql += " or usuario.usuario_alteracao LIKE '%" + filtroUserString.trim() + "%'";

            sql +=" or novo_tombo_micro LIKE '%"+ filtroUserString.trim() + "%'";
            sql +=" or novo_tombo_monitor LIKE '%"+ filtroUserString.trim() + "%'";
            sql +=" or possui_termo LIKE '%"+ filtroUserString.trim() + "%')";

            sql += " or id_modelo_monitor2 LIKE '%"+ filtroUserString.trim() + "%'";
            sql += " or id_marca_monitor2 LIKE '%"+ filtroUserString.trim() + "%'";
            sql += " or id_proprietario_monitor2 LIKE '%"+ filtroUserString.trim() + "%'";

            sql += " or usuario.cpf LIKE '%"+ filtroUserString.trim() + "%'";


            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNomepc(rs.getString("host_nome"));
                user.setNome(rs.getString("nome"));
                user.setTombamentoMicro(rs.getInt("tombo_micro"));
                user.setSerieMicro(rs.getString("serie_micro"));
                user.setTombamentoMonitor(rs.getInt("tombo_monitor"));
                user.setSerieMonitor(rs.getString("serie_monitor"));

                user.setSerieMonitor1(rs.getString("serie_monitor2"));
                user.setTombamentoMonitor1(rs.getInt("tombo_monitor2"));
                user.setEtiquetaCESU(rs.getInt("cmtech"));
                user.setEtiquetaSAD(rs.getString("etq_sad"));
                user.setGarantia(rs.getString("garantia"));
                user.setNotebook(rs.getString("notebook"));

                user.setTermo_responsabilidade(rs.getBoolean("possui_termo"));

                user.setDataAlteracao(rs.getString("data_alteracao"));
                user.setUsuarioAlteracao(rs.getString("usuario_alteracao"));
                //Chaves estrangeiras:
                //Versao Office
                VersaoOffice versaoOffice = new VersaoOffice();
                versaoOffice.setId_versao_office(rs.getInt("id_versao_office"));
                versaoOffice.setDescricao(rs.getString("descricao_office"));
                user.setVersao_office(versaoOffice);
                //Gerencia:
                Gerencia gerencia = new Gerencia();
                gerencia.setIdGerencia(rs.getInt("id_gerencia"));
                gerencia.setGerencia(rs.getString("gerencia"));
                gerencia.setSiglaGerencia(rs.getString("sigla"));
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

                //Modelo Monitor2:
                ModeloMonitor modeloMonitor1 = new ModeloMonitor();
                modeloMonitor1.setIdModelo(rs.getInt("id_modelo_monitor2"));
                modeloMonitor1.setModelo(rs.getString("modelo_monitor"));
                user.setModeloMonitor1(modeloMonitor1);
                //Marca Monitor2:
                MarcaMonitor marcaMonitor1 = new MarcaMonitor();
                marcaMonitor1.setIdMarca(rs.getInt("id_marca_monitor2"));
                marcaMonitor1.setMarca(rs.getString("marca_monitor"));
                user.setMarcaMonitor1(marcaMonitor1);
                //Proprietario Monitor2:
                ProprietarioMonitor proprietarioMonitor1 = new ProprietarioMonitor();
                proprietarioMonitor1.setIdProprietario(rs.getInt("id_proprietario_monitor2"));
                proprietarioMonitor1.setProprietario(rs.getString("proprietario_monitor"));
                user.setProprietarioMonitor1(proprietarioMonitor1);

                user.setAtivo(rs.getBoolean("ativo"));
                user.setCpf(rs.getString("cpf"));

                listaUser.add(user);
            }

        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao Executar Consulta - " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();

        return listaUser;

    }

    // CLASSE OBSERVACAO
    @Override
    public void informarObservacao(Obs obs) throws Exception {

        try {
            Statement conex = conectar();

            String sql = " INSERT INTO Obs (id_usuario,obs,data_obs,nome_usuario)";
            sql += " values (" + obs.getUsuario_obs().getId_usuario() + ",'" + obs.getObs() + "','" + obs.getData_obs() + "','" + obs.getNome_usuario() + "');";

            conex.execute(sql);
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao registrar observação - \n" + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void alterarObservacao(Obs alterarObs, Obs selecionadoObs) throws Exception {
        try {

            Statement conex = conectar();
            String sql = "UPDATE Obs SET ";
            sql += "obs='" + alterarObs.getObs() + "',data_obs='" + alterarObs.getData_obs() + "',nome_usuario='" + alterarObs.getNome_usuario() + "'";
            sql += " WHERE id_obs=" + selecionadoObs.getId_obs() + ";";

            conex.execute(sql);

        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao alterar Observação." + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerObservacao(Obs removerObs) throws Exception {

        try {
            Statement conex = conectar();

            String sql = "DELETE Obs WHERE id_obs= " + removerObs.getId_obs();
            //executando a instrução sql
            conex.execute(sql);
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao deletar a observação - " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public ArrayList<Obs> listarObs(Obs filtroObs) throws Exception {

        ArrayList<Obs> listaObs = new ArrayList<Obs>();

        try {

            Statement conex = conectar();
            //instrução SQL Consulta usuário usando filtro SE HOUVER
            //String sql = "select * from Obs,Usuario";
            //sql += " where obs.id_obs=obs.id_obs";

            String sql = "select * from Obs,Usuario,Gerencia,Cargo,Pavimento,Configuracao,Marca_Micro,Modelo_Micro,Plataforma,";
            sql += "Proprietario_Micro,Sistema,Modelo_Monitor,Marca_Monitor,Proprietario_Monitor,Versao_Office";
            sql += " where obs.id_usuario=usuario.id_usuario and usuario.id_gerencia=gerencia.id_gerencia and usuario.id_cargo=cargo.id_cargo and usuario.id_pavimento=pavimento.id_pavimento";
            sql += " and usuario.id_configuracao=configuracao.id_configuracao and usuario.id_marca_micro=marca_micro.id_marca_micro";
            sql += " and usuario.id_modelo_micro=modelo_micro.id_modelo_micro and usuario.id_plataforma=plataforma.id_plataforma and usuario.id_proprietario_micro=proprietario_micro.id_proprietario_micro";
            sql += " and usuario.id_so=sistema.id_so and usuario.id_modelo_monitor=modelo_monitor.id_modelo_monitor and usuario.id_marca_monitor=marca_monitor.id_marca_monitor";
            sql += " and usuario.id_proprietario_monitor=proprietario_monitor.id_proprietario_monitor and Usuario.id_versao_office=Versao_Office.id_versao_office";

            if ((filtroObs.getUsuario_obs().getId_usuario() != 0)) {
                sql += " and obs.id_usuario=" + filtroObs.getUsuario_obs().getId_usuario();
            }

            if (!(filtroObs.getObs().trim().equals(""))) {

                sql += " and (obs.obs LIKE '%" + filtroObs.getObs().trim() + "%'";
                sql += " or data_obs LIKE '%" + filtroObs.getData_obs().trim() + "%'";
                sql += " or nome_usuario LIKE '%" + filtroObs.getNome_usuario().trim() + "%')";

            }

            sql += "  order by data_obs desc";

            //executando a instrução sql
            ResultSet rs = conex.executeQuery(sql);
            //Enquanto houver resultado eles são guardados no ArrayList
            while (rs.next()) {
                Obs obs = new Obs();
                obs.setId_obs(rs.getInt("id_obs"));
                obs.setObs(rs.getString("obs"));
                obs.setData_obs(rs.getString("data_obs"));
                obs.setNome_usuario(rs.getString("nome_usuario"));

                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNomepc(rs.getString("host_nome"));
                user.setNome(rs.getString("nome"));
                user.setTombamentoMicro(rs.getInt("tombo_micro"));
                user.setSerieMicro(rs.getString("serie_micro"));
                user.setTombamentoMonitor(rs.getInt("tombo_monitor"));
                user.setSerieMonitor(rs.getString("serie_monitor"));
                user.setSerieMonitor1(rs.getString("serie_monitor2"));
                user.setTombamentoMonitor1(rs.getInt("tombo_monitor2"));
                user.setEtiquetaCESU(rs.getInt("cmtech"));
                user.setGarantia(rs.getString("garantia"));
                user.setNotebook(rs.getString("notebook"));

                user.setDataAlteracao(rs.getString("data_alteracao"));
                user.setUsuarioAlteracao(rs.getString("usuario_alteracao"));
                //Chaves estrangeiras:
                //Versao Office
                VersaoOffice versaoOffice = new VersaoOffice();
                versaoOffice.setId_versao_office(rs.getInt("id_versao_office"));
                versaoOffice.setDescricao(rs.getString("descricao_office"));
                user.setVersao_office(versaoOffice);
                //Gerencia:
                Gerencia gerencia = new Gerencia();
                gerencia.setIdGerencia(rs.getInt("id_gerencia"));
                gerencia.setGerencia(rs.getString("gerencia"));
                gerencia.setSiglaGerencia(rs.getString("sigla"));
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
                //Modelo Monitor2:
                ModeloMonitor modeloMonitor1 = new ModeloMonitor();
                modeloMonitor1.setIdModelo(rs.getInt("id_modelo_monitor2"));
                modeloMonitor1.setModelo(rs.getString("modelo_monitor"));
                user.setModeloMonitor1(modeloMonitor1);
                //Marca Monitor2:
                MarcaMonitor marcaMonitor1 = new MarcaMonitor();
                marcaMonitor1.setIdMarca(rs.getInt("id_marca_monitor2"));
                marcaMonitor1.setMarca(rs.getString("marca_monitor"));
                user.setMarcaMonitor1(marcaMonitor1);
                //Proprietario Monitor2:
                ProprietarioMonitor proprietarioMonitor1 = new ProprietarioMonitor();
                proprietarioMonitor1.setIdProprietario(rs.getInt("id_proprietario_monitor2"));
                proprietarioMonitor1.setProprietario(rs.getString("proprietario_monitor"));
                user.setProprietarioMonitor1(proprietarioMonitor1);
                obs.setUsuario_obs(user);

                listaObs.add(obs);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar Consulta - " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
        //retornando uma coleção de users
        return listaObs;
    }

    @Override
    public void verificarDadosCadastrar(Usuario user) throws Exception {

        try {

            Statement conex = conectar();

            //HOST NAME
            String sqlValida = "select host_nome,id_usuario ";
            sqlValida += " from Usuario where host_nome = '" + user.getNomepc() + "';";
            ResultSet rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if ((!rs.getString("host_nome").equals("N/I")) && (rs.getInt("id_usuario") != user.getId_usuario())) {
                    throw new Exception("Este Host Name já está cadastrado no sistema.");
                }
            }

//             //NOME
//             String sqlValida0 = "select nome,id_usuario ";
//             sqlValida0 += " from Usuario where nome = '" + user.getNome() + "';";
//             ResultSet rs0 = conex.executeQuery(sqlValida0);
//             while (rs0.next()) {
//             if ((!rs0.getString("nome").equals("N/I")) && (rs0.getInt("id_usuario") != user.getId_usuario())) {
//             throw new Exception("Já existe um usuario com este nome cadastrado no sistema.");
//             }
//             }

            //TOMBO MICRO
            sqlValida = "select tombo_micro,id_usuario, nome ";
            sqlValida += " from Usuario where tombo_micro = '" + user.getTombamentoMicro() + "';";
            rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if (rs.getInt("tombo_micro") != 1 && rs.getInt("id_usuario")!=user.getId_usuario()) {
                    throw new Exception("Este Tombamento de Micro já está cadastrado no sistema no nome de:" + rs.getString("nome") + ".");
                }

            }

            //CMTECH
            sqlValida = "select cmtech,id_usuario ";
            sqlValida += " from Usuario where cmtech = '" + user.getEtiquetaCESU() + "';";
            rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if (rs.getInt("cmtech") != 1 && rs.getInt("id_usuario")!=user.getId_usuario()) {
                    throw new Exception("Esta etiqueta CMTECH já está cadastrada no sistema.");
                }

            }

            //Tombamento do Monitor
            sqlValida = "select tombo_monitor,id_usuario ";
            sqlValida += " from Usuario where tombo_monitor = '" + user.getTombamentoMonitor() + "';";
            rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if (rs.getInt("tombo_monitor") != 1 && rs.getInt("id_usuario")!=user.getId_usuario()) {
                    throw new Exception("Este Tombamento de Monitor já está cadastrado no sistema.");
                }

            }

            //Série Monitor
            sqlValida = "select serie_monitor,id_usuario ";
            sqlValida += " from Usuario where serie_monitor = '" + user.getSerieMonitor() + "';";
            rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if ((!rs.getString("serie_monitor").equals("N/I")) && (rs.getInt("id_usuario")!=user.getId_usuario())) {
                    throw new Exception("Este nº de série de Monitor já está cadastrado no sistema.");
                }

            }


            //Série Micro
            sqlValida = "select serie_micro,id_usuario ";
            sqlValida += " from Usuario where serie_micro = '" + user.getSerieMicro() + "';";
            rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if ((!rs.getString("serie_micro").equals("N/I")) && (rs.getInt("id_usuario")!=user.getId_usuario())) {
                    throw new Exception("Este nº de série de Micro já está cadastrado no sistema.");
                }

            }

            // Cpf usuario
            // verificar se cpf tem 11 digitos
            if (user.getCpf().length() != 11) {
                throw new Exception("CPF inválido, preencha apenas com números.");
            }
            // verificar se cpf tem apenas números
            if (!user.getCpf().matches("[0-9]*")) {
                throw new Exception("CPF inválido, preencha apenas com números.");
            }
            sqlValida = "select cpf,id_usuario ";
            sqlValida += " from Usuario where cpf = '" + user.getCpf() + "';";
            rs = conex.executeQuery(sqlValida);
            while (rs.next()) {
                if ((!rs.getString("cpf").equals("N/I")) && (rs.getInt("id_usuario")!=user.getId_usuario())) {
                    throw new Exception("Este CPF já está cadastrado no sistema.");
                }

            }

        } catch (SQLException e) {
            throw new Exception("Erro ao executar Consulta - " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void alternarNotebookPC(Usuario user) throws Exception {

        try {

            Statement conex = conectar();
            String sql = "";

            switch (user.getNotebook()) {
                case "sim": {
                    sql = "update usuario set notebook='não'";
                    sql += " where id_usuario = '" + user.getId_usuario() + "';";
                    break;
                }
                case "não": {
                    sql = "update usuario set notebook='sim'";
                    sql += " where id_usuario = '" + user.getId_usuario() + "';";
                    break;
                }
            }

            conex.execute(sql);

        } catch (SQLException e) {
            throw new Exception("Erro ao alterar tipo (Notebook/PC).");
        }

        desconectar();
    }

}
