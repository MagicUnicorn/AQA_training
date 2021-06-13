package training.by.issoft.ui.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailSelenium {

    WebDriver driver;
    String pressNewEmailButton = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]/div/div/div/div[1]/div/div/a";
    String inputAddressee = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input";
    String inputTheme = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input";
    String inputText = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]";
    String pressSendEmailButton = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]";
    String closeModal = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]/span/span";
    String emailTheme = "test";

    SendEmailSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void send() {
        WebDriverWait wait = new WebDriverWait(this.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pressNewEmailButton))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputAddressee))).sendKeys("zhdanova.qa@mail.ru");
        this.driver.findElement(By.xpath(inputTheme)).sendKeys(emailTheme);
        this.driver.findElement(By.xpath(inputText)).sendKeys("test");
        this.driver.findElement(By.xpath(pressSendEmailButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeModal))).click();

    }

}
