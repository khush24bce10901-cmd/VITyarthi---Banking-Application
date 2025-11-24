import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // to get input from user
        Scanner sc = new Scanner(System.in);

        UserService bankService = new UserService();
        SettingService settingService = new SettingService();

        System.out.println("Welcome to our Bank!!");

        while (true) {
            System.out.println("1 Register\n2 Login\n3 Deposit\n4 Withdraw\n5 History\n");
            System.out.println("6 Change Username\n7 Change Password\n8 Delete Account\n9 Logout");
            System.out.println("Enter choice");
            int choice = sc.nextInt();

            // 1: Register
            if (choice == 1) {

                // ask for credentials
                System.out.println("Enter username: ");
                String username = sc.next();
                System.out.println("Enter password");
                String password = sc.next();

                // check if password is valid or not
                if (Validation.isValid(password)) {

                    // if yes we register the user
                    bankService.register(username, password);
                    System.out.println("\nUser Registered\n");
                }
            } else if (choice == 2) { // 2: Login

                // ask for credentials
                System.out.println("Enter username: ");
                String username = sc.next();
                System.out.println("Enter password");
                String password = sc.next();

                // login the user
                bankService.login(username, password);
                System.out.println("\nUser Logged In\n");
            } else if (choice == 3) { // 3: Deposit

                // ask for amount
                System.out.println("Enter amount to deposit: ");
                int amt = sc.nextInt();

                // deposit
                bankService.deposit(amt);
            } else if (choice == 4) { // 4: Withdraw

                // ask for amount
                System.out.println("Enter amount to withdraw: ");
                int amt = sc.nextInt();

                // withdraw
                bankService.withdraw(amt);
            } else if (choice == 5) { // 5: History

                // get Transactional History
                bankService.printHistory();
            } else if (choice == 6) { // 6: Change Username

                // change username
                settingService.changeUserName();
            } else if (choice == 7) { // 7: Change Password

                // change password
                settingService.changePassword();
            } else if (choice == 8) { // 8: Delete Account

                // delete account
                settingService.delete();
                break;
            } else if (choice == 9) { // 9: Logout

                // logout
                bankService.logout();
                System.out.println("Thankyou");
                break;
            } else {

                System.out.println("Invalid Choice. Try Again");
            }
        }
    }
}
