package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void loginSuccess() {
        //open login form
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
        loginItem.click();

        //fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("noa@gmail.com");

        //fill password
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Nnoa12345$");

        //click button Login
        wd.findElement(By.xpath("//*[text()=' Login']")).click();


        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out")).size() > 0);

    }

    @Test
    public void loginSuccessNew()
    {
        //open login form
        click(By.cssSelector("[href='/login']"));
        //fill email
        type(By.xpath("//input[1]"),"noa@gmail.com");
        //fill password
        type(By.xpath("//input[2]"),"Nnoa12345$");
        //click button login
        click(By.xpath("//*[text()=' Login']"));

        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out")));
    }
}
