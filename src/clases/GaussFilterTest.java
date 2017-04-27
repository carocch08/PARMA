package clases;
import static org.junit.Assert.*;

import org.junit.Test;

public class GaussFilterTest {

	@Test
	public void test() {
		GaussFilter gauss = new GaussFilter();
		gauss.gauss_filter("Celula2.jpg", 0.5);
	}

}
