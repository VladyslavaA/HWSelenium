import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestS {

    @Test
    public void check() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        By code = By.xpath("//*[contains(text(), 'Україна')]");
        By number = By.xpath("//input[@data-qa-node='phone-number']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By debitSource = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstNamedebitSource = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastNamedebitSource = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By button = By.xpath("//button[@data-qa-node='submit']");
        By button2 = By.xpath("//*[contains(text(), 'Сплатити')]");


        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(number).sendKeys("939155859");
        driver.findElement(amount).sendKeys("\b\b\b");
        driver.findElement(amount).sendKeys("1");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(debitSource).sendKeys("11/24");
        driver.findElement(cvv).sendKeys("198");
        driver.findElement(firstNamedebitSource).sendKeys("CAT");
        driver.findElement(lastNamedebitSource).sendKeys("Kitty");
        driver.findElement(button).click();


        By actualAmount = By.xpath("//div[@data-qa-node='amount']");
        By actualCommission = By.xpath("//span[@data-qa-node='commission']");
        By actualDetails = By.xpath("//div[@data-qa-node='details']");


        Assertions.assertEquals("1 UAH", driver.findElement(actualAmount).getText());
        Assertions.assertEquals("2", driver.findElement(actualCommission).getText());
        Assertions.assertEquals("Поповнення телефону. На номер +380939155859", driver.findElement(actualDetails).getText());


    }

}
