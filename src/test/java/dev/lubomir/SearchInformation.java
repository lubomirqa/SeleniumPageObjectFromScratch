package dev.lubomir;

import dev.lubomir.page.SearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchInformation extends TestBase{

  @Test
  public void checkResultsSum(){
    SearchPage searchPage = new SearchPage(driver);
    searchPage.inputAndSearch("John Doe");
  }

  @Test
  public void checkNumberOfResults(){
    SearchPage searchPage = new SearchPage(driver);
    int results = searchPage.getNumberOfResults("Lub");
    assertTrue(results > 1000000, "Amount is less than 1000000 by " + Math.abs(results - 1000000));
    System.out.println("Amount is " + results + ", which is bigger than 1000000 by " + (results - 1000000));
  }

}
