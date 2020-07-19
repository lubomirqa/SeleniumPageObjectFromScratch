package page;

import org.openqa.selenium.WebDriver;
import dev.lubomir.util.*;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected String pageUrl = "";

  protected WebDriver driver;

  protected String getPageUrl(){
    return pageUrl;
  }

  protected void setPageUrl(){
    this.pageUrl = pageUrl;
  }

  public BasePage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void loadPage(){
    driver.get(Constants.GOOGLE_URL + pageUrl);
  }
}
