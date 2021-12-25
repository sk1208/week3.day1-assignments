package assaignments.week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leafground.com/pages/frame.html");
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		 WebElement screen = driver.findElement(By.xpath("(//button[text()='Click Me'])[1]"));
		 File screenshotAs = screen.getScreenshotAs(OutputType.FILE);
		 File target= new File ("./report/img.png");
		 FileUtils.copyFile(screenshotAs, target);
		 System.out.println("snaped");
		 driver.close();
		 

	}

}
