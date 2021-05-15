package es.iespuertodelacruz.procesadores.modelo;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ArquitecturaModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public ArquitecturaModelo(MySqlBbdd persistencia) {
        this.persistencia = persistencia;
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

    //Falta obtener arquitectura y obtener lsita arquitectura
}
