package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public boolean isSignOutPresent(){
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegistartionForm(String email,String password){
        //fill email
        type(By.xpath("//input[1]"),email);
        // fill password
        type(By.xpath("//input[2]"),password);

    }
    public void fillLoginRegistartionForm(User user){
        //fill email
        type(By.xpath("//input[1]"), user.getEmail());
        // fill password
        type(By.xpath("//input[2]"), user.getPassword());

    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegistrationSuccess() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void signOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertDisplayed() {

        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());


        if(alert==null){
            return false;
        }else {
            return true;
        }
    }

    public boolean isErrorWrongFormat() {

        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();

        String error = alert.getText();
        System.out.println(error);
        // ok
        alert.accept();
        // cancel
        // alert.dismiss();
        // send message
        //alert.sendKeys("Hello");
        return error.contains("Wrong email or password format");


    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistartionForm(user);
        submitLogin();
    }
}