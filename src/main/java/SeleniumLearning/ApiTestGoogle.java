package SeleniumLearning;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ApiTestGoogle
    {
        public static void main (String[] args)
            {
                //Add Place API
                //given - All input details
                //when - submit the details - resource, Method
                //then - validate the response
                RestAssured.baseURI ="https://rahulshettyacademy.com";
                given().
                        queryParam("key","qaclick123").header("Content-Type","application/json").
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
                        .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).
                        header("server","Apache/2.4.18 (Ubuntu)");

            };





    }
