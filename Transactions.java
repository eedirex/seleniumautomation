import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Transactions {
	
		
	public void verifyWithdrawalTransactions(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@ng-bind-html='language.SIDE_MENU.AGENT_TRANSACTIONS']")).click();
		List <WebElement> withdrawalTransactions = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		if (withdrawalTransactions.size() != 0 ) {
			
			System.out.println("Withdrawal Transaction found for this Agent");
			withdrawalTransactions.get(0).click();
			Thread.sleep(3000);
			test(driver);
			Thread.sleep(3000);	
			requestRefund(driver);
		}	
		else {
			
			System.out.println("No Withdrawal Transaction found for this Agent");
		}					
	}
	
	public void requestRefund(WebDriver driver) throws InterruptedException {  
		
		try {
			
			driver.findElement(By.xpath("//button[@ng-bind-html='language.BUTTONS.LOG_DISPUTE']")).click();
			Select s = new Select(driver.findElement(By.id("customerBankCode")));
			s.selectByValue("ECO");
			driver.findElement(By.name("customerAccountNumber")).sendKeys("1061184479");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
			System.out.println("Dispute Created Successfully");
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			
			System.out.println("Refund can't be requested for this transaction");
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		}	
	}
	
	public void verifyDepositTransactions (WebDriver driver ) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Deposits')]")).click();
		List <WebElement> depositTransactions = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		
		if (depositTransactions.size() != 0 ) {
			
			System.out.println("Deposit transaction(s) found for this Agent");
			depositTransactions.get(0).click();
			Thread.sleep(3000);	
			test(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();		
		}	
		else {
			
			System.out.println("No Deposit transaction found for this Agent");
		}	
	}
	
	public void verifyCashOuts (WebDriver driver ) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Cashouts')]")).click();
		List <WebElement> CashOuts = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		
		if (CashOuts.size() != 0 ) {
			
			System.out.println("Cashout transaction(s) found for this Agent");
			CashOuts.get(0).click();
			Thread.sleep(3000);	
			test(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		}	
		else {
			
			System.out.println("No Cashout transaction found for this Agent");
		}	
	}
	
	public void verifyTopups (WebDriver driver ) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Top Ups')]")).click();
		List <WebElement> topUps = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		
		if (topUps.size() != 0 ) {
			
			System.out.println("Top up transaction(s) found for this Agent");
			topUps.get(0).click();
			Thread.sleep(3000);	
			test(driver);
			Thread.sleep(3000);	
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		}	
		else {
			
			System.out.println("No Top up transaction found for this Agent");
		}	
	}
	
	public void verifyQuarantinedWithdrawals (WebDriver driver ) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Quarantined Withdrawals')]")).click();
		List <WebElement> qWithdrawals = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		
		if (qWithdrawals.size() != 0 ) {
			
			System.out.println("Quarantined transaction(s) found for this Agent");
			qWithdrawals.get(0).click();
			Thread.sleep(3000);	
			test(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		}	
		else {
			
			System.out.println("No Quarantined transaction found for this Agent");
		}	
	}
	
	public void test (WebDriver driver) {
		
		String actualTitle = driver.findElement(By.xpath("//h4[@class='ng-binding']")).getText();
		String expectedTitle = "Transaction Data";
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Transaction Test Passed");
		}
		catch (AssertionError e) {
			System.out.println("Transaction test Failed");
		}
	}
	
	public void verifyTrSearch (WebDriver driver) throws InterruptedException {
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary bottom-margin_2 ng-scope']")).click();
		Select s = new Select(driver.findElement(By.id("status")));
		s.selectByValue("string:FAILED");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@ng-bind-html='language.ACTIONS.APPLY']")).click();
		Thread.sleep(3000);
		List <WebElement> searchResults = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		
		if (searchResults.size() != 0) {
			
			System.out.println("Results found for this Search");
			String actualData = searchResults.get(0).findElement(By.xpath("//td[@ng-bind-html='item.responseCode']")).getText();
			String expectedData = "91";
			try {
				Assert.assertEquals(actualData, expectedData);
				System.out.println("Search Test Passed");
			}
			catch (AssertionError e) {
				System.out.println("Search test Failed");
			}			
		}
		driver.findElement(By.xpath("//span[@ng-bind-html='language.BUTTONS.DISMISS']")).click();
		
	
	}
	
}

		
	

