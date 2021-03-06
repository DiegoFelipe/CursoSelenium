import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	@Test
	public void testLoginElysium() throws InterruptedException {
//		WebDriver driver = new 	FirefoxDriver();
		WebDriver driver = DriverFactory.getDriver();
		driver.get("http://elysium.unimedfama.com.br/index.php/site/login");
		Assert.assertEquals("Login",driver.getTitle());
		driver.findElement(By.id("user_login")).sendKeys("master");
		driver.findElement(By.id("user_pass")).sendKeys("master");
		driver.findElement(By.xpath("//*[@id=\'login-form\']/input[4]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals("Master",driver.findElement(By.xpath("/html/body/aside/div/section/div/div[2]/p")).getText());
		driver.quit();
	}
}
