package utils;

import org.openqa.selenium.WebDriver;

public class Init {

    private static WebDriver driver = Driver.getInsance();
    private static String url = TestProperties.getInsance().getProperty("url");

    public static void gettingStarted() {
        driver.get(url);
    }

    public static void gettingStarted(String url) {
        driver.get(url);
    }

    public static void shutDown() {
        driver.quit();
    }
}
