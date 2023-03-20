package Doreamon;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Giyan {
	public static String url = "https://demo.guru99.com/test/newtours/index.php";
	WebDriver driver;

	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void login() {
		driver.manage().window().maximize();
		String beforelogin = driver.getTitle();
		System.out.println(beforelogin);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("user");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("user");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		String afterlogin = driver.getTitle();
		System.out.println(afterlogin);
		if (beforelogin == afterlogin) {
			System.out.println("same");

		} else {
			System.out.println("titles are different");
		}
	}

	@Test(priority = 1)
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
	}

	@Test(priority = 2)
	public void fillinformation() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Dipali");
		driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys("Gadam");
		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("8888548626");
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("dinksch@gmail.com");
		driver.findElement(By.xpath("//*[@name='address1']")).sendKeys("block2,pune");
		driver.findElement(By.xpath("//*[@name='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//*[@name='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//*[@name='postalCode']")).sendKeys("413598");
		WebElement country= driver.findElement(By.xpath("//*[@name='country']"));
		Select s1= new Select(country);
	    s1.selectByVisibleText("INDIA");
	    driver.findElement(By.xpath("//*[@name='email']")).sendKeys("dipali@321");
	    driver.findElement(By.xpath("//*[@name='password']")).sendKeys("mymavenproject");
	    driver.findElement(By.xpath("//*[@name='confirmPassword']")).sendKeys("mymavenproject");
	    driver.findElement(By.xpath("//*[@name='submit']")).click();
	    driver.close();
	   
	}
	
		}
		

	

	

