package clases;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
public class Bilateral extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bilateral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {

			String file_name = request.getParameter("name");
			String intensity_dominance = request.getParameter("dominance");
			String space = request.getParameter("space");
//			int convInt_dominance = Integer.parseInt(intensity_dominance);
//			int convSpace = Integer.parseInt(space);
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
	         
	         Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         Imgproc.bilateralFilter(source, destination, 1, 80, 1, Core.BORDER_DEFAULT);
			   
			 int aparicion = file_name.indexOf(".");
	         String name = file_name.substring(0, aparicion);
	         String final_name = name + "BilateralFilter.jpg";
	        
			 Imgproc.equalizeHist(source, destination);
			 Imgcodecs.imwrite(final_name, destination);
			
	      } finally
		{
	    	  out.close();
	   }
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
