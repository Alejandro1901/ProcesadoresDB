package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.controlador.PlacaBaseControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class PlacaBaseVista {
    public static PlacaBaseControlador placaBaseControlador;

    /**
     * Constructor con el controlador
     * 
     * @throws PersistenciaException controlada
     */
    public PlacaBaseVista() throws PersistenciaException {
        placaBaseControlador = new PlacaBaseControlador();
    }


    /**
     * Funcion que nos permite crear una placa base
     * 
     * @return objeto PlacaBase
     */
    private static PlacaBase crearPlacaBase() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id de la placa base");
        int id = sn.nextInt();
        System.out.println("Escribe la id del socket de la placa base");
        int idSocket = sn.nextInt();
        System.out.println("Escribe el nombre de la placa base");
        String nombre = sn.next();
        sn.close();
        return new PlacaBase(id, idSocket, nombre);
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
        PlacaBase placaBase = crearPlacaBase();
        placaBaseControlador.insertar(placaBase);
    }

    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        PlacaBase placaBase = crearPlacaBase();
        placaBaseControlador.modificar(placaBase);
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
        placaBaseControlador.eliminar(id);
    }

    /**
     * Metodo que nos permite buscar
     * 
     * @throws PersistenciaException controlada
     */
    public void buscar() throws PersistenciaException {
        int id = crearClave();
        PlacaBase placaBase = placaBaseControlador.buscar(id);
        placaBase.toString();
    }
}
