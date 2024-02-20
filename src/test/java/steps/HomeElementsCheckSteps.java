package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomeUnicefPage;
import runner.base_class.BaseSteps;

public class HomeElementsCheckSteps extends BaseSteps {

    HomeUnicefPage homePage = new HomeUnicefPage();
    @Then("the press centre button should be clickable")
    public void the_press_centre_is_clickable() {
        homePage.isPressCentreButtonClickable();
    }

    @Then("the donate button should be clickable")
    public void the_donate_button_is_clickable() {
        homePage.isDonateButtonClickable();
    }

    @When("the user goes into the what we do section")
    public void the_user_goes_into_the_what_we_do_section() {
        homePage.hoverWhatWeDoSection();
    }

    @Then("the all areas link should be working fine")
    public void the_all_areas_link_should_be_working_fine() throws InterruptedException {
        homePage.clickAllAreasLink();
    }

    @Then("the adolescents link should be working fine")
    public void the_adolescents_link_should_be_working_fine() throws InterruptedException {
        homePage.clickAdolescentsLink();
    }
}
