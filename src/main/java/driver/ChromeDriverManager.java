package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager extends DriverManager{

  private ChromeDriverService chromeService;
  private String chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver";
  private String downloadPath = System.getProperty("user.dir") + "/downloads";

  @Override
  void startService() {
    if(null == chromeService){
      chromeService = new ChromeDriverService.Builder()
              .usingDriverExecutable(new File(getChromePath()))
              .usingAnyFreePort()
              .build();
    }
  }

  @Override
  void stopService() {
    if (null != chromeService && chromeService.isRunning()){
      chromeService.stop();
    }
  }

  @Override
  void createDriver() {
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("preferences", chromePreferences(getDownloadFolder()));
    driver = new ChromeDriver(chromeService);
  }

  private String getChromePath(){
    return chromePath;
  }

  private String getDownloadFolder(){
    return downloadPath;
  }

  private Map<String, Object> chromePreferences (String downloadFolder) {
    Map<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.default_directory", downloadFolder);
    chromePrefs.put("chrome.switches", Arrays.asList("--start-maximized","--disk-cache-size=1","--media-cache-size=1"));
    return chromePrefs;
  }
}
