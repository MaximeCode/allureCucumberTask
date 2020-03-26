package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static WebDriver INSTANCE;

    private Driver() {}

    public static WebDriver getInsance() {
        if (INSTANCE == null) {
            TestProperties properties = TestProperties.getInsance();
            System.setProperty(properties.getProperty("driver_key"), properties.getProperty("driver_value"));
            INSTANCE = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        }
        return INSTANCE;
    }
}
