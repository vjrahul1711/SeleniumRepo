package ApiAutomation;

import static io.restassured.RestAssured.given;



import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;







import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;



public class test1 {
    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        String response =

                given()



                        .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .formParams("grant_type", "client_credentials")

                        .formParams("scope", "trust")





                        .when().log().all()

                        .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);

        String accessToken = jsonPath.getString("access_token");

        System.out.println(accessToken);

        String r2=    given()

                .queryParams("access_token", accessToken)

                .when()

                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")

                .asString();

        System.out.println(r2);



    }


}
