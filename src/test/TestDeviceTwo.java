import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import main.base;



public class TestDeviceTwo extends base {



    @Test
    public void login() throws InterruptedException {

        WebElement uName = driver.findElement(By.xpath("//input[@type='email']"));
        System.out.println("found uname");
        WebElement passWd = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='login-btn-style white-text-color block cursor-pointer text-center']"));


        uName.sendKeys("testbed-prod-5");
        passWd.sendKeys("testbed-prod-5");
        loginBtn.click();
        System.out.println("Logged in Successfully");

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(9000);

        try {
            WebElement addTemp = driver.findElement(By.xpath("//button[contains(text(),'+')]"));
            addTemp.click();
            System.out.println("Added temp");


        } catch (Exception e) {
            System.out.println("Add Temp Button not found");
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        try {
            WebElement setTemp = driver.findElement(By.xpath("//button[contains(text(),'Set temperature')]"));
            setTemp.click();
            System.out.println("Set Temp button found");


        } catch (Exception e) {
            System.out.println("Device is off");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.quit();
    }

}




