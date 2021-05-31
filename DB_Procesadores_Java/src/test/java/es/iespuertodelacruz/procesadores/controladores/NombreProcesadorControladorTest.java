package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.controlador.NombreProcesadorControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class NombreProcesadorControladorTest {
    
        NombreProcesador nombreProcesador = new NombreProcesador();
        NombreProcesadorControlador nombreProcesadorControlador;
    
        @BeforeEach
        public void setUp() throws PersistenciaException, ControladoresDBException {
            if (nombreProcesadorControlador == null) {
                nombreProcesadorControlador = new NombreProcesadorControlador();
            }
            if (nombreProcesador.getModeloProcesador() == null || nombreProcesador.getModeloProcesador().isEmpty()) {
                nombreProcesador = crearNombreProcesador();
            }
            if (nombreProcesadorControlador.buscar(nombreProcesador.getModeloProcesador()) == null) {
                nombreProcesadorControlador.insertar(nombreProcesador;
            }
        }
    
        @AfterEach
        public void after() throws ControladoresDBException, PersistenciaException {
        nombreProcesadorControlador.eliminar(nombreProcesador.getModeloProcesador());
        }
        
        @Test
        public void buscarNombreProcesador() throws PersistenciaException {
            NombreProcesador nombreProcesadorEncontrada = nombreProcesadorControlador.buscar(nombreProcesador.getModeloProcesador());
            assertEquals(nombreProcesadorEncontrada, nombreProcesador, "No es igual la ruta encontrada a la esperada");
        }
    
        private static NombreProcesador crearNombreProcesador() {
            return new NombreProcesador("test", "test", 100);
        }
    }   

