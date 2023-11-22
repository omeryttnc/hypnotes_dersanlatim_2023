package utilities;


import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.*;

public class ApiUtilities {
    public static void getToken(String email,String password){
        Map<String,String> mapBody= new HashMap<>();
        mapBody.put("username",email);
        mapBody.put("password",password);

        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("https://test.hypnotes.net/api/login");

        PHPSESSID = response.cookies().get("PHPSESSID");
        csrfToken = response.cookies().get("csrfToken");
    }
}

