package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.controlador.NombreProcesadorControlador;
import es.iespuertodelacruz.procesadores.controlador.ProcesadorControlador;
import es.iespuertodelacruz.procesadores.controlador.ProcesadorGraficaIntegradaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorVista {
    public static ProcesadorControlador procesadorControlador;
    public static NombreProcesadorControlador nombreProcesadorControlador;
    public static ProcesadorGraficaIntegradaControlador procesadorGraficaIntegradaControlador;
    public static NombreProcesadorVista nombreProcesadorVista;

    /**
     * Constructor con los controladores
     * 
     * @throws PersistenciaException controlada
     */
    public ProcesadorVista() throws PersistenciaException {
        procesadorControlador = new ProcesadorControlador();
        nombreProcesadorControlador = new NombreProcesadorControlador();
        procesadorGraficaIntegradaControlador = new ProcesadorGraficaIntegradaControlador();
        nombreProcesadorVista = new NombreProcesadorVista();
    }


    /**
     * Funcion que nos permite crear una procesador
     * 
     * @return objeto Procesador
     */
    private static Procesador crearProcesador() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del procesador");
        int id = sn.nextInt();
        System.out.println("Escibe la id del fabricante del procesador");
        String codigoFabricante = sn.next();
        System.out.println("Escribe la id del tipo de socket donde se puede alojar el procesador");
        int idSocket = sn.nextInt();
        System.out.println("Escribe la id de la arquitectura del procesador");
        int idArquitectura = sn.nextInt();
        System.out.println("Escribe el modelo del procesador");
        String modelo = sn.next();
        System.out.println("Escribe la fecha de lanzamiento del procesador");
        String fechaLanzamiento = sn.next(); //Hay que validar este valor
        System.out.println("Escribe el numero de nucleos del procesador");
        int nucleos = sn.nextInt();
        System.out.println("Escribe el numero de hilos del procesador");
        int hilos = sn.nextInt();
        System.out.println("Escribe la frecuencia a la que va el procesador");
        float frecuencia = sn.nextFloat();
        System.out.println("¿Se puede hacer overclock al procesador? (True o false)");
        boolean overclock = sn.nextBoolean();
        System.out.println("Escribe el tdp del procesador");
        float tdp = sn.nextFloat();
        System.out.println("Escribe el precio del procesador");
        float precio = sn.nextFloat();
        sn.close();
        return new Procesador(id, codigoFabricante, idSocket, idArquitectura, modelo, fechaLanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio);
    }

    /**
     * Metodo que nos permite insertar en la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void insertar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        Procesador procesador = crearProcesador();
        NombreProcesador nombreProcesador = nombreProcesadorVista.crearNombreProcesador(procesador.getModelo());
        System.out.println("Escribe la id de la grafica integrada que contiene el procesador (Si tiene)");
        int idGraficaIntegrada = sn.nextInt();
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = new ProcesadorGraficaIntegrada(procesador.getId(), idGraficaIntegrada);
        nombreProcesadorControlador.insertar(nombreProcesador);
        procesadorControlador.insertar(procesador);
        procesadorGraficaIntegradaControlador.modificar(procesadorGraficaIntegrada);
    }

    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        Procesador procesador = crearProcesador();
        procesadorControlador.modificar(procesador);
    }

    /**
     * Metodo que nos permite eliminar
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void eliminar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        int id = sn.nextInt();
        procesadorControlador.eliminar(id);
    }
}
