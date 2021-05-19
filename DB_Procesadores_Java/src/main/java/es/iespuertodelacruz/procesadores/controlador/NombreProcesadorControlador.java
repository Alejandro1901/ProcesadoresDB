package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.modelo.NombreProcesadorModelo;

public class NombreProcesadorControlador {

 /**
 * Controlador de la clase NombreProcesadorDBControlador
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

   if (nombreProcesador.getFamilia() == null || nombreProcesador.getFamilia().isEmpty()) {
      mensaje = "El ModeloProcesador del nombreProcesador no puede tener valores nulos y tiene que existir al menos un dato, ";
      } 

   if (nombreProcesador.getGeneracion() < 0) {
      mensaje = "La generacion del nombreProcesador no puede ser cero o menor que el, ";
      }
      
   if (!mensaje.isEmpty()) {
      throw new ControladoresDBException(mensaje);
      }  

   }
}
   