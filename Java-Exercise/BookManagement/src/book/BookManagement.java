package book;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookManagement {
	public int action_Update;
	ArrayList<Book> book_List = new ArrayList<>();
	Scanner keyboard = new Scanner(System.in);

	// Enters Book's information
	public void inputBook(Book input_Book) {
		System.out.print("Enter Id: ");
		String id = keyboard.nextLine();
		input_Book.setId(id);

		System.out.print("Enter Name: ");
		String name = keyboard.nextLine();
		input_Book.setName(name);		

		System.out.print("Enter Price: ");
		int price = Integer.parseInt(keyboard.nextLine().trim());
		input_Book.setPrice(price);
	}

	public String outputBook(Book out_Book) {
		return "[ID = " + out_Book.getId() + ", Name = " + out_Book.getName() + ", Price = " + out_Book.getPrice()
				+ "]";
	}

	// Add Book's information into book list
	public void addBook() {
		Book add_Book = new Book();
		inputBook(add_Book);
		book_List.add(add_Book);
	}

	// Display all of book in the book list
	public void displayAllOfBook() {
		int book_Numerical = 0;
		if (!book_List.isEmpty()) {
			for (Book display_Book : book_List) {
				System.out.println("Book " + ++book_Numerical + ": " + outputBook(display_Book));
			}
		} else {
			System.out.println("Not found book. Please add book!");
			addBook();
		}

		System.out.println("Total Book in list: " + book_List.size());
	}

	// Find book by ID
	public void findBookById(String id) {
		int count_ID = 0;
		int book_Numerical_Id = 0;
		for (Book book_Find_Id : book_List) {
			if (book_Find_Id.getId().equalsIgnoreCase(id)) {
				for (Book book_ID : book_List) {
					if (book_ID.getId().equalsIgnoreCase(id)) {
						System.out.println("Book " + ++book_Numerical_Id + ": " + outputBook(book_ID));
						count_ID++;
					}
				}
				break;
			}
		}
		System.out.println("Total book has ID " + id + " is: " + book_Numerical_Id);

		if (count_ID == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need find: ");
			String id_Again = keyboard.nextLine();
			findBookById(id_Again);
		}
	}

	// Find book by Name
	public void findBookByName(String name) {
		int count_Name = 0;
		int book_Numerical_Name = 0;
		for (Book book_Find_Name : book_List) {
			if (book_Find_Name.getName().equalsIgnoreCase(name)) {
				for (Book book_Name : book_List) {
					if (book_Name.getName().equalsIgnoreCase(name)) {
						System.out.println("Book " + ++book_Numerical_Name + ": " + outputBook(book_Name));
						count_Name++;
					}
				}
				break;
			}
		}
		System.out.println("Total book has ID " + name + " is: " + book_Numerical_Name);

		if (count_Name == 0) {
			System.out.println("Not found book name. Pease try again!");
			System.out.print("Enter Name need find: ");
			String name_Again = keyboard.nextLine();
			findBookById(name_Again);
		}
	}

	// Edit book by ID
	public void editBookById(String id) {
		BookHelper object_Book_Helper = new BookHelper();
		int count_Edit_ID = 0;
		for (Book book_Edit_Id : book_List) {
			if (book_Edit_Id.getId().equalsIgnoreCase(id)) {
				for (Book book_Id : book_List) {
					if (book_Id.getId().equalsIgnoreCase(id)) {
						object_Book_Helper.option_Update(book_Id);
						count_Edit_ID++;
						System.out.println("******Book information after edit*******");
						System.out.println(outputBook(book_Id));
					}
				}
				break;
			}
		}

		if (count_Edit_ID == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need edit: ");
			String id_Edit_Again = keyboard.nextLine();
			editBookById(id_Edit_Again);
		}
	}

	// Edit book by Name
	public void editBookByName(String name) {
		BookHelper object_Book_Helper = new BookHelper();
		int count_Edit_Name = 0;
		for (Book book_Edit_Name : book_List) {
			if (book_Edit_Name.getName().equalsIgnoreCase(name)) {
				for (Book book_Name : book_List) {
					if (book_Name.getName().equalsIgnoreCase(name)) {
						object_Book_Helper.option_Update(book_Name);
						count_Edit_Name++;
						System.out.println("******Book information after edit*******");
						System.out.println(outputBook(book_Edit_Name));
						break;
					}
				}
				break;
			}
		}

		if (count_Edit_Name == 0) {
			System.out.println("Not found book id. Pease try again!");
			System.out.print("Enter ID need edit: ");
			String name_Edit_Again = keyboard.nextLine();
			findBookById(name_Edit_Again);
		}
	}

	// Remove book by ID
	public void removeBookById(String id) {
		/*
		 * THIS is 1 WAY: int count_Remove_ID = 0; for (Book book_Remove_Id : book_List)
		 * { if (book_Remove_Id.getId().equalsIgnoreCase(id)) { for (Book book_Id :
		 * book_List) { if (book_Id.getId().equalsIgnoreCase(id)) { count_Remove_ID++; }
		 * }
		 * 
		 * book_List.remove(book_Remove_Id); } } if (count_Remove_ID == 0) {
		 * System.out.println("Not found book ID. Pease try again!");
		 * System.out.print("Enter ID need remove: "); String id_Remove_Again =
		 * keyboard.nextLine(); removeBookById(id_Remove_Again); }
		 */

		// Note: If uses 1 way to remove then have exception Current...Exception

		// THIS is 2 WAY
		if (book_List.removeIf(book_Id_Remove -> book_Id_Remove.getId().equalsIgnoreCase(id))) {
			System.out.println("Book has ID " + id + " is removed succesfull");
			System.out.println("******Book information after remove*******");
			displayAllOfBook();
		} else {
			System.out.println("Not found book ID. Pease try again!");
			System.out.print("Enter ID need remove: ");
			String id_Remove_Again = keyboard.nextLine();
			removeBookById(id_Remove_Again);
		}
	}

	// Remove book by Name
	public void removeBookByName(String name) {
		// THIS is 1 way
		/*
		 * int count_Remove_Name = 0;
		 * 
		 * for (Book book_Remove_Name : book_List) { if
		 * (book_Remove_Name.getName().equalsIgnoreCase(name)) { for (Book book_Name :
		 * book_List) { if (book_Name.getName().equalsIgnoreCase(name)) {
		 * book_List.remove(book_Name); count_Remove_Name++; } } } }
		 * 
		 * System.out.println("******Book information after remove*******");
		 * displayAllOfBook();
		 * 
		 * if (count_Remove_Name == 0) {
		 * System.out.println("Not found book Name. Pease try again!");
		 * System.out.print("Enter Name need remove: "); String name_Remove_Again =
		 * keyboard.nextLine(); removeBookByName(name_Remove_Again); }
		 */

		// Note: If uses 1 way to remove then have exception Current...Exception

		// THIS is 2 WAY
		if (book_List.removeIf(book_Name_Remove -> book_Name_Remove.getName().equalsIgnoreCase(name))) {
			System.out.println("Book has Name " + name + " is removed succesfull");
			System.out.println("******Book information after remove*******");
			displayAllOfBook();
		} else {
			System.out.println("Not found book Name. Pease try again!");
			System.out.print("Enter Name need remove: ");
			String name_Remove_Again = keyboard.nextLine();
			removeBookByName(name_Remove_Again);
		}
	}

	// Display Book has maximum Price
	public void displayBookMaxPrice() {
		int book_Numerical_Max_Price = 0;
		int count_Book_Max_Price = 0;
		// THIS is 1 way
		Book max_Price = book_List.get(0);
		for (int i = 1; i <= book_List.size() - 1; i++) {
			if (max_Price.getPrice() <= book_List.get(i).getPrice()) {
				max_Price = book_List.get(i);
				System.out.println("Book " + ++book_Numerical_Max_Price + ": " + outputBook(max_Price));
				count_Book_Max_Price++;
			}
		}
		System.out.println("Total book in list is: " + count_Book_Max_Price);
		
		
		// THIS 2 WAY: Using Lamda Expression. However, this method get only one element
		 	/*book_List.sort((a, b) -> a.getPrice() - b.getPrice());
		  	System.out.println("Book " + ++book_Numerical_Max_Price + ": " + outputBook(book_List.get(i)));*/
	}

	// Display Book has minimum Price. Still not finish
	public void displayBookMinPrice() {
		int book_Numerical_Min_Price = 0;
		int count_Book_Min_Price = 0;
		// THIS is 1 way
		Book min_Price = book_List.get(0);
		for (int i = 0; i <= book_List.size() - 1; i++) {
			if (min_Price.getPrice() >= book_List.get(i).getPrice()) {
				min_Price = book_List.get(i);
				System.out.println("Book " + ++book_Numerical_Min_Price + ": " + outputBook(min_Price));
				count_Book_Min_Price++;
			}
		}
		System.out.println("Total book in list is: " + count_Book_Min_Price);

		// THIS 2 WAY: Using Lamda Expression. However, this method get only one element
		/*book_List.sort((a, b) -> b.getPrice() - a.getPrice());
		System.out.println("Book " + ++book_Numerical_Min_Price + ": " + outputBook(book_List.get(book_List.size() - 1)));*/
	}

	// Display book has middle Prices between min price and max price
	public void displayBookMiddlePrice() {
		int book_Numerical_Middle_Price = 0;
		book_List.sort((a, b) -> a.getPrice() - b.getPrice());
		for (int i = 1; i < book_List.size() - 1; i++) {
			System.out.println("Book " + ++book_Numerical_Middle_Price + ": " + outputBook(book_List.get(i)));
		}
	}

	// Display book by sort ID A - Z
	public void sortBookIdAtoZ() {
		int book_Numerical_Id_AZ = 0;
		int count = 0;
		book_List.sort((book_ID_AZ1, book_ID_AZ2) -> book_ID_AZ1.getId().compareTo(book_ID_AZ2.getId()));
		for (Book book_Sort_ID_AZ : book_List) {
			System.out.println("Book " + ++book_Numerical_Id_AZ + ": " + outputBook(book_Sort_ID_AZ));
		}
		if (count != book_List.size()) {
			System.out.println("Total book in list is: " + book_List.get(book_List.size() - count));
		}
	}

	// Display book by sort ID Z - A
	public void sortBookIdZtoA() {
		int book_Numerical_Id_ZA = 0;
		book_List.sort((book_ID_ZA1, book_ID_ZA2) -> book_ID_ZA2.getId().compareTo(book_ID_ZA1.getId()));
		for (Book book_Sort_ID_AZ : book_List) {
			System.out.println("Book " + ++book_Numerical_Id_ZA + ": " + outputBook(book_Sort_ID_AZ));
		}
		System.out.println("Total book in list is: " + book_List.size());
	}

	// Display book by sort ID A - Z
	public void sortBookNameAtoZ() {
		int book_Numerical_Name_AZ = 0;
		book_List.sort((book_Name_AZ1, book_Name_AZ2) -> book_Name_AZ1.getName().compareTo(book_Name_AZ2.getName()));
		for (Book book_Sort_Name_AZ : book_List) {
			System.out.println("Book " + ++book_Numerical_Name_AZ + ": " + outputBook(book_Sort_Name_AZ));
		}
		System.out.println("Total book in list is: " + book_List.size());
	}

	// Display book by sort ID Z - A
	public void sortBookNameZtoA() {
		int book_Numerical_Name_ZA = 0;
		book_List.sort((book_Name_AZ1, book_Name_AZ2) -> book_Name_AZ2.getName().compareTo(book_Name_AZ1.getName()));
		for (Book book_Sort_Name_ZA : book_List) {
			System.out.println("Book " + ++book_Numerical_Name_ZA + ": " + outputBook(book_Sort_Name_ZA));
		}
		System.out.println("Total book in list is: " + book_List.size());
	}

	// Display book by sort Price Low - High
	public void sortBookPriceLowToHigh() {
		int book_Numerical_Price_LH = 0;
		Collections.sort(book_List,
				(book_Price_LH1, book_Price_LH2) -> (book_Price_LH1.getPrice() - book_Price_LH2.getPrice()));
		for (Book book_Sort_Price_LH : book_List) {
			System.out.println("Book " + ++book_Numerical_Price_LH + ": " + outputBook(book_Sort_Price_LH));
		}
		System.out.println("Total book in list is: " + book_List.size());
	}

	// Display book by sort Price High - Low
	public void sortBookPriceHighToLow() {
		int book_Numerical_Price_HL = 0;
		Collections.sort(book_List,
				(book_Price_HL1, book_Price_HL2) -> (book_Price_HL2.getPrice() - book_Price_HL1.getPrice()));
		for (Book book_Sort_Price_HL : book_List) {
			System.out.println("Book " + ++book_Numerical_Price_HL + ": " + outputBook(book_Sort_Price_HL));
		}
		System.out.println("Total book in list is: " + book_List.size());
	}

	// Write book.txt file
	String fileName = "book.txt";

	public void writeBookFile() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(book_List);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void readBookFile() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			book_List = (ArrayList<Book>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}