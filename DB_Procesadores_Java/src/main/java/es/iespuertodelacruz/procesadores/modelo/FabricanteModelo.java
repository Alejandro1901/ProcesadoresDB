package es.iespuertodelacruz.procesadores.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class FabricanteModelo {

    private static final String PUNTO_Y_COMA = ";";
    private static final int CERO = 0;
    private static final String STRING_VACIO = "";
    private static final String SQL_FIN_COMILLA_SIMPLE = "';";
    private static final String SQL_FIN_PARENTESIS = "');";
    private static final String SQL_VALUES = "VALUES ('";
    private static final String SQL_COMA = "', '";
    
    MySqlBbdd persistencia;

    private static final String TABLA = "fabricante";
    private static final String CLAVE_PRIMARIA = "codigo";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public FabricanteModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(TABLA, CLAVE_PRIMARIA, null, null);
    }

    /**
     * Metodo que inserta una fabricante
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
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que elimina una fabricante
     * 
     * @param fabricante a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Fabricante fabricante) throws PersistenciaException {
        String sql = "DELETE FROM fabricante WHERE codigo = '" + fabricante.getCodigo() + SQL_FIN_COMILLA_SIMPLE;
        persistencia.actualizar(sql);
    }

    /**
     * Metodo que modifica una fabricante
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
        persistencia.actualizar(sql);
    }

    /**
     * Funcion que busca una fabricante en la bbdd
     * 
     * @param clave de la fabricante
     * @return fabricante encontrada
     * @throws PersistenciaException controlada
     */
    public Fabricante buscar(String clave) throws PersistenciaException {
        Fabricante fabricanteEncontrado = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE " + CLAVE_PRIMARIA + "='" + clave + "'";
        ResultSet resultSet;
        ArrayList<Fabricante> lista = new ArrayList<>();
        try {
            resultSet = persistencia.buscarElementos(sql);
            lista = buscar(resultSet);
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Se ha producido un error realizando la consulta", e);
        } finally {
            persistencia.closeConecction(persistencia.getConnection(), null, null);
        }

        if (!lista.isEmpty()) {
            fabricanteEncontrado = lista.get(0);
        }
        return fabricanteEncontrado;
    }

    /**
     * Funcion encargada de transformar un ResultSet en una lista de resultados
     * 
     * @param resultSet de entrada
     * @return lista de fabricante
     * @throws PersistenciaException controlada
     */
    private ArrayList<Fabricante> buscar(ResultSet resultSet) throws PersistenciaException {
        ArrayList<Fabricante> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String codigoPostal = resultSet.getString("codigo_postal");
                String nombre = resultSet.getString("nombre");
                int numero = resultSet.getInt("numero");
                String pais = resultSet.getString("pais");
                String calle = resultSet.getString("calle");
                String telefono = resultSet.getString("telefono");
                String correo = resultSet.getString("correo");
                String web = resultSet.getString("web");
                Fabricante Fabricante = new Fabricante(codigo, codigoPostal, nombre, numero, pais, calle, telefono, correo, web);
                lista.add(Fabricante);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Se ha producido un error realizando la transformacion a Fabricante", e);
        } finally {
            persistencia.closeConecction(null, null, resultSet);
        }
        return lista;
    }


    /**
     * Funcion encargada de buscar todas los fabricantes de la bbdd
     * 
     * @return arraylist de fabricante
     * @throws PersistenciaException controlada
     */
    public ArrayList<Fabricante> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLA;
        ResultSet resultSet;
        ArrayList<Fabricante> lista = new ArrayList<>();
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