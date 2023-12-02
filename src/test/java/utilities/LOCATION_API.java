package utilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.*;

public class LOCATION_API {
    private Map<String, Object> requestBody = new HashMap<>();
    private int locationId;
public int addLocation(String addressTitle,String address, String zipcode, String timeZone){
    requestBody.put("addressTitle", addressTitle);
    requestBody.put("address", address);
    requestBody.put("zipCode", zipcode);
    requestBody.put("timeZone", timeZone);

    response = given()
            .header("cookie", "PHPSESSID=" + PHPSESSID)
            // .contentType(ContentType.URLENC)
            .formParams(requestBody)
            .post("https://test.hypnotes.net/api/settings/location/add");

return locationId = response.jsonPath().getInt("locationInfo.id");
}



public void deleteLocation(int locationId){
    requestBody.put("id", locationId);

    response = given()
            .header("cookie", "PHPSESSID=" + PHPSESSID)
            // .contentType(ContentType.URLENC)
            .formParams(requestBody)
            .post("https://test.hypnotes.net/api/settings/location/delete");

}

public void getLocation(){
    response=given()
            .header("cookie","PHPSESSID="+PHPSESSID)
            .post("https://test.hypnotes.net/api/dashboard/getUser");

}

public void updateLocation(int locationId,String updatedAddressTitle, String updatedAddress,String updatedZipcode){
    requestBody.put("id",locationId);
    requestBody.put("addressTitle", updatedAddressTitle);
    requestBody.put("address", updatedAddress);
    requestBody.put("zipCode", updatedZipcode);
    requestBody.put("timeZone", "Turkey Standard Time");


    response = given()
            .header("cookie","PHPSESSID="+PHPSESSID)
            // .contentType(ContentType.URLENC)
            .formParams(requestBody)
            .post("https://test.hypnotes.net/api/settings/location/update");

}
}
