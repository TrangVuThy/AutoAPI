package common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {

	RequestSpecification request = null;
	ResponseSpecification reponse = null;

	public static String getStringfromJson(String response, String title) {
		JsonPath js = new JsonPath(response);
		String text = js.getString(title);
		return text;

	}

	public static int getIntfromJson(String response, String title) {
		JsonPath js = new JsonPath(response);
		int intNumber = js.getInt(title);
		return intNumber;

	}

	public RequestSpecification requestSpeccification() {
		if (request == null) {
			request = new RequestSpecBuilder().build();
			request.baseUri("https://rahulshettyacademy.com");
			request.log().all();
			request.contentType(ContentType.JSON);
		}
		return request;
	}

	public ResponseSpecification responseSpecBuilder() {
		reponse = new ResponseSpecBuilder().build();
		reponse.contentType(ContentType.JSON);
		
		return reponse;
	}
}
