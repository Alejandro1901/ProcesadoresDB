package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.controlador.NombreProcesadorControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class NombreProcesadorVista {
    public static NombreProcesadorControlador nombreProcesadorControlador = new NombreProcesadorControlador();
    
    /**
     * Funcion que nos permite crear un objeto NombreProcesador
     * 
     * @param modelo del procesador
     * @return objeto NombreProcesador
     */
    public static NombreProcesador crearNombreProcesador(String modelo) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la familia del procesador");
        String familia = sn.next();
        System.out.println("Escribe la generacion del procesador");
        int generacion = sn.nextInt();
        return new NombreProcesador(modelo, familia, generacion);
    }

    /**
     * Funcion que nos permite crear un objeto NombreProcesador
     * 
     * @return objeto NombreProcesador
     */
    public static NombreProcesador crearNombreProcesador() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe el modelo del procesador");
        String modelo = sn.next();
        System.out.println("Escribe la familia del procesador");
        String familia = sn.next();
        System.out.println("Escribe la generacion del procesador");
        int generacion = sn.nextInt();
        return new NombreProcesador(modelo, familia, generacion);
    }

    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        NombreProcesador nombreProcesador = crearNombreProcesador();
        nombreProcesadorControlador.modificar(nombreProcesador);
    }

    /**
     * Metodo que nos permite eliminar
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void eliminar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        String modeloProcesador = sn.next();
        nombreProcesadorControlador.eliminar(modeloProcesador);
    }
}
