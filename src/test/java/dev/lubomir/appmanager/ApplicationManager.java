package dev.lubomir.appmanager;

import dev.lubomir.util.Constants;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public ChromeDriver driver;
  String url = "https://lubomir.dev";
  String googleUrl = Constants.SERVER_URL;

  public void init() {
    //create driver
    System.setProperty("webdriver.chrome.driver", "/Users/mac/SeleniumPajeObjectFromScratch/lubomir.dev/src/main/resources/chromedriver");

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get(googleUrl); //change url if needed
  }

  public void stop() {
    driver.quit();
  }
}
