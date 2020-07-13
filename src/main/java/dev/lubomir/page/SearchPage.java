package dev.lubomir.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage extends BasePage{

  public static final String searchInput = "//input[@name=\"q\"]";
  public static final String linksXp = "//h3[@class=\"LC20lb DKV0Md\"]";
  public static final String pagesXp = "//table[@class=\"AaVjTc\"]//td";


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

  public boolean compareResults(String question1, String question2){
    int result1 = getNumberOfResults(question1);
    driver.navigate().back();
    int result2 = getNumberOfResults(question2);
    return result1 == result2;
  }

  public List<WebElement> amountOfLinksOnAPage(String text){
    inputAndSearch(text);
    List<WebElement> links = driver.findElements(By.xpath(linksXp));
    return links;
  }

  public List<WebElement> amountOfLinksOnAPage(){
    List<WebElement> links = driver.findElements(By.xpath(linksXp));
    return links;
  }

  public void clickPage(int index){
    List<WebElement> pages = driver.findElements(By.xpath(pagesXp));
    pages.get(index).click();
  }

  public void clickPictures(){
    driver.findElement(By.xpath("//a[@class=\"q qs\"]")).click();
  }

}
