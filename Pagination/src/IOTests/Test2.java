package IOTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test2 {

	@Test
	void test() {

		String[] args = { "4", "10", "2", "2" };

		Pagination.main(args);

		assertEquals("1 2 3 4 5 6 ... 9 10", Pagination.footer.generatefooter());
	}

}
