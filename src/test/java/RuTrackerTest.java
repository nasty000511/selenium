import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RuTrackerTest {

    private WebDriver driver;

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://rutracker.org/forum/index.php");
    }
    @After
    public void close() {
      try {
          Thread.sleep(6000);
      }
      catch (InterruptedException interruptedException){

      }

        driver.quit();
    }

    @Test
    public void searchTest() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("Matrix");
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("rutracker.org");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());

    }

    @Test
    public void loginTest() {

        driver.get("http://rutracker.org/forum/index.php");

        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage.login("anastasiiajobs", "anastasiia");

    }

    @Test
    public void messageTest() {

        driver.get("http://rutracker.org/forum/index.php");

        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MainPage mainPage = loginPage.login("anastasiiajobs", "anastasiia");
        mainPage.writeMessage("Selenium test");

    }

}
