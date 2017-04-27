package clases;
import org.junit.Test;

public class ConvolutionTest {

	  @Test
	  public void archivoExistente() {
		  Convolution test = new Convolution();
		  test.make_convolution("Captura.jpg");
		  test.make_convolution("Ejemplo.jpg");		  
	  } 
	  @Test
	  public void archivoNoExistente(){
		  HistoEQ test = new HistoEQ();
		  test.eqHisto("CapturaN.jpg");
	  }
}
