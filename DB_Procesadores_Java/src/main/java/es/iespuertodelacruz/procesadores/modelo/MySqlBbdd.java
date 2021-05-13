package es.iespuertodelacruz.procesadores.modelo;

public class MySqlBbdd extends Bbdd {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/text";
    
    /**
     * Constructor con los aprametros que extienden desde Bbdd
     * 
     * @param driver   usado por la base de datos
     * @param url      de la base de datos
     * @param usuario  para logear en la base de datos
     * @param password del usuario
     */
    public MySqlBbdd (String usuario, String password) {
        super(driver, url, usuario, password);
    }

}
