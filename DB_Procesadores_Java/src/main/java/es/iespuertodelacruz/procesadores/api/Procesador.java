package es.iespuertodelacruz.procesadores.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Procesador {

    private static final String DELIMITADOR = "'";

    int id; //PK
    String codigoFabricante; //FK
    int idSocket; //FK
    int idArquitectura; //FK
    String modelo; //FK
    String fechaLanzamiento;
    int nucleos;
    int hilos;
    float frecuencia;
    boolean overclock;
    float tdp;
    float precio;
    boolean graficaPropia;

    /**
     * Constructor con todos los parametros
     * 
     * @param id del procesador
     * @param codigoFabricante Foreignkey de la tabla fabricante
     * @param idSocket Foreignkey de la tabla socket
     * @param idArquitectura Foreiginkey de la tabla arquitectura
     * @param modelo foreignkey de la tabla nombre_procesador
     * @param fechaLanzamiento Cuando salio a la venta el procesador 
     * @param nucleos el tamaño de nucleos del procesador 
     * @param hilos a los que va el procesador
     * @param frecuencia a la que va el procesador
     * @param overclock si es posible overclock o no 
     * @param tdp del procesador
     * @param precio del procesador
     * @param graficaPropia del procesador
     */
    public Procesador(int id, String codigoFabricante, int idSocket, int idArquitectura, String modelo, String fechaLanzamiento, int nucleos, int hilos, float frecuencia, boolean overclock, float tdp, float precio, boolean graficaPropia) {
        this.id = id;
        this.codigoFabricante = codigoFabricante;
        this.idSocket = idSocket;
        this.idArquitectura = idArquitectura;
        this.modelo = modelo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.nucleos = nucleos;
        this.hilos = hilos;
        this.frecuencia = frecuencia;
        this.overclock = overclock;
        this.tdp = tdp;
        this.precio = precio;
        this.graficaPropia = graficaPropia;
    }
    
    /**
     * Constructor mediante cadena de texto
     * 
     * @param cadena con el procesador
     */
    public Procesador(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.id = Integer.parseInt((String) elementos.get(0));
        this.codigoFabricante = (String) elementos.get(1);
        this.idSocket = Integer.parseInt((String) elementos.get(2));
        this.idArquitectura = Integer.parseInt((String) elementos.get(3));
        this.modelo = (String) elementos.get(4);
        this.fechaLanzamiento = (String) elementos.get(5);
        this.nucleos = Integer.parseInt((String) elementos.get(6));
        this.hilos = Integer.parseInt((String) elementos.get(7));
        this.frecuencia = Float.parseFloat((String) elementos.get(8));
        this.overclock = Boolean.parseBoolean((String) elementos.get(9));
        this.tdp = Float.parseFloat((String) elementos.get(10));
        this.precio = Float.parseFloat((String) elementos.get(11));
        this.graficaPropia = Boolean.parseBoolean((String) elementos.get(12));
    }

    /**
     * Constructor vacio
     */
    public Procesador() {}

    /**
     * Creacion de getter and setters
     */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoFabricante() {
        return this.codigoFabricante;
    }

    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public int getIdSocket() {
        return this.idSocket;
    }

    public void setIdSocket(int idSocket) {
        this.idSocket = idSocket;
    }

    public int getIdArquitectura() {
        return this.idArquitectura;
    }

    public void setIdArquitectura(int idArquitectura) {
        this.idArquitectura = idArquitectura;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFechaLanzamiento() {
        return this.fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getNucleos() {
        return this.nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public int getHilos() {
        return this.hilos;
    }

    public void setHilos(int hilos) {
        this.hilos = hilos;
    }

    public float getFrecuencia() {
        return this.frecuencia;
    }

    public void setFrecuencia(float frecuencia) {
        this.frecuencia = frecuencia;
    }

    public boolean isOverclock() {
        return this.overclock;
    }

    public boolean getOverclock() {
        return this.overclock;
    }

    public void setOverclock(boolean overclock) {
        this.overclock = overclock;
    }

    public float getTdp() {
        return this.tdp;
    }

    public void setTdp(float tdp) {
        this.tdp = tdp;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isGraficaPropia() {
        return this.graficaPropia;
    }

    public boolean getGraficaPropia() {
        return this.graficaPropia;
    }

    public void setGraficaPropia(boolean GraficaPropia) {
        this.graficaPropia = GraficaPropia;
    }

    @Override
    public String toString() {
        return getId() + DELIMITADOR +
            getCodigoFabricante() + DELIMITADOR +
            getIdSocket() + DELIMITADOR +
            getIdArquitectura() + DELIMITADOR +
            getModelo() + DELIMITADOR +
            getFechaLanzamiento() + DELIMITADOR +
            getNucleos() + DELIMITADOR +
            getHilos() + DELIMITADOR +
            getFrecuencia() + DELIMITADOR +
            getOverclock() + DELIMITADOR +
            getTdp() + DELIMITADOR +
            getPrecio() + DELIMITADOR +
            getGraficaPropia();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Procesador)) {
            return false;
        }
        Procesador procesador = (Procesador) o;
        return id == procesador.id && Objects.equals(codigoFabricante, procesador.codigoFabricante) && idSocket == procesador.idSocket && idArquitectura == procesador.idArquitectura && Objects.equals(modelo, procesador.modelo) && Objects.equals(fechaLanzamiento, procesador.fechaLanzamiento) && nucleos == procesador.nucleos && hilos == procesador.hilos && frecuencia == procesador.frecuencia && overclock == procesador.overclock && tdp == procesador.tdp && precio == procesador.precio && graficaPropia == procesador.graficaPropia;
    }
}
