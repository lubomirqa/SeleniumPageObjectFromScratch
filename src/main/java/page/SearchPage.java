package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage{

  public static final String pagesXp = "//table[@class=\"AaVjTc\"]//td";

  @FindBy(xpath = "//input[@name=\"q\"]")
  public WebElement searchInput;

  @FindBy(xpath = "//h3[@class=\"LC20lb DKV0Md\"]")
  public WebElement linksXp;

  @FindBy(className = "gNO89b")
  public WebElement searchXp;

  @FindBy(id = "result-stats")
  public WebElement resultsXp;

  @FindBy(xpath = "//a[@class=\"q qs\"]")
  public WebElement picturesXp;


  @Override
  public void loadPage(){
    super.loadPage();
  }

  public SearchPage(WebDriver driver){
    super(driver);
  }

  public void inputAndSearch(String text){
    searchInput.sendKeys(text);
    searchXp.click();
  }

  public int getNumberOfResults(String text){
    inputAndSearch(text);
    String results = resultsXp.getText();
    System.out.println(results);
    results = results.substring(0, results.indexOf("(") + 1)
            .trim()
            .replaceAll("\\D+","");
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
    return Arrays.asList(linksXp);
  }

  public List<WebElement> amountOfLinksOnAPage(){
    return Arrays.asList(linksXp);
  }

  public void clickPage(int index){
    List<WebElement> pages = driver.findElements(By.xpath(pagesXp));
    pages.get(index).click();
  }

  public void clickPictures(){
    picturesXp.click();
  }
}
