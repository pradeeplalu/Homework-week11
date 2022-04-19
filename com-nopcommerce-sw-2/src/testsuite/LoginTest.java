package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    // open the browser
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        WebElement loginlink = driver.findElement(By.linkText("login"));
        loginlink.click();
        //This is from requirement
        String expectedMessage = "Welcome, Please Sign in!";

        //find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        //validate actual and expected message
        Assert.assertEquals("Not to navigate to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // store web element by id
        WebElement emailfield = driver.findElement(By.id("Email"));
        //sending email to email field element
        emailfield.sendKeys("Deep123@gmail.com");
        //to find the password field element
        WebElement passwordfield = driver.findElement(By.name("Password"));
        //sending password to password field element
        passwordfield.sendKeys("deep123");
        //find the login element and click
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();
        //find logout button on webpage
        WebElement logoutElement = driver.findElement(By.className("ico-logout"));

        if (logoutElement.isDisplayed()) {
            System.out.println("Verification Successful - 'Log out' is displayed on the web page");
        } else {
            System.out.println("Verification Unsuccessful - 'Log out' is not displayed on the web page");
        }
    }
    @Test
            public void verifyTheErrorMessage(){
        //find the login link and click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

            WebElement emailField = driver.findElement(By.id("Email"));//store in WebElement by id
            emailField.sendKeys("Deep123@gmail.com");///Sending email to email filed element
            //to find the password field element
            WebElement passwordFeild = driver.findElement(By.name("Password"));//Store in webelement by name
            passwordFeild.sendKeys("deep123"); //Sending password to password filed element


            WebElement loginButton =driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));

            loginButton.click();
            WebElement actualErrorMessageElement = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.login-page div.page-body div.customer-blocks div.returning-wrapper.fieldset form:nth-child(1) > div.message-error.validation-summary-errors:nth-child(1)"));
            String actualMessageError = actualErrorMessageElement.getText();

            String expectedErrorMessage ="Login was unsuccessful. Please correct the errors and try again.\n" +
                    "No customer account found";
            //validate actual and expected text
            Assert.assertEquals("Error message not found ",expectedErrorMessage,actualMessageError);

        }
     @After
             public void tearDown() {
            closeBrowser();
        }
        }












