package es.iespuertodelacruz.procesadores.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.*;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class Bbdd {

    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
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
     * @throws PersistenciaException controlado
     */
    private Connection getConnection() throws PersistenciaException {
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
    private void actualizar(String sql) throws PersistenciaException {
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

    //METODOS DE INSERCION

    /**
     * Metodo encargado de realizar la insercion de una arquitectura
     * 
     * @param arquitectura a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Arquitectura arquitectura) throws PersistenciaException {
        String sql = "INSERT INTO arquitectura (id, version_arquitectura, disenio, tecnologia, estandar) " + SQL_VALUES
                + arquitectura.getId() + SQL_COMA 
                + arquitectura.getVersion() + SQL_COMA 
                + arquitectura.getDisenio() + SQL_COMA 
                + arquitectura.getTecnologia() + SQL_COMA 
                + arquitectura.getEstandar() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un fabricante
     * 
     * @param fabricante a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Fabricante fabricante) throws PersistenciaException {
        String sql = "INSERT INTO fabricante (codigo, codigo_postal, nombre, numero, pais, calle, telefono, "
                + "correo, web) " + SQL_VALUES 
                + fabricante.getCodigo() + SQL_COMA 
                + fabricante.getCodigoPostal() + SQL_COMA 
                + fabricante.getNombre() + SQL_COMA 
                + fabricante.getNumero() + SQL_COMA
                + fabricante.getPais() + SQL_COMA 
                + fabricante.getCalle() + SQL_COMA 
                + fabricante.getTelefono() + SQL_COMA 
                + fabricante.getCorreo() + SQL_COMA 
                + fabricante.getWeb() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de una grafica integrada
     * 
     * @param graficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        String sql = "INSERT INTO grafica_integrada (id, nombre_grafica, frec_basica, frec_max, memoria_max, resolucion) "
                + SQL_VALUES 
                + graficaIntegrada.getId() + SQL_COMA 
                + graficaIntegrada.getNombreGrafica() + SQL_COMA
                + graficaIntegrada.getFrecuenciaBasica() + SQL_COMA 
                + graficaIntegrada.getFrecuenciaMaxima() + SQL_COMA
                + graficaIntegrada.getMemoriaMaxima() + SQL_COMA 
                + graficaIntegrada.getResolucion() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un registro en nombre_procesador
     * 
     * @param nombreProcesador a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(NombreProcesador nombreProcesador) throws PersistenciaException {
        String sql = "INSERT INTO nombre_procesador (modelo_procesador, familia, generacion) " + SQL_VALUES
                + nombreProcesador.getModeloProcesador() + SQL_COMA 
                + nombreProcesador.getFamilia() + SQL_COMA
                + nombreProcesador.getGeneracion() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de una placa base
     * 
     * @param placaBase a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(PlacaBase placaBase) throws PersistenciaException {
        String sql = "INSERT INTO placa_base (id, id_socket, nombre) " + SQL_VALUES 
                + placaBase.getId() + SQL_COMA
                + placaBase.getIdSocket() + SQL_COMA 
                + placaBase.getNombre() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un procesador
     * 
     * @param procesador a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Procesador procesador) throws PersistenciaException {
        String sql = "INSERT INTO procesador (id, codigo_fabricante, id_socket, id_arquitectura, modelo, "
                + "fecha_lanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio) " + SQL_VALUES
                + procesador.getId() + SQL_COMA 
                + procesador.getCodigoFabricante() + SQL_COMA 
                + procesador.getIdSocket() + SQL_COMA 
                + procesador.getIdArquitectura() + SQL_COMA 
                + procesador.getModelo() + SQL_COMA
                + procesador.getFechaLanzamiento() + SQL_COMA 
                + procesador.getNucleos() + SQL_COMA
                + procesador.getHilos() + SQL_COMA 
                + procesador.getFrecuencia() + SQL_COMA 
                + procesador.getOverclock() + SQL_COMA 
                + procesador.getTdp() + SQL_COMA 
                + procesador.getPrecio() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de realizar la insercion de un registro en
     * procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        String sql = "INSERT INTO procesador_grafica_integrada (id_procesador, id_grafica_integrada) " + SQL_VALUES
                + procesadorGraficaIntegrada.getIdProcesador() + SQL_COMA
                + procesadorGraficaIntegrada.getIdGraficaIntegrada() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    /**
     * Metodo encargado de insertar un socket
     * 
     * @param socket a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Zocalo socket) throws PersistenciaException {
        String sql = "INSERT INTO socket (id, tipo, tecnologia, fecha_lanzamiento) " + SQL_VALUES 
                + socket.getId() + SQL_COMA 
                + socket.getTipo() + SQL_COMA 
                + socket.getTecnologia() + SQL_COMA
                + socket.getFechaLanzamiento() + SQL_FIN_PARENTESIS;
        actualizar(sql);
    }

    //METODOS DE MODIFICACION

    /**
     * Metodo encargado de modificar una arquitectura de la BBDD
     * 
     * @param arquitectura a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Arquitectura arquitectura) throws PersistenciaException {
        String sql = "UPDATE arquitectura SET id = '" + arquitectura.getId() 
                + "', version_arquitectura = '" + arquitectura.getVersion() 
                + "', disenio = '" + arquitectura.getDisenio() 
                + "', tecnologia = '" + arquitectura.getTecnologia() 
                + "', estandar = '" + arquitectura.getEstandar() 
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar un fabricante de la BBDD
     * 
     * @param fabricante a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Fabricante fabricante) throws PersistenciaException {
        String sql = "UPDATE fabricante SET codigo = '" + fabricante.getCodigo() 
                + "', codigo_postal = '" + fabricante.getCodigoPostal() 
                + "', nombre = '" + fabricante.getNombre() 
                + "', numero = '" + fabricante.getNumero() 
                + "', pais = '" + fabricante.getPais() 
                + "', calle = '" + fabricante.getCalle() 
                + "', telefono = '" + fabricante.getTelefono() 
                + "', correo = '" + fabricante.getCorreo() 
                + "', web = '" + fabricante.getWeb() 
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar una grafica de la BBDD
     * 
     * @param graficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        String sql = "UPDATE grafica_integrada SET id = '" + graficaIntegrada.getId() 
                + "', nombre_grafica = '" + graficaIntegrada.getNombreGrafica() 
                + "', frec_basica = '" + graficaIntegrada.getFrecuenciaBasica() 
                + "', frec_max = '" + graficaIntegrada.getFrecuenciaMaxima() 
                + "', memoria_max = '" + graficaIntegrada.getMemoriaMaxima() 
                + "', resolucion = '" + graficaIntegrada.getResolucion() 
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar un registro en nombre_procesador
     * 
     * @param nombreProcesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(NombreProcesador nombreProcesador) throws PersistenciaException {
        String sql = "UPDATE nombre_procesador SET modelo_procesador = '" + nombreProcesador.getModeloProcesador() 
                + "', familia = '" + nombreProcesador.getFamilia() 
                + "', generacion = '" + nombreProcesador.getGeneracion() 
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar una placa base en la BBDD
     * 
     * @param placaBase a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(PlacaBase placaBase) throws PersistenciaException {
        String sql = "UPDATE placa_base SET id = '" + placaBase.getId() 
                + "', id_socket = '" + placaBase.getIdSocket()
                + "', nombre = '" + placaBase.getNombre() 
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar un procesador en la BBDD
     * 
     * @param procesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Procesador procesador) throws PersistenciaException {
        String sql = "UPDATE procesador SET id = '" + procesador.getId()
                + "', codigo_fabricante = '" + procesador.getCodigoFabricante()
                + "', id_socket = '" + procesador.getIdSocket()
                + "', id_arquitectura = '" + procesador.getIdArquitectura()
                + "', modelo = '" + procesador.getModelo()
                + "', fecha_lanzamiento = '" + procesador.getFechaLanzamiento()
                + "', nucleos = '" + procesador.getNucleos()
                + "', hilos = '" + procesador.getHilos()
                + "', frecuencia = '" + procesador.getFrecuencia()
                + "', overclock = '" + procesador.getOverclock()
                + "', tdp = '" + procesador.getTdp()
                + "', precio = '" + procesador.getPrecio()
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar un registro en procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        String sql = "UPDATE procesador_grafica_integrada SET id_procesador = '" + procesadorGraficaIntegrada.getIdProcesador()
                + "', id_grafica_integrada = '" + procesadorGraficaIntegrada.getIdGraficaIntegrada()
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de modificar un socket en la BBDD
     * 
     * @param socket a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Zocalo socket) throws PersistenciaException {
        String sql = "UPDATE socket SET id = '" + socket.getId()
                + "', tipo = '" + socket.getTipo()
                + "', tecnologia = '" + socket.getTecnologia()
                + "', fecha_lanzamiento = '" + socket.getFechaLanzamiento()
                + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    //METODOS DE ELIMINACION

    /**
     * Metodo encargado de eliminar una arquitectura de la BBDD
     * 
     * @param arquitectura a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Arquitectura arquitectura) throws PersistenciaException {
        String sql = "DELETE FROM arquitectura WHERE id = '" + arquitectura.getId() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de eliminar un fabricante de la BBDD
     * 
     * @param fabricante a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Fabricante fabricante) throws PersistenciaException {
        String sql = "DELETE FROM fabricante WHERE codigo = '" + fabricante.getCodigo() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

     /**
     * Metodo encargado de eliminar una grafica integrada de la BBDD
     * 
     * @param graficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        String sql = "DELETE FROM grafica_integrada WHERE id = '" + graficaIntegrada.getId() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de eliminar un registro de nombre_procesador
     * 
     * @param nombreProcesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(NombreProcesador nombreProcesador) throws PersistenciaException {
        String sql = "DELETE FROM nombre_procesador WHERE modelo_procesador = '" + nombreProcesador.getModeloProcesador() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de eliminar una placa base de la BBDD
     * 
     * @param placaBase a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(PlacaBase placaBase) throws PersistenciaException {
        String sql = "DELETE FROM placa_base WHERE id = '" + placaBase.getId() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de eliminar un procesador de la BBDD
     * 
     * @param procesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Procesador procesador) throws PersistenciaException {
        String sql = "DELETE FROM procesador WHERE id = '" + procesador.getId() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de eliminar un registro de procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        String sql = "DELETE FROM procesador_grafica_integrada WHERE id_procesador = '" + procesadorGraficaIntegrada.getIdProcesador() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    /**
     * Metodo encargado de eliminar un socket de la BBDD
     * 
     * @param socket a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Zocalo socket) throws PersistenciaException {
        String sql = "DELETE FROM socket WHERE id = '" + socket.getId() + SQL_FIN_COMILLA_SIMPLE;
        actualizar(sql);
    }

    //obtenerListado


    private ArrayList<Object> obtenerListado(String sql) throws PersistenciaException {
        ArrayList<Object> listado = new ArrayList<>();

        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            decidirTabla(resultSet, sql, listado);
        } catch (Exception exception) {
            throw new PersistenciaException("Se ha producido un error realizando el listado");
        } finally {
            closeConecction(connection, statement, resultSet);
        }
        return listado;
    }

    private ArrayList<Object> decidirTabla(ResultSet resultSet, String sql, ArrayList<Object> listado) throws SQLException {
        while (resultSet.next()) {
                if (sql.contains(" nombre_procesador;")) {
                    NombreProcesador nombreProcesador = crearNombreProcesador(resultSet);
                    listado.add(nombreProcesador);
                } else if (sql.contains(" arquitectura;")) {
                    
                } else if (sql.contains(" fabricante;")) {

                } else if (sql.contains(" zocalo;")) {

                } else if (sql.contains(" placa_base;")) {

                } else if (sql.contains(" grafica_integrada;")) {

                } else if (sql.contains(" procesador;")) {

                } else if (sql.contains(" procesador_grafica_integrada;")) {

                }
        }
    }

    /**
     * Funcion que crea un objeto NombreProcesador segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto NombreProcesador
     * @throws SQLException 
     */
    private NombreProcesador crearNombreProcesador(ResultSet resultSet) {
        String modeloProcesador = "";
        String familia = "";
        byte generacion = 0;
        try {
            modeloProcesador = resultSet.getString("modelo_procesador");
            familia = resultSet.getString("familia");
            generacion = resultSet.getByte("generacion");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
        NombreProcesador nombreProcesador = new NombreProcesador(modeloProcesador, familia, generacion);
        return nombreProcesador;
    }

    /**
     * Metodo encargado de cerrar la conexion con la base de datos
     * 
     * @param connection a cerra
     * @param statement  a cerrar
     * @param resultSet  a cerrar
     * @throws PersistenciaException con mensaje descriptivo
     */
    private void closeConecction(Connection connection, Statement statement, ResultSet resultSet)
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
