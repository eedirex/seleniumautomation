import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Dashboard {

	public void dashboard(WebDriver driver) throws InterruptedException {
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[@ng-bind-html='dashboard.linkedBankAccountDetails.accountNumber']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//span[@ng-bind-html='dashboard.walletBalance']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//span[@ng-bind-html='dashboard.data.displayTotalProfit']")).isDisplayed());
			System.out.println("Dashboard Test Pass");
		}
		catch (AssertionError e) {
			System.out.println("Dashboard Test Failed");	
		}
	}

}
