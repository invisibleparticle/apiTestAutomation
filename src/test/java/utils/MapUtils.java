package utils;

import baseClasses.ScenarioSpecific;

import java.util.HashMap;

/**
 * Map related utilities
 */
public class MapUtils
{
    /**
     * Put input in map.Input should be key1:value1,-key2:value2
     *
     * @param map   Hashmap where the value/s to be added
     * @param input key value pair in form of key1:value1,-key2:value2
     * @return In case of success returns $$pass$$ else returns exception
     */
    public String putInMap(HashMap map, String input)
    {
        String result = ScenarioSpecific.passKey;
        try
        {
            String[] fields = input.split(",-");
            for (int i = 0; i < fields.length; i++)
            {
                String[] field = fields[i].trim().split(":");
                map.put(field[0], field[1]);

            }
        } catch (Exception e)
        {
            result = e.toString();
        }
        return result;

    }
}
