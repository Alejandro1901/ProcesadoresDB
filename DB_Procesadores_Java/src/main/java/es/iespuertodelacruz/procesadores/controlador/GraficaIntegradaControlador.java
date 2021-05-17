package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.GraficaIntegrada;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.modelo.GraficaIntegradaModelo;

public class GraficaIntegradaControlador {

 /**
 * Controlador de la clase GraficaIntegradaDBControlador
 */

private static final String LA_GRAFICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
GraficaIntegradaModelo graficaIntegradaModelo;

public GraficaIntegradaControlador() {
   graficaIntegradaModelo = new GraficaIntegradaModelo();
   }
   /**
    * 
    * @param graficaIntegrada a validar
    * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
    */
   public void validarGraficaIntegrada(GraficaIntegrada graficaIntegrada) throws ControladoresDBException {
    String mensaje = "";
    
    if (graficaIntegrada == null) {
        mensaje = "Se esta validando un objeto nulo de GraficaIntegrada";
        throw new ControladoresDBException(mensaje);
        }

    if (graficaIntegrada.getId() < 0) {
        mensaje = "El ID del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getNombreGrafica() == null || graficaIntegrada.getNombreGrafica().isEmpty()) {
        mensaje = "El nombregrafica de la GraficaIntegrada no puede tener valores nulos y tiene que existir al menos un dato, ";
        } 

    if (graficaIntegrada.getFrecuenciaBasica() < 0) {
        mensaje = "El frecuenciabasica del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getFrecuenciaMaxima() < 0) {
        mensaje = "El frecuenciamaxima del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getMemoriaMaxima() < 0) {
        mensaje = "El MemoriaMaxima del GraficaIntegrada no puede ser cero o menor que el, ";
        }

    if (graficaIntegrada.getResolucion() == null || graficaIntegrada.getResolucion().isEmpty()) {
        mensaje = "El Resolucion de la GraficaIntegrada no puede tener valores nulos y tiene que existir al menos un dato, ";
        }

    if (!mensaje.isEmpty()) {
        throw new ControladoresDBException(mensaje);
        }
   }
} 

   