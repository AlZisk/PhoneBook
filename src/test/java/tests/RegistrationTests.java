package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }

    @Test(groups = {"web","reg","quick"})
    public void registrationSuccess(){

        int index = (int)(System.currentTimeMillis()/1000)%3600;

        System.out.println("wick"+index+"@gmail.com");
        logger.info("wick"+index+"@gmail.com");
        logger.info("The index is --->" +index);


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm("wick"+index+"@gmail.com","Ww12345$");
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());


    }
}