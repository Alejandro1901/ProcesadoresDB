package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class FabricanteModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException controlada
     */
    public FabricanteModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd("com.mysql.jdbc.Driver","jdbc:mysql://localhost/text","admin", "1234");
    }

    /**
     * Metodo que inserta un fabricante
     * 
     * @param fabricante a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Fabricante fabricante) throws PersistenciaException {
        persistencia.insertar(fabricante);
    }

    /**
     * Metodo que elimina un fabricante
     * 
     * @param fabricante a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Fabricante fabricante) throws PersistenciaException {
        persistencia.eliminar(fabricante);
    }

    /**
     * Metodo que modifica un fabricante
     * 
     * @param fabricante a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Fabricante fabricante) throws PersistenciaException {
        persistencia.modificar(fabricante);
    }

    /**
     * Funcion que obtiene un fabricante segun su codigo
     * 
     * @param codigo del fabricante a obtener
     * @return el fabricante si existe
     * @throws PersistenciaException controlada
     */
    public Fabricante obtenerFabricante(String codigo) throws PersistenciaException {
        return persistencia.obtenerFabricante(codigo);
    }

    /**
     * Funcion que obtiene la lista de fabricantes almacenados
     * 
     * @return la lista de fabricantes
     * @throws PersistenciaException controlada
     */
    public ArrayList<Fabricante> obtenerListaFabricante() throws PersistenciaException {
        return persistencia.obtenerListadoFabricante();
    }
}