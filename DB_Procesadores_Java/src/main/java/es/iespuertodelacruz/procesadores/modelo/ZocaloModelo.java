package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Zocalo;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ZocaloModelo {

    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "zocalo";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException
     */
    public ZocaloModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }
    
    /**
     * Metodo que inserta una zocalo
     * 
     * @param zocalo a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Zocalo zocalo) throws PersistenciaException {
        String sql = "INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) " + SQL_VALUES 
        + zocalo.getId() + SQL_COMA 
        + zocalo.getTipo() + SQL_COMA 
        + zocalo.getTecnologia() + SQL_COMA
        + zocalo.getFechaLanzamiento() + SQL_FIN_PARENTESIS;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una zocalo
     * 
     * @param zocalo a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Zocalo zocalo) throws PersistenciaException {
        String sql = "DELETE FROM zocalo WHERE id = '" + zocalo.getId() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una zocalo
     * 
     * @param zocalo a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Zocalo zocalo) throws PersistenciaException {
        String sql = "UPDATE zocalo SET"
                + " tipo = '" + zocalo.getTipo()
                + "', tecnologia = '" + zocalo.getTecnologia()
                + "', fecha_lanzamiento = '" + zocalo.getFechaLanzamiento()
                + "' WHERE id = '" + zocalo.getId() + "';";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una zocalo en la bbdd
     * 
     * @param clave de la zocalo
     * @return zocalo encontrada
     * @throws PersistenciaException controlada
     */
    public Zocalo buscar(int clave) throws PersistenciaException {
        Zocalo procesadorEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<Zocalo> lista = new ArrayList<>();
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
     * @return lista de zocalo
     * @throws PersistenciaException controlada
     */
    private ArrayList<Zocalo> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<Zocalo> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                String tecnologia = resultSet.getString("tecnologia");
                String fechaLanzamiento = resultSet.getString("fecha_lanzamiento");
                Zocalo zocalo = new Zocalo(id, tipo, tecnologia, fechaLanzamiento);
                lista.add(zocalo);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a Zocalo", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }


    /**
     * Funcion encargada de buscar todas los zocalo de la bbdd
     * 
     * @return arraylist de zocalo
     * @throws PersistenciaException controlada
     */
    public ArrayList<Zocalo> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<Zocalo> lista = new ArrayList<>();
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
