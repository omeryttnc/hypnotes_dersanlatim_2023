package stepDefinitions.databaseStepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import utilities.*;

import java.util.Map;

public class week8 {
 private String email;
    @When("we create user from API")
    public void weCreateUserFromAPI() {
        API api = new API(true);
        USER_API.RegisteredUserInfo registeredUserInfo = api.getUserApi().registerUser();
        email= registeredUserInfo.email();

//        System.out.println("registeredUserInfo.fullName() = " + registeredUserInfo.fullName());
//        System.out.println("registeredUserInfo.email() = " + registeredUserInfo.email());
//        System.out.println("registeredUserInfo.password() = " + registeredUserInfo.password());

    }

    @Then("we need to check user exist in database")
    public void weNeedToCheckUserExistInDatabase() {
        DATABASE database = new DATABASE();
        USER_DATABASE.UserDatabaseInfo lastUserInfo = database.getUserDatabase().getLastUserInfo();

        Assert.assertEquals(email,lastUserInfo.email());
//        System.out.println("lastUserInfo.email() = " + lastUserInfo.email());

        Map<String, Object> lastUserInfoMap = database.getUserDatabase().getLastUserInfo_Map();
        Assert.assertEquals(email,lastUserInfoMap.get("email"));
//        System.out.println("lastUserInfoMap.get(\"email\") = " + lastUserInfoMap.get("email"));
    }

    @Test
    public void sifirdanBirKullaniciOlusturmus() {
        API api = new API(true);
        USER_API.RegisteredUserInfo registeredUserInfo = api.getUserApi().registerUser();
        email= registeredUserInfo.email();

        DatabaseUtilities.getConnection();
        USER_DATABASE userDatabase = new USER_DATABASE();
//        DATABASE database = new DATABASE();
//        database.getUserDatabase().activateUser();
        userDatabase.activateUser(email);
    }
}
