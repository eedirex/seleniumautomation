import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Terminals {
	
	public void verfiyTerminals(WebDriver driver) {
		
		driver.findElement(By.xpath("//span[@ng-bind-html='language.SIDE_MENU.AGENT_TERMINALS']")).click();
		List<WebElement> terminals = driver.findElements(By.xpath("//td[@ng-bind-html='item.terminalId']"));	
		
		int numberOfAgentTerminals = terminals.size();
		
		if (numberOfAgentTerminals != 0){
			
			System.out.println("This Agent has " + numberOfAgentTerminals + " terminals");
		}
		
		else {
			
			System.out.println("This Agent has no terminals"); 
		}
		
	}
		
	public void verifyTerminalSearch (WebDriver driver) {
		
		System.out.println("Running Terminal Search Test");
		List<WebElement> terminals = driver.findElements(By.xpath("//td[@ng-bind-html='item.terminalId']"));	
		driver.findElement(By.name("aSearchTerm")).sendKeys(terminals.get(0).findElement(By.xpath("//td[@ng-bind-html='item.terminalId']")).getText());
		terminals.get(0).findElement(By.xpath("//td[@ng-bind-html='item.terminalId']")).getText();
		driver.findElement(By.xpath("//i[contains(@class,'icon-magnifier')]")).click();
		
		String actualData = driver.findElement(By.xpath("//td[@ng-bind-html='item.terminalId']")).getText();
		String expectedData = "2057MF94";
		try {
			Assert.assertEquals(actualData, expectedData);
			System.out.println("Search Test Passed");
		}
		catch (AssertionError e) {
			System.out.println("Search Test Failed");
		}	
	}

}
