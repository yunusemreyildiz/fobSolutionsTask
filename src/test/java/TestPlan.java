import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();
    GsmArenaWebForm gsmArenaWebForm = new GsmArenaWebForm(driver);
    HereWegoWebForm hereWegoWebForm = new HereWegoWebForm(driver);

    @BeforeSuite
    public void before() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Go to GSM Arena Website -> Search for a phone (Iphone 8 Plus) -> Check for the GPS option is exist")
    public void gpsControlForAPhone() throws InterruptedException  {
        driver.get(Constants.GSMARENA_URL);
        driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
        driver.findElement(By.id("topsearch-text"));
        gsmArenaWebForm.searchPhoneModel();
        Thread.sleep(3000);
        gsmArenaWebForm.clickOnFirstItem();
        Thread.sleep(3000);
        if(driver.findElement(By.xpath("//*[@id=\"specs-list\"]/table[8]/tbody/tr[3]/td[2]")).getText().equals("No")){
            System.out.println("There is NO GPS OPTION for this phone.");
        }
        else {
            System.out.println("There is GPS OPTION for this phone.");
        }
    }

    @Test(testName = "Go to Wego Here -> Create A Route btw 2 Locations -> Verify Different Options")
    public void createARouteandCheckForAlternatives() throws InterruptedException  {
        driver.get(Constants.WEGO_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        hereWegoWebForm.enterFirstLocation();
        Thread.sleep(2000);
        hereWegoWebForm.clickFirstLocationSuggestion();
        Thread.sleep(2000);
        hereWegoWebForm.enterDestiationLocation();
        Thread.sleep(2000);
        hereWegoWebForm.clickFirstDestinationSuggestion();
        Thread.sleep(4000);

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[2]")).click();
        Thread.sleep(4000);
        try {
            if (driver.findElement(By.xpath("//*[@id=\"routes_list\"]/div[2]/ul")).isDisplayed()) {
                System.out.println("There are drive routes found.");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("No drive routes found.");

        }

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[3]")).click();
        try {
            if (driver.findElement(By.xpath("//*[@id=\"routes_list\"]/div[2]/ul")).isDisplayed()) {
                System.out.println("There are public transport routes found.");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("No public transport routes found.");

        }

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[4]")).click();
        Thread.sleep(4000);
       try {
           if (driver.findElement(By.xpath("//*[@id=\"routes_list\"]/div[2]/ul")).isDisplayed()) {
               System.out.println("There are car club routes found.");
           }
       }
       catch (NoSuchElementException e){
           System.out.println("No car club routes found.");

       }

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[5]")).click();
        Thread.sleep(4000);
        try {
            if (driver.findElement(By.xpath("//*[@id=\"routes_list\"]/div[2]/ul")).isDisplayed()) {
                System.out.println("There are taxi routes found.");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("No car taxis routes found.");

        }

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[6]")).click();
        Thread.sleep(4000);
        try {
            if (driver.findElement(By.xpath("//*[@id=\"routes_list\"]/div[2]/ul")).isDisplayed()) {
                System.out.println("There are bicycle routes found.");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("No bicycle routes found.");

        }

        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/button[7]")).click();
        Thread.sleep(4000);
        try {
            if (driver.findElement(By.xpath("//*[@id=\"routes_list\"]/div[2]/ul")).isDisplayed()) {
                System.out.println("There are walk routes found.");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("No walk routes found.");
        }
    }

    @Test(testName = "Go to Wego Here -> Sign In -> Collect A Location -> Verify That Location Colleceted and Its The Place That Was Collected.")
    public void signInAndCollectALocation() throws InterruptedException  {
        driver.get(Constants.WEGO_SIGNIN_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        hereWegoWebForm.enterEmail();
        Thread.sleep(2000);
        hereWegoWebForm.enterPassword();
        Thread.sleep(2000);
        hereWegoWebForm.login();
        Thread.sleep(4000);
        driver.get(Constants.WEGO_URL);
        Thread.sleep(6000);
        hereWegoWebForm.enterFirstLocation();
        Thread.sleep(2000);
        hereWegoWebForm.clickFirstLocationSuggestion();
        Thread.sleep(2000);
        hereWegoWebForm.clickOnCollectionIcon();
        Thread.sleep(2000);
        hereWegoWebForm.addToYourCollections();
        Thread.sleep(1000);
        hereWegoWebForm.doneAddingCollection();
        Thread.sleep(2000);
        hereWegoWebForm.openMenu();
        Thread.sleep(2000);
        hereWegoWebForm.clickOnCollections();
        Thread.sleep(2000);
        hereWegoWebForm.clickOnCollectionsList();
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/section/section/div/a/div[2]/h4")).getText().equals(Constants.ADDRESS1))
        {
            System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[2]/div/section/section/div/a/div[2]/h4")).getText()+ " is the collected place and that it is the true place that was collected.");
        }
        else{
            System.out.println("Collected place is not exists or that it not the place that was collected.");
        }
    }

    @AfterSuite
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }
}
