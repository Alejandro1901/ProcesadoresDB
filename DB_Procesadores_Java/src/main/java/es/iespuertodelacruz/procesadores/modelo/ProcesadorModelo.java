package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorModelo {

    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "procesador";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException
     */
    public ProcesadorModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una procesador
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
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una procesador
     * 
     * @param procesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Procesador procesador) throws PersistenciaException {
        String sql = "DELETE FROM procesador WHERE id = '" + procesador.getId() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una procesador
     * 
     * @param procesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Procesador procesador) throws PersistenciaException {
        String sql = "UPDATE procesador SET"
                + " codigo_fabricante = '" + procesador.getCodigoFabricante()
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
                + "' WHERE id = '" + procesador.getId() + "';";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una procesador en la bbdd
     * 
     * @param clave de la procesador
     * @return procesador encontrada
     * @throws PersistenciaException controlada
     */
    public Procesador buscar(int clave) throws PersistenciaException {
        Procesador procesadorEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<Procesador> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            procesadorEncontrada = lista.get(0);
        }
        return procesadorEncontrada;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de procesador
     * @throws PersistenciaException controlada
     */
    private ArrayList<Procesador> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<Procesador> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String codigoFabricante = resultSet.getString("codigo_fabricante");
                int idSocket = resultSet.getInt("id_socket");
                int idArquitectura = resultSet.getInt("id_arquitectura");
                String modelo = resultSet.getString("modelo");
                String fechaLanzamiento = resultSet.getString("fecha_lanzamiento");
                int nucleos = resultSet.getInt("nucleos");
                int hilos = resultSet.getInt("hilos");
                float frecuencia = resultSet.getFloat("frecuencia");
                boolean overclock = resultSet.getBoolean("overclock");
                float tdp = resultSet.getFloat("tdp");
                float precio = resultSet.getFloat("precio");
                boolean graficaPropia = resultSet.getBoolean("graficaPropia");
                Procesador Procesador = new Procesador(id, codigoFabricante, idSocket, idArquitectura, modelo, fechaLanzamiento, nucleos, hilos, frecuencia, overclock, tdp, precio, graficaPropia);
                lista.add(Procesador);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a Procesador", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }

    /**
     * Funcion encargada de buscar todas los procesador de la bbdd
     * 
     * @return arraylist de procesador
     * @throws PersistenciaException controlada
     */
    public ArrayList<Procesador> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<Procesador> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }
        return lista;
    }
}
