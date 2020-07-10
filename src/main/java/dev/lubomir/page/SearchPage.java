package dev.lubomir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

  public static final String searchInput = "//input[@name=\"q\"]";

  @Override
  public void loadPage(){
    super.loadPage();
  }

  public SearchPage(WebDriver driver){
    super(driver);
  }

  public void inputAndSearch(String text){
    driver.findElement(By.xpath(searchInput)).sendKeys(text);
    driver.findElement(By.className("gNO89b")).click();
  }

  public int getNumberOfResults(String text){
    inputAndSearch(text);
    String results = driver.findElement(By.id("result-stats")).getText();
    System.out.println(results);
    results = results.substring(0, results.indexOf("(") + 1);
    results = results.trim();
    results = results.replaceAll("\\D+","");
    System.out.println(results);
    return Integer.parseInt(results);
  }

}
