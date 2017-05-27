package clases;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

/**
 * Servlet implementation class PsnrServlet
 */
@WebServlet(name = "PsnrServlet", urlPatterns = {"/PsnrServlet"})
public class PsnrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PsnrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException {
    	processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException {
    	processRequest(request, response);
    }
    /*
     * @autor Carolina Campos
     * */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
    {
    	response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 try
		 { 			 
		     long time_start, time_end, result;
	         time_start = System.currentTimeMillis();
			 String file_name1 = request.getParameter("file1");
			 String file_name2 = request.getParameter("file2");
			 double mse = calculate_mse(file_name1, file_name2);
			 double psnr = 10*log10(255*255/mse);
			 time_end = System.currentTimeMillis();   
			 result = time_end - time_start;
			 out.println("<!DOCTYPE html>");
			 out.println("<html>");
			 out.println("<head>");
			 out.println("<tittle>  </tittle>");
			 out.println("</head>");
			 out.println("<body>");
			 out.print("<h1>RESULTADOS</h1>");
			 out.println("<h2>MSE: " + mse + "</h2>");
			 out.println("<h2>PSNR: " + psnr + "</h2>");
			 out.println("<h2>Tiempo de ejecución: " + result + " milisegundos </h2>");
			 out.println("</body>");
			 out.println("</html>");
		 }
		 finally
		 {
			 out.close();
		 }
    }
    /*
     * @param file_name es la ruta de la imagen a analizar
     * @param array es la matriz de pixeles de la imagen
     * @param heigh es el alto de la imagen a analizar
     * @param heigh es el ancho de la imagen a analizar
     * @return void
     * @author Carolina Campos
     * */    		
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
	  * @author Carolina Campos 
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
	 catch (Exception e) 
	 {
		 
	 }
	 	System.out.println("Null");
		return 0;   
	  }
	
	 /*
	  * @param nombre del archivo a analizar
	  * @return ancho de la imagen (matriz)
	  * @author Carolina Campos
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
		catch (Exception e) 
		{
					          
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
	  * @author Carolina Campos
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
	        return mse;
	 }		 
}
