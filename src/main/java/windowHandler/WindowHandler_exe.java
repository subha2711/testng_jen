package windowHandler;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandler_exe {

	WebDriver driver;

	@Test
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void launchBrowser() {

		By searchField = By.xpath("//input[@id='ybar-sbq']");
		WebElement searchElement = driver.findElement(searchField);
		searchElement.sendKeys("xpath" + Keys.ENTER);

		String handle = driver.getWindowHandle();

		By xpathField = By.xpath("//a[contains(text(),'XPath Tutorial - W3Schools')]");
		WebElement xpathElement = driver.findElement(xpathField);
		xpathElement.click();

		Set<String> handles = driver.getWindowHandles();

		for (String item : handles) {
			driver.switchTo().window(item);
		}
		driver.findElement(By.xpath("//a[contains(text(),'CSS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CSS Syntax')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Next ❯' )]/parent::div[1]/a[2]")).click();

		driver.switchTo().window(handle);
	}

}
