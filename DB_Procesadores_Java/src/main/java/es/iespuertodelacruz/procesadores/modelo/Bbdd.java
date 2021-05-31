package es.iespuertodelacruz.procesadores.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.*;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.fichero.Fichero;

public class Bbdd {

    private static final String PUNTO_Y_COMA = ";";
    private static final int CERO = 0;
    private static final String STRING_VACIO = "";
    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";

    private String tabla;
    private String clave;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    private static final String ARQUITECTURA = "arquitectura";
    private static final String FABRICANTE = "fabricante";
    private static final String GRAFICA_INTEGRADA = "grafica_integrada";
    private static final String NOMBRE_PROCESADOR = "nombre_procesador";
    private static final String PLACA_BASE = "placa_base";
    private static final String PROCESADOR = "procesador";
    private static final String PROCESADOR_GRAFICA_INTEGRADA = "procesador_grafica_integrada";
    private static final String ZOCALO = "zocalo";

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
                String crearTabla = new Fichero().leer("resources/sql/sqlite" + tabla + ".crear.sql");
                actualizar(crearTabla);
                String insertElemento = new Fichero().leer("resources/sql/sqlite" + tabla + ".insertar.sql");
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
                + arquitectura.getVersionArquitectura() + SQL_COMA 
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
                + "fecha_lanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio, graficapropia) " + SQL_VALUES
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
                + procesador.getPrecio() + SQL_COMA
                + procesador.getGraficaPropia() + SQL_FIN_PARENTESIS;
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
                + "', version_arquitectura = '" + arquitectura.getVersionArquitectura() 
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
                + "', graficapropia = '" + procesador.getGraficaPropia()
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

    //obtenerFila

    /**
     * Funcion encargada de devolver una arquitectura segun su id
     * 
     * @param idArquitectura de la arquitectura a devolver
     * @return la arquitectura si existe
     * @throws PersistenciaException controlada
     */
    public Arquitectura obtenerArquitectura(int idArquitectura) throws PersistenciaException {
        Arquitectura arquitectura = new Arquitectura();
        ArrayList<Arquitectura> lista;
        String sql = "SELECT * FROM arquitectura WHERE id = " + idArquitectura + PUNTO_Y_COMA;
        lista = (ArrayList<Arquitectura>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            arquitectura = lista.get(0);
        }
        return arquitectura;
    }

    /**
     * Funcion encargada de devolver un fabricante segun su codigo
     * 
     * @param codigo del fabricante a devolver
     * @return el fabricante si existe
     * @throws PersistenciaException controlada
     */
    public Fabricante obtenerFabricante(String codigo) throws PersistenciaException {
        Fabricante fabricante = new Fabricante();
        ArrayList<Fabricante> lista;
        String sql = "SELECT * FROM fabricante WHERE codigo = " + codigo + PUNTO_Y_COMA;
        lista = (ArrayList<Fabricante>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            fabricante = lista.get(0);
        }
        return fabricante;
    }

    /**
     * Funcion encargada de devolver una grafica integrada segun su id
     * 
     * @param id de la grafica integrada a devolver
     * @return la grafica integrada si existe
     * @throws PersistenciaException controlada
     */
    public GraficaIntegrada obtenerGraficaIntegrada(int idGraficaIntegrada) throws PersistenciaException {
        GraficaIntegrada graficaIntegrada = new GraficaIntegrada();
        ArrayList<GraficaIntegrada> lista;
        String sql = "SELECT * FROM grafica_integrada WHERE id = " + idGraficaIntegrada + PUNTO_Y_COMA;
        lista = (ArrayList<GraficaIntegrada>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            graficaIntegrada = lista.get(0);
        }
        return graficaIntegrada;
    }

