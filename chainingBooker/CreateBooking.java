package chainingBooker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateBooking extends BaseClass{
	@Test
	public void create() {
		
		input=RestAssured.given().contentType("application/json").accept("application/json").when().body("{\r\n"
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
		
		response = input.post();
int statusCode = response.getStatusCode();
		
		bookingId = response.jsonPath().get("bookingid");
		response.then().assertThat().statusCode(Matchers.equalTo(200));
		//incnum=response.jsonPath().get("result.number");
		System.out.println("Booking ID of Create: " + bookingId);
		System.out.println("Status Code of Create: " + statusCode);
		
	}

}
