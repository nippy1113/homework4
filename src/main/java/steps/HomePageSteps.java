package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class HomePageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Закрываем окошко Cookies$")
    public void closeCookiesDialog() {
        pageManager.getHomePage().closeCookiesDialog();
    }

    @И("^Выбираем \"(.+)\" в главном меню$")
    public void selectBaseMenu(String nameMenu) {
        pageManager.getHomePage().selectBaseMenu(nameMenu);
    }

    @И("^Выбираем \"(.+)\" в подменю главного меню$")
    public void selectSubMenu(String nameSubMenu) {
        pageManager.getHomePage().selectSubMenu(nameSubMenu);
    }


}
