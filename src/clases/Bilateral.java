package clases;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
/*
 * @param file_name con la imagen a analizar
 * @return final_name con el nombre del archivo que se guardó
 * @author Carolina Campos
 * */
public class Bilateral {
  public String make_bilateral(String file_name, String new_name)
  {
    try {
      System.load("C:\\Users\\Carolina\\Downloads\\Instaladores\\opencv\\build\\java\\x64\\opencv_java320.dll");
      
      Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
      
      Mat destination = new Mat(source.rows(),source.cols(),source.type());
      Imgproc.bilateralFilter(source, destination, 15, 80, 80, Core.BORDER_DEFAULT);
      
      String final_name = "C:\\Users\\Carolina\\workspace\\PARMA\\images\\" + new_name + ".jpg";
      
      Imgcodecs.imwrite(final_name, destination);
      return final_name;
      
   } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
   }
    return "";
  }
}
