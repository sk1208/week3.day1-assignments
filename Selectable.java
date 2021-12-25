package assaignments.week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/selectable");
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement car = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement bus = driver.findElement(By.xpath("//li[text()='Item 5']"));
		Actions builder=new Actions(driver);
		builder.click().dragAndDrop(car, bus).perform();

	}

}
