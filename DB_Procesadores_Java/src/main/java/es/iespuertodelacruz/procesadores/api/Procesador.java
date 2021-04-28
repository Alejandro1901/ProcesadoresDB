package es.iespuertodelacruz.procesadores.api;

import java.sql.Date;

public class Procesador {
    int id;
    String codigoFabricante;
    int idSocket;
    int idArquitectura;
    String familia;
    String modelo;
    int generacion;
    Date fechaLanzamiento;
    int litografia;
    int nucleos;
    int hilos;
    float frecBasica;
    float frecTurbo;
    int tdp;
    float precioMedio;

    /**
     * Constructor con todos los parametros
     * @param id ligado al procesador
     * @param codigoFabricante 
     * @param idSocket
     * @param idArquitectura
     * @param familia
     * @param modelo
     * @param generacion
     * @param fechaLanzamiento
     * @param litografia
     * @param nucleos
     * @param hilos
     * @param frecBasica
     * @param frecTurbo
     * @param tdp
     * @param precioMedio
     */
    public Procesador(int id, String codigoFabricante, int idSocket, int idArquitectura, String familia, String modelo, int generacion, Date fechaLanzamiento, int litografia, int nucleos, int hilos, float frecBasica, float frecTurbo, int tdp, float precioMedio) {
        this.id = id;
        this.codigoFabricante = codigoFabricante;
        this.idSocket = idSocket;
        this.idArquitectura = idArquitectura;
        this.familia = familia;
        this.modelo = modelo;
        this.generacion = generacion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.litografia = litografia;
        this.nucleos = nucleos;
        this.hilos = hilos;
        this.frecBasica = frecBasica;
        this.frecTurbo = frecTurbo;
        this.tdp = tdp;
        this.precioMedio = precioMedio;
    }


    public Procesador() {
    }


}
