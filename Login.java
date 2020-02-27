import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
	
public void verifyLogin(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.name("username")).sendKeys("chineduagent");
		driver.findElement(By.name("secret")).sendKeys("password");
		driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
		Thread.sleep(3000);
		String actualTitle = driver.findElement(By.xpath("//span[@ng-bind-html='userData.fullName || blankSpace']")).getText();
		String expectedTitle = "Obinna Ubah";
		
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Login Test Passed");
		}
		catch (AssertionError e) {
			System.out.println("Login Test Failed");	
		}
	}
}
