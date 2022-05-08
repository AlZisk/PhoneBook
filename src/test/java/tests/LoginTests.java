package tests;

import manager.MyDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import  models.User;


public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }

    @Test
    public void loginSuccess() {
        //open login form
//        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
//        loginItem.click();
//        //fill email
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("noa@gmail.com");
//
//        // fill password
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Nnoa12345$");
//        //click button Login
//        wd.findElement(By.xpath("//*[text()=' Login']")).click();
//
//
//        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);


    }

    @Test (dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNew(String email, String password){

        logger.info("Tests start with email : "+email+"and password : "+password);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm(email,password);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
        logger.info("test passed");
    }


    @Test (dataProvider = "validModelLogin", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProvider(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test (dataProvider = "validModelLoginCSV", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProviderCSV(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());

    }

    @Test(groups = {"web"})
    public void loginNegativeTestWrongPassword(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLoginRegistrationSuccess());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }
}