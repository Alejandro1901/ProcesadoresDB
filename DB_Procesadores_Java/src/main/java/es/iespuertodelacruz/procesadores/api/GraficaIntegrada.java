package es.iespuertodelacruz.procesadores.api;

public class GraficaIntegrada {
    int id;
    String nombreGrafica;
    float frecuenciaBasica;
    float frecuenciaMaxima;
    float memoriaMaxima;
    String resolucion;

    /**
     * Constructor con todos los parametros
     * 
     * @param id de al grafica
     * @param nombreGrafica de la grafica 
     * @param frecuenciaBasica a la que va la grafica 
     * @param frecuenciaMaxima a la que va la grafica 
     * @param memoriaMaxima de la grafica
     * @param resolucion maxima permitida por la grafica
     */
    public GraficaIntegrada(int id, String nombreGrafica, float frecuenciaBasica, float frecuenciaMaxima, float memoriaMaxima, String resolucion) {
        this.id = id;
        this.nombreGrafica = nombreGrafica;
        this.frecuenciaBasica = frecuenciaBasica;
        this.frecuenciaMaxima = frecuenciaMaxima;
        this.memoriaMaxima = memoriaMaxima;
        this.resolucion = resolucion;
    }

    /**
     * Constructor vacio
     */
    public GraficaIntegrada() {
    }

    /**
     * Creacion de getter and setters
     */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreGrafica() {
        return this.nombreGrafica;
    }

    public void setNombreGrafica(String nombreGrafica) {
        this.nombreGrafica = nombreGrafica;
    }

    public float getFrecuenciaBasica() {
        return this.frecuenciaBasica;
    }

    public void setFrecuenciaBasica(float frecuenciaBasica) {
        this.frecuenciaBasica = frecuenciaBasica;
    }

    public float getFrecuenciaMaxima() {
        return this.frecuenciaMaxima;
    }

    public void setFrecuenciaMaxima(float frecuenciaMaxima) {
        this.frecuenciaMaxima = frecuenciaMaxima;
    }

    public float getMemoriaMaxima() {
        return this.memoriaMaxima;
    }

    public void setMemoriaMaxima(float memoriaMaxima) {
        this.memoriaMaxima = memoriaMaxima;
    }

    public String getResolucion() {
        return this.resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
}
