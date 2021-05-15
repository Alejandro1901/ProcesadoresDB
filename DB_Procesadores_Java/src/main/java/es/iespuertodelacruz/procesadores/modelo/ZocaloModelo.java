package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Zocalo;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ZocaloModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public ZocaloModelo(MySqlBbdd persistencia) {
        this.persistencia = persistencia;
    }
    
    /**
     * Metodo que inserta un zocalo
     * 
     * @param zocalo a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Zocalo zocalo) throws PersistenciaException {
        persistencia.insertar(zocalo);
    }

    /**
     * Metodo que elimina un zocalo
     * 
     * @param zocalo a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Zocalo zocalo) throws PersistenciaException {
        persistencia.eliminar(zocalo);
    }

    /**
     * Metodo que modifica un zocalo
     * 
     * @param zocalo a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Zocalo zocalo) throws PersistenciaException {
        persistencia.modificar(zocalo);
    }

    /**
     * Funcion que obtiene un zocalo segun su id
     * 
     * @param idZocalo del zocalo a obtener
     * @return el zocalo si existe
     * @throws PersistenciaException controlada
     */
    public Zocalo obtenerZocalo(int idZocalo) throws PersistenciaException {
        return persistencia.obtenerZocalo(idZocalo);
    }

    /**
     * Funcion que obtiene la lista de zocalos almacenados
     * 
     * @return la lista de zocalos
     * @throws PersistenciaException controlada
     */
    public ArrayList<Zocalo> obtenerListaZocalo() throws PersistenciaException {
        return persistencia.obtenerListadoZocalo();
    }
}
