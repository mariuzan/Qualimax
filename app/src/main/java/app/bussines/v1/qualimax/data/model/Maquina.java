package app.bussines.v1.qualimax.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Maquina implements Serializable {
    //private String idMaquina;
    private String dataCompraMaquina;
    private String capacidadeMaquina;
    private String tipoMaquina;

    public Maquina(String dataCompraMaquina, String capacidadeMaquina, String tipoMaquina) {
       // this.idMaquina = idMaquina;
        this.dataCompraMaquina = dataCompraMaquina;
        this.capacidadeMaquina = capacidadeMaquina;
        this.tipoMaquina = tipoMaquina;
    }


    /*public String getIdMaquina() {
        return idMaquina;
    }*/

   /* public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }*/

    public String getDataCompraMaquina() {
        return dataCompraMaquina;
    }

    public void setDataCompraMaquina(String dataCompraMaquina) {
        this.dataCompraMaquina = dataCompraMaquina;
    }

    public String getCapacidadeMaquina() {
        return capacidadeMaquina;
    }

    public void setCapacidadeMaquina(String capacidadeMaquina) {
        this.capacidadeMaquina = capacidadeMaquina;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }


}
