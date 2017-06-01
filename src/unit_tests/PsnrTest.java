package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Psnr;

public class PsnrTest {

  @Test
  public void test() {
    Psnr psnr = new Psnr();
    psnr.calculate_psnr("C:\\Users\\Carolina\\workspace\\PARMA\\images\\Celula.PNG", "C:\\Users\\Carolina\\workspace\\PARMA\\images\\Celula2.jpg");
  }

}
