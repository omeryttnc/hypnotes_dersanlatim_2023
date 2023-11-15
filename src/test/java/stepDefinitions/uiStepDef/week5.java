package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class week5 extends CommonPage {
    @Then("assert side bar by lambda")
    public void assertSideBarByLambda() {
        List<String> sidebarExpectedList = List.of("Dashboard", "Calendar", "Services", "Clients", "Documents", "Coupons", "Questionnaires", "Email & SMS", "Settings");
        AtomicInteger index = new AtomicInteger(0);
        getHomePage().sidebarList
                .stream()
                .forEach(t -> {
                    Assert.assertTrue(t.isDisplayed());

                    Assert.assertEquals(sidebarExpectedList.get(index.get()), t.getText());
                    index.getAndIncrement();
                });
    }

    @Then("assert side bar by datatable column")
    public void assertSideBarByDatatableColumn(DataTable dataTable) {
        List<String> expectedSideBar = dataTable.column(0);
        List<WebElement> sidebarActualList = getHomePage().sidebarList;

        for (int i = 0; i < sidebarActualList.size(); i++) {
            Assert.assertEquals(
                    expectedSideBar.get(i),
                    sidebarActualList.get(i).getText());
        }

    }

    @Then("assert side bar by datatable map")
    public void assertSideBarByDatatableMap(DataTable dataTable) {
        List<Map<String, String>> expectedSideBarMap = dataTable.asMaps();
        List<WebElement> sidebarActualList = getHomePage().sidebarList;

        for (int i = 0; i < expectedSideBarMap.size(); i++) {
            Assert.assertEquals(
                    expectedSideBarMap.get(i).get("navbar"),
                    sidebarActualList.get(i).getText()
            );
        }


    }

    @Then("assert side bar by scenario outline {string} {int}")
    public void assertSideBarByScenarioOutlineIndex(String sidebar,int index) {
        Assert.assertEquals(
                sidebar,
                getHomePage().sidebarList.get(index).getText()
        );
    }
}
