package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.HistoEQ;

public class HistoEQTest {

  @Test
  public void test() {
   HistoEQ histo = new HistoEQ();
   histo.make_histoEQ("Captura.png");
  }

}
