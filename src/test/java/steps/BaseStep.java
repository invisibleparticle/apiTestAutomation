package steps;

import baseObjects.*;

public class BaseStep
{

    private ScenarioSpecific scenarioObj;//scenario specific object

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

}
