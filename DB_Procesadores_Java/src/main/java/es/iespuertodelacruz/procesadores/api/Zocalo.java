package es.iespuertodelacruz.procesadores.api;

import java.util.Objects;

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

    @Override
    public String toString() {
        return getId() + DELIMITADOR +
            getTipo() + DELIMITADOR +
            getTecnologia() + DELIMITADOR +
            getFechaLanzamiento();
}
    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Zocalo)) {
            return false;
        }
        Zocalo zocalo = (Zocalo) o;
        return id == zocalo.id && Objects.equals(tipo, zocalo.tipo) && Objects.equals(tecnologia, zocalo.tecnologia) && Objects.equals(fechaLanzamiento, zocalo.fechaLanzamiento);
    }

    
  

}
