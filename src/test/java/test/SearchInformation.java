package test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.RetryAnalyzer;
import page.PicturesPage;
import page.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import base.*;
import static org.testng.Assert.*;


@Test(retryAnalyzer = RetryAnalyzer.class)
public class SearchInformation extends TestBase{

  SearchPage searchPage;

  @Test(description = "Check the sum of two searches")
  @Severity(SeverityLevel.BLOCKER)
  public void checkResultsSum(){
    searchPage = new SearchPage(driver);
    searchPage.inputAndSearch("Lub");
  }

  @Test(description = "Compare the number of derived results to 1 000 000 and print the conclusion")
  @Severity(SeverityLevel.CRITICAL)
  public void checkNumberOfResults(){
    searchPage = new SearchPage(driver);
    int results = searchPage.getNumberOfResults("Lub");
    assertTrue(results > 1000000, "Amount is less than 1000000 by " + Math.abs(results - 1000000));
    System.out.println("Amount is " + results + ", which is bigger than 1000000 by " + (results - 1000000));
  }

  @Test(description = "Clicking the very first link after the search being made")
  @Severity(SeverityLevel.BLOCKER)
  public void clickFirstLink(){
    searchPage = new SearchPage(driver);
    searchPage.inputAndSearch("Java patterns");
    List<WebElement> results = driver.findElements(By.xpath("//h3[@class=\"LC20lb DKV0Md\"]"));
    System.out.println("First link is " + results.get(0).getText());
    results.get(0).click();
  }

  @Test(description = "Compare amount of two results and assert that amounts are not equal")
  @Severity(SeverityLevel.CRITICAL)
  public void compareResults(){
    searchPage = new SearchPage(driver);
    boolean result = searchPage.compareResults("JohnyDepp", "Stallone");
    assertFalse(result,"Results are equal");
  }

  @Test(description = "Compare amount of the same result on two pages")
  @Severity(SeverityLevel.BLOCKER)
  public void compareResultsOnTwoPages(){
    int index = 2;
    searchPage = new SearchPage(driver);
    int page1Results = searchPage.amountOfLinksOnAPage("Epam").size();
    searchPage.clickPage(index);
    int page2Results = searchPage.amountOfLinksOnAPage().size();
    assertEquals(page1Results, page2Results, "Amount of results is not equal");
    System.out.println("Amount of results on 1 and " + index + " pages are equal");
  }

  @Test(description = "Search picture of the Cats and print its width")
  @Severity(SeverityLevel.CRITICAL)
  public void searchPictures(){
    searchPage = new SearchPage(driver);
    PicturesPage picturesPage = new PicturesPage(driver);
    searchPage.inputAndSearch("Cats");
    searchPage.clickPictures();
    System.out.println("Width of the picture is " + picturesPage.getPictureWidth(2));
  }

}
