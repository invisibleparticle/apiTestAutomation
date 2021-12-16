package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import baseObjects.ScenarioSpecific;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

/**
 * Class contains common methods and objects for the framework
 */
public class FuncUtil
{
    public static final String passKey="$$pass$$";//String which represents success

    /**
     * Reads from properties file
     * @param fileName Full path plus file name
     * @param inputKey Key we are searching for in .properties file
     * @return value of the key in .properties file if no key is present then returns null. This must be handled in calling method.
     * Catches java.io.IOException
     */
    public static String readPropertiesFile(String fileName, String inputKey)
    {
        String value = null;
        try
        {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            fis.close();
            value = prop.getProperty(inputKey);
            return value;

        } catch ( java.io.IOException e)
        {
            return e.toString();
        }
    }

    /**
     * Put input in map.Input should be key1:value1,-key2:value2
     * @param map Hashmap where the value/s to be added
     * @param input key value pair in form of key1:value1,-key2:value2
     * @return In case of success returns $$pass$$ else returns exception
     */
    public static String putInMap(HashMap map , String input)
    {
        String result=passKey;
        try
        {
            String[] fields = input.split(",-");
            for (int i = 0; i < fields.length; i++)
            {
                String[] field = fields[i].trim().split(":");
                map.put(field[0], field[1]);

            }
        }catch (Exception e){
            result=e.toString();
        }
        return result;

    }

    /**
     * Used to validate scenarioObj.apiResponse with validationsData input.
     * Validation format is jsonPathOfField1:expectedValue,-jsonPathOfField2:expectedValue
     * @param scenarioObj Needs ScenarioSpecific object which has apiResponse value set for validation
     * @param validationsData Validation input data as jsonPathOfField1:expectedValue,-jsonPathOfField2:expectedValue
     * @return In case of success returns $$pass$$ else returns specific field and details of what got failed
     */
    public static String validation(ScenarioSpecific scenarioObj, String validationsData)
    {

        String result = passKey;
        String[] fields = validationsData.split(",-");
        for (int i = 0; i < fields.length; i++)
        {
            String[] field = fields[i].trim().split(":");
            if (!field[1].equals(scenarioObj.apiResponse.jsonPath().getString(field[0])))
            {
                result = "Expected:" + field[1] + " Actual:" + scenarioObj.apiResponse.jsonPath().getString(field[0]);
                break;
            }

        }
        return result;
    }

    /**
     * The HTTP GET request is used to get a resource from a server.
     * @param scenarioObj It uses scenarioObj.GETRequestDetails, scenarioObj.queryParams of ScenarioSpecific object to send request
     * @return  Response object
     */
    //
    public static Response sendGETRequest(ScenarioSpecific scenarioObj)
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

    /**
     * HTTP POST request is used to post data or create a resource on a server.
     * @param scenarioObj It uses scenarioObj.POSTRequestDetails, scenarioObj.queryParams of ScenarioSpecific object to send request
     * @param jsonFile request json file
     * @return Response object
     */
    public static Response sendPOSTRequest(ScenarioSpecific scenarioObj, File jsonFile)
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

    /**
     * The PUT request updates a resource but requires the full JSON payload.
     * @param scenarioObj It uses scenarioObj.PUTRequestDetails, scenarioObj.queryParams of ScenarioSpecific object to send request
     * @param jsonFile request json file
     * @return Response object
     */
    public static Response sendPUTRequest(ScenarioSpecific scenarioObj, File jsonFile)
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
