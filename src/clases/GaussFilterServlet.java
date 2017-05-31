package clases;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
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
 * Servlet implementation class GaussFilterServlet
 */
@WebServlet("/GaussFilterServlet")
public class GaussFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GaussFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @author Carolina Campos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String file_name = request.getParameter("file1");
		try 
		{
		  long time_start, time_end;
          time_start = System.currentTimeMillis();
          GaussFilter gauss = new GaussFilter();
          String final_name = gauss.make_gauss(file_name);
          //Para mostrar la imagen
          response.setContentType("image/jpeg");
          ServletOutputStream out1;
          out1 = response.getOutputStream();
          FileInputStream img_conv = new FileInputStream(final_name);
          BufferedInputStream inp_conv = new BufferedInputStream(img_conv);
          BufferedOutputStream out_conv = new BufferedOutputStream(out1);
          int ch = 0;
          while ((ch=inp_conv.read()) != -1) 
          {
            out_conv.write(ch);
          }             
          inp_conv.close();
          img_conv.close();
          out_conv.close();
          out1.close(); 
          time_end = System.currentTimeMillis();   
          System.out.println("El tiempo de duraci�n fue: "+ ( time_end - time_start ) +" milisegundos");               
	     }
		  catch (Exception e) 
		 {
		    System.out.println("Error: " + e.getMessage());
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
