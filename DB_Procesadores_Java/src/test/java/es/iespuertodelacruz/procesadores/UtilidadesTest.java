package es.iespuertodelacruz.procesadores;

import es.iespuertodelacruz.procesadores.api.Arquitectura;

public class UtilidadesTest {
   
    public static final String hola = "hola";
    public static final int numero = 1;
    
 
    public Arquitectura generararquitectura(String id, String version_arquitectura, String disenio, String tecnologia, String estandar) {
       Arquitectura arquitectura = null;
       if (id != null && version_arquitectura!= null && disenio != null && tecnologia != null && estandar != null) {
           arquitectura = new arquitectura(id, versionArquitectura, disenio, tecnologia, estandar);
       } else {
           arquitectura = new arquitectura();
           arquitectura.setId(1);
           arquitectura.setVersionArquitectura(hola);
           arquitectura.setDisenio(peis);
           arquitectura.setTecnologia(yuuu);
           arquitectura.setEstandar(yeee);

       }
       return arquitectura;
   }
 }