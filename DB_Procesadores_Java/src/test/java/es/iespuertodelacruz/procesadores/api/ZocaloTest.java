package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZocaloTest {
  // Variables de la clase
    
  Zocalo zocalo1;
  Zocalo zocalo2;
  Zocalo zocalo3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      zocalo1 = crearZocalo();
      zocalo2 = new Zocalo(1,"1200","LGA","Q2´20");
      zocalo3 = new Zocalo("1'1200'LGA'Q2´20");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("1'1200'LGA'Q2´20",zocalo1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(zocalo2,zocalo3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private Zocalo crearZocalo() {
      Zocalo zocalo;
      zocalo = new Zocalo();
      zocalo.setId(1);
      zocalo.setTipo("1200");
      zocalo.setTecnologia("LGA");
      zocalo.setFechaLanzamiento("Q2´20");
      

      return zocalo;
  }  

  
}
