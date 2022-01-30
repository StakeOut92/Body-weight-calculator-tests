import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BodyWeighInputTest {
    public static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Open start page
        driver.get("https://healthunify.com/bmicalculator/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForStarvationResultTest() {
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("20");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("150");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertTrue(value.contains("Starvation"), "Starvation message is show");

    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForUnderweightResultTest() {
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("40");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("150");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertTrue(value.contains("Underweight"), "Starvation message is show");
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForNormalResultTest() {
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("82");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertTrue(value.contains("Normal"), "Starvation message is show");
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForOverweightResultTest() {
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("100");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertTrue(value.contains("Overweight"), "Starvation message is show");
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForObeseResultTest() {
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("140");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        Assert.assertTrue(value.contains("Obese"), "Starvation message is show");
    }

    @Test
    public void findObeseResultWithNameTest() {
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("140");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertTrue(value.contains("Obese"), "Starvation message is show");
    }

}


