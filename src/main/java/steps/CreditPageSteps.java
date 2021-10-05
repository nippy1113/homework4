package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import managers.PageManager;

public class CreditPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем что открылась страница \"(.+)\"$")
    public void checkOpenCreditPage(String namePage) {
        pageManager.getCreditPage().checkOpenCreditPage();
    }

    @И("^Заполняем поля заполняем поля информации о кредите$")
    public void fillFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getCreditPage().fillCreditInfoField((String) key, (String) value));
    }


    @И("^Убираем галочку с поля \"(.+)\"$")
    public void clickOnSwitchInputButton(String switchInputButton) {
        pageManager.getCreditPage().clickOnSwitchInputButton(switchInputButton);
    }

    @И("^Проверяем заполнение полей$")
    public void checkData(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getCreditPage().checkData((String) key, (String) value));
    }
    @И("^Ждем \"(.+)\" милисекунд$")
    public void selectSubMenu(int miliSeconds) throws InterruptedException {
        pageManager.getCreditPage().waitForIt(miliSeconds);
    }

}
