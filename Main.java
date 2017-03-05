import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.text.Normalizer.Form;

import javax.imageio.stream.ImageInputStream;

import org.omg.CORBA.portable.InputStream;

import javafx.scene.effect.ImageInput;

public class Main {
	
	public static void main (String [ ] args) {
	 
//	GaussianFilter gau = new GaussianFilter();
//	Time time = new Time();
//	time.time_ejecution();	
		InputStream input = new FileInputStream('Captura2.png');
		ImageInputStream imageInput = ImagenIO.createInputStream(input);
		BufferedImage imagenL = ImagenIO.read(imageInput);
		
		int alto = imagenL.getHeight();
		int ancho = imagenL.getWidth();
		
		System.out.println("Alto: " + alto + "Ancho: " + ancho);
	}

}
