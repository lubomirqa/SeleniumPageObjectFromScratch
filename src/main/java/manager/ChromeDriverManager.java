package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.io.File;

public class ChromeDriverManager extends DriverManager{

  ChromeDriverService chromeService;

  @Override
  void startService() {
    if(chromeService == null){
      chromeService = new ChromeDriverService.Builder()
              .usingDriverExecutable(new File(System.getProperty("user.dir") + "/src/main/resources/chromedriver"))
              .usingAnyFreePort()
              .build();
    }
  }

  @Override
  void stopService() {
    if (chromeService != null && chromeService.isRunning()){
      chromeService.stop();
    }
  }

  @Override
  void createDriver() {
    driver = new ChromeDriver(chromeService);
  }
}
