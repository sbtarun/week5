package week5.day1.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ServicenowDelete extends BaseClassSnow {

	@Test
	public void runDelete() {

		// Click “All”
		driver.findElement(By.linkText("All")).click();

		// Search for the existing incident and click on the incident

		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");

		// Delete the incident
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

		// Verify the deleted incident
		String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		if (text.contentEquals("No records to display"))
			System.out.println("Incident deleted");
		else
			System.out.println("Incident not deleted");
	}

}