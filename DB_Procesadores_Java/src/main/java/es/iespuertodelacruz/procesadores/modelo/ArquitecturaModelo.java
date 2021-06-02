package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ArquitecturaModelo {

    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "arquitectura";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException
     */
    public ArquitecturaModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una arquitectura
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
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una arquitectura
     * 
     * @param arquitectura a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Arquitectura arquitectura) throws PersistenciaException {
        String sql = "DELETE FROM arquitectura WHERE id = '" + arquitectura.getId() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una arquitectura
     * 
     * @param arquitectura a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Arquitectura arquitectura) throws PersistenciaException {
        String sql = "UPDATE arquitectura SET"
        + " version_arquitectura = '" + arquitectura.getVersionArquitectura() 
        + "', disenio = '" + arquitectura.getDisenio() 
        + "', tecnologia = '" + arquitectura.getTecnologia() 
        + "', estandar = '" + arquitectura.getEstandar() 
        + "' WHERE id = '" + arquitectura.getId() + "';";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una arquitectura en la bbdd
     * 
     * @param clave de la arquitectura
     * @return arquitectura encontrada
     * @throws PersistenciaException controlada
     */
    public Arquitectura buscar(int clave) throws PersistenciaException {
        Arquitectura arquitecturaEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<Arquitectura> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            arquitecturaEncontrada = lista.get(0);
        }
        return arquitecturaEncontrada;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de arquitectura
     * @throws PersistenciaException controlada
     */
    private ArrayList<Arquitectura> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<Arquitectura> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String versionArquitectura = resultSet.getString("version_arquitectura");
                String disenio = resultSet.getString("disenio");
                String tecnologia = resultSet.getString("tecnologia");
                String estandar = resultSet.getString("estandar");
                Arquitectura Arquitectura = new Arquitectura(id, versionArquitectura, disenio, tecnologia, estandar);
                lista.add(Arquitectura);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a Arquitectura", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }


    /**
     * Funcion encargada de buscar todas las arquitecturas en la bbdd
     * 
     * @return arraylist de arquitectura
     * @throws PersistenciaException controlada
     */
    public ArrayList<Arquitectura> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<Arquitectura> lista = new ArrayList<>();
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
