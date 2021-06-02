package es.iespuertodelacruz.procesadores.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.api.Arquitectura;
import es.iespuertodelacruz.procesadores.controlador.ArquitecturaControlador;
import es.iespuertodelacruz.procesadores.excepcion.ControladoresDBException;
import es.iespuertodelacruz.procesadores.excepcion.PersistenciaException;



public class ArquitecturaControladorTest {

    Arquitectura arquitectura = new Arquitectura();
    Arquitectura arquitecturaInvalida = new Arquitectura();
    ArquitecturaControlador arquitecturaControlador;

    @BeforeEach
    public void setUp() throws PersistenciaException, ControladoresDBException {
        if (arquitecturaControlador == null) {
            arquitecturaControlador = new ArquitecturaControlador();
        }
        if (arquitectura.getId() == 0) {
            arquitectura = crearArquitectura();
        }
        if (arquitecturaControlador.buscar(arquitectura.getId()) == null) {
            arquitecturaControlador.insertar(arquitectura);
        }
        if (arquitecturaInvalida.getId() == 0) {
            arquitecturaInvalida = crearArquitecturaInvalida();
        }
    }

    @AfterEach
    public void after() throws ControladoresDBException, PersistenciaException {
        arquitecturaControlador.eliminar(arquitectura.getId());
    }
    
    @Test
    public void buscarArquitecturaTest() throws PersistenciaException {
        Arquitectura arquitecturaEncontrada = arquitecturaControlador.buscar(arquitectura.getId());
        assertEquals(arquitecturaEncontrada, arquitectura, "No es igual la ruta encontrada a la esperada");
    }

    @Test
    public void listarArquitecturaTest() throws PersistenciaException {
        ArrayList<Arquitectura> lista = arquitecturaControlador.buscarTodos();
        assertTrue(lista.contains(arquitectura),"La lista no contiene el valor esperado");
    }

    @Test
    public void arquitecturaInvalidaTest() throws ControladoresDBException, PersistenciaException {
        //metodo vacio
    }

    private static Arquitectura crearArquitectura() {
        return new Arquitectura(100, "ARM", "test", "Thumb", "No tiene");
    }

    private static Arquitectura crearArquitecturaInvalida() {
        Arquitectura arquitectura = new Arquitectura();
        arquitectura.setId(-4);
        arquitectura.setVersionArquitectura("");
        arquitectura.setDisenio("");
        arquitectura.setTecnologia("");
        arquitectura.setEstandar("");
        return arquitectura;
    }
}