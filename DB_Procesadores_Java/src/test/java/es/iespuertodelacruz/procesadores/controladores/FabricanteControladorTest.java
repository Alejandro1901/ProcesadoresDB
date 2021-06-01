package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.controlador.FabricanteControlador;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
public class FabricanteControladorTest {
  

        Fabricante fabricante = new Fabricante();
        FabricanteControlador fabricanteControlador;
    
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
    
        private static Fabricante crearFabricante() {
            return new Fabricante("test", "test", "test", 100, "test", "test", "test", "test", "test");
        }
    }

