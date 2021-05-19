package es.iespuertodelacruz.procesadores.controlador;

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.modelo.FabricanteModelo;

public class FabricanteControlador {

 /**
 * Controlador de la clase FabricanteDBControlador
 */

private static final String EL_FABRICANTE_QUE_SE_INDICA_NO_EXISTE = "El fabricante que se indica NO existe en nuestra base de datos";
FabricanteModelo fabricanteModelo;

public FabricanteControlador() {
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
    
if (fabricante.getCodigo() == null || fabricante.getCodigo().isEmpty()) {
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

if (fabricante.getPais() == null || fabricante.getPais().isEmpty()) {
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

    /** 
     * Metodo encargado de insertar
     * @param fabricante a insertar
     * @throws ControladoresDBException con un mensaje controlado
     * @throws PersistenciaException
     */

  public void insertar(Fabricante fabricante) throws ControladoresDBException, PersistenciaException {
    validarFabricante(fabricante);
        if (existe(fabricante)) {
           throw new ControladoresDBException("El fabricante que se indica ya existe");
        }
       fabricanteModelo.insertar(fabricante); 
     }  
     
/**
 * Metodo encargado de eliminar
 * @param fabricante a eliminar 
 * @throws ControladoresDBException con un mensaje controlado
 * @throws PersistenciaException
 */

    public void eliminar(Fabricante fabricante) throws ControladoresDBException, PersistenciaException {
   validarFabricante(fabricante);
        if (!existe(fabricante)) {
           throw new ControladoresDBException(EL_FABRICANTE_QUE_SE_INDICA_NO_EXISTE);
        }
        fabricanteModelo.eliminar(fabricante); 
    }
    
/**
 * Metodo encargado de realizar la eliminacion de una arquitectura
 * @param Id del elemento a eliminar
 * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
 * @throws PersistenciaException 
 */   
    public void eliminar(string codigo) throws ControladoresDBException, PersistenciaException {
        Fabricante fabricante;
        fabricante = buscar(id);
        eliminar(fabricante);
     }

     /**
      * Metodo encargado de buscar por la id de la clase
      * @param id para localizar la arquitectura
      * @return fabricante a traves del id de la clase
      * @throws PersistenciaException
      */

    public Fabricante buscar(String codigoFabricante) throws PersistenciaException {
        Fabricante fabricante = null;
        fabricante = fabricanteModelo.obtenerFabricante(codigoFabricante);
        return fabricante;
     }

/**
 * Metodo encargado de realizar la modificacion de un tipo de arquitectura
 * @param fabricante modificar
 * @throws ControladoresDBException controlada en caso de error
 * @throws PersistenciaException
 */

    public void modificar(Fabricante fabricante) throws ControladoresDBException, PersistenciaException {
      
        validarFabricante(fabricante);
        if (!existe(fabricante)) {
           throw new ControladoresDBException(LA_ARQUITECTURA_QUE_SE_INDICA_NO_EXISTE);
        }
        arquitecturaModelo.modificar(arquitectura);
     }
  
/**
 * Funcion encargada de verificar si existe la arquitectura
 * @param arquitectura a encontrar
 * @return true/false
 * @throws PersistenciaException error controlado
 */

     private boolean existe(Arquitectura arquitectura) throws PersistenciaException {
        boolean encontrada = false;
        Arquitectura arquitecturaEncontrada;
   
        arquitecturaEncontrada = buscar(arquitectura.getId());
        if (arquitecturaEncontrada != null) {
           encontrada = true;
        }  
        return encontrada;
      }   

}

}

