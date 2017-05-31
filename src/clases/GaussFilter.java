package clases;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.sun.glass.ui.Size;

public class GaussFilter {
  public void make_gauss(String file_name)
  {
      try {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        
        Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        
        Mat destination = new Mat(source.rows(),source.cols(),source.type());
        org.opencv.core.Size size = new org.opencv.core.Size(11,45);
        
        Imgproc.GaussianBlur(source, destination, size, 2);
        int aparicion = file_name.indexOf(".");
        String name = file_name.substring(0, aparicion);
        String final_name = name + "GaussFilter.jpg";
             
        Imgcodecs.imwrite(final_name, destination);
     
     } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
     }
  }
}
