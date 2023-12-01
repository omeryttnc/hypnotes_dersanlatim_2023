package stepDefinitions;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ClientPage;
import pages.CommonPage;
import utilities.API;
import utilities.CLIENTS_API;

import java.util.AbstractMap;
import java.util.stream.IntStream;

public class Task7_Group1 extends CommonPage {
    String name;
    String surname;
    String email;
    Faker faker=new Faker();
    CLIENTS_API.PGetClientInfo getClient;

    @And("user adds a client from UI")
    public void userAddsAClientFromUI() {
        name=faker.name().firstName();
        surname=faker.name().lastName();
        email=faker.internet().emailAddress();

        getClientPage().register_firstName.sendKeys(name);
        getClientPage().register_lastName.sendKeys(surname);
        getClientPage().register_email.sendKeys(email);

        "Save".clickWebElementByText();
        "Yes".clickWebElementByText();

    }

    @When("user sends a request for getting all clients")
    public void userSendsARequestForGettingAllClients() {
        API api=new API(USER_INFO.THERAPIST);
        getClient=api.getClientsApi().getClient();

    }

    @Then("user verifies that added client is exist in response")
    public void userVerifiesThatAddedClientIsExistInResponse() {
        //way1 Structural
        Assert.assertTrue(getClient.clientNameList().contains(name));
        Assert.assertTrue(getClient.clientSurnameList().contains(surname));
        Assert.assertTrue(getClient.clientEmailList().contains(email));

        //Functional
        Assert.assertTrue(getClient.clientNameList().stream().anyMatch(t->t.contains(name)));
        Assert.assertTrue(getClient.clientSurnameList().stream().anyMatch(t->t.contains(surname)));
        Assert.assertTrue(getClient.clientEmailList().stream().anyMatch(t->t.contains(email)));
    }

    @And("user deletes added client from UI")
    public void userDeletesAddedClientFromUI() {
        int size= getClientPage().getClientSize();

//        //Way 1 Structural
//        for (int i = 0; i < size; i++) {
//            ClientPage.ClientInfo clientPageInfo=getClientPage().getClientInfo(i);
//            if (clientPageInfo.clientName().equals(name)||clientPageInfo.clientEmail().equals(email)){
//                getClientPage().deleteButton.get(i).click();
//            }
//        }

        //Way2 Functional
        IntStream.range(0,size)
                .mapToObj(i->{
                    ClientPage.ClientInfo clientPageInfo=getClientPage().getClientInfo(i);
                    return new AbstractMap.SimpleEntry<>(i,clientPageInfo);
                })
                .filter(entry->entry.getValue().clientName().equals(name)||entry.getValue().clientEmail().equals(email))
                .findFirst()
                .ifPresent(entry->{
                    int i=entry.getKey();
                    getClientPage().deleteButton.get(i).click();
                });

        "Yes".clickWebElementByText();

    }

    @Then("user verifies that deleted client is not exist in response")
    public void userVerifiesThatDeletedClientIsNotExistInResponse() {
        //way1 Structural
        Assert.assertFalse(getClient.clientNameList().contains(name));
        Assert.assertFalse(getClient.clientSurnameList().contains(surname));
        Assert.assertFalse(getClient.clientEmailList().contains(email));

        //Functional 1
        Assert.assertFalse(getClient.clientNameList().stream().anyMatch(t->t.contains(name)));
        Assert.assertFalse(getClient.clientSurnameList().stream().anyMatch(t->t.contains(surname)));
        Assert.assertFalse(getClient.clientEmailList().stream().anyMatch(t->t.contains(email)));

        //Functional 2
        Assert.assertTrue(getClient.clientNameList().stream().noneMatch(t->t.contains(name)));
        Assert.assertTrue(getClient.clientSurnameList().stream().noneMatch(t->t.contains(surname)));
        Assert.assertTrue(getClient.clientEmailList().stream().noneMatch(t->t.contains(email)));
    }
}
