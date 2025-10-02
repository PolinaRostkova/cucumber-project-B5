package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceivedDocsPage {

    public ReceivedDocsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='subtitle-2 text-none' and .='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='v-btn__content' and .=' Search ']")
    private WebElement searchSubmitButton;

    @FindBy(xpath = "//label[.='Document name']/following-sibling::input")
    private WebElement documentNameInput;

    @FindBy(xpath = "//label[.='Upload date']/following-sibling::input")
    private WebElement uploadDateInput;

    @FindBy(xpath = "//div[@class='v-select__selections']/input")
    private WebElement tagsDropDown;

    @FindBy(xpath = "//div[@role='combobox']/div/label[.='Uploaded by']/following-sibling::input[1]")
    private WebElement uploadedByInput;

    @FindBy(xpath = "//span[@class='v-chip__content']/span[.='Other Documents']")
    private WebElement otherDocumentsDropdownTags;

    @FindBy(xpath = "//span[@class='v-chip__content']/span[.='IRS/State Letter']")
    private WebElement irsStateLetterDropdownTags;

    @FindBy(xpath = "//div[@class='v-btn__content' and .='16']")
    private WebElement date9$16$25;

    @FindBy(xpath = "//div[@class='v-list-item__title' and .='advisor advisor']")
    private WebElement advisorAdvisorTitle;

    @FindBy(xpath = "//p[@class='mb-0 subtitle-1']")
    private WebElement searchMassage;

    public String getSearchMassage() {
        return searchMassage.getText();
    }

    public void clickDate(String date) {
        switch (date.toLowerCase().trim()) {
            case "9-6-25" -> BrowserUtils.waitForClickable(date9$16$25, DocuportConstants.LARGE).click();
            default -> throw new IllegalArgumentException("No such date " + date);
        }
    }

    public void clickDropdown(String dropdownName){
        switch (dropdownName.toLowerCase().trim()){
            case "tags" -> BrowserUtils.waitForClickable(tagsDropDown, DocuportConstants.LARGE).click();
            case "uploaded by" -> BrowserUtils.waitForClickable(uploadedByInput, DocuportConstants.LARGE).click();
            default -> throw new  IllegalArgumentException("Dropdown name not found");
        }
    }

    public void clickDropdownOption(String dropdownOption){
        switch (dropdownOption.toLowerCase().trim()){
            case "other documents" -> BrowserUtils.waitForClickable(otherDocumentsDropdownTags, DocuportConstants.LARGE).click();
            case "irs state letter" -> BrowserUtils.waitForClickable(irsStateLetterDropdownTags, DocuportConstants.LARGE).click();
            case "advisor advisor" -> BrowserUtils.waitForClickable(advisorAdvisorTitle, DocuportConstants.LARGE).click();
            default -> throw new  IllegalArgumentException("Dropdown option not found");
        }
    }

    public void clickButton(String button) {
        switch (button.toLowerCase().trim()) {
            case "search" -> BrowserUtils.waitForClickable(searchButton, DocuportConstants.LARGE).click();
            case "search submit" -> BrowserUtils.waitForClickable(searchSubmitButton, DocuportConstants.LARGE).click();
            case "tags", "uploaded by" -> clickDropdown(button);
            case "upload date"-> BrowserUtils.waitForClickable(uploadDateInput, DocuportConstants.LARGE).click();
            default -> throw new IllegalArgumentException("No such button: " + button);
        }
    }

    public void insertField(String field, String input) {
        switch (field.toLowerCase().trim()) {
            case "document name" -> BrowserUtils.waitForVisibility(documentNameInput, DocuportConstants.LARGE).sendKeys(input);
            default -> throw new IllegalArgumentException("No such a field: " + field);
        }
    }
}
