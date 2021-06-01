

package es.iespuertodelacruz.procesadores.fichero;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FicheroTest {

    static Fichero fichero;

    @BeforeAll
    public static void setUp() {
        fichero = new Fichero();
    }

    @Test
    public void leerFicheroTest() {
        try {
            String lectura = fichero.leer("resources/creaciones/arquitectura.crear.sql");
            assertTrue(lectura.contains("CREATE TABLE IF NOT EXISTS arquitectura ("));
        } catch (Exception e) {
            fail("Se ha producido un error leyendo el fichero", e);
        }
    }
}

