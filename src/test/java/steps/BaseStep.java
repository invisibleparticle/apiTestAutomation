package steps;

import baseClasses.*;
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


    //call ScenarioSpecific and return scenariospecific object
    public BaseStep()
    {
        scenarioObj = new ScenarioSpecific();
        GetRequestObj = new GetRequest();
        PutRequestObj = new PutRequest();
        PostRequestObj = new PostRequest();
        ValidationsObj = new Validations();
        MapUtilsObj = new MapUtils();
        FileUtilsObj = new FileUtils();

    }
    //returns the scenario specific object to caller
    public ScenarioSpecific getScenarioObject()
    {
        return scenarioObj;
    }
    public GetRequest getGetRequestObj()
    {
        return GetRequestObj;
    }

    public PutRequest getPutRequestObj()
    {
        return PutRequestObj;
    }

    public PostRequest getPostRequestObj()
    {
        return PostRequestObj;
    }

    public Validations getValidationsObj()
    {
        return ValidationsObj;
    }

    public MapUtils getMapUtilsObj()
    {
        return MapUtilsObj;
    }

    public FileUtils getFileUtilsObj()
    {
        return FileUtilsObj;
    }
}
