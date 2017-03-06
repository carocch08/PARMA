public class Main{
	
	public static void main( String[] args )
	 {
		Convolution c = new Convolution();
		c.make_convolution();
		
		HistoEQ hEQ = new HistoEQ();
		hEQ.eqHisto("Eclipse.jpg");
	 }
}
