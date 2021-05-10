package es.iespuertodelacruz.procesadores.api;

public class Fabricante {
    String codigo;
    int codigoPostal;
    String nombre;
    String calle;
    int numero;
    String pais;
    int telefono;
    String correo;
    String web;

    /**
     * Constructor con todos los parametros
     * 
     * @param codigo
     * @param codigoPostal
     * @param nombre
     * @param calle
     * @param numero
     * @param pais
     * @param telefono
     * @param correo
     * @param web
     */
    public Fabricante(String codigo, int codigoPostal, String nombre, String calle, int numero, String pais, int telefono, String correo, String web) {
        this.codigo = codigo;
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.pais = pais;
        this.telefono = telefono;
        this.correo = correo;
        this.web = web;
    }

    /**
     * Constructor vacio
     */
    public Fabricante() {
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
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

}
