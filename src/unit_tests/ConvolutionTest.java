package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Convolution;

public class ConvolutionTest {

  @Test
  public void test() {
    Convolution conv = new Convolution();       
    conv.make_convolution("Captura.png");
  }

}
