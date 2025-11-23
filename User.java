public class User {

    // we make these fields private so that other class dont access them
    private String userName;
    private String password;

    // we connect our account and user class as every user has an account
    private Account account;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.account = new Account();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
