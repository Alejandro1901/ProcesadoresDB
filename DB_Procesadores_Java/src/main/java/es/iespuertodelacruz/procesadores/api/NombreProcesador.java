package es.iespuertodelacruz.procesadores.api;

public class NombreProcesador {
    String modeloProcesador;
    String familia;
    int generacion;

    /**
     * Constructor con todos los parametros
     * 
     * @param modeloProcesador del procesador
     * @param familia a la que pertenece
     * @param generacion a la que pertenece
     */
    public NombreProcesador(String modeloProcesador, String familia, int generacion) {
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

    public int getGeneracion() {
        return this.generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }
}    
