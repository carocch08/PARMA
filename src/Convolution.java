import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Convolution {
   public void make_convolution(String file_name){
   
      try {
         int kernelSize = 3;
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         
         Mat source = Imgcodecs.imread(file_name,  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
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
         
         int aparicion = file_name.indexOf(".");
         String name = file_name.substring(0, aparicion);
         Imgproc.filter2D(source, destination, -1, kernel);
         String finalName = name + "Conv.jpg";
         Imgcodecs.imwrite(finalName, destination);
         
      } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }
   }
   
   
}