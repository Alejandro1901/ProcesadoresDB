package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.controlador.ProcesadorControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorControladorTest {
    Procesador procesador = new Procesador();
    ProcesadorControlador procesadorControlador;

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (procesadorControlador == null) {
            procesadorControlador = new ProcesadorControlador();
        }
        if (procesador.getId() == 0) {
            procesador = crearProcesador();
        }
        if (procesadorControlador.buscar(procesador.getId()) == null) {
            procesadorControlador.insertar(procesador);
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    procesadorControlador.eliminar(procesador.getId());
    }
    
    @Test
    public void buscarProcesador() throws PersistenciaException {
        Procesador placaBaseEncontrada = procesadorControlador.buscar(procesador.getId());
        assertEquals(placaBaseEncontrada, procesador, "No es igual la ruta encontrada a la esperada");
    }

    private static Procesador crearProcesador() {
        return new Procesador(143,"US4581401001",1,2,"11900K","Q1´21",8,16,3.5F,false,125F,569.90F,false);
    }
}
