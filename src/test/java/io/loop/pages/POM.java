package io.loop.pages;

public class POM {

    private LoginPageDocuport loginPage;
    private GoogleSearchPage googleSearchPage;
    private ProductPage productPage;


    public LoginPageDocuport getLoginPage() {
        if (loginPage == null){
            loginPage = new LoginPageDocuport();
        }
        return loginPage;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        if (googleSearchPage == null){
            googleSearchPage = new GoogleSearchPage();
        }
        return googleSearchPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null){
            productPage = new ProductPage();
        }
        return productPage;
    }
}
