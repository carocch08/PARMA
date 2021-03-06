package servlets;

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
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import clases.Convolution;

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
     * @author Juan Manuel Guevara/Carolina Campos
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        response.setContentType("text/html;charset=UTF-8");
        String file_name = request.getParameter("file1");
        String new_name = request.getParameter("new_name");
        
        Convolution convolution = new Convolution();
        String final_name = convolution.make_convolution(file_name, new_name);
        
        response.setContentType("image/jpeg");
        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream img_conv = new FileInputStream(final_name);
        BufferedInputStream inp_conv = new BufferedInputStream(img_conv);
        BufferedOutputStream out_conv = new BufferedOutputStream(out);
        int ch = 0;
        while ((ch=inp_conv.read()) != -1) {
        out_conv.write(ch);
        }             
        inp_conv.close();
        img_conv.close();
        out_conv.close();
        out.close(); 
        time_end = System.currentTimeMillis();   
        System.out.println("El tiempo de duraci�n fue: "+ ( time_end - time_start ) +" milisegundos");            

}
    
       

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}