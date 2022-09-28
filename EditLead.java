package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
//		Enter the username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
//		Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
//		Click Login
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
//		Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
//		Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
//		Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
//		Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3] ")).sendKeys("Bhanu");
//		Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		Click on first resulting lead
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Bhanu']")).click();
		String title = driver.getTitle();
		boolean containTitle = title.contains("View Lead | opentaps CRM");
//		Verify title of the page
		if (containTitle == true){
			System.out.println("Title of page is  " + " " + title);
			} else
			{
				System.out.println(title);
			}
		System.out.println(title);

		driver.findElement(By.xpath("//a[text()='Edit']")).click();
//		Click Edit
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		String nameCompany = "DEP";
//		Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(nameCompany);
//	    Click Update
        driver.findElement(By.xpath("//input[@value='Update']")).click();
//		Confirm the changed name appears
        String text = driver.findElement(By.xpath("//span[contains(text(),'(10455)')]")).getText();
        System.out.println(text);
//      Confirm the changed name appears
        if(text.contains("DEP (10455)")) {
        	System.out.println("Company name is changed");
        } else {
        	System.out.println("Company name is not changed");
        }
        driver.close();    
	
	}
}
