package es.iespuertodelacruz.procesadores.api;

import java.sql.Date;

public class Procesador {
    int id;
    String codigoFabricante; //FK
    int idSocket; //FK
    int idArquitectura; //FK
    String modelo; 
    Date fechaLanzamiento;
    int nucleos;
    int hilos;
    float frecuencia;
    boolean overclock;
    float tdp;
    float precioMedio;

    /**
     * 
     * @param id
     * @param codigoFabricante
     * @param idSocket
     * @param idArquitectura
     * @param modelo
     * @param fechaLanzamiento
     * @param nucleos
     * @param hilos
     * @param frecuencia
     * @param overclock
     * @param tdp
     * @param precioMedio
     */
    public Procesador(int id, String codigoFabricante, int idSocket, int idArquitectura, String modelo, Date fechaLanzamiento, int nucleos, int hilos, float frecuencia, boolean overclock, int tdp, float precioMedio) {
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
        this.precioMedio = precioMedio;
    }

    /**
     * Constructor vacio
     */
    public Procesador() {
    }

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

    public Date getFechaLanzamiento() {
        return this.fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
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

    public float getPrecioMedio() {
        return this.precioMedio;
    }

    public void setPrecioMedio(float precioMedio) {
        this.precioMedio = precioMedio;
    }
}
