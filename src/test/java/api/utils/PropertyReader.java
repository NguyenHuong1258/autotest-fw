package api.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties prop;
    private final String propPath = "src/main/resources/typicode.properties";
    private static volatile PropertyReader propertyReader;

    private PropertyReader(){
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propPath));
            prop = new Properties();

            try {
                prop.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("Configuration file is not found at: " + propPath);
        }
    }

    public static synchronized PropertyReader getInstance(){

        if(propertyReader == null){
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }

    /**
     * get baseURL
     * @return
     */
    public String getBaseUrl(){
        String baseUrl = prop.getProperty("baseUrl");
        if (baseUrl != null) return baseUrl;
        else throw new RuntimeException("baseUrl not specified in the typicode.properties file.");
    }

    /**
     * get token
     * @return
     */
    public String getToken(){
        String token = prop.getProperty("token");
        if (token != null) return token;
        else throw new RuntimeException("token not specified in the properties file.");
    }

    /**
     * get Key
     * @return
     */
    public String getKey(){
        String key = prop.getProperty("key");
        if (key != null) return key;
        else throw new RuntimeException("key not specified in the properties file.");
    }

}
