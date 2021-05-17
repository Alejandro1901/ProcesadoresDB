package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class GraficaIntegradaModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public GraficaIntegradaModelo() {
        persistencia = new MySqlBbdd("com.mysql.jdbc.Driver","jdbc:mysql://localhost/text","admin", "1234");
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

    /**
     * Funcion que obtiene una grafica integrada segun su id
     * 
     * @param idGraficaIntegrada de la grafica integrada a obtener
     * @return la grafica integrada si existe
     * @throws PersistenciaException controlada
     */
    public GraficaIntegrada obtenerGraficaIntegrada(int idGraficaIntegrada) throws PersistenciaException {
        return persistencia.obtenerGraficaIntegrada(idGraficaIntegrada);
    }

    /**
     * Funcion que obtiene la lista de graficas integradas almacenadas
     * 
     * @return la lista de graficas integradas
     * @throws PersistenciaException controlada
     */
    public ArrayList<GraficaIntegrada> obtenerListaGraficaIntegrada() throws PersistenciaException {
        return persistencia.obtenerListadoGraficaIntegrada();
    }
}