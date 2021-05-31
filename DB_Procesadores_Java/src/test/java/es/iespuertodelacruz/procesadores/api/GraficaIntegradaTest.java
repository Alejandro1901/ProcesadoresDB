package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraficaIntegradaTest {
  // Variables de la clase
    
  GraficaIntegrada graficaIntegrada1;
  GraficaIntegrada graficaIntegrada2;
  GraficaIntegrada graficaIntegrada3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      graficaIntegrada1 = crearGraficaIntegrada();
      graficaIntegrada2 = new GraficaIntegrada(1,"Intel UHD Graphics 750",0.35F,1.25F,64F,"4K");
      graficaIntegrada3 = new GraficaIntegrada("1'Intel UHD Graphics 750'0.35F'1.25F'64'4K");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("1'Intel UHD Graphics 750'0.35'1.25'64.0'4K",graficaIntegrada1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(graficaIntegrada2,graficaIntegrada3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private GraficaIntegrada crearGraficaIntegrada() {
      GraficaIntegrada graficaIntegrada;
      graficaIntegrada = new GraficaIntegrada();
      graficaIntegrada.setId(1);
      graficaIntegrada.setNombreGrafica("Intel UHD Graphics 750");
      graficaIntegrada.setFrecuenciaBasica(0.35F);
      graficaIntegrada.setFrecuenciaMaxima(1.25F);
      graficaIntegrada.setMemoriaMaxima(64F);
      graficaIntegrada.setResolucion("4K");

      return graficaIntegrada;
  }  

  int id;
  String nombreGrafica;
  float frecuenciaBasica;
  float frecuenciaMaxima;
  float memoriaMaxima;
  String resolucion;
  
}
