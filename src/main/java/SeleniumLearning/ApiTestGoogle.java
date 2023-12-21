package SeleniumLearning;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ApiTestGoogle {
    @Test
    public void Test01() {
        //Add Place API
        //given - All input details
        //when - submit the details - resource, Method
        //then - validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().
                queryParam("key", "qaclick123").
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).
                body("scope", equalTo("APP")).
                header("server", "Apache/2.4.52 (Ubuntu)").
                extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);//FOr parsing json
        String PlaceID = js.getString("place_id");
        System.out.println(PlaceID);
        System.out.println("place added successfully");


        //Update Place API

        given().log().all().queryParam("key", "qaclick123").
                header("Content-Type", "application/json").
                body("{\n" +
                        "\"place_id\":\"" + PlaceID + "\",\n" +
                        "\"address\":\"70 Summer walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().
                body("msg", equalTo("Address successfully updated")).extract().asString();


        // Get place API
        System.out.println("Get Place API started");
        String ExpectedAddress = "70 Summer walk, USA";

        String GetPlaceResponce = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceID).
                when().get("maps/api/place/get/json").
                then().assertThat().log().all().statusCode(200).body("address", equalTo("70 Summer walk, USA")).extract().response().asString();
        System.out.println(GetPlaceResponce);

        JsonPath js2 = new JsonPath(GetPlaceResponce);
        String newAddress = js2.getString("address");
        System.out.println("New Address is " + newAddress);
        assertEquals(newAddress, ExpectedAddress);

        // Delete Place API

        String DeleteResponse = given().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body("{\n" +
                        "    \"place_id\":\"" + PlaceID + "\"\n" +
                        "}\n").
                when().delete("/maps/api/place/delete/json").
                then().log().all().assertThat().statusCode(200).body("status", equalTo("OK")).extract().asString();
        System.out.println(DeleteResponse);
        System.out.println(" If response is printed then the place has been deleted.");

        //Done


    }


}
