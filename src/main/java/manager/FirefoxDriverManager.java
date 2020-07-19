package manager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import java.io.File;

public class FirefoxDriverManager extends DriverManager {
  GeckoDriverService geckoService;

  @Override
  void startService() {
    if(geckoService == null){
      geckoService = new GeckoDriverService.Builder()
              .usingDriverExecutable(new File(System.getProperty("user.dir") + "/src/main/resources/geckodriver"))
              .usingAnyFreePort()
              .build();
    }
  }

  @Override
  void stopService() {
    if (geckoService != null && geckoService.isRunning()){
      geckoService.stop();
    }
  }

  @Override
  void createDriver() {
    driver = new FirefoxDriver(geckoService);
  }
}
