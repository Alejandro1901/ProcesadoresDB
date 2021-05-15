package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorGraficaIntegradaModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public ProcesadorGraficaIntegradaModelo(MySqlBbdd persistencia) {
        this.persistencia = persistencia;
    }

    /**
     * Metodo que inserta una fila en procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        persistencia.insertar(procesadorGraficaIntegrada);
    }

    /**
     * Metodo que elimina una fila en procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        persistencia.eliminar(procesadorGraficaIntegrada);
    }

    /**
     * Metodo que modifica una fila en procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        persistencia.modificar(procesadorGraficaIntegrada);
    }

    /**
     * Funcion que obtiene una fila de la tabla procesador_grafica_integrada
     * 
     * @param idProcesador de la fila a obtener
     * @return la fila si existe
     * @throws PersistenciaException controlada
     */
    public ProcesadorGraficaIntegrada obtenerProcesadorGraficaIntegrada(int idProcesador) throws PersistenciaException {
        return persistencia.obtenerProcesadorGraficaIntegrada(idProcesador);
    }

    /**
     * Funcion que obtiene la lista de filas en procesador_grafica_integrada
     * 
     * @return la lista de filas
     * @throws PersistenciaException controlada
     */
    public ArrayList<ProcesadorGraficaIntegrada> obtenerListaProcesadorGraficaIntegrada() throws PersistenciaException {
        return persistencia.obtenerListadoProcesadorGraficaIntegrada();
    }
}
