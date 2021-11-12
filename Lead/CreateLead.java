package week5.day1.assignments;




import org.openqa.selenium.By;

import org.testng.annotations.Test;



public class CreateLead extends BaseClassLead{
	@Test
	public void runCreateLead() {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tarun");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sb");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876543210");
		driver.findElement(By.name("submitButton")).click();
		
}
}






