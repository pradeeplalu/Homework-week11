package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com";
    @Before
    public void setBaseUrl(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //find element for forgot your password link
        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotPassword.click();//click on the link

        String expectedText = "Forgot Your Password?";
        //find text on webpage
        WebElement actualForgotText = driver.findElement(By.tagName("h1"));
        String actualText = actualForgotText.getText();
        //validate actual and expected text
     Assert.assertEquals("'Forgot Your Password?' text not found", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
