package clases;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/*
 * @param file_name es la ruta de la imagen a analizar
 * @param desv_stand es la desviación estándar para analizar la imagen
 * @return void
 * @author Carolina Campos
 * */
public class GaussFilter {
	public void gaussian_filter(String file_name, double desv_stand){
		try {
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         org.opencv.core.Size size = new org.opencv.core.Size(11,45);
	         Imgproc.GaussianBlur(source, destination, size, desv_stand);
			   
			 int aparicion = file_name.indexOf(".");
	         String name = file_name.substring(0, aparicion);
	         String final_name = name + "GaussFilter.jpg";
	        
			 Imgproc.equalizeHist(source, destination);
			 Imgcodecs.imwrite(final_name, destination);
	      
	      } catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
	      }
	}
}
