package clases;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HistoEQ {
  
  public void make_histoEQ(String file_name)
  {
    try 
    {
      System.load("C:\\Users\\Carolina\\Downloads\\Instaladores\\opencv\\build\\java\\x64\\opencv_java320.dll");
      Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
      Mat destination = new Mat(source.rows(),source.cols(),source.type());
            
      int aparicion = file_name.indexOf(".");
      String name = file_name.substring(0, aparicion);
      String final_name = name + "HistoEQ.jpg";
           
      Imgproc.equalizeHist(source, destination);
      Imgcodecs.imwrite(final_name, destination);
    }
     catch (Exception e) 
     {
         System.out.println("Error: " + e.getMessage());
     }
  }

}
