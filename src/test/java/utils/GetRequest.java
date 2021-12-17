package utils;

import baseClasses.ScenarioSpecific;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Contains items helpful for get api call
 */
public class GetRequest
{

    /**
     * The HTTP GET request is used to get a resource from a server.
     *
     * @param scenarioObj It uses scenarioObj.GETRequestDetails, scenarioObj.queryParams of ScenarioSpecific object to send request
     * @return Response object
     */
    //
    public Response sendGETRequest(ScenarioSpecific scenarioObj)
    {
        RestAssured.baseURI = scenarioObj.baseURI;
        Response response =
                given()
                        .header("Content-Type", scenarioObj.GETRequestDetails.get("Content-Type"))
                        .params(scenarioObj.queryParams)
                        .when()
                        .get(scenarioObj.GETRequestDetails.get("resource"))
                        .then()
                        .extract().response();
        return response;
    }

}
