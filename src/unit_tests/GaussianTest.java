package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Gaussian;

public class GaussianTest {

//  @Test
//  public void test() {
//    HistoEQ histo = new HistoEQ();
//    histo.make_histoEQ("Celula");
//  }
  
  @Test
  public void test()
  {
    Gaussian gauss = new Gaussian();
    gauss.make_gauss("Celula2.jpg");
  }
  

}
