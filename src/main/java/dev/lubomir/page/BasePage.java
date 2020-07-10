package dev.lubomir.page;

import org.openqa.selenium.WebDriver;
import dev.lubomir.util.*;

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
  }

  public void loadPage(){
    driver.get(Constants.SERVER_URL + pageUrl);
  }
}
