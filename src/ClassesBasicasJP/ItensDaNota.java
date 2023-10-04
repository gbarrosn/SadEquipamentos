/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBasicasJP;

//import java.math.BigDecimal;

/**
 *
 * @author joao.paulo
 */
public  class ItensDaNota {

    private int codigo;
    private int quantidade;
    private String valorUnidade;
    private String valorTotalItem;
    private Equipamentos cod_Equip;
    private NotaFiscal cod_NF;

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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the cod_Equip
     */
    public Equipamentos getCod_Equip() {
        return cod_Equip;
    }

    /**
     * @param cod_Equip the cod_Equip to set
     */
    public void setCod_Equip(Equipamentos cod_Equip) {
        this.cod_Equip = cod_Equip;
    }

    /**
     * @return the cod_NF
     */
    public NotaFiscal getCod_NF() {
        return cod_NF;
    }

    /**
     * @param cod_NF the cod_NF to set
     */
    public void setCod_NF(NotaFiscal cod_NF) {
        this.cod_NF = cod_NF;
    }

    /**
     * @return the valorUnidade
     */
    public String getValorUnidade() {
        return valorUnidade;
    }

    /**
     * @param valorUnidade the valorUnidade to set
     */
    public void setValorUnidade(String valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    /**
     * @return the valorTotalItem
     */
    public String getValorTotalItem() {
        return valorTotalItem;
    }

    /**
     * @param valorTotalItem the valorTotalItem to set
     */
    public void setValorTotalItem(String valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

}
