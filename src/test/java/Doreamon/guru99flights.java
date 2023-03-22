package Doreamon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class guru99flights {
	public static String url = "https://demo.guru99.com/test/newtours/index.php";
	WebDriver driver;

	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public void flightsbutton()
	{
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Flights")).click();
	//driver.findElement(By.xpath("//*[@value='roundtrip']")).click();
	driver.findElement(By.xpath("//*[@value='oneway']")).click();
	WebElement passengers= driver.findElement(By.xpath("//*[@name='passCount']"));
	Select s1= new Select(passengers);
    s1.selectByIndex(2);
	
	}
}