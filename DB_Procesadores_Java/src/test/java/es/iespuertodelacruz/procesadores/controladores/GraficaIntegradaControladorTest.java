
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

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.controlador.GraficaIntegradaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaControladorTest {
    GraficaIntegrada graficaIntegrada = new GraficaIntegrada();
    GraficaIntegradaControlador graficaIntegradaControlador;
    GraficaIntegrada graficaIntegradaInvalida = new GraficaIntegrada();

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (graficaIntegradaControlador == null) {
            graficaIntegradaControlador = new GraficaIntegradaControlador();
        }
        if (graficaIntegrada.getId() == 0) {
            graficaIntegrada = crearGraficaIntegrada();
        }
        if (graficaIntegradaControlador.buscar(graficaIntegrada.getId()) == null) {
            graficaIntegradaControlador.insertar(graficaIntegrada);
        }
        if (graficaIntegradaInvalida.getId() == 0) {
            graficaIntegradaInvalida = crearGraficaIntegradaInvalida();
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    graficaIntegradaControlador.eliminar(graficaIntegrada.getId());
    }
    
    @Test
    public void buscarGraficaIntegradaTest() throws PersistenciaException {
        GraficaIntegrada graficaIntegradaEncontrada = graficaIntegradaControlador.buscar(graficaIntegrada.getId());
        assertEquals(graficaIntegradaEncontrada, graficaIntegrada, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarGraficaIntegradaTest() throws PersistenciaException {
        ArrayList<GraficaIntegrada> lista = graficaIntegradaControlador.buscarTodos();
        assertTrue(lista.contains(graficaIntegrada),"La lista no contiene el valor esperado");
    }

    @Test
    public void graficaIntegradaInvalidaTest() throws ControladoresDBException, PersistenciaException {
        try {
            graficaIntegradaControlador.insertar(graficaIntegradaInvalida);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(graficaIntegradaControlador.buscar(graficaIntegradaInvalida.getId()));
        }
    }

    @Test
    public void modificarGraficaIntegradaTest() throws ControladoresDBException, PersistenciaException {
        GraficaIntegrada graficaIntegradaModificada = crearGraficaIntegradaModificada();
        graficaIntegradaControlador.modificar(graficaIntegradaModificada);
        assertNotEquals(, actual);
    }

    private static GraficaIntegrada crearGraficaIntegrada() {
        return new GraficaIntegrada(123, "test", 5.1F, 5.9F, 9.0F, "720p");
    }

    private static GraficaIntegrada crearGraficaIntegradaInvalida() {
        GraficaIntegrada graficaIntegrada = new GraficaIntegrada();
        graficaIntegrada.setId(-5);
        graficaIntegrada.setNombreGrafica("");
        graficaIntegrada.setFrecuenciaBasica(-5);
        graficaIntegrada.setFrecuenciaMaxima(-8);
        graficaIntegrada.setMemoriaMaxima(-5);
        graficaIntegrada.setResolucion("");
        return graficaIntegrada;
    } 

    private static GraficaIntegrada crearGraficaIntegradaModificada() {
        return new GraficaIntegrada(123, "test2", 5.1F, 5.9F, 9.0F, "720p");
    }
} 