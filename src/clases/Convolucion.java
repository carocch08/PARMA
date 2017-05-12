package clases;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author juanmasp
 * @date 05-12-2008
 */
public class Convolucion {
    /** En los bordes que se salen de la imagen no se aplica el filtro. */
    public static final int SIN_BORDES = ConvolveOp.EDGE_NO_OP;
    /** En bordes que se salen de la imagen se evaluan como si tuviesen valor 0. */
    public static final int BORDES_0 = ConvolveOp.EDGE_ZERO_FILL;

   /**
    *  Aplica una operación de convolución sobre la imagen pasada como
    * argumento, utilizando la matriz también pasada como argumento.
    *
    * @param filtro
    * @param imagen
    * @param tratBordes
    * @return imagen resultante de aplicar el filtro, null en caso de fallo o
    * argumentos incorrectos.
 * @throws IOException 
    */
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