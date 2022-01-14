package account;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMService {
    ArrayList<Account> accountList = new ArrayList<>();

    public static final int ONE = 100;
    public static final int TWO = 1000;
    public static final int THREE = 200;
    public static final int FOUR = 2000;
    public static final int FIVE = 500;
    public static final int SIX = 5000;

    Scanner keyboard = new Scanner(System.in);

    public ATMService() {
        Account _account1 = new Account("a", "1", 100);
        Account _account2 = new Account("b", "2", 200);
        Account _account3 = new Account("c", "3", 300);
        accountList.add(_account1);
        accountList.add(_account2);
        accountList.add(_account3);
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> Login to ATM System
     */
    public void login(String _accountName, String _password) {
        int count = 0;
        for (Account account : accountList) {
            if (account.getAccountName().equals(_accountName) && account.getPassword().equals(_password)) {
                System.out.println("==> Login succesful");
                atmServices(_accountName);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Login failured. Account or Password is invalid!");
            System.out.println("Please try again!");

            System.out.print("Account: ");
            String _againAccountName = keyboard.nextLine().trim();

            System.out.print("Password: ");
            String _againPassword = keyboard.nextLine().trim();

            login(_againAccountName, _againPassword);
        }
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> View Balance
     */
    public void register(String _accountName, String _passWord, int _amount){
        if (_amount < 50) {
            System.out.println("==> Sorry. Amount must be than more 50 $. Please try again!");
            AccountMain accountMain = new AccountMain();
            accountMain.regisHelper();
        }else {
            Account account = new Account(_accountName, _passWord, _amount);
            accountList.add(account);
            System.out.println("==> Register successful");
            atmServices(_accountName);
        }
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> View Balance
     */
    public void viewBalance(String _accountName) {
        for (Account account : accountList) {
            if (account.getAccountName().equals(_accountName)) {
                System.out.println("==> Your balance is: " + account.getBalance() + " $");
                yesno(_accountName);
            }
        }
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> Cash Withdrawval
     */
    public void cashWithDrawval(String _accountName, int _amount) {
        int _newBalance = 0;
        if (_amount < 50) {
            System.out.println("==> Sorry. Amount must be than more 50");
            yesno(_accountName);
        } else {
            for (Account account : accountList) {
                if (account.getAccountName().equals(_accountName)) {
                    if (_amount < account.getBalance()) {
                        _newBalance = account.getBalance() - _amount;
                        account.setBalance(_newBalance);
                        System.out.println("Please waiting a minutes!");
                        System.out.println("............");
                        System.out.println("You are received: " + _amount + " $");

                        yesno(_accountName);
                    } else {
                        System.out.println("==> Sorry. Your balance not enough!");
                        yesno(_accountName);
                    }
                }
            }
        }
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> Deposit
     */
    public void deposit(String _accountName, int _amount) {
        int _newBalance = 0;
        if (_amount < 50) {
            System.out.println("==> Sorry. Amount must be than more 50 $");
            yesno(_accountName);
        }
        for (Account account : accountList) {
            if (account.getAccountName().equals(_accountName)) {
                _newBalance = account.getBalance() + _amount;
                account.setBalance(_newBalance);

                System.out.println("==> Deposit successful");
                yesno(_accountName);
            }
        }
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> Transfer
     */
    public void transfer(String _sendAccountName, String _receiveAccountName, int _amount) {
        int _newBalanceSendAccount = 0;
        int _newBalanceReceiveAccount = 0;

        if (_amount < 50) {
            System.out.println("==> Sorry. Amount must be than more 50 $");
            yesno(_sendAccountName);
        }
        for (Account sendAccount : accountList) {
            if (sendAccount.getAccountName().equals(_sendAccountName)) {
                if (_amount >= sendAccount.getBalance()) {
                    System.out.println("==> Sorry. Amount not enough");
                    yesno(_sendAccountName);
                } else {
                    _newBalanceSendAccount = sendAccount.getBalance() - _amount;
                    sendAccount.setBalance(_newBalanceSendAccount);
                    for (Account receiveAccount : accountList) {
                        if (receiveAccount.getAccountName().equals(_receiveAccountName)) {
                            _newBalanceReceiveAccount = receiveAccount.getBalance() + _amount;
                            receiveAccount.setBalance(_newBalanceReceiveAccount);
                            System.out.println("==> Transfer successful");
                            System.out.println("You are transfered to account " + receiveAccount.getAccountName() + " " + _amount + " $");
                            yesno(_sendAccountName);
                        }
                    }
                }
            }
        }
    }

    public void changePassword(String _accountName, String _password) {
        System.out.print("Enter new password: ");
        String _newPassword = keyboard.next().trim();

        System.out.print("Enter confirm password: ");
        String _confirmPassword = keyboard.next().trim();

        for (Account account : accountList) {
            if (account.getAccountName().equals(_accountName)) {
                if (!account.getPassword().equals(_password)) {
                    System.out.println("==> Sorry. Password invalid");
                    yesno(_accountName);
                } else if (_confirmPassword.equals(_newPassword)) {
                    System.out.println("==> Change password successful");
                    account.setPassword(_newPassword);
                    yesno(_accountName);
                } else {
                    System.out.println("==> Sorry. Password invalid");
                    yesno(_accountName);
                }
            }
        }
    }

    public boolean checkAccount(String _accountName) {
        for (Account account : accountList) {
            if (account.getAccountName().equals(_accountName)) {
                return true;
            }
        }
        return false;
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> ATM Service
     */
    public void atmServices(String _accountName) {
        System.out.println("===================ATM SERVICES==================");
        System.out.println("1. Cash Withdrawval            4. Deposit");
        System.out.println("2. View Balance                5. Transfer");
        System.out.println("3. Change Password             6. Cancel");
        System.out.println("=================================================");

        System.out.print("Enter your option: ");
        int _optionService = keyboard.nextInt();

        switch (_optionService) {
            case 1:
                optionAmountHelper(_accountName, _optionService);
                break;

            case 2:
                viewBalance(_accountName);
                break;

            case 3:
                System.out.print("Enter old password: ");
                String _oldPassword = keyboard.next().trim();
                changePassword(_accountName, _oldPassword);
                break;

            case 4:
                optionAmountHelper(_accountName, _optionService);
                break;

            case 5:
                bankName(_accountName);
                break;

            default:
                System.out.println("==> Thank you for using Vietcom Bank service");
                return;
        }
    }

    /*
     * @author: Than, Rosberg <than.rosberg@gmail.com> Yes/No option
     */
    public void yesno(String _accountName) {
        System.out.println("Do you want continues uses ATM Service?");
        System.out.println("Press Y to continues or N to cancel");
        System.out.print("Enter your option: ");
        String _YorN = keyboard.next().trim();

        if (_YorN.equals("y")) {
            atmServices(_accountName);
        } else {
            System.out.println("==> Thank you for using Vietcom Bank service");
            return;
        }
    }

    public void optionAmountHelper(String _accountName, int _optionService) {
        System.out.println("1. 100      2. 1,000");
        System.out.println("3. 200      4. 2,000");
        System.out.println("5. 500      6. 5,000");
        System.out.println("7. Other    8. Cancel");

        System.out.print("Enter your option: ");
        int _optionAmount = keyboard.nextInt();

        switch (_optionAmount) {
            case 1:
                _optionAmount = ONE;
                optionServiceHelper(_accountName, _optionService, _optionAmount);
                break;

            case 2:
                _optionAmount = TWO;
                optionServiceHelper(_accountName, _optionService, _optionAmount);
                break;

            case 3:
                _optionAmount = THREE;
                optionServiceHelper(_accountName, _optionService, _optionAmount);
                break;

            case 4:
                _optionAmount = FOUR;
                optionServiceHelper(_accountName, _optionService, _optionAmount);
                break;

            case 5:
                _optionAmount = FIVE;
                optionServiceHelper(_accountName, _optionService, _optionAmount);
                break;

            case 6:
                _optionAmount = SIX;
                optionServiceHelper(_accountName, _optionService, _optionAmount);
                break;

            case 7:
                System.out.print("Enters Amount: ");
                int _amount = keyboard.nextInt();
                optionServiceHelper(_accountName, _optionService, _amount);
                break;

            default:
                yesno(_accountName);
        }
    }

    public void optionServiceHelper(String _accountName, int _optionService, int _optionAmount) {
        if (_optionService == 1){
            cashWithDrawval(_accountName, _optionAmount);
        }else if (_optionService == 4) {
            deposit(_accountName, _optionAmount);
        }
    }

    public void bankName(String _accountName) {
        System.out.println("1. Vietcom Bank        2. Vietin Bank");
        System.out.println("3. Sacom Bank          4. Dong A Bank");
        System.out.println("5. Agribank            6. ACB Bank");
        System.out.println("7. Exim Bank           8. Cancel");

        System.out.print("Enter your option: ");
        int _optionBankName = keyboard.nextInt();

        if (_optionBankName >= 1 && _optionBankName <= 7) {
            System.out.print("Enter receive account: ");
            String _receiveAccountName = keyboard.next().trim();

            if (_receiveAccountName.equals(_accountName)) {
                System.out.println("==> Sorry. Account name invalid");
                yesno(_accountName);
            } else if (checkAccount(_receiveAccountName)) {
                optionAmountTransferHelper(_accountName, _receiveAccountName, _optionBankName);
            }
        } else {
            yesno(_accountName);
        }
    }

    public void optionAmountTransferHelper(String _accountName, String _receiveAccountName, int _optionBankName) {
        System.out.println("1. 100      2. 1,000");
        System.out.println("3. 200      4. 2,000");
        System.out.println("5. 500      6. 5,000");
        System.out.println("7. Other    8. Cancel");

        System.out.print("Enter your option: ");
        int _optionAmount = keyboard.nextInt();

        switch (_optionAmount) {
            case 1:
                _optionAmount = ONE;
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _optionAmount);
                break;

            case 2:
                _optionAmount = TWO;
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _optionAmount);
                break;

            case 3:
                _optionAmount = THREE;
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _optionAmount);
                break;

            case 4:
                _optionAmount = FOUR;
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _optionAmount);
                break;

            case 5:
                _optionAmount = FIVE;
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _optionAmount);
                break;

            case 6:
                _optionAmount = SIX;
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _optionAmount);
                break;

            case 7:
                System.out.print("Enters Amount: ");
                int _amount = keyboard.nextInt();
                transferHelper(_accountName, _receiveAccountName, _optionBankName, _amount);
                break;

            default:
                yesno(_accountName);
        }
    }

    public void transferHelper(String _sendAccountName, String _receiveAccountName, int _optionBankName, int _amount){
        int _newBalance;
        System.out.println("==> Do you want to transfer to " + "'" + _receiveAccountName + "'" + " account");
        System.out.println("Press Y to continue or N to previous");
        System.out.print("Enter your option: ");

        String _option = keyboard.next().trim();
        if (_option.equals("y")) {
            if (_optionBankName == 1) {
                if (_amount == 7) {
                    transfer(_sendAccountName, _receiveAccountName, _amount);
                } else {
                    transfer(_sendAccountName, _receiveAccountName, _amount);
                }
            } else {
                for (Account account : accountList) {
                    if (account.getAccountName().equals(_sendAccountName)) {
                        _newBalance = account.getBalance() - 30;
                        account.setBalance(_newBalance);
                        System.out.println("=======" + _newBalance);

                        if (_amount == 7) {
                            transfer(_sendAccountName, _receiveAccountName, _amount);
                        } else {
                            transfer(_sendAccountName, _receiveAccountName, _amount);
                        }
                    }
                }
            }
        } else {
            yesno(_sendAccountName);
        }
    }
}