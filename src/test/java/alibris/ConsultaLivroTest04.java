package alibris;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConsultaLivroTest04 {
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
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void consultaLivro() {
        driver.get("https://www.alibris.com/");
        driver.findElement(By.id("searchBox")).click();
        driver.findElement(By.id("searchBox")).sendKeys("The art of Software testing");
        driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("li:nth-child(1) > .left:nth-child(1) .button:nth-child(1) > span:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".product-container:nth-child(2) .price > p")).getText(), is("$1.45 $160.00"));
    }
}

