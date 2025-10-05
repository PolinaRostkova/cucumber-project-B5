package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TernsAndConditionsPage {
    public TernsAndConditionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[contains(.,'SERVICE')]")
    private WebElement serviceText;

    public String getServiceText() {
        return serviceText.getText();
    }
}
