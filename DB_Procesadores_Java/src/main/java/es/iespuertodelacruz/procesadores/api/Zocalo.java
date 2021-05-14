package es.iespuertodelacruz.procesadores.api;

import java.sql.Date;

public class Zocalo {
    int id;
    String tipo;
    String tecnologia;
    Date fechaLanzamiento;

    /**
     * Constructor con todos los parametros
     * 
     * @param id del socket
     * @param tipo del socket
     * @param tecnologia usada por el socket
     * @param fechaLanzamiento del socket
     */
    public Zocalo(int id, String tipo, String tecnologia, Date fechaLanzamiento) {
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

    public Date getFechaLanzamiento() {
        return this.fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}