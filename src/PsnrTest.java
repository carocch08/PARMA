import org.junit.Test;

public class PsnrTest {

	@Test
	public void testMSE() {
		Psnr p = new Psnr();
		p.calculate_mse("Celula.png", "Celula2.jpg");
	}
	
	@Test
	public void testPSNR() {
		Psnr p = new Psnr();
		p.calculate_psnr("Celula.png", "Celula2.jpg");
	}
}
