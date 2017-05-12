package clases;
import org.junit.Test;

public class BilateralFilterTest {

	@Test
	public void test() {
		BilateralFilter bft = new BilateralFilter();
		bft.bilateral_filter("Bilateral.jpg", 15, 80);
	}
}
