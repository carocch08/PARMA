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

public class Gaussian {
  public String make_gauss(String file_name, String new_name)
  {
      try {
        System.load("C:\\Users\\Carolina\\Downloads\\Instaladores\\opencv\\build\\java\\x64\\opencv_java320.dll");
        
        Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        
        Mat destination = new Mat(source.rows(),source.cols(),source.type());
        org.opencv.core.Size size = new org.opencv.core.Size(11,45);
        
        Imgproc.GaussianBlur(source, destination, size, 2);

        String final_name = "C:\\Users\\Carolina\\workspace\\PARMA\\images\\" + new_name + ".jpg";
             
        Imgcodecs.imwrite(final_name, destination);
        return final_name;
     
     } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
     }
      return "";
  }
}
