package es.iespuertodelacruz.procesadores.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.procesadores.api.Arquitectura;

public class AppVista {

    private static final String DEBES_INSERTAR_UN_NUMERO = "Debes insertar un número";
    private static final String ADIOS = "¡Adios!";
    private static final String ESCRIBE_UNA_DE_LAS_OPCIONES = "Escribe una de las opciones";
    private static final String SALIR = "7. Salir";
    private static final String ZOCALO = "6. Zocalo";
    private static final String PLACA_BASE = "5. Placa Base";
    private static final String PROCESADOR = "4. Procesador";
    private static final String GRAFICA_INTEGRADA = "3. Grafica integrada";
    private static final String FABRICANTE = "2. Fabricante";
    private static final String ARQUITECTURA = "1. Arquitectura";
    private static final String SOLO_NUMEROS_ENTRE_1_Y_7 = "Solo números entre 1 y 7";

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("¡Hola! Bienvenido a ProcesadoresDB");
            System.out.println("¿Que tipo de usuario eres?");
            System.out.println("1. Usuario estandar"); //Sin permiso para modificar la BBDD
            System.out.println("2. Admin");
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
     */
    public static void menuAdmin() {
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
            System.out.println("6. Salir");
 
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
                        System.out.println(ADIOS);
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

    /**
     * Submenu para el usuario (usuario estandar, sin permisos para modificar la BBDD)
     */
    public static void menuUsuario() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("Usted ha iniciado sesion como Usuario");
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Buscar");
            System.out.println("2. Listar");
            System.out.println("3. Salir");
 
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

    public static void menuInsertar() {
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
                        break;
                    case 2:
                        System.out.println("Has seleccionado insertar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado insertar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado insertar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado insertar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado insertar un Zocalo");
                        break;
                    case 7:
                        System.out.println(ADIOS);
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

    public static void menuModificar() {
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
                        break;
                    case 2:
                        System.out.println("Has seleccionado modificar un Fabricante");
                        break;
                    case 3:
                        System.out.println("Has seleccionado modificar una Grafica integrada");
                        break;
                    case 4:
                        System.out.println("Has seleccionado modificar un Procesador");
                        break;
                    case 5:
                        System.out.println("Has seleccionado modificar una Placa Base");
                        break;
                    case 6:
                        System.out.println("Has seleccionado modificar un Zocalo");
                        break;
                    case 7:
                        System.out.println(ADIOS);
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

    public static void menuEliminar() {
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
                        System.out.println(ADIOS);
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

    public static void menuBuscar() {
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
                        System.out.println(ADIOS);
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

    public static void menuListar() {
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
                        System.out.println(ADIOS);
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

    public static Arquitectura insertarArquitectura() {
        int id = 0;
        //Terminar
    }
}
