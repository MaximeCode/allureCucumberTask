package steps;

import io.qameta.allure.Step;
import pages.CalculationPage;

public class CalculationSteps {

    private CalculationPage calculation = new CalculationPage();

    @Step("Ввести в поле <{0}> значение <{1}>")
    public CalculationSteps input(String keywords, String value) {
        calculation.input(keywords, value);
        return this;
    }

    @Step("Cнять галочку <{0}>")
    public CalculationSteps off(String keywords) {
        calculation.off(keywords);
        return this;
    }

    @Step("Дождаться появление галочки <{0}>")
    public CalculationSteps wait(String keywords) {
        calculation.wait(keywords);
        return this;
    }

    @Step("Поставить галочку <{0}>")
    public CalculationSteps on(String keywords) {
        calculation.on(keywords);
        return this;
    }

    @Step("Проверить, что в поле <{0}> стоит значение <{1}>")
    public CalculationSteps check(String keywords, String value) {
        calculation.check(keywords, value);
        return this;
    }
}
