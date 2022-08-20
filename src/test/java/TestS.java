import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestS {

    @Test
    public void check(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        By code = By.xpath("//*[contains(text(), 'Україна')]");
        By number = By.xpath("//input[@data-qa-node='phone-number']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By debitSource = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By button = By.xpath("//button[@data-qa-node='submit']");



        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(number).sendKeys("7311111");
        driver.findElement(amount).sendKeys("\b\b\b");
        driver.findElement(amount).sendKeys("111");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(debitSource).sendKeys("11/24");
        driver.findElement(cvv).sendKeys("198");
        driver.findElement(button).click();



    }

}
