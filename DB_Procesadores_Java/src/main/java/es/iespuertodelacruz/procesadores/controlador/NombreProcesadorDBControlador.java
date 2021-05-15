package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.modelo.NombreProcesadorModelo;

public class NombreProcesadorDBControlador {

 /**
 * Controlador de la clase GraficaIntegradaDBControlador
 */

private static final String EL_NOMBRE_PROCESADOR_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
NombreProcesadorModelo nombreProcesadorModelo;

public NombreProcesadorControlador() {
   nombreProcesadorModelo = new NombreProcesadorModelo();
   }

/**
 * 
 * @param nombreProcesador a validar
 * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
 */

   public void validarNombreProcesador(NombreProcesador nombreProcesador) throws ControladoresDBException {
      String mensaje = "";

   if (nombreProcesador == null) {
      mensaje = "Se esta validando un objeto nulo de NombreProcesador";
      throw new ControladoresDBException(mensaje);
      } 

   if (nombreProcesador.getModeloProcesador() == null || nombreProcesador.getModeloProcesador().isEmpty()) {
        mensaje = "El ModeloProcesador del nombreProcesador no puede tener valores nulos y tiene que existir al menos un dato, ";
        } 

   if (nombreProcesador.getFamilia() == null || nombreProcesador.getModeloFamilia().isEmpty()) {
      mensaje = "El ModeloProcesador del nombreProcesador no puede tener valores nulos y tiene que existir al menos un dato, ";
      } 
      
   if (!mensaje.isEmpty()) {
      throw new ControladoresDBException(mensaje);
      }  

   }
}
   