package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.modelo.NombreProcesadorModelo;

public class NombreProcesadorControlador {

   private static final String EL_NOMBRE_PROCESADOR_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
   NombreProcesadorModelo nombreProcesadorModelo;

   /**
    * Controlador con el modelo 
    *
    * @throws PersistenciaException controlada
    */
   public NombreProcesadorControlador() throws PersistenciaException {
      nombreProcesadorModelo = new NombreProcesadorModelo();
   }

   /**
    * Metodo que valida los objetos NombreProcesador
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

 /** 
     * Metodo encargado de insertar
     * @param nombreProcesador a insertar
     * @throws ControladoresDBException con un mensaje controlado
     * @throws PersistenciaException
     */

    public void insertar(NombreProcesador nombreProcesador) throws ControladoresDBException, PersistenciaException {
      validarNombreProcesador(nombreProcesador);
          if (existe(nombreProcesador)) {
             throw new ControladoresDBException("El nombreProcesador que se indica ya existe");
          }
         nombreProcesadorModelo.insertar(nombreProcesador); 
       }  
       
  /**
   * Metodo encargado de eliminar
   * @param modeloProcesador a eliminar 
   * @throws ControladoresDBException con un mensaje controlado
   * @throws PersistenciaException
   */
  
      public void eliminar(NombreProcesador nombreProcesador) throws ControladoresDBException, PersistenciaException {
     validarNombreProcesador(nombreProcesador);
          if (!existe(nombreProcesador)) {
             throw new ControladoresDBException(EL_NOMBRE_PROCESADOR_QUE_SE_INDICA_NO_EXISTE);
          }
          nombreProcesadorModelo.eliminar(nombreProcesador); 
      }
      
  /**
   * Metodo encargado de realizar la eliminacion de modeloProcasador
   * @param modeloProcesador del elemento a eliminar
   * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
   * @throws PersistenciaException 
   */   
      public void eliminar(String modeloProcesador) throws ControladoresDBException, PersistenciaException {
          NombreProcesador nombreProcesador;
          nombreProcesador = buscar(modeloProcesador);
          eliminar(nombreProcesador);
       }
  
       /**
        * Metodo encargado de buscar por el modeloProcesador de la clase
        * @param modeloProcesador para localizar al nombreProcesador
        * @return nombreProcesador a traves del modeloProcesador de la clase
        * @throws PersistenciaException
        */
  
      public NombreProcesador buscar(String modeloProcesador) throws PersistenciaException {
          NombreProcesador nombreProcesador = null;
          nombreProcesador = nombreProcesadorModelo.buscar(modeloProcesador);
          return nombreProcesador;
       }
  
  /**
   * Metodo encargado de realizar la modificacion de un tipo de nombreProcesador
   * @param nombreProcesador modificar
   * @throws ControladoresDBException controlada en caso de error
   * @throws PersistenciaException
   */
  
      public void modificar(NombreProcesador nombreProcesador) throws ControladoresDBException, PersistenciaException {
        
          validarNombreProcesador(nombreProcesador);
          if (!existe(nombreProcesador)) {
             throw new ControladoresDBException(EL_NOMBRE_PROCESADOR_QUE_SE_INDICA_NO_EXISTE);
          }
          nombreProcesadorModelo.modificar(nombreProcesador);
       }
    
  /**
   * Funcion encargada de verificar si existe el nombreProcesador
   * @param nombreProcesador a encontrar
   * @return true/false
   * @throws PersistenciaException error controlado
   */
  
       private boolean existe(NombreProcesador nombreProcesador) throws PersistenciaException {
          boolean encontrada = false;
          NombreProcesador nombreProcesadorEncontrada;
     
          nombreProcesadorEncontrada = buscar(nombreProcesador.getModeloProcesador());
          if (nombreProcesadorEncontrada != null) {
             encontrada = true;
          }  
          return encontrada;
        }   
  
  }


   