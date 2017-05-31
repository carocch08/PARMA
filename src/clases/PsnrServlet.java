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
     * @author Carolina Campos
     * */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
    {
    	response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 try
		 { 			 
		     long time_start, time_end, result;
	         time_start = System.currentTimeMillis();
	         Psnr Psnr = new Psnr();
	         
			 String file_name1 = request.getParameter("file1");
			 String file_name2 = request.getParameter("file2");
			 
			 double mse = Psnr.calculate_mse(file_name1, file_name2);
			 double psnr = Psnr.calculate_psnr(file_name1, file_name2);
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
}
