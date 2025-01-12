package com.testinium.pageModels;

import com.testinium.base.BaseTest;
import com.testinium.methods.BaseSteps;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyransferPage extends BaseTest {

    public BaseSteps baseSteps;

    @FindBy(xpath = "//div[text()='Back']")
    private WebElement backBtn;

    @FindBy(xpath = "//div[text()='Transfer money']")
    private WebElement transferBtn;

    @FindBy(xpath = "//div[text()='Add money']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[text()='My account']")
    private WebElement myAccountTitle;

    @FindBy(xpath = "//div[text()='Account name']")
    private WebElement accountNameTitle;

    @FindBy(xpath = "//div[text()='Account type']")
    private WebElement accountTypeTitle;

    @FindBy(xpath = "//div[text()='Creation time']")
    private WebElement creationTimeTitle;

    @FindBy(xpath = "//div[text()='Amount']")
    private WebElement amountTitle;

    @FindBy(xpath = "//div[text()='Transactions']")
    private WebElement transactionsTitle;

    @FindBy(css = ".css-146c3p1.r-ubezar.r-vw2c0b")
    private WebElement transferMoneyTitle;

    @FindBy(xpath = "//div[text()='Sender account']")
    private WebElement senderAccountTitle;

    @FindBy(xpath = "//div[text()='Receiver account']")
    private WebElement receiverAccountTitle;

    @FindBy(css = ".css-146c3p1.r-1ozpqpt.r-g6644c.r-1b43r93")
    private WebElement transferAmountTitle;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendBtn;

    @FindBy(xpath = "//div[text()='Edit account']")
    private WebElement editAccount;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    private WebElement amountInput;

    @FindBy(xpath = "//div[@class='css-175oi2r r-1777fci']")
    private WebElement senderAccountListBtn;

    @FindBy(xpath = "//div[text()='Receiver account']/following-sibling::div[@class='css-175oi2r r-1777fci']")
    private WebElement receiverAccountListBtn;

    @FindBy(xpath = "//div[text()='Card number']/following-sibling::input")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//div[text()='Card holder']/following-sibling::input")
    private WebElement cardholderInput;

    @FindBy(xpath = "//input[@placeholder='MM/YY']")
    private WebElement expiryDate;

    @FindBy(xpath = "//div[text()='CVV']/following-sibling::input")
    private WebElement cvvInput;

    @FindBy(xpath = "//div[text()='Amount']/following-sibling::input")
    private WebElement cardAmountInput;

    @FindBy(xpath = "//div[text()='Add']/..")
    private WebElement addFromCardBtn;

    @FindBy(xpath = "//div[text()='Account name']/following-sibling::div//input")
    private WebElement enterAccountName;

    @FindBy(xpath = "//div[text()='UPDATE']")
    private WebElement updateAccountName;


    public MoneyransferPage() throws IOException {
        this.baseSteps = new BaseSteps();
        PageFactory.initElements(driver, this);
    }

    @Step("Para transfer sayfası kontrol edilir")
    public void checkMoneyTransferScreen() {
        assertTrue(backBtn.isDisplayed());
        assertTrue(addBtn.isDisplayed());
        assertTrue(transferBtn.isDisplayed());
        assertTrue(editAccount.isDisplayed());
        assertTrue(myAccountTitle.isDisplayed());
        assertTrue(accountNameTitle.isDisplayed());
        assertTrue(accountTypeTitle.isDisplayed());
        assertTrue(creationTimeTitle.isDisplayed());
        assertTrue(amountTitle.isDisplayed());
        assertTrue(transactionsTitle.isDisplayed());
        logger.info("Para transfer sayfası elementleri kontrol edildi.");
    }

    @Step("Para transferi penceresi elementleri kontrol edilir")
    public void checkMoneyTransferWindow() {
        assertTrue(transferMoneyTitle.isDisplayed());
        assertTrue(senderAccountTitle.isDisplayed());
        assertTrue(receiverAccountTitle.isDisplayed());
        assertTrue(transferAmountTitle.isDisplayed());
        assertTrue(sendBtn.isDisplayed());
        logger.info("Para transfer penceresi elementleri kontrol edildi.");
    }

    @Step("Para transferi butonuna tıklanır")
    public void clickTransferMoneyButton(){transferBtn.click();}

    @Step("Gönderilecek para tutarı <text> girilir")
    public void enterAmount(String text){amountInput.sendKeys(text);}

    @Step("Para gönder butonuna tıklanır")
    public void clickSendMoneyButton(){
        sendBtn.click();
    }

    @Step("Gönderici hesap listesi butonuna tıklanır")
    public void clickSenderAccountListButton(){
        senderAccountListBtn.click();
    }

    @Step("Alıcı hesap listesi butonuna tıklanır")
    public void clickReceiverAccountListButton(){
        receiverAccountListBtn.click();
    }

    @Step("Kart numarası <text> girilir")
    public void enterCardNumber(String text){
        cardNumberInput.sendKeys(text);
    }

    @Step("Kart sahibi <text> girilir")
    public void enterCardHolder(String text){
        cardholderInput.sendKeys(text);
    }

    @Step("Son kullanma tarihi <text> girilir")
    public void enterExpriyDate(String text){
        expiryDate.sendKeys(text);
    }

    @Step("Cvv <text> girilir")
    public void enterCvv(String text){
        cvvInput.sendKeys(text);
    }

    @Step("Karttan yüklenecek tutar <text> girilir")
    public void enterCardAmount(String text){
        cardAmountInput.sendKeys(text);
    }

    @Step("Karttan ekle butonuna tıklanır")
    public void addMoneyFromCard(){
        addFromCardBtn.click();
    }

   @Step("Para ekle butonuna tıklanır")
    public void clickAddButton(){
       addBtn.click();
    }

   @Step("Hesap adı değiştir butonuna tıklanır")
    public void clickEditAccountButton(){
       editAccount.click();
    }

   @Step("Hesap adı değiştirme alanına yeni hesap adı <text> girilir")
    public void enterAccountName(String text){
       enterAccountName.sendKeys(text);
    }

    @Step("Hesap adı güncelle butonuna tıklanır")
    public void updateAccountButton(){
        updateAccountName.click();
    }

    @Step("Geri butonuna tıklanır")
    public void clickBackButton(){
        backBtn.click();
    }


}
