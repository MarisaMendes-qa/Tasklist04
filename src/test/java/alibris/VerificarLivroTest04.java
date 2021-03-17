package alibris;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VerificarLivroTest04 {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/88/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void verificarLivroAlibris() {
        driver.get("https://www.alibris.com/How-to-be-a-Gentlewoman-The-Art-of-Soft-Power-in-Hard-Times-Lotte-Jeffs/book/43383618?matches=19");
        driver.findElement(By.cssSelector(".navbar-brand > img")).click();
        driver.findElement(By.id("searchBox")).click();
        driver.findElement(By.id("searchBox")).sendKeys("The art of software testing");
        driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("The Art of Software Testing")).click();
        driver.findElement(By.id("tabUsed")).click();
        assertThat(driver.findElement(By.cssSelector(".product-container:nth-child(1) .price > p")).getText(), is("$130.95 $167.00"));
        driver.close();
    }
}
