package stepDenifitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStep {
	@Given("^Open URL$")
	public void open_URL() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Open URL");
	}

	@When("^Input username =\"([^\"]*)\"$")
	public void input_username(String userName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Username: " + userName);
	}

	@When("^Input password =\"([^\"]*)\"$")
	public void input_password(String pass) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Password: " + pass);

	}

	@When("^click login button$")
	public void click_login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Click login button");
	}

	@Then("^Assert user goes to home page$")
	public void assert_user_goes_to_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User is standing at Home page");
	}

	@Then("^Assert wrong message \"([^\"]*)\"$")
	public void assert_wrong_message(String msg) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Message: "+msg);
	}

}
