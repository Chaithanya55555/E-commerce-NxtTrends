package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import  java.util.List;
public class untitled {
    public static void main(String[] args) throws Exception {
       try {
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
           driver.get("https://rahulnxttrendz.ccbp.tech/login");
           driver.manage().window().fullscreen();
           driver.manage().window().minimize();
           driver.manage().window().maximize();
           WebElement username = driver.findElement(By.xpath("//input[@id = 'username']"));
           username.sendKeys("rahul");
           String userName = username.getAttribute("value");
           System.out.println(userName);
           WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
           password.sendKeys("rahul@2021");
           String Password = password.getAttribute("value");
           System.out.println(Password);
           WebElement login = driver.findElement(By.xpath("//button[text() = 'Login']"));
           login.submit();
           String expectedLoggendUrl = "https://rahulnxttrendz.ccbp.tech/";
           WebDriverWait waitLoadPage = new WebDriverWait(driver,Duration.ofSeconds(10));
           waitLoadPage.until(ExpectedConditions.urlToBe(expectedLoggendUrl));
           String currentLoggedUrl = driver.getCurrentUrl();
           if (currentLoggedUrl.equals(expectedLoggendUrl)){
               System.out.println("Logged in completed");
           }
           WebElement shopnow = driver.findElement(By.xpath("//button[contains(@class , 'shop-now')]"));
           shopnow.click();
           WebDriverWait waitForVisibility = new WebDriverWait(driver,Duration.ofSeconds(10));
           waitForVisibility.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class = 'product-item']")));
           List<WebElement> list = driver.findElements(By.xpath("//li[@class = 'product-item']"));
           if ( list.size() > 0 ){
               System.out.println("No of product: " + list.size() );
               WebElement product = driver.findElement(By.xpath("//h1[contains(text(),'Mini')]"));
               product.click();
               String expectedUrl = "https://rahulnxttrendz.ccbp.tech/products/1002";
               WebDriverWait waitProductDetails = new WebDriverWait(driver,Duration.ofSeconds(10));
               waitProductDetails.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-details-')]")));
               String currentUrl = driver.getCurrentUrl();
               if (currentUrl.equals(expectedUrl)){
                   System.out.println("All products are visible");
               }
               WebElement description = driver.findElement(By.xpath("//p[starts-with(text(),'Collect all mystery mini-figures in the new series 11')]"));
               String des = description.getText();
               System.out.println(des);
           }
           Thread.sleep(3000);
           driver.quit();
       }catch (Exception e){
           System.out.println("Exception is thrown: " + e.getMessage());
           System.out.println("Cause of the exception: " + e.getCause());
       }
    }
}
