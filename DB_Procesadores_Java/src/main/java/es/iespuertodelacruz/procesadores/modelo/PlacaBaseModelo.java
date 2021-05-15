package es.iespuertodelacruz.procesadores.modelo;

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
     * 
     * 
     * @param placaBase
     * @throws PersistenciaException
     */
    public void insertar(PlacaBase placaBase) throws PersistenciaException {
        persistencia.insertar(placaBase);
    }
}
