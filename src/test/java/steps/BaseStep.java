package steps;

import baseObjects.*;
import utils.*;

public class BaseStep
{

    private ScenarioSpecific scenarioObj;//scenario specific object
    private GetRequest GetRequestObj;
    private PutRequest PutRequestObj;
    private PostRequest PostRequestObj;
    private Validations ValidationsObj;
    private utils.MapUtils MapUtilsObj;
    private FileUtils FileUtilsObj;

    //returns the scenario specific object to caller
    public ScenarioSpecific getScenarioObject()
    {
        return scenarioObj;
    }

    //call ScenarioSpecific and return scenariospecific object
    public ScenarioSpecific initializeScenarioObject()
    {
        scenarioObj = new ScenarioSpecific();
        return scenarioObj;
    }


    public GetRequest getGetRequestObj()
    {
        GetRequestObj = new GetRequest();
        return GetRequestObj;
    }

    public PutRequest getPutRequestObj()
    {
        PutRequestObj = new PutRequest();
        return PutRequestObj;
    }

    public PostRequest getPostRequestObj()
    {
        PostRequestObj = new PostRequest();
        return PostRequestObj;
    }

    public Validations getValidationsObj()
    {
        ValidationsObj = new Validations();
        return ValidationsObj;
    }

    public MapUtils getMapUtilsObj()
    {
        MapUtilsObj = new MapUtils();
        return MapUtilsObj;
    }

    public FileUtils getFileUtilsObj()
    {
        FileUtilsObj = new FileUtils();
        return FileUtilsObj;
    }
}
