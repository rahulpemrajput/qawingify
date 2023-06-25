import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginPageTests {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setup() {
        // Set up WebDriver and initialize ExtentReports
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/login-page-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void testValidLogin() {
        test = extent.createTest("Valid Login Test");
        driver.get("https://sakshingp.github.io/assignment/login.html");

        // Perform login with valid credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        usernameField.sendKeys("validusername");
        passwordField.sendKeys("validpassword");
        loginButton.click();

        // Verify successful login
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertEquals(welcomeMessage.getText(), "Welcome, validusername!");
    }

    @Test
    public void testInvalidLogin() {
        test = extent.createTest("Invalid Login Test");
        driver.get("https://sakshingp.github.io/assignment/login.html");

        // Perform login with invalid credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        usernameField.sendKeys("invalidusername");
        passwordField.sendKeys("invalidpassword");
        loginButton.click();

        // Verify error message for invalid login
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertEquals(errorMessage.getText(), "Invalid username or password!");
    }

    @AfterMethod
    public void teardown() {
        // Quit WebDriver and flush extent reports
        driver.quit();
        extent.flush();
    }
}
