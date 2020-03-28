package glue;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.CalculationPage;
import pages.MainPage;
import utils.Init;

import java.util.Map;

public class StepDefinitions {

    private MainPage main = new MainPage();
    private CalculationPage calculation = new CalculationPage();


    @Когда("Перейти на \"(.*)\".")
    public void gettingStarted(String keywords) {
        Init.gettingStarted(keywords);
    }

    @Когда("Навести курсор на пункт \"(.*)\" в верхнем меню, дождаться открытия выпадающего меню.")
    public void goToMenu(String keywords) {
        main.goToMenu(keywords);
    }

    @Когда("Выбрать пункт \"(.*)\".")
    public void goToSubMenu(String keywords) {
        main.goToSubMenu(keywords);
    }

    @Когда("Ввести в поля значения:")
    public void input(Map<String, String> entries) {
        entries.forEach((key, value) -> calculation.input(key, value));
    }

    @Когда("Снять галочку \"(.*)\".")
    public void off(String keywords) {
        calculation.off(keywords);
    }

    @Тогда("Дождаться изменения галочки \"(.*)\".")
    public void wait(String keywords) {
        calculation.wait(keywords);
    }

    @Когда("Поставить галочку \"(.*)\".")
    public void on(String keywords) {
        calculation.on(keywords);
    }

    @Тогда("Проверить значения полей:")
    public void check(Map<String, String> entries) {
        entries.forEach((key, value) -> calculation.check(key, value));
    }
}
