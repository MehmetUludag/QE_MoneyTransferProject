package com.testinium.pageModels;

import com.testinium.base.BaseTest;
import com.testinium.methods.BaseSteps;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.IOException;


public class LoginPage extends BaseTest {

    public BaseSteps baseSteps;

    public LoginPage() throws IOException {
        this.baseSteps = new BaseSteps();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[text()='Login']")
    public WebElement loginBtn;



    @Step("Login ekranında kullanıcı adı <userName> girilir")
    public void enterUsername(String userName) {

            baseSteps.waitBySeconds(1);
            usernameInput.sendKeys(userName);
            logger.info("{} elementine {} texti yazıldı.", usernameInput, userName);

    }

    @Step("Login ekranında şifre <key> girilir")
    public void enterPassword(String password) {

            baseSteps.waitBySeconds(1);
            passwordInput.sendKeys(password);
            logger.info("{} elementine {} texti yazıldı.", passwordInput, password);

    }

    @Step("Login butonuna tıklanır")
    public void clickLoginBtn() {
        baseSteps.clickElementWithText("Login");
        baseSteps.waitBySeconds(5);
        logger.info("Login butonun tiklandi");
    }

    @Step("Login ekranı kontrol edilir")
    public void checkLoginPage() {
        assertTrue(usernameInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(loginBtn.isDisplayed());
        logger.info("Login ekrani kontrol edildi");
    }

}