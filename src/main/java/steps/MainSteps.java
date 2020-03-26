package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    private MainPage main = new MainPage();

    @Step("Навести курсор на пункт 'Ипотека' В верхнем меню, дождаться открытия выпадающего меню.")
    public MainSteps goToMenu(String keywords) {
        main.goToMenu(keywords);
        return this;
    }

    @Step("Выбрать пункт 'Ипотека на готовое жилье'.")
    public void goToSubMenu(String keywords) {
        main.goToSubMenu(keywords);
    }
}
