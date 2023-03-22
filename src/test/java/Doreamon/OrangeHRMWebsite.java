package Doreamon;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMWebsite {
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;

	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

		// System.out.println(driver.getTitle());
	}

	@Test(priority = 1)
	public void login() throws Exception {
		System.out.println("orangehrm is opened");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		String beforelogin = driver.getTitle();
		// driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		// Thread.sleep(2000);
		// driver.findElement(By.name("password")).sendKeys("admin123");
		// driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String afterlogin = driver.getTitle();
		Assert.assertEquals(beforelogin, afterlogin);
		System.out.println("same");
		WebElement username = driver.findElement(By.xpath("//*[@name='username']"));
		if (username.isEnabled()) {
			username.sendKeys("Admin");

		}
		WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
		if (password.isEnabled()) {
			password.sendKeys("admin123");
		}
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void admin() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='oxd-main-menu-item']")).click();
		Thread.sleep(6000);
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
		System.out.println(ele.size());
		//for (int i = 0; i < ele.size(); i++) {
			//System.out.println(ele.get(i));}
			

		/*WebElement username = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		username.sendKeys("Dipali");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@class='oxd-select-wrapper']//div[1]//div")).click();//select
		// Thread.sleep(4000);
		Actions act = new Actions(driver);
		WebElement admindropdown = driver.findElement(By.xpath("//*[@class='oxd-select-wrapper']//div[1]//div"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// act.click();
		// act.contextClick(admindropdown).build().perform();
		act.click(admindropdown).build().perform();// build stores your every action
		Thread.sleep(5000);
		act.sendKeys(admindropdown, Keys.ARROW_DOWN);
		Thread.sleep(5000);
		act.sendKeys(admindropdown, Keys.ARROW_DOWN);
		Thread.sleep(4000);
		// Select s1= new Select(admindropdown);
		// s1.selectByIndex(1);
		// Thread.sleep(4000);
		WebElement Employeename = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input"));
		Thread.sleep(2000);
		Employeename.sendKeys("Dipali Gadam");
		Thread.sleep(5000);*/
	}

	@Test(priority = 3)
	public void PIM() throws InterruptedException {

		// driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void Leave() throws InterruptedException {
		// driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();

		driver.findElement(By.linkText("Leave")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void logout() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']//li[4]//a")).click();

	}

	@Test(priority = 6)
	public void printlink() {
		List<WebElement> ele = driver.findElements(By.tagName("a"));//identifying the elements having tag name a 
		System.out.println(ele.size());
		for (int i = 0; i < ele.size(); i++) {
			System.out.println(ele.get(i).getText());
			System.out.println(ele.get(i).getAttribute("href"));

		}
	}
	

	@AfterTest
	public void close() {
		driver.close();

	}

}
