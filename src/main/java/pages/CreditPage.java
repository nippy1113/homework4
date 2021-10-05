package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;

public class CreditPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'kit-col_xs_12')]//h1")
    private WebElement title;

    @FindBy(xpath = "//div[@class='dc-input__input-container-5-3-5']//input")
    private List<WebElement> creditInfoFieldList;

    @FindBy(xpath = "//input[contains(@class,'switch-input')]")
    private List<WebElement> switchInputList;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/result-block']//span[contains(@class,'_1bsibu5PEmbeJ8n7-CXzcS')]/span")
    private List<WebElement> outputCreditInfo;

    public CreditPage checkOpenCreditPage() {
        Assert.assertTrue("Заголовок отсутствует/не соответствует требуемому",
                title.getText().contains("Ипотека"));
        return this;
    }


    /**
     * Заполняем поле стоимость недвижимости
     *
     * @return this - т.е. возвращает страничку {@link CreditPage}
     */

    public CreditPage fillCreditInfoField(String fieldName, String inputCost) {
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.xpath("//iframe[@id= 'iFrameResizer0']")));
        for (WebElement element : creditInfoFieldList) {
            if (element.findElement(By.xpath(".//../div")).getText().equals(fieldName)) {
                fillInputField(element, inputCost);
                driverManager.getDriver().switchTo().defaultContent();
                return this;
            }
        }
        Assert.fail("Поле '" + fieldName + "' не было найдено на транице!");
        return this;
    }


    /**
     * Кликаем оп кнопке страхование жизни и здороаья
     *
     * @return this - т.е. возвращает страничку {@link CreditPage}
     */

    public CreditPage clickOnSwitchInputButton(String switchInputButton) {
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.xpath("//iframe[@id = 'iFrameResizer0']")));
        for (WebElement element : switchInputList) {
            if (element.findElement(By.xpath(".//../../../..//*[@class ='_3IybUtY6Yr9rd371PHLM0l _10HUwAxpTF1A9OmpNaPW4m' or @class ='_1ZfZYgvLm4KBWPL41DOSO']")).getText().equals(switchInputButton)) {
                element.click();
                driverManager.getDriver().switchTo().defaultContent();
                return this;
            }
        }
        Assert.fail("Поле '" + switchInputButton + "' не было найдено на транице!");


        return this;
    }

    /**
     * проверяем данные по кредиту
     *
     * @return this - т.е. возвращает страничку {@link CreditPage}
     */
    public CreditPage checkData(String outputField, String value) {
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.xpath("//iframe[@id = 'iFrameResizer0']")));
        for (WebElement element : outputCreditInfo) {
            if (element.findElement(By.xpath(".//../../span[contains(@class,'_270')]")).getText().equals(outputField)) {
                Assert.assertEquals("Поле с информацией о кредите не равно ожидаемому значению!",
                        value,
                        Utils.convertPrice(element.getText()));
                driverManager.getDriver().switchTo().defaultContent();
                return this;
            }
        }
        Assert.fail("Поле '" + outputField + "' не было найдено на странице!");
        return this;
    }

    public CreditPage waitForIt(int miliSeconds) throws InterruptedException {
        Thread.sleep(miliSeconds);
        return this;
    }


}
