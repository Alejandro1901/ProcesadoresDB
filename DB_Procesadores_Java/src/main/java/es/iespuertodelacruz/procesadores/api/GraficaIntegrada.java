package es.iespuertodelacruz.procesadores.api;

public class GraficaIntegrada {
    int id;
    String nombreGrafica;
    float frecuenciaBasica;
    float frecuenciaMaxima;
    float memoriaMaxima;
    String resolucion;

    /**
     * 
     * @param id
     * @param nombreGrafica
     * @param frecuenciaBasica
     * @param frecuenciaMaxima
     * @param memoriaMaxima
     * @param resolucion
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

}
