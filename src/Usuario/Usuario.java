/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import SADpe.Gerencia.Gerencia;
import SADpe.Pavimento.Pavimento;
import SADpe.Cargo.Cargo;
import Monitor.ProprietarioMonitor.ProprietarioMonitor;
import Micro.PlataformaMicro.PlataformaMicro;
import Micro.OS.OS;
import Micro.MarcaMicro.MarcaMicro;
import Micro.ProprietarioMicro.ProprietarioMicro;
import Micro.Configuracao.Configuracao;
import Micro.ModeloMicro.ModeloMicro;
import Monitor.MarcaMonitor.MarcaMonitor;
import Monitor.ModeloMonitor.ModeloMonitor;
import Versao_Office.VersaoOffice;

/**
 *
 * @author Posseidon
 */
public class Usuario {

    private String notebook;
    
    //Campo usado para realizar pesquisar em todos os outros campos:
    private String Pesq;
    
    //Usuário
    private long id_usuario;
    private String nome;
    //Classes:
    private Gerencia gerencia;
    private Cargo cargo;
    private Pavimento pavimentoUsuario;

    //Micro
    private String nomepc;
    private long tombamentoMicro;
    private String novoTomboMicro;
    private String serieMicro;
    //Classes:
    private Configuracao configMicro;
    private MarcaMicro marcaMicro;
    private ModeloMicro modeloMicro;
    private PlataformaMicro plataformaMicro;
    private ProprietarioMicro proprietarioMicro;
    private OS osMicro;

    //Monitor
    private long tombamentoMonitor;
    private String serieMonitor;
    private String novoTomboMonitor;
    
    //Monitor2
    private long tombamentoMonitor1;
    private String serieMonitor1;

    
    //Classes:
    private ModeloMonitor modeloMonitor;
    private MarcaMonitor marcaMonitor;
    private ProprietarioMonitor proprietarioMonitor;    
    
    //Classes2:
    private ModeloMonitor modeloMonitor1;
    private MarcaMonitor marcaMonitor1;
    private ProprietarioMonitor proprietarioMonitor1;

    //Outro
    private String garantia;
    private long etiquetaCESU;
    private String dataAlteracao;
    private String usuarioAlteracao;
    private Boolean termo_responsabilidade;
    private String etiquetaSAD;
    private String cpf;
    private Boolean ativo;
    private VersaoOffice versao_office;
    private Boolean estoque;
    //*************


    
    public Usuario(){
        this.serieMonitor="N/I";
        this.novoTomboMonitor="N/I";
        this.tombamentoMonitor=1;
    }

    public Boolean getEstoque() {return estoque;}

    public void setEstoque(Boolean estoque) {this.estoque = estoque;}
    public Boolean getAtivo() {return ativo;}

    public void setAtivo(Boolean ativo) {this.ativo = ativo;}
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the gerencia
     */
    public Gerencia getGerencia() {
        return gerencia;
    }

    /**
     * @param gerencia the gerencia to set
     */
    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the pavimentoUsuario
     */
    public Pavimento getPavimentoUsuario() {
        return pavimentoUsuario;
    }

    /**
     * @param pavimentoUsuario the pavimentoUsuario to set
     */
    public void setPavimentoUsuario(Pavimento pavimentoUsuario) {
        this.pavimentoUsuario = pavimentoUsuario;
    }

    /**
     * @return the nomepc
     */
    public String getNomepc() {
        return nomepc;
    }

    /**
     * @param nomepc the nomepc to set
     */
    public void setNomepc(String nomepc) {
        this.nomepc = nomepc;
    }

    /**
     * @return the tombamentoMicro
     */
    public long getTombamentoMicro() {
        return tombamentoMicro;
    }

    /**
     * @param tombamentoMicro the tombamentoMicro to set
     */
    public void setTombamentoMicro(long tombamentoMicro) {
        this.tombamentoMicro = tombamentoMicro;
    }

    /**
     * @return the serieMicro
     */
    public String getSerieMicro() {
        return serieMicro;
    }

    /**
     * @param serieMicro the serieMicro to set
     */
    public void setSerieMicro(String serieMicro) {
        this.serieMicro = serieMicro;
    }

    /**
     * @return the configMicro
     */
    public Configuracao getConfigMicro() {
        return configMicro;
    }

