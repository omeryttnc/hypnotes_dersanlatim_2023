package stepDefinitions;

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

import static stepDefinitions.Hooks.faker;


public class Task7_Group2 extends CommonPage {
    String name;
    String surName;
    String email;
CLIENTS_API.PGetClientInfo clientInfo;

    @And("user adds a client from UI two")
    public void userAddsAClientFromUITwo() {
        name = faker.name().firstName();
        surName = faker.name().lastName();
        email = faker.internet().emailAddress();

        getClientPage().register_firstName.sendKeys(name);
        getClientPage().register_lastName.sendKeys(surName);
        getClientPage().register_email.sendKeys(email);

        "Save".clickWebElementByText();
        "Yes".clickWebElementByText();
    }

    @When("user sends a request for getting all clients two")
    public void userSendsARequestForGettingAllClientsTwo() {
        API api = new API(USER_INFO.THERAPIST);
       clientInfo= api.getClientsApi().getClient();

    }

    @Then("user verifies that added client is exist in response two")
    public void userVerifiesThatAddedClientIsExistInResponseTwo() {
        //way1 Structural
        Assert.assertTrue(clientInfo.clientNameList().contains(name));
        Assert.assertTrue(clientInfo.clientSurnameList().contains(surName));
        Assert.assertTrue(clientInfo.clientEmailList().contains(email));

        //way2 Functional
        Assert.assertTrue(clientInfo.clientNameList().stream().anyMatch(t->t.contains(name)));
        Assert.assertTrue(clientInfo.clientSurnameList().stream().anyMatch(t->t.contains(surName)));
        Assert.assertTrue(clientInfo.clientEmailList().stream().anyMatch(t->t.contains(email)));
    }

    @And("user deletes added client from UI two")
    public void userDeletesAddedClientFromUITwo() {
        int size=getClientPage().getClientSize();

//        //way1 Structural
//        for (int i = 0; i < size; i++) {
//           ClientPage.ClientInfo clientInfoUI= getClientPage().getClientInfo(i);
//           if (clientInfoUI.clientEmail().equals(email)||clientInfoUI.clientName().equals(name)){
//               getClientPage().deleteButton.get(i).click();
//               "Yes".clickWebElementByText();
//           }
//        }

        //way2 biFunctional
        IntStream.range(0,size)
                .mapToObj(i->{
                    ClientPage.ClientInfo clientInfoUI= getClientPage().getClientInfo(i);
                    return new AbstractMap.SimpleEntry<>(i,clientInfoUI);
                })
                .filter(t->t.getValue().clientName().equals(name)||t.getValue().clientEmail().equals(email))
                .findFirst()
                .ifPresent(t->{
                    int ind=t.getKey();
                    getClientPage().deleteButton.get(ind).click();
                    "Yes".clickWebElementByText();
                });



    }

    @Then("user verifies that deleted client is not exist in response two")
    public void userVerifiesThatDeletedClientIsNotExistInResponseTwo() {
        //way1 Structural
        Assert.assertFalse(clientInfo.clientNameList().contains(name));
        Assert.assertFalse(clientInfo.clientSurnameList().contains(surName));
        Assert.assertFalse(clientInfo.clientEmailList().contains(email));

        //way2 Functional 1
        Assert.assertFalse(clientInfo.clientNameList().stream().anyMatch(t->t.contains(name)));
        Assert.assertFalse(clientInfo.clientSurnameList().stream().anyMatch(t->t.contains(surName)));
        Assert.assertFalse(clientInfo.clientEmailList().stream().anyMatch(t->t.contains(email)));

        //way2 Functional 2
        Assert.assertTrue(clientInfo.clientNameList().stream().noneMatch(t->t.contains(name)));
        Assert.assertTrue(clientInfo.clientSurnameList().stream().noneMatch(t->t.contains(surName)));
        Assert.assertTrue(clientInfo.clientEmailList().stream().noneMatch(t->t.contains(email)));

    }
}
