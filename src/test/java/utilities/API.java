package utilities;

import enums.USER_INFO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.*;
import static stepDefinitions.Hooks.response;

public class API {
    private CLIENTS_API clientsApi;


    public CLIENTS_API getClientsApi() {
        if (clientsApi == null) {
            clientsApi = new CLIENTS_API();
        }
        return clientsApi;
    }

    public API(USER_INFO userInfo) {
        RestAssured.baseURI = "https://" + (userInfo.isTestEnvironment() ? "test." : "") + "hypnotes.net";
        RestAssured.basePath = "/api";
        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("username", userInfo.getEmail());
        mapBody.put("password", userInfo.getPassword());

        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("/login");

        PHPSESSID = response.cookies().get("PHPSESSID");
        csrfToken = response.cookies().get("csrfToken");
    }
}
