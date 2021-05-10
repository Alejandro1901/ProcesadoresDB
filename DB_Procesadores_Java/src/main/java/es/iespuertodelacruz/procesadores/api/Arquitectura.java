package es.iespuertodelacruz.procesadores.api;

public class Arquitectura {
    int id;
    String version;
    String disenio;
    String tecnologia;
    String estandar;

    /**
     * 
     * @param id
     * @param version
     * @param disenio
     */
    public Arquitectura(int id, String version, String disenio, 
        String tecnologia, String estandar) {
        this.id = id;
        this.version = version;
        this.disenio = disenio;
        this.tecnologia = tecnologia;
        this.estandar = estandar;
    }

    /**
     * Constructor vacio
     */
    public Arquitectura() {
    }

}
