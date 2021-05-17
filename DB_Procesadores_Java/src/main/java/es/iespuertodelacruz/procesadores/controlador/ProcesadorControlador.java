package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.modelo.ProcesadorModelo;
public class ProcesadorControlador {

/**
 * Controlador de la clase ProcesadoresDBControlador
 */


    private static final String EL_PROCESADOR_QUE_SE_INDICA_NO_EXISTE = "El procesador que se indicada NO existe en nuestra base de datos";
    ProcesadorModelo procesadorModelo;
 
    public ProcesadorControlador() {
       procesadorModelo = new ProcesadorModelo();
       
    }
    /**
     * 
     * @param procesadores a validar
     * @throws ProcesadoresDBException con el mensaje descriptivo de lo que sucede
     */
    public void validarProcesadores(Procesador procesador) throws ControladoresDBException {
      String mensaje = "";
      
      if (procesador == null) {
         mensaje = "Se esta validando un objeto nulo de Procesadores";
         throw new ControladoresDBException(mensaje);
      }
      
      if (procesador.getId() < 0) {
         mensaje = "El ID del procesador no puede ser cero o menor que el, ";
      }
      
      if (procesador.getCodigoFabricante() == null || procesador.getCodigoFabricante().isEmpty()) {
         mensaje = "El CodigoFabricante del procesador no puede tener valores nulos y tiene que existir al menos un dato, ";
      }
     
      if (procesador.getIdSocket() < 0) {
            mensaje = "El IDSocket del procesador no puede ser cero o menor que el, ";
         }
     
      if (procesador.getIdArquitectura() < 0) {
            mensaje = "El ID del procesador no puede ser cero o menor que el,";
         }
         
      if (procesador.getModelo() == null || procesador.getModelo().isEmpty()) {
            mensaje = "El modelo del procesador no puede tener valores nulos y tiene que existir al menos un dato, ";
         }  
      
      if (procesador.getFechaLanzamiento() == null) {
            mensaje = "El CodigoFabricante del procesador no puede tener valores nulos y tiene que existir al menos un dato, ";
         }
      
      if (procesador.getNucleos() < 0) {
            mensaje = "Los nucleos del procesador no puede ser cero o menor que el, ";
         }
      
      if (procesador.getHilos() < 0) {
            mensaje = "Los hilos del procesador no puede ser cero o menor que el, ";
         }
         
      if (procesador.getFrecuencia() < 0) {
            mensaje = "La frecuencia del procesador no puede ser cero o menor que el, ";
         }
      
      if (procesador.getOverclock() ) {
            mensaje = "el overclock del procesador tiene que ser si o no, ";
         }
      
      if (procesador.getTdp() < 0) {
            mensaje = "Los tdp del procesador no puede ser cero o menor que el, ";
         }
         
      if (procesador.getPrecio() < 0) {
            mensaje = "Los precios del procesador no puede ser cero o menor que el. ";
         }
      
      if (!mensaje.isEmpty()) {
            throw new ControladoresDBException(mensaje);
         }
      }
      
   }
