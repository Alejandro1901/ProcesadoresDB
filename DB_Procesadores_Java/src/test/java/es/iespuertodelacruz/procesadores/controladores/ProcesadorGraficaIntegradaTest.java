package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.controlador.ProcesadorGraficaIntegradaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;


public class ProcesadorGraficaIntegradaTest {
    ProcesadorGraficaIntegrada procesadorGraficaIntegrada = new ProcesadorGraficaIntegrada();
    ProcesadorGraficaIntegradaControlador procesadorGraficaIntegradaControlador;
    ProcesadorGraficaIntegrada procesadorGraficaIntegradaInvalido = crearProcesadorGraficaIntegradaInvalida();

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (procesadorGraficaIntegradaControlador == null) {
            procesadorGraficaIntegradaControlador = new ProcesadorGraficaIntegradaControlador();
        }
        if (procesadorGraficaIntegrada.getIdProcesador() == 0) {
            procesadorGraficaIntegrada = crearProcesadorGraficaIntegrada();
        }
        if (procesadorGraficaIntegradaControlador.buscar(procesadorGraficaIntegrada.getIdProcesador()) == null) {
            procesadorGraficaIntegradaControlador.insertar(procesadorGraficaIntegrada);
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    procesadorGraficaIntegradaControlador.eliminar(procesadorGraficaIntegrada.getIdProcesador());
    }
    
    @Test
    public void buscarProcesadorGraficaIntegrada() throws PersistenciaException {
        ProcesadorGraficaIntegrada placaBaseEncontrada = procesadorGraficaIntegradaControlador.buscar(procesadorGraficaIntegrada.getIdProcesador());
        assertEquals(placaBaseEncontrada, procesadorGraficaIntegrada, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarProcesadorGraficaIntegradaTest() throws PersistenciaException {
        ArrayList<ProcesadorGraficaIntegrada> lista = procesadorGraficaIntegradaControlador.buscarTodos();
        assertTrue(lista.contains(procesadorGraficaIntegrada),"La lista no contiene el valor esperado");
    }

    @Test
    public void procesadorGraficaIntegradaInvalidaTest() throws ControladoresDBException, PersistenciaException {
        try {
            procesadorGraficaIntegradaControlador.insertar(procesadorGraficaIntegradaInvalido);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(procesadorGraficaIntegradaControlador.buscar(procesadorGraficaIntegradaInvalido.getIdProcesador()));
        }
    }

    @Test
    public void modificarProcesadorGraficaIntegradaTest() throws ControladoresDBException, PersistenciaException {
        ProcesadorGraficaIntegrada procesadorGraficaIntegradaModificado = crearProcesadorGraficaIntegradaModificado();
        procesadorGraficaIntegradaControlador.modificar(procesadorGraficaIntegradaModificado);
        assertNotEquals(procesadorGraficaIntegradaControlador.buscar(procesadorGraficaIntegrada.getIdProcesador()), procesadorGraficaIntegrada, "No se ha modificado el campo esperado");
    }

    private static ProcesadorGraficaIntegrada crearProcesadorGraficaIntegrada() {
        return new ProcesadorGraficaIntegrada(1,3);
    }

    private static ProcesadorGraficaIntegrada crearProcesadorGraficaIntegradaInvalida() {
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = new ProcesadorGraficaIntegrada();
        procesadorGraficaIntegrada.setIdProcesador(-6);
        procesadorGraficaIntegrada.setIdGraficaIntegrada(-5);
        return procesadorGraficaIntegrada;
    }

    private static ProcesadorGraficaIntegrada crearProcesadorGraficaIntegradaModificado() {
        return new ProcesadorGraficaIntegrada(1,5);
    }
}
