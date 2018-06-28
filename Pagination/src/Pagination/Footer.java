package Pagination;

import java.util.Scanner;

public class Footer {

	private Integer current_page = 0; // página actual
	private Integer total_pages = 0; // total de páginas
	private Integer boundaries = 0; // quantas páginas queremos linkar no início e no fim
	private Integer around = 0; // quantas páginas queremos linkar antes e depois da página atual

	private String[] args;

	public String generatefooter() {

		StringBuilder result = new StringBuilder();

		for (int i = 1; i <= total_pages; i++) {
			if (i <= current_page + boundaries && i <= 1 + around) {
				result.append(i + " ");
			}

			if (i == current_page && around < boundaries) {
				result.append("... ");
				result.append(i);
			}

			if (i <= current_page + boundaries && around >= boundaries && i > 1 + around) {
				result.append(i + " ");

				if (i == (current_page + boundaries)) {
					result.append("...");
				}

			}

			if (i > total_pages - boundaries) {
				result.append(" " + i);
			}
		}

		return result.toString();
	}

	public boolean testInput() {
		if (args.length == 4) {
		current_page = tryParse(args[0]);
		total_pages = tryParse(args[1]);
		boundaries = tryParse(args[2]);
		around = tryParse(args[3]);
		}

		if (current_page != null && total_pages != null && boundaries != null && around != null) {
			return false;
		} else
			return true;
	}

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

	public String[] getArguments() {
		return args;
	}

	public void setArguments(String[] args) {
		this.args = args;
	}

}
