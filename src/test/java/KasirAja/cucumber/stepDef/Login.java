package KasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    @Given("Navigate in Login Page")
    public void Navigate_Login_Page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String baseUrl = "https://kasirdemo.belajarqa.com/";
        driver.get(baseUrl);
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
        Assert.assertEquals("https://kasirdemo.belajarqa.com/login", Url);
    }

    @And("Input valid username")
    public void Valid_Username() {
        WebElement logininput = driver.findElement(By.xpath("//input[@id='email']"));
        logininput.sendKeys("admin@sel.com");
    }

    @And("Input valid password")
    public void Valid_Password() {
        WebElement passwordinput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordinput.sendKeys("test321");
    }

    @And("Input invalid password")
    public void Invalid_Password() {
        WebElement passwordinput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordinput.sendKeys("321");
    }

    @When("Click login button")
    public void Click_Login_Button() {
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='login']"));
        loginbutton.click();
    }

    @Then("User in dashboard menu")
    public void User_In_Dashboard_Menu() {
        WebElement userfullname = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//dt[normalize-space()='Sel Ventures']")));
        String loginname = userfullname.getText();
        System.out.println(loginname);
        Assert.assertEquals("Sel Ventures", loginname);
        driver.quit();
    }

    @Then("User can't login and get error message")
    public void User_Error_Login_Message() {
        // Add code to verify the error message here
        WebElement AlertKredensial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alert']")));
        String AlertText = AlertKredensial.getText();
        Assert.assertEquals("Kredensial yang Anda berikan salah", AlertText);
        driver.quit();
    }
}
