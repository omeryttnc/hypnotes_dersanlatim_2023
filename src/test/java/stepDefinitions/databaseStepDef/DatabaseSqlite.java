package stepDefinitions.databaseStepDef;

import com.github.javafaker.Faker;
import junit.framework.TestCase;

import java.sql.*;

public class DatabaseSqlite extends TestCase {
    /**
     * connection sagliyacagiz
     * statement olusturacagiz
     * ve bu statement gonderecegiz
     */

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;


    public void testConnectionNormalStatement() {
        Faker faker = new Faker();
        String userEmail = faker.internet().emailAddress();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/SqliteDatabase.db");
            statement = connection.createStatement();

            statement.executeUpdate("insert into Users (userId,email) values (null,'" + userEmail + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void testConnectionPreparedStatement() {
        Faker faker = new Faker();
        String userEmail = faker.internet().emailAddress();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/SqliteDatabase.db");

            preparedStatement = connection.prepareStatement("insert into Users values (null,?,?,?)");
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, "userName herhangi bir deger ");
            //   preparedStatement.setString(3,"userLastName");

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void testConnectionPreparedStatement_hataliKullanim() { // soru isareti sadece value ler icin gecerli ? ni column name de kullanamayiz
        Faker faker = new Faker();
        String userEmail = faker.internet().emailAddress();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/SqliteDatabase.db");

            preparedStatement = connection.prepareStatement("insert into Users (?,email,userName,lastName) values (null,?,'omer','ali')");
            preparedStatement.setString(1, "userId");
            preparedStatement.setString(2, "userEmail herhangi bir deger ");
            //   preparedStatement.setString(3,"userLastName");

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void testReadSample() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/SqliteDatabase.db");
        statement = connection.createStatement();

        String sql = "select * from Users order by userId desc";
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()){

            System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));
            System.out.println("resultSet.getString(\"email\") = " + resultSet.getString("email"));
            System.out.println("********************");
        }

    }
}
