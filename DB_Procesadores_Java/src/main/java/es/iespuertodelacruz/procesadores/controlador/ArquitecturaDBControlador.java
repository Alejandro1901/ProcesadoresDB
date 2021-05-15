package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.modelo.ProcesadoresDBModelo;

public class ArquitecturaDBControlador {

    /**
    * Controlador de la clase ArquitecturaDBControlador
    */
   
   private static final String LA_ARQUITECTURA_QUE_SE_INDICA_NO_EXISTE = "La arquitectura que se indica NO existe en nuestra base de datos";
   ArquitecturaDBModelo ArquitecturaDBModelo;
   
   public ArquitecturaDBControlador() {
      ArquitecturaControlador = new ArquitecturaDBControlador();
      
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
}
