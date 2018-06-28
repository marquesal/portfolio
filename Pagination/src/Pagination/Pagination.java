package Pagination;

public class Pagination {
	
	public static void main(String[] args) {
		
		Footer footer = new Footer();
		
		footer.setArguments(args);
		
		if (footer.testInput()) {
			System.out.println("Please insert 4 numeric params:");
			System.out.print("Current_page Total_pages Boundaries Around");		
		} else 
			
		System.out.print(footer.generatefooter());

	}

}
