import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Groups_DependsOnGroups_PASS
{
	WebDriver driver;
	
	@Test (groups = "initialize")
	public void test1_SetUpChrome ()
	{
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		
		System.out.println("1. Set Up Chrome");
	}
	
	@Test (dependsOnGroups = "initialize", groups = "env_application")
	public void test2_OpenOrangeHRM ()
	{		
		driver.get("https://opensource-demo.orangehrmlive.com/");
			
		System.out.println("2. Open OrangeHRM");
	}
	
	@Test  (dependsOnGroups = "env_application")
	public void test3_SignIn ()
	{		
		WebElement textUsername = driver.findElement(By.id("txtUsername"));
		textUsername.sendKeys("Admin");
		
		WebElement textPassword = driver.findElement(By.id("txtPassword"));
		textPassword.sendKeys("admin123");
		
		WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
		buttonLogin.click();
		
		System.out.println("3. Sign In");
	}
	
	@Test  (dependsOnGroups = "env_application")
	public void test4_SearchUser ()
	{		
		WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		menuAdmin.click();
		
		WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
		textUserName.sendKeys("Admin");
		
		WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
		buttonSearch.click();
		
		System.out.println("4. Search For User");
	}
	
	@Test  (dependsOnGroups = "env_application")
	public void test5_SearchEmployee ()
	{		
		WebElement menuPIM = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
		menuPIM.click();

		WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
		buttonSearch.click();
		
		System.out.println("5. Search For Employee");
	}
	
	@Test  (dependsOnGroups = "env_application")
	public void test6_SearchCandidate ()
	{		
		WebElement menuRecruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
		menuRecruitment.click();
		
		WebElement buttonSearch = driver.findElement(By.id("btnSrch"));
		buttonSearch.click();
		
		System.out.println("6. Search For Candidate");
	}

	@Test  (dependsOnGroups = "env_application")
	public void test7_SignOut () 
	{
		WebElement linkWelcome = driver.findElement(By.id("welcome"));
		linkWelcome.click();

		WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
		linkLogout.click();

		System.out.println("7. Sign Out");
	}
}