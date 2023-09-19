/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Micro.ModeloMicro;

import Micro.MarcaMicro.MarcaMicro;

/**
 *
 * @author Posseidon
 */
public class ModeloMicro {
    private int idModelo;
    private String modelo;
    private MarcaMicro marca;

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
    public MarcaMicro getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaMicro marca) {
        this.marca = marca;
    }

   
}
