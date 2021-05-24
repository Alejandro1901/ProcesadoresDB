package es.iespuertodelacruz.procesadores.vista;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.*;
import es.iespuertodelacruz.procesadores.controlador.*;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class AppVista {

    private static final String DEBES_INSERTAR_UN_NUMERO = "Debes insertar un número";
    private static final String ADIOS = "¡Adios!";
    private static final String ESCRIBE_UNA_DE_LAS_OPCIONES = "Escribe una de las opciones";
    private static final String SALIR = "7. Atras";
    private static final String ZOCALO = "6. Zocalo";
    private static final String PLACA_BASE = "5. Placa Base";
    private static final String PROCESADOR = "4. Procesador";
    private static final String GRAFICA_INTEGRADA = "3. Grafica integrada";
    private static final String FABRICANTE = "2. Fabricante";
    private static final String ARQUITECTURA = "1. Arquitectura";
    private static final String SOLO_NUMEROS_ENTRE_1_Y_7 = "Solo números entre 1 y 7";

    public static ArquitecturaVista arquitecturaVista = new ArquitecturaVista();
    public static FabricanteVista fabricanteVista = new FabricanteVista();
    public static GraficaIntegradaVista graficaIntegradaVista = new GraficaIntegradaVista();
    public static ProcesadorVista procesadorVista = new ProcesadorVista();
    public static NombreProcesadorVista nombreProcesadorVista = new NombreProcesadorVista();
    public static PlacaBaseVista placaBaseVista = new PlacaBaseVista();
    public static ProcesadorGraficaIntegradaVista procesadorGraficaIntegradaVista = new ProcesadorGraficaIntegradaVista();
    public static ZocaloVista zocaloVista = new ZocaloVista();

    /*
    public static ProcesadorControlador procesadorControlador = new ProcesadorControlador();
    public static ArquitecturaControlador arquitecturaControlador = new ArquitecturaControlador();
    public static FabricanteControlador fabricanteControlador = new FabricanteControlador();
    public static GraficaIntegradaControlador graficaIntegradaControlador = new GraficaIntegradaControlador();
    public static NombreProcesadorControlador nombreProcesadorControlador = new NombreProcesadorControlador();
    public static PlacaBaseControlador placaBaseControlador = new PlacaBaseControlador();
    public static ProcesadorGraficaIntegradaControlador procesadorGraficaIntegradaControlador = new ProcesadorGraficaIntegradaControlador();
    public static ZocaloControlador zocaloControlador = new ZocaloControlador();
    */

    public static void main(String[] args) throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¡Hola! Bienvenido a ProcesadoresDB");
            System.out.println("¿Que tipo de usuario eres?");
            System.out.println("1. Admin"); 
            System.out.println("2. Usuario estandar"); //Sin permiso para modificar la BBDD
            System.out.println("3. Salir");
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Admin");
                        menuAdmin();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Usuario");
                        menuUsuario();
                        break;
                    case 3:
                        System.out.println(ADIOS);
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Submenu para el admin
     * 
     * @throws PersistenciaException controlada
     * @throws ControladoresDBException controlada
     */
    private static void menuAdmin() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("Usted ha iniciado sesion como Admin");
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Insertar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar");
            System.out.println("5. Listar");
            System.out.println("6. Atras");
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado insertar");
                        menuInsertar();
                        break;
                    case 2:
                        System.out.println("Has seleccionado modificar");
                        menuModificar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado eliminar");
                        menuEliminar();
                        break;
                    case 4:
                        System.out.println("Has seleccionado buscar");
                        menuBuscar();
                        break;
                    case 5:
                        System.out.println("Has seleccionado listar");
                        menuListar();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuUsuario() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("Usted ha iniciado sesion como Usuario");
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Buscar");
            System.out.println("2. Listar");
            System.out.println("3. Atras");
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado buscar");
                        menuBuscar();
                        break;
                    case 2:
                        System.out.println("Has seleccionado listar");
                        menuListar();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Submenu para insertar un campo
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    private static void menuInsertar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla deseas insertar una nueva fila?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado insertar una Arquitectura");
                        arquitecturaVista.insertar();
                        break;
                    case 2:
                        System.out.println("Has seleccionado insertar un Fabricante");
                        fabricanteVista.insertar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado insertar una Grafica integrada");
                        graficaIntegradaVista.insertar();
                        break;
                    case 4:
                        System.out.println("Has seleccionado insertar un Procesador");
                        procesadorVista.insertar();
                        break;
                    case 5:
                        System.out.println("Has seleccionado insertar una Placa Base");
                        placaBaseVista.insertar();
                        break;
                    case 6:
                        System.out.println("Has seleccionado insertar un Zocalo");
                        zocaloVista.insertar();
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    /**
     * Submenu para modificar
     * 
     * @throws ControladoresDBException controlada
     * @throws PersistenciaException controlada
     */
    private static void menuModificar() throws ControladoresDBException, PersistenciaException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla desea modificar una fila?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado modificar una Arquitectura");
                        arquitecturaVista.modificar();
                        break;
                    case 2:
                        System.out.println("Has seleccionado modificar un Fabricante");
                        fabricanteVista.modificar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado modificar una Grafica integrada");
                        graficaIntegradaVista.modificar();
                        break;
                    case 4:
                        System.out.println("Has seleccionado modificar un Procesador");
                        procesadorVista.modificar();
                        break;
                    case 5:
                        System.out.println("Has seleccionado modificar una Placa Base");
                        placaBaseVista.modificar();
                        break;
                    case 6:
                        System.out.println("Has seleccionado modificar un Zocalo");
                        zocaloVista.modificar();
                        break;
                    case 7:
                        System.out.println("Has seleccionado modificar una fila de NombreProcesador");
                        nombreProcesadorVista.modificar();
                        break;
                    case 8:
                        System.out.println("Has seleccionado modificar una fila de ProcesadorGraficaIntegrada");
                        procesadorGraficaIntegradaVista.modificar();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuEliminar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla desea eliminar una fila?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado eliminar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado eliminar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado eliminar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado eliminar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado eliminar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado eliminar un Zocalo");
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuBuscar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿En que tabla deseas buscar?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado buscar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado buscar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado buscar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado buscar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado buscar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado buscar un Zocalo");
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }

    private static void menuListar() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¿Que tabla deseas listar?");
            System.out.println(ARQUITECTURA);
            System.out.println(FABRICANTE);
            System.out.println(GRAFICA_INTEGRADA);
            System.out.println(PROCESADOR);
            System.out.println(PLACA_BASE);
            System.out.println(ZOCALO);
            System.out.println(SALIR);
 
            try {
 
                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado listar una Arquitectura");
                        break;
                    case 2:
                        System.out.println("Has seleccionado listar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado listar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado listar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado listar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado listar un Zocalo");
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println(SOLO_NUMEROS_ENTRE_1_Y_7);
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                sn.next();
            }
        }
    }
}
