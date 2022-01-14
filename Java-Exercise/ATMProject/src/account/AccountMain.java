package account;

import java.util.Scanner;

public class AccountMain {
	ATMService atmService = new ATMService();
	Scanner keyboard = new Scanner(System.in);
	/*
	 * @author Than, Rosberg <than.a.nguyen@gmail.com>
	 * Menu with ATM System
	 * */
	public void menuSystem() {
		System.out.println("===========SYSTEM MENU============");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("==================================");

		System.out.print("Enter your option: ");
		int option = keyboard.nextInt();

		switch (option) {
			case 1:
				System.out.print("Account: ");
				String _accountName = keyboard.next().trim();

				System.out.print("Password: ");
				String _password = keyboard.next().trim();

				atmService.login(_accountName, _password);
				break;

			case 2:
				regisHelper();
				break;

			default:
				break;
		}
	}

	public void regisHelper(){
		System.out.print("Account: ");
		String _registerAccountName = keyboard.next().trim();

		System.out.print("Password: ");
		String _registerPassword = keyboard.next().trim();

		System.out.print("Confirm password: ");
		String _confirmRegisterPassword = keyboard.next().trim();

		System.out.print("Amount: ");
		int _amount = keyboard.nextInt();

		if (atmService.checkAccount(_registerAccountName)){
			System.out.println("==> Sorry. Account already in system. Please try again!");
			regisHelper();
		}else if (!_registerPassword.equals(_confirmRegisterPassword) || _registerPassword.equals(_registerAccountName)) {
			System.out.println("==> Sorry. Password invalid. Please try again!");
			regisHelper();
		}else {
			atmService.register(_registerAccountName, _registerPassword, _amount);
		}
	}

	public static void main(String[] args) {
		AccountMain accountMain = new AccountMain();
		accountMain.menuSystem();
	}

}
