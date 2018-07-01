package IOTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test6 {

	@Test
	void test() {
		String[] args = { "5", "9", "2", "2" };

		Pagination.main(args);

		assertEquals("1 2 3 4 5 6 7 8 9", Pagination.footer.generatefooter());
	}

}
