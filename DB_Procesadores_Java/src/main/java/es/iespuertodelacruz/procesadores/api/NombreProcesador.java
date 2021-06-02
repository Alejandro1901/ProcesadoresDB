package es.iespuertodelacruz.procesadores.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class NombreProcesador {

    private static final String DELIMITADOR = "'";

    String modeloProcesador;
    String familia;
    int generacion;

    /**
     * Constructor con todos los parametros
     * 
     * @param modeloProcesador del procesador
     * @param familia a la que pertenece
     * @param generacion a la que pertenece
     */
    public NombreProcesador(String modeloProcesador, String familia, int generacion) {
        this.modeloProcesador = modeloProcesador;
        this.familia = familia;
        this.generacion = generacion;
    }

    public NombreProcesador(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.modeloProcesador = (String) elementos.get(0);
        this.familia = (String) elementos.get(1);
        this.generacion = Integer.parseInt((String) elementos.get(2));
    }

    /**
     * Constructor vacio
     */
    public NombreProcesador() {
    }

    /**
     * Creacion de getter and setters
     */

    public String getModeloProcesador() {
        return this.modeloProcesador;
    }

    public void setModeloProcesador(String modeloProcesador) {
        this.modeloProcesador = modeloProcesador;
    }

    public String getFamilia() {
        return this.familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getGeneracion() {
        return this.generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    @Override
    public String toString() {
        return getModeloProcesador() + DELIMITADOR +
            getFamilia() + DELIMITADOR +
            getGeneracion(); 
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NombreProcesador)) {
            return false;
        }
        NombreProcesador nombreProcesador = (NombreProcesador) o;
        return Objects.equals(modeloProcesador, nombreProcesador.modeloProcesador) && Objects.equals(familia, nombreProcesador.familia) && generacion == nombreProcesador.generacion;
    }
}    
