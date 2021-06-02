package es.iespuertodelacruz.procesadores.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.fichero.Fichero;

public class Bbdd {

    private String tabla;
    private String clave;
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
     * @throws PersistenciaException
     */
    public Bbdd(String tabla, String clave, String driver, String url, String usuario, String password) throws PersistenciaException {
        this.tabla = tabla;
        this.clave = clave;
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        inicializarDdBd(tabla);
    }

    /**
     * Metodo que inicializa la base de datos
     * 
     * @param tabla que iniciar
     * @throws PersistenciaException controlada
     */
    private void inicializarDdBd(String tabla) throws PersistenciaException {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();
        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null,
                    new String[] {"TABLE"});
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString("TABLE_NAME"));
            }
            if (!listaTablas.contains(tabla)) {
                String crearTabla = new Fichero().leer("resources/creaciones/" + tabla + ".crear.sql");
                actualizar(crearTabla);
                String insertElemento = new Fichero().leer("resources/inserciones/" + tabla + ".insertar.sql");
                insertarElementos(insertElemento);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConecction(connection, null, resultSet);
        }
    }

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * 
     * @return la coneccion
     * @throws PersistenciaException controlado
     */
    public Connection getConnection() throws PersistenciaException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new PersistenciaException("No se ha podido establecer la coneccion con la BBDD", exception);
        }

        return connection;
    }

    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * 
     * @param sql a ejecutar
     * @throws PersistenciaException error controlado
     */
    public void actualizar(String sql) throws PersistenciaException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConecction(connection, statement, null);
        }

    }

    /**
     * Metodo que inserta elementos en la base de datos
     * 
     * @param cadena con las inserciones
     * @throws PersistenciaException controlada
     */
    protected void insertarElementos(String cadena) throws PersistenciaException {
        String[] cadenaSeparada = cadena.split(";");
        for (String sentencia : cadenaSeparada) {
            actualizar(sentencia);
        }
    }

    /**
     * Funcion que realiza una consulta sobre una sentencia sql
     * 
     * @param sql de la consulta
     * @return lista resultados
     * @throws PersistenciaException controlada
     */
    protected ResultSet buscarElementos(String sql) throws PersistenciaException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException exception) {
            throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
        }
        return resultSet;
    }

    /**
     * Metodo encargado de cerrar la conexion con la base de datos
     * 
     * @param connection a cerra
     * @param statement  a cerrar
     * @param resultSet  a cerrar
     * @throws PersistenciaException con mensaje descriptivo
     */
    public void closeConecction(Connection connection, Statement statement, ResultSet resultSet)
            throws PersistenciaException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error cerrando la coneccion", exception);
        }
    }
}