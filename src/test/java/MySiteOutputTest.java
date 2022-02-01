import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MySiteOutputTest {
    public static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Open start page
        driver.get("file:///D:\\учеба\\TeachMeSkills\\Body-weight-calculator-tests\\src\\test\\resources\\index.html");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void findHeaderMessageTest() {
        //Find Header message
        boolean headerMessageIsDisplayed = driver.findElement(By.id("header")).isDisplayed();
        Assert.assertTrue(headerMessageIsDisplayed, "Message is displayed");
    }

    @Test
    public void findWithNameMessageTest() {
        //Find Name message
        String value = driver.findElement(By.id("header2")).getText();
        Assert.assertTrue(value.contains("Evgeny"), "Name in message is not displayed");
    }

    @Test
    public void favouriteMusicBandListEnableTest() {
        //Find list with music bands
        boolean favouriteMusicBandListIsEnable = driver.findElement(By.id("band")).isDisplayed();
        Assert.assertTrue(favouriteMusicBandListIsEnable, "List is enable");
    }

    @Test
    public void clickMeButtonIsEnableTest() {
        //Find button 'Click me,please'
        boolean clickMeButtonIsEnable = driver.findElement(By.id("elem")).isEnabled();
        Assert.assertTrue(clickMeButtonIsEnable, "Click me button is enable");
    }

    @Test
    public void afterClickMeButtonAlertWindowIsEnableTest() {
        //Click button 'Click me,please' and check alert window
        driver.findElement(By.id("elem")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void alertMessageTextIsCorrectTest() {
        //Click button 'Click me,please' and check alert window text
        driver.findElement(By.id("elem")).click();
        String message = driver.switchTo().alert().getText();
        Assert.assertEquals(message, "SAAB is one of the best car ever", "Alert message is false");
        driver.switchTo().alert().accept();
    }

    @Test
    public void checkActiveLinkOnPageTest() {
        //Search active link on page
        boolean activeLink = driver.findElement(By.id("link1")).isEnabled();
        Assert.assertTrue(activeLink, "Active link is enable");
    }

    @Test
    public void checkActiveLinkURLIsTrueTest() {
        Set<String> oldWindowsSet = driver.getWindowHandles();
        driver.findElement(By.id("link1")).click();
        String newWindowHandle = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        String openedWindowURL = driver.switchTo().window(newWindowHandle).getCurrentUrl();
        Assert.assertEquals(openedWindowURL, "http://www.saabclub.by/");
    }

    @Test
    public void checkOoopsYouFoundItMessageIsEnableTest() {
        String ooopsMessage = driver.findElement(By.id("image1")).getAttribute("alt");
        Assert.assertEquals(ooopsMessage, "oooops,you found it");
    }
}
