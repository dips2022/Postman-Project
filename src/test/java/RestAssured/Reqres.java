package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; 
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;



public class Reqres {
	@Test(enabled = false)
	public void setup() {
		Response rep = RestAssured.get("https://reqres.in/api/users");
		int statusCode = rep.statusCode();
		Assert.assertEquals(statusCode, 200);
		 

	}
	@Test(enabled = false)
	public void ListUsers() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void SingleUser() {
		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.first_name", equalTo("Janet"));
	}
	@Test(enabled = false)
	public void SingleUserNotFound() {
		given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
	}
	 @Test(enabled = false)
	 public void ListResource() {
		 given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	 }
	 @Test(enabled = false)
	 public void SingleResource() {
		 given().get("https://reqres.in/api/unknown/2").then().statusCode(200).body("data.id", equalTo(2)).log().all();
	 }
	 @Test(enabled = false)
	 public void SingleResourceNotFound() {
		 given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log();
	 }
	 @Test(enabled = false) 
	 public void Create() {
		 JSONObject obj = new JSONObject();	
		 obj.put("name", "Dipali");
		 obj.put("job", "Tester");
		 given().body(obj.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	 }
	 @Test(enabled = false)
	 public void Delete() {
		 given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	 }
	 @Test(enabled = false)
	 public void RegisterSuccessful() {
		 JSONObject obj1 = new JSONObject();
		 obj1.put("email", "dipalinsonawane@gmail.com");
		 obj1.put("password", "dipali123");
		 given().body(obj1.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
	 }
	 @Test(enabled = false)
	  public void RegisterUnsuccessful() {
		 JSONObject obj2 = new JSONObject();
		 obj2.put("email", "dipalinsonawane1999@gmail.com");
		 given().body(obj2.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();
	 }
	 @Test(enabled = true)
	 public void LoginSuccessful() {
		 JSONObject obj3 = new JSONObject();
		 obj3.put("email", "dipali1234@gmail.com");
		 obj3.put("password", "dipali1234");
		 given().body(obj3.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();
	 }
	 @Test(enabled = false)
	 public void LoginUnSuccessful() {
		 JSONObject obj4 = new JSONObject();
		 obj4.put("email", "dipali22@gmail.com");
		 given().body(obj4.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();
	 }
	 
	 @Test(enabled = false)
	 public void DelayedResponse() {
		 given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();

	 }

}
