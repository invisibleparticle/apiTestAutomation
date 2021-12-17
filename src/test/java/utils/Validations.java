package utils;

import baseClasses.ScenarioSpecific;

/**
 * validations items
 */
public class Validations
{
    /**
     * Used to validate scenarioObj.apiResponse with validationsData input.
     * Validation format is jsonPathOfField1:expectedValue,-jsonPathOfField2:expectedValue
     *
     * @param scenarioObj     Needs ScenarioSpecific object which has apiResponse value set for validation
     * @param validationsData Validation input data as jsonPathOfField1:expectedValue,-jsonPathOfField2:expectedValue
     * @return In case of success returns $$pass$$ else returns specific field and details of what got failed
     */
    public String validation(ScenarioSpecific scenarioObj, String validationsData)
    {

        String result = ScenarioSpecific.passKey;
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

}
