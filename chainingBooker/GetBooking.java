package chainingBooker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBooking extends BaseClass{
	@Test(dependsOnMethods="chainingBooker.CreateBooking.create")
	public void get() {
		
		
		Response response = input.get("/"+bookingId);
		int statusCode = response.getStatusCode();
		response.then().assertThat().statusCode(Matchers.equalTo(200));
		System.out.println("Booking ID of get: " + bookingId);
		System.out.println("Status Code of get: " + statusCode);
		
	}
}
