package stepDenifitions;

import javax.sound.midi.Soundbank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class registerStep {
	@Given("^Register$")
	public void register() throws Throwable {

		System.out.println("Open website");
	}

	@When("^Register username =\"([^\"]*)\"$")
	public void register_username(String userName) throws Throwable {
		System.out.println("Username:  " + userName);

	}

	@When("^Register password =\"([^\"]*)\"$")
	public void register_password(String pass) throws Throwable {
		System.out.println("Password : " + pass);
	}

	@When("^click register button$")
	public void click_register_button() throws Throwable {
		System.out.println("Click btn register");
	}
}
