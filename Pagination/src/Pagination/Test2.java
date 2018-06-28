package Pagination;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void test() {

		String[] args = { "4", "10", "2", "2" };

		Footer footer = new Footer();
		
		footer.setArguments(args);

		String result = footer.generatefooter();

		assertEquals("1 2 3 4 5 6 ... 9 10", result);
	}

}
