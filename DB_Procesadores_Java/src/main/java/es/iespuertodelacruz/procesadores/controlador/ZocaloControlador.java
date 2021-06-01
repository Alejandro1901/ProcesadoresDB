package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Zocalo;
import es.iespuertodelacruz.procesadores.modelo.ZocaloModelo;

public class ZocaloControlador {

   /**
    * Controlador de la clase ZocaloDBControlador
    */

   private static final String EL_ZOCALO_QUE_SE_INDICA_NO_EXISTE = "El zocalo que se indica NO existe en nuestra base de datos";
   ZocaloModelo zocaloModelo;

   /**
    * Controlador con el modelo 
    *
    * @throws PersistenciaException controlada
    */
   public ZocaloControlador() throws PersistenciaException {
      zocaloModelo = new ZocaloModelo();
   }

/**
 * 
 * @param Zocalo a validar
 * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
 */

public void validarZocalo(Zocalo zocalo) throws ControladoresDBException {
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

   /**
     * Metodo encargado de insertar
     * @param zocalo a insertar
     * @throws ControladoresDBException con un mensaje controlado
     * @throws PersistenciaException
     */
   
    public void insertar(Zocalo zocalo) throws ControladoresDBException, PersistenciaException {
      validarZocalo(zocalo);
          if (existe(zocalo)) {
             throw new ControladoresDBException("El zocalo que se indica ya existe");
          }
          zocaloModelo.insertar(zocalo); 
       }  
       
  /**
   * Metodo encargado de eliminar
   * @param zocalo a eliminar 
   * @throws ControladoresDBException con un mensaje controlado
   * @throws PersistenciaException
   */
  
      public void eliminar(Zocalo zocalo) throws ControladoresDBException, PersistenciaException {
     validarZocalo(zocalo);
          if (!existe(zocalo)) {
             throw new ControladoresDBException(EL_ZOCALO_QUE_SE_INDICA_NO_EXISTE);
          }
          zocaloModelo.eliminar(zocalo); 
      }
      
  /**
   * Metodo encargado de realizar la eliminacion de un zocalo
   * @param Id del elemento a eliminar
   * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
   * @throws PersistenciaException 
   */   
      public void eliminar(int id) throws ControladoresDBException, PersistenciaException {
          Zocalo zocalo;
          zocalo = buscar(id);
          eliminar(zocalo);
       }
  
       /**
        * Metodo encargado de buscar por la id de la clase
        * @param id para localizar la zocalo
        * @return arquitectura a traves del id de la clase
        * @throws PersistenciaException
        */
  
      public Zocalo buscar(int id) throws PersistenciaException {
          Zocalo zocalo = null;
          zocalo = zocaloModelo.buscar(id);
          return zocalo;
       }
  
  /**
   * Metodo encargado de realizar la modificacion de un tipo de zocalo
   * @param zocalo a modificar
   * @throws ControladoresDBException controlada en caso de error
   * @throws PersistenciaException
   */
  
      public void modificar(Zocalo zocalo) throws ControladoresDBException, PersistenciaException {
        
          validarZocalo(zocalo);
          if (!existe(zocalo)) {
             throw new ControladoresDBException(EL_ZOCALO_QUE_SE_INDICA_NO_EXISTE);
          }
          zocaloModelo.modificar(zocalo);
       }
    
  /**
   * Funcion encargada de verificar si existe el zocalo
   * @param zocalo a encontrar
   * @return true/false
   * @throws PersistenciaException error controlado
   */
  
       private boolean existe(Zocalo zocalo) throws PersistenciaException {
          boolean encontrada = false;
          Zocalo zocaloEncontrada;
     
          zocaloEncontrada = buscar(zocalo.getId());
          if (zocaloEncontrada != null) {
             encontrada = true;
          }  
          return encontrada;
        }

   /**
   * Funcion que devuelve el listado completo
   * 
   * @return arraylist con los campos
   * @throws PersistenciaException controlada
   */
   public ArrayList<Zocalo> buscarTodos() throws PersistenciaException {
      return zocaloModelo.buscarTodos();
   }
  
}