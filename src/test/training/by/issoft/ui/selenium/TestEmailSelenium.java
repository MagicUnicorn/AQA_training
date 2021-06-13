package training.by.issoft.ui.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestEmailSelenium {

    WebDriver driver;


    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mail.ru/");
        LoginEmailSelenium login = new LoginEmailSelenium(driver);
        login.login();
        SendEmailSelenium send = new SendEmailSelenium(driver);
        send.send();
        CheckEmailSelenium check = new CheckEmailSelenium(driver);
        check.check();
        driver.close();
    }

}
