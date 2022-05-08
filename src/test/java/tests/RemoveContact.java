package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }
        app.contact().provideContactData();
    }

    @Test (groups = {"web"},priority = 1)
    public void removeOneContact(){

        Assert.assertEquals(app.contact().removeOneContact(),1);
    }

    // @Test (dependsOnMethods = "removeOneContact")
    @Test(priority = 2)
    public void removeAllContact(){
        app.contact().removeAllContacts();
        // Assert

    }
}