package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.BilateralFilter;

public class BilateralTest {

  @Test
  public void test() {
    BilateralFilter bila = new BilateralFilter();
    bila.make_bilateral("Captura.png");
  }

}
