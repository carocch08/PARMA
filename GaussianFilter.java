
public class GaussianFilter {

	int [][] imageMatrix;
	double standartDesviation = 0.5;
	
	
	public double gaussianFilter(int L, int K, int pointX, int pointY)
	{
		double finalU = pointX + ((K-1)/2);
		double finalV = pointY + ((L-1)/2);
		double alpha = alphaCalculus(K, L);
		double calculus = 0;
		double result = 0;
		
		for (int u = pointX - ((K-1)/2) ;u <= finalU; u++)
		{
			for (int v = pointY - ((L-1)/2); v <= finalV; v++)
			{
				calculus += this.imageMatrix[u][v] * FCalculus(pointX-u, pointY-v);
			}
		}
		
		result = (1/alpha) * calculus;
		return result;		
	}
	
	public double FCalculus(int pointX, int pointY)
	{		
		double result =0;
		result = (Math.pow(Math.E, (-(Math.pow(pointX, 2))))) + (Math.pow(pointY, 2) / 2*(Math.pow(this.standartDesviation, 2)));
		return result;
				
	}
	
	public double alphaCalculus(int K, int L)
	{
		double result = 0;
		for (int u = 0; u <= K; u++)
		{
			for (int v = 0; v <= L; v++)
			{
				result += this.FCalculus(u, v);
			}
		}
		return result;
	}
	
	
}
