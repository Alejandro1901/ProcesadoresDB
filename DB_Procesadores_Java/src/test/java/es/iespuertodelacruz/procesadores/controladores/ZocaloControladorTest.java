package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.api.Zocalo;
import es.iespuertodelacruz.procesadores.controlador.ZocaloControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ZocaloControladorTest {
    Zocalo zocalo = new Zocalo();
    ZocaloControlador zocaloControlador;
    Zocalo zocaloInvalido = new Zocalo();

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (zocaloControlador == null) {
            zocaloControlador = new ZocaloControlador();
        }
        if (zocalo.getId() == 0) {
            zocalo = crearZocalo();
        }
        if (zocaloControlador.buscar(zocalo.getId()) == null) {
            zocaloControlador.insertar(zocalo);
        }
        if (zocaloInvalido.getId() == 0) {
            zocaloInvalido = crearZocaloInvalido();
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    zocaloControlador.eliminar(zocalo.getId());
    }
    
    @Test
    public void buscarZocalo() throws PersistenciaException {
        Zocalo placaBaseEncontrada = zocaloControlador.buscar(zocalo.getId());
        assertEquals(placaBaseEncontrada, zocalo, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarZocaloTest() throws PersistenciaException {
        ArrayList<Zocalo> lista = zocaloControlador.buscarTodos();
        assertTrue(lista.contains(zocalo),"La lista no contiene el valor esperado");
    }

    @Test
    public void zocaloInvalidoTest() throws ControladoresDBException, PersistenciaException {
        try {
            zocaloControlador.insertar(zocalo);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(zocaloControlador.buscar(zocaloInvalido.getId()));
        }
    }

    private static Zocalo crearZocalo() {
        return new Zocalo(101,"test","test","Q2´20");
    }

    private static Zocalo crearZocaloInvalido() {
        Zocalo zocalo = new Zocalo();
        zocalo.setId(-5);
        zocalo.setTipo("");
        zocalo.setTecnologia("");
        zocalo.setFechaLanzamiento("");
        return zocalo;
    }
}
