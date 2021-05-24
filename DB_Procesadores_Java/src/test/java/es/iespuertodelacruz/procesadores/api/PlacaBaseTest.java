package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlacaBaseTest {
  // Variables de la clase
    
  PlacaBase placaBase1;
  PlacaBase placaBase2;
  PlacaBase placaBase3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      placaBase1 = crearPlacaBase();
      placaBase2 = new PlacaBase(1,2,"Gigabyte");
      placaBase3 = new PlacaBase("1'2'Gigabyte");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("1'2'Gigabyte",placaBase1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(placaBase2,placaBase3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private PlacaBase crearPlacaBase() {
      PlacaBase placaBase;
      placaBase = new PlacaBase();
      placaBase.setId(1);
      placaBase.setIdSocket(2);
      placaBase.setNombre("Gigabyte");

      return placaBase;
  }  


  
}
