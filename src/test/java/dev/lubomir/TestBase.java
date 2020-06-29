package dev.lubomir;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

  ChromeDriver driver;
  String url = "https://lubomir.dev";

  @BeforeMethod
    public void setup() {
    //create driver
    System.setProperty("webdriver.chrome.driver", "/Users/mac/SeleniumPajeObjectFromScratch/lubomir.dev/src/main/resources/chromedriver");

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get(url);
  }

  @AfterMethod
    public void teardown() {
    driver.quit();
  }
}
