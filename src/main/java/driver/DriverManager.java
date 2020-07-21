package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
  WebDriver driver;

  abstract void startService();
  abstract void stopService();
  abstract void createDriver();

  public void quitDriver(){
    if(null != driver){
      stopService();
    }
  }

  public WebDriver getDriver(){
    if(null == driver){
      startService();
      createDriver();
    }
    return driver;
  }
}
