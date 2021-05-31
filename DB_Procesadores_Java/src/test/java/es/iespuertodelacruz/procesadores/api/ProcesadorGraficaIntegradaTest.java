package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcesadorGraficaIntegradaTest {
  // Variables de la clase
    
  ProcesadorGraficaIntegrada procesadorgraficaintegrada1;
  ProcesadorGraficaIntegrada procesadorgraficaintegrada2;
  ProcesadorGraficaIntegrada procesadorgraficaintegrada3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      procesadorgraficaintegrada1 = crearProcesadorGraficaIntegrada();
      procesadorgraficaintegrada2 = new ProcesadorGraficaIntegrada(1,3);
      procesadorgraficaintegrada3 = new ProcesadorGraficaIntegrada("1'3");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("1'3",procesadorgraficaintegrada1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(procesadorgraficaintegrada2,procesadorgraficaintegrada3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private ProcesadorGraficaIntegrada crearProcesadorGraficaIntegrada() {
      ProcesadorGraficaIntegrada procesadorgraficaintegrada;
      procesadorgraficaintegrada = new ProcesadorGraficaIntegrada();
      procesadorgraficaintegrada.setIdProcesador(1);
      procesadorgraficaintegrada.setIdGraficaIntegrada(3);
      
      return procesadorgraficaintegrada;
  }  

  
}
