public class Main{
	
	public static void main( String[] args )
	 {
//		Convolution c = new Convolution();
//		c.make_convolution("Captura2.jpg");
		
//		HistoEQ hEQ = new HistoEQ();
//		hEQ.eqHisto("Captura2.jpg");
		
//		Time t = new Time();
//		t.time_ejecution();
		BilateralFilter bil = new BilateralFilter();
		bil.bilateral_filter("Bila.png", 1, 2);
//		GaussFilter gauss = new GaussFilter();
//		gauss.gauss_filter("Captura2.jpg", 0.4);
	 }
}