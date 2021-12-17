package baseClasses;

import io.restassured.response.Response;

import java.util.HashMap;

/**
 * This class contains scenario exclusive objects which is to be used to hold and share data from/to scenario STEPS
 */
public class ScenarioSpecific
{

    public HashMap<String, String> GETRequestDetails = new HashMap<String, String>(20);//Map to hold get api request details like headers, resource
    public HashMap<String, String> POSTRequestDetails = new HashMap<String, String>(20);//for post api call specific data
    public HashMap<String, String> PUTRequestDetails = new HashMap<String, String>(20);//Used for put api call specific data
    public HashMap<String, String> queryParams = new HashMap<String, String>(10);//Map to hold api request queryParams
    public Response apiResponse;//Used to hold api response
    public String baseURI;
    public static final String resourcePath = "src/test/resources"; //resource folder where json,properties file resides
    public static final String dataPropertiesFile = "src/test/resources/Data.properties";//full path of data properties file
    public static final String passKey = "$$pass$$";//String which represents success

    /**
     * Constructor to initialize scenario specific objects with default value which to be overwritten when required
     */

    public ScenarioSpecific()
    {
        GETRequestDetails.put("Content-Type", "application/json");
        POSTRequestDetails.put("Content-Type", "application/json");
        PUTRequestDetails.put("Content-Type", "application/json");
    }
}
