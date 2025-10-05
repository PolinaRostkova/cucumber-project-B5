package io.loop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.loop.utilities.Driver;

public class LoopCampPage {

    public LoopCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "input_comp-k8h65pgn2")
    public WebElement emailEmailinput;

    @FindBy(id = "input_comp-k8h6ltbn")
    public WebElement nameTextinput;

    @FindBy(id = "input_comp-k8h6ltbr2")
    public WebElement emailEmailinput1;

    @FindBy(id = "input_comp-k8h72tju")
    public WebElement subjectTextinput;

    @FindBy(id = "textarea_comp-k8h6ltbv3")
    public WebElement textareaCompK8h6ltbv3Textarea;

    @FindBy(id = "SKIP_TO_CONTENT_BTN")
    public WebElement skipToContentBtnButton;

    @FindBy(xpath = "//button[@aria-label='Play']")
    public WebElement playButton;

    @FindBy(xpath = "//button[@aria-label='Subscribe']")
    public WebElement subscribeButton;

    @FindBy(xpath = "//button[@aria-label='Send']")
    public WebElement sendButton;

}
