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
public class NotaFiscal {

    private int codigo;
    private long notaFiscal;
    private String data;
     private Fornecedor cod_Forn;

    /**
     * @return the cod_hp
     */
    /**
     * @return the notaFiscal
     */
    public long getNotaFiscal() {
        return notaFiscal;
    }

    /**
     * @param notaFiscal the notaFiscal to set
     */
    public void setNotaFiscal(long notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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
     * @return the cod_Forn
     */
    public Fornecedor getCod_Forn() {
        return cod_Forn;
    }

    /**
     * @param cod_Forn the cod_Forn to set
     */
    public void setCod_Forn(Fornecedor cod_Forn) {
        this.cod_Forn = cod_Forn;
    }

    /**
     * @return the quantidadeTotal
     */
 
}
