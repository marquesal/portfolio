package IOTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test1 {

	@Test
	void test() {

		String[] args = { "4", "5", "1", "1" };

		Pagination.main(args);

		assertEquals("1 ... 4 5", Pagination.footer.generatefooter());

	}

}
