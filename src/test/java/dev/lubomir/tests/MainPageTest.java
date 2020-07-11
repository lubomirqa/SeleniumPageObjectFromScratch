package dev.lubomir.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class
MainPageTest extends TestBase {

  @Test
  public void checkHeader(){
    WebElement title = applicationManager.driver.findElement(By.xpath("//span[text()=\"Coming Soon\"]"));

    assertTrue(title.isDisplayed(), "Title is not displayed");
    System.out.println("Title is displayed");
  }
}
