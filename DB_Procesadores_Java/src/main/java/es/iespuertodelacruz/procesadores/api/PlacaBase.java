package es.iespuertodelacruz.procesadores.api;

public class PlacaBase {
    int id;
    int idSocket;
    String nombre;

    /**
     * Constructor con todos los parametros
     * 
     * @param id de la placa base
     * @param idSocket del socket colocado en la placa base
     * @param nombre de la placa base
     */
    public PlacaBase(int id, int idSocket, String nombre) {
        this.id = id;
        this.idSocket = idSocket;
        this.nombre = nombre;
    }

    /**
     * Constructor vacio
     */
    public PlacaBase() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSocket() {
        return this.idSocket;
    }

    public void setIdSocket(int idSocket) {
        this.idSocket = idSocket;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
