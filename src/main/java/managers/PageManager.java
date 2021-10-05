package managers;

import pages.CreditPage;
import pages.HomePage;


/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка страхование путешественников
     */
    private CreditPage creditPage;

//    /**
//     * Страничка выбора полиса или тарифа
//     */
//    private SelectInsuranceServicePage selectInsuranceServicePage;
//
//    /**
//     * Страничка оформления полиса страхования
//     */
//    private RegistrationFormPage registrationFormPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return StartPage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link CreditPage}
     *
     * @return InsurancePage
     */
    public CreditPage getCreditPage() {
        if (creditPage == null) {
            creditPage = new CreditPage();
        }
        return creditPage;
    }

}
