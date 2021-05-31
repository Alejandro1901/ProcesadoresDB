package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcesadorTest {
  // Variables de la clase
    
  Procesador procesador1;
  Procesador procesador2;
  Procesador procesador3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      procesador1 = crearProcesador();
      procesador2 = new Procesador(1,"US4581401001",1,2,"11900K","Q1´21",8,16,3.5F,true,125F,569.90F,true);
      procesador3 = new Procesador("1'US4581401001'1'2'11900K'Q1´21'8'16'3.5'true'125'569.90'true");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("1'US4581401001'1'2'11900K'Q1´21'8'16'3.5'true'125.0'569.9'true",procesador1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(procesador2,procesador3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private Procesador crearProcesador() {
      Procesador procesador;
      procesador = new Procesador();
      procesador.setId(1);
      procesador.setCodigoFabricante("US4581401001");
      procesador.setIdSocket(1);
      procesador.setIdArquitectura(2);
      procesador.setModelo("11900K");
      procesador.setFechaLanzamiento("Q1´21");
      procesador.setNucleos(8);
      procesador.setHilos(16);
      procesador.setFrecuencia(3.5F);
      procesador.setOverclock(true);
      procesador.setTdp(125F);
      procesador.setPrecio(569.90F);
      procesador.setGraficaPropia(true);

      return procesador;
  }  

  
}

