package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NombreProcesadorTest {
  // Variables de la clase
    
  NombreProcesador nombreprocesador1;
  NombreProcesador nombreprocesador2;
  NombreProcesador nombreprocesador3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      nombreprocesador1 = crearNombreProcesador();
      nombreprocesador2 = new NombreProcesador("11900K","Core i9",11);
      nombreprocesador3 = new NombreProcesador("11900K'Core i9'11");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("11900K'Core i9'11",nombreprocesador1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(nombreprocesador2,nombreprocesador3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private NombreProcesador crearNombreProcesador() {
      NombreProcesador nombreprocesador;
      nombreprocesador = new NombreProcesador();
      nombreprocesador.setModeloProcesador("11900K");
      nombreprocesador.setFamilia("Core i9");
      nombreprocesador.setGeneracion(11);
      return nombreprocesador;
  }  

  
}
