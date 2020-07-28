package stepDenifitions;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.LessThan;

import org.junit.Assert;

import body.googleApiPayload;
import common.ResourceAPI;
import common.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data_test.GlobalData;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GoogleAPIStep extends Utilities {
	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	googleApiPayload apiBody = new googleApiPayload();

	@When("^User call \"([^\"]*)\" with \"([^\"]*)\" method$")
	public void user_call_with_method(String resource, String method) {
		res = responseSpecBuilder();
		ResourceAPI resourceAPI = ResourceAPI.valueOf(resource);
		if (method.equalsIgnoreCase("POST")) {
			response = given().log().all().spec(req).when().post(resourceAPI.getResource()).then().log().all().spec(res).extract().response();
		} else if (method.equalsIgnoreCase("GET")) {
			response = given().log().all().spec(req).when().get(resourceAPI.getResource()).then().log().all().spec(res).extract().response();
		} else if (method.equalsIgnoreCase("PUT")) {
			response = given().log().all().spec(req).when().put(resourceAPI.getResource()).then().log().all().spec(res).extract().response();
		} else if (method.equalsIgnoreCase("DELETE")) {
			response = given().log().all().spec(req).when().delete(resourceAPI.getResource()).then().log().all().spec(res).extract().response();
		}
	}

	@When("^Check status code (\\d+)$")
	public void check_status_code(int statusCode) {
		System.out.println("Stauts code: " + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@When("^Check performance less than (\\d+) ms$")
	public void check_performance_less_than_ms(long time) {
		long responseTime = response.getTime();
		System.out.println("Response time : " + responseTime);
		Assert.assertTrue(responseTime < time);

	}

	@Given("^User add query param for add getAPI$")
	public void user_add_query_param_for_add_getAPI() throws Throwable {
		req = requestSpeccification();
		req.queryParam("place_id", GlobalData.place_Id);
	}

	@Given("^User add body for \"([^\"]*)\" Place API$")
	public void user_add_body_for_Update_Place_API(String bodyName) {
		req = requestSpeccification();
		if (bodyName.equalsIgnoreCase("update")) {
			req.queryParam("key", "qaclick123");
			req.body(apiBody.UpdatePlacePayload(GlobalData.place_Id));
		} else if (bodyName.equalsIgnoreCase("delete")) {
			req.queryParam("key", "qaclick123");
			req.body(apiBody.DeletePlacePayload(GlobalData.place_Id));
		} else if (bodyName.equalsIgnoreCase("add")) {
			req.body(apiBody.addPlacePayload());

		}
	}

	@Then("^Assert \"([^\"]*)\" text is \"([^\"]*)\"$")
	public void assert_text_is(String key, String value) {
		String valueText = getStringfromJson(response.asString(), key);
		Assert.assertEquals(valueText, value);
	}

	@Then("^Get \"([^\"]*)\"$")
	public void get(String value) {
		if (getStringfromJson(response.asString(), value) != null) {
			GlobalData.place_Id = getStringfromJson(response.asString(), value);
		}

		System.out.println("place_id = " + GlobalData.place_Id);
	}

}
