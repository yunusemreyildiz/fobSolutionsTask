import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GsmArenaWebForm extends PageObject{

    @FindBy(id = "topsearch-text")
    private WebElement searchInputArea;

    @FindBy(xpath = "//*[@id=\"review-body\"]/div/ul/li")
    private WebElement firstItemOnList;

    @FindBy(xpath = "//*[@id=\"specs-list\"]/table[8]/tbody/tr[3]/td[2]")
    private WebElement gpsOption;


    public void searchPhoneModel() {
        this.searchInputArea.sendKeys(Constants.PHONE);
        this.searchInputArea.sendKeys(Keys.ENTER);
    }

    public void clickOnFirstItem(){
        this.firstItemOnList.click();
    }

    public GsmArenaWebForm(WebDriver driver) {
        super(driver);
    }
}
