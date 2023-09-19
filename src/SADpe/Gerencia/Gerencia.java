/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SADpe.Gerencia;

import SADpe.Pavimento.Pavimento;

/**
 *
 * @author Posseidon
 */
public class Gerencia {
    private int idGerencia;
    private String gerencia;
    private String siglaGerencia;
    private Pavimento pavimento;
  
    /**
     * @return the gerencia
     */
    public String getGerencia() {
        return gerencia;
    }

    /**
     * @param gerencia the gerencia to set
     */
    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    /**
     * @return the idGerencia
     */
    public int getIdGerencia() {
        return idGerencia;
    }

    /**
     * @param idGerencia the idGerencia to set
     */
    public void setIdGerencia(int idGerencia) {
        this.idGerencia = idGerencia;
    }    
    
    /**
     * @return the siglaGerencia
     */
    public String getSiglaGerencia() {
        return siglaGerencia;
    }

    /**
     * @param siglaGerencia the siglaGerencia to set
     */
    public void setSiglaGerencia(String siglaGerencia) {
        this.siglaGerencia = siglaGerencia;
    }

    /**
     * @return the pavimento
     */
    public Pavimento getPavimento() {
        return pavimento;
    }

    /**
     * @param pavimento the pavimento to set
     */
    public void setPavimento(Pavimento pavimento) {
        this.pavimento = pavimento;
    }





}
