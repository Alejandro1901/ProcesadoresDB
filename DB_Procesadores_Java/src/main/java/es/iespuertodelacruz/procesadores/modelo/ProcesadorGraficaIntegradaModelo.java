package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorGraficaIntegradaModelo {

    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "procesador_grafica_integrada";
    private static final String CLAVE_PRIMARIA = "id_procesador";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public ProcesadorGraficaIntegradaModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una procesadorGraficaIntegrada
     * 
     * @param procesadorGraficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        String sql = "INSERT INTO procesador_grafica_integrada (id_procesador, id_grafica_integrada) " + SQL_VALUES
        + procesadorGraficaIntegrada.getIdProcesador() + SQL_COMA
        + procesadorGraficaIntegrada.getIdGraficaIntegrada() + SQL_FIN_PARENTESIS;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una procesadorGraficaIntegrada
     * 
     * @param procesadorGraficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        String sql = "DELETE FROM procesador_grafica_integrada WHERE id_procesador = '" + procesadorGraficaIntegrada.getIdProcesador() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una procesadorGraficaIntegrada
     * 
     * @param procesadorGraficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        String sql = "UPDATE procesador_grafica_integrada SET id_grafica_integrada = '" + procesadorGraficaIntegrada.getIdGraficaIntegrada()
                + "' WHERE id_procesador = '" + procesadorGraficaIntegrada.getIdProcesador() + "';";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una procesadorGraficaIntegrada en la bbdd
     * 
     * @param clave de la procesadorGraficaIntegrada
     * @return procesadorGraficaIntegrada encontrada
     * @throws PersistenciaException controlada
     */
    public ProcesadorGraficaIntegrada buscar(int clave) throws PersistenciaException {
        ProcesadorGraficaIntegrada procesadorGraficaIntegradaEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<ProcesadorGraficaIntegrada> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            procesadorGraficaIntegradaEncontrada = lista.get(0);
        }
        return procesadorGraficaIntegradaEncontrada;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de procesadorGraficaIntegrada
     * @throws PersistenciaException controlada
     */
    private ArrayList<ProcesadorGraficaIntegrada> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<ProcesadorGraficaIntegrada> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int idProcesador = resultSet.getInt("id_procesador");
                int idGraficaIntegrada = resultSet.getInt("id_grafica_integrada");
                ProcesadorGraficaIntegrada ProcesadorGraficaIntegrada = new ProcesadorGraficaIntegrada(idProcesador, idGraficaIntegrada);
                lista.add(ProcesadorGraficaIntegrada);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a ProcesadorGraficaIntegrada", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }

    /**
     * Funcion encargada de buscar todas los procesadorGraficaIntegrada de la bbdd
     * 
     * @return arraylist de procesadorGraficaIntegrada
     * @throws PersistenciaException controlada
     */
    public ArrayList<ProcesadorGraficaIntegrada> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<ProcesadorGraficaIntegrada> lista = new ArrayList<>();
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
