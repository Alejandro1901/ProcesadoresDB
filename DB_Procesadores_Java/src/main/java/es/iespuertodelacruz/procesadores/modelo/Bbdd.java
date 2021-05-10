package es.iespuertodelacruz.procesadores.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.excepcion.BbddException;

public class Bbdd {

    private String driver;
    private String url;
    private String usuario;
    private String password;

    /**
     * Constructor con todos los parametros
     * 
     * @param driver   usado por la base de datos
     * @param url      de la base de datos
     * @param usuario  para logear en la base de datos
     * @param password del usuario
     */
    public Bbdd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * 
     * @return la coneccion
     * @throws BbddException controlado
     */
    private Connection getConnection() throws BbddException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new BbddException("No se ha podido establecer la coneccion con la BBDD", exception);
        }

        return connection;
    }

    public void insertar(Arquitectura arquitectura) throws BbddException {
        String sql = "INSERT INTO Arquitectura (id, version, disenio, tecnologia, estandar) " + 
        "VALUES ('" + arquitectura.
    }

}
