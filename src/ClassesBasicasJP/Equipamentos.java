/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBasicasJP;

/**
 *
 * @author joao.paulo
 */
public class Equipamentos{
    private Fornecedor cnpj_forn;
    private int codigo;
    private String tombamento;
    private String especificacao;    
    private String categoria;
    private int replicar;
    private String valUnitario;
    private String serie;
    private String marca;
    /**
     * @return the cnpj_forn
     */
    public Fornecedor getCnpj_forn() {
        return cnpj_forn;
    }

    /**
     * @param cnpj_forn the cnpj_forn to set
     */
    public void setCnpj_forn(Fornecedor cnpj_forn) {
        this.cnpj_forn = cnpj_forn;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tombamento
     */
    public String getTombamento() {
        return tombamento;
    }

    /**
     * @param tombamento the tombamento to set
     */
    public void setTombamento(String tombamento) {
        this.tombamento = tombamento;
    }

    /**
     * @return the especificacao
     */
    public String getEspecificacao() {
        return especificacao;
    }

    /**
     * @param especificacao the especificacao to set
     */
    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }


    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the replicar
     */
    public int getReplicar() {
        return replicar;
    }

    /**
     * @param replicar the replicar to set
     */
    public void setReplicar(int replicar) {
        this.replicar = replicar;
    }

    /**
     * @return the valUnitario
     */
    public String getValUnitario() {
        return valUnitario;
    }

    /**
     * @param valUnitario the valUnitario to set
     */
    public void setValUnitario(String valUnitario) {
        this.valUnitario = valUnitario;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    /**
     * @return the marca
     */
    public String getMarca(){
        return marca;
    }
    /**
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
