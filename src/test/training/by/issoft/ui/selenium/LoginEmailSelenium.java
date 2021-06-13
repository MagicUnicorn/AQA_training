package training.by.issoft.ui.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginEmailSelenium {

    WebDriver driver;
    String inputLogin = "//*[@id=\"mailbox\"]/form[1]/div[1]/div[2]/input";
    String pressEnterPasswordButton = "//*[@id=\"mailbox\"]/form[1]/button[1]";
    String inputPassword = "//*[@id=\"mailbox\"]/form[1]/div[2]/input";
    String pressEnterButton = "//*[@id=\"mailbox\"]/form[1]/button[2]";

    LoginEmailSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        WebDriverWait wait = new WebDriverWait(this.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputLogin))).sendKeys("zhdanova.qa");
        this.driver.findElement(By.xpath(pressEnterPasswordButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPassword))).sendKeys("3430139aZ!@");
        this.driver.findElement(By.xpath(pressEnterButton)).click();
    }

}
