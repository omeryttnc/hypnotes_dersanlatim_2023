package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import utilities.API;
import utilities.CLIENTS_API;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.PHPSESSID;
import static stepDefinitions.Hooks.response;

public class ReadBody {
    @Test
    public void readBodyByUsingJsonPath() {
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
                .post("https://test.hypnotes.net/api/dashboard/client/add");
        JsonPath jsonPath = response.jsonPath();
        Assert.assertTrue(jsonPath.getBoolean("success"));
        int createdClientID = jsonPath.getInt("client.id");
        Assert.assertEquals(email, jsonPath.getString("client.email"));
        Assert.assertTrue(jsonPath.getList("client.roles").contains("ROLE_CLIENT"));
        Assert.assertEquals(200, response.statusCode());

    }
    @Test
    public void readBodyByUsingJsonPath_way2() {
        API api = new API(USER_INFO.THERAPIST); // hazirlik asamasini yaptim
        CLIENTS_API.PCreateClientInfo client = api.getClientsApi().createClient(); // client olusturdum

        Assert.assertTrue(client.isSuccessTrue()); // olusan client in assertion ini yaptim
        int createdClientID = client.createdClientId();

        Assert.assertTrue(client.clientsRole().contains("ROLE_CLIENT"));
        Assert.assertEquals(200,client.statusCode());

        api.getClientsApi().deleteClient(createdClientID); // olusan client i sildim

    }
}
