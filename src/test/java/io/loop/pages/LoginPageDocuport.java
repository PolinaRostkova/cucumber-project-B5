package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDocuport {

    public LoginPageDocuport() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@class='text-none body-2 font-weight-medium v-btn v-btn--has-bg theme--light v-size--default success']")
    public WebElement contButton;

    @FindBy(xpath = "//img[@alt='Docuport']")
    public WebElement docuportImage;

    /**
     * Login to docuport
     * @param username
     * @param password
     */

    public void docuportLogin(String username, String password) throws InterruptedException {
        BrowserUtils.waitForClickable(loginButton, 10);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();

        Thread.sleep(3000);
        if(BrowserUtils.waitForVisibility(contButton, 10).isDisplayed()) {
           contButton.click();
        }
    }
}
