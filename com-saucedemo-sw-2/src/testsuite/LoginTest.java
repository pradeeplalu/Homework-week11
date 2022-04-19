package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        WebElement emailField = driver.findElement(By.id("user-name"));//find userName WebElement
        emailField.sendKeys("standard_user");//Sending userName filed value
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.name("password"));//find password field webelement by name
        passwordFeild.sendKeys("secret_sauce"); //Sending password to password filed element

//find login element and click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//find 'PRODUCTS' text on webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualText = actualTextElement.getText();

        String expectedText ="PRODUCTS";
        //validate actual and expected text
      Assert.assertEquals("'PRODUCTS' text not found ",expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement emailField = driver.findElement(By.id("user-name"));//find userName WebElement
        emailField.sendKeys("standard_user");//Sending userName filed value
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.name("password"));//find password field webelement by name
        passwordFeild.sendKeys("secret_sauce"); //Sending password to password filed element

//find login element and click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//count 'PRODUCTS ' on webpage by using item label
        List<WebElement> productsList = driver.findElements(By.className("inventory_item_label"));
        int sizeOfList = productsList.size();
        System.out.println("Count of products displayed on page is : "+sizeOfList);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}



