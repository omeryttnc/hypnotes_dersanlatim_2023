package stepDefinitions.databaseStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

import utilities.BrowserUtilities;

import java.sql.SQLException;

import static utilities.DatabaseUtilities.*;


public class US_307 extends CommonPage {
    String title= Faker.instance().address().country().replaceAll("'","");
    String address="Freedom Street";
    String zipcode="12345";


    @Given("user deletes all locations")
    public void userDeletesAllLocations() {
        getClientPage().settingButton.click();
        getClientPage().locationButton.click();
        int ind = getClientPage().locations_delete.size();
        for (int i = 0; i < ind; i++) {
            getClientPage().locations_delete.get(0).click();
            BrowserUtilities.waitFor(1);
            getClientPage().Ok.click();
            BrowserUtilities.waitFor(1);
        }
    }


    @Given("user creates a new location")
    public void userCreatesANewLocation() {
        getClientPage().addNewLocationTitle.click();
        getClientPage().addressTitleBox.sendKeys(title);
        getClientPage().addressBox.sendKeys(address);
        getClientPage().zipCodeBox.sendKeys(zipcode);
        getClientPage().saveButtonOnLocation.click();
    }


    @And("user verifies added location is exist on related table")
    public void userVerifiesAddedLocationIsExistOnRelatedTable() throws SQLException {
        String query="Select * from hypnotes.`location_info` where address_title='"+title+"'";
        System.out.println("query = " + query);
        resultSet=DatabaseMysql.executeQuery(query);
        boolean flag=false;
        while (resultSet.next()){
            System.out.println("address_title = " + resultSet.getString("address_title"));
            if(resultSet.getString("address_title").equals(title)||
            resultSet.getString("address").equals(address)||
            resultSet.getString("zip_code").equals(zipcode));
            {
                flag=true;
                break;
            }
        }
       Assert.assertTrue(flag);
    }


    @And("user waits {int} second")
    public void userWaitsSecond(int second) {
        BrowserUtilities.waitFor(2);
    }
}
