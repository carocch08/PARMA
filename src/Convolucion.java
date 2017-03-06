import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Convolucion {
   public void make_convolution(){
   
      try {
         int kernelSize = 3;
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
         Mat source = Imgcodecs.imread("Captura2.jpg",  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
         Mat destination = new Mat(source.rows(),source.cols(),source.type());
         
         Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
            {
               put(0,0,0);
               put(0,1,0);
               put(0,2,0);

               put(1,0,0);
               put(1,1,1);
               put(1,2,0);

               put(2,0,0);
               put(2,1,0);
               put(2,2,0);
            }
         };
         
         Imgproc.filter2D(source, destination, -1, kernel);
         Imgcodecs.imwrite("Convolution.jpg", destination);
         
      } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }
   }
   
   
}