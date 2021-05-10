package es.iespuertodelacruz.procesadores.modelo;

import java.sql.*;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.api.Socket;
import es.iespuertodelacruz.procesadores.excepcion.BbddException;

public class Bbdd {

    private static final String SQL_FIN = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
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

    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * 
     * @param sql a ejecutar
     * @throws BbddException error controlado
     */
    private void actualizar(String sql) throws BbddException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error realizando la consulta", exception);
        } finally {
            closeConecction(connection, statement, null);
        }

    }

    /**
     * Metodo encargado de realizar la insercion de una arquitectura
     * 
     * @param arquitectura a insertar
     * @throws BbddException controlada
     */
    public void insertar(Arquitectura arquitectura) throws BbddException {
        String sql = "INSERT INTO arquitectura (id, version, disenio, tecnologia, estandar) " + SQL_VALUES
                + arquitectura.getId() + SQL_COMA + arquitectura.getVersion() + SQL_COMA + arquitectura.getDisenio()
                + SQL_COMA + arquitectura.getTecnologia() + SQL_COMA + arquitectura.getEstandar() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un fabricante
     * 
     * @param fabricante a insertar
     * @throws BbddException controlada
     */
    public void insertar(Fabricante fabricante) throws BbddException {
        String sql = "INSERT INTO fabricante (codigo, codigo_postal, nombre, numero, pais, calle, telefono, "
                + "correo, web) " + SQL_VALUES + fabricante.getCodigo() + SQL_COMA + fabricante.getCodigoPostal()
                + SQL_COMA + fabricante.getNombre() + SQL_COMA + fabricante.getNumero() + SQL_COMA
                + fabricante.getPais() + SQL_COMA + fabricante.getCalle() + SQL_COMA + fabricante.getTelefono()
                + SQL_COMA + fabricante.getCorreo() + SQL_COMA + fabricante.getWeb() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de una grafica integrada
     * 
     * @param graficaIntegrada a insertar
     * @throws BbddException controlada
     */
    public void insertar(GraficaIntegrada graficaIntegrada) throws BbddException {
        String sql = "INSERT INTO grafica_integrada (id, nombre_grafica, frec_basica, frec_max, memoria_max, resolucion) "
                + SQL_VALUES + graficaIntegrada.getId() + SQL_COMA + graficaIntegrada.getNombreGrafica() + SQL_COMA
                + graficaIntegrada.getFrecuenciaBasica() + SQL_COMA + graficaIntegrada.getFrecuenciaMaxima() + SQL_COMA
                + graficaIntegrada.getMemoriaMaxima() + SQL_COMA + graficaIntegrada.getResolucion() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un registro en nombre_procesador
     * 
     * @param nombreProcesador a insertar
     * @throws BbddException controlada
     */
    public void insertar(NombreProcesador nombreProcesador) throws BbddException {
        String sql = "INSERT INTO nombre_procesador (modelo_procesador, familia, generacion) " + SQL_VALUES
                + nombreProcesador.getModeloProcesador() + SQL_COMA + nombreProcesador.getFamilia() + SQL_COMA
                + nombreProcesador.getGeneracion() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de una placa base
     * 
     * @param placaBase a insertar
     * @throws BbddException controlada
     */
    public void insertar(PlacaBase placaBase) throws BbddException {
        String sql = "INSERT INTO placa_base (id, id_socket, nombre) " + SQL_VALUES + placaBase.getId() + SQL_COMA
                + placaBase.getIdSocket() + SQL_COMA + placaBase.getNombre() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un procesador
     * 
     * @param procesador a insertar
     * @throws BbddException controlada
     */
    public void insertar(Procesador procesador) throws BbddException {
        String sql = "INSERT INTO procesador (id, codigo_fabricante, id_socket, id_arquitectura, modelo, "
                + "fecha_lanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio) " + SQL_VALUES
                + procesador.getId() + SQL_COMA + procesador.getCodigoFabricante() + SQL_COMA + procesador.getIdSocket()
                + SQL_COMA + procesador.getIdArquitectura() + SQL_COMA + procesador.getModelo() + SQL_COMA
                + procesador.getFechaLanzamiento() + SQL_COMA + procesador.getNucleos() + SQL_COMA
                + procesador.getHilos() + SQL_COMA + procesador.getFrecuencia() + SQL_COMA + procesador.getOverclock()
                + SQL_COMA + procesador.getTdp() + SQL_COMA + procesador.getPrecioMedio() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un registro en
     * procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a insertar
     * @throws BbddException controlada
     */
    public void insertar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws BbddException {
        String sql = "INSERT INTO procesador_grafica_integrada (id_procesador, id_grafica_integrada) " + SQL_VALUES
                + procesadorGraficaIntegrada.getIdProcesador() + SQL_COMA
                + procesadorGraficaIntegrada.getIdGraficaIntegrada() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodo encargado de insertar un socket
     * 
     * @param socket a insertar
     * @throws BbddException controlada
     */
    public void insertar(Socket socket) throws BbddException {
        String sql = "INSERT INTO socket (id, tipo, tecnologia, fecha_lanzamiento) " + SQL_VALUES
                + socket.getId() + SQL_COMA + socket.getTipo() + SQL_COMA + socket.getTecnologia() 
                + SQL_COMA + socket.getFechaLanzamiento() + SQL_FIN;
        actualizar(sql);
    }

    /**
     * Metodoe ncargado de cerrar la conexion con la base de datos
     * 
     * @param connection a cerra
     * @param statement  a cerrar
     * @param resultSet  a cerrar
     * @throws BbddException con mensaje descriptivo
     */
    private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
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
            throw new BbddException("Se ha producido un error cerrando la coneccion", exception);
        }

    }
}
