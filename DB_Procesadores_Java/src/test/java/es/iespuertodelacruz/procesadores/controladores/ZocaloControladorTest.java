package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private static Zocalo crearZocalo() {
        return new Zocalo(101,"test","test","Q2´20");
    }
}
