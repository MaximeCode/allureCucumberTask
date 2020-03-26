package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    private By alertLocator = By.xpath("//a[@title='Закрыть предупреждение']");
    private By frameLocator = By.xpath("//iframe[@title='Основной контент']");
    private String menuLocator = "//span[@class='lg-menu__text' and text()='%s']";

    public void goToMenu(String keywords) {
        closeAlert();
        new Actions(driver)
                .moveToElement(waitToBeClickable(By
                .xpath(String.format(menuLocator, keywords))))
                .perform();
    }

    public void goToSubMenu(String keywords) {
        waitToBeClickable(By.partialLinkText(keywords)).click();
        driver.switchTo().frame(waitToBeVisible(frameLocator));
    }

    private void closeAlert() {
        By locator = alertLocator;
        while (true) {
            try {
                waitToBeClickable(locator).click();
                break;
            }
            catch (Exception ignored) {}

            try {
                waitPresence(locator);
            }
            catch (TimeoutException ignored) {
                break;
            }
        }
    }
}
