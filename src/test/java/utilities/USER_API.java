package utilities;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.response;

public class USER_API {

    public RegisteredUserInfo registerUser() {
        Map<String, Object> map = new HashMap<>();
        FakeData fakeData = new FakeData();

        map.put("registration_form[email]", fakeData.getEmail());
        map.put("registration_form[fullname]", fakeData.getFullName());
        map.put("registration_form[plainPassword]", fakeData.getPassword());
        map.put("registration_form[referCode]", false);
        map.put("registration_form[currency]", "GBP");

        response = given()
                .formParams(map)
                .post("/register-api");

        return new RegisteredUserInfo(
                fakeData.getEmail(), fakeData.getFullName(), fakeData.getPassword()
        );
    }
public record RegisteredUserInfo(String email,String fullName,String password){}

}
