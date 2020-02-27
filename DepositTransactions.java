import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositTransactions {
	
	public void depositTransactions (WebDriver driver ) throws InterruptedException {
		
		driver.findElement(By.xpath("//span[@ng-bind-html='language.SIDE_MENU.AGENT_TRANSACTIONS']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Deposits')]")).click();
		List <WebElement> depositTransactions = driver.findElements(By.xpath("//td[@ng-bind-html='item.transactionReference']"));
		
		if (depositTransactions.size() != 0 ) {
			
			depositTransactions.get(0).click();
			Thread.sleep(3000);	
		}	
		else {
			
			System.out.println("No Deposit transaction found for this Agent");
		}	
	}

}
