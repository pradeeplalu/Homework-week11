package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        loginLink.click();

        //This is from requirement
        String expectedMessage = "Welcome Back!";

        //Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualMessage = actualMessageElement.getText();

        //validate actual and expected message
        Assert.assertEquals("Not navigate to Sign In page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage(){
        //Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.id("user[email]"));//store in WebElement by id
        emailField.sendKeys("jay123@gmail.com");///Sending email to email filed element
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.name("user[password]"));//Store in webelement by name
        passwordFeild.sendKeys("Jay@123"); //Sending password to password filed element
        //find sign in button element and click
        WebElement loginButton =driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        loginButton.click();
        //get error message text
        WebElement actualErrorMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessageError = actualErrorMessageElement.getText();

        String expectedErrorMessage ="Invalid email or password.";
        //validate actual and expected text
        Assert.assertEquals("Error message not found ",expectedErrorMessage,actualMessageError);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}



