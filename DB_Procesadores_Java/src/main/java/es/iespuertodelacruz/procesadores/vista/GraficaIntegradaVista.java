package es.iespuertodelacruz.procesadores.vista;

import java.util.ArrayList;
import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.controlador.GraficaIntegradaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaVista {
    public static GraficaIntegradaControlador graficaIntegradaControlador;

    /**
     * Constructor con el controlador
     * 
     * @throws PersistenciaException controlada
     */
    public GraficaIntegradaVista() throws PersistenciaException {
        graficaIntegradaControlador = new GraficaIntegradaControlador();
    }


    /**
     * Funcion que nos permite crear una grafica integrada
     * 
     * @return objeto GraficaIntegrada
     */
    private static GraficaIntegrada crearGraficaIntegrada() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id de la grafica integrada");
        int id = sn.nextInt();
        System.out.println("Escibe el nombre de la grafica integrada");
        String nombreGrafica = sn.next();
        System.out.println("Escribe la frecuencia basica a la que trabaja la grafica integrada");
        float frecuenciaBasica = sn.nextFloat();
        System.out.println("Escribe la frecuencia maxima a la que trabaja la grafica integrada");
        float frecuenciaMaxima = sn.nextFloat();
        System.out.println("Escribe la memoria maxima de la grafica integrada");
        int memoriaMaxima = sn.nextInt();
        System.out.println("Escribe la resolucion maxima que puede alcanzar la grafica integrada");
        System.out.println("(720p, 1080p ,2K, 4K, 8K o 16K)");
        String resolucion = sn.next();
        sn.close();
        return new GraficaIntegrada(id, nombreGrafica, frecuenciaBasica, frecuenciaMaxima, memoriaMaxima, resolucion);
    }

    /**
     * Funcion que nos permite crear la clave primaria de la tabla
     * 
     * @return clave primaria
     */
    private static int crearClave() {
        Scanner sn = new Scanner(System.in);
        int id = sn.nextInt();
        return id;
    }

    /**
     * Metodo que nos permite insertar en la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void insertar() throws ControladoresDBException, PersistenciaException {
        GraficaIntegrada graficaIntegrada = crearGraficaIntegrada();
        graficaIntegradaControlador.insertar(graficaIntegrada);
    }
    
    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        GraficaIntegrada graficaIntegrada = crearGraficaIntegrada();
        graficaIntegradaControlador.modificar(graficaIntegrada);
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
        graficaIntegradaControlador.eliminar(id);
    }

    /**
     * Metodo que nos permite buscar
     * 
     * @throws PersistenciaException controlada
     */
    public void buscar() throws PersistenciaException {
        int id = crearClave();
        GraficaIntegrada graficaIntegrada = graficaIntegradaControlador.buscar(id);
        graficaIntegrada.toString();
    }

    /**
     * Metodo que nos permite listar la tabla
     * 
     * @throws PersistenciaException controlada
     */
    public void listar() throws PersistenciaException {
        ArrayList<GraficaIntegrada> lista = graficaIntegradaControlador.buscarTodos();
        lista.toString();
    }
}
