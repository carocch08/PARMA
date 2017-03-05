
public class Time {

	@Test public void time_ejecution()
	{
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		time_end = System.currentTimeMillis();
		gau.alphaCalculus(2, 4);
		System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");		
	}
}
