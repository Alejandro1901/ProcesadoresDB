package es.iespuertodelacruz.procesadores.fichero.*;

import es.iespuertodelacruz.procesadores.excepcion.FicheroException;;

import java.io.*;
import java.util.Scanner;

public class FicheroProcesador {

    private static final String RETORNO_CARRO = "\n";

    /**
     * Funcion encargada de leer un fichero
     * 
     * @param nombre nombre del fichero a leer
     * @throws FicheroException Error controlado en la lectura del fichero
     */
    public String leer(String nombre) throws FicheroException {
        StringBuilder informacion = null;
        File fichero = new File(nombre);
        if (!validarFicheroProcesador(fichero)) {
            throw new FicheroException("El fichero a leer no existe");
        }
    }
}