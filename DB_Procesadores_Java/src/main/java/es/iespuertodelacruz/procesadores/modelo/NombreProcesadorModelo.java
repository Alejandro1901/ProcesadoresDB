package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class NombreProcesadorModelo {

    private static final String PUNTO_Y_COMA = ";";
    private static final int CERO = 0;
    private static final String STRING_VACIO = "";
    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "nombre_procesador";
    private static final String CLAVE_PRIMARIA = "modelo_procesador";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public NombreProcesadorModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una nombreProcesador
     * 
     * @param nombreProcesador a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(NombreProcesador nombreProcesador) throws PersistenciaException {
        String sql = "INSERT INTO nombre_procesador (modelo_procesador, familia, generacion) " + SQL_VALUES
        + nombreProcesador.getModeloProcesador() + SQL_COMA 
        + nombreProcesador.getFamilia() + SQL_COMA
        + nombreProcesador.getGeneracion() + SQL_FIN_PARENTESIS;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una nombreProcesador
     * 
     * @param nombreProcesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(NombreProcesador nombreProcesador) throws PersistenciaException {
        String sql = "DELETE FROM nombre_procesador WHERE modelo_procesador = '" + nombreProcesador.getModeloProcesador() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una nombreProcesador
     * 
     * @param nombreProcesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(NombreProcesador nombreProcesador) throws PersistenciaException {
        String sql = "UPDATE nombre_procesador SET"
        + " familia = '" + nombreProcesador.getFamilia() 
        + "', generacion = '" + nombreProcesador.getGeneracion() 
        + "' WHERE modelo_procesador = '" + nombreProcesador.getModeloProcesador() + "';";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una nombreProcesador en la bbdd
     * 
     * @param clave de la nombreProcesador
     * @return nombreProcesador encontrada
     * @throws PersistenciaException controlada
     */
    public NombreProcesador buscar(String clave) throws PersistenciaException {
        NombreProcesador nombreProcesadorEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<NombreProcesador> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            nombreProcesadorEncontrada = lista.get(0);
        }
        return nombreProcesadorEncontrada;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de nombreProcesador
     * @throws PersistenciaException controlada
     */
    private ArrayList<NombreProcesador> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<NombreProcesador> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String modelo = resultSet.getString("modelo_procesador");
                String familia = resultSet.getString("familia");
                int generacion = resultSet.getInt("generacion");
                NombreProcesador NombreProcesador = new NombreProcesador(modelo, familia, generacion);
                lista.add(NombreProcesador);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a NombreProcesador", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }


    /**
     * Funcion encargada de buscar todas los nombreProcesador de la bbdd
     * 
     * @return arraylist de nombreProcesador
     * @throws PersistenciaException controlada
     */
    public ArrayList<NombreProcesador> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<NombreProcesador> lista = new ArrayList<>();
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
