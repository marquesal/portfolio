package Pagination;

public class Footer {

	private Integer current_page = 0;
	private Integer total_pages = 0;
	private Integer boundaries = 0; // how many page links we want at the beginning and end
	private Integer around = 0; // how many page links we want before and after current page

	private String[] args;

	/**
	 * Generates the pagination for the footer
	 */
	public String generatefooter() {

		StringBuilder result = new StringBuilder();

		for (int i = 1; i <= total_pages; i++) {

			if (i == total_pages) {
				result.append(i);
			} else
				result.append(i + " ");

			// Break in sequence before current page
			if (i >= boundaries && i < current_page - around - 1) {

				result.append("... ");

				while (i >= boundaries && i < current_page - around - 1) {
					i++;
					// Corner-case
					if (total_pages - boundaries == current_page)
						i++;
				}
			}

			// Break in sequence after current page
			if (i >= current_page + around && i < total_pages - boundaries) {

				result.append("... ");

				while (i >= current_page + around && i < total_pages - boundaries) {
					// Corner-case
					if (i + 1 == total_pages + boundaries)
						break;
					i++;
				}
			}
		}
		return result.toString();
	}

	/**
	 * The input must be tested for valid arguments that the program can accept
	 */
	public boolean testInput() {
		if (args.length == 4) {
			current_page = tryParse(args[0]);
			total_pages = tryParse(args[1]);
			boundaries = tryParse(args[2]);
			around = tryParse(args[3]);
		}

		if (current_page == null) {
			System.out.println("Current page (1st argument) must be a number.");
			return false;
		}

		if (total_pages == null) {
			System.out.println("Total_pages (2nd argument) must be a number.");
			return false;
		}

		if (boundaries == null) {
			System.out.println("Boundaries (3rd argument) must be a number.");
			return false;
		}

		if (around == null) {
			System.out.println("Around (4th argument) must be a number.");
			return false;
		}

		if (current_page == 0) {
			System.out.println("Current page must be at least 1.");
			return false;
		}

		if (current_page > total_pages) {
			System.out.println("Current page must be smaller or equal to total number of pages.");
			return false;
		}

		return true;
	}

	/**
	 * Tries to parse the input string to Integer numbers
	 */
	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	// ======= Getter and Setters ======= //

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public int getBoundaries() {
		return boundaries;
	}

	public void setBoundaries(int boundaries) {
		this.boundaries = boundaries;
	}

	public int getAround() {
		return around;
	}

	public void setAround(int around) {
		this.around = around;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

}
