package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FabricanteTest {
  // Variables de la clase
    
  Fabricante fabricante1;
  Fabricante fabricante2;
  Fabricante fabricante3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      fabricante1 = crearFabricante();
      fabricante2 = new Fabricante("US4581401001","95052","Intel",3186,"Estados Unidos","Mission College Blvd","877-284-1566","investor.relations@intel.com","https://www.intel.es");
      fabricante3 = new Fabricante("US4581401001'95052'Intel'3186'Estados Unidos'Mission College Blvd'877-284-1566'investor.relations@intel.com'https://www.intel.es");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("US4581401001'95052'Intel'3186'Estados Unidos'Mission College Blvd'877-284-1566'investor.relations@intel.com'https://www.intel.es",fabricante1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(fabricante2,fabricante3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private Fabricante crearFabricante() {
      Fabricante fabricante;
      fabricante = new Fabricante();
      fabricante.setCodigo("US4581401001");
      fabricante.setCodigoPostal("95052");
      fabricante.setNombre("Intel");
      fabricante.setNumero(3186);
      fabricante.setPais("Estados Unidos");
      fabricante.setCalle("Mission College Blvd");
      fabricante.setTelefono("877-284-1566");
      fabricante.setCorreo("investor.relations@intel.com");
      fabricante.setWeb("https://www.intel.es");

      return fabricante;
  }  

  
}
