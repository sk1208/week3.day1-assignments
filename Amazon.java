package assaignments.week4;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//open url
		driver.get("https://www.amazon.in/");
		//window maximize
	    driver.manage().window().maximize();
	    //timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//seach on oneplus 
		Actions builder=new Actions(driver);
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 9 pro");
		 driver.findElement(By.id("nav-search-submit-button")).click();
		 Thread.sleep(3000);
		//get the price 
		 WebElement bus = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		 builder.moveToElement(bus).click().perform();
		String cash = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[5]/following-sibling::span")).getText();
		System.out.println("price:"+cash);
		//print the number of ratings 
		String rating = driver.findElement(By.xpath("(//a[@id='acrCustomerReviewLink'])[1]/span")).getText();
		System.out.println(rating);
		//mouse over to rating
		WebElement mouse = driver.findElement(By.xpath("((//span[@class='a-icon-alt'])/parent::i)[1]"));
		builder.moveToElement(mouse).perform();
		//get the percentage of ratings for the 5star.
		String s1 = driver.findElement(By.xpath("(//a[@aria-disabled='true'])[3]")).getText();
		System.out.println(s1);
		//click the first text link of the first image.
		WebElement sel = driver.findElement(By.xpath("a-size-large product-title-word-break"));
		builder.click().perform();
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();		//Take a screen shot of the product displayed
		Set<String> windows = driver.getWindowHandles();
		List<String>system= new ArrayList<String>(windows);
		driver.switchTo().window(system.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);//method used to take Screenshot
	    File target = new File("./report/img.png");	//set the storage path
	    FileUtils.copyFile(screenshotAs, target);//link the source and target files
	    System.out.println("CLICKED SNAPSHOT");
		//click add to cart button
	    WebElement cart = driver.findElement(By.id("add-to-cart-button"));
	    builder.moveToElement(cart).click().perform();
		//get the cart subtotal and verify if it is correct
	    String calc = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
	    System.out.println("cart subtotal:"+calc);
	    if(cash==calc) {
	    	System.out.println("cart total is correct");
	    }
	    else {
	    	System.out.println("cart total is in-correct");
	    }
		//close the windows
		driver.close();
		
		

	}

}
