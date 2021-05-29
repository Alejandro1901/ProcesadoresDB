package es.iespuertodelacruz.procesadores.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class GraficaIntegrada {

    private static final String DELIMITADOR = "'";

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
 * Constructor con to string
 * @param cadena
 */
    public GraficaIntegrada(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.id = Integer.parseInt((String) elementos.get(0));
        this.nombreGrafica = (String) elementos.get(1);
        this.frecuenciaBasica = Integer.parseInt((String) elementos.get(2));
        this.frecuenciaMaxima = Integer.parseInt((String) elementos.get(3));
        this.memoriaMaxima = Integer.parseInt((String) elementos.get(4));
        this.resolucion = (String) elementos.get(5);
        
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

    @Override
    public String toString() {
        return getId() + DELIMITADOR +
            getNombreGrafica() + DELIMITADOR +
            getFrecuenciaBasica() + DELIMITADOR +
            getFrecuenciaMaxima() + DELIMITADOR +
            getMemoriaMaxima() + DELIMITADOR +
            getResolucion(); 
    }  

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GraficaIntegrada)) {
            return false;
        }
        GraficaIntegrada graficaIntegrada = (GraficaIntegrada) o;
        return id == graficaIntegrada.id && Objects.equals(nombreGrafica, graficaIntegrada.nombreGrafica) && frecuenciaBasica == graficaIntegrada.frecuenciaBasica && frecuenciaMaxima == graficaIntegrada.frecuenciaMaxima && memoriaMaxima == graficaIntegrada.memoriaMaxima && Objects.equals(resolucion, graficaIntegrada.resolucion);
    }

   

}
