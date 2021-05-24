package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.controlador.GraficaIntegradaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaVista {
    public static GraficaIntegradaControlador graficaIntegradaControlador = new GraficaIntegradaControlador();

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
}
