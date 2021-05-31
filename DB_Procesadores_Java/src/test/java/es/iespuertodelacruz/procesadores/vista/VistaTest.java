package es.iespuertodelacruz.procesadores.vista;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VistaTest {

    static AppVista appVista;

    @BeforeAll
    public static void setUp() {
        appVista = new AppVista();
    }

    @Test
    public void menuTest() {
        assertTrue(AppVista.menu(0).contains("0. Salir"));
        assertTrue(AppVista.menu(1).contains("1. Mostrar informacion de un producto"));
        assertTrue(AppVista.menu(2).contains("1. Mostrar informacion de una lista"));
        assertTrue(AppVista.menu(3).contains("1. Mostrar informacion de una operacion"));
        assertTrue(AppVista.menu(4).contains("1. Insertar nueva empresa"));
        assertTrue(AppVista.menu(5).contains("1. Calcular indice de ocupacion del almacen"));
        assertNull(AppVista.menu(6));
    }

    
    

