package Doreamon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropannotation {
public static String url = "https://jqueryui.com/droppable/";
WebDriver driver;

@BeforeTest
public void bt() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();

}
@Test 
public void frame() throws InterruptedException {
	driver.findElements(By.tagName("iframe")).size();
	System.out.println(driver.findElements(By.tagName("iframe")).size());
	Thread.sleep(5000);
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
	Thread.sleep(5000);
	WebElement drag= driver.findElement(By.id("draggable"));
	WebElement drop= driver.findElement(By.id("droppable"));
	Thread.sleep(5000);
	Actions act=new Actions(driver);
	act.dragAndDrop(drag, drop).build().perform();
	Thread.sleep(5000);
	driver.close();
}
}
