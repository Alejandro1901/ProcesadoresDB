package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.ProcesadorGraficaIntegrada;
import es.iespuertodelacruz.procesadores.modelo.ProcesadorGraficaIntegradaModelo;

public class GraficaIntegradaDBControlador {

 /**
 * Controlador de la clase ProcesadorGraficaIntegrada
 */

private static final String LA_GAFRICA_INTEGRADA_QUE_SE_INDICA_NO_EXISTE = "La grafica integrada que se indica NO existe en nuestra base de datos";
ProcesadorGraficaIntegradaModelo procesadorGraficaIntegradaModelo;

public GraficaIntegradaDBControlador() {
   procesadorGraficaIntegradaModelo = new ProcesadorGraficaIntegradaModelo();
   }

   
}
   