package IOTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test4 {

	@Test
	void test() {

		String[] args = { "8", "12", "2", "1" };

		Pagination.main(args);

		assertEquals("1 2 ... 7 8 9 ... 11 12", Pagination.footer.generatefooter());

	}

}
