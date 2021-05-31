package es.iespuertodelacruz.procesadores;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.procesadores.fichero.Fichero;

public class FicheroTest {

    static Fichero fichero;

    @BeforeAll
    public static void setUp() {
        fichero = new Fichero();
    }

    @Test
    public void leerFicheroTest() {
        try {
            fichero.leer("aaa.txt");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("El fichero a leer no existe"));
        }
        try {
            String lectura = fichero.leer("resources/sql/sqlite/producto.crear.sql");
            assertTrue(lectura.contains("CREATE TABLE producto ("));
        } catch (Exception e) {
            fail("Se ha producido un error leyendo el fichero", e);
        }
    }
}
