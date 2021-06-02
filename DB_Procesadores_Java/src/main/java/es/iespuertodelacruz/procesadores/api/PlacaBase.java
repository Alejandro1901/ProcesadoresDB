package es.iespuertodelacruz.procesadores.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class PlacaBase {
   
private static final String DELIMITADOR = "'";

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
     * Constructor mediante cadena de texto
     * 
     * @param cadena con la se crea la placa base
     */
    public PlacaBase(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.id = Integer.parseInt((String) elementos.get(0));
        this.idSocket = Integer.parseInt((String) elementos.get(1));
        this.nombre = (String) elementos.get(2);
    }

    /**
     * Constructor vacio
     */
    public PlacaBase() {}

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

    @Override
    public String toString() {
        return getId() + DELIMITADOR +
            getIdSocket() + DELIMITADOR +
            getNombre();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PlacaBase)) {
            return false;
        }
        PlacaBase placaBase = (PlacaBase) o;
        return id == placaBase.id && idSocket == placaBase.idSocket && Objects.equals(nombre, placaBase.nombre);
    }
}