    /**
     * Funcion encargada de devolver una fila de la tabla nombre_procesador segun su modelo
     * 
     * @param modeloProcesador de la fila a devolver
     * @return la fila si existe
     * @throws PersistenciaException controlada
     */
    public NombreProcesador obtenerNombreProcesador(String modeloProcesador) throws PersistenciaException {
        NombreProcesador nombreProcesador = new NombreProcesador();
        ArrayList<NombreProcesador> lista;
        String sql = "SELECT * FROM nombre_procesador WHERE modelo_procesador = " + modeloProcesador + PUNTO_Y_COMA;
        lista = (ArrayList<NombreProcesador>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            nombreProcesador = lista.get(0);
        }
        return nombreProcesador;
    }

    /**
     * Funcion encargada de devolver una placa base segun su id
     * 
     * @param idPlacaBase de la placa base a devolver
     * @return la placa base si existe
     * @throws PersistenciaException controlada
     */
    public PlacaBase obtenerPlacaBase(int idPlacaBase) throws PersistenciaException {
        PlacaBase placaBase = new PlacaBase();
        ArrayList<PlacaBase> lista;
        String sql = "SELECT * FROM placa_base WHERE id = " + idPlacaBase + PUNTO_Y_COMA;
        lista = (ArrayList<PlacaBase>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            placaBase = lista.get(0);
        }
        return placaBase;
    }

    /**
     * Funcion encargada de devolver un procesador segun su id
     * 
     * @param idProcesador del procesador a devolver
     * @return el procesador si existe
     * @throws PersistenciaException controlada
     */
    public Procesador obtenerProcesador(int idProcesador) throws PersistenciaException {
        Procesador procesador = new Procesador();
        ArrayList<Procesador> lista;
        String sql = "SELECT * FROM procesador WHERE id = " + idProcesador + PUNTO_Y_COMA;
        lista = (ArrayList<Procesador>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            procesador = lista.get(0);
        }
        return procesador;
    }

    /**
     * Funcion encargada de devolver una fila de procesador_grafica_integrada segun la id del procesador
     * 
     * @param idProcesador de la fila a devolver
     * @return la fila si existe
     * @throws PersistenciaException controlada
     */
    public ProcesadorGraficaIntegrada obtenerProcesadorGraficaIntegrada(int idProcesador) throws PersistenciaException {
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = new ProcesadorGraficaIntegrada();
        ArrayList<ProcesadorGraficaIntegrada> lista;
        String sql = "SELECT * FROM procesador_grafica_integrada WHERE id_procesador = " + idProcesador + PUNTO_Y_COMA;
        lista = (ArrayList<ProcesadorGraficaIntegrada>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            procesadorGraficaIntegrada = lista.get(0);
        }
        return procesadorGraficaIntegrada;
    }

    /**
     * Funcion encargada de devolver un zocalo segun su id
     * 
     * @param idZocalo del zocalo a devolver
     * @return el zocalo si existe
     * @throws PersistenciaException controlada
     */
    public Zocalo obtenerZocalo(int idZocalo) throws PersistenciaException {
        Zocalo zocalo = new Zocalo();
        ArrayList<Zocalo> lista;
        String sql = "SELECT * FROM zocalo WHERE id = " + idZocalo + PUNTO_Y_COMA;
        lista = (ArrayList<Zocalo>) (ArrayList<?>) obtenerListado(sql);
        if (!lista.isEmpty()) {
            zocalo = lista.get(0);
        }
        return zocalo;
    }

    //obtenerListado

