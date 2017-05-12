package clases;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.sun.glass.ui.Size;

/*
 * @param file_name es la ruta de la imagen a analizar
 * @param intensity_dominance es la intensidad dominante para analizar la imagen
 * @param space es la intensidad del espacio para analizar la imagen
 * @return void
 * @author Carolina Campos
 * */
public class BilateralFilter {
	public void bilateral_filter(String file_name, int intensity_dominance, int space){
		try 
		{
		      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

		      Mat source = Imgcodecs.imread(file_name);
		      Mat destination = new Mat();

		      Imgproc.bilateralFilter(source, destination, intensity_dominance, 80, space, Core.BORDER_DEFAULT);
		      int aparicion = file_name.indexOf(".");
		      String name = file_name.substring(0, aparicion);
		      String final_name = name + "BilateralFilter.jpg";
		         
		      // Writing the image
		      Imgcodecs.imwrite(final_name, destination);

		} 
		catch (Exception e) 
		{
	         System.out.println("Error: " + e.getMessage());
	    }
	}
}

