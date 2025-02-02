package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String uiPropertyValue(String key){
        Properties properties = new Properties();
        File propFile = new File("src/test/resources/uiCredentials.properties");
        try{
            FileInputStream inputStream=new FileInputStream(propFile);
            properties.load(inputStream);
        }catch(IOException ex){
            throw new RuntimeException("uiCredentials.properties file was not found",ex);
        }
        return properties.getProperty(key);
    }
    public static String apiPropertyValue(String key){
        Properties properties = new Properties();
        File propFile = new File("src/test/resources/apiCredentials.properties");
        try{
            FileInputStream inputStream=new FileInputStream(propFile);
            properties.load(inputStream);
        }catch(IOException ex){
            throw new RuntimeException("apiCredentials.properties file was not found",ex);
        }
        return properties.getProperty(key);
    }
    public static String databasePropertyValue(String key){
        Properties properties = new Properties();
        File propFile = new File("src/test/resources/databaseCredentials.properties");
        try{
            FileInputStream inputStream=new FileInputStream(propFile);
            properties.load(inputStream);
        }catch(IOException ex){
            throw new RuntimeException("databaseCredentials.properties file was not found",ex);
        }
        return properties.getProperty(key);
    }
}
