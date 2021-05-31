package es.iespuertodelacruz.procesadores.fichero;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.excepcion.FicheroException;
import es.iespuertodelacruz.procesadores.fichero.*;

public class FicheroTest {

    static Fichero fichero;

    @BeforeAll
    public static void setUp() {
        fichero = new Fichero();
    }

    @Test
    public void leerFicheroTest() {
        try {
            fichero.leer("ProcesadoresDB.sql");
        } catch (FicheroException e) {
            assertTrue(e.getMessage().contains("El fichero a leer no existe"));
        }
        try {
            String lectura = fichero.leer("resources/sql/sqlite/producto.crear.sql");
            assertTrue(lectura.contains("CREATE TABLE producto ("));
        } catch (FicheroException e) {
            fail("Se ha producido un error leyendo el fichero", e);
        }
    }
}