package week5.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

public class ServicenowAssign extends BaseClassSnow {

	@Test
	public void runAssign() {
		// Click on open and Search for the existing incident and click on the incident
		driver.findElement(By.linkText("Open")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0000003", Keys.ENTER);
		driver.findElement(By.linkText("INC0000003")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");

		// Assign the incident to Software group

		driver.findElement(By.name("lookup.incident.assignment_group")).click();
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Software", Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(winList.get(0));
		driver.switchTo().frame("gsft_main");

		// Update the incident with Work Notes
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Assigning to INC to Software group");
		driver.findElement(By.id("sysverb_update")).click();

		// Verify the Assignment group and Assigned for the incident
		driver.findElement(By.linkText("INC0000003")).click();
		String assigngroup = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		if (assigngroup.contentEquals("Software"))
			System.out.println("Assignment group matches");
		else
			System.out.println("Assignment group does not match");

	}

}