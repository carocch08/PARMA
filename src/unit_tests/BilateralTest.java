package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Bilateral;

public class BilateralTest {

  @Test
  public void test() {
    Bilateral bila = new Bilateral();
    bila.make_bilateral("C:\\Users\\Carolina\\workspace\\PARMA\\images\\Celula.PNG", "Bilateral");
  }

}
