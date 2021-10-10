package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'kitt-top-menu__item_first')]/a[@role or @aria-expanded]")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//a[@data-cga_click_top_menu]")
    private List<WebElement> listSubMenu;

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    private WebElement cookiesButtonClose;

    /**
     * Функция наведения мыши на любой пункт меню
     *
     * @param nameBaseMenu - наименование меню
     * @return HomePage - т.е. остаемся на этой странице
     */
    public HomePage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : listBaseMenu) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return this;
            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }


    /**
     * Функция клика на любое подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return InsurancePage - т.е. переходим на страницу {@link CreditPage}
     */
    public CreditPage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : listSubMenu) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getCreditPage().checkOpenCreditPage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return pageManager.getCreditPage().checkOpenCreditPage();
    }

    /**
     * Закрытия сообщения cookies
     *
     * @return HomePage - т.е. остаемся на этой странице
     */
    public HomePage closeCookiesDialog() {
        waitUtilElementToBeClickable(cookiesButtonClose).click();
        return this;
    }


}
