package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps_POM {
    WebDriver driver;
    LoginPage login ;


    @Given("browser is launched")
    public void browser_is_launched() {
        System.out.println("==== I am inside the POM steps");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @And("user is on login page")
    public void user_is_on_login_page() {

        driver.navigate().to("https://example.testproject.io/web/");

    }
    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String UserName, String Password) throws InterruptedException {
        login.enterUserName(UserName);
        login.enterPassword(Password);
//        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(UserName);
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
//        Thread.sleep(2000);
    }
    @And ("user click login button")
    public void user_click_login_button() {
        login.clickLoginButton();
//        driver.findElement(By.xpath("//button[@id='login']")).click();

    }
    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {

        if(login.checkLogOutIsDisplayed()){
            System.out.println("login is successful");
        }
        else{
            System.out.println("login failed");
        }
        driver.quit();
    }


}
