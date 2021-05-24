package es.iespuertodelacruz.procesadores.vista;

import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.controlador.FabricanteControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class FabricanteVista {
    public static FabricanteControlador fabricanteControlador = new FabricanteControlador();

    /**
     * Funcion que nos permite crear un fabricante
     * 
     * @return objeto Fabricante
     */
    private static Fabricante crearFabricante() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe el codigo del fabricante");
        String codigo = sn.next();
        System.out.println("Escribe el codigo postal del fabricante");
        String codigoPostal = sn.next();
        System.out.println("Escribe el nombre del fabricante");
        String nombre = sn.next();
        System.out.println("Escribe el numero de la sede del fabricante");
        int numero = sn.nextInt();
        System.out.println("Escirbe el pais donde se ubica la sede del fabricante");
        String pais = sn.next();
        System.out.println("Escribe la calle donde se ubica la sede del fabricante");
        String calle = sn.next();
        System.out.println("Escribe el telefono de contacto del fabricante");
        String telefono = sn.next();
        System.out.println("Escribe el correo de contacto del fabricante");
        String correo = sn.next();
        System.out.println("Escribe la web del fabricante");
        String web = sn.next();
        sn.close();
        return new Fabricante(codigo, codigoPostal, nombre, calle, numero, pais, telefono, correo, web);
    }

    /**
     * Metodo que nos permite insertar en la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void insertar() throws ControladoresDBException, PersistenciaException {
        Fabricante fabricante = crearFabricante();
        fabricanteControlador.insertar(fabricante);
    }

    /**
     * Metodo que nos permite modificar un campo de la BBDD
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    public void modificar() throws ControladoresDBException, PersistenciaException {
        Fabricante fabricante = crearFabricante();
        fabricanteControlador.modificar(fabricante);
    }
}
