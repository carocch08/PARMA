import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.imageio.ImageIO;

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
			    int inicio = file_name.indexOf(".");
			    String res = file_name.substring(0, inicio);
			    System.out.println(inicio);
				String output_file = res + "GrayScale"; 
				System.out.println(output_file);
				System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
				File input = new File(file_name);
				BufferedImage image = ImageIO.read(input);	
				
				byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
				Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
				mat.put(0, 0, data);
				
				Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
				Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);
				
				byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int)(mat1.elemSize())];
				mat1.get(0, 0, data1);
				BufferedImage image1 = new BufferedImage(mat1.cols(),mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
				image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);
				
				File ouptut = new File(output_file);
				ImageIO.write(image1, "jpg", ouptut);
				System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
				Mat source = Imgcodecs.imread(output_file, 
				Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
				Mat destination = new Mat(source.rows(),source.cols(),source.type());
				   
				Imgproc.equalizeHist(source, destination);
				String finalRes = file_name + "EQ.jpg";
				Imgcodecs.imwrite(finalRes, destination);
			     
		    } 
		    catch (Exception e) 
		    {
		    	System.out.println("Error: " + e.getMessage());
		    }
	}

}