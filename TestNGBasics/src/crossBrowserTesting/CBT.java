package crossBrowserTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser){
		if (browser.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		
		else if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
     		driver = new ChromeDriver();
		}
		
		else if (browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Webdrivers\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if (browser.equals("Opera")){
			System.setProperty("webdriver.opera.driver", "C:\\Webdrivers\\operadriver_win32\\operadriver.exe");
			driver = new OperaDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
	}
	
	@Test
	public void verifyTitle(){
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}

}
