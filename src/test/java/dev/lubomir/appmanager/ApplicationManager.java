package dev.lubomir.appmanager;

import dev.lubomir.util.Constants;
import org.apache.logging.log4j.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public ChromeDriver driver;
  protected Logger log;
  String url = "https://lubomir.dev";
  String googleUrl = Constants.SERVER_URL;

  public void init(ITestContext ctx) {
    String testName = ctx.getCurrentXmlTest().getName();
    log = LogManager.getLogger(testName);
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
