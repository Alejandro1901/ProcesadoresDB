package es.iespuertodelacruz.procesadores.api;

public class NombreProcesador {
    String modeloProcesador;
    String familia;
    byte generacion;

    /**
     * Constructor con todos los parametros
     * 
     * @param modeloProcesador del procesador
     * @param familia a la que pertenece
     * @param generacion a la que pertenece
     */
    public NombreProcesador(String modeloProcesador, String familia, byte generacion) {
        this.modeloProcesador = modeloProcesador;
        this.familia = familia;
        this.generacion = generacion;
    }

    /**
     * Constructor vacio
     */
    public NombreProcesador() {
    }

    /**
     * Creacion de getter and setters
     */

    public String getModeloProcesador() {
        return this.modeloProcesador;
    }

    public void setModeloProcesador(String modeloProcesador) {
        this.modeloProcesador = modeloProcesador;
    }

    public String getFamilia() {
        return this.familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public byte getGeneracion() {
        return this.generacion;
    }

    public void setGeneracion(byte generacion) {
        this.generacion = generacion;
    }
}
