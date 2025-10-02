package io.loop.pages;

public class POM {

    private LoginPageDocuport loginPage;
    private GoogleSearchPage googleSearchPage;
    private ProductPage productPage;
    private ReceivedDocsPage receivedDocsPage;
    private LeftNavigatePage leftNavigatePage;
    private MyUploadsPage myUploads;
    private InvitationsPage invitations;


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

    public ReceivedDocsPage getReceivedDocsPage() {
        if (receivedDocsPage == null){
            receivedDocsPage = new ReceivedDocsPage();
        }
        return receivedDocsPage;
    }

    public LeftNavigatePage getLeftNavigatePage() {
        if (leftNavigatePage == null){
            leftNavigatePage = new LeftNavigatePage();
        }
        return leftNavigatePage;
    }

    public MyUploadsPage getMyUploadsPage() {
        if (myUploads == null){
            myUploads = new MyUploadsPage();
        }
        return myUploads;
    }

    public InvitationsPage getInvitationsPage() {
        if (invitations == null){
            invitations = new InvitationsPage();
        }
        return invitations;
    }
}
