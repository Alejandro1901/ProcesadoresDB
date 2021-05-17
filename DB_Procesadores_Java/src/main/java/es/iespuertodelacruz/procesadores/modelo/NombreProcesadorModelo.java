package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.NombreProcesador;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class NombreProcesadorModelo {
    
    MySqlBbdd persistencia;

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
     */
    public NombreProcesadorModelo() {
        persistencia = new MySqlBbdd("com.mysql.jdbc.Driver","jdbc:mysql://localhost/text","admin", "1234");
    }

    /**
     * Metodo que inserta una fila en la tabla nombre_procesador
     * 
     * @param nombreProcesador a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(NombreProcesador nombreProcesador) throws PersistenciaException {
        persistencia.insertar(nombreProcesador);
    }

    /**
     * Metodo que elimina una fila en la tabla nombre_procesador
     * 
     * @param nombreProcesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(NombreProcesador nombreProcesador) throws PersistenciaException {
        persistencia.eliminar(nombreProcesador);
    }

    /**
     * Metodo que modifica una fila en la tabla nombre_procesador
     * 
     * @param nombreProcesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(NombreProcesador nombreProcesador) throws PersistenciaException {
        persistencia.modificar(nombreProcesador);
    }

    /**
     * Funcion que obtiene una fila de la tabla nombre_procesador segun el modelo del procesador
     * 
     * @param modeloProcesador a de la fial a obtener
     * @return la fila si existe
     * @throws PersistenciaException controlada
     */
    public NombreProcesador obtenerNombreProcesador(String modeloProcesador) throws PersistenciaException {
        return persistencia.obtenerNombreProcesador(modeloProcesador);
    }

    /**
     * Funcion que obtiene la lista de filas en nombre_procesador
     * 
     * @return la lista de filas
     * @throws PersistenciaException controlada
     */
    public ArrayList<NombreProcesador> obtenerListaNombreProcesador() throws PersistenciaException {
        return persistencia.obtenerListadoNombreProcesador();
    }
}
