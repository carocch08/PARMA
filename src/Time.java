public class Time {

	public void time_ejecution()
	{
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		time_end = System.currentTimeMillis();		
		System.out.println("The task has taken "+ ( time_end - time_start ) +" milliseconds");		
	}
}