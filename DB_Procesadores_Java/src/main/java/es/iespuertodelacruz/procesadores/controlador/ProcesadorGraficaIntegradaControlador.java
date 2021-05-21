package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
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

/**
    * Metodo encargado de insertar
    * 
    * @param procesadorGraficaIntegrada a insertar
    * @throws ControladoresDBException con un mensaje controlado
    * @throws PersistenciaException
    */

    public void insertar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws ControladoresDBException, PersistenciaException {
      validarProcesadorGraficaIntegrada(procesadorGraficaIntegrada);
      if (existe(procesadorGraficaIntegrada)) {
         throw new ControladoresDBException("El procesadorGraficaIntegrada que se indica ya existe");
      }
      procesadorGraficaIntegradaModelo.insertar(procesadorGraficaIntegrada);
   }

   /**
    * Metodo encargado de eliminar
    * 
    * @param procesadorGraficaIntegrada a eliminar
    * @throws ControladoresDBException con un mensaje controlado
    * @throws PersistenciaException
    */

   public void eliminar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws ControladoresDBException, PersistenciaException {
      validarProcesadorGraficaIntegrada(procesadorGraficaIntegrada);
      if (!existe(procesadorGraficaIntegrada)) {
         throw new ControladoresDBException(EL_PROCESADOR_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE);
      }
      procesadorGraficaIntegradaModelo.eliminar(procesadorGraficaIntegrada);
   }

   /**
    * Metodo encargado de realizar la eliminacion de un procesadorGraficaIntegrada
    * 
    * @param idprocesador del elemento a eliminar
    * @throws ControladoresDBException del elemento a eliminarcontrolada con el error                         
    * @throws PersistenciaException
    */
   public void eliminar(int id) throws ControladoresDBException, PersistenciaException {
      ProcesadorGraficaIntegrada procesadorGraficaIntegrada;
      procesadorGraficaIntegrada = buscar(id);
      eliminar(procesadorGraficaIntegrada);
   }

   /**
    * Metodo encargado de buscar por la idprocesador de la clase
    * 
    * @param idprocesador para localizar el procesadorGraficaIntegrada
    * @return procesadorGraficaIntegrada a traves del idprocesador de la clase
    * @throws PersistenciaException
    */

   public ProcesadorGraficaIntegrada buscar(int idprocesador) throws PersistenciaException {
      ProcesadorGraficaIntegrada procesadorGraficaIntegrada = null;
      procesadorGraficaIntegrada = procesadorGraficaIntegradaModelo.obtenerProcesadorGraficaIntegrada(id);
      return procesadorGraficaIntegrada;
   }

   /**
    * Metodo encargado de realizar la modificacion de un tipo de procesadorGraficaIntegrada
    * 
    * @param procesadorGraficaIntegrada a modificar
    * @throws ControladoresDBException controlada en caso de error
    * @throws PersistenciaException
    */

   public void modificar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws ControladoresDBException, PersistenciaException {

      validarProcesadorGraficaIntegrada(procesadorGraficaIntegrada);
      if (!existe(procesadorGraficaIntegrada)) {
         throw new ControladoresDBException(EL_PROCESADOR_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE);
      }
      procesadorGraficaIntegradaModelo.modificar(procesadorGraficaIntegrada);
   }

   /**
    * Funcion encargada de verificar si existe la procesadorGraficaIntegrada
    * 
    * @param procesadorGraficaIntegrada a encontrar
    * @return true/false
    * @throws PersistenciaException error controlado
    */

   private boolean existe(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
      boolean encontrada = false;
      ProcesadorGraficaIntegrada procesadorGraficaIntegradaEncontrada;

      procesadorGraficaIntegradaEncontrada = buscar(procesadorGraficaIntegrada.getIdProcesador());
      if (procesadorGraficaIntegradaEncontrada != null) {
         encontrada = true;
      }
      return encontrada;
   }

}


   