
package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private static GraficaIntegrada crearGraficaIntegrada() {
        return new GraficaIntegrada(123, "test", 5.1F, 5.9F, 9.0F, "720p");
    }
} 