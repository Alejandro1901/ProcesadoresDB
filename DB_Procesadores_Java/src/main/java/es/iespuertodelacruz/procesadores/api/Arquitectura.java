package es.iespuertodelacruz.procesadores.api;

public class Arquitectura {
    int id;
    String version;
    String disenio;
    String tecnologia;
    String estandar;

    /**
     * Constructor con todos los parametros
     * @param id de la arquitectura
     * @param version de la arquitectura
     * @param disenio de la arquitectura
     * @param tecnologia de la arquitectura (Solo ARM)
     * @param estandar de la arquietctura (Solo x86-64)
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


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDisenio() {
        return this.disenio;
    }

    public void setDisenio(String disenio) {
        this.disenio = disenio;
    }

    public String getTecnologia() {
        return this.tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getEstandar() {
        return this.estandar;
    }

    public void setEstandar(String estandar) {
        this.estandar = estandar;
    }

}
