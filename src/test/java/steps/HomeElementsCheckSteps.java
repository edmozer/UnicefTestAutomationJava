package steps;

import io.cucumber.java.en.Then;
import pages.HomeUnicefPage;
import runner.base_class.BaseSteps;

public class HomeElementsCheckSteps extends BaseSteps {

    HomeUnicefPage homePage = new HomeUnicefPage();
    @Then("the press centre button should be clickable")
    public void the_user_should_be_able_to_donate() {
        homePage.GetHomePage();
    }
}
