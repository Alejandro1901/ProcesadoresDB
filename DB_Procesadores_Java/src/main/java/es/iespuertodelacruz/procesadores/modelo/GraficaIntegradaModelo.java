package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaModelo {

    private static final String PUNTO_Y_COMA = ";";
    private static final int CERO = 0;
    private static final String STRING_VACIO = "";
    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "grafica_integrada";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public GraficaIntegradaModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una graficaIntegrada
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
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una graficaIntegrada
     * 
     * @param graficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        String sql = "DELETE FROM grafica_integrada WHERE id = '" + graficaIntegrada.getId() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una graficaIntegrada
     * 
     * @param graficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        String sql = "UPDATE grafica_integrada SET"
        + " nombre_grafica = '" + graficaIntegrada.getNombreGrafica() 
        + "', frec_basica = '" + graficaIntegrada.getFrecuenciaBasica() 
        + "', frec_max = '" + graficaIntegrada.getFrecuenciaMaxima() 
        + "', memoria_max = '" + graficaIntegrada.getMemoriaMaxima() 
        + "', resolucion = '" + graficaIntegrada.getResolucion() 
        + "' WHERE id = '" + graficaIntegrada.getId() + "';";
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una graficaIntegrada en la bbdd
     * 
     * @param clave de la graficaIntegrada
     * @return graficaIntegrada encontrada
     * @throws PersistenciaException controlada
     */
    public GraficaIntegrada buscar(int clave) throws PersistenciaException {
        GraficaIntegrada graficaIntegradaEncontrada = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<GraficaIntegrada> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            graficaIntegradaEncontrada = lista.get(0);
        }
        return graficaIntegradaEncontrada;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de graficaIntegrada
     * @throws PersistenciaException controlada
     */
    private ArrayList<GraficaIntegrada> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<GraficaIntegrada> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombreGrafica = resultSet.getString("nombre_grafica");
                float frecuenciaBasica = resultSet.getFloat("frec_basica");
                float frecuenciaMaxima = resultSet.getFloat("frec_max");
                int memoriaMaxima = resultSet.getInt("memoria_max");
                String resolucion = resultSet.getString("resolucion");
                GraficaIntegrada GraficaIntegrada = new GraficaIntegrada(id, nombreGrafica, frecuenciaBasica, frecuenciaMaxima, memoriaMaxima, resolucion);
                lista.add(GraficaIntegrada);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a GraficaIntegrada", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }


    /**
     * Funcion encargada de buscar todas los graficaIntegrada de la bbdd
     * 
     * @return arraylist de graficaIntegrada
     * @throws PersistenciaException controlada
     */
    public ArrayList<GraficaIntegrada> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<GraficaIntegrada> lista = new ArrayList<>();
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