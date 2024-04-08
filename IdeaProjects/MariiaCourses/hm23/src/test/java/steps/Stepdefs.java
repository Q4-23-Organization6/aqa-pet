package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Root;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stepdefs {
    private Root actualData;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @When("I send request to get single resource by existing id")
    public void i_send_request_to_get_single_resource_by_existing_id()  {
        actualData = given()
                .when()
                .spec(getRequestSpecification("https://reqres.in/"))
                .get("api/unknown/2")
                .then()
                .statusCode(200)
                .extract().response()
                .as(Root.class);
    }

    @Then("I should receive {string} resource data")
    public void i_should_receive_resource_data(String string) {
        Root expectedData = readFile(string, Root.class);

        assertEquals(actualData, expectedData, "Response is not equals to expected data");
    }

    @When("I send request to get resource by unexisting id")
    public void i_send_request_to_get_resource_by_unexisting_id() {
        actualData = given()
                .when()
                .spec(getRequestSpecification("https://reqres.in/"))
                .get("api/unknown/23")
                .then()
                .statusCode(404)
                .extract()
                .as(Root.class);
    }

    @Then("I should receive {string} resource data with empty body")
    public void i_should_receive_resource_data_with_empty_body(String file) {
        Root expectedData = readFile(file, Root.class);
        assertEquals(actualData, expectedData, "Response is not equals to expected data");
    }


    protected RequestSpecification getRequestSpecification(String host) {
        return new RequestSpecBuilder()
                .setBaseUri(host)
                .addHeader("accept", "application/json")
                .build();
    }
    private <T> T readFile(String fileName, Class<T> type) {
        try {
            byte[] expectedJson = Files.readAllBytes(Path.of("src/test/resources", fileName));
            return MAPPER.readValue(expectedJson, type);
        } catch (IOException e) {
            throw new RuntimeException("Error reading the expected JSON file", e);
        }
    }
}
