package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    private By txt_username = By.xpath("//input[@id='name']");
    private  By txt_password = By.xpath("//input[@id='password']");
    private By btn_login = By.xpath("//button[@id='login']");

    public LoginPage(WebDriver driver){this.driver = driver;
    }

    public void enterUserName(String userName){driver.findElement(txt_username).sendKeys(userName);}

    public void enterPassword(String password){driver.findElement(txt_password).sendKeys(password);}

    public void clickLoginButton(){driver.findElement(btn_login).click();}



}
