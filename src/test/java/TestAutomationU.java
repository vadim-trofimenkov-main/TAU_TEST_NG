import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAutomationU
{
	WebDriver driver;
		
	@Test
	@Parameters ( {"URL", "BrowserType"} )
	public void verifyTAU (String url, String browserType)
	{
		if (browserType.equalsIgnoreCase("Internet Explorer"))
		{
			driver = new InternetExplorerDriver ();
		} 
		else if (browserType.equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver ();
		}
		else if (browserType.equalsIgnoreCase("Chrome")) 
		{
			driver = new ChromeDriver ();
		}
				
		driver.manage().window().maximize();
		driver.get(url);
				
		System.out.println("\n" + "Open " + browserType);
		System.out.println("   " +  driver.getTitle());
		System.out.println("   " +  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div[1]/section[1]/p[1]")).getText());
		System.out.println("Close " + browserType + "\n");
			
		driver.quit();
	}
}









