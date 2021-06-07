package es.iespuertodelacruz.procesadores.excepcion;
import es.iespuertodelacruz.procesadores.excepcion.*;
import es.iespuertodelacruz.procesadores.api.*;
    
public class ExcepcionesTest {
    
    
        Exception exception = new NullPointerException();
        String mensaje = "test";
    
        @Test
        public void PersistenciaExceptionTest() {
            try {
                throw new PersistenciaException(mensaje);
            } catch (PersistenciaException e) {
                assertTrue(e.getMessage().contains(mensaje));
            }
            try {
                throw new PersistenciaException(mensaje, exception);
            } catch (BbddException e) {
                assertTrue(e.getMessage().contains(mensaje));
                assertTrue(e.getCause().toString().contains(exception.toString()));
            }
        }
    
        @Test
        public void ficheroExceptionTest() {
            try {
                throw new FicheroException(mensaje);
            } catch (FicheroException e) {
                assertTrue(e.getMessage().contains(mensaje));
            }
            try {
                throw new FicheroException(mensaje, exception);
            } catch (FicheroException e) {
                assertTrue(e.getMessage().contains(mensaje));
                assertTrue(e.getCause().toString().contains(exception.toString()));
            }
        }
    
        @Test
        public void ControladoresDBExceptionTest() {
            try {
                throw new ControladoresDBException(mensaje);
            } catch (ControladoresDBException e) {
                assertTrue(e.getMessage().contains(mensaje));
            }
            try {
                throw new ControladoresDBException(mensaje, exception);
            } catch (ControladoresDBException e) {
                assertTrue(e.getMessage().contains(mensaje));
                assertTrue(e.getCause().toString().contains(exception.toString()));
            }
        }
    }
    

