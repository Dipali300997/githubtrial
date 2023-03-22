package Doreamon;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command.Priority;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertannotationonQAwebsite {
	public static String url = "https://demoqa.com/alerts/";
	WebDriver driver;

	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void alertbutton1() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='alertButton']")).click();
		Thread.sleep(5000);
		Alert alt = driver.switchTo().alert();
		Thread.sleep(5000);
		alt.accept();// accepts permission
	}

	@Test(priority = 1)
	public void alertButton2() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
		Thread.sleep(5000);
		Alert ale = driver.switchTo().alert();
		Thread.sleep(5000);
		ale.accept();

	}

	@Test(priority = 2)
	public void alertButton3() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
		Alert ale1 = driver.switchTo().alert();
		ale1.dismiss();// Decline permission

	}

	@Test(priority = 3)
	public void alertButton4() throws InterruptedException {
		Thread.sleep(3000);
		WebElement promtbutton = driver.findElement(By.xpath("//*[@id='promtButton']"));
		Thread.sleep(3000);
		promtbutton.click();
		Alert ale2 = driver.switchTo().alert();
		Thread.sleep(3000);
		ale2.sendKeys("Dipali");
		Thread.sleep(5000);
		ale2.accept();

	}

	@AfterTest
	public void driverclosing() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
	}

}
