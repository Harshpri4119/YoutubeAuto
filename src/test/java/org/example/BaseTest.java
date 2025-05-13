package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    WebDriver driver = new ChromeDriver();

    String url = "https://www.youtube.com/";
    String title;
    String currentURL;
    String searchKey = "Uyi Amma";

    @Test
    public void TestLaunch() throws InterruptedException {

        driver.get(url);
        driver.manage().window().maximize();

        title = driver.getTitle();
        currentURL = driver.getCurrentUrl();

        System.out.println("Title: " + title);
        System.out.println("Current URL: " + currentURL);

        if(!url.equals(currentURL)) {
            System.out.println("URL Not Matched.");
        }else{
            System.out.println("URL Matched.");
        }


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        WebElement searchElement = driver.findElement(By.xpath("//input[@name='search_query']"));


        wait.until(ExpectedConditions.visibilityOf(searchElement));

        searchElement.sendKeys(searchKey);

        driver.findElement(By.xpath("//button[@title='Search']")).click();

        Thread.sleep(5000);


        List<WebElement> webElements = driver.findElements(By.xpath("//div[@id='contents']"));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        for(WebElement element : webElements){

            String elementText = element.getText();
            String a = "Uyi Amma - Azaad | Aaman D, Rasha Thadani| Madhubanti Bagchi,Amit Trivedi,Amitabh| Bosco| Abhishek K";

            System.out.println(elementText);

            if (elementText.equals(a)){
                driver.findElement(By.xpath("//a[@id='thumbnail']")).click();
            }
        }

        driver.close(); //  Added Driver close

    }
}
