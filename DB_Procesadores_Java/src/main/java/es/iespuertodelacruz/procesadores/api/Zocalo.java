package es.iespuertodelacruz.procesadores.api;


public class Zocalo {

    private static final String DELIMITADOR = "'";

    int id;
    String tipo;
    String tecnologia;
    String fechaLanzamiento;

    /**
     * Constructor con todos los parametros
     * 
     * @param id del socket
     * @param tipo del socket
     * @param tecnologia usada por el socket
     * @param fechaLanzamiento del socket
     */
    public Zocalo(int id, String tipo, String tecnologia, String fechaLanzamiento) {
        this.id = id;
        this.tipo = tipo;
        this.tecnologia = tecnologia;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Constructor vacio
     */
    public Zocalo() {
    }

    /**
     * Creacion de getter and setters
     */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTecnologia() {
        return this.tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getFechaLanzamiento() {
        return this.fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
