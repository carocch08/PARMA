import org.junit.Test;

public class BilateralFilterTest {

	@Test
	public void test() {
		BilateralFilter bft = new BilateralFilter();
		bft.bilateral_filter("Bila.png", 1, 2);
	}
}
