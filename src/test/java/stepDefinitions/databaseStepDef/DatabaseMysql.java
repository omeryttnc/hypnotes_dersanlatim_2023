package stepDefinitions.databaseStepDef;

import enums.USER_INFO;
import junit.framework.TestCase;
import utilities.API;
import utilities.CLIENTS_API;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static utilities.DatabaseUtilities.*;

public class DatabaseMysql extends TestCase {

    public CreatedClient getLastCreatedClient() {
        getConnection();
        CreatedClient createdClient = null;
        Map<String, Object> map = new HashMap<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from `client` order by id desc limit 1");

            while (resultSet.next()) {
                // way 1 with map
                map.put("userID", resultSet.getInt(1));
                map.put("userEmail", resultSet.getString(2));


                // way 2 with record
                createdClient = new CreatedClient(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(8),
                        resultSet.getString(9)

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return createdClient;
    }

    public Map<String, Object> getLastCreatedClient_WithMap() {
        getConnection();
        Map<String, Object> map = new HashMap<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select  * from `client` order by id desc limit 1");

            while (resultSet.next()) {
                // way 1 with map
                map.put("userID", resultSet.getInt(1));
                map.put("userEmail", resultSet.getString(2));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    public record CreatedClient(int userID, String userEmail, String firstName, String lastName) { }


    public class CreatedClient_CLass {
        private int userID;
        private String userEmail,firstName,lastName;

        public CreatedClient_CLass(int userID, String userEmail, String firstName, String lastName) {
            this.userID = userID;
            this.userEmail = userEmail;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int getUserID() {
            return userID;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

//    public void testCreatedClint() {
//        API api = new API(USER_INFO.THERAPIST);
//        CLIENTS_API.PCreateClientInfo client = api.getClientsApi().createClient();
//
//        CreatedClient lastCreatedClient = getLastCreatedClient(); // record
//        Map<String, Object> lastCreatedClientMap = getLastCreatedClient_WithMap();
//        System.out.println("lastCreatedClientMap.get(\"userEmail\") = " + lastCreatedClientMap.get("userEmail"));
//        System.out.println("lastCreatedClient.userEmail() = " + lastCreatedClient.userEmail());
//
//        assertNotSame(client.firstName(), lastCreatedClient.firstName());
//        assertEquals(client.email(), lastCreatedClient.userEmail());
//
//    }

}
