package com.testinium.pageModels;

import com.testinium.base.BaseTest;
import com.testinium.methods.BaseSteps;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppStarterPage  extends BaseTest {



    public AppStarterPage() throws IOException{
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Challenge name:']")
    private WebElement challengeName;

    @FindBy(xpath = "//span[text()='Start time:']")
    private WebElement startTime;

    @FindBy(xpath = "//span[text()='End time:']")
    private WebElement endTime;

    @FindBy(xpath = "//span[text()='Manager name:']")
    private WebElement managerName;

    @FindBy(xpath = "//span[text()='Company name:']")
    private WebElement companyName;

    @FindBy(xpath = "//div[text()='Logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//div[text()='Open Money Transfer']")
    private WebElement openMoneyTrnsferBtn;

    @Step("Uygulama giriş ekranı kontrol edilir")
    public void checkAppScreen() {
        assertTrue(challengeName.isDisplayed());
        assertTrue(startTime.isDisplayed());
        assertTrue(endTime.isDisplayed());
        assertTrue(managerName.isDisplayed());
        assertTrue(companyName.isDisplayed());
        assertTrue(logoutBtn.isDisplayed());
        assertTrue(openMoneyTrnsferBtn.isDisplayed());
        logger.info("Uygulama giris ekranı elementleri kontrol edildi.");
    }

    @Step("Uygulama giriş ekranında uygulamaya giriş butonuna tıklanır")
    public void clickOpenMoneyTransferButton() {
        openMoneyTrnsferBtn.click();
        logger.info("Uygulama giris butonuna tiklandi.");
    }


    @Step("Çıkış butonuna tıklanır")
    public void clickExitButton() {
        logoutBtn.click();
        logger.info("Uygulama çikis butonuna tiklandi.");
    }



}
