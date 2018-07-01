package Pagination;

public class Pagination {
	
	public static Footer footer = new Footer();

	public static void main(String[] args) {		

		footer.setArgs(args);

		if (footer.testInput()) {
			System.out.print(footer.generatefooter());
		} else {
			System.out.println("Please insert the following 4 numbers as arguments");
			System.out.print("Current_page Total_pages Boundaries Around");		
		}

	}

}
