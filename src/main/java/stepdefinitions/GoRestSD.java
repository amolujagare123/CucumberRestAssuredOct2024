package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GoRestSD {
    RequestSpecification requestSpecification;
    RequestSpecification request;
    Response response;
    ResponseSpecification responseSpecification;
    String responseStr;

    @Given("create user for GoRest is created")
    public void createUserForGoRestIsCreated() {
        // Implement this method
  /*    OAuth2Scheme auth = new OAuth2Scheme();
        auth.setAccessToken("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd");
*/
         requestSpecification = new RequestSpecBuilder()
                 .setBaseUri("https://gorest.co.in/")
              //  .setAuth(auth)
                 //.addHeader("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .setContentType("application/json")
                .build();

         request = given().log().all().spec(requestSpecification)
                 .body(" {\n" +
                         "    \"name\": \"Awchar Kailas\",\n" +
                         "    \"email\": \"awchar1.kailas@gmail.com\",\n" +
                         "    \"gender\": \"male\",\n" +
                         "    \"status\": \"inactive\"\n" +
                         "  }");
    }

    @When("I send post request with create user for GoRest")
    public void sendPostRequestWithCreateUserForGoRest() {
        // Implement this method
         response = request.when().post("/public/v2/users");
    }

    @Then("status code should for GoRest be {string}")
    public void statusCodeShouldForGoRestBe(String expectedStatusCode) {
        // Implement this method
         responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(Integer.parseInt(expectedStatusCode))
                .build();

         responseStr = response.then().log().all()
                .spec(responseSpecification)
                .extract().asString();
    }

    @Then("{string} should for GoRest be {string}")
    public void emailShouldForGoRestBe(String jPath,String expectedValue) {
        // Implement this method
        JsonPath jsonPath = new JsonPath(responseStr);
        String actualValue = jsonPath.get(jPath);

        Assert.assertEquals(expectedValue,actualValue);
    }
}
