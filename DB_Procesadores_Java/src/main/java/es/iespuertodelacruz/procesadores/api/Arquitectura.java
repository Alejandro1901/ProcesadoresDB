package es.iespuertodelacruz.procesadores.api;

public class Arquitectura {
    int id;
    String version;
    String disenio;

    /**
     * 
     * @param id
     * @param version
     * @param disenio
     */
    public Arquitectura(int id, String version, String disenio) {
        this.id = id;
        this.version = version;
        this.disenio = disenio;
    }

    /**
     * Constructor vacio
     */
    public Arquitectura() {
    }

}
