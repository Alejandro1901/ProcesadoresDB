package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private static ProcesadorGraficaIntegrada crearProcesadorGraficaIntegrada() {
        return new ProcesadorGraficaIntegrada(1,3);
    }
}
