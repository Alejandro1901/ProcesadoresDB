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
}
