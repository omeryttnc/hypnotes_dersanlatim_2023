package utilities;

import com.github.javafaker.Faker;

public class FakeData {

    private String email,firstName,lastName,fullName,password;

    public FakeData() {
        Faker faker =new Faker();
         email ="test__"+faker.internet().emailAddress().toLowerCase();
         firstName= faker.name().firstName();
         lastName= faker.name().lastName();
         fullName= faker.name().fullName();
         password = faker.internet().password(4,8,true,true,true)+"aA7.";
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
