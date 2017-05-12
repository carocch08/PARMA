package clases;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GaussianFilterServlet
 */
@WebServlet("/GaussianFilterServlet")
public class GaussianFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int SIN_BORDES = ConvolveOp.EDGE_NO_OP;
	    /** En bordes que se salen de la imagen se evaluan como si tuviesen valor 0. */
    public static final int BORDES_0 = ConvolveOp.EDGE_ZERO_FILL;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GaussianFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException {
    	processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException {
//    	processRequest(request, response);    
	}
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
    {
    	response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 try
		 { 		String file_name1 = request.getParameter("file1");
				BufferedImage img = null;
				img = ImageIO.read(new File("Celula.PNG"));
				aplicar(img, 1, 1);
		 }
		 finally
		 {
			 out.close();
		 }
		 
//		 BufferedImage myPicture = null;
//		    try {
//		        myPicture = ImageIO.read(new File(path));
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		    }
    }
	
	public  BufferedImage aplicar(BufferedImage imagen, int theta, int size) throws IOException{
//	      BufferedImage res = null;
	      float kernel[][]= generateKernel(theta, size);

	      BufferedImage res = aplicarConv(kernel, imagen, BORDES_0);

	      return res;
	  }

	  /**
	   *  Genera la matriz de convolución para un filtro Gaussiano a partir de
	   * theta y el tamaño de la matriz (n x n).
	   *
	   * @param theta
	   * @param size
	   * @return
	   */
	  private static float[][] generateKernel(float theta, int size){
	      float [][] kernel = new float [size][size];
	      for(int j=0;j<size;++j){
	          for(int i=0;i<size;++i){
	              kernel[i][j]=gaussianDiscrete2D(theta,i-(size/2),j-(size/2));
	          }
	      }

	      double sum = 0;
	      for(int j=0;j<size;++j){
	        for(int i=0;i<size;++i){
	      sum = sum + kernel[i][j];

	        }
	      }

	      return kernel;
	  }

	  private static float gaussianDiscrete2D(double theta, int x, int y){
	  float g = 0;
	  for(double ySubPixel = y - 0.5; ySubPixel < y + 0.55; ySubPixel += 0.1){
	    for(double xSubPixel = x - 0.5; xSubPixel < x + 0.55; xSubPixel += 0.1){
	          g = g + (float)((1/(2*Math.PI*theta*theta)) *
	          Math.pow(Math.E,-(xSubPixel*xSubPixel+ySubPixel*ySubPixel)/
	                        (2*theta*theta)));
	    }
	  }
	  g = g/121;
	  //System.out.println(g);
	  return g;
	}
	  
	  public static BufferedImage aplicarConv(float filtro[][], BufferedImage imagen, int tratBordes) throws IOException{
	        BufferedImage res = null;
	       
	        if(imagen == null)
	            throw new IllegalArgumentException("La imagen no puede ser nula");
	        if(filtro == null || filtro.length == 0)
	            throw new IllegalArgumentException("Debe pasarse algún filtro válido");

	        if(tratBordes != SIN_BORDES || tratBordes != BORDES_0)
	            tratBordes = SIN_BORDES;

	        int width = filtro.length;
	        int height = filtro[0].length;
	        int tam = width * height;
	        float filtroK[] = new float[tam];

	        //Creamos el filtro
	        for(int i=0; i < width; i++){
	            for(int j=0; j < height; j++){
	                filtroK[i*width + j] = filtro[i][j];
	            }
	        }

	        //Creamos la operación de convolución.
	        Kernel kernel = new Kernel(width, height, filtroK);
	        ConvolveOp cop = new ConvolveOp(kernel, tratBordes, null);

	        //Creamos la imagen nueva a semejanza de la antigua
	        res = new BufferedImage(imagen.getWidth(), imagen.getHeight(), imagen.getType());

	        //Aplicamos el filtro
	        BufferedImage i = cop.filter(imagen, res);         
	        File outputfile = new File("saved.png");
	        ImageIO.write(i, "png", outputfile);
	        return res;
	    }

}
