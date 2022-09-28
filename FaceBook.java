package homeAssignmentsWeek2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		EdgeDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		options.addArguments("--disable-notifications");
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Prudvi");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kris");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9848123456");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("ASDFGHJKL");
		
		WebElement findDate = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select selectDate = new Select(findDate);
		selectDate.selectByIndex(9);
		
		Thread.sleep(1000);
		WebElement findMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select selectMonth = new Select(findMonth);
		selectMonth.selectByVisibleText("Jul");
		
		WebElement findYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select selectYear = new Select(findYear);
		selectYear.selectByValue("1996");
		
		WebElement seleGender = driver.findElement(By.xpath("//label[text()='Male']"));
		seleGender.click();
	
	}

}
