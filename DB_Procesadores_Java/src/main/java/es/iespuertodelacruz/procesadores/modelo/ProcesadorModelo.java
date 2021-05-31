package es.iespuertodelacruz.procesadores.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Procesador;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadorModelo {
    
    MySqlBbdd persistencia;

    private static final String TABLA = "procesador";
    private static final String CLAVE_PRIMARIA = "id";

    /**
     * Constructor con la persistencia
     * 
     * @param persistencia elegida
<<<<<<< HEAD
     * @throws PersistenciaException
=======
     * @throws PersistenciaException controlada
>>>>>>> 9ce3322a96adfc6872a460a095ea94933654e122
     */
    public ProcesadorModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd("com.mysql.jdbc.Driver","jdbc:mysql://localhost/text","admin", "1234");
    }

    /**
     * Metodo que inserta un procesador
     * 
     * @param procesador a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Procesador procesador) throws PersistenciaException {
        persistencia.insertar(procesador);
    }
    
    /**
     * Metodo que elimina un procesador
     * 
     * @param procesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Procesador procesador) throws PersistenciaException {
        persistencia.eliminar(procesador);
    }

    /**
     * Metodo que modifica un procesador
     * 
     * @param procesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Procesador procesador) throws PersistenciaException {
        persistencia.modificar(procesador);
    }

    /**
     * Funcion que obtiene un procesador segun su id
     * 
     * @param idProcesador del procesador a obtener
     * @return el procesador si existe
     * @throws PersistenciaException controlada
     */
    public Procesador obtenerProcesador(int idProcesador) throws PersistenciaException {
        return persistencia.obtenerProcesador(idProcesador);
    }

    /**
     * Funcion que obtiene la lista de procesadores almacenados
     * 
     * @return la lista de procesadores
     * @throws PersistenciaException controlada
     */
    public ArrayList<Procesador> obtenerListaProcesador() throws PersistenciaException {
        return persistencia.obtenerListadoProcesador();
    }
}
