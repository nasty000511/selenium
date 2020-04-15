import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    By searchLocator = By.name("nm");
    By searchButton = By.id("cse-search-btn-top");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String search(String keywords) {
        WebElement element = driver.findElement(searchLocator);
        WebElement button = driver.findElement(searchButton);
        element.sendKeys(keywords);
        button.click();
        return driver.getTitle();
    }

}
