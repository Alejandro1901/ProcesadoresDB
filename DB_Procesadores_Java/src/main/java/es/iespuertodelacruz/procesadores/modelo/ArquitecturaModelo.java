package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ArquitecturaModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     * @throws PersistenciaException
     */
    public ArquitecturaModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(null, null);
    }



    /**
     * Metodo que inserta una arquitectura
     * 
     * @param arquitectura a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Arquitectura arquitectura) throws PersistenciaException {
        persistencia.insertar(arquitectura);
    }

    /**
     * Metodo que elimina una arquitectura
     * 
     * @param arquitectura a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Arquitectura arquitectura) throws PersistenciaException {
        persistencia.eliminar(arquitectura);
    }

    /**
     * Metodo que modifica una arquitectura
     * 
     * @param arquitectura a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Arquitectura arquitectura) throws PersistenciaException {
        persistencia.modificar(arquitectura);
    }

    /**
     * Funcion que obtiene una arquitectura segun su id
     * 
     * @param idArquitectura de la arquitectura a obtener
     * @return la arquitectura si existe
     * @throws PersistenciaException controlada
     */
    public Arquitectura obtenerArquitectura(int idArquitectura) throws PersistenciaException {
        return persistencia.obtenerArquitectura(idArquitectura);
    }

    /**
     * Funcion que obtiene la lista de arquitecturas almacenadas
     * 
     * @return la lista de arquitecturas
     * @throws PersistenciaException controlada
     */
    public ArrayList<Arquitectura> obtenerListaArquitectura() throws PersistenciaException {
        return persistencia.obtenerListadoArquitectura();
    }
}
