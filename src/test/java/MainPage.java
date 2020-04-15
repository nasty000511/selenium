import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MainPage {

    private final WebDriver driver;

    private By topicStart = By.linkText("Коронавирус в России и в мире");
    private By topicTitle = By.partialLinkText("COVID-19 Фильмы в тему");
    private By reply = By.xpath("//*[@id=\"main_content_wrap\"]/table[5]/tbody/tr/td[1]/a/img");
    private By textArea = By.id("post-textarea");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeMessage(String message) {
        WebElement topicStartElement = driver.findElement(topicStart);
        topicStartElement.click();
        WebElement topicElement = driver.findElement(topicTitle);
        topicElement.click();
        WebElement replyElement = driver.findElement(reply);
        Actions action = new Actions(driver);
        action.moveToElement(replyElement);
        action.perform();
        replyElement.click();
        WebElement textAreaElement = driver.findElement(textArea);
        textAreaElement.sendKeys(message);

    }

}
