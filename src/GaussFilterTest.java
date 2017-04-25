import static org.junit.Assert.*;

import org.junit.Test;

public class GaussFilterTest {

	@Test
	public void test() {
		GaussFilter gauss = new GaussFilter();
		gauss.gauss_filter("Captura.jpg", 0.5);
	}

}
