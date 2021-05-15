package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.excepcion.ControladorDBException;
import es.iespuertodelacruz.procesadores.excepcion.PercistenciaException;
import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.modelo.FabricanteModelo;

public class FabricanteDBControlador {

 /**
 * Controlador de la clase ProcesadoresDBControlador
 */

private static final String EL_FABRICANTE_QUE_SE_INDICA_NO_EXISTE = "El fabricante que se indica NO existe en nuestra base de datos";
FabricanteModelo fabricanteModelo;

public FabricanteDBControlador() {
   fabricanteModelo = new FabricanteModelo();
   
}

/**
 * 
 * @param fabricante a validar
 * @throws ControladoresDBException con el mensaje descriptivo de lo que sucede
 */

public void validarFabricante(Fabricante fabricante) throws ControladoresDBException {
    String mensaje = "";

if (fabricante == null) {
    mensaje = "Se esta validando un objeto nulo de Procesadores";
    throw new ControladoresDBException(mensaje);
    }
    
if (fabricante.getCodigo() == null || fabricante.getCodigoFabricante().isEmpty()) {
    mensaje = "El Codigo del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }
     
if (fabricante.getCodigoPostal() == null || fabricante.getCodigoPostal().isEmpty()) {
    mensaje = "El CodigoPostal del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }

if (fabricante.getNombre() == null || fabricante.getNombre().isEmpty()) {
    mensaje = "El nombre del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }

if (fabricante.getNumero() < 0) {
    mensaje = "El numero del fabricante no puede ser cero o menor que el, ";
    }

if (fabricante.getPais() == null || fabricante.getCodigoPais().isEmpty()) {
    mensaje = "El pais del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }  

if (fabricante.getCalle() == null || fabricante.getCalle().isEmpty()) {
    mensaje = "La calle del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }

if (fabricante.getTelefono() == null || fabricante.getTelefono().isEmpty()) {
    mensaje = "El telefono del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }
    
if (fabricante.getCorreo() == null || fabricante.getCorreo().isEmpty()) {
    mensaje = "El correo del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }

if (fabricante.getWeb() == null || fabricante.getWeb().isEmpty()) {
    mensaje = "La web del fabricante no puede tener valores nulos y tiene que existir al menos un dato, ";
    }   

if (!mensaje.isEmpty()) {
    throw new ControladoresDBException(mensaje);
    }
  }
}