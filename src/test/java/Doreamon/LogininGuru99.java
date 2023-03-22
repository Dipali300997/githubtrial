package Doreamon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogininGuru99  {
	public static String url = "https://demo.guru99.com/test/newtours/index.php";
	ExtentReports er;//variable creation
	ExtentHtmlReporter ehr;
	ExtentTest et;
	WebDriver driver;

	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
        er=new ExtentReports();//object creation 
        ehr= new ExtentHtmlReporter("extent.html");//this line is for giving name to the report.
        er.attachReporter(ehr);//this line is linking the er+ehr.
        
        et=er.createTest("This is before test.");//this is the test name in the report.
        
	}

	@Test(priority = 0)
	public void login() {
		driver.manage().window().maximize();
		et=er.createTest("login");
		String beforelogin = driver.getTitle();
		System.out.println(beforelogin);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("user");
		et.pass("User is able to enter an username");//this line is for showing that this test case is passed.
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("user");
		et.pass("User is able to enter an password");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		et.info("user is able to click on submit button");//this line is for giving info that user is able to click.
		
}
	@Test
	public void logout() {
		
	}
@Test(priority = 1)
public void close() {
	driver.close();
	er.flush();//creating whole new report.
}
}