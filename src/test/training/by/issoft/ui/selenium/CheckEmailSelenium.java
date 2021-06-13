package training.by.issoft.ui.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CheckEmailSelenium {

    WebDriver driver;
    String pressSentEmail = "//*[@id=\"sideBarContent\"]/div/nav/a[5]";
    String emailTheme = "test";
    String listEmails = "ll-sj__normal";

    CheckEmailSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void check() {

        WebDriverWait wait = new WebDriverWait(this.driver, 3);
        this.driver.findElement(By.xpath(pressSentEmail)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(listEmails)));
        List<WebElement> emailsTheme = this.driver.findElements(By.className(listEmails));

        Boolean isFind = Boolean.FALSE;
        for (int i = 0; i < emailsTheme.size(); i++) {
            WebElement themeElem = emailsTheme.get(i);
            String theme = themeElem.getText();
            theme = theme.replaceAll("\\s+", "");
            theme = theme.replaceAll("Self:", "");
            if (theme.equals(emailTheme)) {
                isFind = Boolean.TRUE;
                break;
            }
        }
        if (!isFind) {
            Assert.fail("No email with theme:" + emailTheme);
        }


    }

}
