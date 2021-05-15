package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.PlacaBase;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class PlacaBaseModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public PlacaBaseModelo(MySqlBbdd persistencia) {
        this.persistencia = persistencia;
    }

    /**
     * Metodo que inserta una placa base
     * 
     * @param placaBase a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(PlacaBase placaBase) throws PersistenciaException {
        persistencia.insertar(placaBase);
    }

    /**
     * Metodo que elimina una placa base
     * 
     * @param placaBase a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(PlacaBase placaBase) throws PersistenciaException {
        persistencia.eliminar(placaBase);
    }

    /**
     * Metodo que modifica una placa base
     * 
     * @param placaBase a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(PlacaBase placaBase) throws PersistenciaException {
        persistencia.modificar(placaBase);
    }

    /**
     * Funcion que obtiene una placa base segun su id
     * 
     * @param idPlacaBase de la placa base a obtener
     * @return la palca base si existe
     * @throws PersistenciaException controlada
     */
    public PlacaBase obtenerPlacaBase(int idPlacaBase) throws PersistenciaException {
        return persistencia.obtenerPlacaBase(idPlacaBase);
    }

    /**
     * Funcion que obtiene la lista de placas base almacenadas
     * 
     * @return la lista de placas base
     * @throws PersistenciaException controlada
     */
    public ArrayList<PlacaBase> obtenerListaPlacaBase() throws PersistenciaException {
        return persistencia.obtenerListadoPlacaBase();
    }
}
