package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomeUnicefPage;
import runner.base_class.BaseSteps;

public class HomeElementsCheckSteps extends BaseSteps {

    HomeUnicefPage homePage = new HomeUnicefPage();
    @Then("the press centre button should be clickable")
    public void the_press_centre_is_clickable() {
        homePage.isPressCentreButtonClickable();
        screenshot();
    }

    @Then("the donate button should be clickable")
    public void the_donate_button_is_clickable() {
        homePage.isDonateButtonClickable();
        screenshot();
    }

    @When("the user goes into the what we do section")
    public void the_user_goes_into_the_what_we_do_section() {
        homePage.hoverWhatWeDoSection();
    }

    @Then("the all areas link should be working fine")
    public void the_all_areas_link_should_be_working_fine() throws InterruptedException {
        homePage.clickAllAreasLink();
        screenshot();
    }

    @Then("the adolescents link should be working fine")
    public void the_adolescents_link_should_be_working_fine() throws InterruptedException {
        homePage.clickAdolescentsLink();
    }

    @Then("when {string} is clicked it should lead to {string}")
    public void all_the_other_links_should_lead_to(String elementToClick, String desiredPage) throws InterruptedException {
        homePage.otherLinks(elementToClick, desiredPage);
        screenshot();
    }

    @Then("when {string} is clicked in the middle of page it should lead to {string}")
    public void middle_section_links_should_lead_to(String elementToClick, String desiredPage) throws InterruptedException {
        homePage.clickMiddleSectionLink(elementToClick, desiredPage);
        screenshot();
    }

    @Then("when {string} is clicked in the second half of middle of page it should lead to {string}")
    public void middle_section_2_links_should_lead_to(String elementToClick, String desiredPage) throws InterruptedException {
        homePage.clickMiddleSection2Link(elementToClick, desiredPage);
        screenshot();
    }

    @Then("when {string} is clicked in the bottom of page it should lead to {string}")
    public void bottom_page_links_should_lead_to(String elementToClick, String desiredPage) throws InterruptedException {
        homePage.bottomPageLink(elementToClick, desiredPage);
        screenshot();
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

    @When("the user goes into Take Action section")
    public void the_user_goes_into_take_action_section() throws InterruptedException {
       homePage.hoverTakeActionSection();
    }

    @When("the search button is clicked and data is inserted")
    public void the_search_button_is_clicked() throws InterruptedException {
        homePage.clickSearchButton();
        homePage.insertDatainSearchInput();
    }

    @Then("the search should show results")
    public void the_search_should_show_results() {
        homePage.doesSearchContainResults();
        screenshot();
    }

    @Then("the main image should be loaded and displayed")
    public void the_main_image_should_be_loaded_and_displayed() {
       homePage.isMainImageDisplayed();
       screenshot();
    }

    @Then("the bottom image should be loaded and displayed")
    public void the_bottom_image_should_be_loaded_and_displayed() {
        homePage.isBottomImageDisplayed();
        screenshot();
    }

    @And("read more button should be clickable")
    public void read_more_button_should_be_clickable() {
        homePage.isMainReadMoreButtonIsClickable();
        screenshot();
    }

    @And("join unicef button should be clickable")
    public void join_unicef_button_should_be_clickable() {
        homePage.isMainReadMoreButtonIsClickable();
        screenshot();
    }

}
