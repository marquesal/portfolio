package IOTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test3 {

	@Test
	void test() {
		String[] args = { "1", "3", "1", "1" };

		Pagination.main(args);

		assertEquals("1 2 3", Pagination.footer.generatefooter());
	}

}
