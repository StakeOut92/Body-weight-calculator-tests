import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BodyWeighInputTest {
    @Test
    public void enterDigitsToWeighAndCmsFieldsForStarvationResultTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open start page
        driver.get("https://healthunify.com/bmicalculator/");
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("20");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("150");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        if (value.contains("Starvation")) {
            System.out.println("Message 'Starvation' is show");

        } else {
            Assert.fail("'Starvation' message is not show");
        }
        driver.quit();
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForUnderweightResultTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open start page
        driver.get("https://healthunify.com/bmicalculator/");
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("40");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("150");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        if (value.contains("Underweight")) {
            System.out.println("Message 'Underweight' is show");
        } else {
            Assert.fail("'Underweight' message is not show");
        }
        driver.quit();
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForNormalResultTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open start page
        driver.get("https://healthunify.com/bmicalculator/");
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("82");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        if (value.contains("Normal")) {
            System.out.println("Message 'Normal' is show");
        } else {
            Assert.fail("'Normal' message is not show");
        }
        driver.quit();
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForOverweightResultTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open start page
        driver.get("https://healthunify.com/bmicalculator/");
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("100");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        if (value.contains("Overweight")) {
            System.out.println("Message 'Overweight' is show");
        } else {
            Assert.fail("'Overweight' message is not show");
        }
        driver.quit();
    }

    @Test
    public void enterDigitsToWeighAndCmsFieldsForObeseResultTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open start page
        driver.get("https://healthunify.com/bmicalculator/");
        //Input weight in field
        driver.findElement(By.name("wg")).sendKeys("140");
        //Input cms in field
        driver.findElement(By.name("ht")).sendKeys("183");
        //Click 'Calculate' button
        driver.findElement(By.cssSelector("[value=Calculate]")).click();
        //Check message 'Starvation' is show
        String value = driver.findElement(By.className("content")).getAttribute("value");
        if (value.contains("Obese")) {
            System.out.println("Message 'Obese' is show");
        } else {
            Assert.fail("'Obese' message is not show");
        }
        driver.quit();
    }
}
