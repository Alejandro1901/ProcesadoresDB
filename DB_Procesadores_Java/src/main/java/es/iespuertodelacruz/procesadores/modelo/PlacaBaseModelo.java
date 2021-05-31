package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class PlacaBaseModelo {

    private static final String PUNTO_Y_COMA = ";";
    private static final int CERO = 0;
    private static final String STRING_VACIO = "";
    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "placa_base";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public PlacaBaseModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una placaBase
     * 
     * @param placaBase a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(PlacaBase placaBase) throws PersistenciaException {
        String sql = "INSERT INTO placa_base (id, id_socket, nombre) " + SQL_VALUES 
                + placaBase.getId() + SQL_COMA
                + placaBase.getIdSocket() + SQL_COMA 
                + placaBase.getNombre() + SQL_FIN_PARENTESIS;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una placaBase
     * 
     * @param placaBase a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(PlacaBase placaBase) throws PersistenciaException {
        String sql = "DELETE FROM placa_base WHERE id = '" + placaBase.getId() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una placaBase
     * 
     * @param placaBase a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(PlacaBase placaBase) throws PersistenciaException {
        String sql = "UPDATE placa_base SET id = '" + placaBase.getId() 
                + "', id_socket = '" + placaBase.getIdSocket()
                + "', nombre = '" + placaBase.getNombre() 
                + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una placaBase en la bbdd
     * 
     * @param clave de la placaBase
     * @return placaBase encontrada
     * @throws PersistenciaException controlada
     */
    public PlacaBase buscar(int clave) throws PersistenciaException {
        PlacaBase placaBaseEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<PlacaBase> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            placaBaseEncontrada = lista.get(0);
        }
        return placaBaseEncontrada;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de placaBase
     * @throws PersistenciaException controlada
     */
    private ArrayList<PlacaBase> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<PlacaBase> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idSocket = resultSet.getInt("id_socket");
                String nombre = resultSet.getString("nombre");
                PlacaBase PlacaBase = new PlacaBase(id, idSocket, nombre);
                lista.add(PlacaBase);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a PlacaBase", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }


    /**
     * Funcion encargada de buscar todas los placaBase de la bbdd
     * 
     * @return arraylist de placaBase
     * @throws PersistenciaException controlada
     */
    public ArrayList<PlacaBase> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<PlacaBase> lista = new ArrayList<>();
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
