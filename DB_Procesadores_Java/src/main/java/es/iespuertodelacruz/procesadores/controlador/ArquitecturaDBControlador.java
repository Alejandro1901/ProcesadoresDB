package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.modelo.ArquitecturaModelo;

public class ArquitecturaDBControlador {

    /**
    * Controlador de la clase ArquitecturaDBControlador
    */
   
   private static final String LA_ARQUITECTURA_QUE_SE_INDICA_NO_EXISTE = "La arquitectura que se indica NO existe en nuestra base de datos";
   ArquitecturaModelo arquitecturaModelo;
   
   public ArquitecturaDBControlador() {
      arquitecturaModelo = new ArquitecturaModelo();
      
   }
   /**
    * 
    * @param arquitectura a validar
    * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
    */
   public void validarArquitectura(Arquitectura arquitectura) throws ControladoresDBException {
       String mensaje = "";

    if (arquitectura == null) {
        mensaje = "Se esta validando un objeto nulo de Procesadores";
        throw new ControladoresDBException(mensaje);
        }  
      
    if (arquitectura.getId() < 0) {
        mensaje = "El ID de arquitectura no puede ser cero o menor que el, ";
        }

    if (arquitectura.getVersion_arquitectura() == null || arquitectura.getVersion_arquitectura().isEmpty()) {
        mensaje = "La version_arquitectura de la arquitectura no puede tener valores nulos y tiene que existir al menos un dato, ";
        } 

    if (arquitectura.getDisenio() == null || arquitectura.getDisenio().isEmpty()) {
        mensaje = "El diseño de la arquitectura no puede tener valores nulos y tiene que existir al menos un dato, ";
        } 
        
    if (arquitectura.getTecnologia() == null || arquitectura.getTecnologia().isEmpty()) {
        mensaje = "La tecnologia de la arquitectura no puede tener valores nulos y tiene que existir al menos un dato, ";
        } 

    if (arquitectura.getEstandar() == null || arquitectura.getEstandar().isEmpty()) {
        mensaje = "El estandar de la arquitectura no puede tener valores nulos y tiene que existir al menos un dato, ";
        }    
    }

    /**
     * Metodo encargado de insertar
     * @param arquitectura a insertar
     * @throws ControladoresDBException con un mensaje controlado
     * @throws PersistenciaException
     */
   
     public void insertar(Arquitectura arquitectura) throws ControladoresDBException, PersistenciaException {
    validarArquitectura(arquitectura);
        if (existe(arquitectura)) {
           throw new ControladoresDBException("La Arquitectura que se indica ya existe");
        }
        arquitecturaModelo.insertar(arquitectura); 
     }  
     
/**
 * Metodo encargado de eliminar
 * @param arquitectura a eliminar 
 * @throws ControladoresDBException con un mensaje controlado
 * @throws PersistenciaException
 */

    public void eliminar(Arquitectura arquitectura) throws ControladoresDBException, PersistenciaException {
   validarArquitectura(arquitectura);
        if (!existe(arquitectura)) {
           throw new ControladoresDBException(LA_ARQUITECTURA_QUE_SE_INDICA_NO_EXISTE);
        }
        frutaModelo.eliminar(arquitectura); 
    }
    
/**
 * Metodo encargado de realizar la eliminacion de una arquitectura
 * @param Id del elemento a eliminar
 * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
 * @throws PersistenciaException 
 */   
    public void eliminar(Int Id) throws ControladoresDBException, PersistenciaException {
        Arquitectura arquitectura;
        arquitectura = buscar(id);
        eliminar(arquitectura);
     }

     /**
      * Metodo encargado de buscar por la id de la clase
      * @param id para localizar la arquitectura
      * @return arquitectura a traves del id de la clase
      * @throws PersistenciaException
      */

    public Arquitectura buscar(Int id) throws PersistenciaException {
        Arquitectura arquitectura = null;
        arquitectura = arquitecturaModelo.buscar(id);
        return arquitectura;
     }

/**
 * Metodo encargado de realizar la modificacion de un tipo de arquitectura
 * @param arquitectura a modificar
 * @throws ControladoresDBException controlada en caso de error
 * @throws PersistenciaException
 */

    public void modificar(Arquitectura arquitectura) throws ControladoresDBException, PersistenciaException {
      
        validarArquitectura(arquitectura);
        if (!existe(arquitectura)) {
           throw new ControladoresDBException(LA_ARQUITECTURA_QUE_SE_INDICA_NO_EXISTE);
        }
        arquitecturaModelo.modificar(arquitectura);
     }
  
/**
 * Funcion encargada de verificar si existe la arquitectura
 * @param arquitectura a encontrar
 * @return true/false
 * @throws PersistenciaException error controlado
 */

     private boolean existe(Arquitectura arquitectura) throws PersistenciaException {
        boolean encontrada = false;
        Arquitectura arquitecturaEncontrada;
   
        arquitecturaEncontrada = buscar(arquitectura.getId());
        if (arquitecturaEncontrada != null) {
           encontrada = true;
        }  
        return encontrada;
      }   

}
