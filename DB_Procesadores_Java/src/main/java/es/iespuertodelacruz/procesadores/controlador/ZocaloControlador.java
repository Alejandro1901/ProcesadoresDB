package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.api.Zocalo;
import es.iespuertodelacruz.procesadores.modelo.ZocaloModelo;

public class ZocaloControlador {

 /**
 * Controlador de la clase ZocaloDBControlador
 */

private static final String EL_ZOCALO_QUE_SE_INDICA_NO_EXISTE = "El zocalo que se indica NO existe en nuestra base de datos";
ZocaloModelo zocaloModelo;

public ZocaloControlador() {
   zocaloModelo = new ZocaloModelo();
   }

/**
 * 
 * @param Zocalo a validar
 * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
 */

public void validarNombreProcesador(Zocalo zocalo) throws ControladoresDBException {
   String mensaje = "";

   if (zocalo == null) {
      mensaje = "Se esta validando un objeto nulo de zocalo";
      throw new ControladoresDBException(mensaje);
   } 
  
   if (zocalo.getId() < 0) {
      mensaje = "La ID del zocalo no puede ser cero o menor que el, ";
      }
  
   if (zocalo.getTipo() == null || zocalo.getTipo().isEmpty()) {
      mensaje = "El tipo del zocalo no puede tener valores nulos y tiene que existir al menos un dato, ";
      } 
   
   if (zocalo.getTecnologia() == null || zocalo.getTecnologia().isEmpty()) {
      mensaje = "La tecnologia del zocalo no puede tener valores nulos y tiene que existir al menos un dato, ";
      }  
   
   if (zocalo.getFechaLanzamiento() == null) {
      mensaje = "La fecha de lanzamiento del zocalo no puede tener valores nulos y tiene que existir al menos un dato, ";
      }
      if (!mensaje.isEmpty()) {
         throw new ControladoresDBException(mensaje);
         } 
   
   




   
   }
}
   