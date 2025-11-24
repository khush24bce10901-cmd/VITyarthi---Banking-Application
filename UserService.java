public class Service {

    // user authentication methods

    // to register a user
    public void register(String userName, String password) {

        // 1st we check if user currently exists or not in database(Map)
        if (Database.userDatabase.containsKey(userName)) {
            System.out.println("User already exists");
        }

        User newUser = new User(userName, password);
        Database.userDatabase.put(userName, newUser);
    }

    // to login a user
    public void login(String userName, String password) {

        // 1st we check if user exists in database or not
        User user = Database.userDatabase.get(userName);

        if (user == null) {
            System.out.println("User doesnt exist");
        } else {

            // if user exists we now match the password
            if (user.getPassword().equals(password)) {

                // set user as our current user if our password match
                Database.currentUser = user;
            } else {

                System.out.println("Invalid Password.\nTray again");
            }
        }
    }

    // to logout a user
    public void logout() {

        // we empty the current user
        Database.currentUser = null;
    }


    // bank operation methods

    // to deposit the amount
    public void deposit(int amount) {

        // we only allow if user is logged in
        if (Database.currentUser != null) {

            // get users account and then add the amount
            Database.currentUser.getAccount().deposit(amount);
        } else {
            System.out.println("No user logged in.\nLogin first");
        }
    }

    // to withdraw the amount
    public void withdraw(int amount) {

        // we only allow if user is logged in
        if (Database.currentUser != null) {

            // get users account and then withdraw the amount
            Database.currentUser.getAccount().withdraw(amount);
        } else {
            System.out.println("No user logged in.\nLogin first");
        }
    }

    // get our transaction history
    public void printHistory() {

        // we only allow if user is logged in
        if (Database.currentUser != null) {

            // user details (for proper bank like structure we 1st write thier user name then thier current balance then thier whole history)
            System.out.println("Statement for: " + Database.currentUser.getUserName());
            System.out.println("Current Balance: " + Database.currentUser.getAccount().getBalance());

            // get users account and then get thier transaction history
            for (String transaction : Database.currentUser.getAccount().getTransactionHistory()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("No user logged in.\nLogin first");
        }
    }
}
