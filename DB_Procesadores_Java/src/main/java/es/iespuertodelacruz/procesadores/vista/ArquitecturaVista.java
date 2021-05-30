package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.controlador.ArquitecturaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ArquitecturaVista {

    public static ArquitecturaControlador arquitecturaControlador;

    /**
     * Constructor con el controlador
     * 
     * @throws PersistenciaException controlada
     */
    public ArquitecturaVista() throws PersistenciaException {
        arquitecturaControlador = new ArquitecturaControlador();
    }
    
    
    /**
     * Funcion que nos permite crear una arquitectura
     * 
     * @return objeto arquitectura
     */
    private static Arquitectura crearArquitectura() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la id del procesador");
        int id = sn.nextInt();
        System.out.println("Escribe la version de la arquitectura (x86-64 o ARM)");
        String versionArquitectura = sn.next();
        System.out.println("Escribe el diseño de la arquitectura (Por ejemplo Zen 3)");
        String disenio = sn.next();
        System.out.println("Escribe la tecnologia de la arquitectura (si tiene)");
        String tecnologia = sn.next();
        System.out.println("Escribe el estandar de la arquitectura (si tiene)");
        String estandar = sn.next();
        sn.close();
        return new Arquitectura(id, versionArquitectura, disenio, tecnologia, estandar);
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
        Arquitectura arquitectura = crearArquitectura();
        arquitecturaControlador.insertar(arquitectura);
    }
    
    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        Arquitectura arquitectura = crearArquitectura();
        arquitecturaControlador.modificar(arquitectura);
    }

    /**
     * Metodo que nos permite eliminar
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void eliminar() throws ControladoresDBException, PersistenciaException {
        int id = crearClave();
        arquitecturaControlador.eliminar(id);
    }

    /**
     * Metodo que nos permite buscar
     * 
     * @throws PersistenciaException controlada
     */
    public void buscar() throws PersistenciaException {
        int id = crearClave();
        Arquitectura arquitectura = arquitecturaControlador.buscar(id);
        arquitectura.toString();
    }
}
