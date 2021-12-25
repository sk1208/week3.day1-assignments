package assaignments.week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//open url
		driver.get("https://www.myntra.com/");
		//window maximize
	    driver.manage().window().maximize();
	    //timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//to mouse over on men
		Actions builder=new Actions(driver);
		WebElement Men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		builder.moveToElement(Men).perform();
		Thread.sleep(2000);
		//click jackets
		WebElement Jackets = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		builder.moveToElement(Jackets).click().perform();
		//find the total count of item
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total count :"+count);
		//validate the sum of categories
		String catagories = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println("sum ofcatagories:"+catagories );
		String catagorie = driver.findElement(By.xpath("//label[text()='Rain Jacket']/span")).getText();
		System.out.println("sum of categorie:"+catagorie);
		String sum=catagories+catagorie;
		System.out.println(sum);
		if(count==sum) {
			System.out.println("equals");
		}else {
			System.out.println("not equals");
		}
	    //check jackets
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
	    //click+Moe option under Brand
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//span[@class='FilterDirectory-count']/following::div)[1]")).click();
		//close the pop-up x
		driver.findElement(By.xpath("(//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove'])")).click();
		//confirm all the coats are of brand duke
		//List<WebElement> findElement = driver.findElement(By.xpath("(//picture[@class='img-responsive'])[1]/img"));
        //sort by 
		 WebElement sorting = driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"));
		 builder.moveToElement(sorting).click();
		 WebElement cash = driver.findElement(By.xpath("//label[text()='Better Discount']"));
		 builder.moveToElement(cash).click().perform();
		 String text = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		 System.out.println(text);
		 builder.click().perform();
		 WebElement sele = driver.findElement(By.xpath("(//div[@ class='product-productMetaInfo'])[1]"));
		 File screenshotAs = sele.getScreenshotAs(OutputType.FILE);
		 File target= new File ("./report/img.png");
		 FileUtils.copyFile(screenshotAs, target);
		 System.out.println("snaped");
		 //WebElement wish = driver.findElement(By.xpath("//span[text()='WISHLIST']"));
		 //builder.moveToElement(wish).click().perform();
		 driver.quit();
		 
		 
		 
	}

}
