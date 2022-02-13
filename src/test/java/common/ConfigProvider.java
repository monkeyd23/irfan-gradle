package common;

import java.util.Properties;

public class ConfigProvider {

    static ConfigProvider instance;
    Properties configProperties;

    private ConfigProvider() {

    }

    static ConfigProvider getInstance() {
        if (instance == null) instance = new ConfigProvider();
        return instance;
    }

    Properties initProperties() {

    }

}
