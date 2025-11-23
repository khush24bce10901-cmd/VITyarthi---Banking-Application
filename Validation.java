public class Validation {

    // check if amount to be withdrawn/deposited +ve or not
    public static boolean isPositive(int amount) {

        if (amount > 0) {
            return true;
        } else {
            System.out.println("Amount to be deposited/withdrawn should be positive");
            return false;
        }
    }

    // check if password is valid or not (strong or not)
    public static boolean isValid(String password) {

        // our password should be atleast 8 letters
        if (password.length() >= 8) {
            return true;
        } else {
            System.out.println("Password must be atleast 8 letters");
            return false;
        }
    }
}
