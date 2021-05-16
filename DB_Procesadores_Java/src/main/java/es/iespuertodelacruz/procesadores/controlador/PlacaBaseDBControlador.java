package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.modelo.PlacaBaseModelo;


public class PlacaBaseDBControlador {

 /**
 * Controlador de la clase PlacaBaseDBControlador
 */

private static final String LA_PLACA_BASE_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
PlacaBaseModelo placaBaseModelo;

public PlacaBaseDBControlador() {
    placaBaseModelo= new PlacaBaseModelo();
   }

/**
 * 
 * @param placaBase
 * @throws ControladoresDBException
 */

   public void validarPlacaBase(PlacaBase placaBase) throws ControladoresDBException {
      String mensaje = "";
     
      if (placaBase == null) {
         mensaje = "Se esta validando un objeto nulo de PlacaBase";
         throw new ControladoresDBException(mensaje);
         } 

      if (placaBase.getId() < 0) {
         mensaje = "La ID de placa base no puede ser cero o menor que el, ";
         }
      
      if (placaBase.getIdSocket() < 0) {
         mensaje = "La IdSocket de placa base no puede ser cero o menor que el, ";
         }  
         
      if (placaBase.getNombre() == null || placaBase.getNombre().isEmpty()) {
         mensaje = "El nombre de la placa base no puede tener valores nulos y tiene que existir al menos un dato, ";
         } 

      if (!mensaje.isEmpty()) {
         throw new ControladoresDBException(mensaje);
         }

   }
}
   