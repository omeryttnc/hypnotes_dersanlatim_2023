package stepDefinitions.backendStepDef;

import enums.USER_INFO;
import io.cucumber.java.en.Given;
import utilities.API;

public class week6 {
    @Given("create client from backend")
    public void createClientFromBackend() {
        API api = new API(USER_INFO.THERAPIST);
        api.getClientsApi().createClient();
    }
}
