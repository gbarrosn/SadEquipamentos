/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitor.ModeloMonitor;

import Monitor.MarcaMonitor.MarcaMonitor;

/**
 *
 * @author Posseidon
 */
public class ModeloMonitor {
    private int idModelo;
    private String modelo;
    private MarcaMonitor marca;

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the idModelo
     */
    public int getIdModelo() {
        return idModelo;
    }

    /**
     * @param idModelo the idModelo to set
     */
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * @return the marca
     */
    public MarcaMonitor getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaMonitor marca) {
        this.marca = marca;
    }

}
