package stepdefinitions;

import POJO.GoRest.GoRestCreateUserPojo;
import io.cucumber.datatable.DataTable;
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

import java.util.List;

import static POJO.GoRest.GoRestCreateObject.getGoRestCreateObject;
import static io.restassured.RestAssured.given;
import static util.ConfigReader.getBaseUrl;
import static util.GoRestObj.getCreateUserGoRestPayLoad;

public class GoRestSD {
    RequestSpecification requestSpecification;
    RequestSpecification request;
    Response response;
    ResponseSpecification responseSpecification;
    String responseStr;
    GoRestCreateUserPojo goRestCreateUserPojo;

    @Given("create user for GoRest is created")
    public void createUserForGoRestIsCreated() {
        // Implement this method
  /*    OAuth2Scheme auth = new OAuth2Scheme();
        auth.setAccessToken("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd");
*/
         requestSpecification = new RequestSpecBuilder()
                 .setBaseUri(getBaseUrl())
              //  .setAuth(auth)
                .addHeader("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .setContentType("application/json")
                .build();

        /* request = given().log().all().spec(requestSpecification)
                 .body(" {\n" +
                         "    \"name\": \"Awchar Kailas\",\n" +
                         "    \"email\": \"awchar1.kailas@gmail.com\",\n" +
                         "    \"gender\": \"male\",\n" +
                         "    \"status\": \"inactive\"\n" +
                         "  }");*/

        request = given().log().all().spec(requestSpecification)
                .body(getGoRestCreateObject("VAISHALI","vaishali@gmail.com","Female","active"));
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

        /* responseStr = response.then().log().all()
                .spec(responseSpecification)
                .extract().asString();*/

         goRestCreateUserPojo = response.then().log().all()
                .spec(responseSpecification)
                .extract().as(GoRestCreateUserPojo.class);
    }

    @Then("{string} should be for GoRest be {string}")
    public void emailShouldForGoRestBe(String jPath,String expectedValue) {
        // Implement this method
        JsonPath jsonPath = new JsonPath(responseStr);
        String actualValue = jsonPath.get(jPath);

        Assert.assertEquals(expectedValue,actualValue);
    }


    @Given("create user for GoRest is created with {} , {} , {} and {}")
    public void createUserForGoRestIsCreatedWithAnd(String name, String email, String gender, String status) {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                //  .setAuth(auth)
                .addHeader("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .setContentType("application/json")
                .build();

        /*request = given().log().all().spec(requestSpecification)
                .body(" {\n" +
                        "    \"name\": \""+name+"\",\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"gender\": \""+gender+"\",\n" +
                        "    \"status\": \""+status+"\"\n" +
                        "  }");*/
        request = given().log().all().spec(requestSpecification)
                .body(getCreateUserGoRestPayLoad(name, email, gender, status));
    }

    @Then("{string} should for GoRest be {}")
    public void shouldForGoRestBe(String jPath, String expectedValue) {
        // Implement this method
       /* JsonPath jsonPath = new JsonPath(responseStr);
        String actualValue = jsonPath.get(jPath);*/

        String actualValue = goRestCreateUserPojo.getEmail();

        Assert.assertEquals(expectedValue,actualValue);
    }



    @Given("create user for GoRest is created with below Dta")
    public void createUserForGoRestIsCreatedWithBelowDta(DataTable dataTable) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                //  .setAuth(auth)
                .addHeader("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .setContentType("application/json")
                .build();

        List<List<String>> data = dataTable.asLists();



        request = given().log().all().spec(requestSpecification)
                .body(getCreateUserGoRestPayLoad(data.get(0).get(0), data.get(0).get(1),data.get(0).get(2),data.get(0).get(3)));

    }
}
