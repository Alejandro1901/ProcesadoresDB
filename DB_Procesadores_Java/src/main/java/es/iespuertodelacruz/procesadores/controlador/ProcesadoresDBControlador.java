package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.*;

public class ProcesadoresDBControlador {

/**
 * Controlador de la clase ProcesadoresDBControlador
 */


    private static final String EL_PROCESADOR_QUE_SE_INDICA_NO_EXISTE = "El procesador que se indicada NO existe en nuestra base de datos";
    ProcesadoresDBModelo ProcesadoresDBModelo;
 
    public ProcesadoresDBControlador() {
       procesadorControlador = new ProcesadoresDBControlador();
       
    }
    /**
     * 
     * @param procesadores a validar
     * @throws ProcesadoresDBException
     */
    public void validarProcesadores(Procesador procesador) throws ProcesadoresDBException {
      String mensaje = "";
      if (procesador == null) {
         mensaje = "Se esta validando un objeto nulo de Procesadores";
         throw new ProcesadoresDBException(mensaje);
      }
      if (procesador.getId() == 0) {
         procesador.setId(id);
      }
    }
}
