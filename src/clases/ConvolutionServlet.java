package clases;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Servlet implementation class ConvolutionServlet
 */
@WebServlet("/ConvolutionServlet")
public class ConvolutionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvolutionServlet() {
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
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String file_name = request.getParameter("file1");
        try {
          int kernelSize = 3;
          System.load("C:\\Users\\Carolina\\Downloads\\Instaladores\\opencv\\build\\java\\x64\\opencv_java320.dll");
          
          Mat source = Imgcodecs.imread(file_name, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
          Mat destination = new Mat(source.rows(),source.cols(),source.type());
          
          Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
             {
                put(0,0,0);
                put(0,1,0);
                put(0,2,0);

                put(1,0,0);
                put(1,1,1);
                put(1,2,0);

                put(2,0,0);
                put(2,1,0);
                put(2,2,0);
             }
          };
          
          Imgproc.filter2D(source, destination, -1, kernel);
          
          int aparicion = file_name.indexOf(".");
          String name = file_name.substring(0, aparicion);
          String final_name = name + "Conv.jpg";
          Imgcodecs.imwrite(final_name, destination);
                   
          
       } catch (Exception e) {
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