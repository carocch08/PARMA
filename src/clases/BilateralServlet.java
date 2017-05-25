package clases;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Servlet implementation class Bilateral
 */
@WebServlet(name = "Bilateral", urlPatterns = {"/Bilateral"})
public class BilateralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BilateralServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try {

			String file_name = request.getParameter("file1");
			System.load("C:\\Users\\Carolina\\Downloads\\Instaladores\\opencv\\build\\java\\x64\\opencv_java320.dll");
	         
	         Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         Imgproc.bilateralFilter(source, destination, 15, 80, 80, Core.BORDER_DEFAULT);
			   
	         int aparicion = file_name.indexOf(".");
	         String name = file_name.substring(0, aparicion);
	         String final_name = name + "BilateralFilter.jpg";	            
	         Imgcodecs.imwrite(final_name, destination);

	         response.setContentType("image/jpeg");
	         ServletOutputStream out1;
	         out1 = response.getOutputStream();
	         FileInputStream img_conv = new FileInputStream(final_name);
	         BufferedInputStream inp_conv = new BufferedInputStream(img_conv);
	         BufferedOutputStream out_conv = new BufferedOutputStream(out1);
	         int ch = 0;
	         while ((ch=inp_conv.read()) != -1) {
	         out_conv.write(ch);
	         }	           
	         inp_conv.close();
	         img_conv.close();
	         out_conv.close();
	         out1.close(); 	     	         	        
	      } 
		finally
		{
		  
	    }
	}
	
	public void display_image(String file_name)
	{
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*protected void conversion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
//			 String file_name = request.getParameter("file");
//			 out.println(Integer.parseInt(file_name));
//			 String intensity_dominance = request.getParameter("dominance");
//			 String space = request.getParameter("space");
//	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
//	         
//	         Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
//	         
//	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
//	         Imgproc.bilateralFilter(source, destination, Integer.parseInt(intensity_dominance), 80, Integer.parseInt(space), Core.BORDER_DEFAULT);
//			 out.println(Integer.parseInt(intensity_dominance));
//			 int aparicion = file_name.indexOf(".");
//	         String name = file_name.substring(0, aparicion);
//	         String final_name = name + "BilateralFilter.jpg";
//	        
//			 Imgproc.equalizeHist(source, destination);
//			 Imgcodecs.imwrite(final_name, destination);
			String name = request.getParameter("image");
			out.println("<DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Bla bla</title>");
			out.println("<head>");
			out.println("<body>");
			out.println("<h1>Hello " + name + "</h1>");
			out.println("</body>");
			out.println("</html>");
			
	      } finally
		{
	    	  out.close();
	   }
	}*/

}