    /**
     * Funcion que obtiene el listado de arquitecturas almacenadas en la BBDD
     * 
     * @return un arraylist con las arquitecturas
     * @throws PersistenciaException controlada
     */
    public ArrayList<Arquitectura> obtenerListadoArquitectura() throws PersistenciaException {
        String sql = "SELECT * FROM arquitectura;";
        return (ArrayList<Arquitectura>) (ArrayList<?>) obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de fabricantes almacenados en la BBDD
     * 
     * @return un arraylist con los fabricantes
     * @throws PersistenciaException controlada
     */
    public ArrayList<Fabricante> obtenerListadoFabricante() throws PersistenciaException {
        String sql = "SELECT * FROM fabricante;";
        return (ArrayList<Fabricante>) (ArrayList<?>) obtenerListado(sql);
    } 

    /**
     * Funcion que obtiene el listado de graficas integradas almacenadas en la BBDD
     * 
     * @return un arraylist con las graficas integradas
     * @throws PersistenciaException controlada
     */
    public ArrayList<GraficaIntegrada> obtenerListadoGraficaIntegrada() throws PersistenciaException {
        String sql = "SELECT * FROM grafica_integrada;";
        return (ArrayList<GraficaIntegrada>) (ArrayList<?>) obtenerListado(sql);
    } 

    /**
     * Funcion que obtiene el listado de registros en nombre_procesador almacenados en la BBDD
     * 
     * @return un arraylist con los registros en nombre_procesador
     * @throws PersistenciaException controlada
     */
    public ArrayList<NombreProcesador> obtenerListadoNombreProcesador() throws PersistenciaException {
        String sql = "SELECT * FROM nombre_procesador;";
        return (ArrayList<NombreProcesador>) (ArrayList<?>) obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de placas base almacenadas en la BBDD
     * 
     * @return un arraylist con las placas base
     * @throws PersistenciaException controlada
     */
    public ArrayList<PlacaBase> obtenerListadoPlacaBase() throws PersistenciaException {
        String sql = "SELECT * FROM placa_base;";
        return (ArrayList<PlacaBase>) (ArrayList<?>) obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de procesadores almacenados en la BBDD
     * 
     * @return un arraylist con los procesadores
     * @throws PersistenciaException controlada
     */
    public ArrayList<Procesador> obtenerListadoProcesador() throws PersistenciaException {
        String sql = "SELECT * FROM procesador;";
        return (ArrayList<Procesador>) (ArrayList<?>) obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de registros en procesador_grafica_integrada almacenados en la BBDD
     * 
     * @return un arraylist con los registros en procesador_grafica_integrada
     * @throws PersistenciaException controlada
     */
    public ArrayList<ProcesadorGraficaIntegrada> obtenerListadoProcesadorGraficaIntegrada() throws PersistenciaException {
        String sql = "SELECT * FROM procesador_grafica_integrada;";
        return (ArrayList<ProcesadorGraficaIntegrada>) (ArrayList<?>) obtenerListado(sql);
    }

    /**
     * Funcion que obtiene el listado de zocalos almacenados en la BBDD
     * 
     * @return un arraylist con los zocalos
     * @throws PersistenciaException controlada
     */
    public ArrayList<Zocalo> obtenerListadoZocalo() throws PersistenciaException {
        String sql = "SELECT * FROM zocalo;";
        return (ArrayList<Zocalo>) (ArrayList<?>) obtenerListado(sql);
    }

    /**
     * Funcion que realiza la consulta sobre el listado en la BBDD
     * 
     * @param sql de la consulta
     * @return lista de objetos
     * @throws PersistenciaException controlada
     */
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

    /**
     * Funcion que decide sobre que tabla es la consulta
     * 
     * @param resultSet fila
     * @param sql de la consulta
     * @param listado de los objetos a listar
     * @return una lista de objetos
     * @throws SQLException
     */
    private ArrayList<Object> decidirTabla(ResultSet resultSet, String sql, ArrayList<Object> listado) throws SQLException {
        NombreProcesador nombreProcesador;
        Arquitectura arquitectura;
        Fabricante fabricante;
        Zocalo zocalo;
        PlacaBase placaBase;
        GraficaIntegrada graficaIntegrada;
        Procesador procesador;
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada;
        while (resultSet.next()) {
                if (sql.contains(" nombre_procesador;")) {
                    nombreProcesador = crearNombreProcesador(resultSet);
                    listado.add(nombreProcesador);
                } else if (sql.contains(" arquitectura;")) {
                    arquitectura = crearArquitectura(resultSet);
                    listado.add(arquitectura);
                } else if (sql.contains(" fabricante;")) {
                    fabricante = crearFabricante(resultSet);
                    listado.add(fabricante);
                } else if (sql.contains(" zocalo;")) {
                    zocalo = crearZocalo(resultSet);
                    listado.add(zocalo);
                } else if (sql.contains(" placa_base;")) {
                    placaBase = crearPlacaBase(resultSet);
                    listado.add(placaBase);
                } else if (sql.contains(" grafica_integrada;")) {
                    graficaIntegrada = crearGraficaIntegrada(resultSet);
                    listado.add(graficaIntegrada);
                } else if (sql.contains(" procesador;")) {
                    procesador = crearProcesador(resultSet);
                    listado.add(procesador);
                } else if (sql.contains(" procesador_grafica_integrada;")) {
                    procesadorGraficaIntegrada = crearProcesadorGraficaIntegrada(resultSet);
                    listado.add(procesadorGraficaIntegrada);
                }
        }
        return listado;
    }

    /**
     * Funcion que crea un objeto NombreProcesador segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto NombreProcesador
     * @throws SQLException 
     */
    private NombreProcesador crearNombreProcesador(ResultSet resultSet) throws SQLException {
        String modeloProcesador = STRING_VACIO;
        String familia = STRING_VACIO;
        byte generacion = CERO;
        modeloProcesador = resultSet.getString("modelo_procesador");
        familia = resultSet.getString("familia");
        generacion = resultSet.getByte("generacion");
        NombreProcesador nombreProcesador = new NombreProcesador(modeloProcesador, familia, generacion);
        return nombreProcesador;
    }

    /**
     * Funcion que crea un objeto Arquitectura segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto Arquitectura
     * @throws SQLException  
     */
    private Arquitectura crearArquitectura(ResultSet resultSet) throws SQLException {
        int id = CERO;
        String version = STRING_VACIO;
        String disenio = STRING_VACIO;
        String tecnologia = STRING_VACIO;
        String estandar = STRING_VACIO;
        id = resultSet.getInt("id");
        version = resultSet.getString("version_arquitectura");
        disenio = resultSet.getString("disenio");
        tecnologia = resultSet.getString("tecnologia");
        estandar = resultSet.getString("estandar");
        Arquitectura arquitectura = new Arquitectura(id,version,disenio,tecnologia,estandar);
        return arquitectura;
    }

    /**
     * Funcion que crea un objeto Fabricante segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto Fabricante
     * @throws SQLException  
     */
    private Fabricante crearFabricante(ResultSet resultSet) throws SQLException {
        String codigo = STRING_VACIO;
        String codigoPostal = STRING_VACIO;
        String nombre = STRING_VACIO;
        int numero = CERO;
        String pais = STRING_VACIO;
        String calle = STRING_VACIO;
        String telefono = STRING_VACIO;
        String correo = STRING_VACIO;
        String web = STRING_VACIO;
        codigo = resultSet.getString("codigo");
        codigoPostal = resultSet.getString("codigo_postal");
        nombre = resultSet.getString("nombre");
        numero = resultSet.getInt("numero");
        pais = resultSet.getString("pais");
        calle = resultSet.getString("calle");
        telefono = resultSet.getString("telefono");
        correo = resultSet.getString("correo");
        web = resultSet.getString("web");
        Fabricante fabricante = new Fabricante(codigo, codigoPostal, nombre, calle, numero, pais, telefono, correo, web);
        return fabricante;
    }

    /**
     * Funcion que crea un objeto Zocalo segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto Zocalo
     * @throws SQLException  
     */
    private Zocalo crearZocalo(ResultSet resultSet) throws SQLException {
        int id = CERO;
        String tipo = STRING_VACIO;
        String tecnologia = STRING_VACIO;
        String fechaLanzamiento; //Inicializar
        id = resultSet.getInt("id");
        tipo = resultSet.getString("tipo");
        tecnologia = resultSet.getString("tecnologia");
        fechaLanzamiento = resultSet.getString("fecha_lanzamiento");
        Zocalo zocalo = new Zocalo(id, tipo, tecnologia, fechaLanzamiento);
        return zocalo;
    }

    /**
     * Funcion que crea un objeto PlacaBase segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto PlacaBase
     * @throws SQLException  
     */
    private PlacaBase crearPlacaBase(ResultSet resultSet) throws SQLException {
        int id = CERO;
        int idSocket = CERO;
        String nombre = STRING_VACIO;
        id = resultSet.getInt("id");
        idSocket = resultSet.getInt("id_socket");
        nombre = resultSet.getString("nombre");
        PlacaBase placaBase = new PlacaBase(id, idSocket, nombre);
        return placaBase;
    }

    /**
     * Funcion que crea un objeto GraficaIntegrada segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto GraficaIntegrada
     * @throws SQLException
     */
    private GraficaIntegrada crearGraficaIntegrada(ResultSet resultSet) throws SQLException {
        int id = CERO;
        String nombreGrafica = STRING_VACIO;
        float frecuenciaBasica = CERO;
        float frecuenciaMaxima = CERO;
        int memoriaMaxima = CERO;
        String resolucion = STRING_VACIO;
        id = resultSet.getInt("id");
        nombreGrafica = resultSet.getString("nombre_grafica");
        frecuenciaBasica = resultSet.getFloat("frec_basica");
        frecuenciaMaxima = resultSet.getFloat("frec_max");
        memoriaMaxima = resultSet.getInt("memoria_max");
        resolucion = resultSet.getString("resolucion");
        GraficaIntegrada graficaIntegrada = new GraficaIntegrada(id, nombreGrafica, frecuenciaBasica, frecuenciaMaxima, memoriaMaxima, resolucion);
        return graficaIntegrada;
    }

    /**
     * Funcion que crea un objeto Procesador segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto Procesador
     * @throws SQLException
     */
    private Procesador crearProcesador(ResultSet resultSet) throws SQLException {
        int id = CERO;
        String codigoFabricante = STRING_VACIO;
        int idSocket = CERO;
        int idArquitectura = CERO;
        String modelo = STRING_VACIO;
        String fechaLanzamiento; //inicializar
        int nucleos = CERO;
        int hilos = CERO;
        float frecuencia = CERO;
        boolean overclock = false;
        float tdp = CERO;
        float precio = CERO;
        boolean graficaPropia = false;
        id = resultSet.getInt("id");
        codigoFabricante = resultSet.getString("codigo_fabricante");
        idSocket = resultSet.getInt("id_socket");
        idArquitectura = resultSet.getInt("id_arquitectura");
        modelo = resultSet.getString("modelo");
        fechaLanzamiento = resultSet.getString("fecha_lanzamiento");
        nucleos = resultSet.getInt("nucleos");
        hilos = resultSet.getInt("hilos");
        frecuencia = resultSet.getFloat("frecuencia");
        overclock = resultSet.getBoolean("overclock");
        tdp = resultSet.getFloat("tdp");
        precio = resultSet.getFloat("precio");
        graficaPropia = resultSet.getBoolean("graficapropia");
        return new Procesador(id, codigoFabricante, idSocket, idArquitectura, modelo, fechaLanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio, graficaPropia);
    }

    /**
     * Funcion que crea un objeto ProcesadorGraficaIntegrada segun el resultSet pasado
     * 
     * @param resultSet con la fila
     * @return objeto ProcesadorGraficaIntegrada
     * @throws SQLException
     */
    private ProcesadorGraficaIntegrada crearProcesadorGraficaIntegrada(ResultSet resultSet) throws SQLException {
        int idProcesador = CERO;
        int idGraficaIntegrada = CERO;
        idProcesador = resultSet.getInt("id_procesador");
        idGraficaIntegrada = resultSet.getInt("id_grafica_integrada");
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = new ProcesadorGraficaIntegrada(idProcesador, idGraficaIntegrada);
        return procesadorGraficaIntegrada;
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
