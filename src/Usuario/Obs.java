/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

/**
 *
 * @author airton.oliveira
 */
public class Obs {
    private long id_obs;
    private Usuario usuario_obs;
    private String obs;
    private String data_obs;
    private String nome_usuario;

    /**
     * @return the id_obs
     */
    public long getId_obs() {
        return id_obs;
    }

    /**
     * @param id_obs the id_obs to set
     */
    public void setId_obs(long id_obs) {
        this.id_obs = id_obs;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the data_obs
     */
    public String getData_obs() {
        return data_obs;
    }

    /**
     * @param data_obs the data_obs to set
     */
    public void setData_obs(String data_obs) {
        this.data_obs = data_obs;
    }

    /**
     * @return the id_usuario
     */
    public Usuario getUsuario_obs() {
        return usuario_obs;
    }

    /**
     * @param usuario_obs the id_usuario to set
     */
    public void setUsuario_obs(Usuario usuario_obs) {
        this.usuario_obs = usuario_obs;
    }

    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        return nome_usuario;
    }

    /**
     * @param nome_usuario the nome_usuario to set
     */
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
}
