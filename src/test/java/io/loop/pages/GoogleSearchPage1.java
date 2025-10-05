package io.loop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.loop.utilities.Driver;

public class GoogleSearchPage1 {

    public GoogleSearchPage1() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "input-14")
    public WebElement element;



}
