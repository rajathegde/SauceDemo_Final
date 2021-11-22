package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefs {

	WebDriver driver = Baseclass.driver;

	@Given("^User Opened Swag Lab Application$")
	public void user_opened_swag_lab_application() throws Throwable {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);

	}

	@When("^User Enters username \"([^\"]*)\"$")
	public void user_enters_username_something(String UserName) throws Throwable {
		WebElement email = driver.findElement(By.xpath("//input[@id='user-name']"));
		email.sendKeys(UserName);

	}

	@And("^User Enter Password \"([^\"]*)\"$")
	public void user_enter_password_something(String password) throws Throwable {
		WebElement pass = driver.findElement(By.cssSelector("input[id=password]"));
		pass.sendKeys(password);
	}


	@And("^Clicks on Login Button$")
	public void clicks_on_login_button() throws Throwable {

		WebElement btn_sign = driver.findElement(By.cssSelector("input[id=login-button]"));
		btn_sign.click();

	}

	@Then("^User Should be on the Products Page$")
	public void user_should_be_on_the_products_page() throws Throwable {
		WebElement check_status = driver.findElement(By.xpath("//span[text()='Products']"));

		String Expected ="PRODUCTS";
		Assert.assertEquals(Expected, check_status.getText());
	}

	@Then("^User Should Get \"([^\"]*)\"$")
	public void user_should_get_something(String error) throws Throwable {
		WebElement error_button = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
		Assert.assertEquals(error, error_button.getText());
	}

	




}
