package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.POM;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductStepDefs {

    POM pages = new POM();
    private static final Logger LOG = LogManager.getLogger();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("product.url"));
        LOG.info("User is on home page");
    }
    @Then("User should be able to see expected prices in the following products")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products(List<Map<String, String>> productDetails) {

        for (Map<String, String> productDetail : productDetails) {
            //click the category
            pages.getProductPage().clickCategory(productDetail.get("Category"));

            // get the actual price
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get("Product"));

            //get product expected price from table
            String expectedPrice = productDetail.get("expectedPrice");

            //do assertion
            assertEquals("Expected is NOT matching",  expectedPrice, actualPrice);
            LOG.info("Validation of the price for " + productDetail.get("Category") + ", for Product: " +  productDetail.get("Product"));
        }

    }

    @Then("User should be able to see expected prices in the following products with listOfLists")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products_with_list_of_lists(List<List<String>> productDetails) {
        int i = 0;
        for (List<String> productDetail : productDetails) {
            // category
            pages.getProductPage().clickCategory(productDetail.get(0));

            //get actual price for each product
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get(1));

            String expectedPrice = productDetail.get(2);

            //assertion
            assertEquals("Expected is NOT matching",  expectedPrice, actualPrice);
            LOG.info("Validation of the price for: " + productDetail.get(0) +  ", for Product: " +  productDetail.get(1) + ", actualPrice: " +  actualPrice + ", expectedPrice: " +  expectedPrice);

        }
    }

    @Then("user should be able to see the names")
    public void user_should_be_able_to_see_the_names(Map<String, List<String>> studentNamesInGroups) {
        List<String> actualNamesGroup2 = studentNamesInGroups.get("Group 2");
        List<String> actualNamesGroup3 = studentNamesInGroups.get("Group 3");
        System.out.println("ActualNamesGroup2: " + actualNamesGroup2
        + " ActualNamesGroup3: " + actualNamesGroup3);

    }

    @Then("User should be able to see expected prices in the following products with map")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products_with_map(Map<String, List<String>> productDetails) {

        int i = 0;
        for ( Map.Entry<String, List<String>> productDetail : productDetails.entrySet()) {
            String category = productDetail.getKey();;
            List<String>  productName = productDetail.getValue();

            for (String product : productName) {
                try {
                    String[] expectedPrice = product.split("-");
                    String product1 = expectedPrice[i].trim();
                    String price = expectedPrice[i + 1].trim();

                    pages.getProductPage().clickCategory(category);

                    String actualPrice = pages.getProductPage().getProductPrice(product1);

                    assertEquals("Expected is NOT matching", price, actualPrice);
                    LOG.info("Expected price = {}, actual price = {}", price, actualPrice);
                }catch (NullPointerException e){
                    e.getMessage();
                }

            }




        }

    }

}
