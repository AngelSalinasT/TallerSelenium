package Poms;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import net.bytebuddy.asm.Advice.Enter;

public class GooglePage {

	WebDriver driver;
	String searchBarId = "APjFqb";
	String amzl = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3";
	String firstresult = "//h3[text()='Nintendo - Wikipedia']";
	String resultsClass = "//h3[@class='LC20lb MBeuO DKV0Md']";
	String parraf = "//*[@id=\"mw-content-text\"]/div[1]/p";  // //*[@id=class="a-price-whole"]
	
	
	String searchBarAmzl = "//*[@id=\"twotabsearchtextbox\"]";
	
	public GooglePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void typeOnSearchBar(String value) {
		// TODO Auto-generated method stub
		WebElement searchBar = driver.findElement(By.id(searchBarId));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public void clickFirstresult(String element) {
		// TODO Auto-generated method stub
		WebElement fr =driver.findElement(By.xpath(element));
		fr.click();

	}
	
	public void printFirstText() {
		// TODO Auto-generated method stub
		WebElement fr = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[2]/div/aside/div/div[2]/div[1]/p"));
		System.out.println(fr.getText());

	}
	public void clicResultById(int result) {
		
		List <WebElement> list = driver.findElements(By.xpath(resultsClass));
		list.get(result).click();
		
 	}
	public void printTitle() {
		System.out.println(driver.getTitle());
	}
	public void printResults() {
		List <WebElement> list = driver.findElements(By.xpath(resultsClass));
		for (WebElement element : list) {
			System.out.println(element.getText());
		}
	}
	public void printResults2() {
		List <WebElement> list = driver.findElements(By.xpath(parraf));
		//for (WebElement element : list) {
			//System.out.println(element.getText());
		//}
		
		for (int i = 3; i > 0; i--) {
			System.out.println(list.get(i).getText());
		}
		
		
	}
	
	public void bucarAMZL() {
		WebElement fr =driver.findElement(By.xpath(searchBarAmzl));
		fr.sendKeys("celulares");
		fr.sendKeys(Keys.ENTER);
	}
	
	public void searchLowPrice() {
		List <WebElement> list = driver.findElements(By.className("a-price-whole"));
		List <WebElement> listName = driver.findElements(By.className("a-size-base-plus"));
		//class="a-size-base-plus a-color-base a-text-normal"
		int n = 0, menor = 0, menorposision = 0;
		
		menor = Integer.parseInt(list.get(0).getText().replace(",", ""));

		
		for (int i = 1; i < list.size()-1; i++) {
			System.out.print(list.get(i).getText().replace(",", ""));
			System.out.println(" "+listName.get(i).getText());
			n = Integer.parseInt(list.get(i).getText().replace(",", ""));
			if (menor > n) {
				menor = n;
				menorposision = i;
			}
		}
		System.out.println("Es el menor: "+menor+listName.get(menorposision).getText());
	}
	
	public void clickFirstresultAMZL() {
		// TODO Auto-generated method stub
		WebElement fr =driver.findElement(By.xpath(amzl));
		fr.click();

	}
	
	public void clickCheckBox() {
		WebElement fr =driver.findElement(By.xpath("//*[@id=\"p_89/SAMSUNG\"]/span/a/div/label/i"));
		fr.click();
		}
	public void comboBoxForIndice(Integer n) {
		WebElement comboBox = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		List <WebElement> list = comboBox.findElements(By.tagName("option"));
		
		for (int i = 0; i < list.size(); i++) {
			if (n.equals(i)) {
				list.get(i).click();
				break;
			}
		}
	}
	public void comboBoxForName(String name) {
		WebElement comboBox = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		List <WebElement> list = comboBox.findElements(By.tagName("option"));
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(name)) {
				list.get(i).click();
				break;
			}
		}
		
	}
}
