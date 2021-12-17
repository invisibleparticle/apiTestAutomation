package utils;

import baseClasses.ScenarioSpecific;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * Contains items helpful for put api call
 */
public class PutRequest
{
    /**
     * The PUT request updates a resource but requires the full JSON payload.
     *
     * @param scenarioObj It uses scenarioObj.PUTRequestDetails, scenarioObj.queryParams of ScenarioSpecific object to send request
     * @param jsonFile    request json file
     * @return Response object
     */
    public Response sendPUTRequest(ScenarioSpecific scenarioObj, File jsonFile)
    {
        RestAssured.baseURI = scenarioObj.baseURI;
        Response response =
                given()
                        .header("Content-Type", scenarioObj.PUTRequestDetails.get("Content-Type"))
                        .params(scenarioObj.queryParams)
                        .and()
                        .body(jsonFile)
                        .when()
                        .put(scenarioObj.PUTRequestDetails.get("resource"))
                        .then()
                        .extract().response();
        return response;
    }
}
