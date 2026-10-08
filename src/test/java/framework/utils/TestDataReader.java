package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static Properties properties;

    static {

        properties = new Properties();

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/testdata.properties"
                    );

            properties.load(file);

            file.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load testdata.properties",
                    e
            );
        }
    }

    public static String getProperty(
            String key) {

        String value =
                properties.getProperty(key);

        if (value == null) {

            throw new RuntimeException(
                    "Test data not found: " + key
            );
        }

        return value;
    }
}