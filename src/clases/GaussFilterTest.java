package clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class GaussFilterTest {

	@Test
	public void test() {
		GaussFilter gauss = new GaussFilter();
		gauss.gaussian_filter("Celula.PNG", 0.5);
	}

}
