import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class BilateralFilter {
	public void bilateral_filter(String file_name, int intensity_dominance, int space){
		 try {
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         Imgproc.bilateralFilter(source, destination, intensity_dominance, 80, space, Core.BORDER_DEFAULT);
			   
			 int aparicion = file_name.indexOf(".");
	         String name = file_name.substring(0, aparicion);
	         String final_name = name + "BilateralFilter.jpg";
	        
			 Imgproc.equalizeHist(source, destination);
			 Imgcodecs.imwrite(final_name, destination);
	      
	      } catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
	      }
	   }
}
