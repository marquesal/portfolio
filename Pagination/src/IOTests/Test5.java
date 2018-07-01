package IOTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Pagination.Pagination;

class Test5 {

	@Test
	void test() {
		String[] args = { "8", "13", "0", "0" };

		Pagination.main(args);

		assertEquals("1 ... 8 ... 13", Pagination.footer.generatefooter());
	}

}
