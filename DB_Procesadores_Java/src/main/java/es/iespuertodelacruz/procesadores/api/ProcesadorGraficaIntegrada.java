package es.iespuertodelacruz.procesadores.api;

public class ProcesadorGraficaIntegrada {

    private static final String DELIMITADOR = "'";

    int idProcesador;
    int idGraficaIntegrada;

    /**
     * Cosntructor con todos los parametros
     * 
     * @param idProcesador del procesador
     * @param idGraficaIntegrada de la grafica integrada
     */
    public ProcesadorGraficaIntegrada(int idProcesador, int idGraficaIntegrada) {
        this.idProcesador = idProcesador;
        this.idGraficaIntegrada = idGraficaIntegrada;
    }

    /**
     * Constructor vacio
     */
    public ProcesadorGraficaIntegrada() {
    }

     /**
     * Creacion de getter and setters
     */

    public int getIdProcesador() {
        return this.idProcesador;
    }

    public void setIdProcesador(int idProcesador) {
        this.idProcesador = idProcesador;
    }

    public int getIdGraficaIntegrada() {
        return this.idGraficaIntegrada;
    }

    public void setIdGraficaIntegrada(int idGraficaIntegrada) {
        this.idGraficaIntegrada = idGraficaIntegrada;
    }

    @Override
    public String toString() {
        return getIdProcesador() + DELIMITADOR +
               getIdGraficaIntegrada();
}
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProcesadorGraficaIntegrada)) {
            return false;
        }
        ProcesadorGraficaIntegrada procesadorGraficaIntegrada = (ProcesadorGraficaIntegrada) o;
        return idProcesador == procesadorGraficaIntegrada.idProcesador && idGraficaIntegrada == procesadorGraficaIntegrada.idGraficaIntegrada;
    }


   

    
    

}
