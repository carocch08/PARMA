package clases;
import org.junit.Test;

public class BilateralFilterTest {

	@Test
	public void test() {
		BilateralFilter bft = new BilateralFilter();
		bft.bilateral_filter("Bilateral.png", 1, 2);
	}
}
