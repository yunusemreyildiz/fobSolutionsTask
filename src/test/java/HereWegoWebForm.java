import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HereWegoWebForm extends PageObject{

    @FindBy(xpath = "//*[@id=\"searchbar\"]/div/div/input")
    private WebElement locationSearchInputArea;

    @FindBy(xpath = "//*[@id=\"searchbar\"]/div/div[2]/div[1]")
    private WebElement firstLocationSuggestion;

    @FindBy(xpath = "//*[@id=\"itinerary_item_0\"]/div[2]/div[1]")
    private WebElement firstDestinationSuggestion;

    @FindBy(id="itinerary_item_input_0")
    private WebElement destinationSearchInputArea;

    @FindBy(id="sign-in-email")
    private WebElement emailInputArea;

    @FindBy(id="sign-in-password-encrypted")
    private WebElement passwordInputArea;

    @FindBy(id="signInBtn")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"destination_pdc\"]/div/div/div[1]/div[3]/div/div[3]/button/span")
    private WebElement collectionIcon;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div/div/div[2]/ul/li/div[2]")
    private WebElement collectionsFolder;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div/div/div[2]/button[2]")
    private WebElement doneButtonForAdd;

    @FindBy(xpath = "//*[@id=\"directions_header\"]/div[1]/button")
    private WebElement menuIcon;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div/div[1]/div[3]/a")
    private WebElement collections;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[1]/div/div[2]/div/div/h4/a")
    private WebElement collectionsList;


    public void enterFirstLocation(){
        this.locationSearchInputArea.sendKeys(Constants.ADDRESS1);
    }

    public void enterDestiationLocation(){
        this.destinationSearchInputArea.sendKeys(Constants.ADDRESS2);
    }

    public void enterEmail(){
        this.emailInputArea.click();
        this.emailInputArea.sendKeys(Constants.EMAIL);
    }

    public void enterPassword(){
        this.passwordInputArea.sendKeys(Constants.PASSWORD);
    }

    public void clickFirstLocationSuggestion(){
        this.firstLocationSuggestion.click();
    }

    public void clickFirstDestinationSuggestion(){
        this.firstDestinationSuggestion.click();
    }

    public void login() {
        this.loginButton.click();
    }

    public void clickOnCollectionIcon() {
        this.collectionIcon.click();
    }

    public void addToYourCollections() {
        this.collectionsFolder.click();
    }

    public void doneAddingCollection() {
        this.doneButtonForAdd.click();
    }

    public void openMenu() {
        this.menuIcon.click();
    }

    public void clickOnCollections() {
        this.collections.click();
    }

    public void clickOnCollectionsList() {
        this.collectionsList.click();
    }

    public HereWegoWebForm(WebDriver driver) {
        super(driver);
    }
}
