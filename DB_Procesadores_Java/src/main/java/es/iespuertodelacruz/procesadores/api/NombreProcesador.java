package es.iespuertodelacruz.procesadores.api;

public class NombreProcesador {
    String modeloProcesador;
    String familia;
    byte generacion;

    /**
     * 
     * @param modeloProcesador
     * @param familia
     * @param generacion
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

}
