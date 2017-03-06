import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer.Form;

import javax.imageio.stream.ImageInputStream;

import org.omg.CORBA.portable.InputStream;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import javafx.scene.effect.ImageInput;
import sun.nio.cs.HistoricallyNamedCharset;

public class Main {
	
	
	 public static void main( String[] args ) throws IOException
	 {
		HistogramsEQ hEQ = new HistogramsEQ();
		hEQ.equalize_hist("Captura.jpg");	
	}

}
