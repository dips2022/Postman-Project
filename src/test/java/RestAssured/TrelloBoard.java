package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;
//https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken

public class TrelloBoard {
	@Test
	public void CreateBoard() {
		RestAssured.baseURI = "https://trello.com";
		Response Rep = given().queryParam("name", "Sakshi").queryParam("key", "9db7d8a21efb1b4d7df5925db707c204")
				.queryParam("token", "ATTA86a6a68326b1b6fb2deb58194019d27a066da2e9de48424a6836a42f9a9768a5D0987A70")
				.header("Content-Type", "application/json").when().post("/1/boards/").then()
				.contentType(ContentType.JSON).extract().response();
		String str = Rep.asString();
//		System.out.println(str);
		JsonPath js = new JsonPath(str); // fetch response for json format
		String id = js.get("id");
		System.out.println(id);
	    
		given().queryParam("key", "9db7d8a21efb1b4d7df5925db707c204")
		.queryParam("token", "ATTA86a6a68326b1b6fb2deb58194019d27a066da2e9de48424a6836a42f9a9768a5D0987A70")
		.header("Content-Type", "application/json").when().delete("/1/boards/"+id).then().contentType(ContentType.JSON);
	}
	

}
