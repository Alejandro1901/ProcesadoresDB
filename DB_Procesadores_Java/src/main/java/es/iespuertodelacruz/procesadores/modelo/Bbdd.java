package es.iespuertodelacruz.procesadores.modelo;

public class Bbdd {
    
    private String driver;
    private String url;
    private String usuario;
    private String password;

    /**
     * Constructor con todos los parametros
     * @param driver usado por la base de datos
     * @param url de la base de datos
     * @param usuario para logear en la base de datos
     * @param password del usuario
     */
    public Bbdd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    

}
