package driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import java.io.File;

public class FirefoxDriverManager extends DriverManager {
  GeckoDriverService geckoService;

  @Override
  void startService() {
    if(null == geckoService){
      geckoService = new GeckoDriverService.Builder()
              .usingDriverExecutable(new File(System.getProperty("user.dir") + "/src/main/resources/geckodriver"))
              .usingAnyFreePort()
              .build();
    }
  }

  @Override
  void stopService() {
    if (null != geckoService && geckoService.isRunning()){
      geckoService.stop();
    }
  }

  @Override
  void createDriver() {
    driver = new FirefoxDriver(geckoService);
  }
}
