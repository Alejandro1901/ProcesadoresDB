package es.iespuertodelacruz.procesadores.modelo;

import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class MySqlBbdd extends Bbdd {
    private static final String DRIVER_BBDD = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:test.db";
    
    /**
     * Constructor con los aprametros que extienden desde Bbdd
     * 
     * @param driver   usado por la base de datos
     * @param url      de la base de datos
     * @param usuario  para logear en la base de datos
     * @param password del usuario
     * @throws PersistenciaException controlada
     */
    public MySqlBbdd (String tabla, String clave, String driver, String url, String usuario, String password) throws PersistenciaException {
        super(tabla, clave, driver, url, usuario, password);
    }

    public MySqlBbdd (String tabla, String clave, String usuario, String password) throws PersistenciaException {
        super(tabla, clave, DRIVER_BBDD, URL, usuario, password);
    }
}
