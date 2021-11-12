package week5.day1.assignments;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.testng.annotations.Test;



public class MergeLead extends BaseClassLead{
	@Test
	public void runMergeLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Merge Leads")).click();
		// From Widget
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();

		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(winList.get(0));

		// To widget
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> winSet2 = driver.getWindowHandles();
		List<String> winList2 = new ArrayList<String>(winSet2);

		driver.switchTo().window(winList2.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(winList.get(0));

		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text1 = driver.getTitle();
		if (text1.equals("View Lead | opentaps CRM")) {
			System.out.println("Title verified");
		} else {
			System.out.println("Title mismatch");
		}
		

	}
}
