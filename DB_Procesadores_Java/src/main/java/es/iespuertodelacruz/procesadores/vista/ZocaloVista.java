package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.Zocalo;
import es.iespuertodelacruz.procesadores.controlador.ZocaloControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ZocaloVista {
    public static ZocaloControlador zocaloControlador;

    /**
     * Constructor con el controlador
     * 
     * @throws PersistenciaException controlada
     */
    public ZocaloVista() throws PersistenciaException {
        zocaloControlador = new ZocaloControlador();
    }


    /**
     * Funcion que nos permite crear un zocalo
     * 
     * @return objeto Zocalo
     */
    private static Zocalo crearZocalo() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del zocalo");
        int id = sn.nextInt();
        System.out.println("Escribe el tipo del zocalo");
        String tipo = sn.next();
        System.out.println("Escribe la tecnologia del zocalo");
        String tecnologia = sn.next();
        System.out.println("Escribe la fecha de lanzamiento del zocalo");
        String fechaLanzamiento = sn.next(); //Validar fecha
        sn.close();
        return new Zocalo(id, tipo, tecnologia, fechaLanzamiento);
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
        Zocalo zocalo = crearZocalo();
        zocaloControlador.insertar(zocalo);
    }

    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        Zocalo zocalo = crearZocalo();
        zocaloControlador.modificar(zocalo);
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
        zocaloControlador.eliminar(id);
    }

    /**
     * Metodo que nos permite buscar
     * 
     * @throws PersistenciaException controlada
     */
    public void buscar() throws PersistenciaException {
        int id = crearClave();
        Zocalo zocalo = zocaloControlador.buscar(id);
        zocalo.toString();
    }

    /**
     * Metodo que nos permite listar la tabla
     * 
     * @throws PersistenciaException controlada
     */
    public void listar() throws PersistenciaException {
        zocaloControlador.buscarTodos();
    }
}
