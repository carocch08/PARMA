import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.sun.glass.ui.Size;

public class GaussFilter {
	public void gauss_filter(String file_name, double standardDev){
		   
	      try {
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         org.opencv.core.Size size = new org.opencv.core.Size(45,45);
	         Imgproc.GaussianBlur(source, destination, size, standardDev);
			   
			 int aparicion = file_name.indexOf(".");
	         String name = file_name.substring(0, aparicion);
	         String finalName = name + "GaussFilter.jpg";
	        
			 Imgproc.equalizeHist(source, destination);
			 Imgcodecs.imwrite(finalName, destination);
	      
	      } catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
	      }
	   }
}
