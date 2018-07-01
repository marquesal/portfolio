package IOTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test7 {

	@Test
	void test() {
		String[] args = { "12", "25", "2", "2" };

		Pagination.main(args);

		assertEquals("1 2 ... 10 11 12 13 14 ... 24 25", Pagination.footer.generatefooter());
	}

}
