package es.iespuertodelacruz.procesadores.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Arquitectura {

    private static final String DELIMITADOR = "'";

    int id;
    String versionArquitectura;
    String disenio;
    String tecnologia;
    String estandar;

    /**
     * Constructor con todos los parametros
     * @param id de la arquitectura 
     * @param versionArquitectura de la arquitectura 
     * @param disenio es el nombre del tipo de arquitectura 
     * @param tecnologia de la arquitectura (Solo ARM)
     * @param estandar de la arquietctura (Solo x86-64)
     */
   
    /**
     * Creación de un constructor con todos los atributos de las tablas
     */
   
     public Arquitectura(int id, String versionArquitectura, String disenio, 
        String tecnologia, String estandar) {
        this.id = id;
        this.versionArquitectura = versionArquitectura;
        this.disenio = disenio;
        this.tecnologia = tecnologia;
        this.estandar = estandar;
    }

    public Arquitectura(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.id = Integer.parseInt((String) elementos.get(0));
        this.versionArquitectura = (String) elementos.get(1);
        this.disenio = (String) elementos.get(2);
        this.tecnologia = (String) elementos.get(3);
        this.estandar = (String) elementos.get(4);
    }

    /**
     * Constructor vacio
     */
    
     public Arquitectura() {
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

    public String getVersionArquitectura() {
        return this.versionArquitectura;
    }

    public void setVersionArquitectura(String versionArquitectura) {
        this.versionArquitectura = versionArquitectura;
    }

    public String getDisenio() {
        return this.disenio;
    }

    public void setDisenio(String disenio) {
        this.disenio = disenio;
    }

    public String getTecnologia() {
        return this.tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getEstandar() {
        return this.estandar;
    }

    public void setEstandar(String estandar) {
        this.estandar = estandar;
    }

    @Override
    public String toString() {
        return getId() + DELIMITADOR +
            getVersionArquitectura() + DELIMITADOR +
            getDisenio() + DELIMITADOR +
            getTecnologia() + DELIMITADOR +
            getEstandar(); 
}
    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Arquitectura)) {
            return false;
        }
        Arquitectura arquitectura = (Arquitectura) o;
        return id == arquitectura.id && Objects.equals(versionArquitectura, arquitectura.versionArquitectura) && Objects.equals(disenio, arquitectura.disenio) && Objects.equals(tecnologia, arquitectura.tecnologia) && Objects.equals(estandar, arquitectura.estandar);
    }
}
