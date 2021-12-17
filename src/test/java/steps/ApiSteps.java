package steps;

import baseObjects.ScenarioSpecific;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.*;

import java.io.File;
import java.util.HashMap;

public class ApiSteps
{
    private BaseStep baseStep;

    // DI to pass required object to particular scenario step
    public ApiSteps(BaseStep baseStep)
    {
        this.baseStep = baseStep;
    }

    @Given("^I set '(.+)' api request details as (.+)$")
    public void i_set_api_request(String requestType, String requestDetails)
    {
        ScenarioSpecific scenarioObj = baseStep.initializeScenarioObject();//intialize ScenarioSpecific object
        scenarioObj.baseURI = baseStep.getFileUtilsObj().readPropertiesFile(ScenarioSpecific.dataPropertiesFile, "baseURI");//Get baseURI
        //Add details to appropriate hashmap
        HashMap map;
        if (requestType.equals("POST"))
        {
            map = scenarioObj.POSTRequestDetails;//For post request put value in POSTRequestDetails
        } else if (requestType.equals("PUT"))
        {
            map = scenarioObj.PUTRequestDetails;//For put request put value in PUTRequestDetails
        } else
        {
            map = scenarioObj.GETRequestDetails;//else put value  in GETRequestDetails
        }

        String result = baseStep.getMapUtilsObj().putInMap(map, requestDetails);
        if (!result.equals("$$pass$$"))
        {
            Assert.fail(result);//fail if result returns non $$pass$$ value
        }

    }

    @When("^I send GET request using (.+)$")
    public void I_send_GET_request(String searchCriteria)
    {
        ScenarioSpecific scenarioObj = baseStep.getScenarioObject();//Get the scenario specific object
        baseStep.getMapUtilsObj().putInMap(scenarioObj.queryParams, searchCriteria);//put query param key value to queryParams map
        scenarioObj.apiResponse = baseStep.getGetRequestObj().sendGETRequest(scenarioObj);//send get request
    }

    @Then("^I receive response having successful validations (.+)$")
    public void I_receive_response_having_successful_validations(String validationsData)
    {
        ScenarioSpecific scenarioObj = baseStep.getScenarioObject();//Get the scenario specific object
        String result = baseStep.getValidationsObj().validation(scenarioObj, validationsData);//Do the validation of response and validation data
        if (!result.equals("$$pass$$"))
        {
            Assert.fail(result);//fail if result returns non $$pass$$ value
        }
    }

    @When("^I send POST request using (.+)$")
    public void I_send_POST_request_using(String payloadFile)
    {
        ScenarioSpecific scenarioObj = baseStep.getScenarioObject();//Get the scenario specific object
        File jsonFile = new File(ScenarioSpecific.resourcePath + "/" + payloadFile);//get payload file
        scenarioObj.apiResponse = baseStep.getPostRequestObj().sendPOSTRequest(scenarioObj, jsonFile);//send post request
    }

    @Then("^I receive response (.+) code for api response status code")
    public void I_recive_response(String responseCode)
    {
        ScenarioSpecific scenarioObj = baseStep.getScenarioObject();
        int code = Integer.parseInt(responseCode);
        Assert.assertEquals(code, scenarioObj.apiResponse.statusCode());
    }

    @When("^I send PUT request using (.+)$")
    public void I_send_PUT_request_using(String payloadFile)
    {
        ScenarioSpecific scenarioObj = baseStep.getScenarioObject();//Get the scenario specific object
        File jsonFile = new File(ScenarioSpecific.resourcePath + "/" + payloadFile);//get payload file
        scenarioObj.apiResponse = baseStep.getPutRequestObj().sendPUTRequest(scenarioObj, jsonFile);//send put request
    }

    @Then("^To test the scenario- (.+)$")
    public void To_test_the_scenario(String scenaroName)
    {
        //String x="sf";
        //Keep this empty for the time being. Just a template
    }
}
