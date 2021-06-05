import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ConfigurationAnnotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - Set Up Chrome");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Open Chrome");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class - Open Test Application");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Sign In");
    }

    @Test
    public void searchCustomer() {
        System.out.println("Search For Customer");
    }

    @Test
    public void searchProduct() {
        System.out.println("Search For Product");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Sign Out");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Close Test Application");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test - Close Chrome\n");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Chrome - Clean Up All Cookies");
    }
}