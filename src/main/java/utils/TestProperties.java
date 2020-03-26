package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static TestProperties INSTANCE;
    private final Properties properties = new Properties();

    private TestProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/"
                    + System.getProperty("env", "env") + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInsance() {
        if (INSTANCE == null)
            INSTANCE = new TestProperties();
        return INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
