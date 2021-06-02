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

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.controlador.FabricanteControlador;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.vista.FabricanteVista;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
public class FabricanteControladorTest {
    
    Fabricante fabricante = new Fabricante();
    FabricanteControlador fabricanteControlador;
    Fabricante fabricanteInvalido = new Fabricante();

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (fabricanteControlador == null) {
            fabricanteControlador = new FabricanteControlador();
        }
        if (fabricante.getCodigo() == null || fabricante.getCodigo().isEmpty()) {
            fabricante = crearFabricante();
        }
        if (fabricanteControlador.buscar(fabricante.getCodigo()) == null) {
            fabricanteControlador.insertar(fabricante);
        }
        if (fabricanteInvalido.getCodigo() == null) {
            fabricanteInvalido = crearFabricanteInvalido();
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
    fabricanteControlador.eliminar(fabricante.getCodigo());
    }
    
    @Test
    public void buscarFabricanteTest() throws PersistenciaException {
        Fabricante fabricanteEncontrada = fabricanteControlador.buscar(fabricante.getCodigo());
        assertEquals(fabricanteEncontrada, fabricante, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarFabricanteTest() throws PersistenciaException {
        ArrayList<Fabricante> lista = fabricanteControlador.buscarTodos();
        assertTrue(lista.contains(fabricante),"La lista no contiene el valor esperado");
    }

    @Test
    public void fabricanteInvalidoTest() throws ControladoresDBException, PersistenciaException {
        try {
            fabricanteControlador.insertar(fabricanteInvalido);
            fail("No deberia llegar a esta linea");
        } catch (Exception e) {
            assertNull(fabricanteControlador.buscar(fabricanteInvalido.getCodigo()));
        }
    }

    @Test
    public void modificarFabricanteTest() throws ControladoresDBException, PersistenciaException {
        Fabricante fabricanteModificado = crearFabricanteParaModificar();
        fabricanteControlador.modificar(fabricanteModificado);
        assertNotEquals(fabricanteModificado, fabricante, "No se ha modificado el campo");
    }

    private static Fabricante crearFabricante() {
        return new Fabricante("test", "test", "test", 100, "test", "test", "test", "test", "test");
    }

    private static Fabricante crearFabricanteInvalido() {
        Fabricante fabricante = new Fabricante();
        fabricante.setCodigo("");
        fabricante.setCodigoPostal("");
        fabricante.setNombre("");
        fabricante.setNumero(-57);
        fabricante.setPais("");
        fabricante.setCalle("");
        fabricante.setTelefono("");
        fabricante.setCorreo("");
        fabricante.setWeb("");
        return fabricante;
    }

    private static Fabricante crearFabricanteParaModificar() {
        return new Fabricante("test", "test", "test", 100, "test2", "test", "test", "test", "test");
    }
}

