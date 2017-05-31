package PruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Psnr;

public class PsnrTest {

  @Test
  public void test() {
    Psnr psnr = new Psnr();
    psnr.calculate_psnr("Celula.png", "Celula2.jpg");
  }

}
