import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;

public class LoginPage {

    private By loginLink = By.cssSelector("[tabindex='5']");
    private By usernameLocator = By.name("login_username");
    private By passwordLocator = By.name("login_password");
    private By sslLocator = By.className("login-ssl");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login(String login, String password) {
        WebElement link = driver.findElement(loginLink);
        link.click();
        WebElement loginElement = driver.findElement(usernameLocator);
        loginElement.sendKeys(login);
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys(password);
        WebElement sslElement = driver.findElement(sslLocator);
        sslElement.click();
        passwordElement.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("rutracker.org");
            }
        });
        WebElement loginButton =
                driver.findElement(By.xpath("//*[@id=\"login-form-full\"]/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td/input"));
        loginButton.click();
        return new MainPage(driver);
    }
}
