package es.iespuertodelacruz.procesadores.modelo;

import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class MySqlBbdd extends Bbdd {
    
    /**
     * Constructor con los aprametros que extienden desde Bbdd
     * 
     * @param driver   usado por la base de datos
     * @param url      de la base de datos
     * @param usuario  para logear en la base de datos
     * @param password del usuario
     * @throws PersistenciaException controlada
     */
    public MySqlBbdd (String driver, String url, String usuario, String password) throws PersistenciaException {
        super(driver, url, usuario, password);
    }

}
