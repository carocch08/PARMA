import org.junit.Test;

public class TimeTest {
	@Test
	  public void testTiempo() {
		  Time t = new Time();
		  t.time_ejecution();
//		  Convolution c = new Convolution();
//		  c.make_convolution("Captura.jpg");	
	  } 
	  @Test
	  public void archivoNoExistente(){
		  HistoEQ test = new HistoEQ();
		  test.eqHisto("CapturaN.jpg");
	  }
}
