package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Gaussian;

public class GaussianTest {

  @Test
  public void test()
  {
    Gaussian gauss = new Gaussian();
    gauss.make_gauss("C:\\Users\\Carolina\\workspace\\PARMA\\images\\Celula.PNG", "Gauss");
  }
  

}
