package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.modelo.GraficaIntegradaModelo;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaControlador {

 /**
 * Controlador de la clase GraficaIntegradaDBControlador
 */

private static final String LA_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
GraficaIntegradaModelo graficaIntegradaModelo;

public GraficaIntegradaControlador() {
   graficaIntegradaModelo = new GraficaIntegradaModelo();
   }
   /**
    * 
    * @param graficaIntegrada a validar
    * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
    */
   public void validarGraficaIntegrada(GraficaIntegrada graficaIntegrada) throws ControladoresDBException {
    String mensaje = "";
    
    if (graficaIntegrada == null) {
        mensaje = "Se esta validando un objeto nulo de GraficaIntegrada";
        throw new ControladoresDBException(mensaje);
        }

    if (graficaIntegrada.getId() < 0) {
        mensaje = "El ID del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getNombreGrafica() == null || graficaIntegrada.getNombreGrafica().isEmpty()) {
        mensaje = "El nombregrafica de la GraficaIntegrada no puede tener valores nulos y tiene que existir al menos un dato, ";
        } 

    if (graficaIntegrada.getFrecuenciaBasica() < 0) {
        mensaje = "El frecuenciabasica del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getFrecuenciaMaxima() < 0) {
        mensaje = "El frecuenciamaxima del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getMemoriaMaxima() < 0) {
        mensaje = "El MemoriaMaxima del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getResolucion() == null || graficaIntegrada.getResolucion().isEmpty()) {
        mensaje = "El Resolucion de la GraficaIntegrada no puede tener valores nulos y tiene que existir al menos un dato, ";
        }

    if (!mensaje.isEmpty()) {
        throw new ControladoresDBException(mensaje);
        }
   }

  /** 
     * Metodo encargado de insertar
     * @param graficaIntegrada a insertar
     * @throws ControladoresDBException con un mensaje controlado
     * @throws PersistenciaException
     */

    public void insertar(GraficaIntegrada graficaIntegrada) throws ControladoresDBException, PersistenciaException {
        validarGraficaIntegrada(graficaIntegrada);
            if (existe(graficaIntegrada)) {
               throw new ControladoresDBException("La graficaIntegrada que se indica ya existe");
            }
           graficaIntegradaModelo.insertar(graficaIntegrada); 
         }  
         
    /**
     * Metodo encargado de eliminar
     * @param graficaIntegrada a eliminar 
     * @throws ControladoresDBException con un mensaje controlado
     * @throws PersistenciaException
     */
    
        public void eliminar(GraficaIntegrada graficaIntegrada) throws ControladoresDBException, PersistenciaException {
       validarGraficaIntegrada(graficaIntegrada);
            if (!existe(graficaIntegrada)) {
               throw new ControladoresDBException(LA_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE);
            }
            graficaIntegradaModelo.eliminar(graficaIntegrada); 
        }
        
    /**
     * Metodo encargado de realizar la eliminacion de una graficaIntegrada
     * @param id del elemento a eliminar
     * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
     * @throws PersistenciaException 
     */   
        public void eliminar(int id) throws ControladoresDBException, PersistenciaException {
            GraficaIntegrada graficaIntegrada;
            graficaIntegrada = buscar(id);
            eliminar(graficaIntegrada);
         }
    
         /**
          * Metodo encargado de buscar por la id de la clase
          * @param id para localizar la grafica integrada
          * @return graficaIntehrada a traves del id de la clase
          * @throws PersistenciaException
          */
    
        public GraficaIntegrada buscar(int id) throws PersistenciaException {
            GraficaIntegrada graficaIntegrada = null;
            graficaIntegrada = graficaIntegradaModelo.obtenerGraficaIntegrada(id);
            return graficaIntegrada;
         }
    
    /**
     * Metodo encargado de realizar la modificacion de un tipo de graficaIntegrada
     * @param graficaIntegrada modificar
     * @throws ControladoresDBException controlada en caso de error
     * @throws PersistenciaException
     */
    
        public void modificar(GraficaIntegrada graficaIntegrada) throws ControladoresDBException, PersistenciaException {
          
            validarGraficaIntegrada(graficaIntegrada);
            if (!existe(graficaIntegrada)) {
               throw new ControladoresDBException(LA_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE);
            }
            graficaIntegradaModelo.modificar(graficaIntegrada);
         }
      
    /**
     * Funcion encargada de verificar si existe la graficaIntegrada
     * @param graficaIntegrada a encontrar
     * @return true/false
     * @throws PersistenciaException error controlado
     */
    
         private boolean existe(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
            boolean encontrada = false;
            GraficaIntegrada graficaIntegradaEncontrada;
       
            graficaIntegradaEncontrada = buscar(graficaIntegrada.getId());
            if (graficaIntegradaEncontrada != null) {
               encontrada = true;
            }  
            return encontrada;
          }   
    
    }



   