package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    
        private static PlacaBase crearPlacaBase() {
            return new PlacaBase(100, 101, "test" );
        }
    }   

