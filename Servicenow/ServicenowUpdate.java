package week5.day1.assignments;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class ServicenowUpdate extends BaseClassSnow {

	@Test
	public void runUpdate()
	{
	    // Click “All”
		driver.findElement(By.linkText("All")).click();

		// Search for the existing incident and click on the incident

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0000046", Keys.ENTER);

		driver.findElement(By.linkText("INC0000046")).click();

		driver.switchTo().defaultContent();

		// Update the incidents with Urgency as High and State as In Progress
		driver.switchTo().frame("gsft_main");

		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select dd1 = new Select(urgency);
		dd1.selectByValue("1");

		WebElement state = driver.findElement(By.id("incident.state"));
		Select dd2 = new Select(state);
		dd2.selectByValue("2");

		driver.findElement(By.id("sysverb_update")).click();

		driver.findElement(By.linkText("INC0000046")).click();

		WebElement urgencycheck = driver.findElement(By.id("incident.urgency"));
		Select dd3 = new Select(urgencycheck);
		String urgencySelectedOption = dd3.getFirstSelectedOption().getText();

		WebElement statecheck = driver.findElement(By.id("incident.state"));
		Select dd4 = new Select(statecheck);
		String stateSelectedOption = dd4.getFirstSelectedOption().getText();

		if (urgencySelectedOption.contentEquals("1 - High"))
			System.out.println("Urgency is correct");
		else
			System.out.println("Urgency is wrong");

		if (stateSelectedOption.contentEquals("In Progress"))
			System.out.println("State is correct");
		else
			System.out.println("State is wrong");
	}

}