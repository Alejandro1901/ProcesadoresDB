package es.iespuertodelacruz.procesadores.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArquitecturaTest {
  // Variables de la clase
  
  Arquitectura arquitectura1;
  Arquitectura arquitectura2;
  Arquitectura arquitectura3;

  //BeforeEach y AfterEach

  @BeforeEach
  public void SetUp() {
      arquitectura1 = crearArquitectura();
      arquitectura2 = new Arquitectura(1,"x86-64","Tiger Lake","Intel 64","halo");
      arquitectura3 = new Arquitectura("1'x86-64'Tiger Lake'Intel 64'halo");
  }

  //Test

  @Test
  public void toStringTest() {
      assertEquals("1'x86-64'Tiger Lake'Intel 64'halo",arquitectura1.toString(), "El texto recibido no era el esperado");
  }

  @Test
  public void EqualsTest() {
      assertEquals(arquitectura2,arquitectura3,"Los objetos son iguales y equals no lo reconoce");
  }

  //Funciones y metodos

  private Arquitectura crearArquitectura() {
      Arquitectura arquitectura;
      arquitectura = new Arquitectura();
      arquitectura.setId(1);
      arquitectura.setVersionArquitectura("x86-64");
      arquitectura.setDisenio("Tiger Lake");
      arquitectura.setTecnologia("Intel 64");
      arquitectura.setEstandar("halo");
      return arquitectura;
  }  

  
}
