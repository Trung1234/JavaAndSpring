package book;

import java.util.Scanner;

public class BookHelper {
	public int action_Update;
	Scanner keyboard = new Scanner(System.in);

	public void inputBookUpdate(Book input_Book_Update) {
		if (action_Update != 1 && action_Update != 2 && action_Update != 3) {
			System.out.print("Enter Id: ");
			String id = keyboard.nextLine();
			input_Book_Update.setId(id);
		}

		if (action_Update == 1 || action_Update == 3) {
			System.out.print("Enter Name: ");
			String name = keyboard.nextLine();
			input_Book_Update.setName(name);
		}

		if (action_Update == 2 || action_Update == 3) {
			System.out.print("Enter Price: ");
			int price = Integer.parseInt(keyboard.nextLine().trim());
			input_Book_Update.setPrice(price);
		}
	}

	public void option_Update(Book book_Helper) {
		System.out.println("++++++++++EDIT OPTION+++++++++++");
		System.out.println("1. Edit book name only          ");
		System.out.println("2. Edit book price only         ");
		System.out.println("3. Edit both book name and price");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.print("Your edit option: ");
		action_Update = Integer.parseInt(keyboard.nextLine().trim());
		switch (action_Update) {
		case 1:
			inputBookUpdate(book_Helper);
			break;
		case 2:
			inputBookUpdate(book_Helper);
			break;
		case 3:
			inputBookUpdate(book_Helper);
			break;
		default:
			break;
		}
	}
}
