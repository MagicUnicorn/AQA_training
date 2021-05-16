package training.ui;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;


public class TestEmail {

    String inputLogin = "//*[@id=\"mailbox\"]/form[1]/div[1]/div[2]/input";
    String pressEnterPasswordButton = "//*[@id=\"mailbox\"]/form[1]/button[1]";
    String inputPassword = "//*[@id=\"mailbox\"]/form[1]/div[2]/input";
    String pressEnterButton = "//*[@id=\"mailbox\"]/form[1]/button[2]";
    String pressNewEmailButton = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]/div/div/div/div[1]/div/div/a";
    String inputAddressee = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input";
    String inputTheme = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input";
    String inputText = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]";
    String pressSendEmailButton = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]";
    String closeModal = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]/span/span";
    String pressSentEmail = "//*[@id=\"sideBarContent\"]/div/nav/a[5]";
    String emailTheme = "test";

    @Test
    public void test1() {
        open("https://mail.ru/");
        $(By.xpath(inputLogin)).setValue("zhdanova.qa");
        $(By.xpath(pressEnterPasswordButton)).click();
        $(By.xpath(inputPassword)).setValue("3430139aZ!@");
        $(By.xpath(pressEnterButton)).click();
        $(By.xpath(pressNewEmailButton)).click();
        $(By.xpath(inputAddressee)).setValue("zhdanova.qa@mail.ru");
        $(By.xpath(inputTheme)).setValue(emailTheme);
        $(By.xpath(inputText)).setValue("test");
        $(By.xpath(pressSendEmailButton)).click();
        $(By.xpath(closeModal)).click();
        $(By.xpath(pressSentEmail)).click();
        List<SelenideElement> emailsTheme  = $$(By.className("ll-sj__normal"));
        Boolean isTrue = Boolean.FALSE;
        for (int i = 0; i < emailsTheme.size(); i++) {

            SelenideElement themeElem = emailsTheme.get(i);
            String theme = themeElem.innerText();
            theme = theme.replaceAll("\\s+","");
            theme = theme.replaceAll("Self:","");

            if (theme.equals(emailTheme)) {
                isTrue = Boolean.TRUE;
                break;
            }
        }
        if (!isTrue) {
            Assert.fail("No email with theme:"+emailTheme);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
