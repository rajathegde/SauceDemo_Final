package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductAdd {
	WebDriver driver = Baseclass.driver;
	
	@And("^user adds a product to the cart \"([^\"]*)\"$")
	public void user_adds_a_product_to_the_cart_something(String product) throws Throwable {
		WebElement add = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + product + "']/following::button[1]"));
		add.click();  

	}

	@Then("^User see product is added to the cart$")
	public void user_see_product_is_added_to_the_cart() throws Throwable {
		WebElement cart_verify = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
		Assert.assertEquals("1", cart_verify.getText());
	}


}
