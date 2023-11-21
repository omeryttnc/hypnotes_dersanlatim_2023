package utilities;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.PHPSESSID;
import static stepDefinitions.Hooks.response;

public class CLIENTS_API {
    @Test
    public void createClientString() {
        API api = new API(USER_INFO.THERAPIST);
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress().toLowerCase();

        response = given()
                .contentType(ContentType.URLENC)
                .header("cookie", "PHPSESSID=" + PHPSESSID)
                .body(
                        "firstName=" + firstName +
                                "&lastName=" + lastName +
                                "&email=" + email +
                                "&timezone=Europe/London"
                )
                .post("/dashboard/client/add");


    }


    public PCreateClientInfo createClient() {
        API api = new API(USER_INFO.THERAPIST);
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress().toLowerCase();
        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("firstName", firstName);
        mapBody.put("lastName", lastName);
        mapBody.put("email", email);
        mapBody.put("timezone", "Europe/London");

        response = given()
                .header("cookie", "PHPSESSID=" + PHPSESSID)
                .formParams(mapBody)
                .post("/dashboard/client/add");
        JsonPath jsonPath = response.jsonPath();

        return new PCreateClientInfo(
                jsonPath.getBoolean("success"),
                jsonPath.getInt("client.id"),
                jsonPath.getString("client.email"),
                jsonPath.getList("client.roles"),
                response.statusCode()
        );

    }

    // Hamcrest Matchers kullanarak delete yapildi
    public void deleteClient(int clientId) {
        given()
                .contentType(ContentType.URLENC)
                .header("cookie", "PHPSESSID=" + PHPSESSID)
                .body("clientId=" + clientId)
                .when()
                .post("/dashboard/client/delete")
                .then()
                .statusCode(200)
                .body("success",Matchers.is(true))
                .body("success",Matchers.not(false))
                .body("success",Matchers.notNullValue())
                .body("descr",Matchers.equalTo("Client deleted"))
                .header("content-type","application/json");
    }

    public record PCreateClientInfo(boolean isSuccessTrue, int createdClientId, String email, List<String> clientsRole,
                                    int statusCode) {
    }
}
