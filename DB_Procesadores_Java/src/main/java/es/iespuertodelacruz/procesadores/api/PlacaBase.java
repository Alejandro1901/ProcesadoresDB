package es.iespuertodelacruz.procesadores.api;

public class PlacaBase {
    int id;
    int idSocket;
    String nombre;

    /**
     * 
     * @param id
     * @param idSocket
     * @param nombre
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

}