    /**
     * @param configMicro the configMicro to set
     */
    public void setConfigMicro(Configuracao configMicro) {
        this.configMicro = configMicro;
    }

    /**
     * @return the marcaMicro
     */
    public MarcaMicro getMarcaMicro() {
        return marcaMicro;
    }

    /**
     * @param marcaMicro the marcaMicro to set
     */
    public void setMarcaMicro(MarcaMicro marcaMicro) {
        this.marcaMicro = marcaMicro;
    }

    /**
     * @return the modeloMicro
     */
    public ModeloMicro getModeloMicro() {
        return modeloMicro;
    }

    /**
     * @param modeloMicro the modeloMicro to set
     */
    public void setModeloMicro(ModeloMicro modeloMicro) {
        this.modeloMicro = modeloMicro;
    }

    /**
     * @return the plataformaMicro
     */
    public PlataformaMicro getPlataformaMicro() {
        return plataformaMicro;
    }

    /**
     * @param plataformaMicro the plataformaMicro to set
     */
    public void setPlataformaMicro(PlataformaMicro plataformaMicro) {
        this.plataformaMicro = plataformaMicro;
    }

    /**
     * @return the proprietarioMicro
     */
    public ProprietarioMicro getProprietarioMicro() {
        return proprietarioMicro;
    }

    /**
     * @param proprietarioMicro the proprietarioMicro to set
     */
    public void setProprietarioMicro(ProprietarioMicro proprietarioMicro) {
        this.proprietarioMicro = proprietarioMicro;
    }

    /**
     * @return the osMicro
     */
    public OS getOsMicro() {
        return osMicro;
    }

    /**
     * @param osMicro the osMicro to set
     */
    public void setOsMicro(OS osMicro) {
        this.osMicro = osMicro;
    }

    /**
     * @return the tombamentoMonitor
     */
    public long getTombamentoMonitor() {
        return tombamentoMonitor;
    }

    /**
     * @param tombamentoMonitor the tombamentoMonitor to set
     */
    public void setTombamentoMonitor(long tombamentoMonitor) {
        this.tombamentoMonitor = tombamentoMonitor;
    }

    /**
     * @return the serieMonitor
     */
    public String getSerieMonitor() {
        return serieMonitor;
    }

    /**
     * @param serieMonitor the serieMonitor to set
     */
    public void setSerieMonitor(String serieMonitor) {
        this.serieMonitor = serieMonitor;
    }

    /**
     * @return the modeloMonitor
     */
    public ModeloMonitor getModeloMonitor() {
        return modeloMonitor;
    }

    /**
     * @param modeloMonitor the modeloMonitor to set
     */
    public void setModeloMonitor(ModeloMonitor modeloMonitor) {
        this.modeloMonitor = modeloMonitor;
    }

    /**
     * @return the marcaMonitor
     */
    public MarcaMonitor getMarcaMonitor() {
        return marcaMonitor;
    }

    /**
     * @param marcaMonitor the marcaMonitor to set
     */
    public void setMarcaMonitor(MarcaMonitor marcaMonitor) {
        this.marcaMonitor = marcaMonitor;
    }

    /**
     * @return the proprietarioMonitor
     */
    public ProprietarioMonitor getProprietarioMonitor() {
        return proprietarioMonitor;
    }

    /**
     * @param proprietarioMonitor the proprietarioMonitor to set
     */
    public void setProprietarioMonitor(ProprietarioMonitor proprietarioMonitor) {
        this.proprietarioMonitor = proprietarioMonitor;
    }

    //monitor2
    /**
     * @return the tombamentoMonitor
     */
    public long getTombamentoMonitor1() {
        return tombamentoMonitor1;
    }

    /**
     * @param tombamentoMonitor1 the tombamentoMonitor to set
     */
    public void setTombamentoMonitor1(long tombamentoMonitor1) {
        this.tombamentoMonitor1 = tombamentoMonitor1;
    }

    /**
     * @return the serieMonitor
     */
    public String getSerieMonitor1() {
        return serieMonitor1;
    }

    /**
     * @param serieMonitor1 the serieMonitor to set
     */
    public void setSerieMonitor1(String serieMonitor1) {
        this.serieMonitor1 = serieMonitor1;
    }

    /**
     * @return the modeloMonitor1
     */
    public ModeloMonitor getModeloMonitor1() {
        return modeloMonitor1;
    }

