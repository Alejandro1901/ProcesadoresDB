package es.iespuertodelacruz.procesadores.api;

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

    /**
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
     */
    public Procesador(int id, String codigoFabricante, int idSocket, int idArquitectura, String modelo, String fechaLanzamiento, int nucleos, int hilos, float frecuencia, boolean overclock, float tdp, float precio) {
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
    }

    /**
     * Constructor vacio
     */
    public Procesador() {
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
}
