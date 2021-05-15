package es.iespuertodelacruz.procesadores.modelo;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public GraficaIntegradaModelo(MySqlBbdd persistencia) {
        this.persistencia = persistencia;
    }

    /**
     * Metodo que inserta una grafica integrada
     * 
     * @param graficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        persistencia.insertar(graficaIntegrada);
    }

    /**
     * Metodo que elimina una grafica integrada
     * 
     * @param graficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        persistencia.eliminar(graficaIntegrada);
    }

    /**
     * Metodo que modifica una grafica integrada
     * 
     * @param graficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(GraficaIntegrada graficaIntegrada) throws PersistenciaException {
        persistencia.modificar(graficaIntegrada);
    }
}
