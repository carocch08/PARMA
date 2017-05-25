package clases;
import java.lang.reflect.Method;

/*
 * @param no tiene parametros
 * @return void
 * @author Carolina Campos
 * */

public class Time {

	public void time_ejecution()
	{
		long time_start, time_end;
		time_start = System.currentTimeMillis();
//		HistoEQ hist = new HistoEQ();
//		hist.eqHisto("Captura2.jpg");
		time_end = System.currentTimeMillis();			
		System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");		
	}	
}
