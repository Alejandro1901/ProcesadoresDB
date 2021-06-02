package es.iespuertodelacruz.procesadores.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Fabricante {

    private static final String DELIMITADOR = "'";

    String codigo;
    String codigoPostal;
    String nombre;
    int numero;
    String pais;
    String calle;
    String telefono;
    String correo;
    String web;

    /**
     * Constructor con todos los parametros
     * 
     * @param codigo       del fabricante
     * @param codigoPostal del fabricante
     * @param nombre       del fabricante
     * @param calle        del fabricante, donde esta situado la fabrica
     * @param numero       de la fabrica
     * @param pais         donde se fabrican los procesadores
     * @param telefono     del fabricante
     * @param correo       del fabricante
     * @param web          del fabricante
     */
    public Fabricante(String codigo, String codigoPostal, String nombre, int numero, String pais, String calle, String telefono, String correo, String web) {
        this.codigo = codigo;
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.numero = numero;
        this.pais = pais;
        this.calle = calle;
        this.telefono = telefono;
        this.correo = correo;
        this.web = web;
    }

    public Fabricante(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.codigo = (String) elementos.get(0);
        this.codigoPostal = (String) elementos.get(1);
        this.nombre = (String) elementos.get(2);
        this.numero = Integer.parseInt((String) elementos.get(3));
        this.pais = (String) elementos.get(4);
        this.calle = (String) elementos.get(5);
        this.telefono = (String) elementos.get(6);
        this.correo = (String) elementos.get(7);
        this.web = (String) elementos.get(8);
    }

    /**
     * Constructor vacio
     */
    public Fabricante() {}

    /**
     * Creacion de getter and setters
     */

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getWeb() {
        return this.web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    
    @Override
    public String toString() {
        return getCodigo() + DELIMITADOR + getCodigoPostal() + DELIMITADOR + getNombre() + DELIMITADOR + getNumero()
                + DELIMITADOR + getPais() + DELIMITADOR + getCalle() + DELIMITADOR + getTelefono() + DELIMITADOR
                + getCorreo() + DELIMITADOR + getWeb();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fabricante)) {
            return false;
        }
        Fabricante fabricante = (Fabricante) o;
        return Objects.equals(codigo, fabricante.codigo) && Objects.equals(codigoPostal, fabricante.codigoPostal) && Objects.equals(nombre, fabricante.nombre) && numero == fabricante.numero && Objects.equals(pais, fabricante.pais) && Objects.equals(calle, fabricante.calle) && Objects.equals(telefono, fabricante.telefono) && Objects.equals(correo, fabricante.correo) && Objects.equals(web, fabricante.web);
    }
}
