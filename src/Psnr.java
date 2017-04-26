import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Psnr {
	 public void readByteArray(String fname, int array[][], int heigh, int width) {
		    try {
		      File file = new File(fname);
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
	
	public static double log10(double x) {
		return Math.log(x)/Math.log(10);
	}

	 public double calculate_mse(String file_name1, String file_name2)
	 {
		    int heigh = get_heigh(file_name1);
	    	int width = get_width(file_name2);
	        int img1[][], img2[][];
	        double  peak, signal, noise, mse;

	        img1 = new int[heigh][width];
	        img2 = new int[heigh][width];
	        readByteArray(file_name1, img1, heigh, width);
	        readByteArray(file_name2, img2, heigh, width);

	        signal = noise = peak = 0;
	        for (int i1=0; i1<heigh; i1++) {
	          for (int j=0; j<width; j++) {
	            signal += img1[i1][j] * img1[i1][j];
	            noise += (img1[i1][j] - img2[i1][j]) * (img1[i1][j] - img2[i1][j]);
	          }
	        }

	        mse = noise/(heigh*width); // Mean square error	        
	        System.out.println("MSE: " + mse);
	        return mse;
	 }
	 
	 public double calculate_psnr(String file_name1, String file_name2)
	 {
		 double mse = calculate_mse(file_name1, file_name2);
		 double psnr = 10*log10(255*255/mse);
		 System.out.println("PSNR: " + psnr);
		 return psnr;
	 }

}
