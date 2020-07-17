package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PicturesPage extends BasePage {

  private String tegList = "//span[@class=\"KZ4CUc\"]/div";
  private String pictureList = "//img[@class=\"rg_i Q4LuWd\"]";

  public PicturesPage(WebDriver driver){
    super(driver);
  }

  public int getPictureWidth(int index){
    List<WebElement> pictures = driver.findElements(By.xpath(pictureList));
    int width = Integer.parseInt(pictures.get(index).getAttribute("width"));
    return width;
  }

}
