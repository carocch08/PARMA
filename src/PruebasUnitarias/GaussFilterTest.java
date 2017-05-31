package PruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.GaussFilter;

public class GaussFilterTest {

//  @Test
//  public void test() {
//    HistoEQ histo = new HistoEQ();
//    histo.make_histoEQ("Celula");
//  }
  
  @Test
  public void test()
  {
    GaussFilter gauss = new GaussFilter();
    gauss.make_gauss("Celula2.jpg");
  }
  

}
