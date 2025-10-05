package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.loop.pages.POM;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.DocuportConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

public class ClientStepsDefs {

    private Logger logger = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    POM pages = new POM();

    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        String actual;
        String expected;

        switch (text.toLowerCase().trim()) {
            case "login"-> {
              //actual = pages.getLoginPage().getLoginText().toLowerCase().trim();
              actual = "nadir";
              expected = text.toLowerCase().trim();
              softAssertions.assertThat(actual).isEqualTo(expected);
              logger.info(text + " is Displayed");
            }
            case "docuport" ->{
                //actual = pages.getLoginPage().docuportImage.getAttribute("alt").toLowerCase().trim();
                actual = "feyruz";
                expected = text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                logger.info(text + " is Displayed");
            }
            case "choose account" ->{
                BrowserUtils.waitForVisibility(pages.getLoginPage().chooseAccountText, DocuportConstants.LARGE);
                actual = pages.getLoginPage().chooseAccountText.getText().toLowerCase().trim();
                expected = text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                logger.info(text + " is Displayed");
            }
            default -> throw  new IllegalArgumentException("Invalid text");
        }

    }

    @Then("user validates all assertions")
    public void user_validates_all_assertions() {
        softAssertions.assertAll();
    }

}
