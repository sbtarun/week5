package week5.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.testng.annotations.Test;

public class ServicenowCreate extends BaseClassSnow {

	@Test
	public void runCreate() throws IOException {

		// Click “All”
		driver.findElement(By.linkText("All")).click();

		// Click New button

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();

		driver.switchTo().defaultContent();

		// Select a value for Caller and Enter value for short_description

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.linkText("Abraham Lincoln")).click();

		driver.switchTo().window(winList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Automation testing");

		// Read the incident number and save it a variable
		String incNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident number is: " + incNumber);

		// Click on Submit button
		driver.findElement(By.id("sysverb_insert")).click();

		// Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incNumber, Keys.ENTER);

		// Verify the incident is created successful and take snapshot of the created incident.	
		String incconfirm = driver.findElement(By.linkText(incNumber)).getText();
		if (incconfirm.equals(incNumber)) {
			System.out.println("Incident number matches");
		} else {
			System.out.println("Incident number mismatch");
		}
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("screenshots/snowincident.png");
		FileUtils.copyFile(src, dst);
	}

}