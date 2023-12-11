package utilities;

import org.junit.Test;

import java.sql.*;

import static utilities.DatabaseUtilities.*;

public class DATABASE {
    private USER_DATABASE userDatabase;

    public USER_DATABASE getUserDatabase() {
        if (userDatabase == null) {
            userDatabase = new USER_DATABASE();
        }
        return userDatabase;
    }
}
