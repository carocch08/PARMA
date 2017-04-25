import org.junit.Test;

public class BillateralFilterTest {

	@Test
	public void test() {
		BilateralFilter bft = new BilateralFilter();
		bft.bilateral_filter("Bila.png", 1, 2);
	}
}
