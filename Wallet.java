import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Wallet {
	
	public void verifyWalletBalance(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@ng-click='sidemenu.loadWallet()']")).click();
		Thread.sleep(3000);
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[@ng-bind-html='wallet.summary.balances.displayAvailableBalance']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//span[@ng-bind-html='wallet.summary.balances.displayLedgerBalance']")).isDisplayed());
			System.out.println("Wallet Balance Test Passed");
		}
		catch (AssertionError e) {
			System.out.println("Wallet Balance Test Failed");	
		}
	}
		
}

