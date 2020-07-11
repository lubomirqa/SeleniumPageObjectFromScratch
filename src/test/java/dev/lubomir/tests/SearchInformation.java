package dev.lubomir.tests;

import dev.lubomir.page.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SearchInformation extends TestBase{

  @Test
  public void checkResultsSum(){
    SearchPage searchPage = new SearchPage(applicationManager.driver);
    searchPage.inputAndSearch("John Doe");
  }

  @Test
  public void checkNumberOfResults(){
    SearchPage searchPage = new SearchPage(applicationManager.driver);
    int results = searchPage.getNumberOfResults("Lub");
    assertTrue(results > 1000000, "Amount is less than 1000000 by " + Math.abs(results - 1000000));
    System.out.println("Amount is " + results + ", which is bigger than 1000000 by " + (results - 1000000));
  }

  @Test
  public void clickFirstLink(){
    SearchPage searchPage = new SearchPage(applicationManager.driver);
    searchPage.inputAndSearch("Java patterns");
    List<WebElement> results = applicationManager.driver.findElements(By.xpath("//h3[@class=\"LC20lb DKV0Md\"]"));
    System.out.println("First link is " + results.get(0).getText());
    results.get(0).click();
  }

}
