import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import main.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestDeviceOne extends base {

    @Test
    public void login() throws InterruptedException, MalformedURLException {

        WebElement uName = driver.findElement(By.xpath("//input[@type='email']"));
        System.out.println("found uname");
        WebElement passWd = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='login-btn-style white-text-color block cursor-pointer text-center']"));


        uName.sendKeys("testbeddev4");
        passWd.sendKeys("Testbeddev4!");
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
    }

    // public void tearDown() throws Exception {

    //  driver.quit();
    // }





}

