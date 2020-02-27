import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FOTestSuite {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//ialiyu//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver ();
		Login l = new Login ();
		Dashboard d = new Dashboard ();
		Terminals t = new Terminals ();
		Transactions tr = new Transactions (); 
		Wallet w = new Wallet ();
		
		driver.get("http://frontoffice-ui.mab.development.teamapt.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		l.verifyLogin(driver);
		Thread.sleep(3000);
		d.dashboard(driver);
		Thread.sleep(3000);
		tr.verifyWithdrawalTransactions(driver);
		Thread.sleep(3000);
		tr.verifyTrSearch(driver);
		tr.verifyDepositTransactions(driver);
		tr.verifyCashOuts(driver);
		tr.verifyTopups(driver);
		tr.verifyQuarantinedWithdrawals(driver);
		Thread.sleep(3000);
		t.verfiyTerminals(driver);
		Thread.sleep(3000);
		t.verifyTerminalSearch(driver);
		Thread.sleep(3000);
		w.verifyWalletBalance(driver);
		driver.close();
		
	}					 
}
