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

    @Then("when {string} is clicked it should lead to {string}")
    public void all_the_other_links_should_lead_to(String elementToClick, String desiredPage) throws InterruptedException {
        homePage.otherLinks(elementToClick, desiredPage);
    }

    @When("the user goes into the research and reports section")
    public void the_user_goes_into_the_research_and_reports_section() {
        homePage.hoverResearchAndReportsSection();
    }

    @When("the user goes into stories section")
    public void the_user_goes_into_stories_section() throws InterruptedException {
        homePage.hoverStoriesSection();
    }

    @When("the user goes into About Unicef section")
    public void the_user_goes_into_about_unicef_section() throws InterruptedException {
        homePage.hoverAboutUnicefSection();
    }





}
