package stepDefinitions.databaseStepDef;

import enums.ROLES;
import io.cucumber.java.en.*;
import org.junit.Assert;

import utilities.BrowserUtilities;

import java.util.List;

public class kontrol {
   DatabaseMysql databaseMysql=new DatabaseMysql();
    List<DatabaseMysql.CreatedClientDB> allClientsInfo;

    @Given("user gets all created clients from db")
    public void userGetsAllCreatedClientsFromDb() {
        allClientsInfo=databaseMysql.getAllClientsInfoFromDb();
    }

    @Then("user verifies that all clients have id")
    public void userVerifiesThatAllClientsHaveId() {
       Assert.assertNotNull(allClientsInfo.stream().map(t->t.userID()));
    }

    @And("user verifies that all clients have email")
    public void userVerifiesThatAllClientsHaveEmail() {
        Assert.assertNotNull(allClientsInfo.stream().map(t->t.userEmail()));
    }

    @And("user verifies that there is password when ROLE_CLIENT_VERIFIED is exist for roles column")
    public void userVerifiesThatThereIsPasswordWhenROLE_CLIENT_VERIFIEDIsExistForRolesColumn() {
        allClientsInfo.stream().filter(t->t.roles().contains(ROLES.ROLE_CLIENT_VERIFIED.getRole())).forEach(t->Assert.assertNotNull(t.password()));
    }

    @And("user verifies that created dates are before today")
    public void userVerifiesThatCreatedDatesAreBeforeToday() {
       Assert.assertTrue(allClientsInfo.stream().allMatch(t->BrowserUtilities.isDateFuture(t.createdDate())));
    }

    @And("user verifies that ROLE_CLIENT_VERIFIED is true when client sign up with, google, facebook or linkedin")
    public void userVerifiesThatROLE_CLIENT_VERIFIEDIsTrueWhenClientSignUpWithGoogleFacebookOrLinkedin() {
      allClientsInfo.stream().filter(t->t.google_id()!=null).forEach(t->   Assert.assertTrue(t.roles().contains(ROLES.ROLE_CLIENT_VERIFIED.getRole())));
        allClientsInfo.stream().filter(t->t.facebook_id()!=null).forEach(t->   Assert.assertTrue(t.roles().contains(ROLES.ROLE_CLIENT_VERIFIED.getRole())));
        allClientsInfo.stream().filter(t->t.linkedin_id()!=null).forEach(t->   Assert.assertTrue(t.roles().contains(ROLES.ROLE_CLIENT_VERIFIED.getRole())));
    }
}
