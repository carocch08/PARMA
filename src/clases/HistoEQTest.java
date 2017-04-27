package clases;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class HistoEQTest {
	  
	  @Test
	  public void archivoExistente() {
		  HistoEQ test = new HistoEQ();
		  test.eqHisto("Domino.png");
//		  test.eqHisto("Ejemplo.jpg");		  
	  } 
	  @Test
	  public void archivoNoExistente(){
		  HistoEQ test = new HistoEQ();
		  test.eqHisto("CapturaN.jpg");
	  }
}