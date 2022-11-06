package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
   WebDriver driver;

   private By btn_logout = By.xpath("//button[@id='logout']");

   public HomePage(WebDriver driver){
       this.driver=driver;
   }


   public boolean checkLogOutIsDisplayed(){return driver.findElement(btn_logout).isDisplayed();}

}
