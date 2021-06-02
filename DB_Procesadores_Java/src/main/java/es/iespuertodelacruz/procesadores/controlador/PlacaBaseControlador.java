package es.iespuertodelacruz.procesadores.controlador;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.modelo.PlacaBaseModelo;


public class PlacaBaseControlador {

   private static final String LA_PLACA_BASE_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
   PlacaBaseModelo placaBaseModelo;

   /**
    * Controlador con el modelo 
    *
    * @throws PersistenciaException controlada
    */
   public PlacaBaseControlador() throws PersistenciaException {
      placaBaseModelo= new PlacaBaseModelo();
   }

   /**
    * Metodo que valida una placa base
    *
    * @param placaBase a validar
    * @throws ControladoresDBException controlada
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
         mensaje += "La IdSocket de placa base no puede ser cero o menor que el, ";
      }     
      if (placaBase.getNombre() == null || placaBase.getNombre().isEmpty()) {
         mensaje += "El nombre de la placa base no puede tener valores nulos y tiene que existir al menos un dato, ";
      } 
      if (!mensaje.isEmpty()) {
         throw new ControladoresDBException(mensaje);
      }
   }

   /**
    * Metodo encargado de insertar
    *
    * @param placaBase a insertar
    * @throws ControladoresDBException con un mensaje controlado
    * @throws PersistenciaException
    */
   public void insertar(PlacaBase placaBase) throws ControladoresDBException, PersistenciaException {
      validarPlacaBase(placaBase);
      if (existe(placaBase)) {
         throw new ControladoresDBException("La placaBase que se indica ya existe");
      }
      placaBaseModelo.insertar(placaBase); 
   }  
       
  /**
   * Metodo encargado de eliminar
   * 
   * @param placaBase a eliminar 
   * @throws ControladoresDBException con un mensaje controlado
   * @throws PersistenciaException
   */
   public void eliminar(PlacaBase placaBase) throws ControladoresDBException, PersistenciaException {
      validarPlacaBase(placaBase);
      if (!existe(placaBase)) {
         throw new ControladoresDBException(LA_PLACA_BASE_QUE_SE_INDICA_NO_EXISTE);
      }
      placaBaseModelo.eliminar(placaBase); 
   }
      
  /**
   * Metodo encargado de realizar la eliminacion de una placaBase
   * 
   * @param id del elemento a eliminar
   * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
   * @throws PersistenciaException 
   */   
   public void eliminar(int id) throws ControladoresDBException, PersistenciaException {
      PlacaBase placaBase;
      placaBase = buscar(id);
      eliminar(placaBase);
   }
  
   /**
   * Metodo encargado de buscar por la id de la clase
   *
   * @param id para localizar la placaBase
   * @return placaBase a traves del id de la clase
   * @throws PersistenciaException
   */
   public PlacaBase buscar(int id) throws PersistenciaException {
      PlacaBase placaBase = null;
      placaBase = placaBaseModelo.buscar(id);
      return placaBase;
   }

  /**
   * Metodo encargado de realizar la modificacion de un tipo de placaBase
   * 
   * @param placaBase a modificar
   * @throws ControladoresDBException controlada en caso de error
   * @throws PersistenciaException
   */
   public void modificar(PlacaBase placaBase) throws ControladoresDBException, PersistenciaException {
      validarPlacaBase(placaBase);
      if (!existe(placaBase)) {
         throw new ControladoresDBException(LA_PLACA_BASE_QUE_SE_INDICA_NO_EXISTE);
      }
      placaBaseModelo.modificar(placaBase);
   }
    
  /**
   * Funcion encargada de verificar si existe la placaBase
   * @param placaBase a encontrar
   * @return true/false
   * @throws PersistenciaException error controlado
   */
   private boolean existe(PlacaBase placaBase) throws PersistenciaException {
      boolean encontrada = false;
      PlacaBase placaBaseEncontrada;
      placaBaseEncontrada = buscar(placaBase.getId());
      if (placaBaseEncontrada != null) {
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
   public ArrayList<PlacaBase> buscarTodos() throws PersistenciaException {
      return placaBaseModelo.buscarTodos();
   }
}
   