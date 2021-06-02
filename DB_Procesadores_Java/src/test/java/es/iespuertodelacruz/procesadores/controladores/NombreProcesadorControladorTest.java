package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.controlador.NombreProcesadorControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class NombreProcesadorControladorTest {
    
    NombreProcesador nombreProcesador = new NombreProcesador();
    NombreProcesadorControlador nombreProcesadorControlador;
    NombreProcesador nombreProcesadorInvalido = new NombreProcesador();

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (nombreProcesadorControlador == null) {
            nombreProcesadorControlador = new NombreProcesadorControlador();
        }
        if (nombreProcesador.getModeloProcesador() == null || nombreProcesador.getModeloProcesador().isEmpty()) {
            nombreProcesador = crearNombreProcesador();
        }
        if (nombreProcesadorControlador.buscar(nombreProcesador.getModeloProcesador()) == null) {
            nombreProcesadorControlador.insertar(nombreProcesador);
        }
        if (nombreProcesadorInvalido.getModeloProcesador() == null) {
            nombreProcesadorInvalido = crearNombreProcesadorInvalido();
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    nombreProcesadorControlador.eliminar(nombreProcesador.getModeloProcesador());
    }
    
    @Test
    public void buscarNombreProcesador() throws PersistenciaException {
        NombreProcesador nombreProcesadorEncontrada = nombreProcesadorControlador.buscar(nombreProcesador.getModeloProcesador());
        assertEquals(nombreProcesadorEncontrada, nombreProcesador, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarNombreProcesadorTest() throws PersistenciaException {
        ArrayList<NombreProcesador> lista = nombreProcesadorControlador.buscarTodos();
        assertTrue(lista.contains(nombreProcesador),"La lista no contiene el valor esperado");
    }

    @Test
    public void nombreProcesadorInvalidaTest() throws ControladoresDBException, PersistenciaException {
        try {
            nombreProcesadorControlador.insertar(nombreProcesadorInvalido);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(nombreProcesadorControlador.buscar(nombreProcesadorInvalido.getModeloProcesador()));
        }
    }

    private static NombreProcesador crearNombreProcesador() {
        return new NombreProcesador("test", "test", 100);
    }

    private static NombreProcesador crearNombreProcesadorInvalido() {
        NombreProcesador nombreProcesador = new NombreProcesador();
        nombreProcesador.setModeloProcesador("");
        nombreProcesador.setFamilia("");
        nombreProcesador.setGeneracion(-5);
        return nombreProcesador;
    }
}   

