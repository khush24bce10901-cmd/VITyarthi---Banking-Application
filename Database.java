import java.util.HashMap;
import java.util.Map;

public class Database {

    // we have to make them static to make these fields global so that they are permanent

    // our map Key is our userName and our Value is our whole user object
    public static Map<String, User> userDatabase = new HashMap<>();

    // this field is used to track which user is currently logged in
    public static User currentUser = null;
}
