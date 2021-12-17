package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

/**
 * File related utilities
 */
public class FileUtils
{
    /**
     * Reads from properties file
     *
     * @param fileName Full path plus file name
     * @param inputKey Key we are searching for in .properties file
     * @return value of the key in .properties file if no key is present then returns null. This must be handled in calling method.
     * Catches java.io.IOException
     */
    public String readPropertiesFile(String fileName, String inputKey)
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

        } catch (java.io.IOException e)
        {
            return e.toString();
        }
    }


}
