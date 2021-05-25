package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.controlador.ProcesadorGraficaIntegradaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorGraficaIntegradaVista {
    public static ProcesadorGraficaIntegradaControlador procesadorGraficaIntegradaControlador = new ProcesadorGraficaIntegradaControlador();

    /**
     * Funcion que nos permite crear un objeto NombreProcesador
     * 
     * @param modelo del procesador
     * @return objeto NombreProcesador
     */
    private static ProcesadorGraficaIntegrada crearProcesadorGraficaIntegrada() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del procesador");
        int idProcesador = sn.nextInt();
        System.out.println("Escribe la id de la grafica integrada");
        int idGraficaIntegrada = sn.nextInt();
        sn.close();
        return new ProcesadorGraficaIntegrada(idProcesador, idGraficaIntegrada);
    }

    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = crearProcesadorGraficaIntegrada();
        procesadorGraficaIntegradaControlador.modificar(procesadorGraficaIntegrada);
    }

    /**
     * Metodo que nos permite eliminar
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void eliminar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        int idProcesador = sn.nextInt();
        procesadorGraficaIntegradaControlador.eliminar(idProcesador);
    }
}
