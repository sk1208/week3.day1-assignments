package assaignments.week4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsLeafTap {

	private static Alert alert;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.leafground.com/pages/Alert.html");
		 
	    driver.findElement(By.xpath("//button[@onclick='normalAlert()']")).click();
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    
		driver.findElement(By.xpath("//button[@onclick='confirmAlert()']")).click();
		Thread.sleep(3000);
		alert.dismiss();
		
		
		driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']")).click();
		Thread.sleep(3000);
		alert.sendKeys("sathishkumar N");
		alert.accept();
		
		driver.findElement(By.xpath("//button[@onclick='lineBreaks()']")).click();
		alert.accept();
		
		 
		driver.findElement(By.xpath("//button[@onclick='sweetalert()']")).click();
		driver.quit();
		
		
		

	}

}
