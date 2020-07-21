package base;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestBase {

  protected WebDriver driver;
  protected DriverManager driverManager;

  @Parameters({"browserName"})
  @BeforeMethod
  public void setUp(@Optional String browserName){
    getLocalDriver(browserName);
    driver.manage().window().maximize();
    driver.navigate().to(Constants.GOOGLE_URL);
  }

  public WebDriver getLocalDriver(String browserName){
    browserName = "Chrome"; //for single test purposes
    if(browserName.equalsIgnoreCase("Chrome")){
      driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }
    else if(browserName.equalsIgnoreCase("Firefox")){
      driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    }
    else{
      throw new RuntimeException("No such driver found");
    }
    driver = driverManager.getDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }

  @AfterMethod
  public void tearDown(){
    driverManager.quitDriver();
  }

}
