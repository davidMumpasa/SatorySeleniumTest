package org.example;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest
        extends TestCase {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\David\\chromedriver_win32\\chromedriver.exe");
        // Create an instance of ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testRegister() throws InterruptedException {
        // Navigate to the URL
        driver.get("http://localhost:3000");

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root")));

        // Find the register button and click it
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div > div.col-lg-6.align-self-center > div > a.btn.btn-border-base.ml-4.aos-init.aos-animate")));
        registerBtn.click();

        // Wait for the registration form to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#form1")));

        // Find the email input field and enter an email address
        WebElement emailInput = driver.findElement(By.cssSelector("#form1"));
        emailInput.sendKeys("test@example.com");
        Thread.sleep(2000);  // Adjust sleep time if needed

        // Wait for a moment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form2")));

        // Find the password input field and enter a password
        WebElement passwordInput = driver.findElement(By.cssSelector("#form2"));
        passwordInput.sendKeys("your_password");
        Thread.sleep(2000);  // Adjust sleep time if needed

        // Wait for a moment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form3']")));

        // Find the confirm password input field using XPath and enter the same password
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//*[@id='form3']"));
        confirmPasswordInput.sendKeys("your_password");
        Thread.sleep(2000);  // Adjust sleep time if needed

        // Wait for a moment
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#flexCheckDefault")));

        // Find the terms and conditions checkbox and click it
        WebElement termAndConCheckBox = driver.findElement(By.cssSelector("#flexCheckDefault"));
        termAndConCheckBox.click();
        Thread.sleep(2000);  // Adjust sleep time if needed

        // Wait for a moment
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div.col.mb-5.mt-3.m-4 > div > div.text-center.pt-1.mb-2.pb-1.row > button")));

        // Find the sign-up button and click it
        WebElement signUpBtn = driver.findElement(By.cssSelector("#root > div > div > div.col.mb-5.mt-3.m-4 > div > div.text-center.pt-1.mb-2.pb-1.row > button"));
        signUpBtn.click();
        Thread.sleep(5000);

        // Wait for a few seconds to see the results
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='swal2-title']")));

        // Check Alert
        WebElement popUp = driver.findElement(By.xpath("//*[@id='swal2-title']"));

        // test password Match
        WebElement popUpMessage = driver.findElement(By.xpath("//*[@id='swal2-html-container']"));

        // if (popUpMessage.getText().equals("You need to be registered to the Academy")) {
        WebElement popUpOkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        popUpOkBtn.click();
        Thread.sleep(2000);

        emailInput.clear();
        emailInput.sendKeys("Rajesh@fluidintellect.com");
        Thread.sleep(2000);

        passwordInput.clear();
        passwordInput.sendKeys("11111111");
        Thread.sleep(2000);

        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys("2222222");
        signUpBtn.click();
        Thread.sleep(5000);

        popUpOkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        popUpOkBtn.click();
        Thread.sleep(5000);

        // User Already Register Test

        emailInput.clear();
        emailInput.sendKeys("Rajesh@fluidintellect.com");
        Thread.sleep(2000);

        passwordInput.clear();
        passwordInput.sendKeys("11111111");
        Thread.sleep(2000);

        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys("11111111");
        Thread.sleep(2000);

        signUpBtn = driver.findElement(By.cssSelector("#root > div > div > div.col.mb-5.mt-3.m-4 > div > div.text-center.pt-1.mb-2.pb-1.row > button"));
        signUpBtn.click();
        Thread.sleep(5000);

        popUpOkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        popUpOkBtn.click();
        Thread.sleep(5000);

        // Test weak password

        emailInput.clear();
        emailInput.sendKeys("tammy.singh@fluidintellect.com");
        Thread.sleep(2000);

        passwordInput.clear();
        passwordInput.sendKeys("11111111");
        Thread.sleep(2000);

        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys("11111111");
        Thread.sleep(2000);

        signUpBtn = driver.findElement(By.cssSelector("#root > div > div > div.col.mb-5.mt-3.m-4 > div > div.text-center.pt-1.mb-2.pb-1.row > button"));
        signUpBtn.click();
        Thread.sleep(5000);

        popUpOkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        popUpOkBtn.click();
        Thread.sleep(2000);

        // test with correct information

        emailInput.clear();
        emailInput.sendKeys("tammy.singh@fluidintellect.com");
        Thread.sleep(2000);

        passwordInput.clear();
        passwordInput.sendKeys("TammySight$16");
        Thread.sleep(2000);

        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys("TammySight$16");
        Thread.sleep(2000);

        signUpBtn = driver.findElement(By.cssSelector("#root > div > div > div.col.mb-5.mt-3.m-4 > div > div.text-center.pt-1.mb-2.pb-1.row > button"));
        signUpBtn.click();
        Thread.sleep(5000);

        popUpOkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        popUpOkBtn.click();
        Thread.sleep(2000);

    }

    @Test
    public void testLogin() throws InterruptedException {
        // Navigate to the URL
        driver.get("http://localhost:3000");

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root")));

        // Find the register button and click it
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div > div.col-lg-6.align-self-center > div > a:nth-child(4)")));
        loginBtn.click();

        // Wait for the registration form to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#form1")));

        // Find the email input field and enter an email address
        WebElement emailInput = driver.findElement(By.cssSelector("#form1"));
        emailInput.sendKeys("test@example.com");
        Thread.sleep(2000);

        // Wait for a moment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form2")));

        // Find the password input field and enter a password
        WebElement passwordInput = driver.findElement(By.cssSelector("#form2"));
        passwordInput.sendKeys("your_password");
        Thread.sleep(2000);

        // Find the sign-up button and click it
        loginBtn = driver.findElement(By.cssSelector("#root > div > div > div.col.mb-5.mt-5.m-4 > div > div.text-center.pt-1.mb-5.pb-1.row > button"));
        loginBtn.click();
        Thread.sleep(5000);

        WebElement popUpOkBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        popUpOkBtn.click();
        Thread.sleep(2000);

        // correct login
        emailInput = driver.findElement(By.cssSelector("#form1"));
        emailInput.clear();
        emailInput.sendKeys("tammy.singh@fluidintellect.com");
        Thread.sleep(2000);

        passwordInput = driver.findElement(By.cssSelector("#form2"));
        passwordInput.clear();
        passwordInput.sendKeys("TammySight$16");
        Thread.sleep(2000);

        loginBtn = driver.findElement(By.cssSelector("#root > div > div > div.col.mb-5.mt-5.m-4 > div > div.text-center.pt-1.mb-5.pb-1.row > button"));
        loginBtn.click();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

