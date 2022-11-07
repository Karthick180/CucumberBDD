package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps_POM {
    WebDriver driver;
    LoginPage login ;
    HomePage homePage;


    @Before
    public void browserSetUp(){
        System.out.println("I am inside browser set up");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Given("browser is launched")
    public void browser_is_launched() {
        System.out.println("==== I am inside the POM steps ====");
        login = new LoginPage(driver);
        homePage = new HomePage(driver);

    }
    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String UserName, String Password) throws InterruptedException {
        login.enterUserName(UserName);
        login.enterPassword(Password);
    }

    @And ("user click login button")
    public void user_click_login_button() {
        login.clickLoginButton();
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        if(homePage.checkLogOutIsDisplayed()){
            System.out.println("login is successful");
        }
        else{
            System.out.println("login failed");
        }
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


}
