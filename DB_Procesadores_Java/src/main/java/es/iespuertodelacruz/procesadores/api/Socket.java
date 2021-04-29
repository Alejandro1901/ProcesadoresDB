package es.iespuertodelacruz.procesadores.api;

import java.sql.Date;

public class Socket {
    int id;
    String tipo;
    String tecnologia;
    Date fechaLanzamiento;

    /**
     * 
     * @param id
     * @param tipo
     * @param tecnologia
     * @param fechaLanzamiento
     */
    public Socket(int id, String tipo, String tecnologia, Date fechaLanzamiento) {
        this.id = id;
        this.tipo = tipo;
        this.tecnologia = tecnologia;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Constructor vacio
     */
    public Socket() {
    }

}
