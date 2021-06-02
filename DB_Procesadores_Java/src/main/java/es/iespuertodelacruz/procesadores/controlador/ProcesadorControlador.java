package es.iespuertodelacruz.procesadores.controlador;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.modelo.ProcesadorModelo;

public class ProcesadorControlador {

   /**
    * Controlador de la clase ProcesadoresDBControlador
    */

   private static final String EL_PROCESADOR_QUE_SE_INDICA_NO_EXISTE = "El procesador que se indicada NO existe en nuestra base de datos";
   ProcesadorModelo procesadorModelo;

   /**
    * Controlador con el modelo 
    *
    * @throws PersistenciaException controlada
    */
   public ProcesadorControlador() throws PersistenciaException {
      procesadorModelo = new ProcesadorModelo();

   }

   /**
    * 
    * @param procesadores a validar
    * @throws ProcesadoresDBException con el mensaje descriptivo de lo que sucede
    */
   public void validarProcesador(Procesador procesador) throws ControladoresDBException {
      String mensaje = "";

      if (procesador == null) {
         mensaje = "Se esta validando un objeto nulo de Procesadores";
         throw new ControladoresDBException(mensaje);
      }
      if (procesador.getId() < 0) {
         mensaje = "El ID del procesador no puede ser cero o menor que el, ";
      }
      if (procesador.getCodigoFabricante() == null || procesador.getCodigoFabricante().isEmpty()) {
         mensaje += "El CodigoFabricante del procesador no puede tener valores nulos y tiene que existir al menos un dato, ";
      }
      if (procesador.getIdSocket() < 0) {
         mensaje += "El IDSocket del procesador no puede ser cero o menor que el, ";
      }
      if (procesador.getIdArquitectura() < 0) {
         mensaje += "El ID del procesador no puede ser cero o menor que el,";
      }
      if (procesador.getModelo() == null || procesador.getModelo().isEmpty()) {
         mensaje += "El modelo del procesador no puede tener valores nulos y tiene que existir al menos un dato, ";
      }
      if (procesador.getFechaLanzamiento() == null || procesador.getFechaLanzamiento().isEmpty()) {
         mensaje += "El CodigoFabricante del procesador no puede tener valores nulos y tiene que existir al menos un dato, ";
      }
      if (procesador.getNucleos() < 0) {
         mensaje += "Los nucleos del procesador no puede ser cero o menor que el, ";
      }
      if (procesador.getHilos() < 0) {
         mensaje += "Los hilos del procesador no puede ser cero o menor que el, ";
      }
      if (procesador.getFrecuencia() < 0) {
         mensaje += "La frecuencia del procesador no puede ser cero o menor que el, ";
      }
      if (procesador.getTdp() < 0) {
         mensaje += "Los tdp del procesador no puede ser cero o menor que el, ";
      }
      if (procesador.getPrecio() < 0) {
         mensaje += "Los precios del procesador no puede ser cero o menor que el. ";
      }
      if (!mensaje.isEmpty()) {
         throw new ControladoresDBException(mensaje);
      }
   }

   /**
    * Metodo encargado de insertar
    * 
    * @param procesador a insertar
    * @throws ControladoresDBException con un mensaje controlado
    * @throws PersistenciaException
    */

   public void insertar(Procesador procesador) throws ControladoresDBException, PersistenciaException {
      validarProcesador(procesador);
      if (existe(procesador)) {
         throw new ControladoresDBException("El procesador que se indica ya existe");
      }
      procesadorModelo.insertar(procesador);
   }

   /**
    * Metodo encargado de eliminar
    * 
    * @param procesador a eliminar
    * @throws ControladoresDBException con un mensaje controlado
    * @throws PersistenciaException
    */

   public void eliminar(Procesador procesador) throws ControladoresDBException, PersistenciaException {
      validarProcesador(procesador);
      if (!existe(procesador)) {
         throw new ControladoresDBException(EL_PROCESADOR_QUE_SE_INDICA_NO_EXISTE);
      }
      procesadorModelo.eliminar(procesador);
   }

   /**
    * Metodo encargado de realizar la eliminacion de un procesador
    * 
    * @param id del elemento a eliminar
    * @throws ControladoresDBException del elemento a eliminarcontrolada con el
    *     error
    * @throws PersistenciaException
    */
   public void eliminar(int id) throws ControladoresDBException, PersistenciaException {
      Procesador procesador;
      procesador = buscar(id);
      eliminar(procesador);
   }

   /**
    * Metodo encargado de buscar por la id de la clase
    * 
    * @param id para localizar el procesador
    * @return procesador a traves del id de la clase
    * @throws PersistenciaException
    */

   public Procesador buscar(int id) throws PersistenciaException {
      Procesador procesador = null;
      procesador = procesadorModelo.buscar(id);
      return procesador;
   }

   /**
    * Metodo encargado de realizar la modificacion de un tipo de procesador
    * 
    * @param procesador a modificar
    * @throws ControladoresDBException controlada en caso de error
    * @throws PersistenciaException
    */

   public void modificar(Procesador procesador) throws ControladoresDBException, PersistenciaException {

      validarProcesador(procesador);
      if (!existe(procesador)) {
         throw new ControladoresDBException(EL_PROCESADOR_QUE_SE_INDICA_NO_EXISTE);
      }
      procesadorModelo.modificar(procesador);
   }

   /**
    * Funcion encargada de verificar si existe la procesador
    * 
    * @param procesador a encontrar
    * @return true/false
    * @throws PersistenciaException error controlado
    */

   private boolean existe(Procesador procesador) throws PersistenciaException {
      boolean encontrada = false;
      Procesador procesadorEncontrada;

      procesadorEncontrada = buscar(procesador.getId());
      if (procesadorEncontrada != null) {
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
   public ArrayList<Procesador> buscarTodos() throws PersistenciaException {
      return procesadorModelo.buscarTodos();
   }
}
