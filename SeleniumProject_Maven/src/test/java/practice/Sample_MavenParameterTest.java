package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Sample_MavenParameterTest {
	WebDriver driver;
	String url;
	String username;
	String password;
	String browser;
	
	@Test
	public void sampleTest() {
		url = System.getProperty("url");
		username = System.getProperty("username");
		password = System.getProperty("password");
		browser = System.getProperty("browser");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
			launchBrowser();
		} else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
			launchBrowser();
		} else {
			System.out.println("invalid browser");
		}
	}
	public void launchBrowser() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(System.getProperty("organizationname"));
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
//		String createdOrganizationName = driver.findElement(By.xpath("//pan[contains(text(),'Organization Information')]")).getText();
//		System.out.println(createdOrganizationName);
		driver.close();
	}
}
