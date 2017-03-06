import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HistoEQ {
	 		
	public void eqHisto (String file_name)
	{
		try 
		   {	
				System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
				Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
				Mat destination = new Mat(source.rows(),source.cols(),source.type());
				   
				int aparicion = file_name.indexOf(".");
		        String name = file_name.substring(0, aparicion);
		        String finalName = name + "HistoEQ.jpg";
		        
				Imgproc.equalizeHist(source, destination);
				Imgcodecs.imwrite(finalName, destination);
			     
		    } 
		    catch (Exception e) 
		    {
		    	System.out.println("Error: " + e.getMessage());
		    }
	}

}