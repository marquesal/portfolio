package Pagination;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test1 {

	@Test
	void test() {

		String[] args = { "4", "5", "1", "0" };
		
		Footer footer = new Footer();
		
		footer.setArguments(args);

		String result = footer.generatefooter();

		System.out.print(result);

		assertEquals("1 ... 4 5", result);
	}

}
