package es.iespuertodelacruz.procesadores.modelo;

import java.net.Socket;

import es.iespuertodelacruz.procesadores.api.*;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;

public class ProcesadoresDBModelo {
    
    MySqlBbdd persistencia;

    public ProcesadoresDBModelo() throws PersistenciaException {
        persistencia = new MySqlBbdd(null, null);
    }

    //Arquitectura metodos

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

    //Fabricante metodos

    /**
     * Metodo que inserta un fabricante
     * 
     * @param fabricante a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Fabricante fabricante) throws PersistenciaException {
        persistencia.insertar(fabricante);
    }

    /**
     * Metodo que elimina un fabricante
     * 
     * @param fabricante a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Fabricante fabricante) throws PersistenciaException {
        persistencia.eliminar(fabricante);
    }

    /**
     * Metodo que modifica un fabricante
     * 
     * @param fabricante a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Fabricante fabricante) throws PersistenciaException {
        persistencia.modificar(fabricante);
    }

    //Grafica integrada metodos

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

    //NombreProcesador metodos

    /**
     * Metodo que inserta un registro en nombre_procesador
     * 
     * @param nombreProcesador a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(NombreProcesador nombreProcesador) throws PersistenciaException {
        persistencia.insertar(nombreProcesador);
    }

    /**
     * Metodo que elimina un registro en nombre_procesador
     * 
     * @param nombreProcesador a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(NombreProcesador nombreProcesador) throws PersistenciaException {
        persistencia.eliminar(nombreProcesador);
    }

    /**
     * Metodo que modifica un registro en nombre_procesador
     * 
     * @param nombreProcesador a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(NombreProcesador nombreProcesador) throws PersistenciaException {
        persistencia.modificar(nombreProcesador);
    }

    //Placa base metodos

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

    //Procesador metodos

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

    //ProcesadorGraficaIntegrada metodos

    /**
     * Metodo que inserta un registro en procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        persistencia.insertar(procesadorGraficaIntegrada);
    }

    /**
     * Metodo que elimina un registro de procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        persistencia.eliminar(procesadorGraficaIntegrada);
    }

    /**
     * Metodo que modifica un registro de procesador_grafica_integrada
     * 
     * @param procesadorGraficaIntegrada a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(ProcesadorGraficaIntegrada procesadorGraficaIntegrada) throws PersistenciaException {
        persistencia.modificar(procesadorGraficaIntegrada);
    }

    //Socket metodos

    /**
     * Metodo que inserta un socket
     * 
     * @param socket a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Zocalo socket) throws PersistenciaException {
        persistencia.insertar(socket);
    }

    /**
     * Metodo que elimina un socket
     * 
     * @param socket a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Zocalo socket) throws PersistenciaException {
        persistencia.eliminar(socket);
    }

    /**
     * Metodo que modifica un socket
     * 
     * @param socket a modificar
     * @throws PersistenciaException controlada
     */
    public void modificar(Zocalo socket) throws PersistenciaException {
        persistencia.modificar(socket);
    }
}