    /**
     * @param modeloMonitor1 the modeloMonitor to set
     */
    public void setModeloMonitor1(ModeloMonitor modeloMonitor1) {
        this.modeloMonitor1 = modeloMonitor1;
    }

    /**
     * @return the marcaMonitor
     */
    public MarcaMonitor getMarcaMonitor1() {
        return marcaMonitor1;
    }

    /**
     * @param marcaMonitor1 the marcaMonitor to set
     */
    public void setMarcaMonitor1(MarcaMonitor marcaMonitor1) {
        this.marcaMonitor1 = marcaMonitor1;
    }

    /**
     * @return the proprietarioMonitor
     */
    public ProprietarioMonitor getProprietarioMonitor1() {
        return proprietarioMonitor1;
    }

    /**
     * @param proprietarioMonitor1 the proprietarioMonitor to set
     */
    public void setProprietarioMonitor1(ProprietarioMonitor proprietarioMonitor1) {
        this.proprietarioMonitor1 = proprietarioMonitor1;
    }
//fim monitor2
    
    /**
     * @return the garantia
     */
    public String getGarantia() {
        return garantia;
    }

    /**
     * @param garantia the garantia to set
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    /**
     * @return the etiquetaCMTECH
     */
    public long getEtiquetaCESU() {
        return etiquetaCESU;
    }

    /**
     * @param etiquetaCMTECH the etiquetaCMTECH to set
     */
    public void setEtiquetaCESU(long etiquetaCMTECH) {
        this.etiquetaCESU = etiquetaCMTECH;
    }

    /**
     * @return the id_usuario
     */
    public long getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the transactID
     */
    public String getPesq() {
        return Pesq;
    }

    /**
     * @param Pesq the transactID to set
     */
    public void setPesq(String Pesq) {
        this.Pesq = Pesq;
    }

    /**
     * @return the notebook
     */
    public String getNotebook() {
        return notebook;
    }

    /**
     * @param notebook the notebook to set
     */
    public void setNotebook(String notebook) {
        this.notebook = notebook;
    }

    /**
     * @return the dataAlteracao
     */
    public String getDataAlteracao() {
        return dataAlteracao;
    }

    /**
     * @param dataAlteracao the dataAlteracao to set
     */
    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    /**
     * @return the versao_office
     */
    public VersaoOffice getVersao_office() {
        return versao_office;
    }

    /**
     * @param versao_office the versao_office to set
     */
    public void setVersao_office(VersaoOffice versao_office) {
        this.versao_office = versao_office;
    }

    /**
     * @return the usuarioAlteracao
     */
    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    /**
     * @param usuarioAlteracao the usuarioAlteracao to set
     */
    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    /**
     * @return the termo_responsabilidade
     */
    public Boolean getTermo_responsabilidade() {
        return termo_responsabilidade;
    }

    /**
     * @param termo_responsabilidade the termo_responsabilidade to set
     */
    public void setTermo_responsabilidade(Boolean termo_responsabilidade) {
        this.termo_responsabilidade = termo_responsabilidade;
    }

    /**
     * @return the novoTomboMicro
     */
    public String getNovoTomboMicro() {
        return novoTomboMicro;
    }

    /**
     * @param novoTomboMicro the novoTomboMicro to set
     */
    public void setNovoTomboMicro(String novoTomboMicro) {
        this.novoTomboMicro = novoTomboMicro;
    }

    /**
     * @return the novoTomboMonitor
     */
    public String getNovoTomboMonitor() {
        return novoTomboMonitor;
    }

    /**
     * @param novoTomboMonitor the novoTomboMonitor to set
     */
    public void setNovoTomboMonitor(String novoTomboMonitor) {
        this.novoTomboMonitor = novoTomboMonitor;
    }

    /**
     * @return the etiquetaSAD
     */
    public String getEtiquetaSAD() {
        return etiquetaSAD;
    }

    /**
     * @param etiquetaSAD the etiquetaSAD to set
     */
    public void setEtiquetaSAD(String etiquetaSAD) {
        this.etiquetaSAD = etiquetaSAD;
    }

    private static class ProprietarioMonitor1 {

        public ProprietarioMonitor1() {
        }
    }

    private static class MarcaMonitor1 {

        public MarcaMonitor1() {
        }
    }

}
