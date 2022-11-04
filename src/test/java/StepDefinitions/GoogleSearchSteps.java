package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class GoogleSearchSteps {
    WebDriver driver = null;


    @Given("browser is open")
    public void browserIsOpen() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("Browser Is Open");

        driver.manage().window().maximize();
    }

    @And("user is on google search page")
    public void userIsOnGoogleSearchPage() {
        driver.navigate().to("https://www.google.com/");

        System.out.println("We are in Google Page");
    }

    @When("user enters a text in search box")
    public void userEntersATextInSearchBox() {
        driver.findElement(By.name("q")).sendKeys("Cricket");
        System.out.println("Search Text was entered");
    }

    @And("hits enter")
    public void hitsEnter() {
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        System.out.println("Search was clicked");
    }

    @Then("user is able to see the results")
    public void userIsAbleToSeeTheResults() {

        driver.getPageSource().contains("cricket");
        System.out.println("User Saw the result");
        driver.quit();
    }
}
