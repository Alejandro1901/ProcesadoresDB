package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

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
    Procesador procesadorInvalido = new Procesador();

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
        if (procesadorInvalido.getId() == 0) {
            procesadorInvalido = crearProcesadorInvalido();
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

    @Test
    public void listarProcesadorTest() throws PersistenciaException {
        ArrayList<Procesador> lista = procesadorControlador.buscarTodos();
        assertTrue(lista.contains(procesador),"La lista no contiene el valor esperado");
    }

    @Test
    public void procesadorInvalidoTest() throws ControladoresDBException, PersistenciaException {
        try {
            procesadorControlador.insertar(procesadorInvalido);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(procesadorControlador.buscar(procesadorInvalido.getId()));
        }
    }

    private static Procesador crearProcesador() {
        return new Procesador(143,"US4581401001",1,2,"11900K","Q1´21",8,16,3.5F,false,125F,569.90F,false);
    }

    private static Procesador crearProcesadorInvalido() {
        Procesador procesador = new Procesador();
        procesador.setId(-5);
        procesador.setCodigoFabricante("");
        procesador.setIdSocket(-5);
        procesador.setIdArquitectura(-8);
        procesador.setModelo("");
        procesador.setFechaLanzamiento("");
        procesador.setNucleos(-3);
        procesador.setHilos(-6);
        procesador.setFrecuencia(-4);
        procesador.setTdp(-33);
        procesador.setPrecio(-66);
        return procesador;
    }
}
