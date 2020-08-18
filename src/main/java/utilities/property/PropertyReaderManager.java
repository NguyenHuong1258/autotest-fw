package utilities.property;

import java.util.Properties;

public class PropertyReaderManager {
    private static PropertyReaderManager instance;
    private static ConfigPropertyReader configPropertyReader;

    private PropertyReaderManager(){

    }

    public static PropertyReaderManager getInstance(){
        if (instance == null){
            return instance = new PropertyReaderManager();
        } else
            return instance;
    }

    public ConfigPropertyReader getConfigPropertiesReader(){
        return (configPropertyReader == null) ? new ConfigPropertyReader() : configPropertyReader;
    }
}
