package es.iespuertodelacruz.procesadores.excepcion;

public class ProcesadoresDBException extends Exception {
    private static final long serialVersionUID = 1L;
 
    /**
     * Un nuevo constructor con un mensaje persoonalizado
     * @param mensaje personalizado
     */
     public ProcesadoresDBException (String mensaje) {
       super(mensaje);
    }
 
    /**
     * Un nuevo contructor con el mensaje y la exception que produce el propio constructor
     * @param mensaje de la excepcion
     * @param exception que produce el error
     */
    public ProcesadoresDBException (String mensaje, Exception exception) {
       super(mensaje, exception);
    }
 }