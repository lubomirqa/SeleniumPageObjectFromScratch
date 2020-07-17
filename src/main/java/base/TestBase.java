package base;

import manager.DriverManager;
import manager.DriverManagerFactory;
import manager.DriverType;
import dev.lubomir.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class TestBase {

  public WebDriver driver;
  DriverManager driverManager;

  @BeforeMethod
  @Parameters("browserName")
  public void setUp(@Optional String browserName){
    getLocalDriver(browserName);
    driver.manage().window().maximize();
    driver.navigate().to(Constants.GOOGLE_URL);
  }

  public WebDriver getLocalDriver(String browserName){
    if(browserName.equalsIgnoreCase("Chrome")){
      driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
      driver = driverManager.getDriver();
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    else if(browserName.equalsIgnoreCase("Firefox")){
      driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
      driver = driverManager.getDriver();
    }
    return driver;
  }

  @AfterMethod
  public void tearDown(){
    driverManager.quitDriver();
  }

}
