import org.junit.After;
import org.junit.Before;
import steps.CalculationSteps;
import steps.MainSteps;
import utils.Init;
import org.junit.Test;
public class MyTest {

/*    Сценарий:
1) перейти на https://www.sberbank.ru/person
2) в верхнем меню "навестись" на Ипотека - дождаться открытия выпадающего меню и выбрать "Ипотека на готовое жилье"
3) заполнить поля:
    стоимость недвижимости 5 180 000 ₽
    первоначальный взнос 3 058 000 ₽
    срок кредита 30 лет
    снять галочку - есть зарплатная карта сбербанка
    дождаться появления "есть возможность подтвердить доход справкой"
    поставить галочку "молодая семья"
4) проверить значение полей
    сумма кредита 2 122 000 ₽
    ужемесячный платеж 18 937 ₽
    необходимый доход 31 561 ₽
    процентная ставка 11% - тут ошибка (специально)
*/

    @Before
    public void gettingStarted() {
        Init.gettingStarted();
    }

    @Test
    public void test() {
        MainSteps mainSteps = new MainSteps();
        mainSteps
                .goToMenu("Ипотека")
                .goToSubMenu("Ипотека на готовое жильё");

        CalculationSteps calculationSteps = new CalculationSteps();
        calculationSteps
                .input("Стоимость недвижимости", "5 180 000 ₽")
                .input("Первоначальный взнос", "3 058 000 ₽")
                .input("Срок кредита", "30 лет")
                .off("Есть зарплатная карта Сбербанка")
                .wait("Есть возможность подтвердить доход справкой")
                .on("Молодая семья")
                .check("Сумма кредита", "2 122 000 ₽")
                .check("Ежемесячный платеж", "17 535 ₽")
                .check("Необходимый доход", "29 224 ₽")
                .check("Процентная ставка", "10 %");
    }

    @After
    public void shutDown() {
        Init.shutDown();
    }
}