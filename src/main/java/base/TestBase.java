package base;

import manager.DriverManager;
import manager.DriverManagerFactory;
import manager.DriverType;
import dev.lubomir.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestBase {

  public WebDriver driver;
  DriverManager driverManager;

  @Parameters({"browserName"})
  @BeforeMethod
  public void setUp(@Optional String browserName){
    getLocalDriver(browserName);
    driver.manage().window().maximize();
    driver.navigate().to(Constants.GOOGLE_URL);
  }

  public WebDriver getLocalDriver(String browserName){
    //browserName = "Chrome"; //for single test purposes
    if(browserName.equalsIgnoreCase("Chrome")){
      driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
      driver = driverManager.getDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    else if(browserName.equalsIgnoreCase("Firefox")){
      driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
      driver = driverManager.getDriver();
    }
    else{
      throw new RuntimeException("No such driver found");
    }
    return driver;
  }

  @AfterMethod
  public void tearDown(){
    driverManager.quitDriver();
  }

}
