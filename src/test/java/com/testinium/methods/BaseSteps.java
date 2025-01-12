package com.testinium.methods;

import com.testinium.base.BaseTest;
import com.testinium.model.ElementInfo;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class BaseSteps extends BaseTest {


    public BaseSteps() throws IOException {
        String currentWorkingDir = System.getProperty("user.dir");
        initMap(getFileList(currentWorkingDir + "/src"));
    }

    public WebElement findElement(String key) {
        By infoParam = getElementInfoToBy(findElementInfoByKey(key));
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }

    public By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        switch (elementInfo.getType()) {
            case "css":
                by = By.cssSelector(elementInfo.getValue());
                break;
            case ("name"):
                by = By.name(elementInfo.getValue());
                break;
            case "id":
                by = By.id(elementInfo.getValue());
                break;
            case "xpath":
                by = By.xpath(elementInfo.getValue());
                break;
            case "linkText":
                by = By.linkText(elementInfo.getValue());
                break;
            case ("partialLinkText"):
                by = By.partialLinkText(elementInfo.getValue());
                break;
        }
        return by;
    }

    public WebElement findElementWithKey(String key) {
        return findElement(key);
    }

    @Step("<key> elementinde <text> texine sahip elementine tıkla")
    public void selectClick(String key, String text){
        WebElement dropdown = findElementWithKey(key);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    @Step({"Wait <value> seconds",
            "<int> saniye bekle"})
    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Step({"Click on element with text <text>",
            "<text> metni olan elemente tikla"})
    public void clickElementWithText(String text) {
        if (!text.isEmpty()) {
            List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));

            if (!elements.isEmpty()) {
                elements.get(0).click();
                logger.info("'" + text + "' metni olan elemente tıklandı.");
            } else {
                logger.error("'" + text + "' metni olan element bulunamadı.");
            }
        } else {
            logger.error("Metin değeri boş.");
        }
    }


    @Step({"Go to <url> address",
            "<url> adresine git"})
    public void goToUrl(String url) {
        driver.get(url);
        logger.info(url + " adresine gidiliyor.");
    }

    @Step({"Clear text of element <key>",
            "<key> elementinin text alanini temizle"})
    public void clearInputArea(String key) {
        findElement(key).clear();
    }


    @Step({"<key> li elementi bul ve degerini <saveKey> olarak sakla",
            "Find element by <key> and save its value as <saveKey>"})
    public void saveValueByKey(String key, String saveKey) throws InterruptedException {
        WebElement element;
        int waitVar = 0;
        element = findElementWithKey(key);
        while (true) {
            if (element.isDisplayed()) {
                String elementValue = element.getAttribute("value");
                saveValue(saveKey, elementValue);
                logger.info("WebElement is found at: " + waitVar + " second.");
                //logger.info("Saved value as '" + saveKey + "': " + elementValue);
                logger.info("["+getValue(saveKey)+"]" + " degeri ["+ saveKey + "] ismiyle hafizaya kaydedildi");
                break;
            } else {
                waitVar = waitVar + 1;
                Thread.sleep(1000);
                if (waitVar == 20) {
                    throw new NullPointerException(String.format("by = %s Web element list not found"));
                }
            }
        }
    }

    @Step({"<key> li elementin text degerini hafizada <saveKey> olarak saklanan text ile karsilastir"})
    public void checkTextByKeyAndSaveKey(String key, String saveKey) {
        try {
            System.out.println("------------------------------------------------------");

            WebElement element = findElementWithKey(key);
            String elementText = element.getText();
            logger.info("Beklenen Değer: " + elementText);

            String elementValue = getValue(saveKey);
            logger.info("Saklanan Değer: " + elementValue);

            System.out.println("------------------------------------------------------");

            assertTrue(elementText.contains(elementValue), "Degerler birbirine esit degil!");
        } catch (NoSuchElementException e) {
            logger.error("Key '" + key + "' ile ilgili element bulunamadı: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Bir hata oluştu: " + e.getMessage());
            throw e;
        }
    }

}