package logica;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import com.sun.org.glassfish.gmbal.ParameterNames;

public class Psnr {
	/* @param nombre del archivo
	 * @param array para pasar los bytes de la imagen
	 * @param alto de la imagen
	 * @param ancho de la imagen
	 * @ return void
	 */ 	
	 public void bytes_array(String file_name, int array[][], int heigh, int width) {
		    try {
		      File file = new File(file_name);
		      FileInputStream fin= new FileInputStream(file);
		       for (int i=0; i<heigh; i++)
		       {
		    	   for (int j=0; j<width; j++)
		    	   {
		    		   array[i][j] = (int)(0xFF & fin.read()); // Unsigned char to integer
		    	   }       	   
		       }
		         
		      fin.close();
		    }
		    catch (Exception e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		    }
		  }
	 /*
	  * @param nombre del archivo a analizar
	  * @return alto de la imagen (matriz) 
	  */
	 public int get_heigh(String file_name)
	  {
		  try
		  {			  
			  InputStream input = new FileInputStream(file_name);
		      ImageInputStream imageInput = ImageIO.createImageInputStream(input);		      
		      BufferedImage imageL = ImageIO.read(imageInput);		      
		      int heigh = imageL.getHeight();		      
			  return heigh;   
		  }
		  catch (Exception e) {
	          
	      }
		  System.out.println("Null");
		  return 0;   
	  }
	
	 /*
	  * @param nombre del archivo a analizar
	  * @return ancho de la imagen (matriz)
	  */
	public int get_width(String file_name)
	  {
		  try
		  {			  
			  InputStream input = new FileInputStream(file_name);
		      ImageInputStream imageInput = ImageIO.createImageInputStream(input);		      
		      BufferedImage imageL = ImageIO.read(imageInput);		      
		      int width = imageL.getWidth();		      
			  return width;   
		  }
		  catch (Exception e) {
	          
	      }
		  System.out.println("Null");
		  return 0;   
	  }
	
	 public static double log10(double num) {
		return Math.log(num)/Math.log(10);
	 }

	 /*
	  * @param nombre del primer archivo a analizar
	  * @return nombre del segundo archivo a analizar
	  * @return un double con el resultado del mse
	  */
	 public double calculate_mse(String file_name1, String file_name2)
	 {
		    int heigh = get_heigh(file_name1);
	    	int width = get_width(file_name2);
	        int image1[][], image2[][];
	        double result, mse;

	        image1 = new int[heigh][width];
	        image2 = new int[heigh][width];
	        bytes_array(file_name1, image1, heigh, width);
	        bytes_array(file_name2, image2, heigh, width);

	        result = 0;
	        for (int i1=0; i1<heigh; i1++) {
	          for (int j=0; j<width; j++) {
	            result += (image1[i1][j] - image2[i1][j]) * (image1[i1][j] - image2[i1][j]);
	          }
	        }

	        mse = result/(heigh*width); // Mean square error	        
	        System.out.println("MSE: " + mse);
	        return mse;
	 }
	 
	 /*
	  * @param nombre del primer archivo a analizar
	  * @return nombre del segundo archivo a analizar
	  * @return un double con el resultado del psnr
	  */
	 public double calculate_psnr(String file_name1, String file_name2)
	 {
		 double mse = calculate_mse(file_name1, file_name2);
		 double psnr = 10*log10(255*255/mse);
		 System.out.println("PSNR: " + psnr);
		 return psnr;
	 }

}
