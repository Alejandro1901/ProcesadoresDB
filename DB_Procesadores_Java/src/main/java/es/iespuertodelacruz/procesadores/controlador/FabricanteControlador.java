package es.iespuertodelacruz.procesadores.controlador;

import java.util.ArrayList;

import es.iespuertodelacruz.procesadores.api.Fabricante;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;
import es.iespuertodelacruz.procesadores.modelo.FabricanteModelo;

public class FabricanteControlador {

    private static final String EL_FABRICANTE_QUE_SE_INDICA_NO_EXISTE = "El fabricante que se indica NO existe en nuestra base de datos";
    FabricanteModelo fabricanteModelo;

    /**
     * Constructor con el modelo
     * 
     * @throws PersistenciaException controlada
     */
    public FabricanteControlador() throws PersistenciaException {
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
 * @param codigo a eliminar 
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
 * Metodo encargado de realizar la eliminacion de un fabricante
 * @param Codigo del elemento a eliminar
 * @throws ControladoresDBException del elemento a eliminarcontrolada con el error
 * @throws PersistenciaException 
 */   
    public void eliminar(String codigo) throws ControladoresDBException, PersistenciaException {
        Fabricante fabricante;
        fabricante = buscar(codigo);
        eliminar(fabricante);
     }

     /**
      * Metodo encargado de buscar por la id de la clase
      * @param codigo para localizar al fabricante
      * @return fabricante a traves del codigoFabricante de la clase
      * @throws PersistenciaException
      */

    public Fabricante buscar(String codigo) throws PersistenciaException {
        Fabricante fabricante = null;
        fabricante = fabricanteModelo.buscar(codigo);
        return fabricante;
     }

/**
 * Metodo encargado de realizar la modificacion de un tipo de fabricante
 * @param fabricante modificar
 * @throws ControladoresDBException controlada en caso de error
 * @throws PersistenciaException
 */

    public void modificar(Fabricante fabricante) throws ControladoresDBException, PersistenciaException {
      
        validarFabricante(fabricante);
        if (!existe(fabricante)) {
           throw new ControladoresDBException(EL_FABRICANTE_QUE_SE_INDICA_NO_EXISTE);
        }
        fabricanteModelo.modificar(fabricante);
     }
  
/**
 * Funcion encargada de verificar si existe el fabricante
 * @param fabricante a encontrar
 * @return true/false
 * @throws PersistenciaException error controlado
 */

    private boolean existe(Fabricante fabricante) throws PersistenciaException {
        boolean encontrada = false;
        Fabricante fabricanteEncontrada;

        fabricanteEncontrada = buscar(fabricante.getCodigo());
        if (fabricanteEncontrada != null) {
            encontrada = true;
        }  
        return encontrada;
    }   

    /**
     * Funcion que devuelve el listado completo
     * 
     * @return arraylist con los campos
     * @throws PersistenciaException controlada
     */
    public ArrayList<Fabricante> buscarTodos() throws PersistenciaException {
        return fabricanteModelo.buscarTodos();
    }
}



