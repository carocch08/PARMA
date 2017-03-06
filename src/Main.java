public class Main{
	
	public static void main( String[] args )
	 {
		Convolucion c = new Convolucion();
		c.make_convolution();
		
		HistoEQ hEQ = new HistoEQ();
		hEQ.eqHisto("Eclipse.jpg");
	 }
}
