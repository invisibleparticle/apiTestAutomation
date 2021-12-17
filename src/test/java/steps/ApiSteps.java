package steps;

import baseClasses.ScenarioSpecific;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        baseStep.getScenarioObject().baseURI = baseStep.getFileUtilsObj().readPropertiesFile(ScenarioSpecific.dataPropertiesFile, "baseURI");//Set baseURI
        //Add details to appropriate hashmap
        HashMap map;
        if (requestType.equals("POST"))
        {
            map = baseStep.getScenarioObject().POSTRequestDetails;//For post request put value in POSTRequestDetails
        } else if (requestType.equals("PUT"))
        {
            map = baseStep.getScenarioObject().PUTRequestDetails;//For put request put value in PUTRequestDetails
        } else
        {
            map = baseStep.getScenarioObject().GETRequestDetails;//else put value  in GETRequestDetails
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
        baseStep.getMapUtilsObj().putInMap(baseStep.getScenarioObject().queryParams, searchCriteria);//put query param key value to queryParams map
        baseStep.getScenarioObject().apiResponse = baseStep.getGetRequestObj().sendGETRequest(baseStep.getScenarioObject());//send get request
    }

    @Then("^I receive response having successful validations (.+)$")
    public void I_receive_response_having_successful_validations(String validationsData)
    {
        String result = baseStep.getValidationsObj().validation(baseStep.getScenarioObject(), validationsData);//Do the validation of response and validation data
        if (!result.equals("$$pass$$"))
        {
            Assert.fail(result);//fail if result returns non $$pass$$ value
        }
    }

    @When("^I send POST request using (.+)$")
    public void I_send_POST_request_using(String payloadFile)
    {

        File jsonFile = new File(ScenarioSpecific.resourcePath + "/" + payloadFile);//get payload file
        baseStep.getScenarioObject().apiResponse = baseStep.getPostRequestObj().sendPOSTRequest(baseStep.getScenarioObject(), jsonFile);//send post request
    }

    @Then("^I receive response (.+) code for api response status code")
    public void I_recive_response(String responseCode)
    {
        int code = Integer.parseInt(responseCode);
        Assert.assertEquals(code, baseStep.getScenarioObject().apiResponse.statusCode());
    }

    @When("^I send PUT request using (.+)$")
    public void I_send_PUT_request_using(String payloadFile)
    {
        File jsonFile = new File(ScenarioSpecific.resourcePath + "/" + payloadFile);//get payload file
        baseStep.getScenarioObject().apiResponse = baseStep.getPutRequestObj().sendPUTRequest(baseStep.getScenarioObject(), jsonFile);//send put request
    }

    @Then("^To test the scenario- (.+)$")
    public void To_test_the_scenario(String scenaroName)
    {
        //String x="sf";
        //Keep this empty for the time being. Just a template
    }
}
