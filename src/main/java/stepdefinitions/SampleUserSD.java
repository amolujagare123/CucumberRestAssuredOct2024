package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class SampleUserSD {

    String baseUrl;
    RequestSpecification requestSpecification;
    RequestSpecification request;
    Response response;
    String responseStr;


    @Given("base url is set")
    public void base_url_is_set() {
        baseUrl = "https://reqres.in";
        requestSpecification
                = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    } // Background

    @Given("create user payload is created")
    public void create_user_payload_is_created() {

         request = given().log().all()
                .spec(requestSpecification)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}");

    }
    @When("I send post request with create user resource")
    public void i_send_post_request_with_create_user_resource() {
         response = request.when().post("/api/users");

    }
    @Then("status code should be {string}")
    public void status_code_should_be(String statusCode) {
        ResponseSpecification responseSpecification
                = new ResponseSpecBuilder()
                .expectStatusCode(Integer.parseInt(statusCode))
                .build();

         responseStr = response.then().log().all()
                .spec(responseSpecification)
                .extract().asString();

    }

    @Given("update user payload is created")
    public void updateUserPayloadIsCreated() {
        request = given().log().all()
                .spec(requestSpecification)
                .body("{\n" +
                        "    \"name\": \"Amol\",\n" +
                        "    \"job\": \"zion Homes\"\n" +
                        "}");
    }

    @When("I send put request with update user resource")
    public void iSendPutRequestWithUpdateUserResource() {

        response = request.when().put("/api/users/2");

    }

    @Then("{string} should be {string}")
    public void shouldBe(String jPath, String expectedValue) {


        JsonPath jsonPath = new JsonPath(responseStr);

        String actualValue = jsonPath.get(jPath);

        Assert.assertEquals(expectedValue,actualValue);

    }
}
