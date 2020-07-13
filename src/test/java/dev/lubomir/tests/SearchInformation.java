package dev.lubomir.tests;

import dev.lubomir.page.PicturesPage;
import dev.lubomir.page.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
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

  @Test
  public void compareResults(){
    SearchPage searchPage = new SearchPage(applicationManager.driver);
    boolean result = searchPage.compareResults("JohnyDepp", "Stallone");
    assertTrue(result,"Results are not equal");
  }

  @Test
  public void compareResultsOnTwoPages(){
    int index = 2;
    SearchPage searchPage = new SearchPage(applicationManager.driver);
    int page1Results = searchPage.amountOfLinksOnAPage("Epam").size();
    searchPage.clickPage(index);
    int page2Results = searchPage.amountOfLinksOnAPage().size();
    assertEquals(page1Results, page2Results, "Amount of result if not equal");
    System.out.println("Amount of results on 1 and " + index + " pages are equal");
  }

  @Test
  public void searchPictures(){
    SearchPage searchPage = new SearchPage(applicationManager.driver);
    PicturesPage picturesPage = new PicturesPage(applicationManager.driver);
    searchPage.inputAndSearch("Cats");
    searchPage.clickPictures();
    System.out.println("Width of the picture is " + picturesPage.getPictureWidth(2));
  }

}
