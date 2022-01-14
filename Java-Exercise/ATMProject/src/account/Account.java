package account;

public class Account {
	private String accountName;
	private String password;
	private int balance;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountName, String password, int balance) {
		this.accountName = accountName;
		this.password = password;
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
