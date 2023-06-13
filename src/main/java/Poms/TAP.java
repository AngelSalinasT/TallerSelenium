package Poms;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TAP {
	WebDriver driver;
	String alertButtonXpath = "//button[text()='Click Me']";
	
	public TAP(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAlertButton() {
		// TODO Auto-generated method stub
		WebElement button = this.driver.findElement(By.xpath(this.alertButtonXpath));
		button.click();
	}
	public void clickButton() {
		// TODO Auto-generated method stub
		WebElement button = this.driver.findElement(By.xpath("//*[@id='HTML9']/div[1]/button"));
		button.click();
	}
	public void acceptAlert() {
		// TODO Auto-generated method stub
		this.driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		this.driver.switchTo().alert().dismiss();
	}
	
	public void printFirstText() {
		// TODO Auto-generated method stub
		WebElement fr = driver.findElement(By.xpath("//*[@id=\"demo\"]"));
		System.out.println(fr.getText());

	}
	public void clickWikipediaIcon() {
		////*[@id="Wikipedia1_wikipedia-search-form"]/div/span[1]/a/img
		WebElement button = this.driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[1]/a/img"));
		button.click();
	}
	
	public void goToPage(String link, WebDriver driver, ArrayList<String> tabs2) {
		for (int i = 0; i < tabs2.size(); i++) {
			driver.switchTo().window(tabs2.get(i));
			if (driver.getTitle().equals(link)) {
				System.out.println(driver.getTitle());
				break;
			}
		}
	}
}
