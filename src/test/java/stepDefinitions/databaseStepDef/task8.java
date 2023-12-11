package stepDefinitions.databaseStepDef;

import enums.ROLE;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class task8 {
    DatabaseMysql databaseMysql=new DatabaseMysql();

    List<DatabaseMysql.CreatedClientDB> clientsInfo;
    @Given("user gets all clients info from DB")
    public void userGetsAllClientsInfoFromDB() {
        clientsInfo=databaseMysql.getAllClientsInfo();
    }

    @Then("user verifies all clients have id")
    public void userVerifiesAllClientsHaveId() {
        Assert.assertNotNull(clientsInfo.stream().map(t->t.userID()));
    }

    @Then("user verifies all clients have email")
    public void userVerifiesAllClientsHaveEmail() {
        Assert.assertNotNull(clientsInfo.stream().map(t->t.userEmail()));
    }

    @Then("user verifies there is password if role_client_verify is exist")
    public void userVerifiesThereIsPasswordIfRole_client_verifyIsExist() {
        clientsInfo.stream().filter(t->t.role().contains(ROLE.ROLE_Client_Verified)).forEach(t->Assert.assertNotNull(t.password()));
    }

    @Then("user verifies created date is past")
    public void userVerifiesCreatedDateIsPast() {
    }

    @Then("user gets number of google, Linkedin, facebook accounts")
    public void userGetsNumberOfGoogleLinkedinFacebookAccounts() {
        long google_id_number=clientsInfo.stream().filter(t->t.google_id()!=null).count();
        long facebook_id_number=clientsInfo.stream().filter(t->t.facebook_id()!=null).count();
        long linkedin_id_number=clientsInfo.stream().filter(t->t.linkedin_id()!=null).count();
        System.out.println("google_id_number = " + google_id_number);
        System.out.println("linkedin_id_number = " + linkedin_id_number);
        System.out.println("facebook_id_number = " + facebook_id_number);
    }


    @Then("user verifies there is role_client_verify when google_id - Linkedin_id - facebook_id is exist")
    public void userVerifiesThereIsRole_client_verifyWhenGoogle_idLinkedin_idFacebook_idIsExist() {
        clientsInfo.stream().filter(t->t.google_id()!=null).forEach(t->Assert.assertNotNull(t.role().contains(ROLE.ROLE_Client_Verified)));
        clientsInfo.stream().filter(t->t.facebook_id()!=null).forEach(t->Assert.assertNotNull(t.role().contains(ROLE.ROLE_Client_Verified)));
        clientsInfo.stream().filter(t->t.linkedin_id()!=null).forEach(t->Assert.assertNotNull(t.role().contains(ROLE.ROLE_Client_Verified)));
    }
}
