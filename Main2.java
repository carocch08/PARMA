
public class Main2 {
		public static void main (String [ ] args) {
		 
//		GaussianFilter gau = new GaussianFilter();
//		Time time = new Time();
//		time.time_ejecution();	
			InputStream input = new FileInputStream('Captura2.png');
			ImageInputStream imageInput = ImagenIO.createInputStream(input);
			BufferedImage imagenL = ImagenIO.read(imageInput);
			
			int alto = imagenL.getHeight();
			int ancho = imagenL.getWidth();
			
			System.out.println("Alto: " + alto + "Ancho: " + ancho);
		}

}
