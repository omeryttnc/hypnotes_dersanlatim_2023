package utilities;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static utilities.DatabaseUtilities.*;
import static utilities.DatabaseUtilities.resultSet;

public class USER_DATABASE {
    public UserDatabaseInfo getLastUserInfo() {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select email,id from user order by id desc limit 1");
            resultSet.next();
            return new UserDatabaseInfo(resultSet.getString("email"), resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Object> getLastUserInfo_Map() {
        Map<String, Object> map = new HashMap<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select email,id from user order by id desc limit 1");
            resultSet.next();
            map.put("email", resultSet.getString("email"));
            map.put("id", resultSet.getString("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void activateUser(String email) {
        try {
            String sql = "UPDATE `user` SET `roles` = '[\"ROLE_HYPNOTHERAPIST\",\"ROLE_USER_VERIFIED\"]' WHERE `user`.`email` = '" + email + "';";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public record UserDatabaseInfo(String email, int id) {
    }
}
