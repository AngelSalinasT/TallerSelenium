package Scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;

public class Sesion4 {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https:/www.google.com");
		GooglePage gp = new GooglePage(driver);
		Thread.sleep(1000);
	
		//busqueda en google
		gp.typeOnSearchBar("Automation Testing Practice");
		gp.clickFirstresult("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3");
		Thread.sleep(1000);
		gp.clickFirstresult("//*[@id='country']/option[2]");
		Thread.sleep(1000);
		gp.comboBoxForIndice(5);
		Thread.sleep(1000);
		gp.comboBoxForName("japan");
	}
	
	//funcion que imprima el primer texto en la pagina de wiki
	//sobre nintendo wikipedia  es getText
	//
	//
	@After
	public void teardown() {
		
		//driver.quit();
	}
}
