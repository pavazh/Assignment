package chainingBooker;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static Integer bookingId;
	public static RequestSpecification input;
	public static Response response;
@BeforeMethod
	public void setUp() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
		RestAssured.authentication=RestAssured.preemptive().basic("admin", "password123");
	}
}
