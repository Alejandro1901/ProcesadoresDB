package es.iespuertodelacruz.procesadores.excepcion;

public class ControladoresDBException extends Exception {
   private static final long serialVersionUID = 1L;
 
   /**
    * Un nuevo constructor con un mensaje persoonalizado
    * @param mensaje personalizado
    */
   public ControladoresDBException (String mensaje) {
      super(mensaje);
   }
 
   /**
    * Un nuevo contructor con el mensaje y la exception que produce el propio constructor
    * @param mensaje de la excepcion
    * @param exception que produce el error
    */
   public ControladoresDBException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }
 }