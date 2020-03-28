package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;

import java.util.List;

public class CalculationPage extends BasePage {

    public void input(String keywords, String value) {
        WebElement element = waitToBeClickable(getInput(keywords));
        value = value.replaceAll("\\D", "");
        while (true) {
            element.clear();
            element.sendKeys(value);
            if (value.equals(element.getAttribute("value").replaceAll("\\D", ""))) {
                try {
                    String finalValue = value;
                    wait.until(driver -> !finalValue.equals(element.getAttribute("value").replaceAll("\\D", "")));
                }
                catch (TimeoutException e) {
                    String oldValue = getValue("Ежемесячный платеж");
                    try {
                        wait.until((driver) -> !oldValue.equals(getValue("Ежемесячный платеж")));
                    }
                    catch (TimeoutException ignored) {
                    }
                    break;
                }
            }
        }
    }

    public void on(String keywords) {
        scrollDown();
        WebElement toggle = getToggle(keywords);
        if (toggle == null) {
            System.out.println("Переключатель <" + keywords + "> не найден.");
            return;
        }
        if (!toggle.getAttribute("class").contains("dcCalc_switch_checked"))
            switchToggle(keywords, toggle);
    }

    public void off(String keywords) {
        scrollDown();
        WebElement toggle = getToggle(keywords);
        if (toggle == null) {
            System.out.println("Переключатель <" + keywords + "> не найден.");
            return;
        }
        if (toggle.getAttribute("class").contains("dcCalc_switch_checked"))
            switchToggle(keywords, toggle);
    }

    private void switchToggle(String keywords, WebElement toggle) {
        String value = getValue("Ежемесячный платеж");
        while (true) {
            String toggleClass = toggle.getAttribute("class");
            toggle.click();
            try {
                wait.until(driver -> !toggleClass.equals(toggle.getAttribute("class")));
                break;
            }
            catch (TimeoutException ignored) {
            }
        }
        System.out.println("Клик по переключателю <" + keywords + ">.");
        wait.until((driver) -> !value.equals(getValue("Ежемесячный платеж")));
        while (true) {
            String loopValue = getValue("Ежемесячный платеж");
            try {
                wait.until((driver) -> !loopValue.equals(getValue("Ежемесячный платеж")));
            }
            catch (TimeoutException e) {
                break;
            }
        }
    }

    public void wait(String keywords) {
        wait.until((driver) -> getToggle(keywords) != null);
    }

    public void check(String keywords, String value) {
        System.out.println("Ожидаемое значение поля <" + keywords + "> " + value
                + ", в действительности это значение " + getValue(keywords) + ".");
        Assert.assertEquals(value, getValue(keywords));
    }

    private WebElement getInput(String keywords) {
        List<WebElement> elements = waitElementsToBeVisible(By.xpath("//div[@class='dcCalc_input-row-tablet__label']"));
        return elements
                .stream()
                .filter(element -> element.getText().contains(keywords))
                .map(element -> element.findElement(By.xpath("./..//input")))
                .findFirst()
                .orElse(null);
    }

    private String getValue(String keywords) {
        List<WebElement> elements = waitElementsToBeVisible(By.xpath("//div[@class='dcCalc_result-calculation__title']"));
        return elements
                .stream()
                .filter(element -> element.getText().contains(keywords))
                .map(element -> element.findElement(By.xpath("./..//span")).getText())
                .findFirst()
                .orElse("не найдено");
    }

    private void scrollDown() {
        ((Locatable) waitToBeVisible(By.xpath("//div[contains(text(), 'не является публичной офертой')]")))
                .getCoordinates().inViewPort();
    }

    public WebElement getToggle(String keywords) {
        List<WebElement> elements = waitElementsToBeVisible(By.xpath("//div[@class='dcCalc_switch-tablet__title']"));
        return elements
                .stream()
                .filter(element -> element.getText().contains(keywords))
                .map(element -> element.findElement(By.xpath("./..//label")))
                .findFirst()
                .orElse(null);
    }
}