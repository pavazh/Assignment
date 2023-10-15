package chainingBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateBooking extends BaseClass{
	@Test(dependsOnMethods="chainingBooker.CreateBooking.create")
	public void update() {
		
		RequestSpecification input=RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"firstname\": \"{{$randomFirstName}}\",\r\n"
				+ "    \"lastname\": \"{{$randomLastName}}\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}");
		Response response = input.put("/"+bookingId);
		
		
	}
}
