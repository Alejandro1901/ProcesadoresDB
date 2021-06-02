package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.controlador.PlacaBaseControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class PlacaBaseControladorTest {
    
    PlacaBase placaBase = new PlacaBase();
    PlacaBaseControlador placaBaseControlador;
    PlacaBase placaBaseInvalida = new PlacaBase();

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (placaBaseControlador == null) {
            placaBaseControlador = new PlacaBaseControlador();
        }
        if (placaBase.getId() == 0) {
            placaBase = crearPlacaBase();
        }
        if (placaBaseControlador.buscar(placaBase.getId()) == null) {
            placaBaseControlador.insertar(placaBase);
        }
        if (placaBaseInvalida.getId() == 0) {
            placaBaseInvalida = crearPlacaBaseInvalida();
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    placaBaseControlador.eliminar(placaBase.getId());
    }
    
    @Test
    public void buscarPlacaBase() throws PersistenciaException {
        PlacaBase placaBaseEncontrada = placaBaseControlador.buscar(placaBase.getId());
        assertEquals(placaBaseEncontrada, placaBase, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarPlacaBaseTest() throws PersistenciaException {
        ArrayList<PlacaBase> lista = placaBaseControlador.buscarTodos();
        assertTrue(lista.contains(placaBase),"La lista no contiene el valor esperado");
    }

    @Test
    public void placaBaseInvalidaTest() throws ControladoresDBException, PersistenciaException {
        try {
            placaBaseControlador.insertar(placaBaseInvalida);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(placaBaseControlador.buscar(placaBaseInvalida.getId()));
        }
    }

    private static PlacaBase crearPlacaBase() {
        return new PlacaBase(100, 101, "test" );
    }

    private static PlacaBase crearPlacaBaseInvalida() {
        PlacaBase placaBase = new PlacaBase();
        placaBase.setId(-8);
        placaBase.setIdSocket(-9);
        placaBase.setNombre("");
        return placaBase;
    }
}

