package utils;

import baseObjects.ScenarioSpecific;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * Contains items helpful for post api call
 */
public class PostRequest
{
    /**
     * HTTP POST request is used to post data or create a resource on a server.
     *
     * @param scenarioObj It uses scenarioObj.POSTRequestDetails, scenarioObj.queryParams of ScenarioSpecific object to send request
     * @param jsonFile    request json file
     * @return Response object
     */
    public Response sendPOSTRequest(ScenarioSpecific scenarioObj, File jsonFile)
    {
        RestAssured.baseURI = scenarioObj.baseURI;
        Response response =
                given()
                        .header("Content-Type", scenarioObj.POSTRequestDetails.get("Content-Type"))
                        .params(scenarioObj.queryParams)
                        .and()
                        .body(jsonFile)
                        .when()
                        .post(scenarioObj.POSTRequestDetails.get("resource"))
                        .then()
                        .extract().response();
        return response;
    }
}
