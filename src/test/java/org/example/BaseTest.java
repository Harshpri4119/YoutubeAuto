package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTest {

    WebDriver driver = new ChromeDriver();

    String url = "https://www.youtube.com/";
    String title;
    String currentURL;

    @Test
    public void TestLaunch() throws  Exception{

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
        Thread.sleep(5000);

        driver.quit();
    }
}
