package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.modelo.ProcesadorGraficaIntegradaModelo;

public class ProcesadorGraficaIntegradaControlador {

 /**
 * Controlador de la clase ProcesadorGraficaIntegrada
 */

private static final String EL_PROCESADOR_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE = "El ProcesadorGraficaIntegrada que se indica NO existe en nuestra base de datos";
ProcesadorGraficaIntegradaModelo procesadorGraficaIntegradaModelo;

public ProcesadorGraficaIntegradaControlador() {
   procesadorGraficaIntegradaModelo = new ProcesadorGraficaIntegradaModelo();
   }
   
   /**
    * 
    * @param procesadorGraficaIntegrada a validar
    * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
    */
   
   public void validarProcesadorGraficaIntegrada(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws ControladoresDBException {
      String mensaje = "";
      
      if (procesadorGraficaIntegrada == null) {
         mensaje = "Se esta validando un objeto nulo de ProcesadorGraficaIntegrada";
         throw new ControladoresDBException(mensaje);
      }
      
      if (procesadorGraficaIntegrada.getIdProcesador() < 0) {
         mensaje = "El IdProcesador de ProcesadorGraficaIntegrada no puede ser cero o menor que el, ";
      }

      if (procesadorGraficaIntegrada.getIdGraficaIntegrada() < 0) {
         mensaje = "La IdGraficaIntegrada de ProcesadorGraficaIntegrada no puede ser cero o menor que el, ";
      }
      if (!mensaje.isEmpty()) {
         throw new ControladoresDBException(mensaje);
      }

   }
}
   